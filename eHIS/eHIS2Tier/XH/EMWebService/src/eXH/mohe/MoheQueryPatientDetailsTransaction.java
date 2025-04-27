package eXH.mohe;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;

import eXH.util.ConnectionManager;
import eXH.util.EMDataSource;
import eXH.util.XHJSONBuild;
import eXH.util.XHJSONUtil;
import eXH.util.XHUtil;

@SuppressWarnings("rawtypes")
public class MoheQueryPatientDetailsTransaction {
	
	
	public static String l_debug_YN = "N";

	public String l_errcd = "S", l_field_separator = "$!^";
	public String l_errmsg = "";
	public String l_ack_text = "";
	public String l_update_response_str = "";
	public String l_eventType = "OA28";
	
	public static String l_conn_msg = "Error - Unable to connect to the Data base, Kindly contact the System Administrator";

	
	public String processRequest(String actionKey) {
		String l_app_msg = "";
		String l_response_err_json = "", l_facility_id = "", l_actionKey = "";
		String l_in_JSON = "", l_err_msg = "", l_response_str = "", l_message_id = "", l_application_id = "", l_protocol_link_id = "";
		String l_status = "", l_status_desc = "";
		
		String l_first_name = "", l_second_name = "", l_surname = "", l_contact_no = "", l_patient_id = "";

		List<Map<String,String>> fetchedPatientDets = new ArrayList<Map<String,String>>();
		List<Map<String,String>> fetchedPatientFinDets = new ArrayList<Map<String,String>>();
		ArrayList l_external_app_details = null;
		Map<String, String> params = new LinkedHashMap<String, String>();
		Map<String, Object> l_response_json = new HashMap<String, Object>();
		ObjectMapper objMapper = new ObjectMapper();

		String l_request_ref_no = "", l_request_code = "", l_request_type = "", l_responseJsonString = "";
		String json_output = "" , l_national_id = "";
		String l_mobile_no = "";
		
		
		CallableStatement cstmt =null;
		
		String p_response="", errorCode = "", errorMsg = "";
		
		
		try
		{
			Connection con	= null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;
	
			l_debug_YN = XHUtil.l_debug_YN;
	
			l_app_msg = " ::: Inside Mohe Query Patient Details :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
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

				return "200#" + l_response_err_json + "#";

			}
			
			l_app_msg = " ::: Getting Request Ref Number from JSON :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
	
			l_request_ref_no = XHJSONUtil.getJsonRequestString(l_in_JSON, "request_ref_no");
			if (l_request_ref_no.indexOf("Error") >= 0) {
				l_errcd = "E";
				l_err_msg = "request_ref_no not available in request parameter -"+l_request_ref_no;
				l_response_err_json = " { " + " \"status\" : \"0\" , " + " \"message\" : \" " + l_err_msg + " \"  "+ " } ";				

				return "200#" + l_response_err_json + "#";
			}
			
			l_app_msg = " ::: Request Ref Number : " + l_request_ref_no;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
	
			l_app_msg = " ::: Getting Request Type from JSON :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
	
			l_request_type = XHJSONUtil.getJsonRequestString(l_in_JSON, "request_type");
			if (l_request_type.indexOf("Error") >= 0) {
				l_errcd = "E";
				l_err_msg = "request_type not available in request parameter -"+l_request_type;
				l_response_err_json = " { " + " \"status\" : \"0\" , " + " \"message\" : \" " + l_err_msg + " \"  "+ " } ";				

				return "200#" + l_response_err_json + "#";
			}
			l_app_msg = " ::: Request Type : " + l_request_type;
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
				
				return "200#" + l_response_err_json + "#";
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
			
			if (l_errcd.equals("S"))
			{
				l_response_str =new MoheInboundTransaction().MessageLoadMethod(actionKey, params, l_errcd, "");
				l_app_msg = l_app_msg +" : " + l_response_str;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				
			}
	
			l_app_msg = " ::: Getting Patient ID from JSON :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
	
			l_patient_id = XHJSONUtil.getJsonRequestString(l_in_JSON,"patient_id");
			if (l_debug_YN.equals("Y")) System.out.println(" ::: Patient ID ::: "+l_patient_id);
			if (l_patient_id.length()<0) {
				l_patient_id = "";							
			}
			
			l_app_msg = " ::: Getting National ID from JSON :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_national_id = XHJSONUtil.getJsonRequestString(l_in_JSON,"national_id");
			if (l_debug_YN.equals("Y")) System.out.println(" ::: National ID ::: "+l_national_id);
			if (l_national_id.length()<0) {
				l_national_id = "";							
			}
			
			l_app_msg = " ::: Getting Mobile Number from JSON :::";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
	
			l_mobile_no = XHJSONUtil.getJsonRequestString(l_in_JSON,"mobile_no");
			if (l_debug_YN.equals("Y")) System.out.println(" ::: Mobile Number ::: "+l_mobile_no);
			if (l_mobile_no.length()<0) {
				l_mobile_no = "";						
			}
	
			
			try {
				con =  EMDataSource.getConnection();
				if (l_debug_YN.equals("Y")) System.out.println("Connection created..............");
				
				/*cstmt = con.prepareCall("{? = call XH_GET_PATIENT_DETAILS(?,?)}");
				if (l_debug_YN.equals("Y")) System.out.println("CallableStatement created..............");
				
				cstmt.registerOutParameter(1, java.sql.Types.CLOB);
				cstmt.setString(2, l_request_code);
				cstmt.setString(3, l_request_ref_no);
				
				if (l_debug_YN.equals("Y")) System.out.println("registerOutParameter created..............");
				cstmt.executeUpdate();
				
				if (l_debug_YN.equals("Y")) System.out.println("execute created..............");
				
				json_output = cstmt.getString(1);
				
				if (l_debug_YN.equals("Y")) System.out.println("val is "+ json_output);*/
				
				//String Query = "";
				
				cstmt = con.prepareCall ("{ CALL XHMOHE.GET_PATIENT_DETAILS(?,?,?,?,?,?,?) }");
				cstmt.setString(1, l_patient_id);
				cstmt.setString(2, l_national_id);
				cstmt.setString(3, l_mobile_no);
				cstmt.setString(4, l_request_ref_no);
				cstmt.registerOutParameter(5, java.sql.Types.CLOB);
				cstmt.registerOutParameter(6, java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(7, java.sql.Types.VARCHAR);
				
				cstmt.executeUpdate();
				
				//if (l_debug_YN.equals("Y")) System.out.println("execute created..............");
				
				p_response = cstmt.getString(5);
				errorCode = cstmt.getString(6);
				errorMsg = cstmt.getString(7);
				System.out.println("p_response : "+p_response+" : errorCode : "+errorCode);
				
				//if (l_debug_YN.equals("Y")) System.out.println("val is "+ p_response);
				
				if((errorMsg != null) && (errorMsg.trim().length()>0)) 
				{
					json_output=errorMsg;	
				}
				else
				{
					if(errorCode=="S" || "S".equalsIgnoreCase(errorCode))
					{
						json_output=p_response;
					}
					else
					{
						json_output=p_response;
					}
				}
					     
			}
			catch(SQLException e)
			{
				//e.getMessage();
				//if (l_debug_YN.equals("Y")) System.out.println("::: Exception in GET_PATIENT_DETAILS ::: "+ e.getMessage());
				e.printStackTrace();
			}
			finally {
				cstmt.close();  
			    XHUtil.closeDBResources(rs, pstmt, null);
				EMDataSource.returnConnection(con);
			}
						
				
		}catch(Exception e){
			e.printStackTrace();
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^ Exception Occurred " + e.getMessage();
		}

		return "200#"+json_output+"#";
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
