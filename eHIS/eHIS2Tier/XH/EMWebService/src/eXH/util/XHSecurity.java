package eXH.util;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.StringTokenizer;

import org.json.simple.JSONObject;

public class XHSecurity {
	
	public static String application_id = "";
	public static String segment_id = "";
	public static String standard_code = "";
	public String l_app_msg = "";
	public static final String l_field_separator = "&";
	public static String delims = "^!^";

	public static String l_debug_YN = "N";
	public static String added_by_id ="INTERFACE";
	public static String added_at_ws_no ="INTERFACE";
	
	static JSONObject jsonObjString = new JSONObject();
	static JSONObject jsonObjMain = new JSONObject();
	
	public XHSecurity(String debugYN, String segmentId, String standardCode, String applicationId) {
		l_debug_YN = debugYN;
		segment_id = segmentId;
		standard_code = standardCode;
		application_id = applicationId;
	}
	
	public String SecurityValidation(String protocolLinkID, Connection dbConn){
		//Connection dbConn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;

		String validate_token_query = "";
		String l_app_msg = "", l_element_id = "";

		String l_set_token = "N", l_validate_token = "N", l_validate_until = "N", l_request_token = "N";

		String l_vendor_id = "", l_token_id = "";
		String l_response_msg = "", l_return_resp = "",  l_request_token_msg = "", l_validate_token_msg = "";
		
		String l_request_token_resp = "", l_validate_token_resp = "";
		String l_data_obj = "", l_expire = "";
		
		StringTokenizer st = null;
		ArrayList<String> tokenD = null;
		String l_errcd = "S";
		
		String l_resp_status = "E", l_resp_msg = " ";
		boolean validToken = false;

		l_app_msg = " ::: Inside SecurityValidation Method ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);		

		try
		{			
			l_app_msg = "Retrieving Set Token Flag...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_element_id = "SET_TOKEN";

			l_set_token = FetchStdCntrlSegMethod(segment_id, l_element_id, standard_code, dbConn);
			l_app_msg = " ::: Set Token Flag : "+l_set_token;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			if (l_set_token.indexOf("Error")>=0)
			{
				l_set_token = "N";
			}
			
			if (l_set_token.equalsIgnoreCase("Y"))
			{				
				l_app_msg = "Retrieving Vendor Id...";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				l_element_id = "VENDOR_ID";

				l_vendor_id = FetchStdCntrlSegMethod(segment_id, l_element_id, standard_code, dbConn);
				l_app_msg = " ::: Vendor Id : "+l_vendor_id;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
				if (l_vendor_id.indexOf("Error")>=0)
				{
					l_vendor_id = "";				
					l_resp_msg = "App Id has not be conifgured for this Integration, Kinldy contact System Administrator";
					l_errcd = "E";
				}
				
				l_app_msg = "Retrieving Validate Until Token Flag...";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
				
				l_element_id = "VALIDATE_UNTIL_TOKEN";

				l_validate_until = FetchStdCntrlSegMethod(segment_id, l_element_id, standard_code, dbConn);
				l_app_msg = " ::: Validate Until Token : "+l_validate_until;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
				if (l_validate_until.indexOf("Error")>=0)
				{
					l_validate_until = "N";
				}
				
				l_app_msg = " ::: Vendor Id : "+l_vendor_id+" ::: Application Id : "+application_id;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
				
				if (l_vendor_id.length()>0 && application_id.length()>0)
				{
				
					validate_token_query = "select nvl(nvl(token_id,secret_key),'') token_id from xh_appl_vendor_token " +
							" where application_id = ? " +
							" and vendor_id = ? ";
							
							if (l_validate_until.equalsIgnoreCase("Y"))
								validate_token_query = validate_token_query + " and  valid_until_date > sysdate";
							
					pstmt = dbConn.prepareStatement(validate_token_query);
					pstmt.setString(1, application_id);
					pstmt.setString(2, l_vendor_id);
	                rs = pstmt.executeQuery();	            
	                
		            while (rs.next()) {
		            	l_token_id = rs.getString("TOKEN_ID");		            	
		            }	
		            
		            l_app_msg = "Retrieving Token Query..."+validate_token_query+ " \n Existing Token Id : "+l_token_id;
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
					
		            
		            l_app_msg = "Retrieving Validate Token Flag...";
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
					
					l_element_id = "VALIDATE_TOKEN";
	
					l_validate_token = FetchStdCntrlSegMethod(segment_id, l_element_id, standard_code, dbConn);
					l_app_msg = " ::: Validate Token Flag : "+l_validate_token;
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
					if (l_validate_token.indexOf("Error")>=0)
					{
						l_validate_token = "N";
					}
					
					if ((l_token_id.length()>0) && (l_validate_token.equalsIgnoreCase("Y")))
					{
						l_validate_token_resp = ValidateToken(protocolLinkID, l_token_id, dbConn);
						
						l_app_msg = " ::: Validate token Response : "+l_validate_token_resp;
						if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
						
						l_validate_token_resp = l_validate_token_resp.replace("$!^", delims);
	
						st = new StringTokenizer(l_validate_token_resp, delims);
	
						tokenD = new ArrayList<String>();
	
						while (st.hasMoreElements()) {
							tokenD.add(st.nextToken());
						}
	
						if (tokenD.size() > 0) {
							l_errcd = tokenD.get(0);
							l_validate_token_msg = tokenD.get(2);
						}	
						
						if (l_errcd.equalsIgnoreCase("S"))
						{						
							l_resp_status = XHJSONUtil.getJsonRequestString(l_validate_token_msg, "status");
							l_resp_msg = XHJSONUtil.getJsonRequestString(l_validate_token_msg, "message");
							validToken = XHJSONUtil.getJsonRequestString(l_validate_token_msg, "data", "boolean");
							
							if (validToken){
								l_return_resp = "S" +"$!^"+ l_set_token +"$!^"+ l_validate_until +"$!^"+ l_validate_token +"$!^"+ l_token_id +"$!^" + l_resp_msg;
								return l_return_resp; 
							}						
						}					
					}
				}
				
				if (!(validToken) || !(l_token_id.length()>0))
				{				
					l_app_msg = "Retrieving Request For Token...";
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
	
					l_element_id = "REQUEST_FOR_TOKEN";
	
					l_request_token = FetchStdCntrlSegMethod(segment_id, l_element_id, standard_code, dbConn);
					l_app_msg = " ::: Request For Token : "+l_request_token;
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
					if (l_request_token.indexOf("Error")>=0)
					{
						l_request_token = "N";
					}
					
					if (l_request_token.equalsIgnoreCase("Y"))
					{
						l_request_token_resp = RequestForToken(protocolLinkID, dbConn);
						
						l_app_msg = " ::: Request token Response : "+l_request_token_resp;
						if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
						
						l_request_token_resp = l_request_token_resp.replace("$!^", delims);

						st = new StringTokenizer(l_request_token_resp, delims);

						tokenD = new ArrayList<String>();

						while (st.hasMoreElements()) {
							tokenD.add(st.nextToken());
						}

						if (tokenD.size() > 0) {
							l_errcd = tokenD.get(0);
							l_request_token_msg = tokenD.get(2);
						}	
						
						if (l_errcd.equalsIgnoreCase("S"))
						{						
							l_resp_status = XHJSONUtil.getJsonRequestString(l_request_token_msg, "status");
							l_resp_msg = XHJSONUtil.getJsonRequestString(l_request_token_msg, "message");
							l_data_obj = XHJSONUtil.getJsonRequestString(l_request_token_msg, "data");
							
							l_app_msg = " ::: Response token message : "+l_request_token_msg;
							if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
							
							if (l_resp_status.equalsIgnoreCase("1"))
							{							
								l_token_id = XHJSONUtil.getJsonRequestString(l_data_obj, "token");
								l_expire = XHJSONUtil.getJsonRequestString(l_data_obj, "expire");								
								UpdateToken(l_token_id, l_expire, dbConn);
								l_return_resp = "S" +"$!^"+ l_set_token +"$!^"+ l_validate_until +"$!^"+ l_validate_token +"$!^"+ l_token_id +"$!^" + l_resp_msg;
								return l_return_resp; 
							}						
						}						
					}					
				}
			}
			
			if (!l_resp_status.equalsIgnoreCase("1"))			
				l_return_resp = "E" +"$!^"+ l_set_token +"$!^"+ l_validate_until +"$!^"+ l_validate_token +"$!^"+ " " +"$!^" + l_resp_msg;
			
			if (l_set_token.equalsIgnoreCase("N"))
				l_return_resp = "S" +"$!^"+ l_set_token +"$!^"+ l_validate_until +"$!^"+ l_validate_token +"$!^"+ " " +"$!^" + l_resp_msg;
			
			
		}		
		catch(Exception e)
		{
			e.printStackTrace();
			l_response_msg = "E" +"$!^"+ l_set_token +"$!^"+ l_validate_until +"$!^"+ l_validate_token +"$!^"+ l_token_id +"$!^" + "Error while "+ l_app_msg + " : " +  e.getMessage();
			System.out.println(" ::: Exception ::: " +l_response_msg);
			return l_response_msg;
		}
		finally {
			XHUtil.closeDBResources(rs, pstmt, null);
			//EMDataSource.returnConnection(dbConn);
		}
		l_app_msg = " ::: SecurityValidation Response : "+l_return_resp;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		return l_return_resp;
	}

	public String RequestForToken(String protocolLinkID, Connection dbConn){
		//Connection dbConn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;

		String l_app_msg = "", l_element_id = "";

		String l_vendor_id = "", l_vendor_secret_id = "", l_token_id = "";
		String l_response_str = "", l_response_msg = "", l_return_resp = "", l_error_msg = "", l_status = "";
		String l_eventType = "REQUESTTOKEN";
		
		String l_action_type = "P", l_request_msg = "";
		
		StringTokenizer st = null;
		ArrayList<String> tokenD = null;
		String l_errcd = "S", l_status_desc = "";

		l_app_msg = " ::: Inside RequestForToken Method ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);		

		try
		{
			l_status = "S";
			
			l_app_msg = "Retrieving Vendor Id...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_element_id = "VENDOR_ID";

			l_vendor_id = FetchStdCntrlSegMethod(segment_id, l_element_id, standard_code, dbConn);
			l_app_msg = " ::: Vendor Id : "+l_vendor_id;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			if (l_vendor_id.indexOf("Error")>=0)
			{
				l_vendor_id = "";				
				l_error_msg = "App Id";
				l_status = "E";
			}
			
			l_app_msg = "Retrieving Vendor Secret Id...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_element_id = "VENDOR_SECRET_ID";

			l_vendor_secret_id = FetchStdCntrlSegMethod(segment_id, l_element_id, standard_code, dbConn);
			l_app_msg = " ::: Vendor Secret id : "+l_vendor_secret_id;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			if (l_vendor_secret_id.indexOf("Error")>=0)
			{
				l_vendor_secret_id = "";
				if (l_error_msg.length()>0) 
					l_error_msg = l_error_msg + ", ";
				
				l_error_msg = l_error_msg + "App Secret Id ";
				l_status = "E";
			}
			
			l_app_msg = "Status... "+l_status;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			
			if (l_status.equalsIgnoreCase("E"))
			{
				l_response_msg = " Unable to proceed with the token request - "+ l_error_msg + " not configured";
				return l_return_resp = l_status +"$!^"+ l_response_msg +"$!^"+ l_token_id;
			}			
			
			JSONObject reqTokenObj = new JSONObject();
			
			reqTokenObj.put("app_id", l_vendor_id);
			reqTokenObj.put("app_secret", l_vendor_secret_id);
			
			l_request_msg = reqTokenObj.toString();
			
			l_response_str = TransCommunicationMethod(protocolLinkID, l_eventType, l_request_msg, l_action_type, dbConn);
			
			l_response_str = l_response_str.replace("$!^", "^!^");

			st = new StringTokenizer(l_response_str, delims);
			
			l_app_msg = " ::: Return request Token Response Before Processing 2 : "+l_response_str;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			tokenD = new ArrayList<String>();

			while (st.hasMoreElements()) {
				tokenD.add(st.nextToken());
			}

			if (tokenD.size() > 0) {
				l_errcd = tokenD.get(0);
				l_status_desc = tokenD.get(1);
				l_response_str = tokenD.get(2);
			}			
			
			l_return_resp = l_errcd +"$!^"+ l_status_desc +"$!^"+ l_response_str;
			
		}		
		catch(Exception e)
		{
			e.printStackTrace();
			l_response_msg = "E" +"$!^"+"Error while "+ l_app_msg + " : " +  e.getMessage()+"$!^"+l_return_resp;
			System.out.println(" ::: Exception ::: " +l_response_msg);
			return l_response_msg;
		}
		finally {
			XHUtil.closeDBResources(rs, pstmt, null);
			//EMDataSource.returnConnection(dbConn);
		}
		l_app_msg = " ::: Return Request Token Response : "+l_return_resp;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		return l_return_resp;
	}
	
	public String ValidateToken(String protocolLinkID, String tokenId, Connection dbConn){
		//Connection dbConn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;

		String l_app_msg = "";

		String l_response_str = "", l_response_msg = "", l_return_resp = "", l_token_resp = " ";
		String l_eventType = "VALIDATETOKEN";
		
		String l_action_type = "G", l_request_msg = "";
		
		StringTokenizer st = null;
		ArrayList<String> tokenD = null;

		l_app_msg = " ::: Inside ValidateToken Method ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		
		String l_errcd = "S", l_status_desc = "";

		try
		{
			l_app_msg = "Validating Token Id..."+tokenId;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			
			/*
			JSONObject validTokenObj = new JSONObject();			
			validTokenObj.put("token", tokenId);
			*/
			
			l_request_msg = "token="+tokenId;
			
			l_response_str = TransCommunicationMethod(protocolLinkID, l_eventType, l_request_msg, l_action_type, dbConn);
			l_response_str = l_response_str.replace("$!^", "^!^");

			st = new StringTokenizer(l_response_str, delims);

			tokenD = new ArrayList<String>();

			while (st.hasMoreElements()) {
				tokenD.add(st.nextToken());
			}

			if (tokenD.size() > 0) {
				l_errcd = tokenD.get(0);
				l_status_desc = tokenD.get(1);
				l_token_resp = tokenD.get(2);
			}
			
			l_app_msg = "Validate Token Response Message... "+l_token_resp;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);			
	
			l_return_resp = l_errcd +"$!^"+ l_status_desc +"$!^"+ l_token_resp.toString();
			
			l_app_msg = "Validate Token Response..."+l_return_resp;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			
		}		
		catch(Exception e)
		{
			e.printStackTrace();
			l_response_msg = "E" +"$!^"+"Error while "+ l_app_msg + " : " +  e.getMessage()+"$!^"+l_return_resp;
			System.out.println(" ::: Exception ::: " +l_response_msg);
			return l_response_msg;
		}
		finally {
			XHUtil.closeDBResources(rs, pstmt, null);
			//EMDataSource.returnConnection(dbConn);
		}
		return l_return_resp;
	}
	
	public String FetchStdCntrlSegMethod(String segmentID, String elementId,
			String standardCode, Connection dbConn) {

		//Connection dbConn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		String query = "";
		String l_app_msg = "", l_field_value = "";

		l_app_msg = " ::: Inside FetchStdCntrlSegMethod ::: ";
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);

		l_app_msg = " ::: Segment ID : " + segmentID + " ::: Element ID : "
				+ elementId + " ::: Standard Code : " + standardCode;
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);

		l_app_msg = " ::: Retrieving " + elementId + " Value...";
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);

		try {
			//dbConn = EMDataSource.getConnection();
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

		} catch (Exception e) {
			l_field_value = "Error in " + l_app_msg + " : " + e.getMessage();
		} finally {
			XHUtil.closeDBResources(rs, pstmt, null);
			//EMDataSource.returnConnection(dbConn);
		}
		return l_field_value;
	}
	
	public String TransCommunicationMethod(String protocolLinkID, String actionKey, String message, String action_type, Connection dbConn) 
	{
		
		//Connection dbConn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		String query = "";
		String l_app_msg = "", l_element_id = "";

		String l_profile_id = "";
		String l_http_user_agent = "", l_http_content_type = "", l_http_transfer_encoding = "", l_http_soapaction = "",
				l_url = "";
		int l_http_content_length_flag = 0;

		String l_request_url = "";

		String l_proxy_server = "", l_proxy_port = "";

		HttpURLConnection conn = null;

		String l_response_msg = "", l_return_resp = "";

		l_app_msg = " ::: Inside TransCommunicationMethod ::: ";
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);

		l_app_msg = " ::: Protocol Link ID : " + protocolLinkID + " ::: Action Key : " + actionKey + " ::: Message : "
				+ message;
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);

		l_app_msg = " ::: Fetching Communication Standards ::: ";
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);

		try {
			//dbConn = EMDataSource.getConnection();
			query = "SELECT    nvl(profile_id,'') profile_id, nvl(xml_style_sheet_url, '') xml_style_sheet_url, nvl(standard_code,'') standard_code, "
					+ " nvl(http_user_agent,'XXX') http_user_agent, nvl(http_content_type, 'XXX') http_content_type, nvl(http_transfer_encoding, 'XXX') http_transfer_encoding, "
					+ " nvl(http_soapaction,'XXX') http_soapaction, nvl(http_content_length_flag,0)  http_content_length_flag "
					+ " FROM    xh_protocol a, xh_protocol_link b "
					+ " WHERE    a.protocol_id = b.protocol_id AND b.protocol_link_id = ? ";

			pstmt = dbConn.prepareStatement(query);
			pstmt.setString(1, protocolLinkID);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				l_profile_id = rs.getString("PROFILE_ID");
				l_url = rs.getString("XML_STYLE_SHEET_URL");
				standard_code = rs.getString("STANDARD_CODE");
				l_http_user_agent = rs.getString("HTTP_USER_AGENT");
				l_http_content_type = rs.getString("HTTP_CONTENT_TYPE");
				l_http_transfer_encoding = rs.getString("HTTP_TRANSFER_ENCODING");
				l_http_soapaction = rs.getString("HTTP_SOAPACTION");
				l_http_content_length_flag = rs.getInt("HTTP_CONTENT_LENGTH_FLAG");
			}

			l_app_msg = " ::: Profile ID : " + l_profile_id + " ::: API URL : " + l_url + " ::: Standard Code : "
					+ standard_code + " ::: HTTP User Agent : " + l_http_user_agent;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_app_msg = " ::: HTTP Content Type : " + l_http_content_type + " ::: HTTP Transfer Encoding : "
					+ l_http_transfer_encoding + " ::: HTTP Soap Action : " + l_http_soapaction
					+ " ::: HTTP Content Length Flag : " + l_http_content_length_flag;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_app_msg = "Retrieving Request URL...";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_element_id = actionKey;

			l_request_url = FetchStdCntrlSegMethod(segment_id, l_element_id, standard_code, dbConn);
			l_app_msg = " ::: l_request_url : " + l_request_url;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			if (l_request_url.indexOf("Error") >= 0) {
				return l_request_url;
			}

			l_element_id = "PROXY_SERVER";

			l_proxy_server = FetchStdCntrlSegMethod(segment_id, l_element_id, standard_code, dbConn);
			l_app_msg = " ::: l_proxy_server : " + l_proxy_server;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			if (l_proxy_server.indexOf("Error") >= 0) {
				return l_proxy_server;
			}

			l_element_id = "PROXY_PORT";

			l_proxy_port = FetchStdCntrlSegMethod(segment_id, l_element_id, standard_code, dbConn);
			l_app_msg = " ::: l_proxy_port : " + l_proxy_port;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			if (l_proxy_port.indexOf("Error") >= 0) {
				return l_proxy_port;
			}

			l_url = l_url.trim();
			l_request_url = l_request_url.trim();

			l_url = l_url + "/" + l_request_url;

			l_url = l_url.trim();
			
			if (action_type.equalsIgnoreCase("G"))
				l_url = l_url +"?"+ message;				
				
			l_app_msg = " ::: BruHealthApp Url :" + l_url;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			URL url = new URL(l_url);

			if (l_proxy_server.length() > 0 && !l_proxy_server.equals("X")) {
				l_app_msg = " ::: Setting http Proxy...";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				System.setProperty("http.proxyHost", l_proxy_server);
				System.setProperty("https.proxyHost", l_proxy_server);
			}

			if (l_proxy_port.length() > 0 && !l_proxy_server.equals("X")) {
				l_app_msg = " ::: Setting http port...";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				System.setProperty("http.proxyPort", l_proxy_port);
				System.setProperty("https.proxyPort", l_proxy_port);

			}

			l_app_msg = " ::: URL Open Connection...";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			conn = (HttpURLConnection) url.openConnection();

			l_app_msg = " ::: Connection Set Method...";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_app_msg = " ::: Action Type... "+action_type;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			if (!(action_type.length()>0))
				action_type = "I";
			
			if (action_type.equalsIgnoreCase("I"))
				conn.setRequestMethod("POST");
			
			if (action_type.equalsIgnoreCase("U"))
				conn.setRequestMethod("PUT");
			
			if (action_type.equalsIgnoreCase("D"))
				conn.setRequestMethod("PUT");	
			
			if (action_type.equalsIgnoreCase("G"))
				conn.setRequestMethod("GET");	
			
			l_app_msg = " ::: Method Set... "+conn.getRequestMethod();
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			// Common Headers for BruHealth Transactions

			if (!(l_http_content_type.equals("XXX"))) {
				l_app_msg = " ::: Set Property Content-Type...";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				conn.setRequestProperty("Content-Type", l_http_content_type);
			}

			if (!(l_http_user_agent.equals("XXX"))) {
				l_app_msg = " ::: Set Property User-Agent...";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				conn.setRequestProperty("User-Agent", l_http_user_agent);
			}

			if (l_http_content_length_flag > 0) {
				l_app_msg = " ::: Set Property Content-Length...";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				conn.setRequestProperty("Content-Length", Integer.toString(message.length()));
			}

			if (!(l_http_transfer_encoding.equals("XXX"))) {
				l_app_msg = " ::: Set Property Transfer-Encoding...";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				conn.setRequestProperty("Transfer-Encoding", l_http_transfer_encoding);
			}

			if (!(l_http_soapaction.equals("XXX"))) {
				l_app_msg = " ::: Set Property SOAPAction...";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				conn.setRequestProperty("SOAPAction", l_http_soapaction);
			}

			l_app_msg = " ::: conn.setUseCaches(false)...";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			conn.setUseCaches(false);
			
			if (!(action_type.equalsIgnoreCase("G")))
			{
				l_app_msg = " ::: conn.setDoOutput(true)...";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				conn.setDoOutput(true);
	
				l_app_msg = " ::: Writing the request to the OutputStream...";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
	
				OutputStream os = conn.getOutputStream();
				os.write(message.getBytes());
				os.flush();			
			}
			
			l_app_msg = " ::: Reading the response from the OutputStream...";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			InputStream is;
			try {
				is = conn.getInputStream();
			} catch (Exception e) {
				is = conn.getErrorStream();
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((is)));

			l_app_msg = " ::: Output from Server .... \n";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			while ((l_response_msg = br.readLine()) != null) {
				l_return_resp = l_return_resp + l_response_msg;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_return_resp);
			}

			conn.disconnect();			
			
			if (conn.getResponseCode() != 200) {
				l_return_resp = "E" + "$!^" + conn.getResponseMessage() + "$!^" + l_return_resp;
				return l_return_resp;
			}			

		} catch (MalformedURLException e) {
			e.printStackTrace();
			l_return_resp = " ";
			l_response_msg = "E" + "$!^" + "Error while " + l_app_msg + " : " + e.getMessage() + "$!^" + l_return_resp;
			System.out.println(" ::: MalformedURLException ::: " + l_response_msg);
			return l_response_msg;
		} catch (IOException e) {
			e.printStackTrace();
			l_return_resp = " ";
			l_response_msg = "E" + "$!^" + "Error while " + l_app_msg + " : " + e.getMessage() + "$!^" + l_return_resp;
			System.out.println(" ::: IOException ::: " + l_response_msg);
			return l_response_msg;
		} catch (Exception e) {
			e.printStackTrace();
			l_return_resp = " ";
			l_response_msg = "E" + "$!^" + "Error while " + l_app_msg + " : " + e.getMessage() + "$!^" + l_return_resp;
			System.out.println(" ::: Exception ::: " + l_response_msg);
			return l_response_msg;
		} finally {
			XHUtil.closeDBResources(rs, pstmt, null);
			//EMDataSource.returnConnection(dbConn);
		}
		l_return_resp = "S" + "$!^" + " " + "$!^" + l_return_resp;
		l_app_msg = " ::: Trans Communication Response : " + l_return_resp;
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);
		return l_return_resp;
	}
	
	public String UpdateToken(String tokenId, String validUntil, Connection dbConn) {

		//Connection dbConn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		String query = "";
		String l_app_msg = "", l_field_value = "";
		
		String l_element_id = "";
		
		int insertCount = 0;
		
		String l_vendor_id = "", l_vendor_secret_id = "";

		l_app_msg = " ::: Inside UpdateToken Method ::: ";
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);	

		try {
			
			l_app_msg = "Retrieving Vendor Id...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_element_id = "VENDOR_ID";

			l_vendor_id = FetchStdCntrlSegMethod(segment_id, l_element_id, standard_code, dbConn);
			l_app_msg = " ::: Set Token Flag : "+l_vendor_id;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			if (l_vendor_id.indexOf("Error")>=0)
			{
				l_vendor_id = "";
			}
			
			l_app_msg = "Retrieving Vendor Secret Id...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_element_id = "VENDOR_SECRET_ID";

			l_vendor_secret_id = FetchStdCntrlSegMethod(segment_id, l_element_id, standard_code, dbConn);
			l_app_msg = " ::: Set Token Flag : "+l_vendor_secret_id;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			if (l_vendor_secret_id.indexOf("Error")>=0)
			{
				l_vendor_secret_id = "";
			}
			
			l_element_id = "APPL_USER_ID";
			added_by_id = FetchStdCntrlSegMethod(segment_id, l_element_id, standard_code, dbConn);
			l_app_msg = " ::: APPL User Id ::: "+ added_by_id;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_element_id = "BL_WS_NO";
			added_at_ws_no = FetchStdCntrlSegMethod(segment_id, l_element_id, standard_code, dbConn);
			l_app_msg = " ::: Workstation Id ::: "+ added_at_ws_no;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_app_msg = " ::: Application ID : " + application_id + " ::: Vendor ID : "+ l_vendor_id + 
					" ::: Token Id : " + tokenId + " ::: Valid Until : "+validUntil;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);	
			
			
			//dbConn = EMDataSource.getConnection();
			query = "Insert into XH_APPL_VENDOR_TOKEN (APPLICATION_ID, VENDOR_ID, TOKEN_ID, TOKEN_ADDED_DATE, VALID_UNTIL_DATE, SECRET_KEY, " +
					"		ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO) " +
					"		VALUES (?, ?, ?, SYSDATE, SYSDATE + "+validUntil+"/24/60/60, ?," +
					"				?, SYSDATE, ?, ?, SYSDATE, ?)";

			pstmt = dbConn.prepareStatement(query);
			pstmt.setString(1, application_id);
			pstmt.setString(2, l_vendor_id);
			pstmt.setString(3, tokenId);
			pstmt.setString(4, l_vendor_secret_id);
			pstmt.setString(5, added_by_id);
			pstmt.setString(6, added_at_ws_no);
			pstmt.setString(7, added_by_id);
			pstmt.setString(8, added_at_ws_no);
			
			insertCount = pstmt.executeUpdate();
			
			l_app_msg = " ::: Insert count from  XH_APPL_VENDOR_TOKEN ::: "+ insertCount;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);	
			
			if (insertCount>0)
				dbConn.commit();
			else
				dbConn.rollback();			

		} catch (Exception e) {
			l_field_value = "Error in " + l_app_msg + " : " + e.getMessage();
			if (l_debug_YN.equals("Y"))
				System.out.println(l_field_value);	
		} finally {
			XHUtil.closeDBResources(rs, pstmt, null);
			//EMDataSource.returnConnection(dbConn);
		}
		return l_field_value;
	}

}
