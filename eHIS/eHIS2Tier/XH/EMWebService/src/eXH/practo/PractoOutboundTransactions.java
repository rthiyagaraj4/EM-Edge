package eXH.practo;

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
import java.sql.SQLException;

import oracle.sql.CLOB;

import java.util.Date;
import java.text.*;
import java.util.*;
import eXH.util.*;

//Class for Practo Outbound Transaction
//Added for KDAH-CRF-0456 by Krupa on 25/07/2018
public class PractoOutboundTransactions
{
	/*
	OA21 - SCH
	OA22 - CAN
	OA23 - RSCH
	OA24 - BLK
	OA25 - CKIN
	OA26 - SLOTID
		
	*/
	public static String l_debug_YN = "N";
	String l_field_separator = "$!^";
	String l_errcd ="S";
	
	/*public static void main(String[] args){
		String response="",query = "",l_visit_date= "",l_acc_dt = "";
		
		String rschactionKey = "<REQTYPE>RSCH$!^<URL>https://<hmsdomain>/bookAppointment$!^<APPLICATION_ID>PRACTO$!^<FACILITY_ID>KH$!^"
				+ "<EVENT_TYPE>OA23$!^<MESSAGE_ID>71$!^<PROTOCOL_LINK>KHPRACTPL1$!^<ADDED_BY_ID>dflt$!^<ADDED_AT_WS_NO>dflt$!^"
				+ "<ADDED_FACILITY_ID>KH$!^<ADDED_DATE>YYYYMMDDHH24MISS$!^JSON<original_appointment_id>701$!^"
				+ "<appointment_time>2018-07-05T17:2000.000+00:00$!^<appointment_slot_id>be1e247b-16e7-4525-8be3-956311f6387b$!^"
				+ "<appointment_procedure_id>58289e00-cd00-4ddc-b9cc-1ed01b0df956$!^<appointment_source>100$!^"
				+ "<patient_mobile>9896250253$!^<appointment_type>N$!^<first_timer>0";
		String blkactionKey = "<REQTYPE>BLK$!^<URL>https://<hmsdomain>/doctors/block_slots$!^<APPLICATION_ID>PRACTO$!^<FACILITY_ID>KH$!^<EVENT_TYPE>OA24$!^<MESSAGE_ID>50$!^<PROTOCOL_LINK>KHPRACTPL1$!^"
			+"<ADDED_BY_ID>dflt$!^<ADDED_AT_WS_NO>dflt$!^<ADDED_FACILITY_ID>KH$!^<ADDED_DATE>YYYYMMDDHH24MISS$!^<key>atfo8z$!^<salt>w2psja8n2mhw5nw$!^"
			+"<signature>slotid$!^JSON<slot_id>asdasasdas$!^<reason>Doctor not available$!^<block_timings>[$!^<start_time>12319230192380198$!^<end_time>24232342342234$!^<block_timings>]";

		String slotId = "<REQTYPE>SLOTID$!^<URL>https://staging-pulse.qikwell.com/api/v1/doctors/slots?doctor_id=ARSHAD&location_id=CARD$!^"
				+ "<APPLICATION_ID>PRACTO$!^<FACILITY_ID>KH$!^<EVENT_TYPE>OA26$!^<MESSAGE_ID>1705903$!^"
				+ "<PROTOCOL_LINK>KHPRACTPL1$!^<ADDED_BY_ID>ARSHAD$!^"
				+ "<ADDED_AT_WS_NO>CSCINDAE696231$!^<ADDED_FACILITY_ID>KH$!^"
				+ "<ADDED_DATE>30-MAY-13$!^<KEY>atfo8z$!^<SALT>w2psja8n2mhw5nw$!^<SIGNATURE>ARSHAD|CARD$!^<METHOD>GET";
		response = ConnectionManager.getDBDetails();
		System.out.println(":: response :: "+response);
		
		if(response.equals("S"))
		{
			 String canactionKey = "<REQTYPE>CAN$!^<URL>https://<hmsdomain>/cancelAppointment$!^<APPLICATION_ID>PRACTO$!^"
					+ "<FACILITY_ID>KH$!^<EVENT_TYPE>OA22$!^<MESSAGE_ID>30$!^<PROTOCOL_LINK>KHPRACTPL1$!^<ADDED_BY_ID>dflt$!^<ADDED_AT_WS_NO>dflt$!^"
					+ "<ADDED_FACILITY_ID>KH$!^<ADDED_DATE>YYYYMMDDHH24MISS$!^JSON<appointment_id>"
					+ "12001$!^<reason>Wrong Entry$!^<cancelled_by>CSC234";			
			
			PractoOutboundTransactions app=new PractoOutboundTransactions();
			response = app.processRequest(slotId);
			
			System.out.println(" :: Final response :: "+response);
		}
		else{
			System.out.println(response);
		}
		
		
	}
	*/
    public String processRequest(String actionKey)
    {
    	String l_app_msg = "";
    	String l_request="",l_response = "";    	
    	
		l_debug_YN = XHUtil.l_debug_YN;
		
		try {
			l_app_msg = " ::: Fetching Request... ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_request = FetchFieldValue(actionKey, "<REQTYPE>", null, l_field_separator, "ProcessRequest");
			if (l_request.indexOf("Error")>=0)
			{
				l_errcd = "E";
				return  l_errcd + "$!^" + l_app_msg + "$!^" + l_request;
			}
			l_app_msg = " ::: Request... "+l_request;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			if(l_request.length()<=0)
			{
				l_errcd = "E";
				return  l_errcd + "$!^" + l_app_msg + "$!^" +" No Events Available !!" ;
			}
			else{
				l_response = practoTransaction(actionKey);
			}
		}
		catch (Exception e){
			return "E" + "$!^" + l_app_msg + "$!^" +" Exception Occurred !!" ;
		}	    	
		
		return l_response;
    }
	
    private String practoTransaction(String actionKey) {
		
		String l_app_msg = "";
		
		String l_application_id = "",l_event_type ="",l_facility_id="",l_url ="",l_msg_id = "",l_protocol_link = "";
		String createJsonString="",l_response = "";	
		String l_key ="",l_pkey ="",l_signature ="",l_salt ="",l_message ="{";
		
		String l_response_return = "";
		
		try {		
			
			l_app_msg = " ::: Practo Transaction... ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
		
			l_application_id= FetchFieldValue(actionKey, "<APPLICATION_ID>", null, l_field_separator, "ProcessRequest");
			if (l_application_id.indexOf("Error")>=0)
			{
				l_errcd = "E";
				return l_errcd + "$!^" + l_app_msg + "$!^" + l_application_id;
			}
			l_app_msg = " ::: Application Id... "+l_application_id;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			l_app_msg = " ::: Fetching Event Type... ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
	
			l_event_type = FetchFieldValue(actionKey, "<EVENT_TYPE>", null, l_field_separator, "ProcessRequest");
			if (l_event_type.indexOf("Error")>=0)
			{
				l_errcd = "E";
				return l_errcd + "$!^" + l_app_msg + "$!^" + l_event_type;
			}
			l_app_msg = " ::: Event type... "+l_event_type;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			l_app_msg = " ::: Fetching Facility ID... ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
	
			l_facility_id = FetchFieldValue(actionKey, "<FACILITY_ID>", null, l_field_separator, "ProcessRequest");
			if (l_facility_id.indexOf("Error")>=0)
			{
				l_errcd = "E";
				return l_errcd + "$!^" + l_app_msg + "$!^" + l_facility_id;
			}
			l_app_msg = " ::: Facility Id... "+l_facility_id;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			l_app_msg = " ::: Fetching Message ID... ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
	
			l_msg_id = FetchFieldValue(actionKey, "<MESSAGE_ID>", null, l_field_separator, "ProcessRequest");
			if (l_msg_id.indexOf("Error")>=0)
			{
				l_errcd = "E";
				return l_errcd + "$!^" + l_app_msg + "$!^" + l_msg_id;
			}
			l_app_msg = " ::: Message Id... "+l_msg_id;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			l_app_msg = " ::: Fetching Protocol Link... ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
	
			l_protocol_link = FetchFieldValue(actionKey, "<PROTOCOL_LINK>", null, l_field_separator, "ProcessRequest");
			if (l_protocol_link.indexOf("Error")>=0)
			{
				l_errcd = "E";
				return l_errcd + "$!^" + l_app_msg + "$!^" + l_protocol_link;
			}
			l_app_msg = " ::: Protocol link id... "+l_protocol_link;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			l_app_msg = " ::: Fetching URL... ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);	
			
			l_url =   FetchFieldValue(actionKey, "<URL>", null, l_field_separator, "TransCommunicationMethod");
			l_app_msg = " ::: URL... "+l_url;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			if (l_url.indexOf("Error")>=0)
			{
				return l_url;
			}
			l_message =l_message+ "\"URL\" : \""+l_url+"\"";
			
			l_app_msg = " ::: Fetching key... ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			l_key = FetchFieldValue(actionKey, "<KEY>", null, l_field_separator, "TransCommunicationMethod");
			l_app_msg = " ::: l_key : "+l_key;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			if (l_key.indexOf("Error")>=0)
			{
				return l_key;
			}	
			l_message =l_message+ ",\"KEY\" : \""+l_key+"\"";
			l_app_msg = " ::: Fetching pkey... ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			l_pkey = FetchFieldValue(actionKey, "<SIGNATURE>", null, l_field_separator, "TransCommunicationMethod");
			l_app_msg = " ::: l_pkey : "+l_pkey;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			if (l_key.indexOf("Error")>=0)
			{
				return l_pkey;
			}
			
			l_app_msg = " ::: Fetching salt... ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			l_salt = FetchFieldValue(actionKey, "<SALT>", null, l_field_separator, "TransCommunicationMethod");
			l_app_msg = " ::: l_salt : "+l_salt;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			if (l_key.indexOf("Error")>=0)
			{
				return l_salt;
			}
			
			l_app_msg = " ::: Fetching Signature... ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			l_signature = XHUtil.getSHA512(l_key+"|"+l_pkey+"|"+l_salt);
			l_app_msg = " ::: l_signature : "+l_signature;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			if (l_signature.indexOf("Error")>=0)
			{
				return l_signature;
			}
			l_message =l_message+ ",\"Signature\" : \""+l_signature+"\"";
			
			l_app_msg = " ::: Generating JSON Request Object...Error Code... "+l_errcd;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);				
	        
			if(l_errcd.equals("S")){
				if(!(l_event_type.equals("OA26"))){
					
					l_app_msg = " ::: XHJSONBuild.buildJson... ";
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
					
					createJsonString = XHJSONBuild.buildJson(l_application_id,l_event_type,l_facility_id,actionKey);
					if (createJsonString.indexOf("Error")>=0)
					{
						l_errcd = "E";
						return  l_errcd + "$!^" + l_app_msg + "$!^" + createJsonString;
					}
		            l_app_msg = " ::: JSON String created... "+createJsonString;
					if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
					l_message =l_message+ ",\"JSON\" : "+createJsonString;
				}
				l_message =l_message+"}";
	            
				l_app_msg = " ::: Application Message Details... ";
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
	             
				l_response = updateMessageDetails(l_protocol_link,actionKey,l_message);
				if (l_response.indexOf("Error")>=0)
				{
					l_errcd = "E";
					return  l_errcd + "$!^" + l_app_msg + "$!^" + l_response;
				}
				
				l_app_msg = " :::After Application Message Details... Response... "+l_response+" ::: Error Code... "+l_errcd;
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				
				if(l_errcd.equals("S")){
					
					l_app_msg = " :::  Call TransCommunicationMethod ... ";
					if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
					
					l_response_return = TransCommunicationMethod(l_protocol_link, actionKey,createJsonString,l_signature);
					if (l_response_return.indexOf("Error")>=0)
					{
						l_errcd = "E";
					}
				
					l_app_msg = " :::After Call TransCommunicationMethod ... Response... "+l_response_return;
					if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				
					l_app_msg = " ::: Update Application Message Details ... ";
					if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
					
					l_response = updateMessageDetails(l_protocol_link,actionKey,l_response_return);
					if (l_response.indexOf("Error")>=0)
					{
						l_errcd = "E";
						return  l_errcd + "$!^" + l_app_msg + "$!^" + l_response;
					}
					
					l_app_msg = " ::: After Update Application Message Details... Response... "+l_response ;
					if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				}
	        }
		}
		catch (Exception e) {
			return  "E" + "$!^" + l_app_msg + "$!^ Exception Occurred " + e.getMessage();
		}
		return  l_errcd + "$!^" + l_app_msg + "$!^" + l_response_return;
	}
		
		public String automaticCheckin(String actionKey) {
			// TODO Auto-generated method stub
			return null;
		}
		
		
		public String FetchFieldValue(String message, String identifier, String standardCode, String fieldSep, String procID){

			String l_app_msg = "", l_field_value = "";

			l_app_msg = " ::: Inside FetchFieldValue ::: ";
			//if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_app_msg = " ::: Message : "+ message + " ::: Identifier : " + identifier + " ::: Standard Code : "+ standardCode;
			//if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			
			l_app_msg = " ::: Deriving Field Value..."+identifier;
			//if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

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

			l_app_msg = " ::: Field Value... "+l_field_value;
			//if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			return l_field_value;
		}
		
		public String TransCommunicationMethod(String protocolLinkID, String actionKey, String message,String signature){
			Connection dbConn = null;
			ResultSet rs=null;
			PreparedStatement pstmt = null;

			String query = "",l_app_msg = "";
			String l_key="",l_request="",l_procto_url = "",l_proxy_server = "",l_proxy_port = "";


			String l_profile_id = "", l_standard_code = "";
			String l_http_user_agent = "", l_http_content_type = "", l_http_transfer_encoding = "", l_http_soapaction = "", l_url = "";
			int l_http_content_length_flag  = 0;

			HttpURLConnection conn = null;

			String l_response_msg = "", l_return_resp = "",l_out_JSON = "",l_method = "";


			l_app_msg = " ::: Inside TransCommunicationMethod ::: ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_app_msg = " ::: Protocol Link ID : "+ protocolLinkID + " ::: Action Key : " + actionKey + " ::: Message : "+message;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			
			l_app_msg = " ::: Fetching Communication Standards ::: ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			try
			{
				dbConn =  EMDataSource.getConnection();
				//dbConn =  EMDBConnectionPool.getConnection();
				query = "SELECT    nvl(profile_id,'') profile_id, nvl(xml_style_sheet_url, '') xml_style_sheet_url, nvl(standard_code,'') standard_code, "
							+ " nvl(http_user_agent,'XXX') http_user_agent, nvl(http_content_type, 'XXX') http_content_type, nvl(http_transfer_encoding, 'XXX') http_transfer_encoding, "
							+ " nvl(http_soapaction,'XXX') http_soapaction, nvl(http_content_length_flag,0)  http_content_length_flag "
				            + " FROM    xh_protocol a, xh_protocol_link b "
							+ " WHERE    a.protocol_id = b.protocol_id AND b.protocol_link_id = ? ";

				pstmt = dbConn.prepareStatement(query);
				pstmt.setString(1, protocolLinkID);			
				rs = pstmt.executeQuery();
				while(rs.next())
				{
				   l_profile_id = rs.getString("PROFILE_ID");
				   l_url = rs.getString("XML_STYLE_SHEET_URL");
				   l_standard_code = rs.getString("STANDARD_CODE");
				   l_http_user_agent = rs.getString("HTTP_USER_AGENT");
				   l_http_content_type = rs.getString("HTTP_CONTENT_TYPE");
				   l_http_transfer_encoding = rs.getString("HTTP_TRANSFER_ENCODING");
				   l_http_soapaction = rs.getString("HTTP_SOAPACTION");
				   l_http_content_length_flag = rs.getInt("HTTP_CONTENT_LENGTH_FLAG");
				}

				l_app_msg = " ::: Profile ID : "+ l_profile_id + " ::: API URL : " + l_url + " ::: Standard Code : "+ l_standard_code + " ::: HTTP User Agent : "+l_http_user_agent;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				l_app_msg = " ::: HTTP Content Type : "+ l_http_content_type + " ::: HTTP Transfer Encoding : " + l_http_transfer_encoding + " ::: HTTP Soap Action : "+ l_http_soapaction + " ::: HTTP Content Length Flag : "+l_http_content_length_flag;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				l_app_msg = " ::: Fetching Request... ";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				l_request = FetchFieldValue(actionKey, "<REQTYPE>", null, l_field_separator, "TransCommunicationMethod");
				l_app_msg = " ::: Request... "+l_request;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
				if (l_request.indexOf("Error")>=0)
				{
					return l_request;
				}
				
				l_app_msg = " ::: Fetching key... ";
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				
				l_key = FetchFieldValue(actionKey, "<KEY>", null, l_field_separator, "TransCommunicationMethod");
				l_app_msg = " ::: Key... "+l_key;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				if (l_key.indexOf("Error")>=0)
				{
					return l_key;
				}	
				
				l_app_msg = " ::: Fetching Method... ";
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				
				l_method = FetchFieldValue(actionKey, "<METHOD>", null, l_field_separator, "TransCommunicationMethod");
				l_app_msg = " ::: Method... "+l_method;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				if (l_method.indexOf("Error")>=0)
				{
					return l_method;
				}
				l_app_msg = " ::: Fetching Proxy Server... ";
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				
				l_proxy_server = FetchFieldValue(actionKey, "<PROXY_SERVER>", null, l_field_separator, "TransCommunicationMethod");
				l_app_msg = " ::: Proxy Server... "+l_proxy_server;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				if (l_proxy_server.indexOf("Error")>=0)
				{
					return l_proxy_server;
				}
				l_app_msg = " ::: Fetching Proxy Port... ";
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				
				l_proxy_port = FetchFieldValue(actionKey, "<PROXY_PORT>", null, l_field_separator, "TransCommunicationMethod");
				l_app_msg = " ::: Proxy port... "+l_proxy_port;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				if (l_proxy_port.indexOf("Error")>=0)
				{
					return l_proxy_port;
				}
				
				l_app_msg = " ::: Fetching URL... ";
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

				
				l_procto_url =   FetchFieldValue(actionKey, "<URL>", null, l_field_separator, "TransCommunicationMethod");
				l_app_msg = " ::: URL... "+l_procto_url;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
				if (l_procto_url.indexOf("Error")>=0)
				{
					return l_procto_url;
				}

				l_procto_url = l_procto_url.trim();
				
				l_app_msg = " ::: URL... "+l_procto_url;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
				URL url = new URL(l_procto_url);
				
				if (l_proxy_server.length()>0 && !l_proxy_server.equals("X"))
				{
					l_app_msg = " ::: Setting http Proxy...";
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

					System.setProperty("http.proxyHost", l_proxy_server);
					System.setProperty("https.proxyHost", l_proxy_server);
				}

				if (l_proxy_port.length()>0  && !l_proxy_server.equals("X"))
				{
					l_app_msg = " ::: Setting http port...";
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

					System.setProperty("http.proxyPort", l_proxy_port);       
					System.setProperty("https.proxyPort", l_proxy_port);

				}

				l_app_msg = " ::: URL Open Connection...";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				conn = (HttpURLConnection) url.openConnection();

				l_app_msg = " ::: Connection Set Method...";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				conn.setRequestMethod(l_method);
				
				conn.setRequestProperty("key", l_key);
				conn.setRequestProperty("signature", signature); 
				
				// Common Headers for PayTM Transactions

				if (!(l_http_content_type.equals("XXX")))
				{
					l_app_msg = " ::: Set Property Content-Type...";
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
					conn.setRequestProperty("Content-Type", l_http_content_type);
				}	
				
				l_app_msg = " ::: l_request : "+l_request;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	


				if (!(l_http_user_agent.equals("XXX")))
				{
					l_app_msg = " ::: Set Property User-Agent...";
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
					conn.setRequestProperty("User-Agent", l_http_user_agent);
				}
				if(!(l_request.equals("SLOTID"))){
					if (l_http_content_length_flag>0)
					{
						l_app_msg = " ::: Set Property Content-Length...";
						if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
						conn.setRequestProperty("Content-Length", Integer.toString(message.length()));
					}
				}

				if (!(l_http_transfer_encoding.equals("XXX")))
				{
					l_app_msg = " ::: Set Property Transfer-Encoding...";
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
					conn.setRequestProperty("Transfer-Encoding", l_http_transfer_encoding);
				}

				if (!(l_http_soapaction.equals("XXX")))
				{
					l_app_msg = " ::: Set Property SOAPAction...";
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
					conn.setRequestProperty("SOAPAction", l_http_soapaction);
				}
				
				l_app_msg = " ::: conn.setUseCaches(false)...";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
				
				conn.setUseCaches(false);

				l_app_msg = " ::: conn.setDoOutput(true)...";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
				conn.setDoOutput(true);

				l_app_msg = " ::: Writing the request to the OutputStream...";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
					
				
				if(!(l_request.equals("SLOTID"))){
					OutputStream os = conn.getOutputStream();
					os.write(message.getBytes());
					os.flush();
				}
				
				

				l_app_msg = " ::: Reading the response from the OutputStream...";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
				
				InputStream is;
				try{
					is = conn.getInputStream();
				}catch(Exception e){
					is = conn.getErrorStream();
				}

				BufferedReader br = new BufferedReader(new InputStreamReader((is)));

				l_app_msg = " ::: Output from Server .... \n";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				while ((l_response_msg = br.readLine()) != null) {
					l_return_resp = l_return_resp + l_response_msg;
					if (l_debug_YN.equals("Y")) System.out.println(l_return_resp);
				}
				
				conn.disconnect();
				l_out_JSON = XHJSONUtil.createJsonObject(l_return_resp);

				if (l_out_JSON.indexOf("Error") >= 0) {
					l_errcd = "E";
				}
			}
			catch (MalformedURLException e) 
			{
				l_errcd="E";
				e.printStackTrace();
				l_response_msg = "Error in "+ l_app_msg + " : " +  e.getMessage();
				System.out.println(" ::: MalformedURLException ::: " +l_response_msg);			
				return l_response_msg;
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
				l_errcd="E";
				l_response_msg = "Error in "+ l_app_msg + " : " +  e.getMessage();
				System.out.println(" ::: IOException ::: " +l_response_msg);			
				return l_response_msg;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				l_errcd="E";
				l_response_msg = "Error in "+ l_app_msg + " : " +  e.getMessage();
				System.out.println(" ::: Exception ::: " +l_response_msg);
				return l_response_msg;
			}
			finally {
				//XHUtil.closeDBResources(rs, pstmt, dbConn);		
				XHUtil.closeDBResources(rs, pstmt, null);
				EMDataSource.returnConnection(dbConn);
			}
			l_app_msg = " ::: Response... "+l_return_resp;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			return l_return_resp;
		}
		
		public CLOB stringToClob(String stringData, Connection dbConn) 
		{
	        CLOB clob = null;

	        try 
			{
	            clob = oracle.sql.CLOB.createTemporary(dbConn, false, CLOB.DURATION_SESSION);
	            clob.setString(1, stringData);
	        } catch (SQLException sqlException) {
	            System.out.println("Exception thrown in stringtoClob function : SQL Exception : " + sqlException.getMessage());
	        }
	 
	        return clob;
		}
		private String updateMessageDetails(String protocolLinkID, String actionKey,String message){
			String l_app_msg,l_errmsg ="";
			Connection dbConn = null;
			ResultSet rs=null;
			PreparedStatement pstmt = null;
			
			oracle.sql.CLOB msg_clob = null;
			
			int count=0,insert_count =0,update_count = 0;
			
			String l_response_str = "";
			
			String query = "";
			String l_request_date = "";
			java.sql.Timestamp sqlDate = null;
			String l_application_id ="", l_event_type ="",l_facility_id ="",l_msg_id ="",l_protocol_link ="";
			String l_added_id = "",l_added_wsno = "",l_added_facility_id= "",l_status = "",l_out_JSON = "";
			
			l_app_msg = " ::: Fetching Application ID... ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			l_application_id= FetchFieldValue(actionKey, "<APPLICATION_ID>", null, l_field_separator, "ProcessRequest");
			if (l_application_id.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_application_id;
			}
			l_app_msg = " ::: Application Id... "+l_application_id;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			l_app_msg = " ::: Fetching Event Type... ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_event_type = FetchFieldValue(actionKey, "<EVENT_TYPE>", null, l_field_separator, "ProcessRequest");
			if (l_event_type.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_event_type;
			}
			l_app_msg = " ::: Event type... "+l_event_type;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			l_app_msg = " ::: Fetching Facility ID... ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_facility_id = FetchFieldValue(actionKey, "<FACILITY_ID>", null, l_field_separator, "ProcessRequest");
			if (l_facility_id.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_facility_id;
			}
			l_app_msg = " ::: Facility Id... "+l_facility_id;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			l_app_msg = " ::: Fetching Message ID... ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_msg_id = FetchFieldValue(actionKey, "<MESSAGE_ID>", null, l_field_separator, "ProcessRequest");
			if (l_msg_id.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_msg_id;
			}
			l_app_msg = " ::: Message Id... "+l_msg_id;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			l_app_msg = " ::: Fetching Protocol Link... ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_protocol_link = FetchFieldValue(actionKey, "<PROTOCOL_LINK>", null, l_field_separator, "ProcessRequest");
			if (l_protocol_link.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_protocol_link;
			}
			l_app_msg = " ::: Protocol link... "+l_protocol_link;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			l_app_msg = " ::: Fetching Added by Id... ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_added_id = FetchFieldValue(actionKey, "<ADDED_BY_ID>", null, l_field_separator, "ProcessRequest");
			if (l_added_id.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_added_id;
			}
			l_app_msg = " ::: Added Id... "+l_added_id;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			l_app_msg = " ::: Fetching Added WSNO... ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_added_wsno = FetchFieldValue(actionKey, "<ADDED_AT_WS_NO>", null, l_field_separator, "ProcessRequest");
			if (l_added_wsno.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_added_wsno;
			}
			l_app_msg = " ::: Added Workstation number... "+l_added_wsno;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			l_app_msg = " ::: Fetching Added facility Id... ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_added_facility_id = FetchFieldValue(actionKey, "<ADDED_FACILITY_ID>", null, l_field_separator, "ProcessRequest");
			if (l_added_facility_id.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_added_facility_id;
			}
			l_app_msg = " ::: Added Facility Id... "+l_added_facility_id;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			l_request_date = getFormattedStringDate("dd/MMM/yyyy HH:mm:ss", new java.util.Date());

			try
			{
				Date d = new SimpleDateFormat("dd/MMM/yyyy HH:mm:ss").parse(l_request_date);
				sqlDate = new java.sql.Timestamp(d.getTime());
			}
			catch (Exception e)
			{
				l_errcd = "E";						
				l_errmsg = "Error in "+ l_app_msg + " : " +  e.getMessage();
				return l_errmsg;
			}

			
			try{
				dbConn =  EMDataSource.getConnection();
				//dbConn =  EMDBConnectionPool.getConnection();
				
				query = "select count(*) COUNT from XH_APPLICATION_MESSAGE"
				         + " where APPLICATION_ID = ? "
				         + " and MESSAGE_ID = ? "
				         + " and FACILITY_ID = ?"
				         + " and EVENT_TYPE = ?"
				         + " and PROTOCOL_LINK_ID = ?";
				         
				pstmt = dbConn.prepareStatement(query);
				pstmt.setString(1, l_application_id);
				pstmt.setString(2, l_msg_id);
				pstmt.setString(3, l_facility_id);
				pstmt.setString(4, l_event_type);
				pstmt.setString(5, l_protocol_link);
				
				rs = pstmt.executeQuery();
				while(rs.next()){
					count = rs.getInt("COUNT");
				}
				
				l_app_msg = " ::: count : "+count;
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				
				if(count<1){
					l_app_msg = " ::: Inserting into Application message table... ";
					if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
					
		            
		            msg_clob = stringToClob(message,dbConn);
		            
					query = "INSERT into XH_APPLICATION_MESSAGE (APPLICATION_ID, MESSAGE_ID, FACILITY_ID, MESSAGE_DATE, EVENT_TYPE, "
							+ " MESSAGE_TEXT, ADDED_BY_ID, ADDED_DATE, MODIFIED_BY_ID, MODIFIED_DATE, ADDED_AT_WS_NO,"
							+ " ADDED_FACILITY_ID, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, PROTOCOL_LINK_ID)"
							+ " Values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
					pstmt = dbConn.prepareStatement(query);
					pstmt.setString(1, l_application_id);
					pstmt.setString(2, l_msg_id);
					pstmt.setString(3, l_facility_id);
					pstmt.setTimestamp(4, sqlDate);
					pstmt.setString(5, l_event_type);
					pstmt.setClob(6, msg_clob);
					pstmt.setString(7, l_added_id);
					pstmt.setTimestamp(8, sqlDate);
					pstmt.setString(9, l_added_id);
					pstmt.setTimestamp(10, sqlDate);
					pstmt.setString(11, l_added_wsno);
					pstmt.setString(12, l_added_facility_id);
					pstmt.setString(13, l_added_wsno);
					pstmt.setString(14, l_added_facility_id);
					pstmt.setString(15, l_protocol_link);

					insert_count = pstmt.executeUpdate();	 	
						
					if (insert_count == 1)
					{
						dbConn.commit();								
						l_errmsg = "Application Message table inserted successfully ";
						return l_errmsg;
					}
					else
					{
						dbConn.rollback();	
						l_errcd = "E";
						l_errmsg = " Error in inserting Application Message table ";	
						return l_errmsg;
					}
				}
				else{
					l_out_JSON = XHJSONUtil.createJsonObject(message);
					
					l_app_msg = " Response JSON... "+l_out_JSON;
					if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
					
					if(!(l_event_type.equals("OA26")))
					{						
						if (l_out_JSON.indexOf("Error") >= 0) {
								l_errcd = "E";						
						}				
						else{
							
							if (!(l_event_type.equals("OA25")) && !(l_event_type.equals("OA27")))
								l_status = XHJSONUtil.getJsonRequestString(l_out_JSON, "status");
							else
							{
								l_response_str = XHJSONUtil.getJsonChild(l_out_JSON, "meta");
								l_status = XHJSONUtil.getJsonRequestString(l_response_str, "status");
							}
							l_app_msg = " Status... "+l_status;
							if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
							
							if(l_status.equals("1")){
								l_errcd = "S";
							}
							else if(l_status.equals("0"))
							{
								l_errcd = "E";
							}
							else{
								l_out_JSON = XHJSONUtil.createJsonObject(l_status);
								l_app_msg = " Response JSON... "+l_out_JSON;
								if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
								
								if(l_out_JSON.indexOf("Error") >= 0){
									l_errcd = "E";
								}
								else
								{
									l_status = XHJSONUtil.getJsonRequestString(l_out_JSON, "response_code");
									l_app_msg = " Status... "+l_status;
									if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
									
									if(l_status.equals("200")){
										l_errcd = "S";
									}
									else{
										l_errcd = "E";
									}
								}		
							}
											
						}
					}
					l_app_msg = " ::: Updating into Application message table... l_status :: "+l_errcd;
					if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);					
		            
		            msg_clob = stringToClob(message,dbConn);
					query = "UPDATE XH_APPLICATION_MESSAGE SET "
							+ " STATUS_TEXT = ? ,"
							+ " MESSAGE_STATUS = ? ,"
							+ " MODIFIED_BY_ID = ?,"
							+ " MODIFIED_DATE = ?,"
							+ " MODIFIED_AT_WS_NO = ?,"
							+ " MODIFIED_FACILITY_ID = ? "
							+ " where APPLICATION_ID = ? "
							+ " and MESSAGE_ID = ? "
							+ " and FACILITY_ID = ?"
							+ " and EVENT_TYPE = ?"
							+ " and PROTOCOL_LINK_ID = ?";
					
					
					pstmt = dbConn.prepareStatement(query);
					pstmt.setString(1, message);
					pstmt.setString(2, l_errcd);
					pstmt.setString(3, l_added_id);
					pstmt.setTimestamp(4, sqlDate);
					pstmt.setString(5, l_added_wsno);
					pstmt.setString(6, l_added_facility_id);

					pstmt.setString(7,l_application_id);
					pstmt.setString(8, l_msg_id);
					pstmt.setString(9, l_facility_id);
					pstmt.setString(10, l_event_type);
					pstmt.setString(11, l_protocol_link);
					
					update_count = pstmt.executeUpdate();	 	
						
					if (update_count == 1)
					{
						dbConn.commit();								
						l_errmsg = "Application Message table updated successfully ";
						return l_errmsg;
					}
					else
					{
						dbConn.rollback();	
						l_errcd = "E";
						l_errmsg = " Error in updating Application Message table ";		
						return l_errmsg;
					}
				}
			}
			catch(Exception e)
			{
				try {
					dbConn.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
				l_errcd = "E";
				l_errmsg = "Error in "+ l_app_msg + " : " +  e.getMessage();	
				return l_errmsg;
			}
			finally {
				//XHUtil.closeDBResources(rs, pstmt, dbConn);	
				XHUtil.closeDBResources(rs, pstmt, null);
				EMDataSource.returnConnection(dbConn);
			}	
		}
		
		private static String getFormattedStringDate(String format,Date date)
	    {	
			SimpleDateFormat dateFormat = new SimpleDateFormat(format);
			dateFormat.setTimeZone(TimeZone.getTimeZone("IST"));
			String dateFormatted = dateFormat.format(date);
			return dateFormatted;
	    }

    
    
}  


