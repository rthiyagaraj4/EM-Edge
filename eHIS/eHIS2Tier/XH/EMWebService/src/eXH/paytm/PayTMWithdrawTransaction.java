package eXH.paytm;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.Date;
import java.text.*;
import java.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import java.io.InputStream;

import com.paytm.pg.merchant.CheckSumServiceHelper;

import eXH.util.*;

public class PayTMWithdrawTransaction implements XHTransactionInterface 
{

	//Class variables 
	public static final String l_segment_id = "PTR";
	public static final String l_standard_code = "HTTPCC";	

	public static final String l_field_separator= "$!^";

	public static String l_debug_YN = "N";

	public String l_errcd = "S";
    public String l_errmsg = "";
    public String l_ack_text = "";	

	public String TransRequestMethod(String profileId, String applicationId, String actionKey){
		String l_app_msg = "", l_element_id = "";
		String l_trans_value = "";

		int l_trans_id = 0;

		String l_request = "", l_order_id = "", l_patient_id = "", l_encounter_id = "", l_facility_id = "", l_episode_type = "", l_session_id = "", l_user_id = "", l_request_msg = "", l_aes_key = "", l_check_sum = "", l_response_msg = "", l_response_str = "",l_user_wsno = "";

		String l_request_date = "";

		Connection dbConn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;

		String query = "", l_debug_yn = "", updateStmt = "";

		int updateCount = 0;		
		
		try
		{
			dbConn =  EMDataSource.getConnection();
			//dbConn =  EMDBConnectionPool.getConnection();
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
			//XHUtil.closeDBResources(rs, pstmt, dbConn);	
			XHUtil.closeDBResources(rs, pstmt, null);
			EMDataSource.returnConnection(dbConn);
		}

			
		l_app_msg = " ::: Inside PayTM TransRequestMethod Action Key ::: "+actionKey;
		if (l_debug_YN.equals("Y"))	
			System.out.println(l_app_msg);		

		l_request = FieldValueFetchMethod(actionKey, "<REQUEST>", null, l_field_separator, "TransRequestMethod");

		l_app_msg = " ::: l_request : "+l_request;
		if (l_debug_YN.equals("Y"))	
			System.out.println(l_app_msg);

		if (l_request.indexOf("Error")>=0)
		{
			return l_request;
		}

		l_app_msg = "Generating Transaction id...";
		if (l_debug_YN.equals("Y"))	
			System.out.println(l_app_msg);

		l_trans_value = GenerateTransIDMethod();
		l_app_msg = "::: l_trans_value : "+l_trans_value;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_trans_value.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_trans_value;
		}

		if (l_trans_value.length() > 0 )
		{
			l_trans_id = Integer.parseInt(l_trans_value);
		}
		
        if (l_request.equals("WITHDRAW_MONEY"))
        {   
            l_app_msg  = "Forming actionKey with Order ID..."+actionKey;
            if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

            actionKey = actionKey.replace("<ORDER_ID>","<ORDER_ID>"+ l_trans_id);
			l_app_msg  = " ::: actionKey : "+actionKey;
            if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	            
		}    
		
		if (l_request.equals("CHECK_STATUS") )
        { 
			l_app_msg = " ::: Fetching Order ID... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_order_id = FieldValueFetchMethod(actionKey,"<ORDER_ID>",null,l_field_separator, "TransRequestMethod");
			l_app_msg = " ::: l_order_id : "+l_order_id;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			if (l_order_id.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_order_id;
			}
		}

		l_app_msg = " ::: Fetching Patient ID ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_patient_id = FieldValueFetchMethod(actionKey,"<PATIENT_ID>",null,l_field_separator, "TransRequestMethod");
		l_app_msg = " ::: l_patient_id : "+l_patient_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_patient_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_patient_id;
		}

		l_app_msg = " ::: Fetching Encounter ID ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_encounter_id = FieldValueFetchMethod(actionKey,"<ENCOUNTER_ID>",null,l_field_separator, "TransRequestMethod");
		l_app_msg = " ::: l_encounter_id : "+l_encounter_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_encounter_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_encounter_id;
		}

		l_app_msg = " ::: Fetching Facility ID ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_facility_id = FieldValueFetchMethod(actionKey,"<FACILITY_ID>",null,l_field_separator, "TransRequestMethod");
		l_app_msg = " ::: l_facility_id : "+l_facility_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_facility_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_facility_id;
		}

		l_app_msg = " ::: Fetching Patient ID ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_episode_type = FieldValueFetchMethod(actionKey,"<EPISODE_TYPE>",null,l_field_separator, "TransRequestMethod");
		l_app_msg = " ::: l_episode_type : "+l_episode_type;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_episode_type.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_episode_type;
		}

		l_app_msg = " ::: Fetching Session ID ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_session_id = FieldValueFetchMethod(actionKey,"<SESSION_ID>",null,l_field_separator, "TransRequestMethod");
		l_app_msg = " ::: l_session_id : "+l_session_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_session_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_session_id;
		}

		l_app_msg = " ::: Fetching User ID ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_user_id = FieldValueFetchMethod(actionKey,"<USER>",null,l_field_separator, "TransRequestMethod");
		l_app_msg = " ::: l_user_id : "+l_user_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_user_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_user_id;
		}
		
		l_app_msg = " ::: Fetching User WSNO ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_user_wsno = FieldValueFetchMethod(actionKey,"<USER_WSNO>",null,l_field_separator, "TransRequestMethod");
		l_app_msg = " ::: l_user_id : "+l_user_wsno;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_user_wsno.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_user_wsno;
		}

		l_app_msg = " ::: Calling Withdraw Request Mesage Build Method... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		if (l_request.equals("WITHDRAW_MONEY") || l_request.equals("CHECK_STATUS"))
        {   
            l_request_msg  = MessageBuildMethod("PAYTM", actionKey);
			l_app_msg = " ::: l_request_msg : "+l_request_msg;
            if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		}  

		if (l_request_msg.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_request_msg;
		}

		l_app_msg = "Retrieving AES Key...";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

        l_element_id = "AES_KEY";

		l_aes_key = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code);
		l_app_msg = " ::: l_aes_key : "+l_aes_key;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_aes_key.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_aes_key;
		}

		l_app_msg = "Generating CheckSum value...";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		CheckSumServiceHelper checkSumServiceHelper = CheckSumServiceHelper.getCheckSumServiceHelper();	

		try
		{
			l_check_sum = checkSumServiceHelper.genrateCheckSum(l_aes_key, l_request_msg);
			l_app_msg = " ::: l_check_sum : "+l_check_sum;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);			
			
		}
		catch (Exception e)
		{
			l_errcd = "E";
			l_errmsg = "Error in Generating CheckSum - " +e.getMessage();;
		}		

		l_app_msg = "Getting Formatted l_request_date value...";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_request_date = getFormattedStringDate("dd-MMM-yyyy HH:mm:ss", new java.util.Date());

		l_app_msg = "::: l_request_date : "+l_request_date;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = "Setting  reqParams value...";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		try
		{		

			Map<String,String> reqParams = new HashMap<String,String>();
			reqParams.put("LOGIN_USER", l_user_id);
			reqParams.put("CLIENT_MACHINE", l_user_wsno); 
			reqParams.put("PGM_ID", "PAYTM");
			reqParams.put("MODULE_ID", "XB");
			reqParams.put("SESSION_ID", l_session_id);

			reqParams.put("MSG_ID", l_trans_value);
			reqParams.put("REQUEST_DATE", l_request_date); 
			reqParams.put("REQUEST_TEXT", l_request_msg); 
			reqParams.put("APPLICATION_ID", applicationId);
			reqParams.put("FACILITY_ID", l_facility_id);
			reqParams.put("MESSAGE_DATE", l_request_date); 
			reqParams.put("EVENT_TYPE", "PT01");
			reqParams.put("PATIENT_ID", l_patient_id);
			reqParams.put("EPISODE_TYPE", "");
			reqParams.put("ENCOUNTER_ID", l_encounter_id);
			reqParams.put("ACC_NO", actionKey);
			reqParams.put("EXT_ACC_NO", "");
			reqParams.put("REQUEST_SYNTAX", actionKey);
			reqParams.put("ACK_MSG_ID", "");
			reqParams.put("PROTOCOL_LINK_ID", "MCOPTM");
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
			l_response_msg = TransCommunicationMethod("MCOPTM", actionKey, l_check_sum, l_request_msg);
			l_app_msg = " ::: l_response_msg : "+l_response_msg;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			if (l_response_msg.indexOf("Error in ")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_response_msg;
			}

		}
		
		if (l_errcd.equals("S"))
		{
			l_response_str  = MessageLoadMethod(actionKey, l_response_msg);
			l_app_msg = " ::: l_response_str : "+l_response_str;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			if (l_response_str.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_response_str;
			}
		}

		dbConn = null;
		pstmt = null;

		try
		{
			dbConn =  EMDataSource.getConnection();
			//dbConn =  EMDBConnectionPool.getConnection();
			updateStmt = " UPDATE XH_INTERACTIVE_INTEGRATION "
							+" SET	response_text        = ?, "
							+" acknowledgment_text    = ?, "
							+" status            = ?, "
							+" error_text        = ? "
							+" WHERE MESSAGE_ID          = ? " 
								+" AND pgm_id = ? " ;

			pstmt = dbConn.prepareStatement(updateStmt);
			pstmt.setString(1, l_response_msg);
			pstmt.setString(2, l_response_str);
			pstmt.setString(3, l_errcd);
			pstmt.setString(4, l_errmsg);
			pstmt.setString(5, l_trans_value);
			pstmt.setString(6, "PAYTM");
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
			//XHUtil.closeDBResources(rs, pstmt, dbConn);	
			XHUtil.closeDBResources(rs, pstmt, null);
			EMDataSource.returnConnection(dbConn);
		}	

		if (l_errcd.equals("S"))
		{
			return l_response_str;
		}
		else
		{
			l_errmsg = "E" + "$!^" + "Error" + "$!^" + l_errmsg + "$!^" + l_trans_value + "$!^" + "" + "$!^" + "";
			return l_errmsg;
		}
		
	}

	public String MessageBuildMethod(String applicationId, String actionKey){
		String l_merchant_guid="", l_currency_code="", l_platform_name="", l_ip_address="", l_channel="", l_version="", l_industry_type="", l_pos_id="";
		String l_app_msg = "", l_element_id = "";

		String l_patient_id="", l_paytm_code="", l_order_id="", l_promo_code="", l_request="", l_amount = "";
		String l_request_type = "", l_trn_type = "";

		String createJsonString = "";	

		l_app_msg = "Inside MessageBuildMethod...";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	       

		l_app_msg = " ::: Fetching Request... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_request = FieldValueFetchMethod(actionKey,"<REQUEST>",null,l_field_separator, "MessageBuildMethod");
		l_app_msg = " ::: l_request : "+l_request;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_request.indexOf("Error")>=0)
		{
			return l_request;
		}

		l_app_msg = "Retrieving Merchant Id...";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

        l_element_id = "MERCHANT_GUID";

		l_merchant_guid = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code);
		l_app_msg = " ::: l_merchant_guid : "+l_merchant_guid;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_merchant_guid.indexOf("Error")>=0)
		{
			return l_merchant_guid;
		}

		l_app_msg = "Retrieving Platform Name...";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_element_id = "PLATFORM_NAME";

		l_platform_name = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code);
		l_app_msg = " ::: l_platform_name : "+l_platform_name;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_platform_name.indexOf("Error")>=0)
		{
			return l_platform_name;
		}

		l_app_msg = " ::: Fetching Order ID... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_order_id = FieldValueFetchMethod(actionKey,"<ORDER_ID>",null,l_field_separator, "MessageBuildMethod");
		l_app_msg = " ::: l_order_id : "+l_order_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_order_id.indexOf("Error")>=0)
		{
			return l_order_id;
		}

		if (l_request.equals("WITHDRAW_MONEY"))
        {  
		
			l_app_msg = "Retrieving Currency Code...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_element_id = "CURRENCY_CODE";

			l_currency_code = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code);
			l_app_msg = " ::: l_currency_code : "+l_currency_code;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			if (l_currency_code.indexOf("Error")>=0)
			{
				return l_currency_code;
			}		

			l_app_msg = "Retrieving IP Address...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_element_id = "IP_ADDRESS";

			l_ip_address = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code);
			l_app_msg = " ::: l_ip_address : "+l_ip_address;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			if (l_ip_address.indexOf("Error")>=0)
			{
				return l_ip_address;
			}

			l_app_msg = "Retrieving Channel...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_element_id = "CHANNEL";

			l_channel = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code);
			l_app_msg = " ::: l_channel : "+l_channel;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			if (l_channel.indexOf("Error")>=0)
			{
				return l_channel;
			}

			l_app_msg = "Retrieving Version...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_element_id = "VERSION";

			l_version = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code);
			l_app_msg = " ::: l_version : "+l_version;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			if (l_version.indexOf("Error")>=0)
			{
				return l_version;
			}

			l_app_msg = "Retrieving Industry Type...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_element_id = "INDUSTRY_TYPE";

			l_industry_type = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code);
			l_app_msg = " ::: l_industry_type : "+l_industry_type;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			if (l_industry_type.indexOf("Error")>=0)
			{
				return l_industry_type;
			}

			l_app_msg = "Retrieving POS Id...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_element_id = "POS_ID";

			l_pos_id = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code);
			l_app_msg = " ::: l_pos_id : "+l_pos_id;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			if (l_pos_id.indexOf("Error")>=0)
			{
				return l_pos_id;
			}

			l_app_msg = " ::: Fetching Patient ID ... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_patient_id = FieldValueFetchMethod(actionKey,"<PATIENT_ID>",null,l_field_separator, "MessageBuildMethod");
			l_app_msg = " ::: l_patient_id : "+l_patient_id;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			if (l_patient_id.indexOf("Error")>=0)
			{
				return l_patient_id;
			}

			l_app_msg = " ::: Fetching PayTM Code... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_paytm_code = FieldValueFetchMethod(actionKey,"<PAYTM_CODE>",null,l_field_separator, "MessageBuildMethod");
			l_app_msg = " ::: l_paytm_code : "+l_paytm_code;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			if (l_paytm_code.indexOf("Error")>=0)
			{
				return l_paytm_code;
			}		

			l_app_msg = " ::: Fetching Amount... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_amount = FieldValueFetchMethod(actionKey,"<AMOUNT>",null,l_field_separator, "MessageBuildMethod");
			l_app_msg = " ::: l_amount : "+l_amount;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			if (l_amount.indexOf("Error")>=0)
			{
				return l_amount;
			}

			l_app_msg = " ::: Fetching Promo Code... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_promo_code = FieldValueFetchMethod(actionKey,"<PROMO_CODE>",null,l_field_separator, "MessageBuildMethod");
			l_app_msg = " ::: l_promo_code : "+l_promo_code;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			if (l_promo_code.indexOf("Error")>=0)
			{
				return l_promo_code;
			}
		}

		if (l_request.equals("CHECK_STATUS"))
        {
			l_app_msg = " ::: Fetching Request Type... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_request_type = FieldValueFetchMethod(actionKey,"<REQUEST_TYPE>",null,l_field_separator, "MessageBuildMethod");
			l_app_msg = " ::: l_request_type : "+l_request_type;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			if (l_request_type.indexOf("Error")>=0)
			{
				return l_request_type;
			}

			l_app_msg = " ::: Fetching Transaction Type... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_trn_type = FieldValueFetchMethod(actionKey,"<TRN_TYPE>",null,l_field_separator, "MessageBuildMethod");
			l_app_msg = " ::: l_trn_type : "+l_trn_type;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			if (l_trn_type.indexOf("Error")>=0)
			{
				return l_trn_type;
			}
		}

		if (l_request.equals("WITHDRAW_MONEY"))
        { 
			l_app_msg = " ::: Generating JSON WITHDRAW_MONEY Request Object... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			XHJSONUtil.ClearJsonObjString("clear");
		
			createJsonString = XHJSONUtil.createJsonRequestString("totalAmount", l_amount);
			createJsonString = XHJSONUtil.createJsonRequestString("currencyCode", l_currency_code);			
			createJsonString = XHJSONUtil.createJsonRequestString("merchantGuid", l_merchant_guid);
			createJsonString = XHJSONUtil.createJsonRequestString("merchantOrderId", l_order_id);
			createJsonString = XHJSONUtil.createJsonRequestString("industryType", l_industry_type);
			createJsonString = XHJSONUtil.createJsonRequestString("posId", l_pos_id);
			createJsonString = XHJSONUtil.createJsonRequestString("comment", "Hi");
			createJsonString = XHJSONUtil.createJsonRequestString("promoCode", l_promo_code);
					
			XHJSONUtil.ClearJsonObjString("clear");
			
			createJsonString = XHJSONUtil.createJsonRequestObject("request", createJsonString);	
			createJsonString = XHJSONUtil.createJsonRequestString("metadata", "Testing Data");
			createJsonString = XHJSONUtil.createJsonRequestString("platformName", l_platform_name);
			createJsonString = XHJSONUtil.createJsonRequestString("ipAddress", l_ip_address);
			createJsonString = XHJSONUtil.createJsonRequestString("operationType", l_request);
			createJsonString = XHJSONUtil.createJsonRequestString("channel", l_channel);
			createJsonString = XHJSONUtil.createJsonRequestString("version", l_version);
		}

		if (l_request.equals("CHECK_STATUS"))
        {
			
			l_app_msg = " ::: Generating JSON CHECK_STATUS Request Object... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			XHJSONUtil.ClearJsonObjString("clear");

			createJsonString = XHJSONUtil.createJsonRequestString("requestType", l_request_type);
			createJsonString = XHJSONUtil.createJsonRequestString("txnType", l_trn_type);			
			createJsonString = XHJSONUtil.createJsonRequestString("merchantGuid", l_merchant_guid);
			createJsonString = XHJSONUtil.createJsonRequestString("txnId", l_order_id);
					
			XHJSONUtil.ClearJsonObjString("clear");
			
			createJsonString = XHJSONUtil.createJsonRequestObject("request", createJsonString);	
			createJsonString = XHJSONUtil.createJsonRequestString("platformName", l_platform_name);
			createJsonString = XHJSONUtil.createJsonRequestString("operationType", "CHECK_TXN_STATUS");
		}

		l_app_msg = " ::: Generated JSON Request Object : "+createJsonString;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		return createJsonString;

	}

	public String MessageLoadMethod(String actionKey, String message){

		String l_app_msg = "";
		String l_in_JSON = ""; 
		String l_status= "", l_status_code= "", l_status_msg= "", l_request="";
		String l_response_str = "";

        String l_wallet_trn_id = "", l_wallet_trn_date = "", l_wallet_timestamp= "";
		String l_txnGuid = "", l_merchantOrderId = "", l_txn_status ="";

        String l_status_return ="", l_order_id = "";

		long l_unix_time;

		l_app_msg = "Inside MessageLoadMethod...";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = " ::: Fetching Request... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_request = FieldValueFetchMethod(actionKey, "<REQUEST>", null, l_field_separator, "MessageLoadMethod");
		l_app_msg = " ::: l_request : "+l_request;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_request.indexOf("Error")>=0)
		{
			return l_request;
		}

		l_app_msg = " ::: Fetching Order ID... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_order_id = FieldValueFetchMethod(actionKey, "<ORDER_ID>", null, l_field_separator, "MessageLoadMethod");
		l_app_msg = " ::: l_order_id : "+l_order_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_order_id.indexOf("Error")>=0)
		{
			return l_order_id;
		}
		
		message = message.replaceAll("null", "\"\"");
		
		l_in_JSON = XHJSONUtil.createJsonObject(message);
		l_app_msg = " ::: l_in_JSON : "+l_in_JSON;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		if (l_in_JSON.indexOf("Error")==0)
		{
			return l_in_JSON;
		}

		if (l_request.equals("WITHDRAW_MONEY"))
		{

			l_status_code = XHJSONUtil.getJsonRequestString(message, "statusCode");
			
			l_app_msg = " ::: l_status_code : "+l_status_code;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			/*

			if (l_status_code.equals("SUCCESS"))
			{
				l_status = XHJSONUtil.getJsonRequestString(message, "status");
				l_app_msg = " ::: l_status : "+l_status;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			}	
			
			*/
			l_app_msg = " ::: message : "+message;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			l_status = XHJSONUtil.getJsonRequestString(message, "status");
			l_app_msg = " ::: l_status : "+l_status;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			if (!(l_status.length()>0))
			{
				l_status = "FAILURE";
			}

			l_status_msg = XHJSONUtil.getJsonRequestString(message, "statusMessage");

			l_app_msg = " ::: l_status_msg : " +l_status_msg;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			if (l_status_code.equals("SUCCESS"))
			{
				l_response_str = XHJSONUtil.getJsonChild(l_in_JSON, "response");
				l_wallet_trn_id = XHJSONUtil.getJsonRequestString(l_response_str, "walletSystemTxnId");
				l_wallet_timestamp = XHJSONUtil.getJsonRequestString(l_response_str, "timestamp");
			}

			// l_wallet_timestamp unix Timestamp to be converted to Oracle date and time format.

			l_app_msg = " ::: l_wallet_timestamp : "+l_wallet_timestamp;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			if (l_wallet_timestamp.length() > 0)
			{
				l_unix_time = Long.parseLong(l_wallet_timestamp);


				l_app_msg = " ::: Long.parseLong l_wallet_timestamp : "+l_unix_time;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				Date date = new Date(l_unix_time);
				//date.setTime((long)l_unix_time*1000L);

				//System.out.println("date ::: "+date);	

				DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				df.setTimeZone(TimeZone.getTimeZone("IST"));
				l_wallet_trn_date = df.format(date);
			}

			l_app_msg = " ::: Before l_status_return... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	


			l_status_return = l_status + "$!^" + l_status_code + "$!^" + l_status_msg + "$!^" + l_order_id + "$!^" + l_wallet_trn_id + "$!^" +l_wallet_trn_date;

			l_app_msg = " ::: l_status_return : "+l_status_return;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		}

		if (l_request.equals("CHECK_STATUS"))
		{
			l_status = XHJSONUtil.getJsonRequestString(l_in_JSON, "status");
			l_status_code = XHJSONUtil.getJsonRequestString(l_in_JSON, "statusCode");
			l_status_msg = XHJSONUtil.getJsonRequestString(l_in_JSON, "statusMessage");

			l_app_msg = " ::: l_status : "+l_status+ " ::: l_status_code : "+l_status_code+ " ::: l_status_msg : " +l_status_msg;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_merchantOrderId = l_order_id;

			if (l_status_code.equals("SS_001"))
			{
				l_response_str = XHJSONUtil.getJsonChild(l_in_JSON, "response");
				l_app_msg = " ::: l_response_str : "+l_response_str;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_txn_status = XHJSONUtil.getJsonArrayObjString(l_response_str, "txnList", "status");
				l_app_msg = " ::: l_txn_status : "+l_txn_status;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				
				if (l_txn_status.equals("0"))
				{
					l_status = "INIT";
				}
				if (l_txn_status.equals("1"))
				{
					l_status = "SUCCESS";
				}
				if (l_txn_status.equals("2"))
				{
					l_status = "FAILURE";
				}
				if (l_txn_status.equals("3"))
				{
					l_status = "PENDING";
				}

				l_status_code = XHJSONUtil.getJsonArrayObjString(l_response_str, "txnList", "txnErrorCode");
				l_app_msg = " ::: l_status_code : "+l_status_code;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				
				l_txnGuid = XHJSONUtil.getJsonArrayObjString(l_response_str, "txnList", "txnGuid");
				l_app_msg = " ::: l_txnGuid : "+l_txnGuid;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				
				l_status_msg = XHJSONUtil.getJsonArrayObjString(l_response_str, "txnList", "message");
				l_app_msg = " ::: l_status_msg : "+l_status_msg;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				
				l_merchantOrderId = XHJSONUtil.getJsonArrayObjString(l_response_str, "txnList", "merchantOrderId");		
				l_app_msg = " ::: l_merchantOrderId : "+l_merchantOrderId;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				
			
			}

			l_app_msg = " ::: Before l_status_return... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_status_return = l_status + "$!^" + l_status_code + "$!^" + l_status_msg + "$!^" + l_merchantOrderId + "$!^" + l_txnGuid + "$!^" + l_wallet_trn_date + "$!^" + l_txn_status;

			l_app_msg = " ::: l_status_return : "+l_status_return;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		}
		
        l_app_msg = " ::: l_status_return from JSON : "+ l_status_return;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		return l_status_return;
	}

	public String TransCommunicationMethod(String protocolLinkID, String actionKey, String checkSum, String message){
		Connection dbConn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;

		String query = "";
		String l_app_msg = "", l_element_id = "";


		String l_profile_id = "", l_standard_code = "HTTPCC";
		String l_http_user_agent = "", l_http_content_type = "", l_http_transfer_encoding = "", l_http_soapaction = "", l_url = "";
		int l_http_content_length_flag  = 0;

		String l_merchant_guid="", l_paytm_code="", l_request="", l_request_type = "", l_request_url = "", l_paytm_url = "";

		String l_payby_option="", l_otp="";
		String l_proxy_server="", l_proxy_port="";

		HttpURLConnection conn = null;

		String l_response_msg = "", l_return_resp = "";


		l_app_msg = " ::: Inside TransCommunicationMethod ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = " ::: Protocol Link ID : "+ protocolLinkID + " ::: Action Key : " + actionKey + " ::: CheckSum : "+ checkSum + " ::: Message : "+message;
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

			l_request = FieldValueFetchMethod(actionKey, "<REQUEST>", null, l_field_separator, "TransCommunicationMethod");
			l_app_msg = " ::: l_request : "+l_request;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			if (l_request.indexOf("Error")>=0)
			{
				return l_request;
			}


			l_app_msg = " ::: Fetching PayTM PAYBY_OPTION... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_payby_option = FieldValueFetchMethod(actionKey, "<PAYBY_OPTION>", null, l_field_separator, "TransCommunicationMethod");
			l_app_msg = " ::: l_payby_option : "+l_payby_option;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			if (l_payby_option.indexOf("Error")>=0)
			{
				return l_payby_option;
			}


			l_app_msg = " ::: Fetching PayTM Code... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_paytm_code = FieldValueFetchMethod(actionKey, "<PAYTM_CODE>", null, l_field_separator, "TransCommunicationMethod");
			l_app_msg = " ::: l_paytm_code : "+l_paytm_code;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			if (l_paytm_code.indexOf("Error")>=0)
			{
				return l_paytm_code;
			}

			
			l_app_msg = " ::: Fetching PayTM OTP... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_otp = FieldValueFetchMethod(actionKey, "<OTP>", null, l_field_separator, "TransCommunicationMethod");
			l_app_msg = " ::: l_otp : "+l_otp;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			if (l_otp.indexOf("Error")>=0)
			{
				return l_otp;
			}


			l_app_msg = "Retrieving Merchant Id...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_element_id = "MERCHANT_GUID";

			l_merchant_guid = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code);
			l_app_msg = " ::: l_merchant_guid : "+l_merchant_guid;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			if (l_merchant_guid.indexOf("Error")>=0)
			{
				return l_merchant_guid;
			}
			
			if (l_request.equals("WITHDRAW_MONEY"))
			{
				//l_request_type = l_request + "_URL"; 

				if (l_payby_option.equals("B"))
				{
					l_request_type = l_request + "_6URL"; 
				}
				else if (l_payby_option.equals("T"))
				{
					l_request_type = l_request + "_7URL"; 
				}
				else
				{
					l_request_type = l_request + "_URL"; 
				}

			}
			else if (l_request.equals("CHECK_STATUS"))
			{
				l_request_type = l_request + "_URL"; 
			}

			l_app_msg = "Retrieving Request URL...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_element_id = l_request_type;

			l_request_url = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code);
			l_app_msg = " ::: l_request_url : "+l_request_url;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			if (l_request_url.indexOf("Error")>=0)
			{
				return l_request_url;
			}

			l_element_id = "PROXY_SERVER";

			l_proxy_server = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code);
			l_app_msg = " ::: l_proxy_server : "+l_proxy_server;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			if (l_proxy_server.indexOf("Error")>=0)
			{
				return l_proxy_server;
			}


			l_element_id = "PROXY_PORT";

			l_proxy_port = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code);
			l_app_msg = " ::: l_proxy_port : "+l_proxy_port;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			if (l_proxy_port.indexOf("Error")>=0)
			{
				return l_proxy_port;
			}


			l_url = l_url.trim();
			l_request_url = l_request_url.trim();
			

			l_paytm_url = l_url + "/" + l_request_url;

			l_paytm_url = l_paytm_url.trim();

			l_app_msg = " ::: l_paytm_url : "+l_paytm_url+":::";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			URL url = new URL(l_paytm_url);

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

			conn.setRequestMethod("POST");
			
			// Common Headers for PayTM Transactions

			if (!(l_http_content_type.equals("XXX")))
			{
				l_app_msg = " ::: Set Property Content-Type...";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
				conn.setRequestProperty("Content-Type", l_http_content_type);
			}	
			
			if (l_merchant_guid.length() > 0)
			{
				l_app_msg = " ::: Set Property mid...";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
				conn.setRequestProperty("mid", l_merchant_guid);
			}

			if (checkSum.length() > 0)
			{
				l_app_msg = " ::: Set Property checksumhash...";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
				conn.setRequestProperty("checksumhash", checkSum);
			}

			l_app_msg = " ::: l_request : "+l_request;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			if (l_request.equals("WITHDRAW_MONEY"))
			{
				if (l_paytm_code.length() > 0)
				{
					l_app_msg = " ::: Set Property PayTM User Code...";
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

					conn.setRequestProperty("code", l_paytm_code);

					if (l_payby_option.equals("B"))
					{
						conn.setRequestProperty("code", l_paytm_code);
					}
					else if (l_payby_option.equals("T"))
					{
						conn.setRequestProperty("phone", l_paytm_code);
						conn.setRequestProperty("Otp", l_otp);
					}
					else
					{
						conn.setRequestProperty("code", l_paytm_code);
					}
				}
			}	

			if (!(l_http_user_agent.equals("XXX")))
			{
				l_app_msg = " ::: Set Property User-Agent...";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
				conn.setRequestProperty("User-Agent", l_http_user_agent);
			}

			if (l_http_content_length_flag>0)
			{
				l_app_msg = " ::: Set Property Content-Length...";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
				conn.setRequestProperty("Content-Length", Integer.toString(message.length()));
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

			OutputStream os = conn.getOutputStream();
			os.write(message.getBytes());
			os.flush();

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
			
		}
		catch (MalformedURLException e) 
		{
			e.printStackTrace();
			l_response_msg = "Error in "+ l_app_msg + " : " +  e.getMessage();
			System.out.println(" ::: MalformedURLException ::: " +l_response_msg);			
			return l_response_msg;
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
			l_response_msg = "Error in "+ l_app_msg + " : " +  e.getMessage();
			System.out.println(" ::: IOException ::: " +l_response_msg);			
			return l_response_msg;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			l_response_msg = "Error in "+ l_app_msg + " : " +  e.getMessage();
			System.out.println(" ::: Exception ::: " +l_response_msg);
			return l_response_msg;
		}
		finally {
			//XHUtil.closeDBResources(rs, pstmt, dbConn);	
			XHUtil.closeDBResources(rs, pstmt, null);
			EMDataSource.returnConnection(dbConn);
		}
		l_app_msg = " ::: l_return_resp : "+l_return_resp;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		return l_return_resp;
	}

	public String FieldValueFetchMethod(String message, String identifier, String standardCode, String fieldSep, String procID){

		String l_app_msg = "", l_field_value = "";	

		try
		{
			
			l_app_msg = " ::: Inside FieldValueFetchMethod ::: ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_app_msg = " ::: Message : "+ message + " ::: Identifier : " + identifier + " ::: Standard Code : "+ standardCode;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			
			l_app_msg = " ::: Deriving Field Value..."+identifier;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			
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

	public String FetchStdCntrlSegMethod(String segmentID, String elementId, String standardCode){

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
			//dbConn =  EMDBConnectionPool.getConnection();
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
			//XHUtil.closeDBResources(rs, pstmt, dbConn);		
			XHUtil.closeDBResources(rs, pstmt, null);
			EMDataSource.returnConnection(dbConn);
		}
		return l_field_value;
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
			//dbConn =  EMDBConnectionPool.getConnection();
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
			//XHUtil.closeDBResources(rs, pstmt, dbConn);	
			XHUtil.closeDBResources(rs, pstmt, null);
			EMDataSource.returnConnection(dbConn);
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
