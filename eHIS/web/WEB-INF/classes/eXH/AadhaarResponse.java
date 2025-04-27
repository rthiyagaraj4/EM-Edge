/***************************************************************************************************************
 * Author   :   Prithvirajan. R
 * Desc     :	This class is used to invoke the external EGL application
 ***************************************************************************************************************/

package eXH;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import java.io.BufferedReader; 
import java.io.InputStreamReader;
import java.io.OutputStream; 
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.InputStream;
import webbeans.eCommon.ConnectionManager;


/**
 * Servlet implementation class InvokeEGLapplication
 */
    public class AadhaarResponse extends HttpServlet {
	//private static final long serialVersionUID = 1L;

	public static final String l_segment_id = "AAG";
	public static final String l_standard_code = "AADHAARSTD";	

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
		doPost(request, response);
	}
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    { 
		String responseTxt=null;
		String l_call_type = "";	

		try
		{
			Map<String, String> reqParams = XHUtil.getRequestParams(request);
			
		//	String paramString=reqParams.get("paramString");
			l_call_type = reqParams.get("callType");			

			if("KYC".equals(l_call_type)) 
			{
					responseTxt=eKYC(request,reqParams);
					PrintWriter resp = response.getWriter();
					resp.write(responseTxt);
					resp.flush();
					resp.close();
			}

			 }
		  catch(Exception e){
			System.out.println(" Exception in Aadhaar Servlet doPost Method ::: "+e.getMessage());
		  }
	}
    
	private String eKYC(HttpServletRequest request,Map<String, String> reqParams) throws Exception 
	{
		Connection dbConn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;
		String query = "";

		//String responseTxt="";
		//String p_response="", errorCode = "", errorMsg = "";

		//String l_call_type = ""; 
		String l_request_id = "", l_uuid = "", l_hash_data = "", l_status = "",l_transaction_id = "";
		String l_aadhaar_id = "", l_user_id = "", l_facility_id = "",client_ip_addr = "",l_request_date = "";
		//String eKYCUrl = "http://ekyc.mobilewaretech.com:2080/Ekyc-web/api/users/1.0/fetchekyc";
		//String l_field_separator= "$!^";

		String message = "", l_return_resp = "", l_response_msg = "", l_element_id = "";

		String param_string = "",l_return_str="",l_tenantCode="", l_access_token = "", l_ekyc_func_param = "", l_accession_key = "";

		String l_profile_id = "", l_url = "", l_http_standard_code = "", l_http_user_agent = "", l_http_content_type = "", l_http_transfer_encoding = "", l_http_soapaction = "";
		int l_http_content_length_flag  = 0;

		boolean isDebugYN = false; 
		String l_app_msg = "";
		String applicationId= "AADHAAR";
        
		HttpURLConnection conn = null;	
		
		HttpSession session; 
		java.util.Properties p;	

		String l_proxy_server="", l_proxy_port="";

		try
		{			
			l_request_id =  XHDBAdapter.checkNull(reqParams.get("request_id"));
			l_uuid = XHDBAdapter.checkNull(reqParams.get("uuid"));
			l_hash_data = XHDBAdapter.checkNull(reqParams.get("hash_data"));
			l_status = XHDBAdapter.checkNull(reqParams.get("status"));
			l_transaction_id = XHDBAdapter.checkNull(reqParams.get("transaction_id"));
			
			isDebugYN = (XHUtil.singleParamExeQry("SELECT DEBUG_YN FROM XH_PARAM").equals("Y")) ? true : false;

			if (isDebugYN) System.out.println("REQUESTID..."+l_request_id);
			if (isDebugYN) System.out.println("UUID..."+l_uuid);
			if (isDebugYN) System.out.println("HASHDATA..."+l_hash_data);
			if (isDebugYN) System.out.println("STATUS..."+l_status);
			if (isDebugYN) System.out.println("TRANSACTION_ID..."+l_transaction_id);

			session = request.getSession(false);
			p = (java.util.Properties) session.getValue( "jdbc" );
			l_user_id = (p.getProperty("login_user")==null)?"":p.getProperty("login_user");
			l_facility_id = (String) session.getValue("facility_id");

			l_aadhaar_id = XHDBAdapter.checkNull(reqParams.get("aadhaar_id"));			

			if (isDebugYN) System.out.println("Request ID..."+l_request_id+"  ::: User ID..."+l_user_id+"  ::: Facility ID..."+l_facility_id);
	
			long millis = System.currentTimeMillis();
			l_app_msg = " ::: millis ::: "+millis;
			if (isDebugYN) System.out.println(l_app_msg);

			l_element_id = "TENANT_CODE";

			l_tenantCode = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code);
			l_app_msg = " ::: l_tenantCode : "+l_tenantCode;
			//if (isDebugYN) System.out.println(l_app_msg);	

			l_element_id = "KYC_FUNC_PARAM";
			
			l_ekyc_func_param = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code);
			l_app_msg = " ::: l_ekyc_func_param : "+l_ekyc_func_param;
			if (isDebugYN) System.out.println(l_app_msg);	


			l_element_id = "PROXY_SERVER";

			l_proxy_server = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code);
			l_app_msg = " ::: l_proxy_server : "+l_proxy_server;
			if (isDebugYN) System.out.println(l_app_msg);	
			

			l_element_id = "PROXY_PORT";

			l_proxy_port = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code);
			l_app_msg = " ::: l_proxy_port : "+l_proxy_port;
			if (isDebugYN) System.out.println(l_app_msg);	
			

			session = request.getSession(false);
			p = (java.util.Properties) session.getValue( "jdbc" );

			client_ip_addr=	p.getProperty("client_ip_address");
			l_app_msg = " ::: Login Machine IP Address... "+client_ip_addr;
			if(isDebugYN)	System.out.println(l_app_msg);

			l_app_msg = "Getting Formatted l_request_date value...";
			if(isDebugYN) System.out.println(l_app_msg);	

			l_request_date = getFormattedStringDate("dd-MMM-yyyy HH:mm:ss", new java.util.Date());

			l_app_msg = "::: l_request_date : "+l_request_date;
			if(isDebugYN) System.out.println(l_app_msg);	


			//l_facility_id = "KH";
			

			if (l_ekyc_func_param.equals("1"))
			{
				message = "{ "
					  +"  \"tenantCode\": \""+l_tenantCode+"\", "
					  +"  \"requestId\": \""+l_transaction_id+"\","
					  +"  \"hash\": \""+l_hash_data+"\","
					  +"  \"uuid\": \""+l_uuid+"\","
					  +"  \"status\": \""+l_status+"\","
					  +"  \"dt\":\""+millis+"\" "
					  +"}";

				param_string = "<REQUEST_ID>"+l_request_id+"$!^<HASH_DATA>"+l_hash_data+"$!^<UUID>"+l_uuid+"$!^<STATUS>"+l_status+"$!^<DT>"+millis+"$!^<TENANT_CODE>"+l_tenantCode+"$!^<REQUEST_JSON>"+message+"$!^";
				l_accession_key = "<REQUEST_ID>"+l_request_id+"$!^<HASH_DATA>"+l_hash_data+"$!^<UUID>"+l_uuid+"$!^<STATUS>"+l_status+"$!^<DT>"+millis+"$!^<TENANT_CODE>"+l_tenantCode+"$!^<REQUEST_JSON>$!^";
			}
			else if (l_ekyc_func_param.equals("0"))
			{
				message = "{ "
					  +"  \"tenantCode\": \""+l_tenantCode+"\", "
					  +"  \"uid\": \""+l_aadhaar_id+"\","
					  +"  \"emFacilityId\": \""+l_facility_id+"\","
					  +"  \"emUserId\": \""+l_user_id+"\","
					  +"  \"dt\":\""+millis+"\" "
					  +"}";
				param_string = "<FACILITY_ID>"+l_facility_id+"$!^<ADDED_BY_ID>"+l_user_id+"$!^<AADHAAR_NO>"+l_aadhaar_id+"$!^<REQUEST_ID>"+l_request_id+"$!^<HASH_DATA>"+l_hash_data+"$!^<UUID>"+l_uuid+"$!^<STATUS>"+l_status+"$!^<DT>"+millis+"$!^<TENANT_CODE>"+l_tenantCode+"$!^<REQUEST_JSON>"+message+"$!^";
				l_accession_key = "<FACILITY_ID>"+l_facility_id+"$!^<ADDED_BY_ID>"+l_user_id+"$!^<AADHAAR_NO>"+l_aadhaar_id+"$!^<REQUEST_ID>"+l_request_id+"$!^<HASH_DATA>"+l_hash_data+"$!^<UUID>"+l_uuid+"$!^<STATUS>"+l_status+"$!^<DT>"+millis+"$!^<TENANT_CODE>"+l_tenantCode+"$!^<REQUEST_JSON>$!^";

			}				

			l_app_msg = " ::: param_string ::: "+param_string;
			//if (isDebugYN) System.out.println(l_app_msg);

			AadhaarRequest aadhaarReq = new AadhaarRequest();

			//Map<String,String> reqParam = new HashMap<String,String>();
			reqParams.put("LOGIN_USER", l_user_id);
			reqParams.put("CLIENT_MACHINE", client_ip_addr); 
			reqParams.put("PGM_ID", "AADHAAR");
			reqParams.put("MODULE_ID", "XH");
			reqParams.put("SESSION_ID", "REGPAT");

			reqParams.put("MSG_ID", l_request_id);
			reqParams.put("REQUEST_DATE", l_request_date); 
			reqParams.put("REQUEST_TEXT", message); 
			reqParams.put("APPLICATION_ID", applicationId);
			reqParams.put("FACILITY_ID", l_facility_id);
			reqParams.put("MESSAGE_DATE", l_request_date); 
			reqParams.put("EVENT_TYPE", "AAG");
			reqParams.put("PATIENT_ID", "");
			reqParams.put("EPISODE_TYPE", "");
			reqParams.put("ENCOUNTER_ID", "");
			reqParams.put("ACC_NO", l_accession_key);
			reqParams.put("EXT_ACC_NO", "");
			reqParams.put("REQUEST_SYNTAX", "");
			reqParams.put("ACK_MSG_ID", "");
			reqParams.put("PROTOCOL_LINK_ID", "AADHAARPL");
			reqParams.put("ADDED_BY_ID", l_user_id); 
			reqParams.put("ADDED_BY_DATE", l_request_date); 
			reqParams.put("MODIFIED_BY_ID", l_user_id); 
			reqParams.put("MODIFIED_BY_DATE", l_request_date); 
			reqParams.put("ADDED_BY_FACILITY", l_facility_id);
			reqParams.put("MODIFIED_BY_FACILITY", l_facility_id);
			reqParams.put("RESPONSE_TEXT", ""); 
			reqParams.put("RESPONSE_SYNTAX", "");
			reqParams.put("PROFILE", ""); 
			reqParams.put("ERROR_TEXT", ""); 
			reqParams.put("ACK_TEXT", "");
			reqParams.put("ACK_SYNTAX", "");

			l_app_msg = "Inserting Interface Audit data...";
			if (isDebugYN) System.out.println(l_app_msg);	
			
			XHUtil.updateInteractiveDetails(reqParams);

			if (l_ekyc_func_param.equals("1"))
			{
				l_return_str = aadhaarReq.UpdateAadhaarRequest(request, param_string);///inserting into the table
			}
			else if (l_ekyc_func_param.equals("0"))
			{
				l_return_str = aadhaarReq.InsertAadhaarRequest(request, param_string);///inserting into the table
			}
			l_app_msg = " ::: l_return_str ::: "+l_return_str;
			if (isDebugYN) System.out.println(l_app_msg);

			l_app_msg = " ::: message ::: "+message;
			//if (isDebugYN) System.out.println(l_app_msg);
            
			dbConn =  ConnectionManager.getConnection();
			query = "SELECT    nvl(profile_id,'') profile_id, nvl(xml_style_sheet_url, '') xml_style_sheet_url, nvl(standard_code,'') standard_code, "
						+ " nvl(http_user_agent,'XXX') http_user_agent, nvl(http_content_type, 'XXX') http_content_type, nvl(http_transfer_encoding, 'XXX') http_transfer_encoding, "
						+ " nvl(http_soapaction,'XXX') http_soapaction, nvl(http_content_length_flag,0)  http_content_length_flag "
			            + " FROM    xh_protocol a, xh_protocol_link b "
						+ " WHERE    a.protocol_id = b.protocol_id AND b.protocol_link_id = ? ";

			pstmt = dbConn.prepareStatement(query);
			pstmt.setString(1, "AADHAARPL");			
			rs = pstmt.executeQuery();
			while(rs.next())
			{
			   l_profile_id = rs.getString("PROFILE_ID");
			   l_url = rs.getString("XML_STYLE_SHEET_URL");
			   l_http_standard_code = rs.getString("STANDARD_CODE");
			   l_http_user_agent = rs.getString("HTTP_USER_AGENT");
			   l_http_content_type = rs.getString("HTTP_CONTENT_TYPE");
			   l_http_transfer_encoding = rs.getString("HTTP_TRANSFER_ENCODING");
			   l_http_soapaction = rs.getString("HTTP_SOAPACTION");
			   l_http_content_length_flag = rs.getInt("HTTP_CONTENT_LENGTH_FLAG");
			}

			l_app_msg = " ::: HTTP l_url : "+ l_url +" ::: HTTP l_http_standard_code : "+ l_http_standard_code +" ::: HTTP l_http_user_agent : "+ l_http_user_agent +" ::: HTTP Content Type : "+ l_http_content_type + " ::: HTTP Transfer Encoding : " + l_http_transfer_encoding + " ::: HTTP Soap Action : "+ l_http_soapaction + " ::: HTTP Content Length Flag : "+l_http_content_length_flag;
			if (isDebugYN) System.out.println(l_app_msg);

			if (l_url.length() > 0)
			{					
				URL url = new URL(l_url);

				l_app_msg = " ::: URL Open Connection ::: ";
				if (isDebugYN) System.out.println(l_app_msg);

				conn = (HttpURLConnection) url.openConnection();
				
				l_app_msg = " ::: Set Request Method POST ::: ";
				if (isDebugYN) System.out.println(l_app_msg);

				conn.setRequestMethod("POST");								

				if (!(l_http_user_agent.equals("XXX")))
				{
					l_app_msg = " ::: Set Property User-Agent...";
					if (isDebugYN) System.out.println(l_app_msg);	
					conn.setRequestProperty("User-Agent", l_http_user_agent);
				}

				if (!(l_http_content_type.equals("XXX")))
				{
					l_app_msg = " ::: Set Property Content-Type...";
					if (isDebugYN) System.out.println(l_app_msg);	
					conn.setRequestProperty("Content-Type", l_http_content_type);
				}

				if (l_http_content_length_flag>0)
				{
					l_app_msg = " ::: Set Property Content-Length...";
					if (isDebugYN) System.out.println(l_app_msg);	
					conn.setRequestProperty("Content-Length", Integer.toString(message.length()));
				}

				if (!(l_http_transfer_encoding.equals("XXX")))
				{
					l_app_msg = " ::: Set Property Transfer-Encoding...";
					if (isDebugYN) System.out.println(l_app_msg);	
					conn.setRequestProperty("Transfer-Encoding", l_http_transfer_encoding);
				}

				if (!(l_http_soapaction.equals("XXX")))
				{
					l_app_msg = " ::: Set Property SOAPAction...";
					if (isDebugYN) System.out.println(l_app_msg);	
					conn.setRequestProperty("SOAPAction", l_http_soapaction);
				}
				
				l_element_id = "ACCESS_TOKEN_AAG";

				l_access_token = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code);
				l_app_msg = " ::: l_access_token : "+l_access_token;
				if (isDebugYN) System.out.println(l_app_msg);				

				l_app_msg = " ::: Set Content Header : Access Token ::: ";
				if (isDebugYN) System.out.println(l_app_msg);

				conn.setRequestProperty("Access-Token", l_access_token);
				
				if (!(l_http_content_type.equals("XXX")))
				{
					l_app_msg = " ::: Set Property Accept...";
					if (isDebugYN) System.out.println(l_app_msg);	
					conn.setRequestProperty("Accept", l_http_content_type);
				}

				if (l_proxy_server.length()>0 && !l_proxy_server.equals("X"))
				{
					l_app_msg = " ::: Setting http Proxy...";
					if (isDebugYN) System.out.println(l_app_msg);

					System.setProperty("http.proxyHost", l_proxy_server);
					System.setProperty("https.proxyHost", l_proxy_server);
				}

				if (l_proxy_port.length()>0  && !l_proxy_server.equals("X"))
				{
					l_app_msg = " ::: Setting http port...";
					if (isDebugYN) System.out.println(l_app_msg);

					System.setProperty("http.proxyPort", l_proxy_port);       
					System.setProperty("https.proxyPort", l_proxy_port);

				}

				
				//conn.setRequestProperty("Accept", "Application/json");
				l_app_msg = " ::: Set setUseCaches(false) ::: ";
				if (isDebugYN) System.out.println(l_app_msg);

				conn.setUseCaches(false);
				
				l_app_msg = " ::: Set setDoOutput(true) ::: ";
				if (isDebugYN) System.out.println(l_app_msg);
				
				conn.setDoOutput(true);
				
				l_app_msg = " ::: Writing the request to the OutputStream...";
				if (isDebugYN) System.out.println(l_app_msg);

				OutputStream os = conn.getOutputStream();
				os.write(message.getBytes());
				os.flush();

				l_app_msg = " ::: Reading the response from the OutputStream...";
				if (isDebugYN) System.out.println(l_app_msg);
				
				InputStream is;
				try{
					is = conn.getInputStream();
				}catch(Exception e){
					is = conn.getErrorStream();
				}

				BufferedReader br = new BufferedReader(new InputStreamReader((is)));

				l_app_msg = " ::: Output from Server .... \n";
				if (isDebugYN) System.out.println(l_app_msg);

				while ((l_response_msg = br.readLine()) != null) {
					l_return_resp = l_return_resp + l_response_msg;
					//System.out.println(l_return_resp);
				}
				if(l_return_resp !=null)
				{
				//AadhaarRequest aadhaarReq = new AadhaarRequest();
				param_string = "<REQUEST_ID>"+l_request_id+"$!^<RESPONSE_JSON>"+l_return_resp+"$!^";
				//l_param_string = "<RESPONSE_JSON>"+responseMsg+"$!^";

				l_return_str = aadhaarReq.UpdateAadhaarResponse(request, param_string);///inserting into the table
		
				

				}
				
				conn.disconnect();
			}
			
		}
		catch (MalformedURLException e) 
		{
			System.out.println("Error in Malformed URL : " +  l_app_msg + " ::: "+ e.getMessage());
		} 
		catch (IOException e) 
		{
			System.out.println("Error in IO Exception : " +  l_app_msg + " ::: "+ e.getMessage());
		}
		catch(Exception e)
		{
			System.out.println("Error in Exception : " +  l_app_msg + " ::: "+ e.getMessage());
		}	
		finally
		{			
			XHUtil.closeDBResources(rs, pstmt, dbConn);
		}
		
		//return l_return_resp;
		return l_return_str;

	}

	public String FetchStdCntrlSegMethod(String segmentID, String elementId, String standardCode){

		Connection dbConn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;

		String query = "";
		String l_field_value = "";

		boolean isDebugYN = false; 
		String l_app_msg = "";
		isDebugYN = (XHUtil.singleParamExeQry("SELECT DEBUG_YN FROM XH_PARAM").equals("Y")) ? true : false;

		l_app_msg = " ::: Inside FetchStdCntrlSegMethod ::: ";
		if (isDebugYN) System.out.println(l_app_msg);	

		l_app_msg = " ::: Segment ID : "+ segmentID + " ::: Element ID : " + elementId + " ::: Standard Code : "+ standardCode;
		if (isDebugYN) System.out.println(l_app_msg);	
		
		l_app_msg = " ::: Retrieving "+ elementId + " Value...";
		if (isDebugYN) System.out.println(l_app_msg);	

		

		try
		{
			dbConn =  ConnectionManager.getConnection();
			query = "SELECT NVL(DEFAULT_VALUE,'') DEFAULT_VALUE FROM XH_STANDARD_CONTROL_SEG " 
						+ " WHERE SEGMENT_ID = ? "
						+ " AND STANDARD_CODE = ? "
						+ " AND ELEMENT_ID = ? ";

			pstmt = dbConn.prepareStatement(query);
			pstmt.setString(1, segmentID);
			pstmt.setString(2, standardCode);
			pstmt.setString(3, elementId);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
			   l_field_value = rs.getString("DEFAULT_VALUE");
			}
			
		}
		catch(Exception e)
		{
			l_field_value = "Error in "+ l_app_msg + " : " +  e.getMessage();
		}
		finally
		{			
			XHUtil.closeDBResources(rs, pstmt, dbConn);
		}		

		return l_field_value;
	}

	public static String getFormattedStringDate(String format,java.util.Date date)
    {	
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		dateFormat.setTimeZone(TimeZone.getTimeZone("IST"));
		String dateFormatted = dateFormat.format(date);
		return dateFormatted;
    }


}
	