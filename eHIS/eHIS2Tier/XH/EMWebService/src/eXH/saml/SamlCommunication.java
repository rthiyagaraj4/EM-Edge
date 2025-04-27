package eXH.saml;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import java.text.*;
import java.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import java.io.InputStream;

import javax.xml.bind.DatatypeConverter;

import org.opensaml.DefaultBootstrap;
import org.opensaml.xml.ConfigurationException;
import org.w3c.dom.Document;


import eXH.saml.SAMLInputContainer;
import eXH.util.EMDataSource;
import eXH.util.XHUtil;


public class SamlCommunication  
{
	//public static final String l_segment_id = "SAML";//WLS
	//public static final String l_standard_code = "MLFIHL725";//WLCRCC	
	public static final String l_field_separator= "$!^";
	public static String l_debug_YN = "Y";

	public String l_errcd = "S";
    public String l_errmsg = "";
    public String l_ack_text = "";	
    public String l_event_type = "PC1";
    
    public static final String l_segment_id = "SAML";
	public static final String l_standard_code = "MLFIHL725";
	
	private String privateKeyLocation;
	private String publicKeyLocation;
	private String keystoreLocation;
	
    
    public String TransRequestMethod(String applicationId, String actionKey) {
		String l_app_msg = "";
		String l_trans_value = "";

		String l_protocol_link_id = "", l_patient_id = "",l_facility_id = "AK", l_session_id = "", l_user_id = "", l_response_msg = "", l_response_str = "",l_user_wsno = "";
		String l_application_id="",l_standard_code="",l_segment_id="",l_practioner_id="",l_saml_response="";
		String l_request_date = "";

		Connection dbConn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;

		String query = "", l_debug_yn = "", updateStmt = "";

		int updateCount = 0;	
		
		try
		{
			dbConn =  EMDataSource.getConnection();
			query = "select NVL(DEBUG_YN, 'N') DEBUG_YN FROM XH_PARAM " ;

			pstmt = dbConn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
			   l_debug_yn = rs.getString("DEBUG_YN");
			}

			l_debug_YN = l_debug_yn;

		}
		catch(Exception e)
		{
		}		
		finally {
			XHUtil.closeDBResources(rs, pstmt, null);
			EMDataSource.returnConnection(dbConn);
		}
		
		 //action_key=<APPLICATION_ID>MALAFFI$!^<PROTOCOL_LINK_ID>MLFIAKP1$!^<STANDARD_CODE>MLFIHL725$!^<SEGMENT_ID>SAML$!^<PATIENT_ID>0105354$!^<PRACTITIONER_ID>DRJAMEEL$!^<USER_NAME>SHIVA
					
		l_app_msg = " ::: Inside SAML Http Communnication TransRequestMethod Action Key ::: "+actionKey;
		if (l_debug_YN.equals("Y"))	
			System.out.println(l_app_msg);
		
		l_app_msg = "Generating Transaction id...";
		if (l_debug_YN.equals("Y"))	
			System.out.println(l_app_msg);

		l_trans_value = GenerateTransIDMethod();
		l_app_msg = "::: Sequence Number : "+l_trans_value;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_trans_value.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_trans_value;
		}
		
		l_app_msg = " ::: Fetching Application ID ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_application_id = FieldValueFetchMethod(actionKey,"<APPLICATION_ID>",null,l_field_separator, "TransRequestMethod");
		l_app_msg = " ::: APPLICATION ID : "+l_application_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_application_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_application_id;
		}
		
		l_app_msg = " ::: Fetching Protocol Link ID ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_protocol_link_id = FieldValueFetchMethod(actionKey,"<PROTOCOL_LINK_ID>",null,l_field_separator, "TransRequestMethod");
		l_app_msg = " ::: PROTOCOL LINK ID : "+l_protocol_link_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_protocol_link_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_protocol_link_id;
		}
		
		l_app_msg = " ::: Fetching Standard Code ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_standard_code = FieldValueFetchMethod(actionKey,"<STANDARD_CODE>",null,l_field_separator, "TransRequestMethod");
		l_app_msg = " ::: STANDARD CODE : "+l_standard_code;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_standard_code.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_standard_code;
		}
		
		l_app_msg = " ::: Fetching Segment ID ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_segment_id = FieldValueFetchMethod(actionKey,"<SEGMENT_ID>",null,l_field_separator, "TransRequestMethod");
		l_app_msg = " ::: SEGMENT ID : "+l_segment_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_segment_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_segment_id;
		}
		
		l_app_msg = " ::: Fetching Patient ID ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_patient_id = FieldValueFetchMethod(actionKey,"<PATIENT_ID>",null,l_field_separator, "TransRequestMethod");
		l_app_msg = " ::: Patient ID : "+l_patient_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_patient_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_patient_id;
		}
		
		l_app_msg = " ::: Fetching Practitioner ID ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_practioner_id = FieldValueFetchMethod(actionKey,"<PRACTITIONER_ID>",null,l_field_separator, "TransRequestMethod");
		l_app_msg = " ::: PRACTITIONER  ID : "+l_practioner_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_practioner_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_practioner_id;
		}
		
		l_app_msg = " ::: Fetching Session ID ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_session_id = FieldValueFetchMethod(actionKey,"<SESSION_ID>",null,l_field_separator, "TransRequestMethod");
		l_app_msg = " ::: Session ID : "+l_session_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_session_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_session_id;
		}
		
		l_app_msg = " ::: Fetching User ID ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_user_id = FieldValueFetchMethod(actionKey,"<USER_NAME>",null,l_field_separator, "TransRequestMethod");
		l_app_msg = " ::: User ID : "+l_user_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_user_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_user_id;
		}
		
		l_app_msg = " ::: Fetching User WSNO ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_user_wsno = FieldValueFetchMethod(actionKey,"<MACHINE_ID>",null,l_field_separator, "TransRequestMethod");
		l_user_wsno = l_user_wsno.trim();
		l_app_msg = " ::: WSNO : "+l_user_wsno;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_user_wsno.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_user_wsno;
		}
		
		l_app_msg = "Getting Formatted l_request_date value...";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_request_date = getFormattedStringDate("dd-MMM-yyyy HH:mm:ss", new java.util.Date());

		l_app_msg = "::: Request Date : "+l_request_date;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = "Setting  reqParams value...";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

		
		try
		{		

			Map<String,String> reqParams = new HashMap<String,String>();
			reqParams.put("LOGIN_USER", l_user_id);
			reqParams.put("CLIENT_MACHINE", l_user_wsno); 
			reqParams.put("PGM_ID", "SAML");
			//reqParams.put("MODULE_ID", "XB");
			reqParams.put("SESSION_ID", l_session_id);

			reqParams.put("MSG_ID", l_trans_value);
			//reqParams.put("REQUEST_DATE", l_request_date); 
			//reqParams.put("REQUEST_TEXT", l_request_msg); 
			reqParams.put("APPLICATION_ID", applicationId);
			reqParams.put("FACILITY_ID", l_facility_id);
			reqParams.put("MESSAGE_DATE", l_request_date); 
			reqParams.put("EVENT_TYPE", "SAM");//WL01, PT01
			reqParams.put("PATIENT_ID", l_patient_id);
			reqParams.put("EPISODE_TYPE", "");
			reqParams.put("ENCOUNTER_ID", "");
			reqParams.put("ACC_NO", actionKey);
			reqParams.put("EXT_ACC_NO", "");
			reqParams.put("REQUEST_SYNTAX", actionKey);
			reqParams.put("ACK_MSG_ID", "");
			reqParams.put("PROTOCOL_LINK_ID", "MLFIAKP1"); //KHOWLC, MCOPTM
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
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			
			XHUtil.updateInteractiveDetails(reqParams);
		
		}
		catch (Exception e)
		{
			l_errcd = "E";
			l_errmsg = "Error in setting request params : "+l_app_msg+ " - "+ e.getMessage();;
		}
		
		l_app_msg = "Calling HTTPGateway Method...";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		if (l_errcd.equals("S"))
		{			
			try 
			{
				//if (!(l_practioner_id.length()>0))
					//l_practioner_id = l_user_id;
				
					l_saml_response=generateSAML(l_debug_YN, l_user_id, l_patient_id);
					//l_response_msg =TransCommunicationMethod(l_saml_response);
					
			} 
			catch (Throwable e) {
				e.printStackTrace();
			}
			l_app_msg = " ::: TransCommunicationMethod Response Message : "+l_saml_response;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			if (l_saml_response.indexOf("Error in ")>=0 || l_saml_response.indexOf("Connection ")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_saml_response;
			}

		}
		
		
		try
		{
			dbConn =  EMDataSource.getConnection();
			updateStmt = " UPDATE XH_INTERACTIVE_INTEGRATION "
							+" SET	response_text        = ?, "
							+" acknowledgment_text    = ?, "
							+" status            = ?, "
							+" error_text        = ? "
							+" WHERE MESSAGE_ID          = ? " 
							+" AND pgm_id = ? " ;

			pstmt = dbConn.prepareStatement(updateStmt);
			pstmt.setString(1, l_saml_response);
			pstmt.setString(2, l_response_str);
			pstmt.setString(3, l_errcd);
			pstmt.setString(4, l_errmsg);
			//pstmt.setString(5, "XB");
			pstmt.setString(5, l_trans_value);
			pstmt.setString(6, "SAML");
			updateCount = pstmt.executeUpdate();

			l_app_msg = " ::: UpdateCount : "+updateCount;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			
			if (updateCount == 1)
			{
				dbConn.commit();				
			}
			else
			{
				dbConn.rollback();	
				l_errcd = "E";
				l_errmsg = " Error in updating Interactive Integration Records ";				
			}

		}
		catch(Exception e)
		{
			l_errcd = "E";
			l_errmsg = "Error in "+ l_app_msg + " : " +  e.getMessage();
		}
		finally {
			XHUtil.closeDBResources(rs, pstmt, null);
			EMDataSource.returnConnection(dbConn);
		}
		
		System.out.println(" ::: SAML Response Length : "+l_saml_response.length()+" : Error Code : "+l_errcd+" : Error Message : "+l_errmsg);
		if (l_errcd.equals("S"))
		{
			return l_saml_response;
		}
		else
		{
			return l_errmsg;
		}
		
	}
    
    public String FieldValueFetchMethod(String message, String identifier, String standardCode, String fieldSep, String procID) {
		String l_app_msg = "", l_field_value = "";	

		try
		{
			if(standardCode != null && !(standardCode.length()>0))
			{

			}
			else
			{
				if (message.indexOf(identifier) >= 0 )
				{
					if (message.indexOf(fieldSep) >= 0)
					{
						l_field_value = message.substring(message.indexOf(identifier)+identifier.length());
						if (l_field_value.indexOf(fieldSep) >= 0)
						{						
							l_field_value = l_field_value.substring(0, l_field_value.indexOf(fieldSep));
						}
					}
				}
			}
		}
		catch (Exception e)
		{
			l_field_value = "Error in "+ l_app_msg + " : " +  e.getMessage();
		}		

		l_app_msg = " ::: l_field_value ::: "+l_field_value;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

		return l_field_value;
	}


 

	public String TransCommunicationMethod(String message){
		
		String l_app_msg = "", l_element_id = "";

		String l_profile_id = "", l_standard_code = "HTTPCC";		 
		
		String l_url = "https://clinicalportal-uat.malaffi.ae/login-auth/saml?path=%2fpatient%2fauth-token%2fportal-context";
		String l_http_content_type = "application/XML";
		String l_http_user_agent = "";
		String l_http_transfer_encoding = "";
		String l_http_soapaction = "";
		int l_http_content_length_flag  = 0;

		String l_proxy_server="", l_proxy_port="";

		HttpURLConnection conn = null;

		String l_response_msg = "", l_return_resp = "";

		try
		{	
			
			l_app_msg = " Setting URL... "+l_url;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			URL url = new URL(l_url);			

			if (l_proxy_server.length()>0 && !l_proxy_server.equals("X"))
			{
				l_app_msg = " Setting http Proxy... "+l_proxy_server;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				System.setProperty("http.proxyHost", l_proxy_server);
				System.setProperty("https.proxyHost", l_proxy_server);
			}

			if (l_proxy_port.length()>0  && !l_proxy_server.equals("X"))
			{
				l_app_msg = " Setting http port... "+l_proxy_port;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				System.setProperty("http.proxyPort", l_proxy_port);       
				System.setProperty("https.proxyPort", l_proxy_port);

			}			 

			l_app_msg = " URL Open Connection...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			conn = (HttpURLConnection) url.openConnection();

			l_app_msg = " Connection Set Method...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			conn.setRequestMethod("POST");
			
			// Common Headers for Pancard Transactions
			
			if (l_http_content_type.length()>0  && !(l_http_content_type.equals("XXX")))
			{
				l_app_msg = " Set Property Content-Type... "+l_http_content_type;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
				conn.setRequestProperty("Content-Type", l_http_content_type);
			}			

			if (l_http_user_agent.length()>0  && !(l_http_user_agent.equals("XXX")))
			{
				l_app_msg = " Set Property User-Agent... "+l_http_user_agent;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
				conn.setRequestProperty("User-Agent", l_http_user_agent);
			}

			if (l_http_content_length_flag>0)
			{
				l_app_msg = " Set Property Content-Length... "+l_http_content_length_flag;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
				conn.setRequestProperty("Content-Length", Integer.toString(message.length()));
			}

			if (l_http_transfer_encoding.length()>0  && !(l_http_transfer_encoding.equals("XXX")))
			{
				l_app_msg = " Set Property Transfer-Encoding... "+l_http_transfer_encoding;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
				conn.setRequestProperty("Transfer-Encoding", l_http_transfer_encoding);
			}

			if (l_http_soapaction.length()>0  && !(l_http_soapaction.equals("XXX")))
			{
				l_app_msg = " Set Property SOAPAction... "+l_http_soapaction;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
				conn.setRequestProperty("SOAPAction", l_http_soapaction);
			}
			
			l_app_msg = " conn.setUseCaches(false)...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			
			conn.setUseCaches(false);
			
			//java certificate location
			//String certificatesTrustStorePath = "%JAVA_HOME%/jre/lib/security/cacerts";
			//System.setProperty("javax.net.ssl.trustStore", certificatesTrustStorePath);

			l_app_msg = " Set DoOutput(true)...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			conn.setDoOutput(true);

			l_app_msg = " Writing the request to the OutputStream...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			OutputStream os = conn.getOutputStream();
			os.write(message.getBytes());
			os.flush();

			l_app_msg = " Reading the response from the OutputStream...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			
			InputStream is;
			try{
				is = conn.getInputStream();
			}catch(Exception e){
				is = conn.getErrorStream();
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((is)));

			l_app_msg = " Output from Server .... \n";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			while ((l_response_msg = br.readLine()) != null) {
				l_return_resp = l_return_resp + l_response_msg;
				l_app_msg = " Output Received from Server..."+l_return_resp;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			}
			
			conn.disconnect();
			
		}
		catch (MalformedURLException e) 
		{
			e.printStackTrace();
			l_response_msg = "Error in TransCommunicationMethod MalformedURLException : "+ l_app_msg + " : " +  e.getMessage();
			System.out.println(" ::: MalformedURLException ::: " +l_response_msg);			
			return l_response_msg;
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
			l_response_msg = "Error in TransCommunicationMethod IOException : "+ l_app_msg + " : " +  e.getMessage();
			System.out.println(" ::: IOException ::: " +l_response_msg);			
			return l_response_msg;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			l_response_msg = "Error in TransCommunicationMethod Exception : "+ l_app_msg + " : " +  e.getMessage();
			System.out.println(" ::: Exception ::: " +l_response_msg);
			return l_response_msg;
		}		
		l_app_msg = " Response Returned : "+l_return_resp;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		return l_return_resp;
	}	
	
	public static Map<String,String> getRequestParams()
	{
		Map<String,String> requestParams = new HashMap<String,String>();		
		return requestParams;
	}

	public static String getFormattedStringDate(String format,Date date)
    {	
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		dateFormat.setTimeZone(TimeZone.getTimeZone("IST"));
		String dateFormatted = dateFormat.format(date);
		return dateFormatted;
    }
	
	public String GenerateTransIDMethod(){

		Connection dbConn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;

		String query = "";
		String l_app_msg = "", l_field_value = "";

		int l_trans_id = 0;

		l_app_msg = " ::: Inside GenerateTransIDMethod ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);			
		
		try
		{
			dbConn =  EMDataSource.getConnection();
			query = "select XH_INTERACTIVE_TRX_NO_SEQ.NEXTVAL TRANSID FROM DUAL " ;

			pstmt = dbConn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
			   l_trans_id = rs.getInt("TRANSID");
			}

			if (l_trans_id > 0 )
			{
				l_field_value = String.valueOf(l_trans_id);
			}
			
		}
		catch(Exception e)
		{
			l_field_value = "Error in "+ l_app_msg + " : " +  e.getMessage();
		}
		finally {
			XHUtil.closeDBResources(rs, pstmt, null);
			EMDataSource.returnConnection(dbConn);
		}	

		return l_field_value;
	}
	
	public String generateSAML(String debug_yn, String practitioner_id, String patient_id) throws Throwable {
    	String responseStr="";
        try {
        	
        	l_debug_YN = debug_yn;
        			
        	Connection dbConn = null;
    		ResultSet rs=null;
    		PreparedStatement pstmt = null;
    		
    		String query = "";
    		String l_app_msg = "",l_first_name="", l_last_name="", l_full_name="", l_email_address="", l_phone="", l_gender="", l_facility_license="";
    		String l_element_id="",l_organization="",l_resourceid_oid="",l_audience_restriction="",l_profession="",l_category="";
    		String l_publickey="",l_privatekey="", l_keystore="",l_practitioner_id="",l_patient_id="",l_issuer_name="",l_apc_no="",l_pract_type="", l_subject_role="", l_recipient = "";
    		
     		
    		l_practitioner_id = practitioner_id;
    		l_patient_id = patient_id;
    		
    		String l_response_msg = "", l_return_resp = "";
    		l_app_msg = " ::: Inside getPatientDetails ::: ";
    		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

    		
    		l_app_msg = " ::: Fetching Communication Standards CheckStatus ::: ";
    		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

    		try
    		{   			
    			
    			dbConn =  EMDataSource.getConnection();
    			query = "Select PRACTITIONER_ID, PRACTITIONER_NAME, NVL(EMAIL_ID,'info@ak-hospital.com') EMAIL_ID, NVL(OFF_TEL_NUM,'037133333') OFF_TEL_NUM, GENDER, NVL(APC_NO,'') APC_NO, PRACT_TYPE From XH_EM_USERS_VW Where PRACTITIONER_ID=?";
    			
    			l_app_msg = " ::: Practitioner Query "+query;
 			   	if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
 			   
    			pstmt = dbConn.prepareStatement(query);
    			pstmt.setString(1, l_practitioner_id);			
    			rs = pstmt.executeQuery();
    			while(rs.next())
    			{
    			   l_first_name = rs.getString("PRACTITIONER_NAME")==null?"":rs.getString("PRACTITIONER_NAME");
    			   l_last_name = rs.getString("PRACTITIONER_NAME")==null?"":rs.getString("PRACTITIONER_NAME");
    			   l_full_name = rs.getString("PRACTITIONER_NAME")==null?"":rs.getString("PRACTITIONER_NAME");
    			   l_email_address = rs.getString("EMAIL_ID")==null?"":rs.getString("EMAIL_ID");
    			   l_phone = rs.getString("OFF_TEL_NUM")==null?"":rs.getString("OFF_TEL_NUM");
    			   l_gender = rs.getString("GENDER")==null?"":rs.getString("GENDER");
    			   if (l_gender.equalsIgnoreCase("M"))
    			   		l_gender = "Male";
    			   else if (l_gender.equalsIgnoreCase("F"))
    			   		l_gender = "Female";
    			   else if (l_gender.equalsIgnoreCase("U"))
   			   		l_gender = "Unknown";
    			   else if (l_gender.equalsIgnoreCase("N"))
      			   		l_gender = "Not Available";
    			   
    			   l_apc_no=rs.getString("APC_NO")==null?"":rs.getString("APC_NO");
    			   l_pract_type=rs.getString("PRACT_TYPE")==null?"":rs.getString("PRACT_TYPE");
    			}
    			   
    			   l_element_id = "FACILITY_LICENSE";
    			   l_facility_license = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code);
    			   l_app_msg = " ::: FACILITY LICENSE: "+l_facility_license;
    			   if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
    			   
    			   if (l_apc_no.length() > 0)
    				   l_apc_no = l_apc_no;
    			   else
    				   l_apc_no = l_facility_license +"-"+l_practitioner_id;
    			   
    			   l_app_msg = " ::: Doctor License : "+l_apc_no;
    			   if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
    			   
    			   l_element_id = "ORGANIZATION";
    			   l_organization = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code);
    			   l_app_msg = " ::: ORGANIZATION : "+l_organization;
    			   if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
    			   
    			 //Modify by Niveditha on 02/07/2020
    			  /* l_element_id = "SUBJECT_ROLE";
    			   l_subject_role = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code);
    			   l_app_msg = " ::: SUBJECT ROLE: "+l_subject_role;
    			   if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	*/     			   
    			  
    			   l_subject_role = FetchSubjRoleMethod(l_pract_type);
    			   l_app_msg = " ::: Subject Role: "+l_subject_role;
    			   if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
    			   
    			   
    			   l_element_id = "RESOURCEID_OID";
    			   l_resourceid_oid = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code);
    			   l_app_msg = " ::: RESOURCEID OID: "+l_resourceid_oid;
    			   if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
    			   
    			   l_element_id = "AUDIENCE_RESTRICTION";
    			   l_audience_restriction = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code);
    			   l_app_msg = " ::: AUDIENCE RESTRICTION: "+l_audience_restriction;
    			   if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
    			   
    			   l_element_id = "PROFESSION";
    			   l_profession = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code);
    			   l_app_msg = " ::: PROFESSION: "+l_profession;
    			   if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
    			   
    			   l_element_id = "CATEGORY";
    			   l_category = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code);
    			   l_app_msg = " ::: CATEGORY: "+l_category;
    			   if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
    			   
    			   l_element_id = "PUBLICKEY";
    			   l_publickey = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code);
    			   l_app_msg = " ::: PUBLICKEY: "+l_publickey;
    			   if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
    			   
    			   this.publicKeyLocation = l_publickey;
    			   
    			   l_element_id = "PRIVATEKEY";
    			   l_privatekey = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code);
    			   l_app_msg = " ::: PRIVATEKEY: "+l_privatekey;
    			   if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
    			   
    			   this.privateKeyLocation = l_privatekey;
    			   
    			   l_element_id = "KEYSTORE";
    			   l_keystore = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code);
    			   l_app_msg = " ::: KEYSTORE: "+l_keystore;
    			   if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
    			   
    			   l_element_id = "ISSUER";
    			   l_issuer_name = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code);
    			   l_app_msg = " ::: ISSUER NAME: "+l_issuer_name;
    			   if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
    			   
    			   l_element_id = "RECIPIENT";
    			   l_recipient = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code);
    			   l_app_msg = " ::: RECIPIENT: "+l_recipient;
    			   if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
    			
    			l_app_msg = " ::: First_Name ID : "+ l_first_name + " ::: Last_Name : " + l_last_name + " ::: Full_Name : "+ l_full_name + " ::: Email_Address : "+l_email_address;
    			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

    			l_app_msg = " ::: Phone : "+ l_phone + " ::: Gender : " + l_gender;
    			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
    			
    			
    		}catch(Exception e)
    		{
    			e.printStackTrace();
    			l_response_msg = e.getMessage();
    			System.out.println(" ::: Exception while getting patient details ::: " +l_response_msg);
    		}
    		finally {
    			closeDBResources(rs, pstmt, null);
    			EMDataSource.returnConnection(dbConn);
    		}
    		l_app_msg = " ::: Check Status return_resp : "+l_return_resp;
    		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
        	
            SAMLInputContainer input = new SAMLInputContainer();
            input.setStrIssuer(l_issuer_name);
            input.setStrNameID(l_apc_no);
            input.setSessionId("abcdedf1234567");
            input.setStrRecipeint(l_recipient);
            input.setAudienceRestriction(l_audience_restriction);
            String publicKey=l_publickey;
            String privateKey=l_privatekey;
            
            Map<String,String> customAttributes = new HashMap<String, String>();
            //customAttributes.put("urn:oasis:names:tc:xacml:2.0:subject:role", l_subject_role); 
            customAttributes.put("urn:malaffi:firstname", l_first_name);
            customAttributes.put("urn:malaffi:lastname", l_last_name);
            customAttributes.put("urn:malaffi:fullname", l_full_name);            
            customAttributes.put("urn:malaffi:emailaddress", l_email_address);
            customAttributes.put("urn:malaffi:workphone", l_phone);
            
            customAttributes.put("urn:malaffi:major", l_profession);
            customAttributes.put("urn:malaffi:profession", l_profession);
            customAttributes.put("urn:malaffi:category", l_category);
            customAttributes.put("urn:malaffi:facilitylicense", l_facility_license);
            customAttributes.put("urn:malaffi:gender",l_gender);
            customAttributes.put("urn:malaffi:organization", l_organization);            
            customAttributes.put("urn:oasis:names:tc:xacml:2.0:resource:resource-id", l_patient_id+"^^^&"+l_resourceid_oid+"&ISO");

            input.setAttributes(customAttributes);
            
            SamlAssertionProducer producer = new SamlAssertionProducer();
			producer.setPrivateKeyLocation(privateKey);
			producer.setPublicKeyLocation(publicKey);
			producer.setKeystoreLocation(l_keystore);
            //Response responseInitial = producer.createSAMLResponse(input);
			
			
			try {
				// A performant implementation would call this in a ServletContextListener.
				DefaultBootstrap.bootstrap();
			} catch (final ConfigurationException e) {
				throw new RuntimeException("Exception bootstrapping the OpenSAML library", e);
			}
			
			
			//Commented by Sethu			
			//responseStr = producer.createSAMLResponse(input);	
			
			String l_keyAlias = "malaffi";//"samlSigningKey"//"4e483dd9-935b-4e32-af99-7ddf22b6eb67"; //"myRSAkey";
    		
    		final char[] password = "AKHMalaffi2020".toCharArray(); //"malaffisso","akh123", "password"
    		
    		String l_roleSamlAttributeName = "urn:oasis:names:tc:xacml:2.0:subject:role";
			
			responseStr = producer.getSamlResponse(l_issuer_name, l_recipient, l_apc_no, l_subject_role,
					input, l_audience_restriction, l_roleSamlAttributeName,
					l_keystore, password, l_keyAlias, password);			
			
			l_app_msg = " ::: SAML Generated After Format: \n "+responseStr;
    		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			
			responseStr = DatatypeConverter.printBase64Binary(responseStr.getBytes());			
	

        } catch (Exception e) {
            e.printStackTrace();
            responseStr = "Exception in generating the SAML response : " +  e.getMessage();
            return responseStr;
        }
        
        return responseStr;
    }
	
	public static String FetchStdCntrlSegMethod(String segmentID, String elementId, String standardCode) {
		Connection dbConn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;

		String query = "";
		String l_app_msg = "", l_field_value = "";

		l_app_msg = " ::: Inside FetchStdCntrlSegMethod ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = " ::: Segment ID : "+ segmentID + " ::: Element ID : " + elementId + " ::: Standard Code : "+ standardCode;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		
		l_app_msg = " ::: Retrieving "+ elementId + " Value...";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		try
		{
			dbConn =  EMDataSource.getConnection();
			query = "SELECT NVL(DEFAULT_VALUE,'X') DEFAULT_VALUE FROM XH_STANDARD_CONTROL_SEG " 
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
		finally {
			XHUtil.closeDBResources(rs, pstmt, null);
			EMDataSource.returnConnection(dbConn);
		}
		return l_field_value;
	}
    
    public static String FetchSubjRoleMethod(String elementId) {
		Connection dbConn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;

		String query = "";
		String l_app_msg = "", l_field_value = "";

		l_app_msg = " ::: Inside FetchSubjRoleMethod ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		
		l_app_msg = " ::: Retrieving "+ elementId + " Value...";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		try
		{
			dbConn =  EMDataSource.getConnection();
			
			query = "SELECT EXT_PK_ID FROM XH_OTH_APPL_DATA_SKEY WHERE TABLE_ID = 'AM_PRACT_TYPE' AND APPLICATION_ID = 'MALAFFI' AND " + "PK_VALUE = ?"; 
	
			pstmt = dbConn.prepareStatement(query);
			pstmt.setString(1, elementId);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
			   l_field_value = rs.getString("EXT_PK_ID");
			}
			
		}
		catch(Exception e)
		{
			l_field_value = "Error in "+ l_app_msg + " : " +  e.getMessage();
		}
		finally {
			XHUtil.closeDBResources(rs, pstmt, null);
			EMDataSource.returnConnection(dbConn);
		}
		return l_field_value;
    }
    
    public static void closeDBResources(ResultSet rs, Statement stmt, Connection conn)
	{
		try {
			if(rs != null) rs.close();
		}
		catch(Exception exp) {
		}
		finally  {
			try {
				if(stmt != null) stmt.close();
			}
			catch(Exception exp) {
			}
			finally  {
				try {
					if(conn != null) 
					{
						EMDataSource.returnConnection(conn);
					}
				}
				catch (Exception exp) { }				
			}
		}
	}

}
