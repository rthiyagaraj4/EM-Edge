package eXH;

import java.io.IOException;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Timestamp;

import java.util.Date;
import java.text.DateFormat;
import java.text.*;
import java.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import java.io.InputStream;

import java.io.DataOutputStream;


import webbeans.eCommon.ConnectionManager;
import eXH.InterfaceUtil;
import eXH.XHJSONUtil;

class PHISTransaction 
{
	//Class variables 	

	public static String l_debug_YN = "N";

	public String l_errcd = "S";
    public String l_errmsg = "";
    public String l_ack_text = "";	

	public String TransRequestMethod(String pharmacyNoteMessage){		

		Connection dbConn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;

		String query = "", l_debug_yn = "";

		String l_app_msg = "", l_field_value = "", l_response_str = "", l_response_str_json = "";

		l_app_msg = " ::: Inside TransRequestMethod ::: ";
		System.out.println(l_app_msg);	
		
		ArrayList<String> tokenD = null;
		ArrayList<String> tokenResponse = null;
		String replacedStr = "";

		String delims = "^!^";
		StringTokenizer st = null;
		
		String l_patient_id = "", l_visit_number = "", l_transaction_id = "", l_serviceType = "", l_request_date = "";
		
		try
		{

			l_request_date = getFormattedStringDate("yyyyMMddHHmmss", new java.util.Date());

			l_app_msg = " ::: Fetching DEBUG_YN FROM XH_PARAM ::: ";
			System.out.println(l_app_msg);	

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
			l_field_value = "Error in "+ l_app_msg + " : " +  e.getMessage();
			System.out.println(l_app_msg);
		}	
		finally
		{
			XHUtil.closeDBResources(rs, pstmt, dbConn);
		}
		
		l_app_msg = "Before Calling MessageLoadMethod...";
		if (l_debug_YN.equals("Y"))	
			System.out.println(l_app_msg);		

		if (l_errcd.equals("S"))
		{
			
			l_response_str  = ParseMessageMethod(pharmacyNoteMessage);

			l_app_msg = " ::: ParseMessageMethod l_response_str : "+l_response_str;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			
			if (l_response_str.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_response_str;
			}

			replacedStr = l_response_str.replace("$!^","^!^");

			st = new StringTokenizer(replacedStr, delims );

			tokenD = new ArrayList<String>();

			while (st.hasMoreElements()) 
			{
				tokenD.add(st.nextToken());	
			}	

			if (tokenD.size()>0)
			{
				l_errcd = tokenD.get(0);

				l_app_msg = " ::: ParseMessageMethod Returned Sstatus : "+l_errcd;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				if (l_errcd.equals("S"))
				{
					l_patient_id = tokenD.get(1);
					l_visit_number = tokenD.get(2);
					l_transaction_id = tokenD.get(3);
					l_serviceType = tokenD.get(4);
				}

			}

			if (l_errcd.equals("S"))
			{			
				l_response_str  = MessageLoadMethod(pharmacyNoteMessage, l_patient_id, l_visit_number, l_transaction_id);
				l_app_msg = " ::: MessageLoadMethod l_response_str : "+l_response_str;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
				if (l_response_str.indexOf("Error")>=0)
				{
					l_errcd = "E";
					l_errmsg = l_response_str;
				}
			}
		}		

		if (l_errcd.equals("S"))
		{
			replacedStr = l_response_str.replace("$!^","^!^");

			st = new StringTokenizer(replacedStr, delims );

			tokenResponse = new ArrayList<String>();

			while (st.hasMoreElements()) 
			{
				tokenResponse.add(st.nextToken());	
			}	

			if (tokenResponse.size()>0)
			{
				l_errcd = tokenResponse.get(0);

				l_app_msg = " ::: ParseMessageMethod Returned Sstatus : "+l_errcd;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				if (l_errcd.equals("S"))
				{
					l_response_str_json = " { "
										  +" \"serviceType\" : \" "+l_serviceType+" \" ,"
										  +" \"transactionId\" : \" "+l_transaction_id+" \" , "
										  +" \"statusCode\" : \"S001\" , "
										  +" \"statusDescription\" : \" Success receive and save records \" , "
										  +" \"responseDatetime\" : \" "+l_request_date+" \"  "
										  +" } ";
				}

			}

			return l_response_str_json;
		}
		else
		{
			l_response_str_json = " { "
										  +" \"serviceType\" : \" "+l_serviceType+" \" ,"
										  +" \"transactionId\" : \" "+l_transaction_id+" \" , "
										  +" \"statusCode\" : \"E001\" , "
										  +" \"statusDescription\" : \" "+l_errmsg+" \" , "
										  +" \"responseDatetime\" : \" "+l_request_date+" \"  "
										  +" } ";
			
			return l_response_str_json;
		}
		
	}

	public String ParseMessageMethod(String message){

		String l_patient_id = "", l_visit_number = "", l_transaction_id = "", l_serviceType = "";

		String l_app_msg = "";

		String l_response_str = "";

		String l_in_JSON = "";	

		try
		{
			l_in_JSON = XHJSONUtil.createJsonObject(message);
			l_app_msg = " ::: l_in_JSON : "+l_in_JSON;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);			
			
			//l_patient_id = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "patientMrn");
			l_patient_id = XHJSONUtil.getJsonRequestString(l_in_JSON, "patientMrn");
			
			l_app_msg = " ::: l_patient_id : "+l_patient_id;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			//l_visit_number = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "visitNumber");
			l_visit_number = XHJSONUtil.getJsonRequestString(l_in_JSON, "visitNumber");
			
			l_app_msg = " ::: l_visit_number : "+l_visit_number;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			//l_transaction_id = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "transactionId");
			l_transaction_id = XHJSONUtil.getJsonRequestString(l_in_JSON, "transactionId");

			//l_serviceType = XHJSONUtil.getJsonArrayObjString(l_in_JSON, "serviceType");
			l_serviceType = XHJSONUtil.getJsonRequestString(l_in_JSON, "serviceType");
			
			l_app_msg = " ::: l_transaction_id : "+l_transaction_id;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_response_str = "S" + "$!^" + l_patient_id + "$!^" + l_visit_number + "$!^" + l_transaction_id + "$!^" + l_serviceType + "$!^" +"";
			
			l_app_msg = " ::: l_response_str : "+l_response_str;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
		}
		catch (Exception e)
		{
			l_app_msg = "Error in parsing the JSON message ::: "+e.getMessage();
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			e.printStackTrace();

			l_response_str = "E" + "$!^" + "" + "$!^" + "" + "$!^" + "" + "$!^" + l_app_msg;
		}

		return l_response_str;

	}

	public String MessageLoadMethod(String message, String patientID, String visitID, String transactionID){

		String l_app_msg = "";
		String l_in_JSON = ""; 		

		String l_request_date = "", l_status_return = "S$!^Success";

		Timestamp timestamp = null;

		l_app_msg = "Inside MessageLoadMethod...";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		
		try
		{	
			
			l_request_date = getFormattedStringDate("dd-MMM-yyyy HH:mm:ss", new java.util.Date());

			timestamp = new Timestamp(System.currentTimeMillis());

			l_app_msg = " ::: l_request_date ::: "+l_request_date;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			//l_sys_date = XHUtil.singleParamExeQry("SELECT to_char(sysdate, 'MM/DD/YYYY HH24:MI:SS') FROM dual");

			//System.out.println(" ::: l_sys_date ::: "+l_sys_date);

			Map<String,String> params = new HashMap<String,String>();

			l_in_JSON = XHJSONUtil.createJsonObject(message);
			l_app_msg = " ::: After Creating l_in_JSON ::: "+l_in_JSON;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	


			params.put("APPLICATION_ID","PHISJS");
			params.put("FACILITY_ID",	"HS");
			params.put("MSG_ID",		transactionID); //MSG_ID
			params.put("SRL_NO",		"1"); //SRL_NO
			params.put("REQUEST_DATE",	l_request_date); //REQUEST_DATE
			params.put("PROCESS_ID",	""); // PROCESS_ID

			params.put("CLIENT_ID",		""); // CLIENT_ID
			params.put("MESSAGE_TEXT",	l_in_JSON); //INBOUND_MESSAGE_TEXT
			params.put("MESSAGE_ACK_TEXT",""); // MESSAGE_ACK_TEXT
			params.put("MESSAGE_STATUS","S"); // MESSAGE_STATUS
			params.put("RD_ORDER_YN",	""); // RD_ORDER_YN

			params.put("ADDED_BY_ID",	"INTERFACE");
			params.put("ADDED_BY_DATE", l_request_date);
			params.put("CLIENT_MACHINE", "INTERFACE");
			params.put("ADDED_BY_FACILITY", "HS");

			params.put("MODIFIED_BY_ID", "INTERFACE");
			params.put("MODIFIED_BY_DATE", l_request_date);			
			params.put("CLIENT_MACHINE", "INTERFACE");
			params.put("MODIFIED_BY_FACILITY","HS");

			params.put("PATIENT_ID",		patientID);
			params.put("MERGED_PATIENT_ID",	"");
			params.put("EPISODE_TYPE",		"");
			params.put("EPISODE_ID",		visitID);
			params.put("VISIT_ID",			"");
			params.put("ACCESSION_NUM",		"");
			params.put("ACTION_TYPE",		"");

			params.put("LAST_PROC_DATE",	"");
			params.put("EVENT_STATUS",		"");
			params.put("NOT_REQ_REASON",	"");
			params.put("EXT_ACCESSION_NUM",	"");
			params.put("EVENT_TYPE",		"PN1");
			params.put("PROTOCOL_LINK_ID",	"EPHISPLI");			

			l_app_msg = "Inserting Inbound Message...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			
			l_status_return = XHUtil.insertInboundMessageDetails(params);


		
		}
		catch (Exception e)
		{
			l_errcd = "E";
			l_errmsg = "Error in setting request params : "+l_app_msg+ " - "+ e.getMessage();
			l_status_return = l_errcd + "$!^" + l_errmsg;
		}			
		
        l_app_msg = " ::: l_status_return from JSON : "+ l_status_return;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		return l_status_return;
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
			dbConn =  ConnectionManager.getConnection();
			query = "SELECT  XI_INBOUND_MESSAGE_SEQ.NEXTVAL TRANSID FROM    dual " ;

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
			XHUtil.closeDBResources(rs, pstmt, dbConn);
		}		

		return l_field_value;
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

}
