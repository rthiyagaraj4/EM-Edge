package eXH;

import java.sql.SQLException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.text.*;
import java.util.*;

import java.io.BufferedReader;
import java.io.*;

import javax.xml.parsers.*;
import org.xml.sax.InputSource;
import org.w3c.dom.*;
import oracle.sql.CLOB;

import webbeans.eCommon.ConnectionManager;

public class EClaimsERATransaction 
{

	//Class variables 
	public static final String l_field_separator= "$!^";

	public static String l_debug_YN = "N";
    
	public String l_errcd = "S";
    public String l_errmsg = "";
    public String l_ack_text = "";	
    public String l_errorCode = "";

	public String l_item_no = "";
	
	static boolean stopRequested = false;

	public String ProcessRequest(String profileId, String applicationId, String actionKey){
		String l_app_msg = "";
		String l_request = "", l_request_type = "", l_response_str = "";

		Connection dbConn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;

		String query = "", l_debug_yn = "";

		l_app_msg = " ::: Inside ProcessRequest ::: ";
		System.out.println(l_app_msg);		
		System.out.println("::: actionKey : "+actionKey);
		try
		{
			dbConn =  ConnectionManager.getConnection();
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
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + e.getMessage() ;
		}	

		l_app_msg = " ::: Fetching Request... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_request = FetchFieldValue(actionKey, "<REQUEST>", null, l_field_separator, "ProcessRequest");
		if (l_request.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_request;
		}
		l_app_msg = " ::: l_request : "+l_request;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_app_msg = " ::: Fetching Request Type... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_request_type = FetchFieldValue(actionKey, "<REQUEST_TYPE>", null, l_field_separator, "ProcessRequest");
		if (l_request_type.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_request_type;
		}
		l_app_msg = " ::: l_request_type : "+l_request_type;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		
		if (l_request_type.equals("ERARES"))
		{
			l_response_str = FetchERAXmlFile(profileId, applicationId, actionKey);
		}

		return l_response_str;

	}

	public String FetchERAXmlFile(String profileId, String applicationId, String actionKey){
		String l_app_msg = "";
		String l_trans_value = "", l_action_key = "";

		String l_empty_str = "";

		String l_request = "", l_request_type = "", l_user_id = "", l_facility_id = "",  l_wca_num = "";

		String l_response_msg = "", l_response_return = "";

		String l_request_date = "", l_file_name = "", l_file_directory = "";

		String l_workstation_id = "";

		String l_interactive_log = "";

		String l_response_status = "", l_response_file_type = "", l_response = "";

		java.sql.Timestamp sqlDate = null;

		Connection dbConn = null;

		HashMap reqParams = null;

		l_action_key = actionKey;
			
		l_app_msg = "Inside FetchERAXmlFile...";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_app_msg = " ::: Fetching Request... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_request = FetchFieldValue(actionKey, "<REQUEST>", null, l_field_separator, "FetchERAXmlFile");
		if (l_request.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_request;
		}
		l_app_msg = " ::: l_request : "+l_request;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_app_msg = " ::: Fetching Request Type... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_request_type = FetchFieldValue(actionKey, "<REQUEST_TYPE>", null, l_field_separator, "FetchERAXmlFile");
		if (l_request_type.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_request_type;
		}
		l_app_msg = " ::: l_request_type : "+l_request_type;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);		
		
		l_app_msg = " ::: Fetching User ID ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_user_id = FetchFieldValue(actionKey,"<USER>",null,l_field_separator, "FetchERAXmlFile");
		if (l_user_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_user_id;
		}
		l_app_msg = " ::: l_user_id : "+l_user_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = " ::: Fetching Workstation ID ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_workstation_id = FetchFieldValue(actionKey,"<WS_NO>",null,l_field_separator, "FetchERAXmlFile");
		if (l_workstation_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_workstation_id;
		}
		l_app_msg = " ::: l_workstation_id : "+l_workstation_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = " ::: Fetching Facility ID ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_facility_id = FetchFieldValue(actionKey,"<FACILITY_ID>",null,l_field_separator, "FetchERAXmlFile");
		if (l_facility_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_facility_id;
		}
		l_app_msg = " ::: l_facility_id : "+l_facility_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_file_directory = FetchFieldValue(actionKey,"<FILE_DIR>",null,l_field_separator, "FetchERAXmlFile");
		if (l_file_directory.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_file_directory;
		}
		l_app_msg = " ::: l_file_directory : "+l_file_directory;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_file_name = FetchFieldValue(actionKey,"<FILE_NAME>",null,l_field_separator, "FetchERAXmlFile");
		if (l_file_name.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_file_name;
		}
		l_app_msg = " ::: l_file_name : "+l_file_name;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	


		l_app_msg = "Generating Transaction id...";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		if (l_errcd.equals("S"))
		{
			l_trans_value = GenerateTransIDMethod("XF_ECLAIMS_SEQ");
			if (l_trans_value.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_trans_value;
			}
			l_app_msg = "::: l_trans_value : "+l_trans_value;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	


			if (l_trans_value.length() > 0 )
			{
			}	
		}

		l_action_key = l_action_key.replaceAll("<TRANS_ID>XXX","<TRANS_ID>"+l_trans_value);

		l_app_msg = " ::: After replacing Trans ID ::: "+l_action_key;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

		l_app_msg = "Getting Formatted l_request_date value...";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);		

		l_request_date = getFormattedStringDate("dd/MMM/yyyy HH:mm:ss", new java.util.Date());

		try
		{
			Date d = new SimpleDateFormat("dd/MMM/yyyy HH:mm:ss").parse(l_request_date);
			sqlDate = new java.sql.Timestamp(d.getTime());
		}
		catch (Exception e)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + " - "+ e.getMessage();
		    l_app_msg = "::: l_errmsg : "+l_errmsg;
		    if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		}

		l_app_msg = "::: l_request_date : "+sqlDate;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = "Setting  reqParams value...";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		try
		{
			reqParams = new HashMap();
			reqParams.put("LOGIN_USER", l_user_id);
			reqParams.put("CLIENT_MACHINE", l_workstation_id); 
			reqParams.put("PGM_ID", "ECLAIMS");
			reqParams.put("MODULE_ID", "XB");
			reqParams.put("SESSION_ID", l_request_type);

			reqParams.put("MSG_ID", l_trans_value);
			reqParams.put("REQUEST_DATE", sqlDate); 
			reqParams.put("REQUEST_TEXT", "XXX");
			reqParams.put("APPLICATION_ID", "ECLAIMS");
			reqParams.put("FACILITY_ID", l_facility_id);
			reqParams.put("MESSAGE_DATE", sqlDate); 
			reqParams.put("EVENT_TYPE", l_request);
			reqParams.put("PATIENT_ID", l_empty_str);
			reqParams.put("EPISODE_TYPE", l_empty_str);
			reqParams.put("ENCOUNTER_ID", l_empty_str);
			reqParams.put("EPISODE_ID", l_empty_str);
			reqParams.put("VISIT_ID", l_empty_str);			
			reqParams.put("ACC_NO", actionKey);
			reqParams.put("EXT_ACC_NO", "XXX");
			reqParams.put("REQUEST_SYNTAX", actionKey);
			reqParams.put("ACK_MSG_ID", "XXX");
			reqParams.put("PROTOCOL_LINK_ID", "ECLAIMSERA");
			reqParams.put("ADDED_BY_ID", l_user_id); 
			reqParams.put("ADDED_BY_DATE", sqlDate); 
			reqParams.put("MODIFIED_BY_ID", l_user_id); 
			reqParams.put("MODIFIED_BY_DATE", sqlDate); 
			reqParams.put("ADDED_BY_FACILITY", l_facility_id);
			reqParams.put("MODIFIED_BY_FACILITY", l_facility_id);
			reqParams.put("RESPONSE_TEXT", "XXX"); 
			reqParams.put("RESPONSE_SYNTAX", "XXX");
			reqParams.put("PROFILE", profileId); 
			reqParams.put("ERROR_MESSAGE", l_empty_str); 
			reqParams.put("ACK_TEXT", "XXX");
			reqParams.put("ACK_SYNTAX", "XXX");
			reqParams.put("CUST_CODE", l_empty_str);
			reqParams.put("DEST_CODE", l_empty_str);
			reqParams.put("MEMBER_ID", l_empty_str);
			reqParams.put("DEPD_CODE", l_empty_str);
			reqParams.put("DEPD_RELN", l_empty_str);
			reqParams.put("DEST_CD", l_empty_str);
			reqParams.put("BILL_DOC_TYPE_CODE", l_empty_str);
			reqParams.put("BILL_DATE", l_empty_str);
			reqParams.put("BILL_DOC_NO", l_empty_str);			
			reqParams.put("CASE_NUM", l_empty_str);
			reqParams.put("CLAIM_NUM", l_empty_str);
			reqParams.put("AUTHORIZATION_NUM", l_empty_str);
			if (!(l_wca_num.length() > 0))
			{
				l_wca_num = "XXX";
			}
			reqParams.put("WCA_NUM", l_empty_str);
			reqParams.put("PATIENT_ID_NUM", l_empty_str);
		}
		catch (Exception e)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + " - "+ e.getMessage();
		}		

		reqParams.put("INPUT_FILE_NAME", l_file_name);		

		try
		{	
			l_app_msg = "Inserting Interface Audit data...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			
			l_interactive_log = UpdateInteractiveDetails(reqParams);
			if (l_interactive_log.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_interactive_log;
			}

			l_app_msg = " ::: l_interactive_log : "+l_interactive_log;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		}
		catch (Exception e)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + " - "+ e.getMessage();
		}	

		l_response_return = l_errmsg;

		reqParams.put("FILE_NAME_FOR_NRL_RESP", "XXX");
		reqParams.put("INBOUND_XML_REPLY", "XXX");
		reqParams.put("ERAHEADERSTATUS", "XXX");
		reqParams.put("ERASCHEMESTATUS", "XXX");
		reqParams.put("ERACLAIMSTATUS", "XXX");
		
		if (l_errcd.equals("S"))
		{		

			l_app_msg = "Calling GetResponseMessage...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_app_msg = "l_file_directory ::: "+l_file_directory+" : "+l_file_name;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_response_msg = GetResponseMessage(l_file_directory, l_file_name);
			l_response_msg = l_response_msg.trim();
			if (l_response_msg.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_response_msg;
			}
			
			l_app_msg = "::: Getting Response Message : ::: l_errcd : "+l_errcd;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_app_msg = " ::: Fetching Status... ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_response_status = FetchFieldValue(l_response_msg, "<STATUS>", null, l_field_separator, "GenerateClaimsRequestXML");
			if (l_response_status.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_response_status;
			}
			l_app_msg = " ::: l_response_status : "+l_response_status;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_app_msg = " ::: Fetching Response File Type... ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_response_file_type = FetchFieldValue(l_response_msg, "<FILE_TYPE>", null, l_field_separator, "GenerateClaimsRequestXML");
			if (l_response_file_type.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_response_file_type;
			}
			l_app_msg = " ::: l_response_file_type : "+l_response_file_type;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);


			l_response = FetchFieldValue(l_response_msg, "<RESPONSE>", null, l_field_separator, "FetchERAXmlFile");
			l_response = l_response.trim();
			if (l_response.indexOf("Error in")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_response;

			}
			//l_app_msg = " ::: l_response : "+l_response;
			//if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);		

			reqParams.put("REQUEST_STATUS", l_response_status);				
			
			reqParams.put("FILE_NAME_FOR_NRL_RESP", l_file_directory +File.separator+l_file_name);
			reqParams.put("INBOUND_XML_REPLY", l_response);						

			reqParams.put("RESPONSE_TEXT", l_response);					
			if (l_response_status.equals("F"))
			{
				reqParams.put("TRANS_STATUS", "99");
			}			
		}

		l_response_return = l_errmsg;

		if (l_errcd.equals("S"))
		{
			if (l_response_status.equals("S"))
			{		
				l_response = FetchResponseMessage(l_file_directory, l_file_name);

				l_app_msg = " ::: l_response.length()... "+l_response.length();
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

				dbConn =  ConnectionManager.getConnection();

				if (l_response.length() > 0)
				{				
					l_app_msg = " ::: Calling ParseERAHeader... ";
					if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

					reqParams = ParseERAHeader(l_response, reqParams, dbConn);	

					l_app_msg = " ::: reqParams.get(ERAHEADERSTATUS).toString()... "+reqParams.get("ERAHEADERSTATUS").toString();
					if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				
					if (reqParams.get("ERAHEADERSTATUS").toString().equals("S"))
					{
						l_errcd = "S";				
						l_response_return = l_errcd + "$!^" + reqParams.get("ERA_NUMBER") + "$!^" + "S"+ "$!^" + "$!^ "+ reqParams.get("ERA_NUMBER");
						reqParams.put("ACKNOWLEDGEMENT_TEXT", l_response_return);

						reqParams = parseSchemeERAXml(l_response, reqParams, dbConn);
					}

					l_app_msg = " ::: reqParams.get(ERAHEADERSTATUS).toString()... "+reqParams.get("ERAHEADERSTATUS").toString();
					if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

					if (reqParams.get("ERAHEADERSTATUS").toString().equals("S"))
					{
						l_errcd = "S";				
						l_response_return = l_errcd + "$!^" + reqParams.get("ERA_NUMBER") + "$!^" + "S"+ "$!^" + "$!^ "+ reqParams.get("ERA_NUMBER");
						reqParams.put("ACKNOWLEDGEMENT_TEXT", l_response_return);

						reqParams = parseClaimXml(l_response, reqParams, dbConn);
					}

					try
					{
						if (l_errcd.equals("S"))
						{
							dbConn.commit();							
						}
						else
							dbConn.rollback();
					}
					catch (Exception e)
					{
						e.printStackTrace();
					}
					finally
					{			
						closeDBResources(null, null, dbConn);			
					}	
					
					l_app_msg = " ::: Error Code Before Process ERA ::: "+l_errcd+ " ::: Error Message ::: "+l_errmsg;
					if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
					
					
					l_app_msg = " ::: reqParams.get(ERAHEADERSTATUS) ::: "+reqParams.get("ERAHEADERSTATUS").toString();
					if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

					if (reqParams.get("ERAHEADERSTATUS").toString().equals("E"))
					{
						l_errcd = "E";
						l_errmsg = l_errcd + "$!^" +  reqParams.get("ERA_NUMBER") + "$!^" + "Error" + "$!^" + reqParams.get("HEADERSTATUSMESSAGE").toString()+"$!^";
						l_response_return = l_errmsg;
						reqParams.put("ACKNOWLEDGEMENT_TEXT", l_errmsg);

						l_app_msg = " ::: l_response_return... "+l_response_return;
						if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
					}	

					l_app_msg = " ::: reqParams.get(ERASCHEMESTATUS) ::: "+reqParams.get("ERASCHEMESTATUS").toString();
					if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
					if (reqParams.get("ERASCHEMESTATUS").toString().equals("E"))
					{
						l_errcd = "E";
						l_errmsg = l_errcd + "$!^" +  reqParams.get("ERA_NUMBER") + "$!^" + "Error" + "$!^" + reqParams.get("ERASCHEMESTATUSMESSAGE").toString()+"$!^";
						l_response_return = l_errmsg;
						reqParams.put("ACKNOWLEDGEMENT_TEXT", l_errmsg);
						l_app_msg = " ::: l_response_return... "+l_response_return;
						if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
					}
					
					l_app_msg = " ::: reqParams.get(ERACLAIMSTATUS) ::: "+reqParams.get("ERACLAIMSTATUS").toString();
					if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
					if (reqParams.get("ERACLAIMSTATUS").toString().equals("E"))
					{
						l_errcd = "E";
						l_errmsg = l_errcd + "$!^" +  reqParams.get("ERA_NUMBER") + "$!^" + "Error" + "$!^" + reqParams.get("ERACLAIMSTATUSMESSAGE").toString()+"$!^";
						l_response_return = l_errmsg;
						reqParams.put("ACKNOWLEDGEMENT_TEXT", l_errmsg);
						l_app_msg = " ::: l_response_return... "+l_response_return;
						if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
					}	
					
					if (reqParams.get("ERAHEADERSTATUS").toString().equals("S"))
					{
						l_errcd = "S";
						l_errmsg = l_errcd + "$!^" +  reqParams.get("ERA_NUMBER") + "$!^" + "Success" + "$!^" + reqParams.get("HEADERSTATUSMESSAGE").toString()+"$!^";
						l_response_return = l_errmsg;
						reqParams.put("ACKNOWLEDGEMENT_TEXT", l_errmsg);

						l_app_msg = " ::: l_response_return... "+l_response_return;
						if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
					}	

					l_app_msg = " ::: reqParams.get(ERASCHEMESTATUS) ::: "+reqParams.get("ERASCHEMESTATUS").toString();
					if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
					if (reqParams.get("ERASCHEMESTATUS").toString().equals("S"))
					{
						l_errcd = "S";
						l_errmsg = l_errcd + "$!^" +  reqParams.get("ERA_NUMBER") + "$!^" + "Success" + "$!^" + reqParams.get("ERASCHEMESTATUSMESSAGE").toString()+"$!^";
						l_response_return = l_errmsg;
						reqParams.put("ACKNOWLEDGEMENT_TEXT", l_errmsg);
						l_app_msg = " ::: l_response_return... "+l_response_return;
						if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
					}
					
					l_app_msg = " ::: reqParams.get(ERACLAIMSTATUS) ::: "+reqParams.get("ERACLAIMSTATUS").toString();
					if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
					if (reqParams.get("ERACLAIMSTATUS").toString().equals("S"))
					{
						l_errcd = "S";
						l_errmsg = l_errcd + "$!^" +  reqParams.get("ERA_NUMBER") + "$!^" + "Success" + "$!^" + reqParams.get("ERACLAIMSTATUSMESSAGE").toString()+"$!^";
						l_response_return = l_errmsg;
						reqParams.put("ACKNOWLEDGEMENT_TEXT", l_errmsg);
						l_app_msg = " ::: l_response_return... "+l_response_return;
						if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
					}

					l_app_msg = " ::: Error Code before Move File ::: "+l_errcd+ " ::: Error Message ::: "+l_errmsg;
					if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
					
					if (l_errcd.equals("S"))
					{
						/// To move the files Sethu here.
						doMove(l_file_directory,l_file_name);
					}
					
				}
			}
		}

        l_app_msg = " ::: ERROR_MESSAGE... "+l_errmsg;
	    if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		reqParams.put("STATUS", l_errcd);	
		reqParams.put("ERROR_MESSAGE", l_errmsg);

		l_app_msg = "Updating Interface Audit data...";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		
		l_interactive_log = UpdateInteractiveDetails(reqParams);
		if (l_interactive_log.indexOf("Error")>=0)
		{
			l_errcd = "E";
		}

		l_app_msg = "Updating Interface Audit data.l_interactive_log ..."+l_interactive_log;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

		l_app_msg = "::: Response Returned : "+l_response_return;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);		
		reqParams.clear();
		

		return l_response_return;		
	}		

	public HashMap ParseERAHeader(String xml, Map params, Connection conn)
	{

		String l_app_msg = "";

		Connection dbConn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;

		String l_insert_stmt = "";

		int l_insert_count = 0;

		String l_era_nbr = "", l_era_date = "", l_hospital_nbr = "", l_hospital_name = "", l_scheme_name = "", l_scheme_code = "";
		String l_era_trans_nbr = "", l_era_trans_date = "", l_era_type = "";

		String l_prov_paid_amount = "0.00", l_pat_paid_amount = "0.00", l_member_liability = "0.00", l_actual_amount_paid = "0.00", l_amount_not_paid = "0.00";
		String l_paid_date = "", l_paid_ref_nbr = "", l_bank_name = "", l_bank_branch_code = "", l_account_nbr = "", l_account_name = "", l_account_type = "";
		
		String l_return_str = "";

		l_app_msg = " ::: Inside ParseERAResponseHeader... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		HashMap reqParam = null;

		SimpleDateFormat sdf;

		java.sql.Timestamp l_current_date = null;

		boolean l_era_flag = false;


		try
		{
			sdf = new SimpleDateFormat("yyyy-MM-dd");

			l_current_date = new java.sql.Timestamp(System.currentTimeMillis());
				
			l_app_msg = " ::: l_current_date : "+l_current_date;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			reqParam = new HashMap(params);

			l_era_nbr = parseResponseXml(xml, "File", "MkEraNbr", "true");
			l_app_msg = " ::: ERA Number ::: "+l_era_nbr;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			reqParam.put("ERA_NUMBER", l_era_nbr);

			l_era_flag = CheckForERADetails(l_era_nbr);

			if (l_era_flag)
			{
				reqParam.put("ERAHEADERSTATUS", "E");
				l_return_str = "ERA file with the ERA Number : "+l_era_nbr+ " has been processed already, cannot be processed again.";
				reqParam.put("HEADERSTATUSMESSAGE", l_return_str);

				return reqParam;
			}

			l_era_date = parseResponseXml(xml, "File", "MkEraDate", "true");
			l_app_msg = " ::: ERA Date ::: "+l_era_date;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			reqParam.put("ERA_DATE", l_era_date);
			
			l_hospital_nbr = parseResponseXml(xml, "BillingProvider", "Number", "true");
			l_app_msg = " ::: Hospital Provider Number ::: "+l_hospital_nbr;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			reqParam.put("HOSP_NO", l_hospital_nbr);

			l_hospital_name = parseResponseXml(xml, "BillingProvider", "Name", "true");
			l_app_msg = " ::: Hospital Name ::: "+l_hospital_name;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			reqParam.put("HOSP_NAME", l_hospital_name);

			l_scheme_name = parseResponseXml(xml, "Scheme", "Name", "true");
			l_app_msg = " ::: Scheme Name ::: "+l_scheme_name;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			reqParam.put("SCHEME_NAME", l_scheme_name);

			l_scheme_code = parseResponseXml(xml, "Scheme", "Code", "true");
			l_app_msg = " ::: Scheme Code ::: "+l_scheme_code;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			reqParam.put("SCHEME_CODE", l_scheme_code);

			l_era_trans_nbr = parseResponseXml(xml, "EraIdentifiers", "Number", "true");
			l_app_msg = " ::: ERA IDENTIFIER ::: "+l_era_trans_nbr;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			reqParam.put("ERA_ID", l_era_trans_nbr);

			l_era_trans_date = parseResponseXml(xml, "EraIdentifiers", "Date", "true");
			l_app_msg = " ::: ERA IDENTIFIER Date ::: "+l_era_trans_date;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			reqParam.put("ERA_TRANS_DATE", l_era_trans_date);

			l_era_type = parseResponseXml(xml, "EraIdentifiers", "Type", "true");
			l_app_msg = " ::: ERA TYPE ::: "+l_era_type;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			reqParam.put("ERA_TYPE", l_era_type);

			l_prov_paid_amount = parseResponseXml(xml, "Financial", "TotalPaidProvider", "true");
			l_app_msg = " ::: Prov Paid Amount ::: "+l_prov_paid_amount;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			reqParam.put("PROV_PAID_AMT", l_prov_paid_amount);

			l_pat_paid_amount = parseResponseXml(xml, "Financial", "TotalPaidMember", "true");
			l_app_msg = " ::: Patient Paid Amount ::: "+l_pat_paid_amount;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			reqParam.put("PAT_PAID_AMT", l_pat_paid_amount);

			l_member_liability = parseResponseXml(xml, "Financial", "TotalMemberLiability", "true");
			l_app_msg = " ::: Memeber Liability ::: "+l_member_liability;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			reqParam.put("MEM_LIAB", l_member_liability);

			l_actual_amount_paid = parseResponseXml(xml, "Financial", "ACB", "true");
			l_app_msg = " ::: Actual Amount Paid ::: "+l_actual_amount_paid;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			reqParam.put("ACT_AMT_PAID", l_actual_amount_paid);

			l_amount_not_paid = parseResponseXml(xml, "Financial", "MkEraDate", "true");
			l_app_msg = " ::: Amount Not paid ::: "+l_amount_not_paid;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			reqParam.put("AMT_NOT_PAID", l_amount_not_paid);

			l_paid_date = parseResponseXml(xml, "PaymentDetails", "PaidDate", "true");
			l_app_msg = " ::: ERA Paid Date ::: "+l_paid_date;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			reqParam.put("ERA_PAID_DATE", l_paid_date);

			l_paid_ref_nbr = parseResponseXml(xml, "PaymentDetails", "PaymentReference", "true");
			l_app_msg = " ::: ERA Payment Reference ::: "+l_paid_ref_nbr;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			reqParam.put("ERA_PAY_REFERENCE", l_paid_ref_nbr);

			l_bank_name = parseResponseXml(xml, "Bank", "Name", "true");
			l_app_msg = " ::: Bank Name ::: "+l_bank_name;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			reqParam.put("BANK_NAME", l_bank_name);

			l_bank_branch_code = parseResponseXml(xml, "Bank", "BranchCode", "true");
			l_app_msg = " ::: Bank Branch Code ::: "+l_bank_branch_code;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			reqParam.put("BRANCH_CODE", l_bank_branch_code);

			l_account_nbr = parseResponseXml(xml, "Account", "Number", "true");
			l_app_msg = " ::: Account Number ::: "+l_account_nbr;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			reqParam.put("ACCOUNT_NBR", l_account_nbr);

			l_account_name = parseResponseXml(xml, "Account", "Name", "true");
			l_app_msg = " ::: Account Name ::: "+l_account_name;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			reqParam.put("ACCOUNT_NAME", l_account_name);

			l_account_type = parseResponseXml(xml, "Account", "Type", "true");
			l_app_msg = " ::: Account Type ::: "+l_account_type;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			reqParam.put("ACCOUNT_TYPE", l_account_type);

			l_app_msg = " ::: ADDED_BY_ID ::: "+XHDBAdapter.isNullReplace(reqParam.get("ADDED_BY_ID").toString(), reqParam.get("LOGIN_USER").toString());
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_app_msg = " ::: CLIENT_MACHINE ::: "+XHDBAdapter.isNullReplace(reqParam.get("CLIENT_MACHINE").toString(),"DFLT_WSNO");
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_app_msg = " ::: ADDED_BY_FACILITY ::: "+XHDBAdapter.isNullReplace(reqParam.get("ADDED_BY_FACILITY").toString(), reqParam.get("FACILITY_ID").toString());
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_app_msg = " ::: MODIFIED_BY_ID ::: "+XHDBAdapter.isNullReplace(reqParam.get("MODIFIED_BY_ID").toString(), reqParam.get("LOGIN_USER").toString());
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			

			l_insert_stmt = " INSERT INTO XF_ERA_HDR (MK_ERA_NO, MK_ERA_DATE, HOSP_NO, HOSP_NAME, SCHEME_NAME, SCHEME_CODE, "
							+"											ERA_TRANS_NO, ERA_TRANS_DATE, ERA_TYPE, "
							+"											PROV_PAID_AMOUNT, PAT_PAID_AMOUNT, MEMBER_LIABILITY, ACTUAL_AMOUNT_PAID, AMOUNT_NOT_PAID, "
							+"											AMOUNT_PAID_DATE, PAYMENT_REFERENCE, BANK_NAME, BRANCH_CODE, ACCOUNT_NO, ACCOUNT_NAME, ACCOUNT_TYPE, "
							+"											PROCESS_STATUS, PROCESS_ERROR_MESSAGE, "
							+"											ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) "
							+"								VALUES (?, ?, ?, ?, ?, ?, "
							+"										?, ?, ?, "
							+"										?, ?, ?, ?, ?, "
							+"										?, ?, ?, ?, ?, ?, ?, "
							+"										?, ?, "
							+"										?, ?, ?, ?, ?, ?, ?, ?)";

			if (l_debug_YN.equals("Y"))	System.out.println(" Inside Insert 1 ");

			//dbConn =  ConnectionManager.getConnection();

			dbConn =  conn;

			pstmt = dbConn.prepareStatement(l_insert_stmt);					
			pstmt.setString(1, l_era_nbr);
			if (l_debug_YN.equals("Y"))	System.out.println(" Inside Insert 1.2 ");
			pstmt.setDate(2, new java.sql.Date(sdf.parse(l_era_date).getTime()));
			if (l_debug_YN.equals("Y"))	System.out.println(" Inside Insert 1.3 ");
			pstmt.setString(3, l_hospital_nbr);
			pstmt.setString(4, l_hospital_name);
			pstmt.setString(5, l_scheme_name);
			pstmt.setString(6, l_scheme_code);
			pstmt.setString(7, l_era_trans_nbr);

			if (l_debug_YN.equals("Y"))	System.out.println(" Inside Insert 2 ");

			pstmt.setDate(8, new java.sql.Date(sdf.parse(l_era_trans_date).getTime()));
			pstmt.setString(9, l_era_type);
			pstmt.setString(10, l_prov_paid_amount);
			pstmt.setString(11, l_pat_paid_amount);
			pstmt.setString(12, l_member_liability);
			pstmt.setString(13, l_actual_amount_paid);
			pstmt.setString(14, l_amount_not_paid);

			if (l_debug_YN.equals("Y"))	System.out.println(" Inside Insert 3 ");

			pstmt.setDate(15, new java.sql.Date(sdf.parse(l_paid_date).getTime()));
			pstmt.setString(16, l_paid_ref_nbr);
			pstmt.setString(17, l_bank_name);
			pstmt.setString(18, l_bank_branch_code);
			pstmt.setString(19, l_account_nbr);
			pstmt.setString(20, l_account_name);
			pstmt.setString(21, l_account_type);
			pstmt.setString(22, l_account_type);
			pstmt.setString(23, l_account_type);

			if (l_debug_YN.equals("Y"))	System.out.println(" Inside Insert 4 ");

			pstmt.setString(24, XHDBAdapter.isNullReplace(reqParam.get("ADDED_BY_ID").toString(), reqParam.get("LOGIN_USER").toString()));
			pstmt.setTimestamp(25, l_current_date);
			pstmt.setString(26, XHDBAdapter.isNullReplace(reqParam.get("CLIENT_MACHINE").toString(),"DFLT_WSNO"));
			pstmt.setString(27, XHDBAdapter.isNullReplace(reqParam.get("ADDED_BY_FACILITY").toString(), reqParam.get("FACILITY_ID").toString()));
			
			pstmt.setString(28, XHDBAdapter.isNullReplace(reqParam.get("MODIFIED_BY_ID").toString(), reqParam.get("LOGIN_USER").toString()));
			pstmt.setTimestamp(29, l_current_date);	
			pstmt.setString(30, XHDBAdapter.isNullReplace(reqParam.get("CLIENT_MACHINE").toString(),"DFLT_WSNO"));
			pstmt.setString(31, XHDBAdapter.isNullReplace(reqParam.get("ADDED_BY_FACILITY").toString(), reqParam.get("FACILITY_ID").toString()));
			
			if (l_debug_YN.equals("Y"))	System.out.println(" Inside Insert 5 ");

			l_insert_count = pstmt.executeUpdate();

			if (l_debug_YN.equals("Y"))	System.out.println(" Inside Insert 6 ");
			
			if (l_insert_count == 1)
			{
				reqParam.put("ERAHEADERSTATUS", "S");
				l_return_str = "Successfully Inserted record in ERA Header for the ERA No : "+l_era_nbr;
				reqParam.put("HEADERSTATUSMESSAGE", l_return_str);
			}
			else
			{
				reqParam.put("ERAHEADERSTATUS", "E");
				l_return_str = "Error in inserting record in ERA Header for the ERA No : "+l_era_nbr;
				reqParam.put("HEADERSTATUSMESSAGE", l_return_str);
			}

			if (l_debug_YN.equals("Y"))	System.out.println(" Inside Insert 7 ");
			
			l_app_msg = " ::: INSERT XF_ERA_TRANS_HDR : MK_ERA_NO : "+l_era_nbr +" :: Insert Count :: " +l_insert_count;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			
		}
		catch (Exception e)
		{
			l_return_str = "Error in Inserting ERA Header for the ERA No : "+l_era_nbr+" ::: "+e.getMessage();
			reqParam.put("ERAHEADERSTATUS", "E");
			reqParam.put("HEADERSTATUSMESSAGE", l_return_str);

			if (l_debug_YN.equals("Y"))	System.out.println(l_return_str);
			
			e.printStackTrace();

			return reqParam;

		}
		finally
		{			
			closeDBResources(rs, pstmt, null);	
			reqParam.clear();
		}		

		
		return reqParam;
	}

	public static String parseResponseXml(String response, String elementname, String tagName, String tagFlag)
	{
		String nodeValue ="";
		String l_app_msg ="";
		String l_errcd ="S";
		String l_errmsg ="";
        try {		    

				DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
				dbf.setNamespaceAware(true);
				DocumentBuilder db = dbf.newDocumentBuilder();
				InputSource is = new InputSource();
				is.setCharacterStream(new StringReader(response));

				//Document document = db.parse(new File("D:\\Applications\\Sample\\ERA\\LDoH_MK_ERA_Sample.xml"));
                 
				Document document = db.parse(is);

				document.getDocumentElement().normalize();

				NodeList list = document.getElementsByTagNameNS("*",elementname);

				if (list.getLength() > 0)
				{
					Element e = (Element)list.item(0);

					if (tagFlag.equals("true"))
					{
						nodeValue = getString(tagName, e);
					}
					else
					{
						nodeValue = e.getAttribute(tagName);
						if (nodeValue != null)
							nodeValue = nodeValue;
						else
							nodeValue = "";
					}
				}			
              
				l_app_msg = " ::: Inside parseResponseXml : elementname : "+elementname+" tagName : "+tagName+ " : nodeValue : "+nodeValue;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			}
			catch (Exception e)
			{
				l_errcd = "E";
				l_errmsg = "Error in parsing request Xml : "+ e.getMessage();

				if (l_debug_YN.equals("Y")) System.out.println(l_errcd+" ::: "+l_errmsg);
			}

			if (l_errcd.equals("S"))
			{
				return nodeValue;
			}
			else
			{
				return l_errmsg;
			}
	}

	protected static String getString(String tagName, Element element) {
        NodeList list = element.getElementsByTagNameNS("*",tagName);
        if (list != null && list.getLength() > 0) {
            NodeList subList = list.item(0).getChildNodes();

            if (subList != null && subList.getLength() > 0) {
                return subList.item(0).getNodeValue();
            }
        }

        return null;
    }

	public HashMap parseSchemeERAXml(String response, Map params, Connection conn)
	{
		String l_app_msg = "";	

		Connection dbConn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;

		String l_insert_stmt = "";

		int l_insert_count = 0;

		String l_era_nbr = "";
		
		String l_adj_id = "", l_adj_ref = "", l_adj_date = "", l_adj_amt = "", l_adj_desc = "", l_bill_doc_type = "";

		int l_bill_doc_no = 0;

		String l_message_id = "", l_message_type = "", l_message_code = "", l_message_desc = "";

		int l_adj_count = 0;

		SimpleDateFormat sdf;

		HashMap reqParam = null;

		String nodeValue ="";

		try
		{
			reqParam = new HashMap(params);

			sdf = new SimpleDateFormat("yyyy-MM-dd");	
			
			//dbConn =  ConnectionManager.getConnection();

			dbConn = conn;
			
			l_era_nbr = parseResponseXml(response, "File", "MkEraNbr", "true");
			l_app_msg = " ::: ERA Number ::: "+l_era_nbr;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			dbf.setNamespaceAware(true);
			DocumentBuilder db = dbf.newDocumentBuilder();

			Document document = db.parse(new InputSource(new StringReader(response)));

			//Document doc = db.parse(new File("LDoH_MK_ERA_Sample.xml"));
			
			NodeList adjNodesList = document.getElementsByTagNameNS("*","Adjustment");

			if (adjNodesList != null)
			{
				l_adj_count = adjNodesList.getLength();

				l_app_msg = " ::: Adjustment NodesList Length ::: "+l_adj_count;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				if (l_adj_count>0)
				{
					for (int i = 0; i < adjNodesList.getLength(); i++) 
					{

						l_adj_id = ""; l_adj_ref = ""; l_adj_date = ""; l_adj_amt = ""; l_adj_desc = ""; l_bill_doc_type = ""; l_bill_doc_no = 0;


						if (adjNodesList.item(i).getNodeType() == Node.ELEMENT_NODE) 
						{
							Element el = (Element) adjNodesList.item(i);
							l_adj_id = el.getAttribute("id");
							l_app_msg = " :::  Adjustment ID Value : "+l_adj_id;
							if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
						}

						Node adjNode = (Node) adjNodesList.item(i);

						l_app_msg = " ::: adjNode.hasChildNodes() ::: "+adjNode.hasChildNodes();
						if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

						if (adjNode.hasChildNodes())
						{
							NodeList adjChildList = adjNode.getChildNodes();

							l_app_msg = " ::: Adjustment adjChildList Length ::: "+adjChildList.getLength();
							if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

							for(int j=0; j < adjChildList.getLength(); j++)
							{
								l_app_msg = " ::: adjChildList.item("+j+").getNodeName() ::: "+adjChildList.item(j).getNodeName()+ " ::: "+adjChildList.item(j).getNodeType();
								//if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

								nodeValue = "";

								if (adjChildList.item(j).getNodeType() == Node.ELEMENT_NODE)
								{	
									
									nodeValue = GetElementNodeValue(adjChildList, j);

									if (adjChildList.item(j).getNodeName().equals("era:Reference"))
									{
										l_adj_ref = nodeValue;
										l_app_msg = " ::: l_adj_ref ::: "+l_adj_ref;
										if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
									}
									if (adjChildList.item(j).getNodeName().equals("era:Date"))
									{
										l_adj_date = nodeValue;
										l_app_msg = " ::: l_adj_date ::: "+l_adj_date;
										if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
									}
									if (adjChildList.item(j).getNodeName().equals("era:Amt"))
									{
										l_adj_amt = nodeValue;
										l_app_msg = " ::: l_adj_amt ::: "+l_adj_amt;
										if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
									}
									if (adjChildList.item(j).getNodeName().equals("era:Description"))
									{
										l_adj_desc = nodeValue;
										l_app_msg = " ::: l_adj_desc ::: "+l_adj_desc;
										if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
									}																							
								}								
							}
							// Insert into XF_ERA_ADJ		
							
							if (l_adj_ref.length()>8)
							{
								l_bill_doc_type = l_adj_ref.substring(2,8);
								l_bill_doc_no = Integer.parseInt(l_adj_ref.substring(8));
							}	

							l_insert_stmt = " INSERT INTO XF_ERA_ADJ (MK_ERA_NO, ADJUSTMENT_ID, ADJUSTMENT_REF, ADJUSTMENT_DATE, ADJUSTMENT_AMOUNT, ADJUSTMENT_DESC, BILL_DOC_TYPE_CODE , BILL_DOC_NUMBER) "
												+"					  VALUES (?, ?, ?, ?, ?, ?, ?, ?) ";

							pstmt = dbConn.prepareStatement(l_insert_stmt);					
							pstmt.setString(1, l_era_nbr);
							pstmt.setString(2, l_adj_id);
							pstmt.setString(3, l_adj_ref);
							pstmt.setDate(4, new java.sql.Date(sdf.parse(l_adj_date).getTime()));
							pstmt.setDouble(5, Double.parseDouble(l_adj_amt));
							pstmt.setString(6, l_adj_desc);	
							pstmt.setString(7, l_bill_doc_type);	
							pstmt.setInt(8, l_bill_doc_no);	

							l_insert_count = pstmt.executeUpdate();

							l_app_msg = " ::: Insert into XF_ERA_ADJ Count ::: "+l_insert_count;
							if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
							
							for(int j=0; j < adjChildList.getLength(); j++)
							{
								if (!(adjChildList.item(j).getNodeName().equals("#text")))
								{
									l_message_id = ""; l_message_type = ""; l_message_code = ""; l_message_desc = "";
									///if (l_debug_YN.equals("Y")) System.out.println(adjChildList.item(j).getNodeName());
									if (adjChildList.item(j).getNodeName().equals("era:Message"))
									{
										
										if (adjChildList.item(j).getNodeType() == Node.ELEMENT_NODE) 
										{
											Element el = (Element) adjChildList.item(j);
											l_message_id = el.getAttribute("id");
											l_app_msg = " :::  Message ID Value : "+l_message_id;
											if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
										}

										Node adjMessageNode = (Node) adjChildList.item(j);

										if (adjMessageNode.hasChildNodes())
										{
											NodeList adjMessageList = adjMessageNode.getChildNodes();
											for(int k=0; k < adjMessageList.getLength(); k++)
											{
												l_app_msg = " ::: adjMessageList.item("+k+").getNodeName() ::: "+adjMessageList.item(k).getNodeName()+ " ::: "+adjMessageList.item(k).getNodeType();
												if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
												
												nodeValue = "";

												if (adjMessageList.item(k).getNodeType() == Node.ELEMENT_NODE)
												{
													nodeValue = GetElementNodeValue(adjMessageList, k);
													
													if (adjMessageList.item(k).getNodeName().equals("era:Type"))
													{
														l_message_type = nodeValue;
														l_app_msg = " ::: l_message_type ::: "+l_message_type;
														if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
													}
													if (adjMessageList.item(k).getNodeName().equals("era:Code"))
													{
														l_message_code = nodeValue;
														l_app_msg = " ::: l_message_code ::: "+l_message_code;
														if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
													}
													if (adjMessageList.item(k).getNodeName().equals("era:Description"))
													{
														l_message_desc = nodeValue;
														l_app_msg = " ::: l_message_desc ::: "+l_message_desc;
														if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
													}
												}
											}
										}
										// Insert into XF_ERA_ADJ_MESSAGE	

										l_insert_count = 0;

										l_insert_stmt = " INSERT INTO XF_ERA_ADJ_MESSAGE (MK_ERA_NO, ADJUSTMENT_ID, MESSAGE_ID, MESSAGE_TYPE, MESSAGE_CODE, MESSAGE_DESC) "
												+"					  VALUES (?, ?, ?, ?, ?, ?) ";
										pstmt = dbConn.prepareStatement(l_insert_stmt);					
										pstmt.setString(1, l_era_nbr);
										pstmt.setString(2, l_adj_id);
										pstmt.setString(3, l_message_id);
										pstmt.setString(4, l_message_type);
										pstmt.setString(5, l_message_code);
										pstmt.setString(6, l_message_desc);						

										l_insert_count = pstmt.executeUpdate();

										l_app_msg = " ::: Insert into XF_ERA_ADJ_MESSAGE Count ::: "+l_insert_count;
										if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
									}																														
								}								
							}
						}
					}						
				}
			}
		}
		catch (Exception e)
		{
			reqParam.put("ERASCHEMESTATUS", "E");
			reqParam.put("ERASCHEMESTATUSMESSAGE", " Error in processing ERA Adjustment : "+e.getMessage());
			e.printStackTrace();
			return reqParam;
		}
		finally
		{			
			closeDBResources(rs, pstmt, null);			
		}

		reqParam.put("ERASCHEMESTATUS", "S");
		reqParam.put("ERASCHEMESTATUSMESSAGE", " Successfully Processed ERA Adjustment. ");

		return reqParam;
	}

	public HashMap parseClaimXml(String response, Map params, Connection conn)
	{

		String l_app_msg = "";

		Connection dbConn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;

		String l_insert_stmt = "";

		int l_insert_count = 0;

		String l_era_nbr = "";

		String l_claim_id = "", l_prov_claim_no = "", l_scheme_claim_no = "", l_treatment_date = "", l_reference = "", l_claim_status = "", l_claim_status_message = "";
		String l_claim_prov_no = "", l_claim_prov_name = "", l_claim_prov_reference = "", l_claim_prov_group = "";
		String l_member_policy_no	= "", l_member_initials = "", l_member_firstname = "", l_member_surname = "", l_member_oldpolicyno = "";
		String l_patient_initials = "", l_patient_firstname = "", l_patient_surname = "", l_patient_dob = "", l_patient_deptcode = ""; 

		String l_claimed_by_provider = "0.00", l_paid_to_provider = "0.00", l_paid_to_member = "0.00", l_member_to_payprovider = "0.00", l_not_paid = "0.00", l_total_deduction = "0.00", l_switch_claim_amt = "0.00";

		String l_claim_deduction_id = "", l_claim_deduction_type = "", l_claim_deduction_amount = "0.00";
		
		int l_claims_count = 0;

		String l_line_id = "", l_prctice_line_no = "", l_scheme_line_no = "", l_switch_line_no = "", l_scheme_reference_no = "", l_service_date = "", l_procedure_code = ""; 
		String l_line_product_code = "", l_line_product_suffix = "", l_line_lab_nbr = "", l_line_patient_dob = "", l_line_patient_deptcode = "";
		String l_line_claimed_by_provider = "0.00", l_line_paid_to_provider = "0.00", l_line_paid_to_member = "0.00", l_line_member_to_payprovider = "0.00", l_line_not_paid = "0.00", l_line_total_deduction = "0.00", l_line_switch_claim_amt = "0.00", l_line_scheme_rate = "0.00";

		String l_message_id = "", l_message_type = "", l_message_code = "", l_message_desc = "";

		String l_line_deduction_id = "", l_line_deduction_type = "", l_line_deduction_amount = "";

		String l_line_message_id = "", l_line_message_type = "", l_line_message_code = "", l_line_message_desc = "";

		String l_updt_stmt = ""; int l_updt_count = 0;

		SimpleDateFormat sdf;

		java.sql.Timestamp l_current_date = null;

		HashMap reqParam = null;

		String nodeValue = "";

		String l_bill_details = "", l_bill_doc_type = ""; 
		int l_bill_doc_no = 0;

		try
		{

			reqParam = new HashMap(params);

			sdf = new SimpleDateFormat("yyyy-MM-dd");

			//dbConn =  ConnectionManager.getConnection();

			dbConn = conn;

			l_current_date = new java.sql.Timestamp(System.currentTimeMillis());
				
			l_app_msg = " ::: l_current_date : "+l_current_date;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_era_nbr = parseResponseXml(response, "File", "MkEraNbr", "true");
			l_app_msg = " ::: ERA Number ::: "+l_era_nbr;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			dbf.setNamespaceAware(true);
			DocumentBuilder db = dbf.newDocumentBuilder();
			InputSource is = new InputSource();
			is.setCharacterStream(new StringReader(response));

			//Document doc = db.parse(new File("LDoH_MK_ERA_Sample.xml"));

			Document document = db.parse(is);
			document.getDocumentElement().normalize();

			
			NodeList claimNodesList = document.getElementsByTagNameNS("*","Claim");

			if (claimNodesList != null)
			{
				l_claims_count = claimNodesList.getLength();

				l_app_msg = " ::: Claims NodesList Length ::: "+l_claims_count;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				if (l_claims_count>0)
				{
					for (int i = 0; i < claimNodesList.getLength(); i++) 
					{

						l_claim_id = ""; l_prov_claim_no = ""; l_scheme_claim_no = ""; l_treatment_date = ""; l_reference = ""; l_claim_status = ""; l_claim_status_message = "";
						l_claim_prov_no = ""; l_claim_prov_name = ""; l_claim_prov_reference = ""; l_claim_prov_group = "";
						l_member_policy_no	= ""; l_member_initials = ""; l_member_firstname = ""; l_member_surname = ""; l_member_oldpolicyno = "";
						l_patient_initials = ""; l_patient_firstname = ""; l_patient_surname = ""; l_patient_dob = ""; l_patient_deptcode = "";
						l_claimed_by_provider = "0.00"; l_paid_to_provider = "0.00"; l_paid_to_member = "0.00"; l_member_to_payprovider = "0.00"; l_not_paid = "0.00"; l_total_deduction = "0.00"; l_switch_claim_amt = "0.00";

						l_bill_details = "";

						l_bill_doc_type = ""; l_bill_doc_no = 0;

						l_updt_stmt = ""; l_updt_count = 0;

						if (claimNodesList.item(i).getNodeType() == Node.ELEMENT_NODE) 
						{
							Element el = (Element) claimNodesList.item(i);
							l_claim_id = el.getAttribute("id");
							l_app_msg = " :::  Claim ID Value : "+l_claim_id;
							if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
						}

						Node claimNode = (Node) claimNodesList.item(i);

						if (claimNode.hasChildNodes())
						{
							NodeList claimChildList = claimNode.getChildNodes();
							for(int j=0; j < claimChildList.getLength(); j++)
							{
								l_app_msg = " Outside claimChildList.item("+j+").getNodeName() ::: "+claimChildList.item(j).getNodeName();
								if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
								
								if (claimChildList.item(j).getNodeName().equals("era:ClaimHeader"))
								{
									Node claimHeaderNode = (Node) claimChildList.item(j);
									if (claimHeaderNode.hasChildNodes())
									{
										l_app_msg = " Inside claimHeaderNode ";
										if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

										NodeList claimHeaderChildList = claimHeaderNode.getChildNodes();

										for(int k=0; k < claimHeaderChildList.getLength(); k++)
										{
											l_app_msg = " Outside claimHeaderChildList.item("+k+").getNodeName() ::: "+claimHeaderChildList.item(k).getNodeName()+ " ::: "+claimHeaderChildList.item(k).getNodeType();
											if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

											nodeValue = "";

											if (claimHeaderChildList.item(k).getNodeType() == Node.ELEMENT_NODE)
											{	

												nodeValue = GetElementNodeValue(claimHeaderChildList, k);
											
												if (claimHeaderChildList.item(k).getNodeName().equals("era:ProviderClaimNbr"))
												{
													l_prov_claim_no = nodeValue;
													l_app_msg = " ::: l_prov_claim_no ::: "+l_prov_claim_no;
													if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
												}
												if (claimHeaderChildList.item(k).getNodeName().equals("era:SchemeClaimNbr"))
												{
													l_scheme_claim_no = nodeValue;
													l_app_msg = " ::: l_scheme_claim_no ::: "+l_scheme_claim_no;
													if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
												}
												if (claimHeaderChildList.item(k).getNodeName().equals("era:TreatmentDate"))
												{
													l_treatment_date = nodeValue;
													l_app_msg = " ::: l_treatment_date ::: "+l_treatment_date;
													if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
												}
												if (claimHeaderChildList.item(k).getNodeName().equals("era:Reference"))
												{
													l_reference = nodeValue;
													l_app_msg = " ::: l_reference ::: "+l_reference;
													if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
												}
												if (claimHeaderChildList.item(k).getNodeName().equals("era:ClaimProvider"))
												{
													l_app_msg = " ::: Inside ClaimProvider ::: ";
													if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

													Node claimProviderNode = (Node) claimHeaderChildList.item(k);
													if (claimProviderNode.hasChildNodes())
													{
														NodeList claimProviderChildList = claimProviderNode.getChildNodes();
														for(int l=0; l < claimProviderChildList.getLength();l++)
														{
															l_app_msg = " Outside claimProviderChildList.item("+l+").getNodeName() ::: "+claimProviderChildList.item(l).getNodeName();
															if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

															nodeValue = "";

															if (claimProviderChildList.item(l).getNodeType() == Node.ELEMENT_NODE)
															{	
																nodeValue = GetElementNodeValue(claimProviderChildList, l);

																if (claimProviderChildList.item(l).getNodeName().equals("era:Number"))
																{
																	l_claim_prov_no = nodeValue;
																	l_app_msg = " ::: l_claim_prov_no ::: "+l_claim_prov_no;
																	if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
																}
																if (claimProviderChildList.item(l).getNodeName().equals("era:Name"))
																{
																	l_claim_prov_name = nodeValue;
																	l_app_msg = " ::: l_claim_prov_name ::: "+l_claim_prov_name;
																	if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
																}
																if (claimProviderChildList.item(l).getNodeName().equals("era:Reference"))
																{
																	l_claim_prov_reference = nodeValue;
																	l_app_msg = " ::: l_claim_prov_reference ::: "+l_claim_prov_reference;
																	if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
																}
																if (claimProviderChildList.item(l).getNodeName().equals("era:Group"))
																{
																	l_claim_prov_group = nodeValue;
																	l_app_msg = " ::: l_claim_prov_group ::: "+l_claim_prov_group;
																	if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
																}
															}

														}
													}

												}
												if (claimHeaderChildList.item(k).getNodeName().equals("era:Member"))
												{
													Node claimMemberNode = (Node) claimHeaderChildList.item(k);
													if (claimMemberNode.hasChildNodes())
													{
														NodeList claimMemberChildList = claimMemberNode.getChildNodes();
														for(int l=0; l < claimMemberChildList.getLength();l++)
														{
															l_app_msg = " Outside claimMemberChildList.item("+l+").getNodeName() ::: "+claimMemberChildList.item(l).getNodeName();
															if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

															nodeValue = "";

															if (claimMemberChildList.item(l).getNodeType() == Node.ELEMENT_NODE)
															{	
																/*
																l_app_msg = " ::: adjChildList.item(j).getNodeName() ::: "+claimMemberChildList.item(l).getNodeName();
																if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

																e2 = (Element) claimMemberChildList.item(l);

																l_app_msg = " ::: e2.hasChildNodes() ::: "+e2.hasChildNodes();
																//if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

																if (e2.hasChildNodes())
																{
																	NodeList eleNodeList = e2.getChildNodes();

																	l_app_msg = " ::: eleNodeList.getLength() ::: "+eleNodeList.getLength();
																	//if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

																	if (eleNodeList.getLength()>0)
																		nodeValue = eleNodeList.item(0).getNodeValue();		
																}
																*/

																nodeValue = GetElementNodeValue(claimMemberChildList, l);


																if (claimMemberChildList.item(l).getNodeName().equals("era:PolicyNumber"))
																{
																	l_member_policy_no = nodeValue;
																	l_app_msg = " ::: l_member_policy_no ::: "+l_member_policy_no;
																	if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
																}
																if (claimMemberChildList.item(l).getNodeName().equals("era:Initials"))
																{
																	l_member_initials = nodeValue;
																	l_app_msg = " ::: l_member_initials ::: "+l_member_initials;
																	if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
																}
																if (claimMemberChildList.item(l).getNodeName().equals("era:FirstName"))
																{
																	l_member_firstname = nodeValue;
																	l_app_msg = " ::: l_member_firstname ::: "+l_member_firstname;
																	if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
																}
																if (claimMemberChildList.item(l).getNodeName().equals("era:Surname"))
																{
																	l_member_surname = nodeValue;
																	l_app_msg = " ::: l_member_surname ::: "+l_member_surname;
																	if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
																}
																if (claimMemberChildList.item(l).getNodeName().equals("era:OldPolicyNumber"))
																{
																	l_member_oldpolicyno = nodeValue;
																	l_app_msg = " :::l_member_oldpolicyno ::: "+l_member_oldpolicyno;
																	if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
																}
															}
														}
													}
												}
												if (claimHeaderChildList.item(k).getNodeName().equals("era:Patient"))
												{
													Node claimPatientNode = (Node) claimHeaderChildList.item(k);
													if (claimPatientNode.hasChildNodes())
													{
														NodeList claimPatientChildList = claimPatientNode.getChildNodes();
														for(int l=0; l < claimPatientChildList.getLength();l++)
														{
															l_app_msg = " Outside claimPatientChildList.item("+l+").getNodeName() ::: "+claimPatientChildList.item(l).getNodeName();
															if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

															nodeValue = "";

															if (claimPatientChildList.item(l).getNodeType() == Node.ELEMENT_NODE)
															{	
																nodeValue = GetElementNodeValue(claimPatientChildList, l);

																if (claimPatientChildList.item(l).getNodeName().equals("era:Initials"))
																{
																	l_patient_initials = nodeValue;
																	l_app_msg = " ::: l_patient_initials ::: "+l_patient_initials;
																	if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
																}
																if (claimPatientChildList.item(l).getNodeName().equals("era:FirstName"))
																{
																	l_patient_firstname = nodeValue;
																	l_app_msg = " ::: l_patient_firstname ::: "+l_patient_firstname;
																	if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
																}
																if (claimPatientChildList.item(l).getNodeName().equals("era:Surname"))
																{
																	l_patient_surname = nodeValue;
																	l_app_msg = " ::: l_patient_surname ::: "+l_patient_surname;
																	if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
																}
																if (claimPatientChildList.item(l).getNodeName().equals("era:DateOfBirth"))
																{
																	l_patient_dob = nodeValue;
																	l_app_msg = " ::: l_patient_dob ::: "+l_patient_dob;
																	if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
																}
																if (claimPatientChildList.item(l).getNodeName().equals("era:DepCode"))
																{
																	l_patient_deptcode = nodeValue;
																	l_app_msg = " ::: l_patient_deptcode ::: "+l_patient_deptcode;
																	if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
																}
															}
														}
													}
												}
												if (claimHeaderChildList.item(k).getNodeName().equals("era:Financial"))
												{
													Node claimFinancialNode = (Node) claimHeaderChildList.item(k);
													if (claimFinancialNode.hasChildNodes())
													{
														NodeList claimFinancialChildList = claimFinancialNode.getChildNodes();
														for(int l=0; l < claimFinancialChildList.getLength();l++)
														{
															l_app_msg = " Outside claimFinancialChildList.item("+l+").getNodeName() ::: "+claimFinancialChildList.item(l).getNodeName();
															if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

															nodeValue = "";

															if (claimFinancialChildList.item(l).getNodeType() == Node.ELEMENT_NODE)
															{	
																nodeValue = GetElementNodeValue(claimFinancialChildList, l);

																if (claimFinancialChildList.item(l).getNodeName().equals("era:ClaimedByProvider"))
																{
																	l_claimed_by_provider = nodeValue;
																	l_app_msg = " ::: l_claimed_by_provider ::: "+l_claimed_by_provider;
																	if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
																}
																if (claimFinancialChildList.item(l).getNodeName().equals("era:PaidToProvider"))
																{
																	l_paid_to_provider = nodeValue;
																	l_app_msg = " ::: l_paid_to_provider ::: "+l_paid_to_provider;
																	if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
																}
																if (claimFinancialChildList.item(l).getNodeName().equals("era:PaidToMember"))
																{
																	l_paid_to_member = nodeValue;
																	l_app_msg = " ::: l_paid_to_member ::: "+l_paid_to_member;
																	if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
																}
																if (claimFinancialChildList.item(l).getNodeName().equals("era:MemberToPayProvider"))
																{
																	l_member_to_payprovider = nodeValue;
																	l_app_msg = " ::: l_member_to_payprovider ::: "+l_member_to_payprovider;
																	if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
																}
																if (claimFinancialChildList.item(l).getNodeName().equals("era:NotPaid"))
																{
																	l_not_paid = nodeValue;
																	l_app_msg = " ::: l_not_paid ::: "+l_not_paid;
																	if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
																}
																if (claimFinancialChildList.item(l).getNodeName().equals("era:TotalDeduction"))
																{
																	l_total_deduction = nodeValue;
																	l_app_msg = " ::: l_total_deduction ::: "+l_total_deduction;
																	if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
																}
																if (claimFinancialChildList.item(l).getNodeName().equals("era:SwitchClaimAmt"))
																{
																	l_switch_claim_amt = nodeValue;
																	l_app_msg = " ::: l_switch_claim_amt ::: "+l_switch_claim_amt;
																	if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
																}
															}
														}
													}
												}
											}											
										}
										// Insert into XF_ERA_CLAIM	

										if (l_reference.length()>0)
										{
											/*
											l_bill_details = GetBillDetails(l_prov_claim_no);

											l_app_msg = " ::: l_bill_details ::: "+l_bill_details;
											if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
											*/

											l_bill_doc_type = ""; l_bill_doc_no = 0;
											l_claim_status = "3";
											l_claim_status_message = "";

											/*

											String[] ClaimNo = l_reference.split("#");	
											
											l_app_msg = " ::: ClaimNo.length ::: "+ClaimNo.length;
											if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

											if (ClaimNo.length>1)
											{												
												l_bill_doc_type = ClaimNo[1];
												l_bill_doc_no = Integer.parseInt(ClaimNo[2]);												
											}

											*/


											l_prov_claim_no = "";

											if (l_reference.length()>8)
											{
												l_bill_doc_type = l_reference.substring(2,8);
												l_bill_doc_no = Integer.parseInt(l_reference.substring(8));
											}	
											
											l_bill_details = GetClaimNoDetails(l_bill_doc_type, l_bill_doc_no);

											l_claim_status_message = " Either no claim has been made with reference Number "+l_reference+" or Claim does not match with the reference.";

											
											l_app_msg = " ::: l_bill_details ::: "+l_bill_details;
											if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

											String[] ClaimNo = l_bill_details.split("#");	
											
											l_app_msg = " ::: ClaimNo.length ::: "+ClaimNo.length;
											if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

											if (ClaimNo.length>1)
											{												
												if ( ClaimNo[0].equals("S"))
												{
													l_prov_claim_no = ClaimNo[1];
													if (!(l_prov_claim_no.equals("0")))
													{
														l_claim_status = "0";
														l_claim_status_message = "";
													}
													
												}
												
											}

											l_app_msg = " ::: L_PROV_NO After GetClaimNoDetails ::: "+l_prov_claim_no;
											if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);											

										}

										l_app_msg = " ::: l_era_nbr ::: "+l_era_nbr+ " ::: l_prov_claim_no ::: "+l_prov_claim_no+ " ::: l_claim_status ::: "+l_claim_status+ " ::: l_claim_status_message ::: "+l_claim_status_message;
										if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);


										l_app_msg = " ::: L_BILL_DOC_TYPE ::: "+l_bill_doc_type+" ::: L_BILL_DOC_NO ::: "+l_bill_doc_no;
										if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

										
										l_insert_stmt = " INSERT INTO XF_ERA_CLAIM (MK_ERA_NO, CLAIM_ID	, PROV_CLAIM_NO, SCHEME_CLAIM_NO, TREATMENT_DATE, "
														+"						CLAIM_STATUS, CLAIM_REFERENCE, CLAIM_PROV_NO, CLAIM_PROV_NAME, CLAIM_PROV_REFERENCE, CLAIM_PROV_GROUP,"
														+"						CLAIM_MEMBER_POLICY_NO, CLAIM_MEMBER_INITIALS, CLAIM_MEMBER_FIRSTNAME, CLAIM_MEMBER_SURNAME, CLAIM_MEMBER_OLDPOLICYNO, "
														+"						CLAIM_PATIENT_INITIALS, CLAIM_PATIENT_FIRSTNAME, CLAIM_PATIENT_SURNAME, CLAIM_PATIENT_DOB, CLAIM_PATIENT_DEPTCODE, "
														+"						CLAIMED_BY_PROVIDER, PAID_TO_PROVIDER, PAID_TO_MEMBER, MEMBER_TO_PAYPROVIDER, NOT_PAID, TOTAL_DEDUCTION, SWITCH_CLAIM_AMT, "
														+"						PROCESS_STATUS, PROCESS_ACK_MESSAGE, PROCESS_ERROR_MESSAGE, BILL_DOC_TYPE_CODE, BILL_DOC_NUMBER, "
														+"						ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) "
														+"				VALUES (?, ?, ?, ?, ?, "
														+"						?, ?, ?, ?, ?, ?, "
														+"						?, ?, ?, ?, ?, "
														+"						?, ?, ?, ?, ?, "
														+"						?, ?, ?, ?, ?, ?, ?, "
														+"						?, ?, ?, ?, ?, "
														+"						?, ?, ?, ?, ?, ?, ?, ?)";

										pstmt = dbConn.prepareStatement(l_insert_stmt);					
										pstmt.setString(1, l_era_nbr);
										pstmt.setString(2, l_claim_id);
										pstmt.setString(3, l_prov_claim_no);
										pstmt.setString(4, l_scheme_claim_no);
										pstmt.setDate(5, new java.sql.Date(sdf.parse(l_treatment_date).getTime()));
										
										pstmt.setString(6, "");
										pstmt.setString(7, l_reference);
										pstmt.setString(8, l_claim_prov_no);
										pstmt.setString(9, l_claim_prov_name);
										pstmt.setString(10, l_claim_prov_reference);
										pstmt.setString(11, l_claim_prov_group);
										
										pstmt.setString(12, l_member_policy_no);
										pstmt.setString(13, l_member_initials);
										pstmt.setString(14, l_member_firstname);
										pstmt.setString(15, l_member_surname);
										pstmt.setString(16, l_member_oldpolicyno);

										pstmt.setString(17, l_patient_initials);
										pstmt.setString(18, l_patient_firstname);
										pstmt.setString(19, l_patient_surname);
										pstmt.setDate(20, new java.sql.Date(sdf.parse(l_patient_dob).getTime()));
										pstmt.setString(21, l_patient_deptcode);

										pstmt.setDouble(22, Double.parseDouble(l_claimed_by_provider));
										pstmt.setDouble(23, Double.parseDouble(l_paid_to_provider));
										pstmt.setDouble(24, Double.parseDouble(l_paid_to_member));
										pstmt.setDouble(25, Double.parseDouble(l_member_to_payprovider));
										pstmt.setDouble(26, Double.parseDouble(l_not_paid));
										pstmt.setDouble(27, Double.parseDouble(l_total_deduction));
										pstmt.setDouble(28, Double.parseDouble(l_switch_claim_amt));	
										pstmt.setString(29, l_claim_status);
										pstmt.setString(30, "");
										pstmt.setString(31, l_claim_status_message);									
										
										pstmt.setString(32, l_bill_doc_type);
										pstmt.setInt(33, l_bill_doc_no);										
										
										pstmt.setString(34, XHDBAdapter.isNullReplace(reqParam.get("ADDED_BY_ID").toString(), reqParam.get("LOGIN_USER").toString()));
										pstmt.setTimestamp(35, l_current_date);
										pstmt.setString(36, reqParam.get("CLIENT_MACHINE").toString());
										pstmt.setString(37, XHDBAdapter.isNullReplace(reqParam.get("ADDED_BY_FACILITY").toString(), reqParam.get("FACILITY_ID").toString()));
										pstmt.setString(38, XHDBAdapter.isNullReplace(reqParam.get("MODIFIED_BY_ID").toString(), reqParam.get("LOGIN_USER").toString()));
										pstmt.setTimestamp(39, l_current_date);	
										pstmt.setString(40, reqParam.get("CLIENT_MACHINE").toString());
										pstmt.setString(41, XHDBAdapter.isNullReplace(reqParam.get("ADDED_BY_FACILITY").toString(), reqParam.get("FACILITY_ID").toString()));

										l_insert_count = pstmt.executeUpdate();

										l_app_msg = " ::: Insert into XF_ERA_CLAIM l_insert_count : "+l_insert_count;
										if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

										//

										l_updt_stmt = " UPDATE XF_ECLAIMS_TRX_HDR set PAID_TO_PROVIDER = ? "
														+" WHERE EVENT_TYPE = 'CLA' AND APPROVAL_STATUS in ('P','A') and SRL_NO = ? and DOC_TYPE_CODE = ? AND DOC_NUM = ? ";

										pstmt = dbConn.prepareStatement(l_updt_stmt);	

										pstmt.setDouble(1, Double.parseDouble(l_paid_to_provider));										
										pstmt.setInt(2, Integer.parseInt(l_prov_claim_no));
										pstmt.setString(3, l_bill_doc_type);
										pstmt.setInt(4, l_bill_doc_no);
										
										l_updt_count = pstmt.executeUpdate();	
										
										l_app_msg = " ::: UPDATE XF_ECLAIMS_TRX_HDR set PAID_TO_PROVIDER l_updt_stmt : "+l_updt_count;
										if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);


										for(int k=0; k < claimHeaderChildList.getLength(); k++)
										{										
											if (!(claimHeaderChildList.item(k).getNodeName().equals("#text")))
											{										
												if (claimHeaderChildList.item(k).getNodeName().equals("era:Deduction"))
												{
													l_claim_deduction_id = ""; l_claim_deduction_type = ""; l_claim_deduction_amount = "";

													if (claimHeaderChildList.item(k).getNodeType() == Node.ELEMENT_NODE) 
													{
														Element el = (Element) claimHeaderChildList.item(k);
														l_claim_deduction_id = el.getAttribute("id");
														l_app_msg = " ::: Claim Deduction ID Value : "+l_claim_deduction_id;
														if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
													}
													
													Node claimDeductionNode = (Node) claimHeaderChildList.item(k);
													
													if (claimDeductionNode.hasChildNodes())
													{
														NodeList claimDedChildList = claimDeductionNode.getChildNodes();

														for(int l=0; l < claimDedChildList.getLength(); l++)
														{	
															nodeValue = "";

															if (claimDedChildList.item(l).getNodeType() == Node.ELEMENT_NODE)
															{	
																nodeValue = GetElementNodeValue(claimDedChildList, l);

																if (claimDedChildList.item(l).getNodeName().equals("era:Type"))
																{
																	l_claim_deduction_type = nodeValue;
																	l_app_msg = " ::: l_claim_deduction_type ::: "+l_claim_deduction_type;
																	if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
																}
																if (claimDedChildList.item(l).getNodeName().equals("era:Amt"))
																{
																	l_claim_deduction_amount = nodeValue;
																	l_app_msg = " ::: l_claim_deduction_amount ::: "+l_claim_deduction_amount;
																	if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
																}
															}
														}
													}

													//INSERT into XF_ERA_CLAIM_DED

													l_insert_count = 0;

													l_insert_stmt = " INSERT INTO XF_ERA_CLAIM_DED (MK_ERA_NO, CLAIM_ID	, DEDUCTION_ID, DEDUCTION_TYPE, DEDUCTION_AMOUNT) "
																					+"				VALUES (?, ?, ?, ?, ?) ";

													pstmt = dbConn.prepareStatement(l_insert_stmt);					
													pstmt.setString(1, l_era_nbr);
													pstmt.setString(2, l_claim_id);
													pstmt.setString(3, l_claim_deduction_id);
													pstmt.setString(4, l_claim_deduction_type);
													pstmt.setDouble(5, Double.parseDouble(l_claim_deduction_amount));											

													l_insert_count = pstmt.executeUpdate();

													l_app_msg = " ::: Insert into XF_ERA_CLAIM_DED l_insert_count : "+l_insert_count;
													if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
												}
											}
										}
									}									
								}
								if (claimChildList.item(j).getNodeName().equals("era:Message"))
								{
									l_app_msg = " Inside Claim Message ";
									if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

									l_message_id = ""; l_message_type = ""; l_message_code = ""; l_message_desc = "";									

									if (claimChildList.item(j).getNodeType() == Node.ELEMENT_NODE) 
									{
										Element el = (Element) claimChildList.item(j);
										l_message_id = el.getAttribute("id");
										l_app_msg = " ::: l_message_id : "+l_message_id;
										if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
									}

									Node claimMessageNode = (Node) claimChildList.item(j);
									if (claimMessageNode.hasChildNodes())
									{
										NodeList claimMessageChildList = claimMessageNode.getChildNodes();

										for(int k=0; k < claimMessageChildList.getLength(); k++)
										{
											nodeValue = "";

											if (claimMessageChildList.item(k).getNodeType() == Node.ELEMENT_NODE)
											{	
												nodeValue = GetElementNodeValue(claimMessageChildList, k);
											
												if (claimMessageChildList.item(k).getNodeName().equals("era:Type"))
												{
													l_message_type =  nodeValue;
													l_app_msg = " ::: l_message_type ::: "+l_message_type;
													if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
												}
												if (claimMessageChildList.item(k).getNodeName().equals("era:Code"))
												{
													l_message_code =  nodeValue;
													l_app_msg = " ::: l_message_code ::: "+l_message_code;
													if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
												}
												if (claimMessageChildList.item(k).getNodeName().equals("era:Description"))
												{
													l_message_desc =  nodeValue;
													l_app_msg = " ::: l_message_desc ::: "+l_message_desc;
													if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
												}
											}
										}
									}

									// Insert into XF_ERA_CLAIM_MESSAGE

									l_insert_count = 0;

									l_insert_stmt = " INSERT INTO XF_ERA_CLAIM_MESSAGE (MK_ERA_NO, CLAIM_ID	, MESSAGE_ID, REASON_TYPE, REASON_CODE, REASON_DESC) "
																	+"				VALUES (?, ?, ?, ?, ?, ?) ";

									pstmt = dbConn.prepareStatement(l_insert_stmt);					
									pstmt.setString(1, l_era_nbr);
									pstmt.setString(2, l_claim_id);
									pstmt.setString(3, l_message_id);
									pstmt.setString(4, l_message_type);
									pstmt.setString(5, l_message_code);	
									pstmt.setString(6, l_message_desc);	

									l_insert_count = pstmt.executeUpdate();

									l_app_msg = " ::: Insert into XF_ERA_CLAIM_MESSAGE l_insert_count : "+l_insert_count;
									if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

								}
								if (claimChildList.item(j).getNodeName().equals("era:Line"))
								{
									l_app_msg = " Inside claimLineNode ";
									if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

									l_line_id = ""; l_prctice_line_no = ""; l_scheme_line_no = ""; l_switch_line_no = ""; l_scheme_reference_no = ""; l_service_date = ""; l_procedure_code = ""; 
									l_line_product_code = ""; l_line_product_suffix = ""; l_line_lab_nbr = ""; l_line_patient_dob = ""; l_line_patient_deptcode = "";
									l_line_claimed_by_provider = "0.00"; l_line_paid_to_provider = "0.00"; l_line_paid_to_member = "0.00"; l_line_member_to_payprovider = ""; l_line_not_paid = "0.00"; l_line_total_deduction = "0.00"; l_line_switch_claim_amt = "0.00"; l_line_scheme_rate = "0.00";

									l_updt_stmt = ""; l_updt_count = 0;

									if (claimChildList.item(j).getNodeType() == Node.ELEMENT_NODE) 
									{
										Element el = (Element) claimChildList.item(j);
										l_line_id = el.getAttribute("id");
										l_app_msg = " ::: l_line_id : "+l_line_id;
										if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
									}

									Node claimLineNode = (Node) claimChildList.item(j);
									if (claimLineNode.hasChildNodes())
									{
										NodeList claimLineChildList = claimLineNode.getChildNodes();

										for(int k=0; k < claimLineChildList.getLength(); k++)
										{											
											nodeValue = "";

											if (claimLineChildList.item(k).getNodeType() == Node.ELEMENT_NODE)
											{	
												nodeValue = GetElementNodeValue(claimLineChildList, k);
												
												if (claimLineChildList.item(k).getNodeName().equals("era:PracticeLineNbr"))
												{
													l_prctice_line_no =  nodeValue;
													l_app_msg = " ::: l_prctice_line_no ::: "+l_prctice_line_no;
													if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
												}
												if (claimLineChildList.item(k).getNodeName().equals("era:SchemeLineNbr"))
												{
													l_scheme_line_no =  nodeValue;
													l_app_msg = " ::: l_scheme_line_no ::: "+l_scheme_line_no;
													if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
												}
												if (claimLineChildList.item(k).getNodeName().equals("era:SwitchLineNbr"))
												{
													l_switch_line_no =  nodeValue;
													l_app_msg = " ::: l_switch_line_no ::: "+l_switch_line_no;
													if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
												}
												if (claimLineChildList.item(k).getNodeName().equals("era:SchemeReferenceNbr"))
												{
													l_scheme_reference_no =  nodeValue;
													l_app_msg = " ::: l_scheme_reference_no ::: "+l_scheme_reference_no;
													if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
												}
												if (claimLineChildList.item(k).getNodeName().equals("era:DateOfService"))
												{
													l_service_date =  nodeValue;
													l_app_msg = " ::: l_service_date ::: "+l_service_date;
													if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
												}
												if (claimLineChildList.item(k).getNodeName().equals("era:ProcedureCode"))
												{
													l_procedure_code =  nodeValue;
													l_app_msg = " ::: l_procedure_code ::: "+l_procedure_code;
													if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
												}
												if (claimLineChildList.item(k).getNodeName().equals("era:Product"))
												{
													Node claimLineProductNode = (Node) claimLineChildList.item(k);
													if (claimLineProductNode.hasChildNodes())
													{
														NodeList claimLineProdChildList = claimLineProductNode.getChildNodes();
														for(int l=0; l < claimLineProdChildList.getLength();l++)
														{
															nodeValue = "";

															if (claimLineProdChildList.item(l).getNodeType() == Node.ELEMENT_NODE)
															{	
																nodeValue = GetElementNodeValue(claimLineProdChildList, l);

																if (claimLineProdChildList.item(l).getNodeName().equals("era:Code"))
																{
																	l_line_product_code =  nodeValue;
																	l_app_msg = " ::: l_line_product_code ::: "+l_line_product_code;
																	if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
																}
																if (claimLineProdChildList.item(l).getNodeName().equals("era:Suffix"))
																{
																	l_line_product_suffix =  nodeValue;
																	l_app_msg = " ::: l_line_product_suffix ::: "+l_line_product_suffix;
																	if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
																}
															}
														}
													}

												}
												if (claimLineChildList.item(k).getNodeName().equals("era:LabNbr"))
												{
													l_line_lab_nbr =  claimLineChildList.item(k).getNodeValue();
													l_app_msg = " ::: l_line_lab_nbr ::: "+l_line_lab_nbr;
													if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
												}	

												if (claimLineChildList.item(k).getNodeName().equals("era:Financial"))
												{
													Node claimLineFinancialNode = (Node) claimLineChildList.item(k);
													if (claimLineFinancialNode.hasChildNodes())
													{
														NodeList claimLineFinancialChildList = claimLineFinancialNode.getChildNodes();
														for(int l=0; l < claimLineFinancialChildList.getLength();l++)
														{
															nodeValue = "";

															if (claimLineFinancialChildList.item(l).getNodeType() == Node.ELEMENT_NODE)
															{	
																nodeValue = GetElementNodeValue(claimLineFinancialChildList, l);

																if (claimLineFinancialChildList.item(l).getNodeName().equals("era:ClaimedByProvider"))
																{
																	l_line_claimed_by_provider = nodeValue;
																	l_app_msg = " ::: l_line_claimed_by_provider ::: "+l_line_claimed_by_provider;
																	if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
																}
																if (claimLineFinancialChildList.item(l).getNodeName().equals("era:PaidToProvider"))
																{
																	l_line_paid_to_provider = nodeValue;
																	l_app_msg = " ::: l_line_paid_to_provider ::: "+l_line_paid_to_provider;
																	if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
																}
																if (claimLineFinancialChildList.item(l).getNodeName().equals("era:PaidToMember"))
																{
																	l_line_paid_to_member = nodeValue;
																	l_app_msg = " ::: l_line_paid_to_member ::: "+l_line_paid_to_member;
																	if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
																}
																if (claimLineFinancialChildList.item(l).getNodeName().equals("era:MemberToPayProvider"))
																{
																	l_line_member_to_payprovider = nodeValue;
																	l_app_msg = " ::: l_line_member_to_payprovider ::: "+l_line_member_to_payprovider;
																	if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
																}
																if (claimLineFinancialChildList.item(l).getNodeName().equals("era:NotPaid"))
																{
																	l_line_not_paid = nodeValue;
																	l_app_msg = " ::: l_line_not_paid ::: "+l_line_not_paid;
																	if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
																}
																if (claimLineFinancialChildList.item(l).getNodeName().equals("era:TotalDeduction"))
																{
																	l_line_total_deduction = nodeValue;
																	l_app_msg = " ::: l_line_total_deduction ::: "+l_line_total_deduction;
																	if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
																}
																if (claimLineFinancialChildList.item(l).getNodeName().equals("era:SwitchClaimAmt"))
																{
																	l_line_switch_claim_amt = nodeValue;
																	l_app_msg = " ::: l_line_switch_claim_amt ::: "+l_line_switch_claim_amt;
																	if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
																}
																if (claimLineFinancialChildList.item(l).getNodeName().equals("era:SchemeRate"))
																{
																	l_line_scheme_rate = nodeValue;
																	l_app_msg = " ::: l_line_scheme_rate ::: "+l_line_scheme_rate;
																	if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
																}
															}
														}
													}
												}												
											}
										}
										// Insert into XF_ERA_CLAIM_LINE

										l_insert_count = 0;

										l_insert_stmt = " INSERT INTO XF_ERA_CLAIM_LINE (MK_ERA_NO, CLAIM_ID, LINE_ID, PRACTICE_LINE_NO, SCHEME_LINE_NO, SWITCH_LINE_NO, SCHEME_REFERENCE_NO, "
																			+"					DATE_OF_SERVICE, PROCEDURE_CODE, PRODUCT_CODE, PRODUCT_SUFFIX, LAB_NBR, "
																			+"					CLAIMED_BY_PROVIDER, PAID_TO_PROVIDER, PAID_TO_MEMBER, MEMBER_TO_PAYPROVIDER, " 
																			+"					NOT_PAID, TOTAL_DEDUCTION, SWITCH_CLAIM_AMT, SCHEME_RATE )"
																			+"			VALUES (?, ?, ?, ?, ?, ?, ?,"
																			+"				    ?, ?, ?, ?, ?, "
																			+"				    ?, ?, ?, ?, "
																			+"				    ?, ?, ?, ?) ";


										pstmt = dbConn.prepareStatement(l_insert_stmt);					
										pstmt.setString(1, l_era_nbr);
										pstmt.setString(2, l_claim_id);
										pstmt.setString(3, l_line_id);
										pstmt.setString(4, l_prctice_line_no);
										pstmt.setString(5, l_scheme_line_no);	
										pstmt.setString(6, l_switch_line_no);	
										pstmt.setString(7, l_scheme_reference_no);

										pstmt.setDate(8, new java.sql.Date(sdf.parse(l_service_date).getTime()));
										pstmt.setString(9, l_procedure_code);
										pstmt.setString(10, l_line_product_code);
										pstmt.setString(11, l_line_product_suffix);	
										pstmt.setString(12, l_line_lab_nbr);	

										pstmt.setDouble(13, Double.parseDouble(l_line_claimed_by_provider));
										pstmt.setDouble(14, Double.parseDouble(l_line_paid_to_provider));
										pstmt.setDouble(15, Double.parseDouble(l_line_paid_to_member));
										pstmt.setDouble(16, Double.parseDouble(l_line_member_to_payprovider));

										pstmt.setDouble(17, Double.parseDouble(l_line_not_paid));
										pstmt.setDouble(18, Double.parseDouble(l_line_total_deduction));
										pstmt.setDouble(19, Double.parseDouble(l_switch_claim_amt));
										pstmt.setString(20, l_line_scheme_rate);	

										l_insert_count = pstmt.executeUpdate();

										l_app_msg = " ::: Insert into XF_ERA_CLAIM_LINE l_insert_count : "+l_insert_count;
										if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);


										//Update XF_ECLAIMS_TRX_DTL

										l_updt_count = 0;

										l_updt_stmt = " UPDATE XF_ECLAIMS_TRX_DTL set PAID_TO_PROVIDER = ? "
														+" WHERE SRL_NO = ? AND BILL_DOC_TYPE_CODE = ? AND BILL_DOC_NUM = ? AND BILL_DOC_LINE_NUM = ? ";

										pstmt = dbConn.prepareStatement(l_updt_stmt);	

										pstmt.setDouble(1, Double.parseDouble(l_line_paid_to_provider));										
										pstmt.setInt(2, Integer.parseInt(l_prov_claim_no));
										pstmt.setString(3, l_bill_doc_type);
										pstmt.setInt(4, l_bill_doc_no);
										pstmt.setString(5, l_prctice_line_no);		
										
										l_updt_count = pstmt.executeUpdate();	
										
										l_app_msg = " ::: UPDATE XF_ECLAIMS_TRX_DTL set PAID_TO_PROVIDER l_updt_stmt : "+l_updt_count;
										if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

										for(int k=0; k < claimLineChildList.getLength(); k++)
										{											
											if (!(claimLineChildList.item(k).getNodeName().equals("#text")))
											{											
												if (claimLineChildList.item(k).getNodeName().equals("era:Message"))
												{
													l_line_message_id = ""; l_line_message_type = ""; l_line_message_code = ""; l_line_message_desc = "";

													if (claimLineChildList.item(k).getNodeType() == Node.ELEMENT_NODE) 
													{
														Element el = (Element) claimLineChildList.item(k);
														l_line_message_id =  el.getAttribute("id");
														l_app_msg = " ::: l_line_message_id : "+l_line_message_id;
														if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
													}

													Node claimLineMessageNode = (Node) claimLineChildList.item(k);
													if (claimLineMessageNode.hasChildNodes())
													{
														NodeList claimLineMessList = claimLineMessageNode.getChildNodes();

														for(int l=0; l < claimLineMessList.getLength(); l++)
														{											
															nodeValue = "";

															if (claimLineMessList.item(l).getNodeType() == Node.ELEMENT_NODE)
															{	

																nodeValue = GetElementNodeValue(claimLineMessList, l);
											
																if (claimLineMessList.item(l).getNodeName().equals("era:Type"))
																{
																	l_line_message_type =  nodeValue;
																	l_app_msg = " ::: l_line_message_type ::: "+l_line_message_type;
																	if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
																}
																if (claimLineMessList.item(l).getNodeName().equals("era:Code"))
																{
																	l_line_message_code =  nodeValue;
																	l_app_msg = " ::: l_line_message_code ::: "+l_line_message_code;
																	if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
																}
																if (claimLineMessList.item(l).getNodeName().equals("era:Description"))
																{
																	l_line_message_desc =  nodeValue;
																	l_app_msg = " ::: l_line_message_desc ::: "+l_line_message_desc;
																	if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
																}
															}
														}
														// Insert into XF_ERA_CLAIM_LINE_REASON

														l_insert_count = 0;

														l_insert_stmt = " INSERT INTO XF_ERA_CLAIM_LINE_REASON (MK_ERA_NO, CLAIM_ID	, LINE_ID, REASON_ID, REASON_TYPE, REASON_CODE, REASON_DESC) "
																						+"				VALUES (?, ?, ?, ?, ?, ?, ?) ";

														pstmt = dbConn.prepareStatement(l_insert_stmt);					
														pstmt.setString(1, l_era_nbr);
														pstmt.setString(2, l_claim_id);
														pstmt.setString(3, l_line_id);
														pstmt.setString(4, l_line_message_id);
														pstmt.setString(5, l_line_message_type);
														pstmt.setString(6, l_line_message_code);	
														pstmt.setString(7, l_line_message_desc);	

														l_insert_count = pstmt.executeUpdate();

														l_app_msg = " ::: Insert into XF_ERA_CLAIM_LINE_REASON l_insert_count : "+l_insert_count;
														if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

													}
												}
											}
										}
										for(int k=0; k < claimLineChildList.getLength(); k++)
										{											
											if (!(claimLineChildList.item(k).getNodeName().equals("#text")))
											{											
												if (claimLineChildList.item(k).getNodeName().equals("era:Deduction"))
												{
													l_line_deduction_id = ""; l_line_deduction_type = ""; l_line_deduction_amount = "";

													if (claimLineChildList.item(k).getNodeType() == Node.ELEMENT_NODE) 
													{
														Element el = (Element) claimLineChildList.item(k);
														l_line_deduction_id =  el.getAttribute("id");
														l_app_msg = " ::: l_line_deduction_id : "+l_line_deduction_id;
														if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
													}

													Node claimLineDedNode = (Node) claimLineChildList.item(k);
													if (claimLineDedNode.hasChildNodes())
													{
														NodeList claimLineDedList = claimLineDedNode.getChildNodes();

														for(int l=0; l < claimLineDedList.getLength(); l++)
														{											
															nodeValue = "";

															if (claimLineDedList.item(l).getNodeType() == Node.ELEMENT_NODE)
															{	
																nodeValue = GetElementNodeValue(claimLineDedList, l);
																
																if (claimLineDedList.item(l).getNodeName().equals("era:Type"))
																{
																	l_line_deduction_type =  nodeValue;
																	l_app_msg = " ::: l_line_deduction_type ::: "+l_line_deduction_type;
																	if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
																}
																if (claimLineDedList.item(l).getNodeName().equals("era:Amt"))
																{
																	l_line_deduction_amount = nodeValue;
																	l_app_msg = " ::: l_line_deduction_amount ::: "+l_line_deduction_amount;
																	if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
																}
															}
														}
														// Insert into XF_ERA_CLAIM_LINE_DED

														l_insert_count = 0;

														l_insert_stmt = " INSERT INTO XF_ERA_CLAIM_LINE_DED (MK_ERA_NO, CLAIM_ID, LINE_ID, DEDUCTION_ID, DEDUCTION_TYPE, DEDUCTION_AMOUNT) "
																						+"				VALUES (?, ?, ?, ?, ?, ?) ";

														pstmt = dbConn.prepareStatement(l_insert_stmt);					
														pstmt.setString(1, l_era_nbr);
														pstmt.setString(2, l_claim_id);
														pstmt.setString(3, l_line_id);
														pstmt.setString(4, l_line_deduction_id);
														pstmt.setString(5, l_line_deduction_type);
														pstmt.setDouble(6, Double.parseDouble(l_line_deduction_amount));	

														l_insert_count = pstmt.executeUpdate();

														l_app_msg = " ::: Insert into XF_ERA_CLAIM_LINE_DED l_insert_count : "+l_insert_count;
														if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

													}
												}
											}
										}
									}
								}								
							}
						}
					}						
				}
			}
		}
		catch (Exception e)
		{
			reqParam.put("ERACLAIMSTATUS", "E");
			reqParam.put("ERACLAIMSTATUSMESSAGE", " Error in Processing ERA Claim : "+e.getMessage());
			e.printStackTrace();
			return reqParam;
		}
		finally
		{			
			closeDBResources(rs, pstmt, null);			
		}

		reqParam.put("ERACLAIMSTATUS", "S");
		reqParam.put("ERACLAIMSTATUSMESSAGE", " Successfully Processed ERA Claims. ");

		return reqParam;
	}	
	
	public String ReadFile(String fileName, String filePath)
	{
		String l_app_msg = "", l_xml_msg = ""; String line = null;

		String l_file_name = "";

		FileReader fileReader = null;
		BufferedReader bufferedReader = null;

		l_app_msg = " ::: Inside WriteFile ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		try {

				l_file_name = filePath+File.separator+fileName;

				fileReader = new FileReader(fileName);

				bufferedReader = new BufferedReader(fileReader);

				while((line = bufferedReader.readLine()) != null) {
					l_xml_msg = l_xml_msg + line;
				}   

				// Always close files.
				bufferedReader.close();  
				
				l_app_msg = " ::: l_xml_msg ::: "+l_xml_msg;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			}
			catch(FileNotFoundException ex) {
				return "Error" + "$!^"+ "FILE_NOT_FOUND" + "$!^"+ l_app_msg + "$!^" + l_file_name + "$!^" + ex.getMessage();          
			}        
			catch(IOException ex) {
				return "Error" + "$!^"+ "Error in reading file" + "$!^" + l_app_msg + "$!^" +  l_file_name + "$!^" + ex.getMessage(); 
			}		

		return "S" + "$!^"+ l_xml_msg + "$!^"+ l_file_name + "$!^" + "";

	}

	public String FetchResponseMessage(String directoryName, String fileName )
	{		
		String l_response_msg = "";
		String l_app_msg = "", l_file_name = "";

		try{

			l_app_msg = "Inside FetchResponseMessage ::: ";
	        if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_app_msg = " ::: directoryName : "+ directoryName +" ::: fileName : "+fileName;
	        if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			File folder = new File(directoryName);

			String filename = directoryName+ File.separator+ fileName;	
			if (l_debug_YN.equals("Y")) System.out.println(" ::: filename ::: "+filename);

			l_response_msg = XHUtil.readFile(filename);
			
			l_app_msg = "FetchResponseMessage::: read success :: l_response_msg : "+l_response_msg ;
			//if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);			
	           
		}
		catch(Exception e)
		{
			return "Error in " + "$!^"+ l_app_msg + "$!^" + l_file_name + "$!^" + e.getMessage(); 
		}

		return l_response_msg;
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

		l_app_msg = " ::: l_field_value ::: "+l_field_value;
		//if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

		return l_field_value;
	}	
	
	public String GenerateTransIDMethod(String SeqenceName){

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
			dbConn =  ConnectionManager.getConnection();
			query = "select "+SeqenceName+".NEXTVAL TRANSID FROM DUAL " ;

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
		finally
		{			
			closeDBResources(rs, pstmt, dbConn);			
		}		

		return l_field_value;
	}

	public String GetResponseMessage(String l_file_directory, String l_file_name)
	{
		
		String l_app_msg = "";
		String l_response_msg = "";
		
		String l_success_flag = "S";

		l_app_msg = "Inside GetResponseMessage...";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = "::: l_file_directory : "+l_file_directory+ " ::: l_file_name : "+l_file_name;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

		try
		{
			l_response_msg = FetchResponseMessage(l_file_directory, l_file_name);
			l_response_msg = l_response_msg.trim();

			if (l_response_msg.indexOf("Error in")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_response_msg;
			}
			l_app_msg = " ::: l_response_msg : "+l_response_msg;
			//if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			if (l_errcd.equals("S"))
			{
				if (l_response_msg.equals("FILE_NOT_FOUND"))
				{
					l_success_flag = "F";
					l_response_msg = "<STATUS>" + l_success_flag + "$!^<FILE_TYPE>" + "ERA" + "$!^<FILE_NAME>" + l_file_name + "$!^<RESPONSE>" + l_response_msg +"$!^";
				}
				else
				{
					if (l_response_msg.length()>0)
					{
						l_success_flag = "S";
						l_response_msg = "<STATUS>" + l_success_flag + "$!^<FILE_TYPE>" + "ERA" + "$!^<FILE_NAME>" + l_file_name + "$!^<RESPONSE>" + l_response_msg +"$!^";
					}
				}
			}
			
		}
		catch (Exception e)
		{
			l_app_msg = " Error in reading the file - "+e.getMessage();
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			l_success_flag = "F";
			l_file_name = "";
			l_response_msg = "<STATUS>" + l_success_flag + "$!^<FILE_TYPE>" + "ERA" + "$!^<FILE_NAME>" + l_file_name + "$!^<RESPONSE>" + l_app_msg +"$!^";
			return l_response_msg;
		}
		
		l_app_msg = " ::: Return Response Message :::  "+l_response_msg;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		return l_response_msg;

	}	

	public String UpdateInteractiveDetails(Map params)
	{
		Connection dbConn = null;

		ResultSet rs=null;
		PreparedStatement pstmt = null;
		String query = "", l_insert_stmt = "", l_update_stmt = "";
		String errorCode = "", errorMsg = "";
		String l_request_date_str = "";

		String l_episode_type = "", l_encounter_id = "";

		String l_response_msg = "", l_response_str = "", l_errcd = "", l_errmsg = "", l_response_syntax = "";
		int l_trans_value = 0;

		java.sql.Timestamp l_current_date = null;

		String l_request_txt = "";

		String l_app_msg = "";

		int l_interactive_count = 0, l_insert_count = 0, l_update_count = 0;

		oracle.sql.CLOB l_response_clob = null;

		try
		{
			l_app_msg = "Inside UpdateInteractiveDetails...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_trans_value = Integer.parseInt(params.get("MSG_ID").toString());

			l_app_msg = " ::: PGM_ID : "+ params.get("PGM_ID").toString() + " ::: TRX_NO : " + l_trans_value + " ::: EVENT_TYPE : "+ params.get("EVENT_TYPE").toString();
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);				

			dbConn = ConnectionManager.getConnection();
			query = " select count(*) INTERACTIVE_COUNT from XH_INTERACTIVE_INTEGRATION where PGM_ID = ? and TRX_NO = ? and EVENT_TYPE = ? " ;

			pstmt = dbConn.prepareStatement(query);
			pstmt.setString(1, params.get("PGM_ID").toString());
			pstmt.setInt(2, l_trans_value);
			pstmt.setString(3, params.get("EVENT_TYPE").toString());

			rs = pstmt.executeQuery();
			while(rs.next())
			{
			   l_interactive_count = rs.getInt("INTERACTIVE_COUNT");
			}
			
			l_request_date_str = params.get("REQUEST_DATE").toString();	

			l_app_msg = " ::: l_interactive_count : "+ l_interactive_count;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			if (l_interactive_count > 0 )
			{
				//update XH_INTERACTIVE_INTEGRATION table 
				l_app_msg = "Inside UPDATE XH_INTERACTIVE_INTEGRATION table ...";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_current_date = new java.sql.Timestamp(System.currentTimeMillis());
				
				l_app_msg = " ::: l_current_date : "+l_current_date;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				l_response_msg = params.get("RESPONSE_TEXT").toString();
				l_app_msg = "::: RESPONSE_TEXT : "+ l_response_msg;
				//if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_response_str = params.get("ACKNOWLEDGEMENT_TEXT").toString();
				l_app_msg = "::: ACKNOWLEDGEMENT_TEXT : "+ l_response_str;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_errcd = params.get("STATUS").toString();
				l_app_msg = "::: STATUS : "+ l_errcd;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_errmsg = params.get("ERROR_MESSAGE").toString();
				l_app_msg = "::: ERROR_MESSAGE : "+ l_errmsg;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
				
				l_response_syntax = "";
				l_app_msg = "::: REPONSE_SYNTAX : "+ l_response_syntax;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				if (l_response_syntax.equals(""))
				{
					l_response_syntax = "";
				}
				
				try
				{
					pstmt = null;

					l_update_stmt = " UPDATE XH_INTERACTIVE_INTEGRATION "
									+" SET	RESPONSE_TEXT	= ?, "
									+" ACKNOWLEDGMENT_TEXT	= ?, "
									+" STATUS				= ?, "
									+" ERROR_TEXT			= ?, "
									+" MODIFIED_DATE		= ?, "
									+" REPONSE_SYNTAX	= ? "
									+" WHERE MESSAGE_ID     = ? " 
										+" AND PGM_ID		= ? " ;

					pstmt = dbConn.prepareStatement(l_update_stmt);
					
					l_response_clob = stringToClob(l_response_msg, dbConn);
					pstmt.setClob(1, l_response_clob);

					//pstmt.setString(1, l_response_msg);
					pstmt.setString(2, l_response_str);
					pstmt.setString(3, l_errcd);
					pstmt.setString(4, l_errmsg);
					pstmt.setTimestamp(5, l_current_date);
					pstmt.setString(6, l_response_syntax);
					pstmt.setInt(7, l_trans_value);
					pstmt.setString(8, "ECLAIMS");
					l_update_count = pstmt.executeUpdate();

					l_app_msg = " ::: UPDATE XH_INTERACTIVE_INTEGRATION : MSG_ID : "+l_trans_value +" :: UpdateCount :: " +l_update_count;
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
					
					if (l_update_count == 1)
					{
						dbConn.commit();		
						errorCode = "S";
						errorMsg = "Interactive Integration Transaction table updated successfully ";
					}
					else
					{
						dbConn.rollback();	
						l_errcd = "E";
						l_errmsg = " Error in updating Interactive Integration Records ";	
						
						errorCode = "E";
						errorMsg = l_errmsg;

						return errorMsg;
					}

					l_response_clob = null;

				}
				catch(Exception e)
				{
					l_errcd = "E";
					l_errmsg = "Error in MSG_ID : "+l_trans_value +" ::: "+ l_app_msg + " : " +  e.getMessage();
					errorCode = "E";
					errorMsg = l_errmsg;
					return errorMsg;
				}
				finally
				{			
					closeDBResources(rs, pstmt, dbConn);				
				}	
			}
			else
			{
				// Insert into XH_INTERACTIVE_INTEGRATION table 
				l_app_msg = "Inside INSERT XH_INTERACTIVE_INTEGRATION table ...";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_current_date = new java.sql.Timestamp(System.currentTimeMillis());

				l_app_msg = "::: LOGIN_USER : "+ params.get("LOGIN_USER").toString();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				
				l_app_msg = "::: CLIENT_MACHINE : " + params.get("CLIENT_MACHINE").toString();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = "::: PGM_ID : "+ params.get("PGM_ID").toString();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = "::: MODULE_ID : "+ params.get("MODULE_ID").toString();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = "::: SESSION_ID : " + params.get("SESSION_ID").toString();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = "::: REQUEST_DATE : "+ l_current_date;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = "::: REQUEST_TEXT : "+ params.get("REQUEST_TEXT").toString();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
          
				l_app_msg = "::: APPLICATION_ID : " + params.get("APPLICATION_ID").toString();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = "::: MSG_ID : "+ l_trans_value;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				
				l_app_msg = "::: FACILITY_ID : "+ params.get("FACILITY_ID").toString();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = "::: MESSAGE_DATE : " + l_current_date;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = "::: EVENT_TYPE : "+ params.get("EVENT_TYPE").toString();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = "::: PATIENT_ID : "+ params.get("PATIENT_ID").toString();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_episode_type = params.get("EPISODE_TYPE").toString();
                l_request_txt  = params.get("REQUEST_TEXT").toString();

				if(l_request_txt.equals("XXX")){
                    l_request_txt = "";
				}
				l_app_msg = "::: EPISODE_TYPE : " + l_episode_type;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);				

				l_encounter_id = params.get("ENCOUNTER_ID").toString();

				l_app_msg = "::: ENCOUNTER_ID : "+ l_encounter_id;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);				

				l_app_msg = "::: ACC_NO : "+ params.get("ACC_NO").toString();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = "::: REQUEST_SYNTAX : "+ params.get("REQUEST_SYNTAX").toString();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = "::: PROTOCOL_LINK_ID : " + params.get("PROTOCOL_LINK_ID").toString();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = "::: ADDED_BY_ID : "+ XHDBAdapter.isNullReplace(params.get("ADDED_BY_ID").toString(), params.get("LOGIN_USER").toString());
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = "::: MODIFIED_BY_ID : "+ XHDBAdapter.isNullReplace(params.get("MODIFIED_BY_ID").toString(), params.get("LOGIN_USER").toString());
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = "::: MODIFIED_BY_DATE : "+ l_current_date;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = "::: PROFILE : "+ params.get("PROFILE").toString();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_errmsg = params.get("ERROR_MESSAGE").toString();
				l_app_msg = "::: ERROR_MESSAGE : "+ l_errmsg;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				try
				{
					pstmt = null;

					l_insert_stmt = " INSERT into XH_INTERACTIVE_INTEGRATION (USER_ID, MACHINE_NAME, WS_NO, PGM_ID, MODULE_ID, "				
										+" SESSION_ID, REQUEST_DATE, REQUEST_TEXT, APPLICATION_ID, MESSAGE_ID, "
										+" FACILITY_ID, MESSAGE_DATE, EVENT_TYPE, PATIENT_ID, EPISODE_TYPE, "
										+" ENCOUNTER_ID, ACCESSION_NUM, REQUEST_SYNTAX, PROTOCOL_LINK_ID, ADDED_BY_ID, "
										+" ADDED_DATE, MODIFIED_BY_ID, MODIFIED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, "
										+" MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, TRX_NO, PROFILE_ID, ERROR_TEXT) "
										+" values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";			

					pstmt = dbConn.prepareStatement(l_insert_stmt);

					l_app_msg = "::: 1 : ";
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

					pstmt.setString(1, XHDBAdapter.isNullReplace(params.get("LOGIN_USER").toString(),"INTERFACE"));
					pstmt.setString(2, XHDBAdapter.isNullReplace(params.get("CLIENT_MACHINE").toString(),"DFLT_WSNO"));
					pstmt.setString(3, XHDBAdapter.isNullReplace(params.get("CLIENT_MACHINE").toString(),"DFLT_WSNO"));
					pstmt.setString(4, XHDBAdapter.isNullReplace(params.get("PGM_ID").toString(),"ECLAIMS"));
					pstmt.setString(5, XHDBAdapter.isNullReplace(params.get("MODULE_ID").toString(),"XI"));
					
					l_app_msg = "::: 2 : ";
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

					pstmt.setString(6, XHDBAdapter.isNullReplace(params.get("SESSION_ID").toString(),"INTERFACE"));
					pstmt.setTimestamp(7, l_current_date);
					pstmt.setString(8, l_request_txt);
					pstmt.setString(9, XHDBAdapter.isNullReplace(params.get("APPLICATION_ID").toString(),"ECLAIMS"));
					pstmt.setString(10, params.get("MSG_ID").toString());

					l_app_msg = "::: 3 : ";
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

					pstmt.setString(11, XHDBAdapter.isNullReplace(params.get("FACILITY_ID").toString(),"DF"));
					pstmt.setTimestamp(12, l_current_date);
					pstmt.setString(13, XHDBAdapter.isNullReplace(params.get("EVENT_TYPE").toString(),"ERA"));
					pstmt.setString(14, XHDBAdapter.isNullReplace(params.get("PATIENT_ID").toString(),""));

					l_app_msg = "::: 4 : ";
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

					pstmt.setString(15, ""); //Episode Type

					l_app_msg = "::: 5 : ";
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
					
					pstmt.setInt(16, 0); //Encounter ID					

					l_app_msg = "::: 6 : ";
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
										
					pstmt.setString(17, XHDBAdapter.isNullReplace(params.get("ACC_NO").toString(),""));
					pstmt.setString(18, XHDBAdapter.isNullReplace(params.get("REQUEST_SYNTAX").toString(),""));
					pstmt.setString(19, XHDBAdapter.isNullReplace(params.get("PROTOCOL_LINK_ID").toString(),"ECLAIMSERA"));
					pstmt.setString(20, XHDBAdapter.isNullReplace(params.get("ADDED_BY_ID").toString(), params.get("LOGIN_USER").toString()));

					l_app_msg = "::: 7 : ";
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

					pstmt.setTimestamp(21, l_current_date);
					pstmt.setString(22, XHDBAdapter.isNullReplace(params.get("MODIFIED_BY_ID").toString(), params.get("LOGIN_USER").toString()));
					pstmt.setTimestamp(23, l_current_date);
					pstmt.setString(24, XHDBAdapter.isNullReplace(params.get("CLIENT_MACHINE").toString(),"DFLT_WSNO"));
					pstmt.setString(25, XHDBAdapter.isNullReplace(params.get("ADDED_BY_FACILITY").toString(), params.get("FACILITY_ID").toString()));

					l_app_msg = "::: 8 : ";
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

					pstmt.setString(26, XHDBAdapter.isNullReplace(params.get("CLIENT_MACHINE").toString(),"DFLT_WSNO"));
					pstmt.setString(27, XHDBAdapter.isNullReplace(params.get("ADDED_BY_FACILITY").toString(), params.get("FACILITY_ID").toString()));
					pstmt.setInt(28, l_trans_value);
					pstmt.setString(29, XHDBAdapter.isNullReplace(params.get("PROFILE").toString(),"INTERFACE"));	
					pstmt.setString(30, l_errmsg);						

					l_app_msg = "::: 9 : ";
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
					
					l_insert_count = pstmt.executeUpdate();	
					
					l_app_msg = " ::: l_insert_count : "+ l_insert_count;
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
					
					if(l_insert_count == 1) {
						errorCode = "S";
						errorMsg = "Interactive Integration table inserted successfully ";
						dbConn.commit();				
					}
					else {				
						errorMsg = "Error in inserting Interactive Integration table";
						return errorMsg;
					}
				}
				catch(Exception e)
				{
					l_errcd = "E";
					l_errmsg = "Error in "+ l_app_msg + " : " +  e.getMessage();
					return l_errmsg;
				}
				finally
				{			
					closeDBResources(rs, pstmt, dbConn);				
				}	
			}
		}
		catch (Exception exp) {
			exp.printStackTrace();
			errorMsg = " Error in (UpdateInteractiveDetails) Exception " + exp.getMessage();
			System.out.println(" Error in (UpdateInteractiveDetails) Exception " + exp.getMessage());
			return errorMsg;
		}
		finally {
			closeDBResources(rs, pstmt, dbConn);
		}

		return errorMsg;
	}	

	public static String getFormattedStringDate(String format,Date date)
    {	
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		dateFormat.setTimeZone(TimeZone.getTimeZone("CAT"));
		String dateFormatted = dateFormat.format(date);
		return dateFormatted;
    }
    
	/***********************/
	public static void closeDBResources(ResultSet rs, PreparedStatement stmt, Connection conn)
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
					if(conn != null) ConnectionManager.returnConnection(conn);					
				}
				catch (Exception exp) { }				
			}
		}
	}

	
	public List FetchFiles(String profileId, String applicationId){
		String l_file_directory = "",l_app_msg = "";
		Connection dbConn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;
		String query="";
		String l_debug_yn = "";
		String l_success_flag = "",l_file_name = "",l_response_msg= "",l_request_type= "";
		l_errcd = "S";
		List fileDetails=new ArrayList();
       try
		{
		   l_app_msg = "Inside ProcessRequest...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			dbConn =  ConnectionManager.getConnection();
			query = "select NVL(DEBUG_YN, 'N') DEBUG_YN FROM XH_PARAM " ;

			pstmt = dbConn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
			   l_debug_yn = rs.getString("DEBUG_YN");
			}

			l_debug_YN = l_debug_yn;

			l_app_msg = ":: l_debug_YN :: "+l_debug_YN;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

		}
		catch(Exception e)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + e.getMessage() ;
		}	
		finally
		{
			XHUtil.closeDBResources(rs, pstmt, dbConn);
		}

		try
			{	
			l_app_msg = "Calling Fetch Protocol Method...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_file_directory = FetchProtocolDetails("ECLAIMSERA");
			if (l_file_directory.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_file_directory;
				
			}
			l_app_msg = " ::: File  Directory : "+l_file_directory;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				

            if(l_errcd.equals("S")){
				l_app_msg = "Calling GetFile Method...";
			    if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				File[] files= getFile(l_file_directory);

				for(int i=0;i<files.length;i++){
					l_app_msg = "Calling getFileProperties Method...";
			        if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

					if (files[i].isFile())
					{
						fileDetails.add(getFileProperties(l_file_directory,files[i]));
					}		
					
				}
    	    }
			
          //FileData=getLatestFile(getLatestFilefromDir(l_file_directory).toString());

		}catch (Exception e)
			{
				l_app_msg = " Error in reading the file - "+e.getMessage();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
				l_success_flag = "4";
				l_file_name = "";
				l_response_msg = "<STATUS>" + l_success_flag + "$!^<FILE_TYPE>" + l_request_type + "$!^<FILE_NAME>" + l_file_name + "$!^<RESPONSE>" + l_app_msg +"$!^";
			
			}
      return fileDetails;
	}
	
    private  List getFileProperties(String Path,File file){
        String l_app_msg = "";
		l_app_msg = " ::: Inside getFileProperties Method ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = " ::: Path ::: "+Path;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

        List fileProperties = new ArrayList();
		
		l_app_msg = " ::: Name ::: "+file.getName()+" ::: lastModified ::: "+file.lastModified()+" ::: length ::: "+file.length();
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		long lastModified = file.lastModified();

		l_app_msg = " ::: lastModified ::: "+lastModified;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

		Date date = new Date(lastModified); 
		// the format of your date
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		// give a timezone reference for formatting (see comment at the bottom)
		sdf.setTimeZone(TimeZone.getTimeZone("GMT")); 
		String formattedDate = sdf.format(date);
        try
		{
			SimpleDateFormat sourceDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date dateObj = sourceDateFormat.parse(formattedDate);
			SimpleDateFormat desiredDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			formattedDate = desiredDateFormat.format(dateObj).toString();
		}
		catch(Exception e)
		{
			l_app_msg = " ::: Exception ::: "+e.getMessage();
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		}

        l_app_msg = " ::: formattedDate ::: "+formattedDate;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

		//String lastModified = Long.toString(file.lastModified());
		String filesize = Long.toString(file.length());
        
		fileProperties.add(file.getName());
		fileProperties.add(formattedDate);
		fileProperties.add(filesize);
		fileProperties.add(Path);
    	
		return fileProperties;	
    }
    
    private  File[] getFile(String Path){
		String l_app_msg = "";

        l_app_msg = " ::: Inside getFile Method ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		 l_app_msg = " ::: Path ::: "+Path;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

    	File folder = new File(Path);

		FilenameFilter fileNameFilter = new FilenameFilter() {
   
            public boolean accept(File dir, String name) {
               if(name.lastIndexOf('.')>0) {
               
                  // get last index for '.' char
                  int lastIndex = name.lastIndexOf('.');
                  
                  // get extension
                  String str = name.substring(lastIndex);
                  
                  // match path name extension
                  if(str.equals(".xml")) {
                     return true;
                  }
               }
               
               return false;
            }
         };
         
		
		File[] listOfFiles = folder.listFiles(fileNameFilter);
		return listOfFiles ;   	
    
    }
	
	public String FetchProtocolDetails(String protocolLinkID){
		Connection dbConn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;

		String query = "";
		String l_app_msg = "";

		String l_profile_id = "", l_file_directory = "", l_standard_code = "";

		l_app_msg = " ::: Inside FetchProtocolDetails ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = " ::: Protocol Link ID : "+ protocolLinkID ;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		
		try
		{
			dbConn =  ConnectionManager.getConnection();
			query = "SELECT    nvl(profile_id,'') profile_id, nvl(standard_code,'') standard_code, "
						+ " nvl(file_directory,'') file_directory "
			            + " FROM    xh_protocol a, xh_protocol_link b "
						+ " WHERE    a.protocol_id = b.protocol_id AND b.protocol_link_id = ? ";

			pstmt = dbConn.prepareStatement(query);
			pstmt.setString(1, protocolLinkID);			
			rs = pstmt.executeQuery();
			while(rs.next())
			{
			   l_file_directory = rs.getString("FILE_DIRECTORY");
			   l_profile_id = rs.getString("PROFILE_ID");
			   l_standard_code = rs.getString("STANDARD_CODE");
			}

			l_app_msg = " ::: Profile ID : "+ l_profile_id + " ::: Standard Code : "+ l_standard_code + " ::: File Directory : "+l_file_directory;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		}
		catch(Exception e)
		{
			e.printStackTrace();
			l_file_directory = "Error in "+ l_app_msg + " : " +  e.getMessage();
		}
		finally
		{			
			closeDBResources(rs, pstmt, dbConn);				
		}	
		
		l_app_msg = " ::: l_file_directory : "+l_file_directory;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		return l_file_directory;
	}	

	protected static String GetElementNodeValue(NodeList list, int listNo) {
		
		String l_app_msg = "", nodeValue = "";

		l_app_msg = " ::: list.item("+listNo+").getNodeName() ::: "+list.item(listNo).getNodeName();
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

		Element e2 = (Element) list.item(listNo);

		l_app_msg = " ::: e2.hasChildNodes() ::: "+e2.hasChildNodes();
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

		if (e2.hasChildNodes())
		{
			NodeList eleNodeList = e2.getChildNodes();

			l_app_msg = " ::: eleNodeList.getLength() ::: "+eleNodeList.getLength();
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			if (eleNodeList.getLength()>0)
				nodeValue = eleNodeList.item(0).getNodeValue();	
			
			return nodeValue;
		}

        return "";
    }

	public boolean CheckForERADetails(String eraID)
	{
		Connection dbConn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;

		String query = "";
		String l_app_msg = "";	
		
		int l_count = 0;

		boolean l_era_flag = false;

		l_app_msg = " ::: Inside CheckForERADetails ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = " ::: ERA ID : "+ eraID ;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		
		try
		{
			dbConn =  ConnectionManager.getConnection();
			query = "SELECT   count(*) ERA_COUNT FROM XF_ERA_HDR WHERE MK_ERA_NO = ? ";

			pstmt = dbConn.prepareStatement(query);
			pstmt.setString(1, eraID);			
			rs = pstmt.executeQuery();
			while(rs.next())
			{
			   l_count = rs.getInt("ERA_COUNT");
			}

			l_app_msg = " ::: ERA ID : "+ eraID + " ::: COUNT : "+ l_count;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			if (l_count>0)
				l_era_flag = true;
			else
				l_era_flag = false;

			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			l_app_msg = " ::: Inside CheckForERADetails Exception ::: "+ e.getMessage();
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			return false;
		}
		finally
		{			
			closeDBResources(rs, pstmt, dbConn);				
		}	
		
		return l_era_flag;
	}	

	private  void doMove(String directory,String fileName) 
	{
		// File (or Directory) to be moved
        File file = new File(directory+File.separator+fileName);
 
        // Destination directory
        File dir = new File(directory+File.separator+"Processed");
 
        if (!dir.exists()) {
			dir.mkdir();
		}
 
        // Move file to a new directory
        boolean success = file.renameTo(new File(dir, file.getName()));
 
        if (success) {
            System.out.println("File was successfully moved.\n");
        } else {
            System.out.println("File was not successfully moved.\n");
        }	 
	} 

	public String GetBillDetails(String ClaimId)
	{
		Connection dbConn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;

		String query = "";
		String l_app_msg = "";	
		
		String l_doc_type = "", l_return_str = "";
		int l_doc_num = 0;

		l_app_msg = " ::: Inside GetBillDetails ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = " ::: Claim ID : "+ ClaimId ;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		
		try
		{
			dbConn =  ConnectionManager.getConnection();
			query = "SELECT   DOC_TYPE_CODE, DOC_NUM FROM XF_ECLAIMS_TRX_HDR WHERE TRANS_TYPE = 'ECLREQ' and EVENT_TYPE = 'CLA' AND CLAIM_NUM = ? ";

			pstmt = dbConn.prepareStatement(query);
			pstmt.setString(1, ClaimId);			
			rs = pstmt.executeQuery();
			while(rs.next())
			{
			   l_doc_type = rs.getString("DOC_TYPE_CODE");
			   l_doc_num = rs.getInt("DOC_NUM");
			}

			l_app_msg = " ::: DOC_TYPE_CODE : "+ l_doc_type + " ::: DOC_NUM : "+ l_doc_num;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			l_return_str = "S"+ "!!!" + l_doc_type +"!!!"+ l_doc_num;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			l_app_msg = " ::: Inside GetBillDetails Exception ::: "+ e.getMessage();
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			l_return_str = "E"+ "!!!" + "" +"!!!"+ "";
			return l_return_str;
		}
		finally
		{			
			closeDBResources(rs, pstmt, dbConn);				
		}	
		
		return l_return_str;
	}	

	public String GetClaimNoDetails(String billDocType, int billDocNo)
	{
		Connection dbConn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;

		String query = "";
		String l_app_msg = "";	
		
		String l_return_str = "";
		int l_doc_num = 0;

		l_app_msg = " ::: Inside GetClaimNoDetails ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = " ::: Bill Doc Type Code : "+ billDocType +" ::: Bill Doc No : "+ billDocNo ;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		
		try
		{
			dbConn =  ConnectionManager.getConnection();
			query = "SELECT max(SRL_NO) SRL_NO FROM XF_ECLAIMS_TRX_HDR "
						+" WHERE TRANS_TYPE = 'ECLREQ' and (EVENT_TYPE = 'CLA' OR EVENT_TYPE = 'CLE') "
						+"		and APPROVAL_STATUS IN (Select STATUS_CODE from XH_TRANS_STATUS where TRANS_EVENT = 'ERA' and TRANS_TYPE = 'CLA') "
						+"		AND DOC_TYPE_CODE = ? and DOC_NUM = ? ";

			pstmt = dbConn.prepareStatement(query);
			pstmt.setString(1, billDocType);
			pstmt.setInt(2, billDocNo);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
			   l_doc_num = rs.getInt("SRL_NO");
			}

			l_app_msg = "::: DOC_NUM : "+ l_doc_num;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			l_return_str = "S"+ "#"+ l_doc_num;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			l_app_msg = " ::: Inside GetBillDetails Exception ::: "+ e.getMessage();
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			l_return_str = "E"+ "!!!"+ "";
			return l_return_str;
		}
		finally
		{			
			closeDBResources(rs, pstmt, dbConn);				
		}	
		
		return l_return_str;
	}

	public CLOB stringToClob(String stringData, Connection dbConn) 
	{
        CLOB clob = null;
		//Connection dbConn = null;

        try 
		{
			//dbConn =  ConnectionManager.getConnection();
            clob = oracle.sql.CLOB.createTemporary(dbConn, false, CLOB.DURATION_SESSION);
            clob.setString(1, stringData);
        } catch (SQLException sqlException) {
            System.out.println("Exception thrown in stringtoClob function : SQL Exception : " + sqlException.getMessage());
        }
 
        return clob;
	}
	
}
