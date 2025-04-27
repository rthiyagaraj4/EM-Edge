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
import java.io.Reader;
import java.lang.StringBuffer;

import java.io.*;

import javax.xml.parsers.*;
import org.xml.sax.InputSource;
import org.w3c.dom.*;
import oracle.sql.CLOB;

import webbeans.eCommon.ConnectionManager;
import org.apache.commons.lang.StringEscapeUtils;

class EClaimsBatchTransaction 
{

	//Class variables 
	public static final String l_segment_id = "ECL";
	public static final String l_standard_code = "ECLASTD";	

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

		l_app_msg = " :::::::::::::::::::::::::::::::::::::::: Inside ProcessRequest :::::::::::::::::::::::::::::::::::::::: ";


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
		finally
		{
			XHUtil.closeDBResources(rs, pstmt, dbConn);
		}

		l_app_msg = "Fetching Request... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_request = FetchFieldValue(actionKey, "<REQUEST>", null, l_field_separator, "ProcessRequest");
		if (l_request.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_request;
		}
		l_app_msg = "Request : "+l_request;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_app_msg = "Fetching Request Type... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_request_type = FetchFieldValue(actionKey, "<REQUEST_TYPE>", null, l_field_separator, "ProcessRequest");
		if (l_request_type.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_request_type;
		}
		l_app_msg = "Request Type : "+l_request_type;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		if (l_request_type.equals("ECLREQ"))
		{
			l_response_str = GenerateClaimsRequestXML(profileId, applicationId, actionKey);
		}
		if (l_request_type.equals("ECLRES"))
		{
			l_response_str = FetchClaimsResponseXML(profileId, applicationId, actionKey);
		}

		return l_response_str;
	

	}
	public String GenerateClaimsRequestXML(String profileId, String applicationId, String actionKey){
		String l_app_msg = "";
		String l_trans_value = "", l_action_key = "";

		int l_trans_id = 0;

		String l_patient_id = "", l_encounter_id = "", l_request = "", l_request_type = "", l_user_id = "", l_facility_id = "", l_cust_code = "", l_dest_code = "", l_episode_type = "", l_wca_num = "",l_auth_num="", l_episode_id = "", l_visit_id = "";
		String l_blng_grp_id = "",  l_settlement_ind = "", l_claim_type = "";

		String l_doc_type_code = "", l_doc_no_str = "" ,l_bill_date = "";
		//int l_doc_no;

		String  l_request_msg = "", l_response_msg = "",  l_response_return = "", l_return_msg = "";
		String l_member_id = "",  l_depd_code = "", l_depd_reln = "",l_member_surname = "",l_member_initial = "";

		String l_request_date = "", l_file_name = "", l_file_directory = "", l_case_nbr = "";

		String l_write_log = "", l_workstation_id = "";

		String l_interactive_log = "", l_eclaims_header_log = "", l_eclaims_item_log = "", l_eclaims_status_log = "";

		String l_response_status = "", l_response_file_type = "", l_response_file_name = "", l_response = "";
        String l_trans_ref_no = "", l_patientid_no = "";

		//Added by bhuvana
		String l_policy_number = "";
		

		java.sql.Timestamp sqlDate = null;
	
		String  l_error_text = "";

		HashMap reqParams = null;

		String l_event_type = "";

		boolean l_check_network_error = false;

		l_action_key = actionKey;
			
		l_app_msg = "Inside GenerateClaimsRequestXML...";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_app_msg = "Fetching Patient ID ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_patient_id = FetchFieldValue(actionKey,"<PATIENT_ID>",null,l_field_separator, "GenerateClaimsRequestXML");
		if (l_patient_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_patient_id ;
		}
		l_app_msg = "Patient ID... "+l_patient_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = "Fetching Encounter ID ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_encounter_id = FetchFieldValue(actionKey,"<ENCOUNTER_ID>",null,l_field_separator, "GenerateClaimsRequestXML");
		if (l_encounter_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_encounter_id ;
		}
		l_app_msg = "Encounter ID... "+l_encounter_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = "Fetching Episode Type... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_episode_type = FetchFieldValue(actionKey,"<EPISODE_TYPE>",null,l_field_separator, "GenerateClaimsRequestXML");
		if (l_episode_type.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_episode_type ;
		}
		l_app_msg = "Episode Type... "+l_episode_type;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = "Fetching Episode ID... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_episode_id = FetchFieldValue(actionKey,"<EPISODE_ID>",null,l_field_separator, "GenerateClaimsRequestXML");
		if (l_episode_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_episode_id ;
		}
		l_app_msg = "Episode ID... "+l_episode_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = "Fetching Visit ID... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_visit_id = FetchFieldValue(actionKey,"<VISIT_ID>",null,l_field_separator, "GenerateClaimsRequestXML");
		if (l_visit_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_visit_id ;
		}
		l_app_msg = "Visit ID... "+l_visit_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = "Fetching Request... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_request = FetchFieldValue(actionKey, "<REQUEST>", null, l_field_separator, "GenerateClaimsRequestXML");
		if (l_request.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_request;
		}
		l_app_msg = "Request... "+l_request;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_app_msg = "Fetching Request Type... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_request_type = FetchFieldValue(actionKey, "<REQUEST_TYPE>", null, l_field_separator, "GenerateClaimsRequestXML");
		if (l_request_type.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_request_type;
		}
		l_app_msg = "Request Type... "+l_request_type;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);		
		
		l_app_msg = "Fetching User ID ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_user_id = FetchFieldValue(actionKey,"<USER>",null,l_field_separator, "GenerateClaimsRequestXML");
		if (l_user_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_user_id;
		}
		l_app_msg = "User ID... "+l_user_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = "Fetching Workstation ID ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_workstation_id = FetchFieldValue(actionKey,"<WS_NO>",null,l_field_separator, "GenerateClaimsRequestXML");
		if (l_workstation_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_workstation_id;
		}
		l_app_msg = "Workstation ID... "+l_workstation_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = "Fetching Facility ID ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_facility_id = FetchFieldValue(actionKey,"<FACILITY_ID>",null,l_field_separator, "GenerateClaimsRequestXML");
		if (l_facility_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_facility_id;
		}
		l_app_msg = "Facility ID... "+l_facility_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = "Fetching Customer Code... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_cust_code = FetchFieldValue(actionKey, "<CUST_CD>", null, l_field_separator, "GenerateClaimsRequestXML");
		if (l_cust_code.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_cust_code;
		}
		l_app_msg = "Customer Code... "+l_cust_code;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_app_msg = "Fetching Billing Group ID... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_blng_grp_id = FetchFieldValue(actionKey, "<BLNG_GRP_ID>", null, l_field_separator, "TransRequestMethod");
		if (l_blng_grp_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_blng_grp_id;
		}
		l_app_msg = "Billing Group ID... "+l_blng_grp_id;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_app_msg = "Fetching Settlement Index... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_settlement_ind = FetchFieldValue(actionKey, "<SETTLEMENT_IND>", null, l_field_separator, "TransRequestMethod");
		if (l_settlement_ind.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_settlement_ind;
		}
		l_app_msg = "Settlement Index... "+l_settlement_ind;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_app_msg = "Fetching Claim Type... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_claim_type = FetchFieldValue(actionKey, "<CLAIM_TYPE>", null, l_field_separator, "TransRequestMethod");
		if (l_claim_type.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_claim_type;
		}
		l_app_msg = "Claim Type... "+l_claim_type;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_app_msg = "Fetching Destination Code... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_dest_code = FetchFieldValue(actionKey, "<DEST_CD>", null, l_field_separator, "GenerateClaimsRequestXML");
		if (l_dest_code.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_dest_code;
		}
		l_app_msg = "Destination Code... "+l_dest_code;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_app_msg = "Fetching Member ID... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_member_id = FetchFieldValue(actionKey, "<MEMBER_ID>", null, l_field_separator, "GenerateClaimsRequestXML");
		if (l_member_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_member_id;
		}
		l_app_msg = "Member ID... "+l_member_id;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_app_msg = "Fetching Member Surname... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_member_surname = FetchFieldValue(actionKey, "<MEMBER_SURNAME>", null, l_field_separator, "GenerateClaimsRequestXML");
		if (l_member_surname.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_member_surname;
		}
		l_app_msg = "Member Surname... "+l_member_surname;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_app_msg = "Fetching Member Initial... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_member_initial = FetchFieldValue(actionKey, "<MEMBER_INITIAL>", null, l_field_separator, "GenerateClaimsRequestXML");
		if (l_member_initial.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_member_initial;
		}
		l_app_msg = "Member Initial... "+l_member_initial;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_app_msg = "Fetching Depd Code... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_depd_code = FetchFieldValue(actionKey, "<DEPD_CODE>", null, l_field_separator, "GenerateClaimsRequestXML");
		if (l_depd_code.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_depd_code;
		}
		l_app_msg = "Dependant Code... "+l_depd_code;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_app_msg = "Fetching Depd reln... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_depd_reln = FetchFieldValue(actionKey, "<DEPD_RELN>", null, l_field_separator, "GenerateClaimsRequestXML");
		if (l_depd_reln.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_depd_reln;
		}
		l_app_msg = "Dependant relation... "+l_depd_reln;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
		
		if("".equals(l_depd_reln))
		{
			l_depd_reln = "1";
			System.out.println(l_depd_reln);
		}

		l_app_msg = "Fetching WCA Number... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_wca_num = FetchFieldValue(actionKey, "<WCA_NUM>", null, l_field_separator, "GenerateClaimsRequestXML");
		if (l_wca_num.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_wca_num;
		}
		l_app_msg = "Wca Number... "+l_wca_num;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_doc_type_code = FetchFieldValue(actionKey, "<BILL_DOC_TYPE_CODE>", null, l_field_separator, "GenerateClaimsRequestXML");
		if (l_doc_type_code.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_doc_type_code;
		}
		l_app_msg = "Doc type code... "+l_doc_type_code;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_doc_no_str = FetchFieldValue(actionKey, "<BILL_DOC_NO>", null, l_field_separator, "GenerateClaimsRequestXML");
		if (l_doc_no_str.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_doc_no_str;
		}
		l_app_msg = "Doc no str... "+l_doc_no_str;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);	

		
        l_bill_date = FetchFieldValue(actionKey, "<BILL_DATE>", null, l_field_separator, "GenerateClaimsRequestXML");
		if (l_bill_date.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_bill_date;
		}
		l_app_msg = "Bill date... "+l_bill_date;

		/*

		try
		{
			SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			java.util.Date date = sdf1.parse(l_bill_date);
			billtimestamp = new java.sql.Timestamp(date.getTime());
		}
		catch (Exception e)
		{
			l_app_msg = " Error in converting bill date to SQL date..."+e.getMessage();
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);	
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + " - "+ e.getMessage();
		}


		l_app_msg = "Bill Time Stamp... "+billtimestamp;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);	

		*/

		l_auth_num = FetchFieldValue(actionKey, "<AUTHORIZATION_NUM>", null, l_field_separator, "GenerateClaimsRequestXML");
		if (l_auth_num.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_auth_num;
		}
		l_app_msg = "Auth Num... "+l_auth_num;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);	

		l_trans_ref_no = FetchFieldValue(actionKey, "<TRANS_REF_ID>", null, l_field_separator, "GenerateClaimsRequestXML");
		if (l_trans_ref_no.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_trans_ref_no;
		}

		if (!(l_trans_ref_no.length()>0))
		{
			l_trans_ref_no = "1";
		}
		l_app_msg = "Trans Reference number... "+l_trans_ref_no;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);	

		l_app_msg = "Fetching Event_Type... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_event_type = FetchFieldValue(actionKey, "<EVENT_TYPE>", null, l_field_separator, "CreateHeaderMessage");
		if (l_event_type.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_event_type;
		}
		l_app_msg = "Event Type... "+l_event_type;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);


		//Added by bhuvana

		l_app_msg = "Fetching Policy Number... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_policy_number = FetchFieldValue(actionKey, "<POLICY_NUMBER>", null, l_field_separator, "CreateHeaderMessage");
		if (l_policy_number.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_policy_number;
		}
		l_app_msg = "Policy Number... "+l_policy_number;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

	/*	l_app_msg = "Fetching Policy Start Date... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_policy_start_date = FetchFieldValue(actionKey, "<POLICY_START_DATE>", null, l_field_separator, "CreateHeaderMessage");
		if (l_policy_start_date.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_policy_start_date;
		}
		l_app_msg = "Policy Start Date : "+l_policy_start_date;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);


		l_app_msg = "Fetching Policy Expiry Date... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_policy_expiry_date = FetchFieldValue(actionKey, "<POLICY_EXPIRY_DATE>", null, l_field_separator, "CreateHeaderMessage");
		if (l_policy_expiry_date.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_policy_expiry_date;
		}
		l_app_msg = "Policy Expiry Date : "+l_policy_expiry_date;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);*/

		//Ended


		l_patientid_no = FetchFieldValue(actionKey, "<PATIENT_ID_NUM>", null, l_field_separator, "GenerateClaimsRequestXML");
		if (l_patientid_no.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_patientid_no;
		}

		if (!(l_patientid_no.length()>0))
		{
			l_patientid_no = "XXX";
		}
		l_app_msg = "Patientid Number... "+l_patientid_no;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);	

		l_app_msg = "Generating Transaction id - Error Status... "+l_errcd;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
        
		if (l_errcd.equals("S"))
		{
			l_trans_value = GenerateTransIDMethod("XF_ECLAIMS_SEQ");
			if (l_trans_value.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_trans_value;
			}
			l_app_msg = "::: Trans Value... "+l_trans_value;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	


			if (l_trans_value.length() > 0 )
			{
				l_trans_id = Integer.parseInt(l_trans_value);
			}	
		}
		
        
		l_action_key = l_action_key.replaceAll("<TRANS_ID>XXX","<TRANS_ID>"+l_trans_value);

		l_app_msg = "After replacing Trans ID"+l_action_key;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

		l_app_msg = "Getting Formatted Request date value...";
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
		}

		l_app_msg = "Request Date... "+sqlDate;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_case_nbr = "CL"+l_doc_type_code+""+l_doc_no_str;

		l_app_msg = "Case Number... "+l_case_nbr;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = "Setting  reqParams value...";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
      //  reqParams.put("REQUEST_TEXT","XXX");
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
			
			reqParams.put("APPLICATION_ID", applicationId);
			reqParams.put("FACILITY_ID", l_facility_id);
			reqParams.put("MESSAGE_DATE", sqlDate); 
			reqParams.put("EVENT_TYPE", l_request);
			reqParams.put("PATIENT_ID", l_patient_id);
			reqParams.put("EPISODE_TYPE", l_episode_type);
			if (!(l_encounter_id.length() > 0))
			{
				l_encounter_id = "XXX";
			}
			reqParams.put("ENCOUNTER_ID", l_encounter_id);
			reqParams.put("EPISODE_ID", l_episode_id);
			reqParams.put("VISIT_ID", l_visit_id);			
			reqParams.put("ACC_NO", actionKey);
			reqParams.put("EXT_ACC_NO", "");
			reqParams.put("REQUEST_SYNTAX", actionKey);
			reqParams.put("ACK_MSG_ID", "");
			reqParams.put("PROTOCOL_LINK_ID", "ECLAIMSPL");
			reqParams.put("ADDED_BY_ID", l_user_id); 
			reqParams.put("ADDED_BY_DATE", sqlDate); 
			reqParams.put("MODIFIED_BY_ID", l_user_id); 
			reqParams.put("MODIFIED_BY_DATE", sqlDate); 
			reqParams.put("ADDED_BY_FACILITY", l_facility_id);
			reqParams.put("MODIFIED_BY_FACILITY", l_facility_id);
			reqParams.put("RESPONSE_TEXT", ""); 
			reqParams.put("RESPONSE_SYNTAX", "");
			reqParams.put("PROFILE", profileId); 
			reqParams.put("ERROR_MESSAGE", "XXX"); 
			reqParams.put("ACK_TEXT", "");
			reqParams.put("ACK_SYNTAX", "");

			if (!(l_cust_code.length() > 0))
			{
				l_cust_code = "XXX";
			}

			reqParams.put("CUST_CODE", l_cust_code);
			reqParams.put("DEST_CODE", l_dest_code);
			reqParams.put("MEMBER_ID", l_member_id);
			reqParams.put("MEMBER_SURNAME", l_member_surname);
			reqParams.put("MEMBER_INITIAL", l_member_initial);
			reqParams.put("DEPD_CODE", l_depd_code);
			reqParams.put("DEPD_RELN", l_depd_reln);
			reqParams.put("DEST_CD", l_dest_code);
			reqParams.put("BILL_DOC_TYPE_CODE", l_doc_type_code);
			reqParams.put("BILL_DATE", l_bill_date);
			reqParams.put("BILL_DOC_NO", l_doc_no_str);			
			reqParams.put("CASE_NUM", l_case_nbr);

			if (l_request.equals("CLA") || l_request.equals("CLE")|| l_request.equals("EOC"))
			{
				reqParams.put("CLAIM_NUM", l_trans_value);
			}
			if (l_request.equals("REV"))
			{				
				reqParams.put("CLAIM_NUM", l_trans_ref_no);
			}
			
			reqParams.put("AUTHORIZATION_NUM", l_auth_num);
			if (!(l_wca_num.length() > 0))
			{
				l_wca_num = "XXX";
			}
			reqParams.put("WCA_NUM", l_wca_num);
			reqParams.put("PATIENT_ID_NUM", l_patientid_no);

			if (!(l_blng_grp_id.length() > 0))
			{
				l_blng_grp_id = "XXX";
			}

			reqParams.put("BLNG_GRP_ID", l_blng_grp_id);
			reqParams.put("SETTLEMENT_IND", l_settlement_ind);
			reqParams.put("CLAIM_TYPE", l_claim_type);

			reqParams.put("POLICY_NUMBER", l_policy_number);
			//reqParams.put("POLICY_START_DATE", l_settlement_ind);
			//reqParams.put("POLICY_END_DATE", l_claim_type);
		}
		catch (Exception e)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + " - "+ e.getMessage();
		}

		l_app_msg = " Before Creating Claims XML Message Error Status... "+l_errcd;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		if (l_errcd.equals("S"))
		{
			l_request_msg = CreateClaimsXMLMessage(l_request, actionKey, reqParams);
			if (l_request_msg.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_request_msg;
			}

			l_request_msg.replaceAll("#itemno",l_item_no);

			//l_app_msg = "Request Message... "+l_request_msg;
			//if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		}

		reqParams.put("REQUEST_TEXT", l_request_msg); 

		l_app_msg = "  Before Fetching Protocol Method Error Status... "+l_errcd;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		if (l_errcd.equals("S"))
		{
			l_file_directory = FetchProtocolDetails("ECLAIMSPL");
			if (l_file_directory.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_file_directory;
			}
			l_app_msg = "File Directory... "+l_file_directory;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		}

		l_app_msg = "  Before Create File Name Method Error Status... "+l_errcd;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);			

		if (l_errcd.equals("S"))
		{
			l_file_name = CreateFileName(l_request_type, l_trans_value, l_case_nbr,l_facility_id);
			if (l_file_name.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_file_name;
			}
			l_app_msg = " File Name... "+l_file_name;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		}

		reqParams.put("INPUT_FILE_NAME", l_file_name);	

		l_app_msg = "Before Calling Write File Method Error Status... "+l_errcd;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_error_text = "";

		if (l_errcd.equals("S"))
		{
			l_write_log = WriteFile(l_file_name, l_file_directory, l_request_msg);
			if (l_write_log.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^"+ l_write_log;
			}
			l_app_msg = " Write Main File Log... "+l_write_log;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			if (l_errcd.equals("E"))
			{
				l_error_text = l_error_text + "\n" +l_write_log;
				reqParams.put("ERROR_MESSAGE", l_errmsg);
			}
			l_write_log = WriteFile(l_file_name, l_file_directory+File.separator+"Requested", l_request_msg);
			if (l_write_log.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_write_log;
			}
			l_app_msg = " Write Requested File Log... "+l_write_log;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			if (l_errcd.equals("E"))
			{
				l_error_text = l_error_text + "\n" +l_write_log;
				reqParams.put("ERROR_MESSAGE", l_errmsg);
			}
		}	
		
		l_response_return = l_errmsg;

		try
		{	
			l_app_msg = "Inserting Interface Audit data...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			
			l_interactive_log = UpdateInteractiveDetails(reqParams);
			if (l_interactive_log.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_interactive_log;
			}

			l_app_msg = "  l_interactive_log... "+l_interactive_log+ " - Error Status... "+l_errcd;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			if (l_errcd.equals("S"))
			{
				l_app_msg = "Updating EClaims Header Details...";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				l_eclaims_header_log = UpdateEClaimsHeaderDetails(reqParams);
				if (l_eclaims_header_log.indexOf("Error")>=0)
				{
					l_errcd = "E";
					l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^"+ l_eclaims_header_log;
				}

				l_app_msg = " EClaims Header Log... "+l_eclaims_header_log;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				if (l_request.equals("CLA") || l_request.equals("CLE"))
				{
					l_eclaims_item_log = UpdateEClaimsItemDetails(reqParams);
					if (l_eclaims_item_log.indexOf("Error")>=0)
					{
						l_errcd = "E";
						l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_eclaims_item_log;
					}

					l_app_msg = " EClaims Item Log... "+l_eclaims_item_log;
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				}				
			}		
		}
		catch (Exception e)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + " - "+ e.getMessage();
		}	

		l_response_return = l_errmsg;

		reqParams.put("FILE_NAME_FOR_NRL_RESP", "XXX");
		reqParams.put("INBOUND_XML_REPLY", "XXX");
		reqParams.put("FILE_NAME_FOR_REJ_RESP", "XXX");	
		reqParams.put("INBOUND_XML_REJ", "XXX");
		reqParams.put("FILE_NAME_FOR_FAILED_RESP", "XXX");
		reqParams.put("INBOUND_XML_FAIL", "XXX");	
		reqParams.put("REQUEST_STATUS", "XXX");
		reqParams.put("REPONSE_SYNTAX", "XXX");
		reqParams.put("WARN_CODE", "XXX");
		reqParams.put("WARN_DESC", "XXX");	
		reqParams.put("ACKNOWLEDGEMENT_TEXT", "XXX");
		reqParams.put("SUB_GROSS_AMOUNT", "XXX");
		reqParams.put("APPR_GROSS_AMOUNT", "XXX");
		reqParams.put("APPR_NET_AMOUNT", "XXX");
		reqParams.put("APPR_DISC_AMOUNT", "XXX");
		reqParams.put("LEVY", "XXX");
		reqParams.put("OVER_CHG", "XXX");
		reqParams.put("FEE_OVER", "XXX");
		reqParams.put("CALC_GROSS", "XXX");
		reqParams.put("HEADERSTATUS", "XXX");

		l_app_msg = " Error code"+l_errcd+" Error message... "+l_errmsg;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

		l_app_msg = "Before calling GetResponseMessage - Error Status... "+l_errcd;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		if (l_errcd.equals("S"))
		{		
			l_app_msg = "Calling Get Response Message...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			l_response_msg = GetResponseMessage(l_request, l_trans_value, l_request_type, l_case_nbr,l_facility_id);
			if (l_response_msg.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_response_msg;
			}
			
			l_app_msg = " Getting Response Message... "+l_response_msg+ "l_errcd... "+l_errcd;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			l_app_msg = "Fetching Response Details... ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			reqParams.put("REPONSE_SYNTAX", l_response_msg);

			l_app_msg = "Fetching Status... ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_response_status = FetchFieldValue(l_response_msg, "<STATUS>", null, l_field_separator, "GenerateClaimsRequestXML");
			if (l_response_status.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_response_status;
			}
			l_app_msg = " Response Status... "+l_response_status;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_app_msg = "Fetching Response File Type... ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_response_file_type = FetchFieldValue(l_response_msg, "<FILE_TYPE>", null, l_field_separator, "GenerateClaimsRequestXML");
			if (l_response_file_type.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_response_file_type;
			}
			l_app_msg = " Response File Type... "+l_response_file_type;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_app_msg = "Fetching Response File Name... ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_response_file_name = FetchFieldValue(l_response_msg, "<FILE_NAME>", null, l_field_separator, "GenerateClaimsRequestXML");
			if (l_response_file_name.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_response_file_name;
			}
			l_app_msg = " Response File Name... "+l_response_file_name;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_app_msg = "Fetching Response Message... ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_response = FetchFieldValue(l_response_msg, "<RESPONSE>", null, l_field_separator, "GenerateClaimsRequestXML");
			if (l_response.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_response;

			}
			l_app_msg = " Response... "+l_response;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);		

			reqParams.put("REQUEST_STATUS", l_response_status);			
			
			if (l_response_file_type.equals("ECLREP"))
			{
				reqParams.put("FILE_NAME_FOR_NRL_RESP", l_response_file_name);
				reqParams.put("INBOUND_XML_REPLY", l_response);
			}
			if (l_response_file_type.equals("ECLREJ"))
			{
				reqParams.put("FILE_NAME_FOR_REJ_RESP", l_response_file_name);
				reqParams.put("INBOUND_XML_REJ", l_response);
			}
			if (l_response_file_type.equals("ECLFAI"))
			{
				reqParams.put("FILE_NAME_FOR_FAILED_RESP", l_response_file_name);
				reqParams.put("INBOUND_XML_FAIL", l_response);
			}

			reqParams.put("RESPONSE_TEXT", l_response);					
			if (l_response_status.equals("09"))
			{
				reqParams.put("TRANS_STATUS", "99");
			}
		}

		l_response_return = l_errmsg;

		l_app_msg = "  Before calling ParseClaimsResponseHeader - Error Status... "+l_errcd;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

		if (l_errcd.equals("S") && !l_response_status.equals("09") )
		{
			if (l_response_file_type.equals("ECLREP") || l_response_file_type.equals("ECLREJ"))
			{
				l_app_msg = " Calling ParseClaimsResponseHeader... ";
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

				reqParams = ParseClaimsResponseHeader(l_response, reqParams);	

				if (reqParams.get("TRANS_STATUS").toString().equals("D"))
				{
					l_check_network_error = CheckForClaimNetworkError(actionKey);

					if (l_check_network_error)
					{
						reqParams.put("TRANS_STATUS", "P");	
					}				
				}


				if (reqParams.get("HEADERSTATUS").toString().equals("S"))
				{
					l_errcd = "S";
					l_response_return = l_errcd + "$!^" + l_trans_value + "$!^" + "S"+ "$!^" + "" + "$!^ "+reqParams.get("TRANS_STATUS").toString();
					reqParams.put("ACKNOWLEDGEMENT_TEXT", l_response_return);
				}
				else if (reqParams.get("HEADERSTATUS").toString().equals("E"))
				{
					l_errcd = "E";
					l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + "E" + "$!^" + reqParams.get("HEADERSTATUSMESSAGE").toString()+"$!^";
					l_response_return = l_errmsg;
					reqParams.put("ACKNOWLEDGEMENT_TEXT", l_errmsg);
				}
			}
			if (l_response_file_type.equals("ECLFAI"))
			{	
				reqParams.put("TRANS_STATUS", "F");
				l_response_return = l_errcd + "$!^" + l_trans_value + "$!^" + "S"+ "$!^" + "" + "$!^ "+reqParams.get("TRANS_STATUS").toString();
				reqParams.put("ACKNOWLEDGEMENT_TEXT", l_response_return);
				
			}
		}

        l_app_msg = "ERROR_MESSAGE... "+l_errmsg;
	    if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		reqParams.put("STATUS", l_errcd);	
		reqParams.put("ERROR_MESSAGE", l_errmsg);

		if(l_request.equals("REV") && reqParams.get("TRANS_STATUS").toString().equals("99")){
			reqParams.put("RESPONSE_TEXT", "Network error");	
			//reqParams.put("TRANS_STATUS", "A");//LMP5038-SCF-0232 Commented by Sethu on 26/10/2018
		}
		
		if (l_errcd.equals("S")) //
		{		
			l_app_msg = "Updating Interface Audit data...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);			
		}

		l_interactive_log = UpdateInteractiveDetails(reqParams);
		if (l_interactive_log.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_interactive_log;
		}

		l_return_msg = l_interactive_log;
		//l_response_return = l_errmsg;

		if (l_errcd.equals("E"))
			l_response_return = l_errmsg;
		else		
			l_response_return = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_return_msg;		
		
		l_app_msg = "Response Returned... "+l_response_return;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

		if (l_errcd.equals("S") || l_response_status.equals("09"))
		{
			l_app_msg = "Updating EClaims data...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			
			l_eclaims_header_log = UpdateEClaimsHeaderDetails(reqParams);
			if (l_eclaims_header_log.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^"+ l_eclaims_header_log;
			}
			l_return_msg = l_eclaims_header_log;			
		}

		if (l_errcd.equals("E"))
			l_response_return = l_errmsg;
		else		
			l_response_return = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_return_msg;	

		l_app_msg = " EClaims Header Response... "+l_response_return+ " - Error Status... "+l_errcd;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		if (l_errcd.equals("S"))
		{
			l_app_msg = "Request... "+l_request;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

            if (l_response_file_type.equals("ECLREP") || l_response_file_type.equals("ECLREJ"))
			{
				if (l_request.equals("CLA")|| l_request.equals("CLE"))
				{
					l_app_msg = "Response File Type... "+l_response_file_type;
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);				

					l_app_msg = " Parsing Claims Items... ";
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);		

					l_eclaims_item_log = ParseClaimsResponseItem(l_response, reqParams);
					if (l_eclaims_item_log.indexOf("Error")>=0)
					{
						l_errcd = "E";
						l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^"+ l_eclaims_item_log;
					}
					l_return_msg = l_eclaims_item_log;
					
					if (l_debug_YN.equals("Y")) System.out.println("EClaims Item Log Response... "+l_eclaims_item_log);

					/*
					
					if (reqParams.get("TRANS_STATUS").toString().equals("D"))
					{
						l_app_msg = " Parsing Reponse Items... ";
						if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

						l_return_msg = UpdateDuplicateClaim(reqParams,actionKey,l_response);

						if (l_return_msg.indexOf("Error")>=0)
						{
							l_errcd = "E";
							l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_return_msg;
						}
						l_response_return = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_return_msg;
						
					}

					*/
				}
					
			}

			if (l_errcd.equals("E"))
				l_response_return = l_errmsg;
			else		
				l_response_return = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_return_msg;	
			
			l_app_msg = " Error Status... "+l_errcd;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			if (l_errcd.equals("S"))
			{
				if (l_response_file_type.equals("ECLREP") || l_response_file_type.equals("ECLREJ"))
				{
					l_app_msg = " Updating Claims Status log... ";
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);		

					l_eclaims_status_log = ParseClaimsStatus(l_response, reqParams);

					if (l_eclaims_status_log.indexOf("Error")>=0)
					{
						l_errcd = "E";
						l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^"+ l_eclaims_status_log;
					}
					l_return_msg = l_eclaims_status_log;

					l_app_msg = " Updating Item Status log... ";
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);		

					l_eclaims_status_log = ParseClaimsItemStatus(l_response, reqParams);

					if (l_eclaims_status_log.indexOf("Error")>=0)
					{
						l_errcd = "E";
						l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^"+ l_eclaims_status_log;
					}
					l_return_msg = l_eclaims_status_log;
					
					l_app_msg = "Item Status Update Log... "+l_eclaims_status_log;
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				}
			}

			if (l_errcd.equals("E"))
				l_response_return = l_errmsg;
			else		
				l_response_return = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_return_msg;	
			
		}
	    if (l_request.equals("REV") && l_event_type.equals("EOC") && (l_response_status.equals("09") || reqParams.get("TRANS_STATUS").toString().equals("A")))
		{
				
			l_trans_value = GenerateTransIDMethod("XF_ECLAIMS_SEQ");
			if (l_trans_value.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_trans_value;
			}
			l_app_msg = "Transaction ID... "+l_trans_value;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	


			if (l_trans_value.length() > 0 )
			{
				l_trans_id = Integer.parseInt(l_trans_value);
			}	
			reqParams.put("MSG_ID", l_trans_value);
			reqParams.put("TRANS_STATUS", "A");

			l_app_msg = " Parsing Reponse Items... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_return_msg =  UpdateClaimReversal(reqParams,actionKey,l_response);

			if (l_return_msg.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_return_msg;
			}                
		
		}
	    reqParams.clear();
		return l_response_return;		
	}	

	public String FetchClaimsResponseXML(String profileId, String applicationId, String actionKey)
	{
		String l_app_msg = "";
		String l_trans_value = "", l_action_key = "";

		int l_trans_id = 0;

		String l_patient_id = "", l_encounter_id = "", l_request = "", l_request_type = "", l_user_id = "", l_facility_id = "", l_cust_code = "", l_dest_code = "", l_episode_type = "", l_wca_num = "",l_auth_num="", l_episode_id = "", l_visit_id = "", l_acknowledgement_text = "";

		String l_blng_grp_id = "",  l_settlement_ind = "";

		String l_doc_type_code = "", l_doc_no_str = "" ,l_bill_date = "";

		String l_response_msg = "", l_response_return = "", l_return_msg = "";;
		String l_member_id = "",  l_depd_code = "", l_depd_reln = "";

		String l_request_date = "", l_case_nbr = "";

		String l_workstation_id = "";

		String l_interactive_log = "", l_eclaims_header_log = "", l_eclaims_item_log = "", l_eclaims_status_log = "";

		String l_response_status = "", l_response_file_type = "", l_response_file_name = "", l_response = "";
        String l_trans_ref_no = "",l_event_type = "";

		java.sql.Timestamp sqlDate = null;
	
		String query = "";

		HashMap reqParams = null;

		boolean l_check_network_error = false;

		l_action_key = actionKey;
			
		l_app_msg = "Inside FetchClaimsResponseXML...";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_app_msg = "Fetching Transaction Value... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_trans_value = FetchFieldValue(actionKey, "<TRANS_ID>", null, l_field_separator, "FetchClaimsResponseXML");
		if (l_trans_value.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" +"$!^" + l_app_msg + "$!^" + l_trans_value;
		}
		l_app_msg = "Trans Value... "+l_trans_value;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_app_msg = "Fetching Patient ID ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_patient_id = FetchFieldValue(actionKey,"<PATIENT_ID>",null,l_field_separator, "GenerateClaimsRequestXML");
		if (l_patient_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_patient_id ;
		}
		l_app_msg = "Patient Id... "+l_patient_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = "Fetching Encounter ID ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_encounter_id = FetchFieldValue(actionKey,"<ENCOUNTER_ID>",null,l_field_separator, "GenerateClaimsRequestXML");
		if (l_encounter_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_encounter_id ;
		}
		l_app_msg = "Encounter Id... "+l_encounter_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = "Fetching Episode Type... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_episode_type = FetchFieldValue(actionKey,"<EPISODE_TYPE>",null,l_field_separator, "GenerateClaimsRequestXML");
		if (l_episode_type.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_episode_type ;
		}
		l_app_msg = "Episode Type... "+l_episode_type;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = "Fetching Episode ID... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_episode_id = FetchFieldValue(actionKey,"<EPISODE_ID>",null,l_field_separator, "GenerateClaimsRequestXML");
		if (l_episode_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_episode_id ;
		}
		l_app_msg = "Episode Id... "+l_episode_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = "Fetching Visit ID... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_visit_id = FetchFieldValue(actionKey,"<VISIT_ID>",null,l_field_separator, "GenerateClaimsRequestXML");
		if (l_visit_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_visit_id ;
		}
		l_app_msg = "Visit Id... "+l_visit_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = "Fetching Request... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_request = FetchFieldValue(actionKey, "<REQUEST>", null, l_field_separator, "GenerateClaimsRequestXML");
		if (l_request.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_request;
		}
		l_app_msg = "Request... "+l_request;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_app_msg = "Fetching Request Type... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_request_type = FetchFieldValue(actionKey, "<REQUEST_TYPE>", null, l_field_separator, "GenerateClaimsRequestXML");
		if (l_request_type.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_request_type;
		}
		l_app_msg = "Request Type... "+l_request_type;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);		
		
		l_app_msg = "Fetching User ID ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_user_id = FetchFieldValue(actionKey,"<USER>",null,l_field_separator, "GenerateClaimsRequestXML");
		if (l_user_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_user_id;
		}
		l_app_msg = "User Id... "+l_user_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = "Fetching Workstation ID ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_workstation_id = FetchFieldValue(actionKey,"<WS_NO>",null,l_field_separator, "GenerateClaimsRequestXML");
		if (l_workstation_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_workstation_id;
		}
		l_app_msg = "Workstation Id... "+l_workstation_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = "Fetching Facility ID ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_facility_id = FetchFieldValue(actionKey,"<FACILITY_ID>",null,l_field_separator, "GenerateClaimsRequestXML");
		if (l_facility_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_facility_id;
		}
		l_app_msg = "Facility Id... "+l_facility_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = "Fetching Customer Code... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_cust_code = FetchFieldValue(actionKey, "<CUST_CD>", null, l_field_separator, "GenerateClaimsRequestXML");
		if (l_cust_code.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_cust_code;
		}
		l_app_msg = "Cust code... "+l_cust_code;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_app_msg = "Fetching Billing Group ID... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_blng_grp_id = FetchFieldValue(actionKey, "<BLNG_GRP_ID>", null, l_field_separator, "TransRequestMethod");
		if (l_blng_grp_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_blng_grp_id;
		}
		l_app_msg = "Billing Group ID... "+l_blng_grp_id;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_app_msg = "Fetching Settlement Index... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_settlement_ind = FetchFieldValue(actionKey, "<SETTLEMENT_IND>", null, l_field_separator, "TransRequestMethod");
		if (l_settlement_ind.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_settlement_ind;
		}
		l_app_msg = "Settlement Index... "+l_settlement_ind;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_app_msg = "Fetching Destination Code... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_dest_code = FetchFieldValue(actionKey, "<DEST_CD>", null, l_field_separator, "GenerateClaimsRequestXML");
		if (l_dest_code.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_dest_code;
		}
		l_app_msg = "Destination Code... "+l_dest_code;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_app_msg = "Fetching Member ID... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_member_id = FetchFieldValue(actionKey, "<MEMBER_ID>", null, l_field_separator, "GenerateClaimsRequestXML");
		if (l_member_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_member_id;
		}
		l_app_msg = "Member ID... "+l_member_id;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_app_msg = "Fetching Depd Code... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_depd_code = FetchFieldValue(actionKey, "<DEPD_CODE>", null, l_field_separator, "GenerateClaimsRequestXML");
		if (l_depd_code.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_depd_code;
		}
		l_app_msg = "Depd Code... "+l_depd_code;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_app_msg = "Fetching Depd reln... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_depd_reln = FetchFieldValue(actionKey, "<DEPD_RELN>", null, l_field_separator, "GenerateClaimsRequestXML");
		if (l_depd_reln.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_depd_reln;
		}
		l_app_msg = "Depd reln... "+l_depd_reln;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
		
		

		l_app_msg = "Fetching WCA Number... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_wca_num = FetchFieldValue(actionKey, "<WCA_NUM>", null, l_field_separator, "GenerateClaimsRequestXML");
		if (l_wca_num.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_wca_num;
		}
		l_app_msg = "WCA Number... "+l_wca_num;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_doc_type_code = FetchFieldValue(actionKey, "<BILL_DOC_TYPE_CODE>", null, l_field_separator, "GenerateClaimsRequestXML");
		if (l_doc_type_code.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_doc_type_code;
		}
		l_app_msg = "Document Type Code... "+l_doc_type_code;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_doc_no_str = FetchFieldValue(actionKey, "<BILL_DOC_NO>", null, l_field_separator, "GenerateClaimsRequestXML");
		if (l_doc_no_str.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_doc_no_str;
		}
		l_app_msg = "Document Number str... "+l_doc_no_str;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);	
		
        l_bill_date = FetchFieldValue(actionKey, "<BILL_DATE>", null, l_field_separator, "GenerateClaimsRequestXML");
		if (l_bill_date.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_bill_date;
		}
		l_app_msg = "Bill Date... "+l_bill_date;

		l_auth_num = FetchFieldValue(actionKey, "<AUTHORIZATION_NUM>", null, l_field_separator, "GenerateClaimsRequestXML");
		if (l_auth_num.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_auth_num;
		}
		l_app_msg = "Auth Number... "+l_auth_num;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);	
		
		l_trans_ref_no = FetchFieldValue(actionKey, "<TRANS_REF_ID>", null, l_field_separator, "GenerateClaimsRequestXML");
		if (l_trans_ref_no.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_trans_ref_no;
		}

		if (!(l_trans_ref_no.length()>0))
		{
			l_trans_ref_no = "1";
		}

		l_app_msg = "Fetching Event Type... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_event_type = FetchFieldValue(actionKey, "<EVENT_TYPE>", null, l_field_separator, "CreateHeaderMessage");
		if (l_event_type.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_event_type;
		}
		l_app_msg = "Event Type... "+l_event_type;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_app_msg = "Trans Reference Number... "+l_trans_ref_no;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_app_msg = "Getting Formatted Request date value...";
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
		}

		l_app_msg = "Request Date... "+sqlDate;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_case_nbr = "CL" +l_doc_type_code+""+ l_doc_no_str;
		
		l_app_msg = "Case Number... "+l_case_nbr;
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
			
			reqParams.put("APPLICATION_ID", applicationId);
			reqParams.put("FACILITY_ID", l_facility_id);
			reqParams.put("MESSAGE_DATE", sqlDate); 
			reqParams.put("EVENT_TYPE", l_request);
			reqParams.put("PATIENT_ID", l_patient_id);
			reqParams.put("EPISODE_TYPE", l_episode_type);
			if (!(l_encounter_id.length() > 0))
			{
				l_encounter_id = "XXX";
			}
			reqParams.put("ENCOUNTER_ID", l_encounter_id);
			reqParams.put("EPISODE_ID", l_episode_id);
			reqParams.put("VISIT_ID", l_visit_id);			
			reqParams.put("ACC_NO", actionKey);
			reqParams.put("EXT_ACC_NO", "");
			reqParams.put("REQUEST_SYNTAX", actionKey);
			reqParams.put("ACK_MSG_ID", "");
			reqParams.put("PROTOCOL_LINK_ID", "ECLAIMSPL");
			reqParams.put("ADDED_BY_ID", l_user_id); 
			reqParams.put("ADDED_BY_DATE", sqlDate); 
			reqParams.put("MODIFIED_BY_ID", l_user_id); 
			reqParams.put("MODIFIED_BY_DATE", sqlDate); 
			reqParams.put("ADDED_BY_FACILITY", l_facility_id);
			reqParams.put("MODIFIED_BY_FACILITY", l_facility_id);
			reqParams.put("RESPONSE_TEXT", ""); 
			reqParams.put("RESPONSE_SYNTAX", "");
			reqParams.put("PROFILE", profileId); 
			reqParams.put("ERROR_MESSAGE", "XXX"); 
			reqParams.put("ACK_TEXT", "");
			reqParams.put("ACK_SYNTAX", "");

			if (!(l_cust_code.length() > 0))
			{
				l_cust_code = "XXX";
			}

			reqParams.put("CUST_CODE", l_cust_code);
			reqParams.put("DEST_CODE", l_dest_code);
			reqParams.put("MEMBER_ID", l_member_id);
			reqParams.put("DEPD_CODE", l_depd_code);
			reqParams.put("DEPD_RELN", l_depd_reln);
			reqParams.put("DEST_CD", l_dest_code);
			reqParams.put("BILL_DOC_TYPE_CODE", l_doc_type_code);
			reqParams.put("BILL_DATE", l_bill_date);
			reqParams.put("BILL_DOC_NO", l_doc_no_str);			
			reqParams.put("CASE_NUM",  l_case_nbr);
			if (l_request.equals("CLA") || l_request.equals("CLE")|| l_request.equals("EOC"))
			{
				reqParams.put("CLAIM_NUM", l_trans_value);
			}
			if (l_request.equals("REV") )
			{				
				reqParams.put("CLAIM_NUM", l_trans_ref_no);
			}
			reqParams.put("AUTHORIZATION_NUM", l_auth_num);
			if (!(l_wca_num.length() > 0))
			{
				l_wca_num = "XXX";
			}
			reqParams.put("WCA_NUM", l_wca_num);
		}
		catch (Exception e)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + " - "+ e.getMessage();
		}		

		l_app_msg = "Calling Get Response Message...";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);		
		
		l_response_msg = GetResponseMessage(l_request, l_trans_value,l_request_type, l_case_nbr,l_facility_id);
		if (l_response_msg.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_response_msg;
		}
		
		l_app_msg = "Getting Response Message at Line 1213... "+l_response_msg+ "l_errcd... "+l_errcd;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

		reqParams.put("FILE_NAME_FOR_NRL_RESP", "XXX");
		reqParams.put("INBOUND_XML_REPLY", "XXX");
		reqParams.put("FILE_NAME_FOR_REJ_RESP", "XXX");	
		reqParams.put("INBOUND_XML_REJ", "XXX");
		reqParams.put("FILE_NAME_FOR_FAILED_RESP", "XXX");
		reqParams.put("INBOUND_XML_FAIL", "XXX");	
		reqParams.put("REQUEST_STATUS", "XXX");
		reqParams.put("REPONSE_SYNTAX", "XXX");
		reqParams.put("REQUEST_TEXT", "XXX");

		reqParams.put("WARN_CODE", "XXX");
		reqParams.put("WARN_DESC", "XXX");	
		reqParams.put("ACKNOWLEDGEMENT_TEXT", "XXX");
		reqParams.put("SUB_GROSS_AMOUNT", "XXX");
		reqParams.put("APPR_GROSS_AMOUNT", "XXX");
		reqParams.put("APPR_NET_AMOUNT", "XXX");
		reqParams.put("APPR_DISC_AMOUNT", "XXX");
		reqParams.put("LEVY", "XXX");
		reqParams.put("OVER_CHG", "XXX");
		reqParams.put("FEE_OVER", "XXX");
		reqParams.put("CALC_GROSS", "XXX");
		reqParams.put("HEADERSTATUS", "XXX");

		if (!(l_blng_grp_id.length() > 0))
		{
			l_blng_grp_id = "XXX";
		}

		reqParams.put("BLNG_GRP_ID", l_blng_grp_id);
		reqParams.put("SETTLEMENT_IND", l_settlement_ind);

		l_app_msg = "Fetching Response Details... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		reqParams.put("REPONSE_SYNTAX", l_response_msg);

		l_app_msg = "Fetching Status... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_response_status = FetchFieldValue(l_response_msg, "<STATUS>", null, l_field_separator, "GenerateClaimsRequestXML");
		if (l_response_status.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_response_status;
		}
		l_app_msg = "Response Status... "+l_response_status;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_app_msg = "Fetching Response File Type... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_response_file_type = FetchFieldValue(l_response_msg, "<FILE_TYPE>", null, l_field_separator, "GenerateClaimsRequestXML");
		if (l_response_file_type.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_response_file_type;
		}
		l_app_msg = "Response File Type... "+l_response_file_type;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_app_msg = "Fetching Response File Name... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_response_file_name = FetchFieldValue(l_response_msg, "<FILE_NAME>", null, l_field_separator, "GenerateClaimsRequestXML");
		if (l_response_file_name.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_response_file_name;
		}
		l_app_msg = "Response File Name... "+l_response_file_name;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_app_msg = "Fetching Response Message... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_response = FetchFieldValue(l_response_msg, "<RESPONSE>", null, l_field_separator, "GenerateClaimsRequestXML");
		if (l_response.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_response;

		}
		l_app_msg = "Response... "+l_response;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);		

		reqParams.put("REQUEST_STATUS", l_response_status);
		
		if (l_response_file_type.equals("ECLREP"))
		{
			reqParams.put("FILE_NAME_FOR_NRL_RESP", l_response_file_name);
			reqParams.put("INBOUND_XML_REPLY", l_response);
		}
		if (l_response_file_type.equals("ECLREJ"))
		{
			reqParams.put("FILE_NAME_FOR_REJ_RESP", l_response_file_name);
			reqParams.put("INBOUND_XML_REJ", l_response);
		}
		if (l_response_file_type.equals("ECLFAI"))
		{
			reqParams.put("FILE_NAME_FOR_FAILED_RESP", l_response_file_name);
			reqParams.put("INBOUND_XML_FAIL", l_response);
		}
		
		if (l_response_status.equals("09"))
		{
			reqParams.put("TRANS_STATUS", "99");
		}

		if (l_errcd.equals("S") && !l_response_status.equals("09") )
		{	
			if (l_response_file_type.equals("ECLREP") || l_response_file_type.equals("ECLREJ"))
			{
				l_app_msg = "Calling Parse Claims Response Header... ";
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

				reqParams = ParseClaimsResponseHeader(l_response, reqParams);	
				
				if (reqParams.get("TRANS_STATUS").toString().equals("D"))
				{
					l_check_network_error = CheckForClaimNetworkError(actionKey);

					if (l_check_network_error)
					{
						reqParams.put("TRANS_STATUS", "P");	
					}				
				}

				if (reqParams.get("HEADERSTATUS").toString().equals("S"))
				{
					l_errcd = "S";
					l_acknowledgement_text = l_errcd + "$!^" + l_trans_value + "$!^" + "S"+ "$!^" + "$!^ "+reqParams.get("TRANS_STATUS").toString();
					reqParams.put("ACKNOWLEDGEMENT_TEXT", l_acknowledgement_text);
				}
				else if (reqParams.get("HEADERSTATUS").toString().equals("E"))
				{
					l_errcd = "E";
					l_acknowledgement_text = l_errcd + "$!^" + l_trans_value + "$!^" + "E" + "$!^" + reqParams.get("HEADERSTATUSMESSAGE").toString()+"$!^";
					reqParams.put("ACKNOWLEDGEMENT_TEXT", l_acknowledgement_text);
				}
			}
			if (l_response_file_type.equals("ECLFAI"))
			{
				reqParams.put("TRANS_STATUS", "F");				
				l_acknowledgement_text = l_errcd + "$!^" + l_trans_value + "$!^" + "S"+ "$!^" + "$!^ "+reqParams.get("TRANS_STATUS").toString();
				reqParams.put("ACKNOWLEDGEMENT_TEXT", l_acknowledgement_text);
			}
		}

		l_app_msg = "RESPONSE_TEXT..."+l_response;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		reqParams.put("RESPONSE_TEXT", l_response);		
		reqParams.put("STATUS", l_errcd);	
		reqParams.put("ERROR_MESSAGE", l_errmsg);

        if(l_request.equals("REV") && reqParams.get("TRANS_STATUS").toString().equals("99")){
			reqParams.put("RESPONSE_TEXT", "Network error");	
			//reqParams.put("TRANS_STATUS", "A");//LMP5038-SCF-0232 Commented by Sethu on 26/10/2018
		}

		l_app_msg = "Updating Interface Audit data...";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		
		l_interactive_log = UpdateInteractiveDetails(reqParams);
		if (l_interactive_log.indexOf("Error")>=0)
		{
			l_errcd = "E";		
			l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_interactive_log;
		}

        l_app_msg = "l_interactive_log..."+l_interactive_log;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		l_return_msg = l_interactive_log;

		if (l_errcd.equals("E"))
			l_response_return = l_errmsg;
		else		
			l_response_return = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_return_msg;

		l_app_msg = "Response return after updating Interface Audit data... "+l_response_return;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

		l_app_msg = "Updating EClaims data...";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		
		l_eclaims_header_log = UpdateEClaimsHeaderDetails(reqParams);
		if (l_eclaims_header_log.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_eclaims_header_log;
		}

		l_return_msg = l_eclaims_header_log;

		if (l_errcd.equals("E"))
			l_response_return = l_errmsg;
		else		
			l_response_return = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_return_msg;	

		l_app_msg = " EClaims Header Response... "+l_response_return+ " - Error Status... "+l_errcd;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		if (l_errcd.equals("S") && !l_response_status.equals("09") )
		{
			if (l_response_file_type.equals("ECLREP") || l_response_file_type.equals("ECLREJ"))
			{
				if (l_request.equals("CLA")|| l_request.equals("CLE"))
				{
					l_app_msg = "Response File Type... "+l_response_file_type;
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

					l_app_msg = " Parsing Reponse Items... ";
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

					l_eclaims_item_log = ParseClaimsResponseItem(l_response, reqParams);
					if (l_eclaims_item_log.indexOf("Error")>=0)
					{
						l_errcd = "E";
						l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^"+ l_eclaims_item_log;
					}
					l_return_msg = l_eclaims_item_log;
					
					if (l_debug_YN.equals("Y")) System.out.println("EClaims Item Log Response... "+l_eclaims_item_log);

					/*
					
					if (reqParams.get("TRANS_STATUS").toString().equals("D"))
					{
						l_app_msg = " Parsing Reponse Items... ";
						if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

						l_return_msg = UpdateDuplicateClaim(reqParams,actionKey,l_response);

						if (l_return_msg.indexOf("Error")>=0)
						{
							l_errcd = "E";
							l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_return_msg;
						}
						l_response_return = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_return_msg;
						
					}

					*/
				}
					
			}

			if (l_errcd.equals("E"))
				l_response_return = l_errmsg;
			else		
				l_response_return = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_return_msg;	
			
			l_app_msg = " Error Status... "+l_errcd;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			if (l_errcd.equals("S"))
			{
				if (l_response_file_type.equals("ECLREP") || l_response_file_type.equals("ECLREJ"))
				{
					l_app_msg = " Updating Status log... ";
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);		

					l_eclaims_status_log = ParseClaimsStatus(l_response, reqParams);

					if (l_eclaims_status_log.indexOf("Error")>=0)
					{
						l_errcd = "E";
						l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^"+ l_eclaims_status_log;
					}
					l_return_msg = l_eclaims_status_log;

					l_app_msg = " Updating Item Status log... ";
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);		

					l_eclaims_status_log = ParseClaimsItemStatus(l_response, reqParams);

					if (l_eclaims_status_log.indexOf("Error")>=0)
					{
						l_errcd = "E";
						l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^"+ l_eclaims_status_log;
					}
					l_return_msg = l_eclaims_status_log;

					l_app_msg = "Item Status Update Log... "+l_eclaims_status_log;
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				}
			}
			if (l_errcd.equals("E"))
				l_response_return = l_errmsg;
			else		
				l_response_return = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_return_msg;	

		}
		if (l_request.equals("REV") && l_event_type.equals("EOC") && (l_response_status.equals("09") || reqParams.get("TRANS_STATUS").toString().equals("A")))
		{
			l_app_msg = "Claims reversal... "+l_event_type;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_trans_value = GenerateTransIDMethod("XF_ECLAIMS_SEQ");
			if (l_trans_value.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_trans_value;
			}
			l_app_msg = "Trans Value... "+l_trans_value;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	


			if (l_trans_value.length() > 0 )
			{
				l_trans_id = Integer.parseInt(l_trans_value);
			}	
			reqParams.put("MSG_ID", l_trans_value);
			reqParams.put("TRANS_STATUS", "A");

			l_app_msg = " Parsing Reponse Items... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_return_msg =  UpdateClaimReversal(reqParams,actionKey,l_response);

			if (l_return_msg.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_return_msg;
			}                
		
		}
		reqParams.clear();

		return l_response_return;
	}

	public HashMap ParseClaimsResponseHeader(String response, Map params)
	{

		String l_app_msg = "";

		String l_trans_res = "", l_trans_case_nbr = "";

		String l_sub_gross_amount_str = "", l_appr_gross_amount_str = "", l_appr_net_amount_str = "", l_appr_disc_amount_str = "";
		String l_levy_str = "", l_over_chg_str = "", l_fee_over_str = "", l_calc_gross_str = "";

		String l_hnet_num = "";

		String l_return_str = "";

		l_app_msg = "Inside ParseClaimsResponseHeader... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		HashMap reqParam = null;

		try
		{
			reqParam = new HashMap(params);

			l_trans_res = parseResponseXml(response,"TX","res");
			l_app_msg = "TRANS RESPONSE STATUS"+l_trans_res;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			reqParam.put("TRANS_STATUS", l_trans_res);

			l_trans_case_nbr = parseResponseXml(response,"TX","case_nbr");
			l_app_msg = "TRANS CASE NUMBER"+l_trans_case_nbr;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			reqParam.put("CASE_NUM", l_trans_case_nbr);

			l_hnet_num = parseResponseXml(response,"AUTHS","hnet");
			l_app_msg = "TRANS HNET NUMBER"+l_hnet_num;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			reqParam.put("AUTHORIZATION_NUM", l_hnet_num);
			
			l_sub_gross_amount_str = parseResponseXml(response,"FIN","sub_gross");	
			if (!(l_sub_gross_amount_str.length() > 0))
			{
				l_sub_gross_amount_str = "XXX";
			}
			l_app_msg = "SUB GROSS AMOUNT"+l_sub_gross_amount_str;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_appr_gross_amount_str = parseResponseXml(response,"FIN","gross");	
			if (!(l_appr_gross_amount_str.length() > 0))
			{
				l_appr_gross_amount_str = "XXX";
			}
			l_app_msg = "APPR GROSS AMOUNT"+l_appr_gross_amount_str;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_appr_net_amount_str = parseResponseXml(response,"FIN","nett");	
			if (!(l_appr_net_amount_str.length() > 0))
			{
				l_appr_net_amount_str = "XXX";
			}
			l_app_msg = "APPR NET AMOUNT"+l_appr_net_amount_str;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_appr_disc_amount_str = parseResponseXml(response,"FIN","disc");	
			if (!(l_appr_disc_amount_str.length() > 0))
			{
				l_appr_disc_amount_str = "XXX";
			}
			l_app_msg = "APPR DISC AMOUNT"+l_appr_disc_amount_str;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_levy_str = parseResponseXml(response,"FIN","levy");	
			if (!(l_levy_str.length() > 0))
			{
				l_levy_str = "XXX";
			}
			l_app_msg = "LEVY AMOUNT"+l_levy_str;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_over_chg_str = parseResponseXml(response,"FIN","over_chg");	
			if (!(l_over_chg_str.length() > 0))
			{
				l_over_chg_str = "XXX";
			}
			l_app_msg = "OVER CHARGE AMOUNT"+l_over_chg_str;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_fee_over_str = parseResponseXml(response,"FIN","fee_over");	
			if (!(l_fee_over_str.length() > 0))
			{
				l_fee_over_str = "XXX";
			}
			l_app_msg = "FEE OVER AMOUNT"+l_fee_over_str;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_calc_gross_str = parseResponseXml(response,"FIN","calc_gross");		
			if (!(l_calc_gross_str.length() > 0))
			{
				l_calc_gross_str = "XXX";
			}
			l_app_msg = "CALC GROSS AMOUNT"+l_calc_gross_str;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			reqParam.put("SUB_GROSS_AMOUNT", l_sub_gross_amount_str);
			reqParam.put("APPR_GROSS_AMOUNT", l_appr_gross_amount_str);
			reqParam.put("APPR_NET_AMOUNT", l_appr_net_amount_str);
			reqParam.put("APPR_DISC_AMOUNT", l_appr_disc_amount_str);
			reqParam.put("LEVY", l_levy_str);
			reqParam.put("OVER_CHG", l_over_chg_str);
			reqParam.put("FEE_OVER", l_fee_over_str);
			reqParam.put("CALC_GROSS", l_calc_gross_str);
			reqParam.put("HEADERSTATUS", "S");
			
		}
		catch (Exception e)
		{
			l_return_str = e.getMessage();
			reqParam.put("HEADERSTATUS", "E");
			reqParam.put("HEADERSTATUSMESSAGE", e.getMessage());
		}
		
		return reqParam;
	}

	public String ParseClaimsResponseItem(String response, Map params)
	{
		Connection dbConn = null;
		PreparedStatement pstmt = null;

		String l_update_stmt = "";

		String l_app_msg ="", l_errcd ="S", l_errmsg ="", l_return_msg = "";	
		
		String l_facility_id = "", l_patient_id = "", l_episode_id = "", l_episode_type = "", l_visit_id = "";
		String l_bill_type_code = "";
		int l_bill_doc_no = 0, l_trans_value = 0;

		String l_item_num = "", l_item_status = "", l_item_status_desc = "", l_item_sub_gross_str = "", l_item_appr_gross_str = "", l_item_appr_net_str = "", l_item_appr_disc_str = "";
		String l_status_code = "", l_status_desc = "", l_status_type = "",l_case_no = "";	

		double l_item_sub_gross = 0.00, l_item_appr_gross = 0.00, l_item_appr_net = 0.00, l_item_appr_disc = 0.00;
		
		int l_item_count = 0, l_update_count = 0, l_tot_update_count = 0;

        try{

			l_app_msg = " Inside ParseClaimsResponseItem...";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			InputSource is = new InputSource();
			is.setCharacterStream(new StringReader(response));

			Document doc = db.parse(is);
			NodeList itemNodesList = doc.getElementsByTagName("ITEM");

			dbConn =  ConnectionManager.getConnection();

			l_facility_id = params.get("FACILITY_ID").toString();
			l_app_msg = "FACILITY ID... "+ l_facility_id;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			l_patient_id = params.get("PATIENT_ID").toString();
			l_app_msg = "PATIENT ID... "+ l_patient_id;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_episode_id = params.get("EPISODE_ID").toString();
			l_app_msg = "EPISODE ID... "+ l_episode_id;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_episode_type = params.get("EPISODE_TYPE").toString();
			l_app_msg = "EPISODE TYPE... "+ l_episode_type;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_visit_id = params.get("VISIT_ID").toString();
			l_app_msg = "VISIT ID... "+ l_visit_id;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);					

			l_trans_value =  Integer.parseInt(params.get("MSG_ID").toString()) ;					

			l_bill_type_code = params.get("BILL_DOC_TYPE_CODE").toString();
			l_app_msg = "BILL TYPE CODE... "+ l_bill_type_code;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_bill_doc_no = Integer.parseInt(params.get("BILL_DOC_NO").toString());
			l_app_msg = "BILL DOC NO... "+ l_bill_doc_no;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_case_no = params.get("CASE_NUM").toString();
			l_app_msg = "CASE NO... "+ l_case_no;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_app_msg = "FACILITY ID... "+ l_facility_id + "PATIENT_ID... " + l_patient_id + "EPISODE_ID... "+ l_episode_id + "EPISODE_TYPE... " + l_episode_type + "VISIT_ID... "+ l_visit_id + "SRL_NO... "+ l_trans_value + "BILL_DOC_TYPE_CODE... "+ l_bill_type_code + "BILL_DOC_NO... "+ l_bill_doc_no;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			 
			if (itemNodesList != null)
			{
				l_item_count = itemNodesList.getLength();

				l_app_msg = "ITEM NodesList Length... "+l_item_count;
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

				if (l_item_count>0)
				{
					for (int i = 0; i < itemNodesList.getLength(); i++) 
					{

						l_item_num = ""; l_item_status = ""; l_item_sub_gross_str = ""; l_item_appr_gross_str = ""; l_item_appr_net_str = ""; l_item_appr_disc_str = ""; l_status_code = ""; l_status_desc = "";
						l_item_sub_gross = 0.00; l_item_appr_gross = 0.00; l_item_appr_net = 0.00; l_item_appr_disc = 0.00;

						if (itemNodesList.item(i).getNodeType() == Node.ELEMENT_NODE) 
						{
							Element el = (Element) itemNodesList.item(i);
							//l_item_num = el.getAttribute("nbr");
							l_item_status = el.getAttribute("status");
						}

						
						Node itemNode = (Node) itemNodesList.item(i);

						if (itemNode.hasChildNodes())
						{
							NodeList itemChildList = itemNode.getChildNodes();
							for(int j=0;j < itemChildList.getLength();j++)
							{
								if (itemChildList.item(j).getNodeName().equals("HB"))
								{
									Element el = (Element) itemChildList.item(j);
									l_item_num = el.getAttribute("line_num");																
								}

								if (itemChildList.item(j).getNodeName().equals("FIN"))
								{
									Element el = (Element) itemChildList.item(j);
									l_item_sub_gross_str = el.getAttribute("sub_gross");
									l_item_appr_gross_str = el.getAttribute("gross");
									l_item_appr_net_str = el.getAttribute("nett");
									l_item_appr_disc_str = el.getAttribute("disc");									
								}
								if (l_item_status.equals("W"))
								{								
									if (itemChildList.item(j).getNodeName().equals("WARN"))
									{
										Element el = (Element) itemChildList.item(j);
										l_status_code = StringEscapeUtils.unescapeXml(el.getAttribute("cd"));
										l_status_desc = StringEscapeUtils.unescapeXml(el.getAttribute("desc"));
									}
								}
								if (l_item_status.equals("R"))
								{								
									if (itemChildList.item(j).getNodeName().equals("RJ"))
									{
										Element el = (Element) itemChildList.item(j);
										l_status_code = StringEscapeUtils.unescapeXml(el.getAttribute("cd"));
										l_status_desc = StringEscapeUtils.unescapeXml(el.getAttribute("desc"));
									}
								}
							}
						}

						l_app_msg = "Item Number... "+l_item_num+" Item Status... "+ l_item_status;
						//if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

						l_app_msg = "Item... "+i+" Number... "+l_item_num+" Status... "+l_item_status+" Sub Gross... "+l_item_sub_gross+" Approved Gross... "+l_item_appr_gross+" Approved Net... "+l_item_appr_net+" Approved Discount... "+l_item_appr_disc+" Status Code... "+l_status_code+" Status description... "+l_status_desc;
						//if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);					
						
						if (l_item_status.equals("P"))
							l_item_status_desc = "Processed";
						if (l_item_status.equals("W"))
							l_item_status_desc = "Processed with Warnings";
						if (l_item_status.equals("R"))
							l_item_status_desc = "Rejected";
						
						l_app_msg = "Item Status... "+ l_item_status;
						//if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

						l_app_msg = "Item Status Desc... "+ l_item_status_desc;
						//if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

						if (l_item_appr_gross_str.length() > 0)
							l_item_appr_gross = Double.parseDouble(l_item_appr_gross_str);

						l_app_msg = "Item Appr Gross... "+ l_item_appr_gross;
						//if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

						if (l_item_appr_net_str.length() > 0)
							l_item_appr_net = Double.parseDouble(l_item_appr_net_str);

						l_app_msg = "Item Appr Net... "+ l_item_appr_net;
						//if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

						if (l_item_appr_disc_str.length() > 0)
							l_item_appr_disc = Double.parseDouble(l_item_appr_disc_str);

						l_app_msg = "Item Appr Disc... "+ l_item_appr_disc;
						//if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

						if (!(l_status_code.length() > 0))
						{
							l_status_code = "";
						}

						l_app_msg = "Status Code... "+ l_status_code;
						//if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

						if (!(l_status_desc.length() > 0))
						{
							l_status_desc = "";
						}

						l_app_msg = "Status Desc... "+ l_status_desc;
						//if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);							

						l_update_stmt = " UPDATE XF_ECLAIMS_TRX_DTL "
										+" SET	CLAIM_STATUS	= ?, "
										+" CLAIM_STATUS_DESC	= ?, "
										+" APPR_GROSS			= ?, "
										+" APPR_NET				= ?, "
										+" APPR_DISC			= ?, "
										+" ITEM_STATUS_CODE		= ?, "
										+" ITEM_STATUS_DESC		= ?, "
										+" CASE_NUM             = ?  "
										+" WHERE FACILITY_ID	= ? " 
											+" AND PATIENT_ID	= ? " 
											+" AND EPISODE_ID	= ? "
											+" AND EPISODE_TYPE	= ? " 
											+" AND VISIT_ID		= ? " 
											+" AND SRL_NO		= ? " 
											+" AND BILL_DOC_TYPE_CODE	= ? " 
											+" AND BILL_DOC_NUM			= ? " 
											+" AND BILL_DOC_LINE_NUM	= ? " ;

						pstmt = dbConn.prepareStatement(l_update_stmt);
						pstmt.setString(1, l_item_status);
						pstmt.setString(2, l_item_status_desc);
						pstmt.setDouble(3, l_item_appr_gross);
						pstmt.setDouble(4, l_item_appr_net);
						pstmt.setDouble(5, l_item_appr_disc);
						pstmt.setString(6, l_status_code);
						pstmt.setString(7, l_status_desc);
						pstmt.setString(8, l_case_no);
						pstmt.setString(9, l_facility_id);
						pstmt.setString(10, l_patient_id);
						pstmt.setInt(11, Integer.parseInt(l_episode_id));
						pstmt.setString(12, l_episode_type);
						pstmt.setInt(13, Integer.parseInt(l_visit_id));
						pstmt.setInt(14, l_trans_value);
						pstmt.setString(15, l_bill_type_code);
						pstmt.setInt(16, l_bill_doc_no);	
						pstmt.setString(17, l_item_num);	
						l_update_count = pstmt.executeUpdate();

						l_tot_update_count = l_tot_update_count + l_update_count;

						l_app_msg = "UPDATE XF ECLAIMS TRX DTL... SRL NO... "+l_trans_value +"...: BILL TYPE CODE... "+l_bill_type_code +"...: BILL DOC NO... "+l_bill_doc_no +"...: BILL DOC LINE NUM... "+l_item_num +"...: UpdateCount...: " +l_update_count;
						if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);						
					}	
					l_app_msg = "UPDATE XF ECLAIMS TRX DTL... TOTAL UPDATE COUNT... "+l_tot_update_count +"...: ITEM COUNT... "+l_item_count;
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
					
					if (l_tot_update_count == l_item_count)
					{
						dbConn.commit();	
						l_errcd = "S";
						l_errmsg = "EClaims Transaction details table updated successfully ";
						l_return_msg = l_errmsg;
					}
					else
					{
						dbConn.rollback();	
						l_errcd = "E";
						l_errmsg = " Error in updating Transaction details table Records "+"$!^"+" Records not updated";	
						l_return_msg = l_errmsg;
					}
				}
				else
				{
					l_status_type = parseResponseXml(response,"TX","res");

					l_app_msg = "Status Type... "+l_status_type;
					if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

					if (l_status_type.equals("R"))
					{
						l_item_status = "R";
						l_item_status_desc = "Rejected";
					}

					l_update_stmt = " UPDATE XF_ECLAIMS_TRX_DTL "
										+" SET	CLAIM_STATUS	= ?, "
										+" CLAIM_STATUS_DESC	= ? "															
										+" WHERE FACILITY_ID	= ? " 
											+" AND PATIENT_ID	= ? " 
											+" AND EPISODE_ID	= ? "
											+" AND EPISODE_TYPE	= ? " 
											+" AND VISIT_ID		= ? " 
											+" AND SRL_NO		= ? " 
											+" AND BILL_DOC_TYPE_CODE	= ? " 
											+" AND BILL_DOC_NUM			= ? ";

					pstmt = dbConn.prepareStatement(l_update_stmt);
					pstmt.setString(1, l_item_status);
					pstmt.setString(2, l_item_status_desc);					
					pstmt.setString(3, l_facility_id);
					pstmt.setString(4, l_patient_id);
					pstmt.setInt(5, Integer.parseInt(l_episode_id));
					pstmt.setString(6, l_episode_type);
					pstmt.setInt(7, Integer.parseInt(l_visit_id));
					pstmt.setInt(8, l_trans_value);
					pstmt.setString(9, l_bill_type_code);
					pstmt.setInt(10, l_bill_doc_no);
					l_update_count = pstmt.executeUpdate();

					if (l_update_count > 0)
					{
						dbConn.commit();	
						l_errcd = "S";
						l_errmsg = "EClaims Transaction details table updated successfully - Sethu ";
						l_return_msg = l_errmsg;
					}
					else
					{
						dbConn.rollback();	
						l_errcd = "E";
						l_errmsg = " Error in updating Transaction details table Records "+"$!^"+" Records not updated";	
						l_return_msg = l_errmsg;
					}
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			l_errcd = "E";
			l_errmsg = "Error in Parsing Response Item Details... "+"$!^"+ e.getMessage();
			l_return_msg = l_errmsg;
		}
		finally{
			closeDBResources(null, pstmt, dbConn);	
		}
		
		return l_return_msg;
	}

	public String ParseClaimsItemStatus(String response, Map params)
	{
		Connection dbConn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null, cntpstmt = null;

		String  l_insert_stmt = "";


		String l_app_msg ="", l_errcd ="S", l_errmsg ="", l_return_msg = "";	
		
		String l_facility_id = "", l_patient_id = "", l_episode_id = "", l_episode_type = "", l_visit_id = "";
		String l_bill_type_code = "", l_case_no = "", l_claim_no = ""; 
		int l_bill_doc_no = 0, l_trans_value = 0;

		String l_item_num = "", l_item_status = "";
		String l_status_code = "", l_status_desc = "", l_status_type = "", l_status_attr = "", l_status_count_str = "", l_status_tag = "",l_count_stmt = "";	

		int l_item_count = 0, l_tot_item_status_count = 0, l_tot_item_insert_count = 0, l_item_status_count = 0, l_status_count = 0, l_insert_count = 0, l_item_insert_count = 0, l_inserted_status_count =0;

		String[] warnType = {"warn", "rej", "eirj", "eiwarn"};

		String l_warn_count = "0", l_rej_count = "0", l_eirj_count = "0", l_eiwarn_count = "0";

        try{

			l_app_msg = " Inside ParseClaimsItemStatus...";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			InputSource is = new InputSource();
			is.setCharacterStream(new StringReader(response));

			Document doc = db.parse(is);
			NodeList itemNodesList = doc.getElementsByTagName("ITEM");

			dbConn =  ConnectionManager.getConnection();

			l_facility_id = params.get("FACILITY_ID").toString();
			l_app_msg = "FACILITY ID... "+ l_facility_id;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			l_patient_id = params.get("PATIENT_ID").toString();
			l_app_msg = "PATIENT ID... "+ l_patient_id;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_episode_id = params.get("EPISODE_ID").toString();
			l_app_msg = "EPISODE ID... "+ l_episode_id;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_episode_type = params.get("EPISODE_TYPE").toString();
			l_app_msg = "EPISODE TYPE... "+ l_episode_type;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_visit_id = params.get("VISIT_ID").toString();
			l_app_msg = "VISIT ID... "+ l_visit_id;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);					

			l_trans_value =  Integer.parseInt(params.get("MSG_ID").toString()) ;					

			l_bill_type_code = params.get("BILL_DOC_TYPE_CODE").toString();
			l_app_msg = "BILL TYPE CODE... "+ l_bill_type_code;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_bill_doc_no = Integer.parseInt(params.get("BILL_DOC_NO").toString());
			l_app_msg = "BILL DOC NO... "+ l_bill_doc_no;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_case_no = params.get("CASE_NUM").toString();
			l_app_msg = "CASE NO... "+ l_case_no;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_claim_no = params.get("CLAIM_NUM").toString();
			l_app_msg = "CLAIM NO... "+ l_claim_no;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);


			l_app_msg = "FACILITY ID... "+ l_facility_id + "PATIENT ID... " + l_patient_id + "EPISODE ID... "+ l_episode_id + "EPISODE TYPE... " + l_episode_type + "VISIT ID... "+ l_visit_id + "SRL NO... "+ l_trans_value + "BILL DOC TYPE_CODE... "+ l_bill_type_code + "BILL DOC NO... "+ l_bill_doc_no;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			 
			if (itemNodesList != null)
			{
				l_item_count = itemNodesList.getLength();

				l_app_msg = "ITEM NodesList Length... "+l_item_count;
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

				l_count_stmt = " Select count(*) COUNT FROM XF_ECLAIMS_TRX_STATUS_DTL "
																+" WHERE SRL_NO = ? " 
																+" AND BILL_DOC_TYPE_CODE = ? "
																+" AND BILL_DOC_NUM = ? "
																+" AND BILL_DOC_LINE_NUM = ? "
																+" AND STATUS_TYPE = ? "
																+" AND STATUS_CODE = ? ";

				l_app_msg = "l_count_stmt... "+ l_count_stmt;
				//if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				cntpstmt = dbConn.prepareStatement(l_count_stmt);	
				
				l_insert_stmt = " INSERT INTO XF_ECLAIMS_TRX_STATUS_DTL (FACILITY_ID, PATIENT_ID, EPISODE_ID, EPISODE_TYPE, VISIT_ID, CASE_NUM, "
																	+" CLAIM_NUM, SRL_NO, BILL_DOC_TYPE_CODE, BILL_DOC_NUM, BILL_DOC_LINE_NUM, "       
																	+" STATUS_TYPE, STATUS_CODE, STATUS_DESC ) "
																	+" VALUES (?, ?, ?, ?, ?, ?, "
																	+"         ?, ?, ?, ?, ?,  "
																	+"         ?, ?, ?)";

				pstmt = dbConn.prepareStatement(l_insert_stmt);		

				if (l_item_count>0)
				{
					for (int i = 0; i < itemNodesList.getLength(); i++) 
					{
						l_warn_count = "0"; l_rej_count = "0"; l_eirj_count = "0"; l_eiwarn_count = "0";
						l_item_insert_count = 0;
						l_item_status_count = 0;

						if (itemNodesList.item(i).getNodeType() == Node.ELEMENT_NODE) 
						{
							Element el = (Element) itemNodesList.item(i);
							//l_item_num = el.getAttribute("nbr");
							l_item_status = el.getAttribute("status");
						}

						l_app_msg = "Item Number... "+l_item_num+" Item Status... "+ l_item_status;
						//if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

						Node itemNode = (Node) itemNodesList.item(i);

						if (itemNode.hasChildNodes())
						{
							NodeList itemChildList = itemNode.getChildNodes();
							for(int j=0; j < itemChildList.getLength(); j++)
							{
								if (itemChildList.item(j).getNodeName().equals("HB"))
								{
									Element el = (Element) itemChildList.item(j);
									l_item_num = el.getAttribute("line_num");																
								}
								if (itemChildList.item(j).getNodeName().equals("CNT"))
								{
									Element el = (Element) itemChildList.item(j);

									l_warn_count = el.getAttribute("warn");
									l_rej_count = el.getAttribute("rej");
									l_eirj_count = el.getAttribute("eirj");
									l_eiwarn_count = el.getAttribute("eiwarn");	
									
									if (!(l_warn_count.length()>0))
									{
										l_warn_count = "0";
									}

									if (!(l_rej_count.length()>0))
									{
										l_rej_count = "0";
									}

									if (!(l_eirj_count.length()>0))
									{
										l_eirj_count = "0";
									}

									if (!(l_eiwarn_count.length()>0))
									{
										l_eiwarn_count = "0";
									}
									
									l_item_status_count = Integer.parseInt(l_warn_count) + Integer.parseInt(l_rej_count) +Integer.parseInt(l_eirj_count) + Integer.parseInt(l_eiwarn_count);

									l_app_msg = "Item Number... "+l_item_num+" l_item_status_count... "+l_item_status_count;
									//if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
									
								}

								
								for (int k=0; k<warnType.length; k++ )
								{
									l_status_attr = warnType[k];

									if (l_status_attr.equals("warn"))
									{
										l_status_count_str = l_warn_count;
										l_status_tag = "WARN";
										l_status_type = "W";
									}
									if (l_status_attr.equals("rej"))
									{
										l_status_count_str = l_rej_count;
										l_status_tag = "RJ";
										l_status_type = "R";
									}
									if (l_status_attr.equals("eirj"))
									{
										l_status_count_str = l_eirj_count;
										l_status_tag = "EIRJ";
										l_status_type = "E";
									}
									if (l_status_attr.equals("eiwarn"))
									{
										l_status_count_str = l_eiwarn_count;
										l_status_tag = "EIWARN";
										l_status_type = "I";
									}		
									
									if (l_status_count_str.length()>0)
									{
										l_status_count = Integer.parseInt(l_status_count_str);
									}	
									
									if (l_status_count > 0)
									{
										l_app_msg = "itemChildList.item(j).getNodeName() "+j+" "+itemChildList.item(j).getNodeName();
										//if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

										if (itemChildList.item(j).getNodeName().equals(l_status_tag))
										{
											l_app_msg = "Status... "+l_status_attr+" Status Count... "+l_status_count;
											//if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

											l_status_code = ""; l_status_desc = "";

											if (itemChildList.item(j).getNodeType() == Node.ELEMENT_NODE) 
											{
												Element el = (Element) itemChildList.item(j);
												l_status_code = StringEscapeUtils.unescapeXml(el.getAttribute("cd"));
												l_status_desc = StringEscapeUtils.unescapeXml(el.getAttribute("desc"));
												l_app_msg = "Status Code... "+l_status_code+" Status Desc... "+ l_status_desc;
												//if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);												
												
												cntpstmt.setInt(1, l_trans_value);
												cntpstmt.setString(2, l_bill_type_code);
												cntpstmt.setInt(3, l_bill_doc_no);
												cntpstmt.setString(4, l_item_num);
												cntpstmt.setString(5, l_status_type);
												cntpstmt.setString(6, l_status_code);											

												rs = cntpstmt.executeQuery();
												while(rs.next()){
													l_inserted_status_count = rs.getInt("COUNT");
												}

												l_app_msg = "Inserted Status Count... "+ l_inserted_status_count;
												//if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

												if(l_inserted_status_count<=0){
																
													pstmt.setString(1, l_facility_id);
													pstmt.setString(2, l_patient_id);
													pstmt.setInt(3, Integer.parseInt(l_episode_id));
													pstmt.setString(4, l_episode_type);
													pstmt.setInt(5, Integer.parseInt(l_visit_id));
													pstmt.setString(6, l_case_no);
													pstmt.setString(7, l_claim_no);
													pstmt.setInt(8, l_trans_value);
													pstmt.setString(9, l_bill_type_code);
													pstmt.setInt(10, l_bill_doc_no);
													pstmt.setString(11, l_item_num);	
													pstmt.setString(12, l_status_type);
													pstmt.setString(13, l_status_code);
													pstmt.setString(14, l_status_desc);

													l_insert_count = pstmt.executeUpdate();
													
													l_item_insert_count = l_item_insert_count + l_insert_count;
												}
												else{
                                                   l_item_insert_count = l_item_insert_count + 1;
												}															
											}
										}										
									}
								}									
							}
							l_app_msg = "INSERT XF ECLAIMS TRX STATUS DTL 1... SRL NO... "+l_trans_value +"Item Number"+l_item_num+"UpdateCount...: " +l_item_insert_count+"StatusCount...: " +l_item_status_count +"Total Item Status Count... "+l_tot_item_status_count+"... Total Item Insert Count... "+l_tot_item_insert_count;
							//if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
						}

						l_tot_item_insert_count = l_tot_item_insert_count + l_item_insert_count;
						l_tot_item_status_count = l_tot_item_status_count + l_item_status_count;
					}	
					l_app_msg = "INSERT XF ECLAIMS TRX STATUS DTL... Total Item Status Count... "+l_tot_item_status_count+"... Total Item Insert Count... "+l_tot_item_insert_count;
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
					
					if (l_tot_item_status_count == l_tot_item_insert_count)
					{
						dbConn.commit();	
						l_errcd = "S";
						l_errmsg = "EClaims Transaction Status details table updated successfully ";
						l_return_msg = l_errmsg;
					}
					else
					{
						dbConn.rollback();	
						l_errcd = "E";
						l_errmsg = " Error in Inserting Transaction Status details table Records "+"$!^"+" Records not Inserted"	;
						l_return_msg = l_errmsg;
					}
				}				
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			l_errcd = "E";
			l_errmsg = "Error in Parsing Response Item Status Details... "+"$!^"+ e.getMessage();
			l_return_msg = l_errmsg;
		}
		finally{
			closeDBResources(rs, cntpstmt, null);	
			closeDBResources(null, pstmt, dbConn);
		}
		
		return l_return_msg;
	}

	public String ParseClaimsStatus(String response, Map params)
	{
		Connection dbConn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null, cntpstmt = null;

		String l_insert_stmt = "";

		String l_app_msg ="", l_errcd ="S", l_errmsg ="", l_return_msg = "";	
		
		String l_facility_id = "", l_patient_id = "", l_episode_id = "", l_episode_type = "", l_visit_id = "";
		String l_bill_type_code = "";
		int l_bill_doc_no = 0, l_trans_value = 0;

		String l_status_type = "", l_status_code = "", l_status_desc = "", l_status_attr = "", l_status_tag = "", l_status_count_str = "",l_count_stmt = "";

		int l_status_count = 0, l_insert_count = 0, l_tot_insert_count = 0, l_tot_status_count = 0 , l_inserted_status_count = 0;

		String l_warn_count = "0", l_rej_count = "0", l_eirj_count = "0", l_eiwarn_count = "0";

		String[] warnType = {"warn", "rej", "erj", "ewarn"};

        try{

			l_app_msg = " Inside ParseClaimsStatus...";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			/*

			l_status_type = parseResponseXml(response,"TX","res");

			l_app_msg = "Status Type... "+l_status_type;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			if (l_status_type.equals("R"))
			{
				l_status_attr = "rej";
			}
			if (l_status_type.equals("W"))
			{
				l_status_attr = "warn";
			}
			if (l_status_type.equals("A"))
			{
				l_status_attr = "warn";
			}

			l_app_msg = "Status Attribute... "+l_status_attr;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			*/

			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			InputSource is = new InputSource();
			is.setCharacterStream(new StringReader(response));

			Document doc = db.parse(is);

			NodeList txNodesList = doc.getElementsByTagName("TX");

			dbConn =  ConnectionManager.getConnection();

			l_facility_id = params.get("FACILITY_ID").toString();
			l_app_msg = "FACILITY ID... "+ l_facility_id;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			l_patient_id = params.get("PATIENT_ID").toString();
			l_app_msg = "PATIENT ID... "+ l_patient_id;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_episode_id = params.get("EPISODE_ID").toString();
			l_app_msg = "EPISODE ID... "+ l_episode_id;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_episode_type = params.get("EPISODE_TYPE").toString();
			l_app_msg = "EPISODE TYPE... "+ l_episode_type;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_visit_id = params.get("VISIT_ID").toString();
			l_app_msg = "VISIT ID... "+ l_visit_id;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);					

			l_trans_value =  Integer.parseInt(params.get("MSG_ID").toString()) ;					

			l_app_msg = "FACILITY ID... "+ l_facility_id + "PATIENT ID... " + l_patient_id + "EPISODE ID... "+ l_episode_id + "EPISODE TYPE... " + l_episode_type + "VISIT ID... "+ l_visit_id + "SRL NO... "+ l_trans_value + "STATUS TYPE... "+ l_status_type+ "STATUS CODE... "+ l_status_code + "STATUS DESC... "+ l_status_desc;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_count_stmt = " Select count(*) COUNT FROM XF_ECLAIMS_STATUS_DTL "
															+" WHERE FACILITY_ID = ? " 
															+" AND PATIENT_ID = ? " 
															+" AND EPISODE_ID = ? "
															+" AND EPISODE_TYPE = ? "
															+" AND VISIT_ID = ? "
															+" AND SRL_NO = ? "       
															+" AND STATUS_TYPE = ? "
															+" AND STATUS_CODE = ? "
															+" AND STATUS_DESC = ? ";

			l_app_msg = "l_count_stmt... "+ l_count_stmt;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			cntpstmt = dbConn.prepareStatement(l_count_stmt);		

			l_insert_stmt = " INSERT INTO XF_ECLAIMS_STATUS_DTL (FACILITY_ID, PATIENT_ID, EPISODE_ID, EPISODE_TYPE, VISIT_ID, SRL_NO, "       
															+" STATUS_TYPE, STATUS_CODE, STATUS_DESC ) "
															+" VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

			pstmt = dbConn.prepareStatement(l_insert_stmt);		


			for (int i = 0; i < txNodesList.getLength(); i++) 
			{
				l_warn_count = "0"; l_rej_count = "0"; l_eirj_count = "0"; l_eiwarn_count = "0";				

				Node txNode = (Node) txNodesList.item(i);

				if (txNode.hasChildNodes())
				{
					NodeList txChildList = txNode.getChildNodes();
					for(int j=0; j < txChildList.getLength(); j++)
					{
						if (txChildList.item(j).getNodeName().equals("CNT"))
						{
							Element el = (Element) txChildList.item(j);

							l_warn_count = el.getAttribute("warn");
							l_rej_count = el.getAttribute("rej");
							l_eirj_count = el.getAttribute("erj");
							l_eiwarn_count = el.getAttribute("ewarn");								
						}	
					}

					for(int j=0; j < txChildList.getLength(); j++)
					{						
						l_tot_status_count = 0;

						for (int k=0; k<warnType.length; k++ )
						{
							l_status_tag = "";
							l_status_count_str = "";
							l_status_type = "";
							l_status_attr = warnType[k];

							if (l_status_attr.equals("warn"))
							{
								l_status_count_str = l_warn_count;
								l_status_tag = "WARN";
								l_status_type = "W";
							}
							if (l_status_attr.equals("rej"))
							{
								l_status_count_str = l_rej_count;
								l_status_tag = "RJ";
								l_status_type = "R";
							}
							if (l_status_attr.equals("erj"))
							{
								l_status_count_str = l_eirj_count;
								l_status_tag = "ERJ";
								l_status_type = "E";
							}
							if (l_status_attr.equals("ewarn"))
							{
								l_status_count_str = l_eiwarn_count;
								l_status_tag = "EWARN";
								l_status_type = "I";
							}

							l_app_msg = "Status... "+l_status_tag+" Status Count String... "+l_status_count_str;
							if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

							if (l_status_count_str.length()>0)
							{
								l_status_count = Integer.parseInt(l_status_count_str);

								l_tot_status_count = l_tot_status_count + l_status_count;
							}

							if (l_status_count > 0)
							{
								l_app_msg = "txChildList.item("+j+").getNodeName()"+txChildList.item(j).getNodeName();
								//if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

								if (txChildList.item(j).getNodeName().equals(l_status_tag))
								{
									l_status_code = ""; l_status_desc = "";						 

									if (txChildList.item(j).getNodeType() == Node.ELEMENT_NODE) 
									{
										Element el = (Element) txChildList.item(j);
										l_status_code = StringEscapeUtils.unescapeXml(el.getAttribute("cd"));
										l_status_desc = StringEscapeUtils.unescapeXml(el.getAttribute("desc"));

										l_app_msg = "Status Code... "+l_status_code+" Status Desc... "+ l_status_desc;
										//if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

													
										cntpstmt.setString(1, l_facility_id);
										cntpstmt.setString(2, l_patient_id);
										
										if (!(l_episode_id.equals("XXX")))
											cntpstmt.setInt(3, Integer.parseInt(l_episode_id));
										else
											cntpstmt.setString(3, "");					
										
										if (!(l_episode_type.equals("XXX")))
											cntpstmt.setString(4, l_episode_type);
										else
											cntpstmt.setString(4, "");

										if (!(l_visit_id.equals("XXX")))
											cntpstmt.setInt(5, Integer.parseInt(l_visit_id));
										else
											cntpstmt.setString(5, "");
										
										cntpstmt.setInt(6, l_trans_value);
										cntpstmt.setString(7, l_status_type);
										cntpstmt.setString(8, l_status_code);
										cntpstmt.setString(9, l_status_desc);

										rs = cntpstmt.executeQuery();
										while(rs.next()){
											l_inserted_status_count = rs.getInt("COUNT");
										}

										l_app_msg = "Inserted Status Count... "+ l_inserted_status_count;
										if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

										if(l_inserted_status_count<=0){												
														
											pstmt.setString(1, l_facility_id);
											pstmt.setString(2, l_patient_id);
											pstmt.setInt(3, Integer.parseInt(l_episode_id));
											pstmt.setString(4, l_episode_type);
											pstmt.setInt(5, Integer.parseInt(l_visit_id));
											pstmt.setInt(6, l_trans_value);
											pstmt.setString(7, l_status_type);
											pstmt.setString(8, l_status_code);
											pstmt.setString(9, l_status_desc);

											l_insert_count = pstmt.executeUpdate();
						
											l_tot_insert_count = l_tot_insert_count + l_insert_count;

											l_app_msg = "INSERT XF ECLAIMS STATUS DTL... SRL NO... "+l_trans_value +"...: UpdateCount...: " +l_insert_count;
											//if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);						
										}
										else{
											 l_tot_insert_count = l_tot_insert_count + 1;
										}
									}
								}
							}
						}	
					}

					l_app_msg = "INSERT XF ECLAIMS STATUS DTL... TOTAL INSERT COUNT... "+l_tot_insert_count +"...: STATUS COUNT... "+l_tot_status_count;
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

					if (l_tot_insert_count == l_tot_status_count)
					{
						dbConn.commit();	
						l_errcd = "S";
						l_errmsg = "EClaims Transaction Status details table updated successfully ";
						l_return_msg = l_errmsg;
					}
					else
					{
						dbConn.rollback();	
						l_errcd = "E";
						l_errmsg = " Error in updating Transaction Status details table Records "+"$!^"+" records not updated";	
						l_return_msg = l_errmsg;
					}
				}
			}	
		}
		catch (Exception e)
		{
			e.printStackTrace();
			l_errcd = "E";
			l_errmsg = "Error in Parsing Response Status Details... "+"$!^"+ e.getMessage();
			l_return_msg = l_errmsg;
		}
		finally{
			closeDBResources(rs, cntpstmt, null);	
			closeDBResources(null, pstmt, dbConn);
		}

		l_app_msg = "Return Message... "+ l_return_msg;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		return l_return_msg;
	}	

	public String FetchXMLFormat(String request, String applicationID, String column){

		Connection Conn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;

		String query = "";
		String l_app_msg = "", l_application_id ="", l_clob_string = "";

		java.sql.Clob l_clob_xml_data = null, l_clob_xsl_data = null;

		l_app_msg = "Inside FetchXMLFormat";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = "Request... "+ request + "Application ID... "+applicationID;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		
		try
		{
			l_application_id = applicationID;

			Conn =  ConnectionManager.getConnection();
			query = "SELECT NVL(XML_FORMAT,'') XML_FORMAT, NVL(XSL_DATA,'') XSL_DATA FROM XH_XML_FORMAT " 
						+ " WHERE APPLICATION_ID = ? "
						+ " AND XML_ID = ? ";

			pstmt = Conn.prepareStatement(query);
			pstmt.setString(1, l_application_id);
			pstmt.setString(2, request);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
			   l_clob_xml_data = rs.getClob("XML_FORMAT");
			   l_clob_xsl_data = rs.getClob("XSL_DATA");
			}
			
			if (column.equals("XML"))
			{
				if (l_clob_xml_data.length()>0)
				{
					l_clob_string = clobToString(l_clob_xml_data);
				}
			}
			if (column.equals("XSL"))
			{
				if (l_clob_xsl_data.length()>0)
				{
					l_clob_string = clobToString(l_clob_xsl_data);
				}
			}			
			
		}
		catch(Exception e)
		{
			l_clob_string = "Error in "+ l_app_msg + "... " +  e.getMessage();
		}
		finally
		{			
			closeDBResources(rs, pstmt, Conn);			
		}		

		return l_clob_string;
	}

	public String FetchProtocolDetails(String protocolLinkID){
		Connection Conn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;

		String query = "";
		String l_app_msg = "";

		String l_profile_id = "", l_file_directory = "", l_standard_code = "";

		l_app_msg = "Inside FetchProtocolDetails";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = "Protocol Link ID... "+ protocolLinkID ;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = " Fetching File Directory... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		
		try
		{
			Conn =  ConnectionManager.getConnection();
			query = "SELECT    nvl(profile_id,'') profile_id, nvl(standard_code,'') standard_code, "
						+ " nvl(file_directory,'') file_directory "
			            + " FROM    xh_protocol a, xh_protocol_link b "
						+ " WHERE    a.protocol_id = b.protocol_id AND b.protocol_link_id = ? ";

			pstmt = Conn.prepareStatement(query);
			pstmt.setString(1, protocolLinkID);			
			rs = pstmt.executeQuery();
			while(rs.next())
			{
			   l_file_directory = rs.getString("FILE_DIRECTORY");
			   l_profile_id = rs.getString("PROFILE_ID");
			   l_standard_code = rs.getString("STANDARD_CODE");
			}

			l_app_msg = "Profile ID... "+ l_profile_id + "Standard Code... "+ l_standard_code + "File Directory... "+l_file_directory;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		}
		catch(Exception e)
		{
			e.printStackTrace();
			l_file_directory = "Error in "+ l_app_msg + "$!^" +  e.getMessage(); //added
		}
		finally
		{			
			closeDBResources(rs, pstmt, Conn);				
		}	
		
		l_app_msg = "File Directory... "+l_file_directory;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		return l_file_directory;
	}

	public String CreateClaimsXMLMessage(String request, String actionKey, Map params){

		String l_app_msg = "";

		String l_header_xml_msg = "", l_diag_xml_msg = "", l_item_xml_msg = "", l_hosp_xml_msg = "",l_hpc_xml_msg = "";

		StringBuffer l_xml_msg = new StringBuffer();

		l_app_msg = "Inside CreateClaimsXMLMessage";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = "Request... "+ request + "Action Key... "+ actionKey;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		
		try
		{
			l_app_msg = " Generating Header Message... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_header_xml_msg = CreateHeaderMessage(request, actionKey, params);
			
			if (l_header_xml_msg.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_app_msg + "$!^" + l_header_xml_msg;
			}
			
			l_app_msg = "Header Xml Message... "+ l_header_xml_msg;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			if (l_errcd.equals("S"))
			{
				l_xml_msg.append(l_header_xml_msg);
			}
			
			l_diag_xml_msg = CreateDiagnosisMessage(request, actionKey, params, "DIAG" , "B");
			l_app_msg = "l_diag_xml_msg"+ l_diag_xml_msg;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			if (l_diag_xml_msg.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_diag_xml_msg;
			}
			if (l_errcd.equals("S"))
			{
				l_xml_msg.append("\n");
				l_xml_msg.append(l_diag_xml_msg);
			}
			
			
           if (l_errcd.equals("S") && (request.equals("CLA")||request.equals("CLE")))
			{
				l_app_msg = " Generating BHF Segment... ";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_hpc_xml_msg = CreateDocterHPCMessage(request, actionKey, params);
				
				if (l_hpc_xml_msg.indexOf("Error")>=0)
				{
					l_errcd = "E";
					l_errmsg = l_app_msg + "$!^" + l_hpc_xml_msg;
				}

				l_app_msg = "HPC Xml Message"+ l_hpc_xml_msg;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				if (l_errcd.equals("S"))
				{
					l_xml_msg.append("\n");
					l_xml_msg.append(l_hpc_xml_msg);
				}
			}

			

			
			

			if (l_errcd.equals("S"))
			{			
				l_app_msg = " Generating HOSP Segment... ";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_hosp_xml_msg = CreateHospMessage(request, actionKey, params);
				
				if (l_hosp_xml_msg.indexOf("Error")>=0)
				{
					l_errcd = "E";
					l_errmsg = l_app_msg + "$!^" + l_hosp_xml_msg;
				}
				
				l_app_msg = "Hospital xml msg"+ l_hosp_xml_msg;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				if (l_errcd.equals("S"))
				{
					l_xml_msg.append(l_hosp_xml_msg);
				}
			}

			if (l_errcd.equals("S") && (request.equals("CLA")||request.equals("CLE")))
			{
				l_app_msg = " Generating ITEM Segment... ";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_item_xml_msg = CreateItemMessage(request, actionKey, params);
				//l_app_msg = "l_item_xml_msg"+ l_item_xml_msg;	
				//if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				if (l_item_xml_msg.indexOf("Error")>=0)
				{
					l_errcd = "E";
					l_errmsg = l_app_msg + "$!^" + l_item_xml_msg;
				}
				if (l_errcd.equals("S"))
				{
					l_xml_msg.append("\n");
					l_xml_msg.append(l_item_xml_msg);
				}	
				l_xml_msg.append("\n");
			}
			if (l_errcd.equals("S"))
			{
				l_xml_msg.append("</TX>");
				l_xml_msg.append("\n");
				l_xml_msg.append("</DOCUMENT>");
			}

			if (l_errcd.equals("E"))
			{
				l_xml_msg.append(l_errmsg);
			}
		}
		catch (Exception e)
		{
			l_xml_msg.append("Error in "+ l_app_msg + "$!^" +  e.getMessage());
		}	

		return l_xml_msg.toString();
	}

	public String CreateHeaderMessage(String request, String actionKey, Map params){

		Connection Conn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;
		String l_query = "";

		String l_app_msg = "";
		String l_element_id = "", l_segment_id = "ECL", l_standard_code = "ECLASTD",l_event_type = "";

		String l_request = "", l_application_id = "";

		StringBuffer l_xml_msg = new StringBuffer();

		String l_document_ver_no = "", l_hospital_no = "", l_tx_cd = "", l_msg_fmt = "", l_orig = "", l_bin = "", l_amd_ind = "";
		String l_vend_id = "", l_vend_ver = "", l_pay_adv = "", l_clm_orig = "", l_cntry_cd = "", l_sect_cd = "";
		String l_request_date = "";

		String l_patient_id = "", l_national_id_no = "", l_passport_id = "", l_name_prefix = "", l_first_name = "", l_third_name = "", l_family_name = "", l_patient_name = "", l_sex = "", l_date_of_birth = "", l_race_code = "" ,l_episode_type = "", l_race_cd = "", l_patient_status = "";

		String l_encounter_id = "", l_episode_id = "", l_visit_id ="";

		String  l_member_id = "",l_wca_num = "",  l_depd_code = "", l_depd_reln = "", l_dest_code = "", l_new_born_flag = "N",l_member_surname = "",l_member_initial = "";

		String l_addr1_line1 = "", l_addr1_line2 = "", l_addr1_line3 = "", l_postal1_code = "", l_res_town_desc = "", l_region_desc = "";

		String l_claim_type = "";

		String l_seq_no = "";
		HashMap patDetailMap = null;

		String l_facility_id = "", l_doc_type_code ="", l_doc_no_str = "";
		int l_doc_num = 0;

		String l_xml_string = "";

		int l_line_count = 0;

		//Added by bhuvana
		String l_policy_number_str = "" ;
	 
		String query = "",l_visit_time = "", l_trans_ref_no = "";


		l_app_msg = "Inside CreateHeaderMessage";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);		
		
		try
		{
			l_request = request;	
			l_app_msg = "Sequence Number... "+ l_seq_no;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_application_id = params.get("APPLICATION_ID").toString();			
			l_app_msg = "Application Id... "+l_application_id;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			l_app_msg = "Calling FetchXMLFormat ... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			if (l_errcd.equals("S"))
			{
				l_xml_string = FetchXMLFormat(l_request, l_application_id, "XML");
				if (l_xml_string.indexOf("Error")>=0)
				{
					l_errcd = "E";
					//l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_xml_string;
					l_errmsg = l_xml_string;

					return l_errmsg;
				}
				l_app_msg = "XML String Generated... "+l_xml_string;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			}

			l_patient_id = params.get("PATIENT_ID").toString();			
			l_app_msg = "Patient  Id... "+l_patient_id;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_episode_type = params.get("EPISODE_TYPE").toString();	
			l_app_msg = "Episode Type... "+l_episode_type;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_encounter_id = params.get("ENCOUNTER_ID").toString();			
			l_app_msg = "Encounter Id... "+l_encounter_id;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_episode_id = params.get("EPISODE_ID").toString();	
			l_app_msg = "Episode Id... "+l_episode_id;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_visit_id = params.get("VISIT_ID").toString();			
			l_app_msg = "Visit Id... "+l_visit_id;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

	        l_wca_num = params.get("WCA_NUM").toString();	
			l_app_msg = "WCA Number: "+l_wca_num;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_seq_no = params.get("MSG_ID").toString();			
			l_app_msg = "Sequence Number... "+l_seq_no;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_member_id = params.get("MEMBER_ID").toString();			
			l_app_msg = "Member Id... "+l_member_id;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_member_surname = params.get("MEMBER_SURNAME").toString();			
			l_app_msg = "Member Surname... "+l_member_surname;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_member_initial = params.get("MEMBER_INITIAL").toString();			
			l_app_msg = "Member Initial... "+l_member_initial;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_depd_code = params.get("DEPD_CODE").toString();			
			l_app_msg = "Depd Code... "+l_depd_code;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_depd_reln = params.get("DEPD_RELN").toString();
			l_app_msg = "Depd reln... "+l_depd_reln;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_dest_code = params.get("DEST_CD").toString();	
			l_app_msg = "Dest Code... "+l_dest_code;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			/********** Bill Document Number **********/

			l_facility_id = params.get("FACILITY_ID").toString();	
			l_app_msg = "Facility Id... "+l_facility_id;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_doc_type_code = params.get("BILL_DOC_TYPE_CODE").toString();	
			l_app_msg = "Document Type Code... "+l_doc_type_code;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_doc_no_str = params.get("BILL_DOC_NO").toString();	
			l_app_msg = "Document_number str... "+l_doc_no_str;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_claim_type = params.get("CLAIM_TYPE").toString();	
			l_app_msg = "Claim Type... "+l_claim_type;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			l_doc_num = Integer.parseInt(l_doc_no_str);

			l_trans_ref_no = params.get("CLAIM_NUM").toString();	
			l_app_msg = "Trans reference Number... "+l_trans_ref_no;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			
			//Added By bhuvana
			l_policy_number_str = params.get("POLICY_NUMBER").toString();	
			l_app_msg = "Policy Number... "+l_policy_number_str;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			

			/*l_policy_start_date = params.get("POLICY_START_DATE").toString();	
			l_app_msg = "Policy Start Date... "+l_policy_start_date;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_policy_expiry_date = params.get("POLICY_EXPIRY_DATE").toString();	
			l_app_msg = "Policy Expiry Date... "+l_policy_expiry_date;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);*/

			//Ended

			l_app_msg = "Fetching Event_Type... ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_event_type = FetchFieldValue(actionKey, "<EVENT_TYPE>", null, l_field_separator, "CreateHeaderMessage");			
			l_app_msg = "l_event_type... "+l_event_type;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			/************<DOCUMENT>*************/

			l_app_msg = "Retrieving Document Version No...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_element_id = "DOCUMENT_VER_NO";

			l_document_ver_no = FetchStdCntrlSeg("ELC", l_element_id, l_standard_code);
			if (l_document_ver_no.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_document_ver_no;
			}
			l_app_msg = "Document Version No... "+l_document_ver_no;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			/************<TX>*************/
			
			l_app_msg = "Retrieving Hospital No...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			//l_element_id = "HOSPITAL_NO";

			/*

			if (l_request.equals("REV") || l_request.equals("EOC"))
			{
				l_ref_no = fetchReferNo(actionKey);
				l_app_msg = "Reference Number... "+l_ref_no;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
				if (l_ref_no.indexOf("Error")>=0)
				{
					l_errcd = "E";
					l_errmsg = l_ref_no;
					return l_errmsg;
				}	

				String[] refNo = l_ref_no.split("/");


				l_app_msg = "refNo.length()... "+refNo.length;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				if (refNo.length>0)
				{
					l_trans_ref_no =  refNo[0];
					l_event_type =  refNo[1];
				}

				l_app_msg = "Trans Reference Number... "+l_trans_ref_no+"Event Type... "+l_event_type;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
				
			}

			*/
			
			l_element_id = "TX_CD_"+l_request;
			if(l_request.equals("REV")){
               l_element_id +=l_event_type;
			}

            l_app_msg = "Request Type... "+l_element_id;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_tx_cd = FetchStdCntrlSeg(l_segment_id, l_element_id, l_standard_code);
			if (l_tx_cd.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_tx_cd;
			}	
			l_app_msg = "tx cd... "+l_tx_cd;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_app_msg = "Retrieving PAY ADV...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_element_id = "PAY_ADV";

			l_pay_adv = FetchStdCntrlSeg("ELC", l_element_id, l_standard_code);
			if (l_pay_adv.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_pay_adv;
			}	
			l_app_msg = "Pay Adv... "+l_pay_adv;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_app_msg = "Retrieving AMD IND...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_element_id = "AMD_IND";

			l_amd_ind = FetchStdCntrlSeg(l_segment_id, l_element_id, l_standard_code);
			if (l_amd_ind.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_amd_ind;
			}	
			l_app_msg = "Amd Ind... "+l_amd_ind;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_app_msg = "Retrieving MSG FMT...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_element_id = "MSG_FMT";

            if (l_request.equals("REV"))
            {
				l_element_id = "MSG_FMT_"+l_request;
            }
			l_msg_fmt = FetchStdCntrlSeg("ELC", l_element_id, l_standard_code);
			if (l_msg_fmt.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_msg_fmt;
			}	
			l_app_msg = "Message Format... "+l_msg_fmt;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_app_msg = "Retrieving ORIG...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_element_id = "ORIG";

			l_orig = FetchStdCntrlSeg("ELC", l_element_id, l_standard_code);
			if (l_orig.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_orig;
			}	
			l_app_msg = "Orig... "+l_orig;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_app_msg = "Retrieving BIN...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_element_id = "BIN";

			l_bin = FetchStdCntrlSeg("ELC", l_element_id, l_standard_code);
			if (l_bin.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_bin;
			}	
			l_app_msg = "Bin... "+l_bin;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_app_msg = "Retrieving CNTRY CODE...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_element_id = "CNTRY_CD";

			l_cntry_cd = FetchStdCntrlSeg("ELC", l_element_id, l_standard_code);
			if (l_cntry_cd.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_cntry_cd;
			}	
			l_app_msg = "Country Code... "+l_cntry_cd;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_app_msg = "Retrieving SECT CODE...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_element_id = "SECT_CD";

			l_sect_cd = FetchStdCntrlSeg("ELC", l_element_id, l_standard_code);
			if (l_sect_cd.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_sect_cd;
			}	
			l_app_msg = "Sect Cd... "+l_sect_cd;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			/************<VEND>*************/

			l_app_msg = "Retrieving VEND ID...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_element_id = "VEND_ID";

			l_vend_id = FetchStdCntrlSeg(l_segment_id, l_element_id, l_standard_code);
			if (l_vend_id.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_vend_id;
			}	
			l_app_msg = "Vendor Id... "+l_vend_id;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_app_msg = "Retrieving Document Version No...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_element_id = "VEND_VER";

			l_vend_ver = FetchStdCntrlSeg(l_segment_id, l_element_id, l_standard_code);
			if (l_vend_id.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_vend_id;
			}	

			l_app_msg = "Vendor Version... "+l_vend_ver;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_element_id = "CLM_ORIG";

			l_clm_orig = FetchStdCntrlSeg("ELC", l_element_id, l_standard_code);
			if (l_clm_orig.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_clm_orig;
			}	
			l_app_msg = "Claim Origin... "+l_clm_orig;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_app_msg = " Getting Formatted Date Time... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_request_date = getFormattedStringDate("yyyyMMdd", new java.util.Date());

			l_app_msg = "Request Date... "+l_request_date;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_app_msg = " Replacing XML with Document details... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_xml_string = l_xml_string.replaceAll("#docverno", StringEscapeUtils.escapeXml(l_document_ver_no));

			l_xml_string = l_xml_string.replaceAll("#transseqNo", l_trans_ref_no);
			l_xml_string = l_xml_string.replaceAll("#seqNo", l_seq_no);

			
			l_xml_string = l_xml_string.replaceAll("#destCode", StringEscapeUtils.escapeXml(l_dest_code.toUpperCase()));
			l_xml_string = l_xml_string.replaceAll("#date", l_request_date);

			l_xml_string = l_xml_string.replaceAll("#transCode", l_tx_cd.toUpperCase());
			l_xml_string = l_xml_string.replaceAll("#payAdv", l_pay_adv.toUpperCase());
			l_xml_string = l_xml_string.replaceAll("#amdind", l_amd_ind);
			l_xml_string = l_xml_string.replaceAll("#msgFmt", StringEscapeUtils.escapeXml(l_msg_fmt.toUpperCase()));
			l_xml_string = l_xml_string.replaceAll("#orig", l_orig.toUpperCase());
			l_xml_string = l_xml_string.replaceAll("#bin", l_bin);
			l_xml_string = l_xml_string.replaceAll("#cntryCode", StringEscapeUtils.escapeXml(l_cntry_cd.toUpperCase()));
			l_xml_string = l_xml_string.replaceAll("#sectCode", StringEscapeUtils.escapeXml(l_sect_cd.toUpperCase()));

			l_xml_string = l_xml_string.replaceAll("#vendId", l_vend_id.toUpperCase());
			l_xml_string = l_xml_string.replaceAll("#vendVersion", StringEscapeUtils.escapeXml(l_vend_ver.toUpperCase()));	
			l_xml_string = l_xml_string.replaceAll("#clmOrig", l_clm_orig.toUpperCase());

			l_xml_string = l_xml_string.replaceAll("#memberId", StringEscapeUtils.escapeXml(l_member_id.toUpperCase()));
			l_xml_string = l_xml_string.replaceAll("#relationship", l_depd_reln.toUpperCase());
			l_xml_string = l_xml_string.replaceAll("#memSurname", StringEscapeUtils.escapeXml(l_member_surname.toUpperCase()));
			l_xml_string = l_xml_string.replaceAll("#memInitial", StringEscapeUtils.escapeXml(l_member_initial.toUpperCase()));
			l_xml_string = l_xml_string.replaceAll("#dependantCode", l_depd_code.toUpperCase());
			//Added by bhuvana
			l_xml_string = l_xml_string.replaceAll("#encounterid", StringEscapeUtils.escapeXml(l_encounter_id.toUpperCase()));
			l_xml_string = l_xml_string.replaceAll("#policynumber", l_policy_number_str);
            
			l_app_msg = "Retrieving Hospital Number...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			//l_element_id = "HOSPITAL_NO";

			l_hospital_no = XHUtil.getHospitalNo(l_facility_id);
			if (l_hospital_no.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_hospital_no;
			}	
			l_app_msg = "Hospital Number... "+l_hospital_no;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	


			l_xml_string = l_xml_string.replaceAll("#hospNo", StringEscapeUtils.escapeXml(l_hospital_no.toUpperCase()));
			System.out.println("Xml String"+l_xml_string);			

			l_app_msg = " Getting Connection Object... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			Conn =  ConnectionManager.getConnection();				

			l_query = "Select count(*) ITEM_COUNT "
						+" from   XF_ECLAIMS_BILL_DETAILS_VW "
						+" where OPERATING_FACILITY_ID = ? and bill_doc_type_code = ? and bill_doc_num = ?";

			pstmt = Conn.prepareStatement(l_query);
			
			l_app_msg = " Fetching Item Count details... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);		

			pstmt.setString(1, l_facility_id);
			pstmt.setString(2, l_doc_type_code);
			pstmt.setInt(3, l_doc_num);
			rs = pstmt.executeQuery();			

			l_line_count = 0;

			while(rs.next())
			{				
				l_line_count = rs.getInt("ITEM_COUNT");
			}

			l_app_msg = "Line Count... "+l_line_count;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_xml_string = l_xml_string.replaceAll("#itemno", String.valueOf(l_line_count));

			l_app_msg = " Fetching New Born Status details... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			pstmt = null;
			rs = null;

			l_query = "Select count(*) NEW_BORN_COUNT "
						+" from   MP_BIRTH_REGISTER "
						+" where PATIENT_ID = ?";

			pstmt = Conn.prepareStatement(l_query);
			pstmt.setString(1, l_patient_id);
			rs = pstmt.executeQuery();

			l_line_count = 0;
			l_new_born_flag = "N";

			while(rs.next())
			{
				l_line_count = rs.getInt("NEW_BORN_COUNT");
			}

			if (l_line_count > 0)
			{
				l_new_born_flag = "Y";
			}


			l_xml_string = l_xml_string.replaceAll("#newborn", l_new_born_flag.toUpperCase());

			l_app_msg = " Fetching Patient details... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_patient_id = params.get("PATIENT_ID").toString();			

			l_app_msg = "...: Inside if Emergency patient...: ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			pstmt = null;
			rs = null;
			
			query = "SELECT PATIENT_CLASS, to_char(VISIT_ADM_DATE_TIME,'yyyyMMdd') VISIT_ADM_DATE_TIME FROM PR_ENCOUNTER "
					 + " WHERE FACILITY_ID = ? AND PATIENT_ID = ? AND ENCOUNTER_ID = ? ";

			l_app_msg = "...: query...: "+query;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			pstmt = Conn.prepareStatement(query);
			pstmt.setString(1,l_facility_id);
			pstmt.setString(2,l_patient_id);
			pstmt.setString(3,l_encounter_id);
			rs = pstmt.executeQuery();

			while(rs.next())
			{
			   l_visit_time = rs.getString("VISIT_ADM_DATE_TIME")==null?"":rs.getString("VISIT_ADM_DATE_TIME").toString();
			   /*
			   DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
			   Date date = formatter.parse(l_visit_time);
			   l_acc_dt = getFormattedStringDate("yyyyMMdd", date);
			   */
			}
			l_app_msg = "...: Visit_time...: "+l_visit_time;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
				
			if (l_request.equals("CLA")||l_request.equals("CLE"))
			{
				if (l_claim_type.equals("3"))
					l_xml_string = l_xml_string.replaceAll("#other", "<OTHER wca_nbr = \""+l_wca_num+"\" dt_of_acdnt = \""+l_visit_time+"\"/>");
				else
					l_xml_string = l_xml_string.replaceAll("#other", "");				
			}
			else{
                l_xml_string = l_xml_string.replaceAll("#other", "");
			}

			if (l_visit_time.length()>0)
				l_xml_string = l_xml_string.replaceAll("#admdate", l_visit_time);
			else
				l_xml_string = l_xml_string.replaceAll("#admdate", l_request_date);


			patDetailMap = new HashMap(FetchPatientDetails(l_patient_id));

			l_app_msg = " After Fetching Patient details..Map Size... "+patDetailMap.size();
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			if (!(patDetailMap.isEmpty()))
			{
				l_app_msg = " Inside patDetailMap not empty... ";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				if (patDetailMap.containsKey("ERROR"))
				{
					l_errcd = "E";
					l_errmsg = patDetailMap.get("ERROR").toString();
					l_app_msg = "Error Message... "+l_errmsg;
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				}
				else
				{
					l_app_msg = " Inside patDetailMap Error Else... ";
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

					l_family_name = patDetailMap.get("FAMILY_NAME").toString()==null?"":patDetailMap.get("FAMILY_NAME").toString();					
					l_name_prefix = patDetailMap.get("NAME_PREFIX").toString()==null?"":patDetailMap.get("NAME_PREFIX").toString();
					l_date_of_birth = patDetailMap.get("DATE_OF_BIRTH").toString()==null?"":patDetailMap.get("DATE_OF_BIRTH").toString();
					l_national_id_no = patDetailMap.get("NATIONAL_ID").toString()==null?"":patDetailMap.get("NATIONAL_ID").toString();
					l_passport_id = patDetailMap.get("PASSPORT_ID").toString()==null?"":patDetailMap.get("PASSPORT_ID").toString();
					l_first_name = patDetailMap.get("FIRST_NAME").toString()==null?"":patDetailMap.get("FIRST_NAME").toString();					
					l_sex = patDetailMap.get("SEX").toString()==null?"":patDetailMap.get("SEX").toString();
					l_addr1_line1 = patDetailMap.get("ADDR1_LINE1").toString()==null?"":patDetailMap.get("ADDR1_LINE1").toString();
					l_addr1_line2 = patDetailMap.get("ADDR1_LINE2").toString()==null?"":patDetailMap.get("ADDR1_LINE2").toString();
					l_addr1_line3 = patDetailMap.get("ADDR1_LINE3").toString()==null?"":patDetailMap.get("ADDR1_LINE3").toString();
					l_race_code = patDetailMap.get("RACE_CODE").toString()==null?"":patDetailMap.get("RACE_CODE").toString();
					l_res_town_desc = patDetailMap.get("CITY_DESC").toString()==null?"":patDetailMap.get("CITY_DESC").toString();
					l_postal1_code = patDetailMap.get("POSTAL1_CODE").toString()==null?"":patDetailMap.get("POSTAL1_CODE").toString();	
					l_region_desc = patDetailMap.get("REGION_DESC").toString()=="XYZ"?"":patDetailMap.get("REGION_DESC").toString();	

					l_app_msg = "After Getting Patient Details from patDetailMap: " + l_national_id_no + "" + l_name_prefix + "" + l_first_name + "" + l_third_name + "" + l_family_name + "" + l_patient_name + "" + l_sex + "" + l_date_of_birth + "" + l_race_code + "" + l_addr1_line1 + "" + l_addr1_line2 + "" + l_postal1_code + "" + l_res_town_desc;
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);


					l_name_prefix = "";

					if (!l_first_name.equals("XYZ"))
					{
						l_name_prefix = l_first_name.substring(0, 1);
					}
					if (!l_family_name.equals("XYZ"))
					{
						l_name_prefix = l_name_prefix + l_family_name.substring(0, 1);
					}

                    //l_name_prefix = l_first_name.substring(0, 1)+""+l_family_name.substring(0, 1);

					l_xml_string = l_xml_string.replaceAll("#patientId", StringEscapeUtils.escapeXml(l_patient_id.toUpperCase()));
					l_xml_string = l_xml_string.replaceAll("#surname", StringEscapeUtils.escapeXml(l_family_name.toUpperCase()));
					l_xml_string = l_xml_string.replaceAll("#initial", StringEscapeUtils.escapeXml(l_name_prefix.toUpperCase()));
					l_xml_string = l_xml_string.replaceAll("#dob", l_date_of_birth);
					if (l_national_id_no.equals("XYZ"))
					{
						l_national_id_no = "";
					}
					l_xml_string = l_xml_string.replaceAll("#nationalId", StringEscapeUtils.escapeXml(l_national_id_no.toUpperCase()));
					l_xml_string = l_xml_string.replaceAll("#firstname", StringEscapeUtils.escapeXml(l_first_name.toUpperCase()));
					l_xml_string = l_xml_string.replaceAll("#gender", l_sex.toUpperCase());
					l_xml_string = l_xml_string.replaceAll("#addrLine1", StringEscapeUtils.escapeXml(l_addr1_line1.toUpperCase()));
					l_xml_string = l_xml_string.replaceAll("#addrLine2", StringEscapeUtils.escapeXml(l_addr1_line2.toUpperCase()));
					l_xml_string = l_xml_string.replaceAll("#suburb", StringEscapeUtils.escapeXml(l_addr1_line3.toUpperCase()));


					if (l_race_code.length()>0)
					{
						l_race_cd = getRaceCode(l_race_code);
					}
					l_app_msg = "Race Code Returned: " + l_race_cd;
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

					l_patient_status = l_episode_type;

					if (l_episode_type.equals("E"))
					{
						l_patient_status = "O";
					}

					if (l_episode_type.equals("D"))
					{
						l_patient_status = "I";
					}

					l_xml_string = l_xml_string.replaceAll("#raceCode", StringEscapeUtils.escapeXml(l_race_cd.toUpperCase()));
					l_xml_string = l_xml_string.replaceAll("#city", StringEscapeUtils.escapeXml(l_res_town_desc.toUpperCase()));
					l_xml_string = l_xml_string.replaceAll("#postCode", StringEscapeUtils.escapeXml(l_postal1_code.toUpperCase()));
					l_xml_string = l_xml_string.replaceAll("#prov", StringEscapeUtils.escapeXml(l_region_desc.toUpperCase()));
					l_xml_string = l_xml_string.replaceAll("#paystatus", l_patient_status);	
					
					if (l_passport_id.equals("XYZ"))
					{
						l_passport_id = "";
					}
					l_xml_string = l_xml_string.replaceAll("#passport", StringEscapeUtils.escapeXml(l_passport_id.toUpperCase()));

					l_xml_string = l_xml_string.replaceAll("XYZ", "");	
					
				}
			}
             
			l_xml_msg.append(l_xml_string);			
		}
		catch (Exception e)
		{
			l_errcd = "E";
			l_xml_msg.append("Error in "+ l_app_msg +" - " + e.getMessage());
			//l_errmsg = l_errcd + "$!^" + l_xml_msg + "$!^" + e.getMessage() + "$!^" + e.getMessage();		
		}	
		finally
		{			
			closeDBResources(rs, pstmt, Conn);				
		}

		l_app_msg = "XML Message... "+l_xml_msg;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

		return l_xml_msg.toString();
	}

	public HashMap FetchPatientDetails(String patientID){

		Connection Conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		String query = "";
		String l_app_msg = "";

		String l_patient_id = "", l_national_id_no = "", l_passport_id = "", l_name_prefix = "", l_first_name = "",  l_third_name = "", l_family_name = "", l_patient_name = "", l_sex = "", l_date_of_birth = "", l_race_code = "", l_region_desc = "";

		String l_addr1_line1 = "", l_addr1_line2 = "", l_addr1_line3 = "", l_postal1_code = "",   l_res_town_desc = "";

		HashMap patientDetailsMap = new HashMap();

		l_app_msg = "Inside FetchPatientDetails";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = "Patient ID... "+ patientID;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		
		try
		{
			Conn =  ConnectionManager.getConnection();
			query = "Select a.PATIENT_ID, nvl(NATIONAL_ID_NO,'') NATIONAL_ID_NO, nvl(a.ALT_ID1_NO,'') ALT_ID1_NO, nvl(NAME_PREFIX,'') NAME_PREFIX, nvl(FIRST_NAME,'') FIRST_NAME, NVL (FAMILY_NAME, '') FAMILY_NAME, nvl(THIRD_NAME,'') THIRD_NAME, nvl(PATIENT_NAME,'') PATIENT_NAME, decode(NVL (sex, ''), 'M', '1', 'F', '2') SEX, TO_CHAR(NVL (date_of_birth, ''), 'yyyymmdd')  DATE_OF_BIRTH,  nvl(RACE_CODE,'') RACE_CODE,  nvl(ADDR1_LINE1,'') ADDR1_LINE1, nvl(ADDR1_LINE2,'') ADDR1_LINE2, nvl(ADDR1_LINE3,'') ADDR1_LINE3, nvl(POSTAL1_CODE,'') POSTAL1_CODE, nvl(REGION1_CODE,'') REGION1_CODE, nvl(RES_AREA1_CODE,'')  RES_AREA1_CODE, nvl(RES_TOWN1_CODE,'') RES_TOWN1_CODE, NVL (c.LONG_DESC, '') CITY_DESC, NVL (d.LONG_DESC, '') REGION_DESC "
						+" from MP_PATIENT a, MP_PAT_ADDRESSES b, MP_RES_TOWN c, MP_REGION d "
						+" where a.PATIENT_ID = b.PATIENT_ID(+) " 
						+"		AND b.RES_TOWN1_CODE = c.RES_TOWN_CODE (+) "
						+"		AND a.REGION_CODE = d.REGION_CODE (+) "
						+"		AND a.PATIENT_ID = ? ";

			pstmt = Conn.prepareStatement(query);
			pstmt.setString(1, patientID);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
			   l_patient_id = rs.getString("PATIENT_ID")==null?"XYZ":rs.getString("PATIENT_ID");
			   l_national_id_no = rs.getString("NATIONAL_ID_NO")==null?"XYZ":rs.getString("NATIONAL_ID_NO");
			   l_passport_id = rs.getString("ALT_ID1_NO")==null?"XYZ":rs.getString("ALT_ID1_NO");
			   l_name_prefix = rs.getString("NAME_PREFIX")==null?"XYZ":rs.getString("NAME_PREFIX");
			   l_first_name = rs.getString("FIRST_NAME")==null?"XYZ":rs.getString("FIRST_NAME");			  
			   l_third_name = rs.getString("THIRD_NAME")==null?"XYZ":rs.getString("THIRD_NAME");
     		   l_family_name = rs.getString("FAMILY_NAME")==null?"XYZ":rs.getString("FAMILY_NAME");
			   l_patient_name = rs.getString("PATIENT_NAME")==null?"XYZ":rs.getString("PATIENT_NAME");
			   l_sex = rs.getString("SEX")==null?"XYZ":rs.getString("SEX");
			   l_date_of_birth = rs.getString("DATE_OF_BIRTH")==null?"XYZ":rs.getString("DATE_OF_BIRTH");
			   l_race_code = rs.getString("RACE_CODE")==null?"XYZ":rs.getString("RACE_CODE");
			   l_addr1_line1 = rs.getString("ADDR1_LINE1")==null?"XYZ":rs.getString("ADDR1_LINE1");
			   l_addr1_line2 = rs.getString("ADDR1_LINE2")==null?"XYZ":rs.getString("ADDR1_LINE2");
			   l_addr1_line3 = rs.getString("ADDR1_LINE3")==null?"XYZ":rs.getString("ADDR1_LINE3");
			   l_postal1_code = rs.getString("POSTAL1_CODE")==null?"XYZ":rs.getString("POSTAL1_CODE");
			   l_res_town_desc = rs.getString("CITY_DESC")==null?"XYZ":rs.getString("CITY_DESC");
			   l_region_desc =  rs.getString("REGION_DESC")==null?"XYZ":rs.getString("REGION_DESC");
			}

			l_app_msg = "Patient Details... "+ l_patient_id + "" + l_national_id_no + "" + l_name_prefix + "" + l_first_name + "" + l_third_name + "" + l_family_name + "" + l_patient_name + "" + l_sex + "" + l_date_of_birth + "" + l_race_code + "" + l_addr1_line1 + "" + l_addr1_line2 + "" + l_addr1_line3 + "" +l_postal1_code + "" + l_res_town_desc;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			patientDetailsMap.put("PATIENT_ID", l_patient_id);
			
			l_app_msg = "Patient Details - National Id Number ... "+ l_national_id_no;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			patientDetailsMap.put("NATIONAL_ID", l_national_id_no); 

			l_app_msg = "Patient Details - Passport Id... "+ l_passport_id;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			patientDetailsMap.put("PASSPORT_ID", l_passport_id); 

			l_app_msg = "Patient Details - Name Prefix: "+ l_name_prefix;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			patientDetailsMap.put("NAME_PREFIX", l_name_prefix);

			l_app_msg = "Patient Details - First Name: "+ l_first_name;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			patientDetailsMap.put("FIRST_NAME", l_first_name);

			l_app_msg = "Patient Details - Third Name... "+ l_third_name;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			patientDetailsMap.put("THIRD_NAME", l_third_name);

			l_app_msg = "Patient Details - Family Name "+ l_family_name;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			patientDetailsMap.put("FAMILY_NAME", l_family_name);

			l_app_msg = "Patient Details - Patient Name "+ l_patient_name;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			patientDetailsMap.put("PATIENT_NAME", l_patient_name); 

			l_app_msg = "Patient Details - Sex "+ l_sex;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			patientDetailsMap.put("SEX", l_sex); 

			l_app_msg = "Patient Details - Date Of Birth "+ l_date_of_birth;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			patientDetailsMap.put("DATE_OF_BIRTH", l_date_of_birth);

			l_app_msg = "Patient Details - Race Code "+ l_race_code;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			patientDetailsMap.put("RACE_CODE", l_race_code);

			l_app_msg = "Patient Details - Address1 Line 1 "+ l_addr1_line1;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			patientDetailsMap.put("ADDR1_LINE1", l_addr1_line1); 

			l_app_msg = "Patient Details - Address1 Line 2 "+ l_addr1_line2;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			patientDetailsMap.put("ADDR1_LINE2", l_addr1_line2);

			l_app_msg = "Patient Details - Address1 Line 2 "+ l_addr1_line3;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			patientDetailsMap.put("ADDR1_LINE3", l_addr1_line3);

			l_app_msg = "Patient Details - Postal1 Code "+ l_postal1_code;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			patientDetailsMap.put("POSTAL1_CODE", l_postal1_code);

			l_app_msg = "Patient Details - Res Town Code "+ l_res_town_desc;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			patientDetailsMap.put("CITY_DESC", l_res_town_desc);

			l_app_msg = "Patient Details - Region Description "+ l_region_desc;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			patientDetailsMap.put("REGION_DESC", l_region_desc);			

			l_app_msg = "patientDetailsMap Size... "+ patientDetailsMap.size();
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
		}
		catch(Exception e)
		{
			patientDetailsMap.put("ERROR", e.getMessage());
			System.out.println(e.getMessage());

		}
		finally
		{			
			closeDBResources(rs, pstmt, Conn);			
		}		

		return patientDetailsMap;
	}

	public String CreateItemMessage(String request, String actionKey, Map params){

		Connection Conn = null;
		ResultSet rs=null, rs1=null;
		ResultSet rsproc=null;
		//ResultSet rsmedi = null;
		ResultSet rspract = null;
		PreparedStatement pstmt = null, pstmtproc = null, pstmtprac = null, pstmt1 = null;

		String query = "", query1="";
		String l_app_msg = "", l_element_id = "";

		String l_facility_id = "", l_doc_type_code = "", l_doc_no_str = "", l_patient_id = "", l_encounter_id = "";
		int l_doc_no;

		String  l_tp = "2", l_cdg_set = "", l_auth_nbr = "", l_orig_tp_ind = "", l_serv_grp_code = "", l_serv_code = "", l_serv_desc = "", l_los = "1.00", l_physician_id = "", l_hpc_nbr = "";
		String l_module_id = "", l_serv_item_code = "", l_start_date = "", l_end_date = "", l_start_time = "", l_end_time = "", l_time_mins = "", l_doc_fee_yn = "";
		//String l_dly_dos = "", l_duration = "";

		String l_prov_cat = "", l_prov_st = "F", l_tp_ind = "";

		String l_tar_ind = "", l_fee_tp = "F", l_disp_fee = "0.00";// l_co_pay = "0.00", l_sub_disc = "", l_gross = "";

		String l_item_xml = "", l_diagnosis_xml = "", l_line_num = "",  l_upfs_code = "";

		String l_med_grp = "", l_grp_hdr = "";

		int l_qty = 0;

		int l_line_count = 0 ;
		String l_stock_code = "";

		String l_wca_num = ""; //Added by bhuvana for LMP-SCF-0263 on 18/07/2019

		double l_upd_gross_charge_amt = 0.00, l_upd_disc_amt = 0.00, l_ins_net_amt = 0.00;

		double l_upd_gross_copay_amt = 0.00, l_upd_net_copay_amt = 0.00;

		StringBuffer l_item_strbfr = new StringBuffer();
		StringBuffer l_proc_strbfr = new StringBuffer();
		StringBuffer l_medi_strbfr = new StringBuffer();

		int l_trx_doc_ref_line_num = 0, l_trx_doc_ref_seq_num = 0;
		String l_trx_doc_ref_num = "";
		l_app_msg = "Inside CreateItemMessage";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		try
		{

			l_facility_id = params.get("FACILITY_ID").toString();			
			l_app_msg = "Facility Id... "+l_facility_id;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_patient_id = params.get("PATIENT_ID").toString();			
			l_app_msg = "Patient Id... "+l_patient_id;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_encounter_id = params.get("ENCOUNTER_ID").toString();			
			l_app_msg = "Encounter Id... "+l_encounter_id;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_doc_type_code = params.get("BILL_DOC_TYPE_CODE").toString();			
			l_app_msg = "Document Type Code... "+l_doc_type_code;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_doc_no_str = params.get("BILL_DOC_NO").toString();			
			l_app_msg = "Document Number Str... "+l_doc_no_str;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_doc_no = Integer.parseInt(l_doc_no_str);

			l_auth_nbr = params.get("AUTHORIZATION_NUM").toString();			
			l_app_msg = "Auth Number... "+l_auth_nbr;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			//Added by bhuvana for LMP-SCF-0263 on 18/07/2019

			l_wca_num = params.get("WCA_NUM").toString();			
			l_app_msg = "l_wca_num... "+l_wca_num;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			if(l_wca_num.equals("XXX"))
			{
				l_wca_num = "";
			}

			//Code ended for LMP-SCF-0263 on 18/07/2019

			l_app_msg = "Retrieving ORIG TP IND...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_element_id = "ORIG_TP_IND";

			l_orig_tp_ind = FetchStdCntrlSeg("ECL", l_element_id, l_standard_code);
			if (l_orig_tp_ind.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_orig_tp_ind;
			}
			l_app_msg = "Orig Tp Ind... "+l_orig_tp_ind;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			l_app_msg = "Retrieving TAR IND...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_element_id = "TAR_IND";

			l_tar_ind = FetchStdCntrlSeg("ECL", l_element_id, l_standard_code);
			if (l_tar_ind.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_tar_ind;
			}
			l_app_msg = "Tar Ind... "+l_tar_ind;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_app_msg = "Retrieving PROV CAT...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_element_id = "PROV_CAT";

			l_prov_cat = FetchStdCntrlSeg("ECL", l_element_id, l_standard_code);
			if (l_prov_cat.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_prov_cat;
			}
			l_app_msg = "Prov Cat... "+l_prov_cat;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_app_msg = "Retrieving PROV ST...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_element_id = "PROV_ST";

			l_prov_st = FetchStdCntrlSeg("ECL", l_element_id, l_standard_code);
			if (l_prov_st.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_prov_st;
			}
			l_app_msg = "Prov St... "+l_prov_st;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_app_msg = "Retrieving TP IND...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_element_id = "TP_IND";

			l_tp_ind = FetchStdCntrlSeg("ECL", l_element_id, l_standard_code);
			if (l_tp_ind.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_tp_ind;
			}
			l_app_msg = "Tp Ind... "+l_tp_ind;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);			

			l_element_id = "MED_GP";

			l_med_grp = FetchStdCntrlSeg("ECL", l_element_id, l_standard_code);
			if (l_med_grp.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_med_grp;
			}
			l_app_msg = "Med group... "+l_med_grp;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);


			Conn =  ConnectionManager.getConnection();
			query = "Select TRX_DOC_REF, TRX_DOC_REF_LINE_NUM, ORG_GROSS_CHARGE_AMT, ORG_DISC_AMT, SERV_QTY, BLNG_SERV_CODE, SERV_DESC, SERV_ITEM_DESC, SERV_ITEM_CODE, "
						+" ICD_CODE_SCHEME, ICD_CODE, SERVICE_DATE, MODULE_ID, DR_SHARE_APPL_YN, to_char(SERVICE_DATE,'YYYYMMDD') SERVICE_START_DATE, PHYSICIAN_ID, "
						+" concat(substr(TRX_DOC_REF, 13), TRX_DOC_REF_LINE_NUM) BILL_LINE_NO , UPFS_CODE, to_char(SERVICE_DATE,'HH24MISS') SERVICE_START_TIME, SERV_GRP_CODE, "
						+" TRX_DOC_REF_SEQ_NUM, PRT_GRP_HDR_CODE, "
						+" ORG_NET_CHARGE_AMT "
						+" from XF_ECLAIMS_BILL_DETAILS_VW "
						+" where OPERATING_FACILITY_ID = ? and bill_doc_type_code = ? and bill_doc_num = ? "
						+" order by TRX_DOC_REF, TRX_DOC_REF_LINE_NUM, TRX_DOC_REF_SEQ_NUM ";

			pstmt = Conn.prepareStatement(query);
			pstmt.setString(1, l_facility_id);
			pstmt.setString(2, l_doc_type_code);
			pstmt.setInt(3, l_doc_no);
			rs = pstmt.executeQuery();

			l_line_count = 0;

			l_item_strbfr = new StringBuffer();

			query = "select PROC_CODE, PROC_DATE, RECORD_TYPE, PROC_CODE_SCHEME, to_char(START_DATETIME,'YYYYMMDD') START_DATE, to_char(END_DATETIME,'YYYYMMDD') END_DATE, "
								+" to_char(START_DATETIME,'HH24MISS') START_TIME, to_char(END_DATETIME,'HH24MISS') END_TIME, (END_DATETIME - START_DATETIME)*24*60 TIME_MINS "
								+" from pr_encounter_procedure "
								+" where FACILITY_ID = ? and ENCOUNTER_ID = ? and PATIENT_ID = ? and PROC_CODE = ? ";
					
			pstmtproc = Conn.prepareStatement(query);

			/* Query to the Item wise copay amount details */

			/*

			query1 = "select h.org_gross_charge_amt org_gross_chrg_amt_copay, h.org_disc_amt org_disc_amt_copay, "
							+" h.org_net_charge_amt org_net_chrg_amt_copay, "
							+" h.adj_gross_charge_amt adj_gross_amt_copay, "
							+" h.adj_disc_amt adj_disc_amt_copay, "
							+" h.adj_net_charge_amt adj_net_chrg_copay, "
							+" h.base_charge_amt base_charge_amt_copay   " 
						+" from bl_patient_charges_folio h "
						+" where h.trx_doc_ref = ? "
								+" and   h.trx_doc_ref_line_num = ? "
								+" and   h.trx_doc_ref_seq_num = ? "
								+" and   h.settlement_ind = 'C' ";

			*/

			query1 = "select h.org_gross_charge_amt org_gross_chrg_amt_copay, h.org_disc_amt org_disc_amt_copay, "
							+" h.org_net_charge_amt org_net_chrg_amt_copay, "
							+" h.adj_gross_charge_amt adj_gross_amt_copay, "
							+" h.adj_disc_amt adj_disc_amt_copay, "
							+" h.adj_net_charge_amt adj_net_chrg_copay, "
							+" h.base_charge_amt base_charge_amt_copay   " 
						+" from bl_patient_charges_folio h "
						+" where (bill_doc_type_code,bill_doc_num) in ( "
											+" select a.doc_Type_code,a.doc_num from bl_bill_hdr a, bl_blng_grp b where  "
											+" 		  b.settlement_ind='C' and a.blng_grp_id=b.blng_grp_id and  "
											+" 		  a.mpi_id in ( "
											+" 		  select mpi_id from bl_bill_hdr WHERE  doc_type_code=? and doc_num=?) "
											+"  ) and h.blng_serv_code=? ";


			pstmt1 = Conn.prepareStatement(query1);
			
			while(rs.next())
			{	
				
				l_line_num = ""; l_serv_code = ""; l_serv_desc = "";
				l_module_id = ""; l_serv_item_code = "";  l_doc_fee_yn = ""; l_start_date = ""; l_physician_id = ""; 	l_upfs_code = "";  l_start_time = ""; 
				l_serv_grp_code = ""; l_grp_hdr = "";

				l_upd_gross_charge_amt = 0.00; l_upd_disc_amt = 0.00; l_qty = 0;
				l_trx_doc_ref_line_num = 0; l_trx_doc_ref_seq_num = 0; l_ins_net_amt = 0.00; l_upd_net_copay_amt = 0.00;
				l_trx_doc_ref_num = "";

				l_proc_strbfr = new StringBuffer();
				l_medi_strbfr = new StringBuffer();

				l_line_count++;			
				
				l_line_num = rs.getString("BILL_LINE_NO");
				l_upd_gross_charge_amt = rs.getDouble("ORG_GROSS_CHARGE_AMT");
				l_upd_disc_amt = rs.getDouble("ORG_DISC_AMT");
				l_serv_code = rs.getString("BLNG_SERV_CODE")==null?"":rs.getString("BLNG_SERV_CODE");
				l_serv_desc = rs.getString("SERV_DESC")==null?"":rs.getString("SERV_DESC");
				l_module_id = rs.getString("MODULE_ID")==null?"":rs.getString("MODULE_ID");	
				l_serv_item_code = rs.getString("SERV_ITEM_CODE")==null?"":rs.getString("SERV_ITEM_CODE");
				l_qty = rs.getInt("SERV_QTY");
				l_doc_fee_yn = rs.getString("DR_SHARE_APPL_YN")==null?"":rs.getString("DR_SHARE_APPL_YN");
				l_start_date = rs.getString("SERVICE_START_DATE")==null?"":rs.getString("SERVICE_START_DATE");
				l_physician_id = rs.getString("PHYSICIAN_ID")==null?"":rs.getString("PHYSICIAN_ID"); 	
				l_upfs_code = rs.getString("UPFS_CODE")==null?"":rs.getString("UPFS_CODE"); 
				l_start_time = rs.getString("SERVICE_START_TIME")==null?"":rs.getString("SERVICE_START_TIME");
				l_serv_grp_code = rs.getString("SERV_GRP_CODE")==null?"":rs.getString("SERV_GRP_CODE");

				l_grp_hdr = rs.getString("PRT_GRP_HDR_CODE")==null?"":rs.getString("PRT_GRP_HDR_CODE");
				
				l_trx_doc_ref_line_num = rs.getInt("TRX_DOC_REF_LINE_NUM");
				l_trx_doc_ref_seq_num = rs.getInt("TRX_DOC_REF_SEQ_NUM");
				l_trx_doc_ref_num = rs.getString("TRX_DOC_REF")==null?"":rs.getString("TRX_DOC_REF");
				l_ins_net_amt = rs.getDouble("ORG_NET_CHARGE_AMT");
				
				l_tp = "2";
				l_cdg_set = "05";

				if (l_serv_grp_code.equals(l_med_grp))
				{
					l_tp = "5";
					l_cdg_set = "06";
				}

				//l_auth_nbr = "";

				if (!(l_qty>0))
				{
					l_qty = 1;
				}

				/* Query to the Item wise copay amount details */

				rs1 = null;

				l_upd_gross_copay_amt = 0.00; 
				l_upd_net_copay_amt = 0.00; 

				pstmt1.setString(1, l_doc_type_code);
				pstmt1.setInt(2, l_doc_no);
				pstmt1.setString(3, l_serv_code);
				rs1 = pstmt1.executeQuery();

				while(rs1.next())
				{				
					l_upd_net_copay_amt = rs1.getDouble("org_net_chrg_amt_copay");
				}

				l_upd_gross_charge_amt = l_ins_net_amt + l_upd_net_copay_amt;

				//UPFS code and Med code changes	
				if (l_debug_YN.equals("Y")) 
					System.out.println(":::Serve code:::"+l_serv_code);	
				
				String l_split_code[] = l_serv_code.split("[-]");
				
				if(l_serv_code.length()>=0)
				{
					if(l_serv_code.contains("-") && l_split_code.length>=2)
					{
						l_upfs_code = l_split_code[0];
					    l_stock_code = l_split_code[l_split_code.length-1];	if (l_debug_YN.equals("Y")) 
						{
							System.out.println("else l_upfs_code is "+l_upfs_code);
							System.out.println("else l_stock_code is "+l_stock_code);
						}				 
					}						
					else 
					{		
						l_upfs_code = l_split_code[0];
					    l_stock_code="";								
					}
					if (l_debug_YN.equals("Y")) 
					{
						System.out.println("else l_upfs_code is "+l_upfs_code);
						System.out.println("else l_stock_code is "+l_stock_code);
					}
				}
				
				l_app_msg = "...:: Inside CreateItemMessage l_line_num...:: "+l_line_num;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
				
				//Changed the auth_nbr to l_wca_num for LMP-SCF=0263 on 18/07/2019
				l_item_strbfr.append("<ITEM lin_num=\""+l_line_num+"\" tp=\""+l_tp+"\" cdg_set=\""+l_cdg_set+"\" auth_nbr=\""+StringEscapeUtils.escapeXml(l_wca_num)+"\" orig_tp_ind=\""+l_orig_tp_ind+"\" descr=\""+StringEscapeUtils.escapeXml(l_serv_desc)+"\" los=\""+l_los+"\" pay_adv=\"P\" pdiem=\"0\" process_tp=\"01\" grp=\""+l_serv_grp_code+"\" >");

				l_proc_strbfr.append("<PROC stg_ind=\"01\" upfs_cd=\""+StringEscapeUtils.escapeXml(l_upfs_code)+"\" qty=\""+l_qty+"\" units=\"#units\" unit_tp=\"#unittp\">");

				if (l_module_id.equals("OT"))
				{						
					pstmtproc.setString(1, l_facility_id);
					pstmtproc.setString(2, l_encounter_id);
					pstmtproc.setString(3, l_patient_id);
					pstmtproc.setString(4, l_serv_item_code);
					rsproc = pstmtproc.executeQuery();
					while(rsproc.next())
					{
						l_start_date = rsproc.getString("START_DATE")==null?"":rsproc.getString("START_DATE");
						l_end_date = rsproc.getString("END_DATE")==null?"":rsproc.getString("END_DATE");

						l_start_time = rsproc.getString("START_TIME")==null?"":rsproc.getString("START_TIME");
						l_end_time = rsproc.getString("END_TIME")==null?"":rsproc.getString("END_TIME");

						l_time_mins = rsproc.getString("TIME_MINS")==null?"":rsproc.getString("TIME_MINS");

						l_proc_strbfr.replace(l_proc_strbfr.indexOf("#units"), l_proc_strbfr.indexOf("#units") + 6, l_time_mins);
						l_proc_strbfr.replace(l_proc_strbfr.indexOf("#unittp"), l_proc_strbfr.indexOf("#unittp") + 7, "03");

						l_proc_strbfr.append("<TRMNT end_tm=\""+l_end_time+"\" end_dt=\""+l_start_date+"\" st_tm=\""+l_start_time+"\" st_dt=\""+l_start_date+"\"/>");

					}	
					try {
							if (rsproc != null) {
								rsproc.close();
								l_app_msg = "Closing rsproc";
								//if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
							}
							
							if(pstmtproc != null) pstmtproc.close();			

						}
						catch(Exception exp) {
							l_app_msg = " Error in closing  rsproc"+exp.getMessage();
							exp.printStackTrace();
							//System.out.println(l_app_msg);	
						}
				}
				else
				{
					l_proc_strbfr.replace(l_proc_strbfr.indexOf("#units"), l_proc_strbfr.indexOf("#units") + 6, "01");
					l_proc_strbfr.replace(l_proc_strbfr.indexOf("#unittp"), l_proc_strbfr.indexOf("#unittp") + 7, "06");

					l_proc_strbfr.append("<TRMNT end_tm=\""+l_start_time+"\" end_dt=\""+l_start_date+"\" st_tm=\""+l_start_time+"\" st_dt=\""+l_start_date+"\"/>");

				}
				
				l_proc_strbfr.append("</PROC>");

				l_item_strbfr.append(l_proc_strbfr);

				if (l_serv_grp_code.equals(l_med_grp))
				{
					/*
					query = "Select facility_id, encounter_id, drug_code, generic_id, a.freq_code, duration, prescribed_qty, b.repeat_value "
							+" from ph_patient_drug_profile a, am_frequency b "
							+" where a.FREQ_CODE = b.FREQ_CODE and a.FACILITY_ID = ? and a.ENCOUNTER_ID = ? and a.PATIENT_ID = ? and DRUG_CODE = ? ";
					
					pstmt = dbConn.prepareStatement(query);
					pstmt.setString(1, l_facility_id);
					pstmt.setString(2, l_encounter_id);
					pstmt.setString(3, l_patient_id);
					pstmt.setString(4, l_serv_item_code);
					rsmedi = pstmt.executeQuery();

					while(rsmedi.next())
					{
						l_dly_dos = rsmedi.getString("REPEAT_VALUE")==null?"":rsmedi.getString("REPEAT_VALUE");
						l_duration = rsmedi.getString("DURATION")==null?"":rsmedi.getString("DURATION");
					}	
					l_medi_strbfr.append("<MED stock_cd = \""+l_serv_code+"\" dly_ds = \""+l_dly_dos+"\" est_days_sup = \""+l_duration+"\" basis_of_eds = \"2\" qty = \""+l_qty+"\" mix_cd = \"0\"/>");	

					*/

					l_medi_strbfr.append("<MED stock_cd = \""+l_stock_code+"\" qty = \""+l_qty+"\" />");	
									
				}				

				l_item_strbfr.append(l_medi_strbfr);

				l_diagnosis_xml = "";

				l_app_msg = "Before CreateDiagnosisMessage";
				//if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				l_diagnosis_xml = CreateDiagnosisMessage(request, actionKey, params, "DIAG", "B");
				if (l_diagnosis_xml.indexOf("Error")>=0)
				{
					l_errcd = "E";
					l_errmsg = l_diagnosis_xml;
				}

				l_app_msg = "After CreateDiagnosisMessage";
				//if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				if (l_errcd.equals("S"))
				{
					l_item_strbfr.append(l_diagnosis_xml);
				}

				if (l_doc_fee_yn.equals("Y"))
					l_fee_tp = "P";
				else
					l_fee_tp = "F";

				l_hpc_nbr = "";

				l_app_msg = "Before Physician Id "+l_physician_id;
				//if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
				
				if (l_physician_id.length()>0 && l_physician_id != null)
				{
				
					query = "select CREDENTIAL_ID1 from AM_PRACTITIONER "
							+" where PRACTITIONER_ID = ?";

					pstmtprac = Conn.prepareStatement(query);
					pstmtprac.setString(1, l_physician_id);
					rspract = pstmtprac.executeQuery();

					while(rspract.next())
					{
						l_hpc_nbr = rspract.getString("CREDENTIAL_ID1")==null?"":rspract.getString("CREDENTIAL_ID1");						
					}

					try {
							if (rspract != null) {
								rspract.close();
								l_app_msg = "Closing rspract";
								//if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
							}

							if(pstmtprac != null) pstmtprac.close();		
						}
						catch(Exception exp) {
							exp.printStackTrace();
							l_app_msg = " Error in closing rspract"+exp.getMessage();
							//System.out.println(l_app_msg);	
						}

				}

				l_app_msg = "After Physician Id"+l_physician_id;
				//if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			
				l_item_strbfr.append("<ADD_BHF prov_cat=\""+l_prov_cat+"\" prov_st=\""+l_prov_st+"\" hpc_nbr=\""+l_hpc_nbr+"\" tp_ind=\""+l_tp_ind+"\"/>");
				l_item_strbfr.append("<FIN net=\""+l_ins_net_amt+"\" fee_tp=\""+l_fee_tp+"\" disp_fee=\""+l_disp_fee+"\" copay=\""+l_upd_net_copay_amt+"\" sub_disc=\""+l_upd_disc_amt+"\" gross=\""+l_upd_gross_charge_amt+"\" tar_ind=\""+l_tar_ind+"\"/>");
				l_item_strbfr.append("</ITEM>");
				l_item_strbfr.append("\n");

				l_app_msg = "Inside CreateItemMessage Line Num"+l_line_num+""+l_item_strbfr.toString();
				//if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
				
			}

			l_item_no = String.valueOf(l_line_count);

			l_item_xml = l_item_strbfr.toString();

			l_app_msg = "Inside CreateItemMessage Item Xml"+l_item_xml;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

	
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Error in retrieving Item Details..."+e.getMessage());
			return "Error in retrieving Item Details" +"$!^"+e.getMessage();
		}
		finally
		{			
			closeDBResources(rs, pstmt, Conn);			
		}		

		return l_item_xml;
	}

	public String CreateDiagnosisMessage(String request, String actionKey, Map params, String strDiagFlag, String admDisFlag){

		Connection Conn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;

		String query = "";
		String l_app_msg = "";

		String l_facility_id = "", l_patient_id = "", l_encounter_id = "", l_episode_type = "";

		String l_term_code = "", l_primary_yn = "";
		String l_stg_cd = "";
		boolean l_prim_flag = false;

		String l_diagnosis_xml = "";

		StringBuffer l_diagnosis_strbfr = new StringBuffer();

		l_app_msg = "Inside CreateDiagnosisMessage";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		try
		{

			l_facility_id = params.get("FACILITY_ID").toString();			
			l_app_msg = "Facility Id... "+l_facility_id;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_patient_id = params.get("PATIENT_ID").toString();			
			l_app_msg = "Patient Id... "+l_patient_id;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_encounter_id = params.get("ENCOUNTER_ID").toString();			
			l_app_msg = "Encounter Id... "+l_encounter_id;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			//ADDED FOR LMP5038-SCF-0254 BY Bhuvaneshwari on 05/02/2019

			l_episode_type = params.get("EPISODE_TYPE").toString();			
			l_app_msg = " LMP5038-SCF-0254  l_episode_type... "+l_episode_type;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			Conn =  ConnectionManager.getConnection();
	 	   query = "select TERM_CODE, B.DIAG_CLASS_TYPE  from PR_DIAGNOSIS_ENC_DTL a, MR_DIAG_CLASS b where A.DIAG_CLASS_CODE = B.DIAG_CLASS_CODE and patient_id = ? and encounter_id = ?  and STATUS not in ('E') ";	

			//Conditioned added for Primary Diagnosis Issue faced.

			//ADDED FOR LMP5038-SCF-0254 BY Bhuvaneshwari on 05/02/2019
			if(l_episode_type.equals("I") || l_episode_type.equals("D"))
			{
				if (admDisFlag.equals("A") || admDisFlag.equals("D"))
					query = query + " and ip_diag_stage = ? ";
			}
		

			pstmt = Conn.prepareStatement(query);
			pstmt.setString(1, l_patient_id);
			pstmt.setString(2, l_encounter_id);

			//ADDED FOR LMP5038-SCF-0254 BY Bhuvaneshwari on 05/02/2019
			if(l_episode_type.equals("I") || l_episode_type.equals("D"))
			{
				if (admDisFlag.equals("A") || admDisFlag.equals("D"))
					pstmt.setString(3, admDisFlag);
			}

			rs = pstmt.executeQuery();
			while(rs.next())
			{
				l_term_code = rs.getString("TERM_CODE")==null?"XYZ":rs.getString("TERM_CODE");
				l_primary_yn = rs.getString("DIAG_CLASS_TYPE");
				
				if(request.equals("CLA"))
				{
					if (l_primary_yn.equals("PD") && !(l_prim_flag))
					{
						l_prim_flag = true;
						l_stg_cd = "01";
					}
					else
						l_stg_cd = "02";
				}
				if(request.equals("CLE")||request.equals("EOC"))
				{
					if (l_primary_yn.equals("PD") && !(l_prim_flag))
					{
						l_prim_flag = true;
						l_stg_cd = "04";
					}
					else
						l_stg_cd = "05";
				}		
				
				if (strDiagFlag.equals("DIAG"))
				{
					l_diagnosis_strbfr.append("<DIAG cd=\""+l_term_code+"\" stg_ind=\""+l_stg_cd+"\"/>");
					l_diagnosis_strbfr.append("\n");		 
				}

				if (strDiagFlag.equals("SEC"))
				{
					if (!(l_primary_yn.equals("PD")))
					{
						l_diagnosis_strbfr.append("<SECDIAG sec_diag =\""+l_term_code+"\" />");
						l_diagnosis_strbfr.append("\n");
					}
				}

			     
			}

			l_diagnosis_xml = l_diagnosis_strbfr.toString();
	
		}
		catch(Exception e)
		{
			System.out.println("Error in retrieving Diagnosis Details..."+e.getMessage());
			return "Error in retrieving Diagnosis Details" +"$!^"+e.getMessage();
		}
		finally
		{			
			closeDBResources(rs, pstmt, Conn);			
		}		

		return l_diagnosis_xml;
	}

	public String CreateHospMessage(String request, String actionKey, Map params){

		Connection Conn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;

		String query = "";
		String l_app_msg = "", l_element_id = "";

		String l_fac_level = "", l_tran_tp = "", l_seq_no = "", l_auth_nbr = "", l_acc_tp = "", l_bill_tp = "", l_los = "1.00";
		String l_adm_dt = "", l_adm_tm = "", l_adm_ind = "", l_prm_diag = "", l_adm_diag = "", l_dis_diag = "";
		String l_dis_dt = "", l_dis_tm = "", l_dis_ind = "", l_eoc_ind = "";
		String l_ip_stg = "", l_primary_yn = "";
		String l_case_no = "", l_case_nbr = "", l_claim_type = "";

		String l_hosp_xml = "";

		String l_patient_id = "", l_encounter_id = "", l_facility_id = "", l_episode_id = "", l_patientid_no = "", l_deceased_date = "", l_episode_type = "";
		double l_net_amt = 0.00;

		String l_doc_type_code ="", l_doc_no_str = "";

		StringBuffer l_hosp_strbfr = new StringBuffer();
		String l_diag_xml_msg = "";

		String l_wca_num = ""; //Added by bhuvana for LMP-SCF-0263 on 18/07/2019

		l_app_msg = "Inside CreateHospMessage ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		try
		{

			//Added by bhuvana for LMP-SCF-0263 on 18/07/2019

			l_wca_num = params.get("WCA_NUM").toString();			
			l_app_msg = "WCA Number... "+l_wca_num;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			if(l_wca_num.equals("XXX"))
			{
				l_wca_num = "";
			}

			//Code ended for LMP-SCF-0263 on 18/07/2019

			l_hosp_strbfr.append("<HOSP fac_level=\"#faclevel\" tran_tp=\"#trantp\" los=\"#los\">");
			if (request.equals("EOC"))
				l_hosp_strbfr.append("<CASE nbr=\"#reftransno\" auth_nbr=\""+l_wca_num+"\" acc_tp=\"#acctp\" bill_tp=\"#billtp\"/>");
			else if (request.equals("REV"))
				l_hosp_strbfr.append("<CASE nbr=\"#reftransno\" auth_nbr=\""+l_wca_num+"\" acc_tp=\"#acctp\" bill_tp=\"#billtp\"/>");
			else
				l_hosp_strbfr.append("<CASE nbr=\"#caseNo\" auth_nbr=\""+l_wca_num+"\" acc_tp=\"#acctp\" bill_tp=\"#billtp\"/>");

			l_hosp_strbfr.append("<ADMISS dt=\"#admdt\" tm=\"#admtm\" ind=\"#admind\" prm_diag=\"#admdiagcd\">");
			
			l_diag_xml_msg = CreateDiagnosisMessage(request, actionKey, params, "SEC", "A");
			l_app_msg = "Diag Xml Message 1"+ l_diag_xml_msg;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			if (l_errcd.equals("S"))
			{
				l_hosp_strbfr.append(l_diag_xml_msg);
			}
			
			l_hosp_strbfr.append("</ADMISS>");
			
			if(request.equals("EOC") || request.equals("CLE")){
				l_hosp_strbfr.append("<EOC>");
				l_hosp_strbfr.append("<DISCH dt=\"#disdt\" tm=\"#distm\" ind=\"#disind\" prm_diag=\"#disdiagcd\" eoc_ind=\"#eocind\">");

				l_diag_xml_msg = CreateDiagnosisMessage(request, actionKey, params, "SEC", "D");
				l_app_msg = "Diag Xml Message 2"+ l_diag_xml_msg;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				
				if (l_errcd.equals("S"))
				{
					l_hosp_strbfr.append(l_diag_xml_msg);
				}
				
				l_hosp_strbfr.append("</DISCH>");
				l_hosp_strbfr.append("<FINCASE val=\"#totamt\"/>");
			    l_hosp_strbfr.append("</EOC>");
			}


			l_hosp_strbfr.append("</HOSP>");

			l_facility_id = params.get("FACILITY_ID").toString();			
			l_app_msg = "Facility Id... "+l_facility_id;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_patient_id = params.get("PATIENT_ID").toString();			
			l_app_msg = "Patient Id... "+l_patient_id;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_encounter_id = params.get("ENCOUNTER_ID").toString();			
			l_app_msg = "Encounter Id... "+l_encounter_id;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			//ADDED FOR LMP5038-SCF-0254 BY Bhuvaneshwari on 05/02/2019

			l_episode_type = params.get("EPISODE_TYPE").toString();			
			l_app_msg = "Episode Type... "+l_episode_type;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);


			l_episode_id = params.get("EPISODE_ID").toString();			
			l_app_msg = "Episode Id... "+l_episode_id;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_seq_no = params.get("MSG_ID").toString();			
			l_app_msg = "Sequence Number... "+l_seq_no;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_auth_nbr = params.get("AUTHORIZATION_NUM").toString();			
			l_app_msg = "Auth Number... "+l_auth_nbr;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_case_no = params.get("CASE_NUM").toString();			
			l_app_msg = "Case Number... "+l_case_no;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_patientid_no = params.get("PATIENT_ID_NUM").toString();			
			l_app_msg = "PatientId Number... "+l_patientid_no;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_doc_type_code = params.get("BILL_DOC_TYPE_CODE").toString();
			l_app_msg = "Documnet Type Code... "+ l_doc_type_code;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_doc_no_str = params.get("BILL_DOC_NO").toString();
			l_app_msg = "Document Number Str... "+ l_doc_no_str;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_claim_type = params.get("CLAIM_TYPE").toString();
			l_app_msg = "Claim Type... "+ l_claim_type;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_case_nbr = "CL" + l_doc_type_code+""+l_doc_no_str;

			l_app_msg = "Retreiving FAC LEVEL...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_element_id = "FAC_LEVEL";

			l_fac_level = FetchStdCntrlSeg("ECL", l_element_id, l_standard_code);
			if (l_fac_level.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_fac_level;
			}
			l_app_msg = "Fac Level... "+l_fac_level;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			l_app_msg = "Retrieving TRAN TP...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			/*
			l_element_id = "TRAN_TP";

			l_tran_tp = FetchStdCntrlSeg("ECL", l_element_id, l_standard_code);
			if (l_tran_tp.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_tran_tp;
			}
			l_app_msg = "Tran Tp... "+l_tran_tp;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			*/

			l_app_msg = "Retrieving ACC TP...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_element_id = "ACC_TP";

			l_acc_tp = FetchStdCntrlSeg("ECL", l_element_id, l_standard_code);
			if (l_acc_tp.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_acc_tp;
			}
			l_app_msg = "Acc Tp... "+l_acc_tp;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_app_msg = "Retrieving BILL TP...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_element_id = "BILL_TP";

			l_bill_tp = FetchStdCntrlSeg("ECL", l_element_id, l_standard_code);
			if (l_bill_tp.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_bill_tp;
			}
			l_app_msg = "Bill Tp... "+l_bill_tp;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_app_msg = "Retrieving ADM IND...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_element_id = "ADM_IND";

			l_adm_ind = FetchStdCntrlSeg("ECL", l_element_id, l_standard_code);
			if (l_adm_ind.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_adm_ind;
			}
			l_app_msg = "Adm Ind... "+l_adm_ind;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_app_msg = "Retrieving DIS IND...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_element_id = "DIS_IND";

			l_dis_ind = FetchStdCntrlSeg("ECL", l_element_id, l_standard_code);
			if (l_dis_ind.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_dis_ind;
			}
			l_app_msg = "Dis Ind... "+l_dis_ind;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_app_msg = "Retrieving EOC IND...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			//l_element_id = "EOC_IND";

			/*l_eoc_ind = FetchStdCntrlSeg("ECL", l_element_id, l_standard_code);
			if (l_eoc_ind.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_eoc_ind;
			}*/

			if(request.equals("CLA"))l_eoc_ind = "N";
            if(request.equals("CLE"))l_eoc_ind = "Y";
			if(request.equals("EOC"))l_eoc_ind = "N";

			l_app_msg = "EOC Ind... "+l_eoc_ind;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_hosp_xml = l_hosp_strbfr.toString();

			l_hosp_xml = l_hosp_xml.replaceAll("#faclevel", l_fac_level);
			l_hosp_xml = l_hosp_xml.replaceAll("#trantp", l_claim_type);
			l_hosp_xml = l_hosp_xml.replaceAll("#caseNo", l_case_nbr.toUpperCase());
			l_hosp_xml = l_hosp_xml.replaceAll("#authnbr",l_auth_nbr);
			l_hosp_xml = l_hosp_xml.replaceAll("#acctp", l_acc_tp);
			l_hosp_xml = l_hosp_xml.replaceAll("#billtp", l_bill_tp);
			
			l_hosp_xml = l_hosp_xml.replaceAll("#admind", l_adm_ind);
			//l_hosp_xml = l_hosp_xml.replaceAll("#disind", l_dis_ind);
			l_hosp_xml = l_hosp_xml.replaceAll("#eocind", l_eoc_ind);
			l_hosp_xml = l_hosp_xml.replaceAll("#reftransno", l_case_no);				

			Conn =  ConnectionManager.getConnection();

			l_app_msg = " Fetching admission and discharge date and time... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			/*

			query = "SELECT TO_CHAR (visit_adm_date_time, 'yyyymmdd') visit_adm_date, TO_CHAR (visit_adm_date_time, 'hh24miss') visit_adm_time, "
						+" TO_CHAR (nvl(discharge_date_time,visit_adm_date_time), 'yyyymmdd') disch_date, TO_CHAR (nvl(discharge_date_time,to_date(visit_adm_date_time ||' 23:59','dd/mm/yyyy hh24:mi:ss')), 'hh24miss') disch_time, DECEASED_DATE_TIME, "
						+" to_char(decode(PATIENT_CLASS,'OP', 1, 'IP', (to_date(nvl(discharge_date_time, nvl(DECEASED_DATE_TIME,sysdate)),'dd/mm/yyyy') - TO_DATE (visit_adm_date_time, 'dd/mm/yyyy') ), 1),99999.99) LOS "
						+" FROM pr_encounter "
						+" WHERE facility_id = ? AND encounter_id = ? AND patient_id = ?";

			*/

			query = "SELECT TO_CHAR (visit_adm_date_time, 'yyyymmdd') visit_adm_date, TO_CHAR (visit_adm_date_time, 'hh24miss') visit_adm_time, "
						+" TO_CHAR (decode(PATIENT_CLASS, 'OP', nvl(discharge_date_time,visit_adm_date_time), 'EM', nvl(discharge_date_time,visit_adm_date_time), discharge_date_time), 'yyyymmdd') disch_date, "
						+" TO_CHAR (decode(PATIENT_CLASS,'OP',nvl(discharge_date_time,to_date(visit_adm_date_time ||' 23:59','dd/mm/yyyy hh24:mi:ss')), 'EM',nvl(discharge_date_time,to_date(visit_adm_date_time ||' 23:59','dd/mm/yyyy hh24:mi:ss')), discharge_date_time), 'hh24miss') disch_time, "
						+" DECEASED_DATE_TIME, "
						+" to_char(decode(PATIENT_CLASS,'OP', 1, 'IP', (to_date(nvl(discharge_date_time, nvl(DECEASED_DATE_TIME,sysdate)),'dd/mm/yyyy') - TO_DATE (visit_adm_date_time, 'dd/mm/yyyy') ), 1),99999.99) LOS "
						+" FROM pr_encounter "
						+" WHERE facility_id = ? AND encounter_id = ? AND patient_id = ?";

			pstmt = Conn.prepareStatement(query);
			pstmt.setString(1, l_facility_id);
			pstmt.setString(2, l_encounter_id);
			pstmt.setString(3, l_patient_id);
			
			rs = pstmt.executeQuery();

			System.out.println("query is 0"+query);

			while(rs.next())
			{
				l_adm_dt = rs.getString("VISIT_ADM_DATE")==null?"":rs.getString("VISIT_ADM_DATE");
				l_adm_tm = rs.getString("VISIT_ADM_TIME")==null?"":rs.getString("VISIT_ADM_TIME");
				l_dis_dt = rs.getString("DISCH_DATE")==null?"":rs.getString("DISCH_DATE");
				l_dis_tm = rs.getString("DISCH_TIME")==null?"":rs.getString("DISCH_TIME");
				l_deceased_date = rs.getString("DECEASED_DATE_TIME")==null?"":rs.getString("DECEASED_DATE_TIME");
				l_los = rs.getString("LOS")==null?"1.00":rs.getString("LOS");
				System.out.println("query is rs"+query);

			}

			if (!(Double.parseDouble(l_los)>0))
			{
				l_los = "1.00";
				System.out.println("query is l_los");
			}

			l_hosp_xml = l_hosp_xml.replaceAll("#los", l_los);
			l_hosp_xml = l_hosp_xml.replaceAll("#admdt", l_adm_dt);
			l_hosp_xml = l_hosp_xml.replaceAll("#admtm", l_adm_tm);

			if(request.equals("CLA")){
				l_hosp_xml = l_hosp_xml.replaceAll("#disdt", "");
				l_hosp_xml = l_hosp_xml.replaceAll("#distm", "");
				l_hosp_xml = l_hosp_xml.replaceAll("#disind", "");
				System.out.println("query is l_hosp_xml"+l_hosp_xml);
			}
			else
			{
				/*
				if (!(l_dis_dt.length() > 0))
				{
					l_dis_dt = l_adm_dt;
				}
				if (!(l_dis_tm.length() > 0))
				{
					l_dis_tm = "235900";
				}
				*/

				l_hosp_xml = l_hosp_xml.replaceAll("#disdt", l_dis_dt);
				l_hosp_xml = l_hosp_xml.replaceAll("#distm", l_dis_tm);
				if (l_deceased_date.length() > 0)
					l_hosp_xml = l_hosp_xml.replaceAll("#disind", "05");
				else
					l_hosp_xml = l_hosp_xml.replaceAll("#disind", l_dis_ind);
			}
			

			l_app_msg = " Fetching diagnosis codes... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			pstmt = null;
			rs = null;
			query = "select TERM_CODE, B.DIAG_CLASS_TYPE, nvl(a.ENC_STAGE,'') ENC_STAGE  from PR_DIAGNOSIS_ENC_DTL a, MR_DIAG_CLASS b " +
					"where A.DIAG_CLASS_CODE = B.DIAG_CLASS_CODE and patient_id = ? and encounter_id = ? and STATUS not in ('E') ";	

			//Conditioned added for Primary Diagnosis Issue faced.
			System.out.println("query is "+query);
			pstmt = Conn.prepareStatement(query);
			
			pstmt.setString(1, l_patient_id);
			pstmt.setString(2, l_encounter_id);

			l_app_msg = " Fetching diagnosis codes l_facility_id"+l_facility_id+""+l_encounter_id+""+l_patient_id;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			rs = pstmt.executeQuery();

			while(rs.next())
			{
				
				l_prm_diag = rs.getString("TERM_CODE")==null?"":rs.getString("TERM_CODE");
				l_primary_yn = rs.getString("DIAG_CLASS_TYPE")==null?"":rs.getString("DIAG_CLASS_TYPE");
				l_ip_stg = rs.getString("ENC_STAGE")==null?"":rs.getString("ENC_STAGE");

				l_app_msg = " Diagnosis data Priamry Diag"+l_prm_diag+""+l_primary_yn+""+l_ip_stg;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				if (l_ip_stg.equals("A") && l_primary_yn.equals("PD"))
				{
					l_adm_diag = l_prm_diag;
				}
				if (l_ip_stg.equals("D") && l_primary_yn.equals("PD"))
				{
					l_dis_diag = l_prm_diag;
				}
				if (l_ip_stg.equals("") && l_primary_yn.equals("PD"))
				{
					l_adm_diag = l_prm_diag;
					l_dis_diag = l_prm_diag;
				}
				
				if ((l_dis_diag.length()>0) && (!(l_adm_diag.length()>0)))
				{
					l_adm_diag = l_dis_diag;
				}
			}

			l_app_msg = " Diagnosis data Adm Diag "+l_adm_diag+"l_dis_diag"+l_dis_diag;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_hosp_xml = l_hosp_xml.replaceAll("#admdiagcd", StringEscapeUtils.escapeXml(l_adm_diag.toUpperCase()));

			if(request.equals("CLA"))
				l_hosp_xml = l_hosp_xml.replaceAll("#disdiagcd", "");
			else
				l_hosp_xml = l_hosp_xml.replaceAll("#disdiagcd", StringEscapeUtils.escapeXml(l_dis_diag.toUpperCase()));			

			if(request.equals("EOC")){

				l_app_msg = " Fetching Net amount... ";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				pstmt = null;
				rs = null;

				query = "select APPR_GROSS_AMOUNT NET_AMT from XF_ECLAIMS_TRX_HDR "
							+" where EVENT_TYPE   ='CLA' and APPROVAL_STATUS = 'P' and FACILITY_ID = ? and PATIENT_ID = ? and EPISODE_ID = ? and DOC_TYPE_CODE = ? and DOC_NUM = ? ";

				pstmt = Conn.prepareStatement(query);
				pstmt.setString(1, l_facility_id);
				pstmt.setString(2, l_patient_id);
				pstmt.setString(3, l_episode_id);
				pstmt.setString(4, l_doc_type_code);
				pstmt.setInt(5, Integer.parseInt(l_doc_no_str));

				rs = pstmt.executeQuery();

				while(rs.next())
				{
					l_net_amt = rs.getDouble("NET_AMT");
				}

				l_hosp_xml = l_hosp_xml.replaceAll("#totamt", String.valueOf(l_net_amt));
			
			}
			else{

				l_app_msg = " Fetching Net amount... ";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				pstmt = null;
				rs = null;

				query = "select sum(upd_net_charge_amt) net_amt from bl_patient_charges_folio "
							+" where operating_facility_id = ? and patient_id = ? and episode_id = ? and bill_doc_type_code = ? and bill_doc_num = ? ";

				pstmt = Conn.prepareStatement(query);
				pstmt.setString(1, l_facility_id);
				pstmt.setString(2, l_patient_id);
				pstmt.setString(3, l_episode_id);
				pstmt.setString(4, l_doc_type_code);
				pstmt.setInt(5, Integer.parseInt(l_doc_no_str));

				rs = pstmt.executeQuery();

				while(rs.next())
				{
					l_net_amt = rs.getDouble("NET_AMT");
				}

				l_hosp_xml = l_hosp_xml.replaceAll("#totamt", String.valueOf(l_net_amt));	
			
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Error in retrieving Hospital details Details..."+e.getMessage());
			return "Error in retrieving Item Details" +"$!^"+e.getMessage();
		}
		finally
		{			
			closeDBResources(rs, pstmt, Conn);			
		}		

		return l_hosp_xml;
	}
    public String CreateDocterHPCMessage(String request, String actionKey, Map params){
		String l_app_msg = "";
		String l_prescribe_admit_doctor_query = "",l_refer_doctor_query = "";
		String l_patient_id = "",l_encounter_id = "",l_hpc_str = "";
		String l_prescribe_doctor = "",l_admit_doctor = "",l_reffer_doctor = "";

		Connection Conn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;

		
     	try
		{

			l_hpc_str = "<BHF> <HPC	prescr = \"#preDoctor\" refer = \"#refferDoctor\" admit = \"#admitDoctor\"/></BHF>";

			
			l_patient_id = params.get("PATIENT_ID").toString();			
			l_app_msg = "Patient Id... "+l_patient_id;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_encounter_id = params.get("ENCOUNTER_ID").toString();			
			l_app_msg = "Encounter Id... "+l_encounter_id;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			Conn =  ConnectionManager.getConnection();

			l_app_msg = " Fetching prescribing and admitting doctor details... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_prescribe_admit_doctor_query = "select DISP_AUTH_PRACTITIONER_ID,ADMIT_PRACTITIONER_ID  from pr_encounter "
			                              + " where patient_id = ? and encounter_id = ? "; 
			pstmt = Conn.prepareStatement(l_prescribe_admit_doctor_query);
			pstmt.setString(1, l_patient_id);
			pstmt.setString(2, l_encounter_id);
			
			rs = pstmt.executeQuery();

			while(rs.next())
			{
				l_prescribe_doctor = rs.getString("DISP_AUTH_PRACTITIONER_ID")==null?"":rs.getString("DISP_AUTH_PRACTITIONER_ID");
				l_admit_doctor = rs.getString("ADMIT_PRACTITIONER_ID")==null?"":rs.getString("ADMIT_PRACTITIONER_ID");
			}
            l_app_msg = "Prescribe Doctor... "+l_prescribe_doctor;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_app_msg = "Admit Doctor... "+l_admit_doctor;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			

			l_app_msg = " Fetching reffering doctor... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			pstmt = null;
			rs = null;

			l_refer_doctor_query = "Select FROM_PRACT_ID from PR_REFERRAL_REGISTER where REFERRAL_ID in "
			                       +"(select REFERRAL_ID  from pr_encounter where patient_id = ? and encounter_id = ?)";


			pstmt = Conn.prepareStatement(l_refer_doctor_query);
			pstmt.setString(1, l_patient_id);
			pstmt.setString(2, l_encounter_id);

			rs = pstmt.executeQuery();

			while(rs.next())
			{
				l_reffer_doctor = rs.getString("FROM_PRACT_ID")==null?"":rs.getString("FROM_PRACT_ID");
			}
            
            l_app_msg = "Reffer Doctor... "+l_reffer_doctor;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_hpc_str = l_hpc_str.replaceAll("#preDoctor", StringEscapeUtils.escapeXml(getCredential1(l_prescribe_doctor).toUpperCase()));
			l_hpc_str = l_hpc_str.replaceAll("#refferDoctor", StringEscapeUtils.escapeXml(getCredential1(l_reffer_doctor).toUpperCase()));
			l_hpc_str = l_hpc_str.replaceAll("#admitDoctor", StringEscapeUtils.escapeXml(getCredential1(l_admit_doctor).toUpperCase()));
		}
		catch(Exception e)
		{
			System.out.println("Error in retrieving  hpc Details..."+e.getMessage());
			return "Error in retrieving hpc Details" +"$!^"+e.getMessage();
		}
		finally
		{			
			closeDBResources(rs, pstmt, Conn);			
		}	
        return l_hpc_str;
	}

	public String getCredential1(String practitioner_id){
       	String l_app_msg = "";

	    Connection Conn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;

		String l_credential = "",l_credential_query = "";
		
     	try
		{
			Conn =  ConnectionManager.getConnection();

			l_app_msg = " Fetching credential 1 details... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_app_msg = "Practitioner Id... "+practitioner_id;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_credential_query = "Select CREDENTIAL_ID1 from AM_PRACTITIONER "
			                              + " where  PRACTITIONER_ID  = ? "; 
			pstmt = Conn.prepareStatement(l_credential_query);
			pstmt.setString(1, practitioner_id);

			l_app_msg = "Credential Query ... "+l_credential_query;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			rs = pstmt.executeQuery();

			while(rs.next())
			{
				l_credential = rs.getString("CREDENTIAL_ID1")==null?"":rs.getString("CREDENTIAL_ID1");
			}
            l_app_msg = "Credential... "+l_credential;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);			

		}
		catch(Exception e)
		{
			System.out.println("Error in retrieving  details Details..."+e.getMessage());
			return "Error in retrieving Credential1 Details" +"$!^"+e.getMessage();
		}
		finally
		{			
			closeDBResources(rs, pstmt, Conn);			
		}	
        return l_credential;

	}

	public String CreateFileName(String requestType, String seqNo, String caseNbr,String l_facility_id)
	{
		String l_app_msg = "";
		String l_element_id = "", l_segment_id = "ELC", l_standard_code = "ECLASTD";

		String l_file_name = "", l_file_prefix = "", l_hospital_no = "";

		String l_query = "";

		l_app_msg = "Inside CreateFileName";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = "Request Type... "+requestType+" Seq No... "+seqNo;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		/*l_element_id = "HOSPITAL_NO";

		l_hospital_no = FetchStdCntrlSeg(l_segment_id, l_element_id, l_standard_code);
		if (l_hospital_no.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_hospital_no;

			return "Error" + "$!^"+ "Error in fetching hospital no" + "$!^"+ l_app_msg + "$!^" + l_errmsg; 
		}
		l_app_msg = "Hospital Number... "+l_hospital_no;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	*/

		l_app_msg = "Retrieving Hospital No...";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		//l_element_id = "HOSPITAL_NO";

		l_hospital_no = XHUtil.getHospitalNo(l_facility_id);
		if (l_hospital_no.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_hospital_no;

			return l_app_msg + "$!^" + l_errmsg;
		}	
		l_app_msg = "Hospital Number... "+l_hospital_no;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

		l_app_msg = "Retrieving Request File Prefix...";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

		l_element_id = requestType+"_FILE";

		l_file_prefix = FetchStdCntrlSeg("ECL", l_element_id, l_standard_code);
		if (l_hospital_no.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_file_prefix;

			return l_app_msg + "$!^" + l_errmsg; 
		}
		l_app_msg = "l_file_prefix... "+l_file_prefix;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		/*if (requestType.equals("ECLREQ"))
		{
			l_file_prefix = "RealtimeReq";
		}
		if (requestType.equals("ECLREP"))
		{
			l_file_prefix = "RealtimeReply";
		}
		if (requestType.equals("ECLREJ"))
		{
			l_file_prefix = "RealtimeRej";
		}
		if (requestType.equals("ECLFAI"))
		{
			l_file_prefix = "RealtimeFail";
		}
	   */

		l_file_name = l_file_prefix + "." + l_hospital_no + caseNbr + seqNo;

		l_app_msg = "File Name... "+l_file_name;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);		

		return l_file_name;

	}

	public String WriteFile(String fileName, String filePath, String message)
	{
		String l_app_msg = "";

		String l_file_name = "";

		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;

		l_app_msg = "Inside WriteFile... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		try {

				File dir = new File(filePath);
 
				if (!dir.exists()) {
					dir.mkdir();
				}

				l_file_name = filePath+File.separator+fileName+".xml";

				l_app_msg = "File Name... "+l_file_name;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				fileWriter = new FileWriter(l_file_name);
				bufferedWriter = new BufferedWriter(fileWriter);
				bufferedWriter.write(message);
				bufferedWriter.close();
			}
			catch(IOException ex) {
				return "Error in writing file..." + l_file_name + "$!^" + ex.getMessage(); 
			}		

		return "S";

	}

	public String ReadFile(String fileName, String filePath)
	{
		String l_app_msg = "", l_xml_msg = ""; String line = null;

		String l_file_name = "";

		FileReader fileReader = null;
		BufferedReader bufferedReader = null;

		l_app_msg = "Inside ReadFile";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		try {

				l_file_name = filePath+"/"+fileName+".xml";

				fileReader = new FileReader(fileName);

				bufferedReader = new BufferedReader(fileReader);

				while((line = bufferedReader.readLine()) != null) {
					l_xml_msg = l_xml_msg + line;
				}   

				// Always close files.
				bufferedReader.close();  
				
				l_app_msg = "Xml Message... "+l_xml_msg;
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

	public String FetchResponseMessage(String directoryName, String fileName, int seconds,String l_request_type)
	{		
		String l_response_msg = "";
		String l_app_msg = "", l_file_name = "";
		String search  = "Processed";

		try{

			l_app_msg = "Inside FetchResponseMessage";
	        if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_file_name = fileName +".xml";

			l_app_msg = "directoryName... "+ directoryName +"fileName... "+l_file_name + "seconds... " + seconds;
	        if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			File folder = new File(directoryName);
			
			File[] listOfFiles = folder.listFiles();

			l_app_msg = "List of Files array Length: "+listOfFiles.length ;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			stopRequested = false;

			for (int i = 0; i < listOfFiles.length; i++) 
			{
				if (listOfFiles[i].isFile()) 
				{
					if (l_debug_YN.equals("Y"))  System.out.println(listOfFiles[i].getName());
					if ((listOfFiles[i].getName().toLowerCase()).equals(l_file_name.toLowerCase())) 
					{
						String filename = directoryName+ File.separator +listOfFiles[i].getName();	
						if (l_debug_YN.equals("Y")) System.out.println(""+filename);

						l_response_msg = XHUtil.readFile(filename);
						
						l_app_msg = "FetchResponseMessageread success...: "+l_response_msg ;
						if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
						if(directoryName.toLowerCase().indexOf(search.toLowerCase()) == -1){
							doMove(directoryName,listOfFiles[i].getName());
						}
						stopRequested = true;
						
						break;
					}
				}
			}	
			l_app_msg = "Stop Requested: "+stopRequested ;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			if (!(stopRequested))
			{
				l_response_msg = "FILE_NOT_FOUND";
			}
	           
		}
		catch(Exception e)
		{
			return "Error in " + l_app_msg + " " +l_file_name + "$!^" + e.getMessage(); 
		}

		return l_response_msg;
	}

	public static void readStop() {
		stopRequested = true;
	}

	private  void doMove(String directory,String fileName) {
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

	public String FetchFieldValue(String message, String identifier, String standardCode, String fieldSep, String procID){

		String l_app_msg = "", l_field_value = "";

		l_app_msg = "Inside FetchFieldValue";
		//if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = "Message... "+ message + "Identifier... " + identifier + "Standard Code... "+ standardCode;
		//if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		
		l_app_msg = "Deriving Field Value..."+identifier;
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
			l_field_value = "Error in "+ l_app_msg + "... " +  e.getMessage();
		}		

		l_app_msg = "Field Value"+l_field_value;
		//if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

		return l_field_value;
	}	

	private String clobToString(java.sql.Clob data)
	{
		final StringBuffer sb = new StringBuffer();

		try
		{
			final Reader         reader = data.getCharacterStream();
			final BufferedReader br     = new BufferedReader(reader);

			int b;
			while(-1 != (b = br.read()))
			{
				sb.append((char)b);
			}

			br.close();
		}
		catch (SQLException e)
		{
			System.out.println("SQL. Could not convert CLOB to string"+e.toString());
			return e.toString();
		}
		catch (IOException e)
		{
			System.out.println("IO. Could not convert CLOB to string"+e.toString());
			return e.toString();
		}

		return sb.toString();
	}

	
	public String FetchStdCntrlSeg(String segmentID, String elementId, String standardCode){

		Connection Conn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;

		String query = "";
		String l_app_msg = "", l_field_value = "";

		l_app_msg = "Inside FetchStdCntrlSeg";
		//if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = "Segment ID... "+ segmentID + "Element ID... " + elementId + "Standard Code... "+ standardCode;
		//if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		
		l_app_msg = "Retrieving "+ elementId + " Value...";
		//if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		try
		{
			Conn =  ConnectionManager.getConnection();
			query = "SELECT NVL(DEFAULT_VALUE,'') DEFAULT_VALUE FROM XH_STANDARD_CONTROL_SEG " 
						+ " WHERE SEGMENT_ID = ? "
						+ " AND STANDARD_CODE = ? "
						+ " AND ELEMENT_ID = ? ";

			pstmt = Conn.prepareStatement(query);
			pstmt.setString(1, segmentID);
			pstmt.setString(2, standardCode);
			pstmt.setString(3, elementId);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
			   l_field_value = rs.getString("DEFAULT_VALUE")==null?"":rs.getString("DEFAULT_VALUE").toString();
			}
			
		}
		catch(Exception e)
		{
			l_field_value = "Error in "+ l_app_msg + "... " +  e.getMessage();
		}
		finally
		{			
			closeDBResources(rs, pstmt, Conn);			
		}		

		return l_field_value;
	}

	public String FetchResponseWaitTime(String pluginType){

		Connection Conn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;

		String query = "";
		String l_app_msg = "", l_field_value = "";

		int l_wait_time = 0;

		l_app_msg = "Inside FetchResponseWaitTime";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = "Plugin Type... "+ pluginType;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		
		try
		{
			Conn =  ConnectionManager.getConnection();
			query = "SELECT NVL(COMM_PROCESS_IDLE_TIME, 0) COMM_PROCESS_IDLE_TIME FROM XH_INTERACTIVE_CONNECT_PARAM " 
						+ " WHERE PLUGIN_TYPE = ? ";

			pstmt = Conn.prepareStatement(query);
			pstmt.setString(1, pluginType);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
			   l_wait_time = rs.getInt("COMM_PROCESS_IDLE_TIME");
			}

			l_field_value = String.valueOf(l_wait_time);
			System.out.println("FetchResponseWaitTime "+l_field_value);
		}
			
		
		catch(Exception e)
		{
			l_field_value = "Error in "+ l_app_msg + "... " +  e.getMessage();
			System.out.println("Exception is FetchResponseWaitTime "+l_field_value);
		}
		finally
		{			
			closeDBResources(rs, pstmt, Conn);			
		}		

		return l_field_value;
	}
	
	public String GenerateTransIDMethod(String SeqenceName){

		Connection Conn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;

		String query = "";
		String l_app_msg = "", l_field_value = "";

		int l_trans_id = 0;

		l_app_msg = "Inside GenerateTransIDMethod";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);			
		
		try
		{
			Conn =  ConnectionManager.getConnection();
			query = "select "+SeqenceName+".NEXTVAL TRANSID FROM DUAL " ;

			pstmt = Conn.prepareStatement(query);
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
			l_field_value = "Error in "+ l_app_msg + "... " +  e.getMessage();
		}
		finally
		{			
			closeDBResources(rs, pstmt, Conn);			
		}		

		return l_field_value;
	}

	public String GetResponseMessage(String l_request, String l_trans_value, String l_request_event_type, String l_case_nbr,String l_facility_id)
	{
		
		String l_app_msg = "";
		String l_wait_time_str = "", l_file_name = "", l_response_msg = "", l_request_type = "", l_file_directory = "";
		String l_processed_directory = "";
		int l_wait_time = 0;
		
		boolean l_next_file_flag = true;

		int l_file_flag = 0, l_no_file_flag = 0;

		String l_success_flag = "";

		l_app_msg = "Inside FetchResponseWaitTime...";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = "Request... "+l_request+ "Trans Value... "+l_trans_value;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

		try
		{	
			l_app_msg = "Fetching File Directory...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			if (l_errcd.equals("S"))
			{
				l_file_directory = FetchProtocolDetails("ECLAIMSPL");
				if (l_file_directory.indexOf("Error")>=0)
				{
					l_errcd = "E";
					l_errmsg = l_app_msg + "$!^" + l_file_directory;
					return l_errmsg;
				}
				l_app_msg = "File  Directory... "+l_file_directory;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			}
            

			l_app_msg = "File  Directory to fetch response: "+l_file_directory;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_app_msg = "Fetching response Wait Time...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			
			l_wait_time_str = FetchResponseWaitTime("ECLAIMS");
			if (l_wait_time_str.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_app_msg + "$!^" + l_wait_time_str;
				return l_errmsg;
			}

			l_app_msg = " Wait Time... "+l_wait_time_str;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			if (l_errcd.equals("S"))
			{
				l_wait_time = Integer.parseInt(l_wait_time_str);
			}

			if (!(l_wait_time > 0))
			{
				l_wait_time = 30;
			}

			l_app_msg = "Before While Loop...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_file_flag = 0;
			l_no_file_flag = 0;

			try        
			{
				Thread.sleep(l_wait_time*1000);
			} 
			catch(InterruptedException ex) 
			{
				Thread.currentThread().interrupt();
			}

			while (l_next_file_flag)
			{

				l_app_msg = " File Flag... "+l_file_flag;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				if (l_no_file_flag>2)
				{
					l_next_file_flag = false;
					l_app_msg = "Before Break Response Message "+l_response_msg;
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
					break;
				}

				if (l_file_flag == 0)
				{
					l_request_type = "ECLREP";
					l_success_flag = "01";
				}
				if (l_file_flag == 1)
				{
					l_request_type = "ECLREJ";
					l_success_flag = "02";
				}
				if (l_file_flag == 2)
				{
					l_request_type = "ECLFAI";
					l_success_flag = "03";
				}

				l_app_msg = "Calling Create File Name...";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				l_file_name = CreateFileName(l_request_type, l_trans_value, l_case_nbr,l_facility_id);
				if (l_file_name.indexOf("Error")>=0)
				{
					l_errcd = "E";
					l_errmsg = l_file_name;
					return l_errmsg;
				}
				l_app_msg = "File Name... "+l_file_name;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				l_response_msg = FetchResponseMessage(l_file_directory, l_file_name, l_wait_time, l_request_event_type);
				if (l_response_msg.indexOf("Error")>=0)
				{
					l_errcd = "E";
					l_errmsg = l_response_msg;
					l_next_file_flag = false;
				}
				l_app_msg = " Response Message... "+l_response_msg;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				if (l_errcd.equals("S"))
				{
					if (l_response_msg.equals("FILE_NOT_FOUND"))
					{
						if(l_request_event_type.equals("ECLRES"))
						{
							l_processed_directory = l_file_directory+File.separator+"Processed";

							l_response_msg = FetchResponseMessage(l_processed_directory, l_file_name, l_wait_time, l_request_event_type);
							if (l_response_msg.indexOf("Error")>=0)
							{
								l_errcd = "E";
								l_errmsg = l_response_msg;
								l_next_file_flag = false;
							}
							l_app_msg = " Response Message... "+l_response_msg;
							if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
						}

						if (l_response_msg.equals("FILE_NOT_FOUND"))
						{
						
							l_next_file_flag = true;
							l_file_flag++;
							l_no_file_flag++;
						}
						else
						{
							if (l_response_msg.length()>0)
							{
								l_response_msg = "<STATUS>" + l_success_flag + "$!^<FILE_TYPE>" + l_request_type + "$!^<FILE_NAME>" + l_file_name + "$!^<RESPONSE>" + l_response_msg +"$!^";

								l_next_file_flag = false;
								break;
							}
						}
					}
					else
					{
						if (l_response_msg.length()>0)
						{
							l_response_msg = "<STATUS>" + l_success_flag + "$!^<FILE_TYPE>" + l_request_type + "$!^<FILE_NAME>" + l_file_name + "$!^<RESPONSE>" + l_response_msg +"$!^";

							l_next_file_flag = false;
							break;
						}
					}
				}

				if (!(l_response_msg.indexOf("Error")>=0) && !(l_response_msg.equals("FILE_NOT_FOUND")))
				{
					l_next_file_flag = false;
				}					
			}	
			
			if (l_no_file_flag>2)
			{
				l_success_flag = "09";
				l_file_name = "";
				l_response_msg = "Error in reading File - No Response File";
				l_response_msg = "<STATUS>" + l_success_flag + "$!^<FILE_TYPE>" + l_request_type + "$!^<FILE_NAME>" + l_file_name + "$!^<RESPONSE>" + l_response_msg +"$!^";

				
				l_app_msg = " File Search Ends "+l_response_msg;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			}
		}
		catch (Exception e)
		{
			l_app_msg = " Error in reading the file - "+ "$!^" +e.getMessage();
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			l_success_flag = "4";
			l_file_name = "";
			l_response_msg = "<STATUS>" + l_success_flag + "$!^<FILE_TYPE>" + l_request_type + "$!^<FILE_NAME>" + l_file_name + "$!^<RESPONSE>" + l_app_msg +"$!^";
			return l_response_msg;
		}
		
		l_app_msg = "Return Response Message... "+l_response_msg;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		return l_response_msg;

	}

	public String ParseResponseMessage(String request, String responseMsg)
	{
		
		String l_app_msg = "";
		String l_response_str = "", l_xsl_string = "";

		l_app_msg = "Inside ParseResponseMessage...";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		XHUtil xhUtil = null;

		try
		{	
			xhUtil = new XHUtil();	
					
			l_app_msg = "Calling FetchXMLFormat ... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			if (l_errcd.equals("S"))
			{
				l_xsl_string = FetchXMLFormat(request, "ECLAIMS", "XSL");
				if (l_xsl_string.indexOf("Error")>=0)
				{
					l_errcd = "E";
					l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_xsl_string;
					return l_errmsg;
				}
				l_app_msg = "XSL String Generated... "+l_xsl_string;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			}
			
			l_app_msg = "Calling XHUTIL.transformData ... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_response_str  = xhUtil.transformData(responseMsg, l_xsl_string);
			if (l_response_str.indexOf("Error")>=0)
			{
				l_errcd = "E";
				//l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_response_str;

                l_errmsg = l_response_str;
			    l_app_msg = "Error Message... "+l_errmsg;
			    if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				return l_errmsg;
			}
			l_app_msg = "Response Str... "+l_response_str;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
				
		}
		catch (Exception e)
		{
			l_app_msg = "Response Str... "+e.getMessage();
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		}

		return l_response_str;

	}

	public String UpdateInteractiveDetails(Map params)
	{
		java.sql.Connection dbConn = null;

		ResultSet rs=null;
		PreparedStatement pstmt = null;
		String query = "", l_insert_stmt = "", l_update_stmt = "";
		String errorCode = "", errorMsg = "";
		String l_request_date_str = "";

		String l_episode_type = "", l_encounter_id = "";

		String l_response_msg = "", l_response_str = "", l_errcd = "", l_errmsg = "", l_response_syntax = "";
		int l_trans_value = 0;

		java.sql.Timestamp l_current_date = null;

		String l_app_msg = "";

		int l_interactive_count = 0, l_insert_count = 0, l_update_count = 0;

		oracle.sql.CLOB l_response_clob = null;

		try
		{
			l_app_msg = "Inside UpdateInteractiveDetails...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_trans_value = Integer.parseInt(params.get("MSG_ID").toString());

			l_app_msg = "PGM ID... "+ params.get("PGM_ID").toString() + "TRX NO... " + l_trans_value + "EVENT TYPE... "+ params.get("EVENT_TYPE").toString();
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

			l_app_msg = "Interactive Count... "+ l_interactive_count;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			if (l_interactive_count > 0 )
			{
				//update XH_INTERACTIVE_INTEGRATION table 
				l_app_msg = "Inside UPDATE XH_INTERACTIVE_INTEGRATION table ...";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_current_date = new java.sql.Timestamp(System.currentTimeMillis());
				
				l_app_msg = "CURRENT DATE... "+l_current_date;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				l_response_msg = params.get("RESPONSE_TEXT").toString();
				l_app_msg = "RESPONSE TEXT... "+ l_response_msg;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_response_str = params.get("ACKNOWLEDGEMENT_TEXT").toString();
				l_app_msg = "ACKNOWLEDGEMENT TEXT... "+ l_response_str;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_errcd = params.get("STATUS").toString();
				l_app_msg = "STATUS... "+ l_errcd;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_errmsg = params.get("ERROR_MESSAGE").toString();
				l_app_msg = "ERROR MESSAGE... "+ l_errmsg;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
				
				l_response_syntax = params.get("REPONSE_SYNTAX").toString();
				l_app_msg = "REPONSE SYNTAX... "+ l_response_syntax;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				if (l_response_syntax.equals("XXX"))
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

					l_app_msg = "Response Message.LENGTH()...: " +l_response_msg.length();
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);					

					//pstmt.setString(1, l_response_msg);

					l_response_clob = stringToClob(l_response_msg, dbConn);
					pstmt.setClob(1, l_response_clob);

					l_app_msg = "Response Str...: "+ l_response_str + ""+l_response_str.length();
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

					pstmt.setString(2, l_response_str);

					pstmt.setString(3, l_errcd);
					pstmt.setString(4, l_errmsg);
					pstmt.setTimestamp(5, l_current_date);
					pstmt.setString(6, l_response_syntax);
					pstmt.setInt(7, l_trans_value);
					pstmt.setString(8, "ECLAIMS");
					l_update_count = pstmt.executeUpdate();

					l_app_msg = "UPDATE INTERACTIVE INTEGRATION... MSG ID... "+l_trans_value +"...: UpdateCount...: " +l_update_count;
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
					
					if (l_update_count == 1)
					{
						dbConn.commit();		
						errorCode = "S";
						errorMsg = "Interactive Integration Transaction table updated successfully ";
						//return errorMsg;
					}
					else
					{
						dbConn.rollback();	
						if (l_errcd.equals("S"))
						{
							l_errcd = "E";								
						}
						errorMsg = " Error in updating Interactive Integration Records... "+l_trans_value +"$!^" + "Records not updated";
						//return errorMsg;
					}
					if (l_debug_YN.equals("Y")) System.out.println(errorMsg);

				}
				catch(Exception e)
				{
					l_errcd = "E";
					l_errmsg = "Error in Updating Interactive Integration Records ... "+l_trans_value +"$!^" +  e.getMessage();
					errorCode = "E";
					errorMsg = l_errmsg;
					//return errorMsg;
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

				l_app_msg = "LOGIN USER... "+ params.get("LOGIN_USER").toString();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				
				l_app_msg = "CLIENT MACHINE... " + params.get("CLIENT_MACHINE").toString();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = "PGM ID... "+ params.get("PGM_ID").toString();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = "MODULE ID... "+ params.get("MODULE_ID").toString();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = "SESSION ID... " + params.get("SESSION_ID").toString();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = "REQUEST DATE... "+ l_current_date;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = "REQUEST TEXT... "+ params.get("REQUEST_TEXT").toString();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = "APPLICATION ID... " + params.get("APPLICATION_ID").toString();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = "MSG ID... "+ l_trans_value;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				
				l_app_msg = "FACILITY ID... "+ params.get("FACILITY_ID").toString();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = "MESSAGE DATE... " + l_current_date;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = "EVENT TYPE... "+ params.get("EVENT_TYPE").toString();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = "PATIENT ID... "+ params.get("PATIENT_ID").toString();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_episode_type = params.get("EPISODE_TYPE").toString();

				l_app_msg = "EPISODE TYPE... " + l_episode_type;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);				

				l_encounter_id = params.get("ENCOUNTER_ID").toString();

				l_app_msg = "ENCOUNTER ID... "+ l_encounter_id;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);				

				l_app_msg = "ACC NO... "+ params.get("ACC_NO").toString();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = "REQUEST SYNTAX... "+ params.get("REQUEST_SYNTAX").toString();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = "PROTOCOL LINK ID... " + params.get("PROTOCOL_LINK_ID").toString();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = "ADDED BY ID... "+ XHDBAdapter.isNullReplace(params.get("ADDED_BY_ID").toString(), params.get("LOGIN_USER").toString());
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = "MODIFIED BY ID... "+ XHDBAdapter.isNullReplace(params.get("MODIFIED_BY_ID").toString(), params.get("LOGIN_USER").toString());
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = "MODIFIED BY DATE... "+ l_current_date;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = "PROFILE... "+ params.get("PROFILE").toString();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_errmsg = params.get("ERROR_MESSAGE").toString();
				l_app_msg = "ERROR MESSAGE... "+ l_errmsg;
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

					l_app_msg = "1... ";
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

					pstmt.setString(1, params.get("LOGIN_USER").toString());
					pstmt.setString(2, params.get("CLIENT_MACHINE").toString());
					pstmt.setString(3, params.get("CLIENT_MACHINE").toString());
					pstmt.setString(4, params.get("PGM_ID").toString());
					pstmt.setString(5, params.get("MODULE_ID").toString());
					
					l_app_msg = "2... ";
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

					pstmt.setString(6, params.get("SESSION_ID").toString());

					l_app_msg = "2A... ";
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

					pstmt.setTimestamp(7, l_current_date);

					l_app_msg = "2B... ";
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

					String l_request_str = params.get("REQUEST_TEXT").toString();

					l_app_msg = "Request Str.length()... "+l_request_str.length();
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);					

					//pstmt.setString(8, l_request_str);
					l_response_clob = stringToClob(l_request_str, dbConn);
					pstmt.setClob(8, l_response_clob);

					l_app_msg = "2C... ";
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

					pstmt.setString(9, params.get("APPLICATION_ID").toString());

					l_app_msg = "2D... ";
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

					pstmt.setString(10, params.get("MSG_ID").toString());

					l_app_msg = "3... ";
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

					pstmt.setString(11, params.get("FACILITY_ID").toString());
					pstmt.setTimestamp(12, l_current_date);
					pstmt.setString(13, params.get("EVENT_TYPE").toString());
					pstmt.setString(14, params.get("PATIENT_ID").toString());

					l_app_msg = "4... ";
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

					if (l_episode_type.equals("X"))
						pstmt.setString(15, "");
					else
						pstmt.setString(15, params.get("EPISODE_TYPE").toString());

					l_app_msg = "5... ";
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

					if (l_encounter_id.equals("XXX"))
						pstmt.setInt(16, 0);
					else
						pstmt.setLong(16, Long.parseLong(l_encounter_id));

					l_app_msg = "6... ";
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
										
					pstmt.setString(17, params.get("ACC_NO").toString());
					pstmt.setString(18, params.get("REQUEST_SYNTAX").toString());
					pstmt.setString(19, params.get("PROTOCOL_LINK_ID").toString());
					pstmt.setString(20, XHDBAdapter.isNullReplace(params.get("ADDED_BY_ID").toString(), params.get("LOGIN_USER").toString()));

					l_app_msg = "7... ";
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

					pstmt.setTimestamp(21, l_current_date);
					pstmt.setString(22, XHDBAdapter.isNullReplace(params.get("MODIFIED_BY_ID").toString(), params.get("LOGIN_USER").toString()));
					pstmt.setTimestamp(23, l_current_date);
					pstmt.setString(24, params.get("CLIENT_MACHINE").toString());
					pstmt.setString(25, XHDBAdapter.isNullReplace(params.get("ADDED_BY_FACILITY").toString(), params.get("FACILITY_ID").toString()));

					l_app_msg = "8... ";
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

					pstmt.setString(26, params.get("CLIENT_MACHINE").toString());
					pstmt.setString(27, XHDBAdapter.isNullReplace(params.get("ADDED_BY_FACILITY").toString(), params.get("FACILITY_ID").toString()));
					pstmt.setInt(28, l_trans_value);
					pstmt.setString(29, params.get("PROFILE").toString());	
					pstmt.setString(30, l_errmsg);						

					l_app_msg = "9... ";
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
					
					l_insert_count = pstmt.executeUpdate();	
					
					l_app_msg = "Insert Count... "+ l_insert_count;
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
					
					if(l_insert_count == 1) {
						errorCode = "S";
						errorMsg = "Interactive Integration table inserted successfully ";						
						dbConn.commit();										
					}
					else {
						l_errmsg = "Error in Inserting Interactive Integration Records ... "+l_trans_value +"$!^" + " Records not inserted";
						errorMsg = l_errmsg;					
						if (l_errcd.equals("S"))
						{
							l_errcd = "E";								
						}
						dbConn.rollback();
					}

					if (l_debug_YN.equals("Y")) System.out.println(errorMsg);
					
				}
				catch(Exception e)
				{
					l_errcd = "E";
					l_errmsg = "Error in Updating Interactive Integration Records ... "+l_trans_value +"$!^" +  e.getMessage();
					errorMsg = l_errmsg;
					//return l_errmsg;
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
			//return errorMsg;
		}
		finally {
			closeDBResources(rs, pstmt, dbConn);
		}    
		
		return errorMsg;
	}

	public String UpdateEClaimsHeaderDetails(Map params)
	{
		Connection dbConn = null;

		ResultSet rs=null;
		PreparedStatement pstmt = null;
		String query = "", l_insert_stmt = "", l_update_stmt = "";
		String errorCode = "", errorMsg = "";
		String l_request_date_str = "";
		String l_wca_num = "";

		java.sql.Timestamp l_current_date = null;

		String l_errcd = "", l_errmsg = "";
		int l_trans_value = 0;

		java.sql.Timestamp billtimestamp = null;

		String l_app_msg = "";

		int l_eclaims_count = 0, l_insert_count = 0, l_update_count = 0;

		String l_file_name_for_nrl_resp = "", l_inbound_xml_reply = "", l_file_name_for_rej_resp = "", l_inbound_xml_rej = "", l_file_name_for_failed_resp = "", l_inbound_xml_fail = "", l_request_status = "";

		String l_facility_id = "", l_patient_id = "", l_episode_id = "", l_cust_code = "", l_dest_code = "";
		String l_doc_date = "";

		String l_sub_gross_amount_str = "", l_appr_gross_amount_str = "", l_appr_net_amount_str = "", l_appr_disc_amount_str = "";
		String l_levy_str = "", l_over_chg_str = "", l_fee_over_str = "", l_calc_gross_str = "";

		double l_sub_gross_amount = 0.00, l_appr_gross_amount = 0.00, l_appr_net_amount = 0.00, l_appr_disc_amount = 0.00;
		double l_levy = 0.00, l_over_chg = 0.00, l_fee_over = 0.00, l_calc_gross = 0.00;

		String l_trans_status = "", l_trans_case_nbr = "";

		String l_blng_grp_id = "", l_settlement_ind = "";

		String whereCond = "";

		oracle.sql.CLOB l_response_clob = null;

		String l_hnet_num = "";

		try
		{
			l_app_msg = "Inside UpdateEClaimsHeaderDetails...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_facility_id = params.get("FACILITY_ID").toString();
			l_app_msg = "FACILITY ID... "+ l_facility_id;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_patient_id = params.get("PATIENT_ID").toString();
			l_app_msg = "PATIENT ID... "+ l_patient_id;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_episode_id = params.get("EPISODE_ID").toString();
			l_app_msg = "EPISODE ID... "+ l_episode_id;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_cust_code = params.get("CUST_CODE").toString();
			l_app_msg = "CUST CODE... "+ l_cust_code;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_blng_grp_id = params.get("BLNG_GRP_ID").toString();
			l_app_msg = "BLNG GRP ID... "+ l_blng_grp_id;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_settlement_ind = params.get("SETTLEMENT_IND").toString();
			l_app_msg = "SETTLEMENT IND... "+ l_settlement_ind;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_dest_code = params.get("DEST_CODE").toString();
			l_app_msg = "DEST CODE... "+ l_dest_code;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_trans_value =  Integer.parseInt(params.get("MSG_ID").toString()) ;

			if (l_settlement_ind.equals("C"))
			{
				whereCond = " and BLNG_GRP_ID = ? ";
			}
			else if (l_settlement_ind.equals("X") || l_settlement_ind.equals("R"))
			{
				whereCond = " and CUST_CODE = ? ";
			}

			l_app_msg = "whereCond... "+ whereCond;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			

			l_app_msg = "FACILITY ID... "+ l_facility_id + "PATIENT ID... " + l_patient_id + "CUST CODE... "+ l_cust_code + "DEST CODE... " + l_dest_code + "SRL NO... "+ l_trans_value + "BLNG GRP ID... " +l_blng_grp_id;	


			dbConn = ConnectionManager.getConnection();
			query = " select count(*) CLAIMS_COUNT from XF_ECLAIMS_TRX_HDR "
						+" where FACILITY_ID = ? and PATIENT_ID = ? and EPISODE_ID = ? AND DESTINATION_CODE = ? and SRL_NO = ? " 
						+ whereCond;

			pstmt = dbConn.prepareStatement(query);
			pstmt.setString(1, l_facility_id);
			pstmt.setString(2, l_patient_id);
			pstmt.setString(3, l_episode_id);
			pstmt.setString(4, l_dest_code);
			pstmt.setInt(5, l_trans_value);
			if (l_settlement_ind.equals("C"))
			{
				pstmt.setString(6, l_blng_grp_id);
			}
			else if (l_settlement_ind.equals("X") || l_settlement_ind.equals("R"))
			{
				pstmt.setString(6, l_cust_code);
			}

			rs = pstmt.executeQuery();
			while(rs.next())
			{
			   l_eclaims_count = rs.getInt("CLAIMS_COUNT");
			}
			
			l_request_date_str = params.get("REQUEST_DATE").toString();	

			l_app_msg = "CLAIMS COUNT... "+ l_eclaims_count;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			if (l_eclaims_count > 0 )
			{
				//update XF_ECLAIMS_TRX_HDR table 
				l_app_msg = "Inside UPDATE XF_ECLAIMS_TRX_HDR table...";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_current_date = new java.sql.Timestamp(System.currentTimeMillis());
				
				l_file_name_for_nrl_resp = params.get("FILE_NAME_FOR_NRL_RESP").toString();
				l_app_msg = "FILE NAME FOR NRL RESP... "+ l_file_name_for_nrl_resp;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				if (l_file_name_for_nrl_resp.equals("XXX"))
				{
					l_file_name_for_nrl_resp = "";
				}

				l_inbound_xml_reply = params.get("INBOUND_XML_REPLY").toString();
				l_app_msg = "INBOUND XML REPLY... "+ l_inbound_xml_reply;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				if (l_inbound_xml_reply.equals("XXX"))
				{
					l_inbound_xml_reply = "";
				}

				l_file_name_for_rej_resp = params.get("FILE_NAME_FOR_REJ_RESP").toString();
				l_app_msg = "FILE NAME FOR REJ RESP... "+ l_file_name_for_rej_resp;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				if (l_file_name_for_rej_resp.equals("XXX"))
				{
					l_file_name_for_rej_resp = "";
				}

				l_inbound_xml_rej = params.get("INBOUND_XML_REJ").toString();
				l_app_msg = "INBOUND XML REJ... "+ l_inbound_xml_rej;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				if (l_inbound_xml_rej.equals("XXX"))
				{
					l_inbound_xml_rej = "";
				}
				
				l_file_name_for_failed_resp = params.get("FILE_NAME_FOR_FAILED_RESP").toString();
				l_app_msg = "FILE NAME FOR FAILED RESP... "+ l_file_name_for_failed_resp;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				if (l_file_name_for_failed_resp.equals("XXX"))
				{
					l_file_name_for_failed_resp = "";
				}

				l_inbound_xml_fail = params.get("INBOUND_XML_FAIL").toString();
				l_app_msg = "INBOUND XML FAIL... "+ l_inbound_xml_fail;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				if (l_inbound_xml_fail.equals("XXX"))
				{
					l_inbound_xml_fail = "";
				}				

				l_request_status = params.get("REQUEST_STATUS").toString();
				l_app_msg = "Request Status... "+ l_request_status;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				if (l_request_status.equals("XXX"))
				{
					l_request_status = "";
				}

				l_trans_status = params.get("TRANS_STATUS").toString();
				l_app_msg = "Trans Status... "+ l_trans_status;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				if (l_trans_status.equals("XXX"))
				{
					l_trans_status = "";
				}					

				l_trans_case_nbr = params.get("CASE_NUM").toString();
				l_app_msg = "Trans Case Number... "+ l_trans_case_nbr;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				if (l_trans_case_nbr.equals("XXX"))
				{
					l_trans_case_nbr = "";
				}		
				
				l_hnet_num = params.get("AUTHORIZATION_NUM").toString();
				l_app_msg = "HNET Number... "+ l_hnet_num;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				if (l_hnet_num.equals("XXX"))
				{
					l_hnet_num = "";
				}		

				l_sub_gross_amount_str = params.get("SUB_GROSS_AMOUNT").toString();
				l_app_msg = "Sub Gross Amount Str... "+ l_sub_gross_amount_str;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				if (!(l_sub_gross_amount_str.equals("XXX")))
				{
					l_sub_gross_amount = Double.parseDouble(l_sub_gross_amount_str);
				}

				l_appr_gross_amount_str = params.get("APPR_GROSS_AMOUNT").toString();
				l_app_msg = "Appr Gross Amount Str... "+ l_appr_gross_amount_str;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				if (!(l_appr_gross_amount_str.equals("XXX")))
				{
					l_appr_gross_amount = Double.parseDouble(l_appr_gross_amount_str);
				}

				l_appr_net_amount_str = params.get("APPR_NET_AMOUNT").toString();
				l_app_msg = "Appr Net Amount Str... "+ l_appr_net_amount_str;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				if (!(l_appr_net_amount_str.equals("XXX")))
				{
					l_appr_net_amount = Double.parseDouble(l_appr_net_amount_str);
				}

				l_appr_disc_amount_str = params.get("APPR_DISC_AMOUNT").toString();
				l_app_msg = "Appr Disc Amount Str... "+ l_appr_disc_amount_str;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				if (!(l_appr_disc_amount_str.equals("XXX")))
				{
					l_appr_disc_amount = Double.parseDouble(l_appr_disc_amount_str);
				}

				l_levy_str = params.get("LEVY").toString();
				l_app_msg = "Levy Str... "+ l_levy_str;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				if (!(l_levy_str.equals("XXX")))
				{
					l_levy = Double.parseDouble(l_levy_str);
				}

				l_over_chg_str = params.get("OVER_CHG").toString();
				l_app_msg = "Over Change Str... "+ l_over_chg_str;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				if (!(l_over_chg_str.equals("XXX")))
				{
					l_over_chg = Double.parseDouble(l_over_chg_str);
				}

				l_fee_over_str = params.get("FEE_OVER").toString();
				l_app_msg = "Fee Over Str... "+ l_fee_over_str;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				if (!(l_fee_over_str.equals("XXX")))
				{
					l_fee_over = Double.parseDouble(l_fee_over_str);
				}

				l_calc_gross_str = params.get("CALC_GROSS").toString();
				l_app_msg = "Calc Gross Str... "+ l_calc_gross_str;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				if (!(l_calc_gross_str.equals("XXX")))
				{
					l_calc_gross = Double.parseDouble(l_calc_gross_str);
				}

				try
				{
					pstmt = null;

					l_update_stmt = " UPDATE XF_ECLAIMS_TRX_HDR "
									+" SET	FILE_NAME_FOR_NRL_RESP	= ?, "
									+" INBOUND_XML_REPLY			= ?, "
									+" FILE_NAME_FOR_REJ_RESP		= ?, "
									+" INBOUND_XML_REJ				= ?, "
									+" FILE_NAME_FOR_FAILED_RESP	= ?, "
									+" INBOUND_XML_FAIL				= ?, "
									+" REQUEST_STATUS				= ?, "
									+" APPROVAL_STATUS				= ?, "
									+" SUB_GROSS_AMOUNT		        = ?, "
									+" APPR_GROSS_AMOUNT			= ?, "
									+" APPR_NET_AMOUNT				= ?, "
									+" APPR_DISC_AMOUNT				= ?, "
									+" LEVY							= ?, "
									+" OVER_CHG						= ?, "
									+" FEE_OVER						= ?, "
									+" CALC_GROSS			        = ?, "
									+" MODIFIED_DATE				= ?, "
									+" CASE_NUM						= ?, "
									+" AUTHORIZATION_NUM			= ? "
									+" WHERE FACILITY_ID			= ? " 
										+" AND PATIENT_ID			= ? " 
										+" AND EPISODE_ID			= ? "
										+" AND DESTINATION_CODE		= ? " 
										+" AND SRL_NO				= ? " ;

					
					if (whereCond.length() > 0)
					{
						l_update_stmt = l_update_stmt + whereCond;
					}	

					pstmt = dbConn.prepareStatement(l_update_stmt);
					pstmt.setString(1, l_file_name_for_nrl_resp);

					l_app_msg = "Inbound Xml Reply.length()... "+l_inbound_xml_reply.length();
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);					

					//pstmt.setString(2, l_inbound_xml_reply);

					l_response_clob = stringToClob(l_inbound_xml_reply, dbConn);
					pstmt.setClob(2, l_response_clob);
					
					pstmt.setString(3, l_file_name_for_rej_resp);
					pstmt.setString(4, l_inbound_xml_rej);
					pstmt.setString(5, l_file_name_for_failed_resp);
					pstmt.setString(6, l_inbound_xml_fail);
					pstmt.setString(7, l_request_status);
					pstmt.setString(8, l_trans_status);
					pstmt.setDouble(9, l_sub_gross_amount);
					pstmt.setDouble(10, l_appr_gross_amount);
					pstmt.setDouble(11, l_appr_net_amount);
					pstmt.setDouble(12, l_appr_disc_amount);
					pstmt.setDouble(13, l_levy);
					pstmt.setDouble(14, l_over_chg);
					pstmt.setDouble(15, l_fee_over);
					pstmt.setDouble(16, l_calc_gross);
					pstmt.setTimestamp(17, l_current_date);	
					pstmt.setString(18, l_trans_case_nbr);	
					pstmt.setString(19, l_hnet_num);	
					pstmt.setString(20, l_facility_id);
					pstmt.setString(21, l_patient_id);
					pstmt.setString(22, l_episode_id);
					pstmt.setString(23, l_dest_code);
					pstmt.setInt(24, l_trans_value);
					if (l_settlement_ind.equals("C"))
					{
						pstmt.setString(25, l_blng_grp_id);
					}
					else if (l_settlement_ind.equals("X") || l_settlement_ind.equals("R"))
					{
						pstmt.setString(25, l_cust_code);
					}
					l_update_count = pstmt.executeUpdate();

					l_app_msg = "UPDATE XF ECLAIMS TRX HDR... SRL NO... "+l_trans_value +"...: UpdateCount...: " +l_update_count;
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
					
					if (l_update_count == 1)
					{
						dbConn.commit();	
						errorCode = "S";
						errorMsg = "EClaims Transaction table updated successfully ";
					}
					else
					{
						dbConn.rollback();	
						l_errcd = "E";
						l_errmsg = " Error in updating EClaims Header Records "+l_trans_value +"$!^" + " Records not updated";	
						errorCode = "E";
						errorMsg = l_errmsg;
					}

				}
				catch(Exception e)
				{
					l_errcd = "E";
					l_errmsg = " Error in updating EClaims Header Records "+l_trans_value + "$!^" +  e.getMessage();

					errorCode = "E";
					errorMsg = l_errmsg;

					l_app_msg = "UPDATE XF ECLAIMS TRX HDR Exception Message... "+e.getMessage();
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				}
				finally
				{			
					closeDBResources(rs, pstmt, dbConn);				
				}	

			}
			else
			{
				// Insert into XF_ECLAIMS_TRX_HDR table
				l_app_msg = "Inside INSERT XF_ECLAIMS_TRX_HDR table...";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_current_date = new java.sql.Timestamp(System.currentTimeMillis());

				l_app_msg = "FACILITY ID... "+ params.get("FACILITY_ID").toString();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				l_app_msg = "PATIENT ID... "+ params.get("PATIENT_ID").toString();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_episode_id = params.get("EPISODE_ID").toString();

				l_app_msg = "EPISODE ID... "+  l_episode_id;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);				

				l_app_msg = "CUST CODE... " + params.get("CUST_CODE").toString();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = "DESTINATION CODE... "+ params.get("DEST_CODE").toString();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = "MEMBER ID... "+ params.get("MEMBER_ID").toString();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = "MEMBER SURNAME... "+ params.get("MEMBER_SURNAME").toString();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = "MEMBER INITIAL... "+ params.get("MEMBER_INITIAL").toString();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = "WCA NUMBER... "+ params.get("WCA_NUM").toString();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_wca_num = params.get("WCA_NUM").toString();
				if (l_wca_num.equals("XXX"))
				{
					l_wca_num = "";
				}

				l_app_msg = "DEPENDENT NUM... " + params.get("DEPD_CODE").toString();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = "DEPENDENT RELATIONSHIP... "+ params.get("DEPD_RELN").toString();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = "TRANS TYPE... " + params.get("SESSION_ID").toString();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = "EVENT TYPE... "+ params.get("EVENT_TYPE").toString();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				
				l_app_msg = "CASE NUM... "+ params.get("CASE_NUM").toString();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = "AUTHORIZATION NUM... "+ params.get("AUTHORIZATION_NUM").toString();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = "CLAIM NUM... " + params.get("CLAIM_NUM").toString();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = "SRL NO... "+ params.get("MSG_ID").toString();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = "ACCESSION NUM... "+ params.get("ACC_NO").toString();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = "REQUEST DATE... " + l_current_date;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				l_app_msg = "OUTBOUND TYPE... O";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = "FILE NAME FOR OUTBOUND... " + params.get("INPUT_FILE_NAME").toString();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = "OUTBOUND XML... "+ params.get("REQUEST_TEXT").toString();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = "ADDED BY ID... "+ XHDBAdapter.isNullReplace(params.get("ADDED_BY_ID").toString(), params.get("LOGIN_USER").toString());
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = "ADDED DATE... " + l_current_date;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = "MODIFIED BY ID... "+ XHDBAdapter.isNullReplace(params.get("MODIFIED_BY_ID").toString(), params.get("LOGIN_USER").toString());
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = "MODIFIED BY DATE... "+ l_current_date;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = "ADDED AT WS NO... "+ params.get("CLIENT_MACHINE").toString();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = "MODIFIED AT WS NO... "+ params.get("CLIENT_MACHINE").toString();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			    l_app_msg = "BILL DOC TYPE CODE... "+ params.get("BILL_DOC_TYPE_CODE").toString();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = "BILL DOC NO... "+ params.get("BILL_DOC_NO").toString();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = "EPISODE TYPE... "+ params.get("EPISODE_TYPE").toString();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = "VISIT ID... "+ params.get("VISIT_ID").toString();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_doc_date = params.get("BILL_DATE").toString();

				l_app_msg = "BILL DATE... "+ l_doc_date;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				
				try
				{
					SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
					java.util.Date date = sdf1.parse(l_doc_date);
					billtimestamp = new java.sql.Timestamp(date.getTime());
				}
				catch (Exception e)
				{
					l_app_msg = " Error in converting bill date to SQL date..."+e.getMessage();
					if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);						
				}

				l_app_msg = "BILL TIME STAMP... "+ billtimestamp;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = "VISIT ID... "+ params.get("VISIT_ID").toString();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);				

				l_app_msg = "FACILITY ID... "+ params.get("FACILITY_ID").toString() + "PATIENT_ID... "+ params.get("PATIENT_ID").toString() ;									

				l_insert_stmt = " INSERT into XF_ECLAIMS_TRX_HDR (FACILITY_ID, PATIENT_ID, EPISODE_ID, CUST_CODE, DESTINATION_CODE, "				
									+" MEMBERSHIP_NUM, WCA_NUMBER, DEPENDENT_NUM, DEPENDENT_RELATIONSHIP, TRANS_TYPE, "
									+" EVENT_TYPE, CASE_NUM, CLAIM_NUM, SRL_NO, ACCESSION_NUM, "
									+" REQUEST_DATE, OUTBOUND_TYPE, FILE_NAME_FOR_OUTBOUND, OUTBOUND_XML, ADDED_BY_ID, "
									+" ADDED_DATE, MODIFIED_BY_ID, MODIFIED_DATE, ADDED_AT_WS_NO, MODIFIED_AT_WS_NO,DOC_TYPE_CODE,DOC_NUM,DOC_DATE,EPISODE_TYPE, VISIT_ID,MEMBERSHIP_SURNAME, MEMBERSHIP_INITIAL, BLNG_GRP_ID, AUTHORIZATION_NUM) "
									+" values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";			

				pstmt = dbConn.prepareStatement(l_insert_stmt);				
				
				pstmt.setString(1, params.get("FACILITY_ID").toString());
				pstmt.setString(2, params.get("PATIENT_ID").toString());

				if (l_episode_id.equals("XXX"))
					pstmt.setInt(3, 0);
				else
					pstmt.setLong(3, Long.parseLong(l_episode_id));

				if (l_cust_code.equals("XXX"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, l_cust_code);

				//pstmt.setString(4, params.get("CUST_CODE").toString());
				pstmt.setString(5, params.get("DEST_CODE").toString());

				pstmt.setString(6, params.get("MEMBER_ID").toString());
				pstmt.setString(7, l_wca_num);
				pstmt.setString(8, params.get("DEPD_CODE").toString());
				pstmt.setString(9, params.get("DEPD_RELN").toString());
				pstmt.setString(10, params.get("SESSION_ID").toString());
				
				pstmt.setString(11, params.get("EVENT_TYPE").toString());
				pstmt.setString(12, params.get("CASE_NUM").toString());
				pstmt.setString(13, params.get("CLAIM_NUM").toString());
				pstmt.setString(14, params.get("MSG_ID").toString());
				pstmt.setString(15, params.get("ACC_NO").toString());

				pstmt.setTimestamp(16, l_current_date);
				pstmt.setString(17, "O");
				pstmt.setString(18, params.get("INPUT_FILE_NAME").toString());

				String l_request_text_str = params.get("REQUEST_TEXT").toString();

				l_app_msg = "Request Text Str... "+ l_request_text_str.length();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				//pstmt.setString(19, l_request_text_str);
				
				
				l_response_clob = stringToClob(l_request_text_str, dbConn);
				pstmt.setClob(19, l_response_clob);

				pstmt.setString(20, XHDBAdapter.isNullReplace(params.get("ADDED_BY_ID").toString(), params.get("LOGIN_USER").toString()));

				pstmt.setTimestamp(21, l_current_date);
				pstmt.setString(22, XHDBAdapter.isNullReplace(params.get("MODIFIED_BY_ID").toString(), params.get("LOGIN_USER").toString()));
				pstmt.setTimestamp(23, l_current_date);
				pstmt.setString(24, params.get("CLIENT_MACHINE").toString());
				pstmt.setString(25, params.get("CLIENT_MACHINE").toString());
				
				pstmt.setString(26, params.get("BILL_DOC_TYPE_CODE").toString());
				pstmt.setString(27, params.get("BILL_DOC_NO").toString());				
				pstmt.setTimestamp(28, billtimestamp);
				pstmt.setString(29, params.get("EPISODE_TYPE").toString());	
				pstmt.setString(30, params.get("VISIT_ID").toString());
				pstmt.setString(31, params.get("MEMBER_SURNAME").toString());	
				pstmt.setString(32, params.get("MEMBER_INITIAL").toString());
				if (l_blng_grp_id.equals("XXX"))
					pstmt.setString(33, null);
				else
					pstmt.setString(33, l_blng_grp_id);

				l_hnet_num = params.get("AUTHORIZATION_NUM").toString();

				if (l_hnet_num.equals("XXX"))
					pstmt.setString(34, null);
				else
					pstmt.setString(34, l_hnet_num);

				l_insert_count = pstmt.executeUpdate();	
				
				l_app_msg = "Insert Count... "+ l_insert_count;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				
				if(l_insert_count == 1) {
					errorCode = "S";
					errorMsg = "EClaims Transaction table inserted successfully ";
					dbConn.commit();				
				}
				else {		
					dbConn.rollback();
					l_errmsg = " Error in inserting EClaims Header Records "+l_trans_value +"$!^" + " Records not inserted";	
					errorMsg = l_errmsg;
				}
			}
		}
		catch (Exception exp) {
			exp.printStackTrace();
			errorMsg = "Error in UpdateEClaimsHeaderDetails Exception "+l_trans_value +"$!^" + exp.getMessage();
			System.out.println(errorMsg);
			return errorMsg;
		}
		finally {
			closeDBResources(rs, pstmt, dbConn);
		}

        l_app_msg = errorMsg;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		return errorMsg;
	}
	
	public String UpdateEClaimsItemDetails(Map params)
	{
		Connection dbConn = null;

		ResultSet rs=null;
		PreparedStatement pstmt = null;
		String query = "", l_insert_stmt = "";
		String errorCode = "", errorMsg = "";
		java.sql.Timestamp l_current_date = null;

		int l_trans_no = 0, l_doc_no = 0;

		String l_app_msg = "";

		int l_eclaims_item_count = 0, l_insert_count = 0;

		String l_facility_id = "";
		String l_doc_type_code = "", l_doc_num = "", l_claim_no = "", l_case_no = "";
		String l_trans_str = "";


		try
		{
			l_app_msg = "Inside UpdateEClaimsItemDetails...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_facility_id = params.get("FACILITY_ID").toString();

			l_app_msg = "FACILITY ID... "+ l_facility_id;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			l_trans_str = params.get("MSG_ID").toString();

			l_app_msg = "SRL NO... "+ l_trans_str;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			
			l_trans_no = Integer.parseInt(l_trans_str);

			l_doc_type_code = params.get("BILL_DOC_TYPE_CODE").toString();

			l_app_msg = "BILL DOC TYPE CODE... "+ l_doc_type_code;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_doc_num = params.get("BILL_DOC_NO").toString();			

			l_app_msg = "BILL DOC NO... "+ l_doc_num;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_claim_no = params.get("CLAIM_NUM").toString();

			l_app_msg = "CLAIM NUM... "+ l_claim_no;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_case_no =  params.get("CASE_NUM").toString();

			l_app_msg = "CASE NUM... "+ l_case_no;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_doc_no = Integer.parseInt(l_doc_num);

			l_app_msg = "FACILITY ID... "+ l_facility_id + "BILL DOC TYPE CODE... "+ l_doc_type_code + "BILL DOC NO... "+ l_doc_num + "SRL NO... "+ l_trans_no;		
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			dbConn = ConnectionManager.getConnection();
			query = " select count(*) CLAIMS_ITEM_COUNT from XF_ECLAIMS_TRX_DTL "
						+" where FACILITY_ID = ? and BILL_DOC_TYPE_CODE = ? and BILL_DOC_NUM = ? and SRL_NO = ? " ;

			pstmt = dbConn.prepareStatement(query);
			pstmt.setString(1, l_facility_id);
			pstmt.setString(2, l_doc_type_code);
			pstmt.setInt(3, l_doc_no);
			pstmt.setInt(4, l_trans_no);

			rs = pstmt.executeQuery();
			while(rs.next())
			{
			   l_eclaims_item_count = rs.getInt("CLAIMS_ITEM_COUNT");
			}
			
			l_app_msg = "CLAIMS ITEM COUNT... "+ l_eclaims_item_count;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			if (l_eclaims_item_count < 1 )
			{				
				// Insert into XF_ECLAIMS_TRX_DTL table
				l_app_msg = "Inside INSERT XF_ECLAIMS_TRX_DTL table...";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_current_date = new java.sql.Timestamp(System.currentTimeMillis());

				l_app_msg = "REQUEST DATE... " + l_current_date;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				pstmt = null;
				
				l_insert_stmt = " insert into XF_ECLAIMS_TRX_DTL (FACILITY_ID, PATIENT_ID, EPISODE_ID, EPISODE_TYPE, VISIT_ID, CLINICIAN, "
								+"									CASE_NUM, CLAIM_NUM, SRL_NO, BILL_DOC_TYPE_CODE, BILL_DOC_NUM, BILL_DOC_LINE_NUM, "
								+"									SERV_QTY, BLNG_SERV_CODE, BLNG_SERV_DESC, SERV_ITEM_CODE, SERV_ITEM_DESC, SERVICE_DATE, "
								+"									SERV_GROSS_AMT, SERV_DISC_AMT, SERV_NET_AMT, ADJ_SERV_GROSS_AMT, ADJ_SERV_DISC_AMT, ADJ_SERV_NET_AMT, "
								+"									TRX_DOC_REF, TRX_DOC_REF_LINE_NUM, TRX_DOC_REF_SEQ_NUM, BASE_CHARGE_AMT, FOLIO_TRX_DATE, UPFS_CODE) "
								+"	Select a.operating_facility_id, a.PATIENT_ID, a.EPISODE_ID, a.EPISODE_TYPE, nvl(a.VISIT_ID,0) VISIT_ID, NULL CLINICIAN, "
								+"			?, ?, ?, c.BILL_DOC_TYPE_CODE, c.BILL_DOC_NUM, concat(substr( c.TRX_DOC_REF, 13),  c.TRX_DOC_REF_LINE_NUM) , "
								+"			c.SERV_QTY, c.BLNG_SERV_CODE, d.long_desc, c.SERV_ITEM_CODE, c.SERV_ITEM_DESC, c.SERVICE_DATE, "
								+"			c.org_gross_charge_amt, c.org_disc_amt, c.org_net_charge_amt, c.ADJ_GROSS_CHARGE_AMT, c.ADJ_DISC_AMT, c.ADJ_NET_CHARGE_AMT, "
								+"			c.TRX_DOC_REF, c.TRX_DOC_REF_LINE_NUM, c.TRX_DOC_REF_SEQ_NUM, c.BASE_CHARGE_AMT, c.TRX_DATE, NULL UPFS_CODE "
								+"	from       bl_bill_hdr a, bl_patient_charges_folio c, bl_blng_serv d "
								+"	WHERE a.operating_facility_id = c.operating_facility_id "
								+"			AND a.doc_type_code = c.bill_doc_type_code "
								+"			AND a.doc_num = c.bill_doc_num "
								+"			AND a.patient_id = c.patient_id "
								+"			AND a.episode_id = c.episode_id "
								+"			AND a.episode_type = c.episode_type "
								+" 			AND c.blng_serv_code = d.blng_serv_code "
								+"			AND c.trx_status IS NULL "
								+"			and a.operating_facility_id = ? "
								+"			and c.BILL_DOC_TYPE_CODE = ? "
								+"			and c.BILL_DOC_NUM = ? "
								+" ORDER BY c.TRX_DOC_REF, c.TRX_DOC_REF_LINE_NUM, c.TRX_DOC_REF_SEQ_NUM  " ;			

				pstmt = dbConn.prepareStatement(l_insert_stmt);		

				l_trans_no =  Integer.parseInt(params.get("MSG_ID").toString()) ;
				

				pstmt.setString(1, l_case_no);	
				pstmt.setString(2, l_claim_no);	
				pstmt.setInt(3, l_trans_no);
				pstmt.setString(4, l_facility_id);				
				pstmt.setString(5, l_doc_type_code);
				pstmt.setInt(6, l_doc_no);				

				l_insert_count = pstmt.executeUpdate();	
				
				l_app_msg = "Insert Count... "+ l_insert_count;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				
				if(l_insert_count > 0) {
					errorCode = "S";
					errorMsg = "EClaims Item Details table inserted successfully ";
					dbConn.commit();				
				}
				else {		
					dbConn.rollback();
					l_errmsg = " Error in inserting EClaims Item Details Records "+l_trans_no +"$!^" + " Records not inserted";	
					errorMsg = l_errmsg;
				}
			}
		}
		catch (Exception exp) {
			exp.printStackTrace();
			l_errmsg = " Error in inserting EClaims Item Details Records Exception "+l_trans_no +"$!^" + exp.getMessage();	
			errorMsg = l_errmsg;
			System.out.println(errorMsg);
			return errorMsg;
		}
		finally {
			closeDBResources(rs, pstmt, dbConn);
		}
		l_app_msg = ":::Update EClaims Item Details Error Msg... " + errorMsg;
	    if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
         
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

	public String parseResponseXml(String response,String tagName, String attrName)
	{
		String attrValue ="";
		String l_app_msg ="";
		String l_errcd ="S";
		String l_errmsg ="";
        try{
			    l_app_msg = "Inside Parse Response Xml... "+response +" Tag Name... "+tagName+" Attr Name... "+attrName;
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

				DocumentBuilderFactory dbf =
				DocumentBuilderFactory.newInstance();
				DocumentBuilder db = dbf.newDocumentBuilder();
				InputSource is = new InputSource();
				is.setCharacterStream(new StringReader(response));

				Document doc = db.parse(is);
				NodeList nodes = doc.getElementsByTagName(tagName);
				if (nodes.getLength() > 0)
				{
					Element e = (Element)nodes.item(0);
					attrValue = StringEscapeUtils.unescapeXml(e.getAttribute(attrName));
					if (attrValue != null)
						attrValue = attrValue;
					else
						attrValue = "";
				}				

				l_app_msg = "Attr Value... "+attrValue;
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			}
			catch (Exception e)
			{
				l_errcd = "E";
				l_errmsg = "Error in parsing request Xml... "+ e.getMessage();
			}

			if (l_errcd.equals("S"))
			{
				return attrValue;
			}
			else
			{
				return l_errmsg;
			}
	}
	public String ValidateTransaction(String actionKey) throws Exception 
	{
		String responseTxt="";
		Connection Conn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;

		String query = "", l_debug_yn = "";

		String l_app_msg = "";
		String l_request = "", l_return_txt = "";

		String l_patient_id = "", l_encounter_id = "", l_facility_id = "", l_episode_type = "", l_episode_id = "", l_visit_id = "";

		String l_doc_type_code = "", l_doc_no_str = "";
		int l_doc_no = 0;

		String l_approval_status = "", l_event_type = "";

		try
		{ 	
			
			Conn =  ConnectionManager.getConnection();
			query = "select NVL(DEBUG_YN, 'N') DEBUG_YN FROM XH_PARAM " ;

			pstmt = Conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
			   l_debug_yn = rs.getString("DEBUG_YN");
			}

			l_debug_YN = l_debug_yn;

			l_app_msg = "Inside ValidateTransaction...";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_app_msg = "Fetching Request... ";
			if (l_debug_yn.equals("Y"))	System.out.println(l_app_msg);

			l_request = FetchFieldValue(actionKey, "<REQUEST>", null, l_field_separator, "ProcessRequest");

			l_app_msg = "Fetching Facility ID ... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_facility_id = FetchFieldValue(actionKey,"<FACILITY_ID>",null,l_field_separator, "GenerateClaimsRequestXML");
			l_app_msg = "Facility Id... "+l_facility_id;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	


			l_app_msg = "Fetching Patient ID ... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_patient_id = FetchFieldValue(actionKey,"<PATIENT_ID>",null,l_field_separator, "GenerateClaimsRequestXML");
			l_app_msg = "Patient Id... "+l_patient_id;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_app_msg = "Fetching Encounter ID ... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_encounter_id = FetchFieldValue(actionKey,"<ENCOUNTER_ID>",null,l_field_separator, "GenerateClaimsRequestXML");
			l_app_msg = "Encounter Id... "+l_encounter_id;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_app_msg = "Fetching Episode Type... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_episode_type = FetchFieldValue(actionKey,"<EPISODE_TYPE>",null,l_field_separator, "GenerateClaimsRequestXML");
			l_app_msg = "Episode Type... "+l_episode_type;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_app_msg = "Fetching Episode ID... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_episode_id = FetchFieldValue(actionKey,"<EPISODE_ID>",null,l_field_separator, "GenerateClaimsRequestXML");
			l_app_msg = "Episode Id... "+l_episode_id;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_app_msg = "Fetching Visit ID... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_visit_id = FetchFieldValue(actionKey,"<VISIT_ID>",null,l_field_separator, "GenerateClaimsRequestXML");
			l_app_msg = "Visit Id... "+l_visit_id;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_doc_type_code = FetchFieldValue(actionKey, "<BILL_DOC_TYPE_CODE>", null, l_field_separator, "GenerateClaimsRequestXML");
			l_app_msg = "Document Tyoe Code... "+l_doc_type_code;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_doc_no_str = FetchFieldValue(actionKey, "<BILL_DOC_NO>", null, l_field_separator, "GenerateClaimsRequestXML");
			l_app_msg = "Document Number Str... "+l_doc_no_str;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);	

			l_doc_no = Integer.parseInt(l_doc_no_str);
			
			pstmt = null;
			rs = null;

			query = " select TRANS_TYPE, EVENT_TYPE, NVL(APPROVAL_STATUS,'') APPROVAL_STATUS from XF_ECLAIMS_TRX_HDR "
                    +"     where (FACILITY_ID, DOC_TYPE_CODE, DOC_NUM, SRL_NO) in "
                    +"               (Select  FACILITY_ID, DOC_TYPE_CODE, DOC_NUM, max(SRL_NO) "
                    +"                        from XF_ECLAIMS_TRX_HDR "
                    +"                        where FACILITY_ID = ? and DOC_TYPE_CODE = ? and DOC_NUM = ? "
                    +"                        group by FACILITY_ID, DOC_TYPE_CODE, DOC_NUM)" ;

			if (l_debug_YN.equals("Y")) System.out.println("Validate Transaction Query... "+query);	

			pstmt = Conn.prepareStatement(query);
			pstmt.setString(1, l_facility_id);
			pstmt.setString(2, l_doc_type_code);
			pstmt.setInt(3, l_doc_no);

			rs = pstmt.executeQuery();
			while(rs.next())
			{
			   l_event_type = rs.getString("EVENT_TYPE")==null?"":rs.getString("EVENT_TYPE");
			   l_approval_status = rs.getString("APPROVAL_STATUS")==null?"":rs.getString("APPROVAL_STATUS");
			}

			if (l_debug_YN.equals("Y")) System.out.println("Validate Transaction Request... "+l_request+" Event Type... "+l_event_type+" Apporval Status... "+l_approval_status);	
			
			if (l_request.equals("CLA")||l_request.equals("CLE"))
				responseTxt = "True";
			else
				responseTxt = "False";	
			
			l_return_txt = "";

			if (l_approval_status.length()>0 && l_event_type.length()>0)
			{	
				if (l_request.equals("CLA")||l_request.equals("CLE"))
				{
					if (l_event_type.equals("CLA")||l_event_type.equals("CLE"))
					{
						if (l_approval_status.equals("P")||l_approval_status.equals("W")||l_approval_status.equals("D"))
						{
							responseTxt = "False";
							l_return_txt = "Claims has already been processed from this bill number, Claims cannot be processed again.";
						}	
						else
						{
							responseTxt = "True";
						}
					}
					if (l_event_type.equals("REV"))
					{
						if (l_approval_status.equals("A")||l_approval_status.equals("P"))
						{
							responseTxt = "True";
						}
						else 					
						{
							responseTxt = "False";
							l_return_txt = "Claims has already been processed from this bill number, Claims cannot be processed again.";
						}
					}
					if (l_event_type.equals("EOC"))
					{
						if (l_approval_status.equals("P"))
						{
							responseTxt = "False";
							l_return_txt = "End of Case has been processed from this bill number, Claims cannot be processed again.";
						}
						else
							responseTxt = "True";
					}
				}

				if (l_request.equals("REV"))
				{
					if (!(l_event_type.length() > 0))
					{
						responseTxt = "False";
						l_return_txt = "Claims has not been processed from this bill number, Reversal cannot be processed.";
					}
					if (l_event_type.equals("CLA")||l_event_type.equals("CLE"))
					{
						if (l_approval_status.equals("P")||l_approval_status.equals("W")||l_approval_status.equals("D"))
						{
							responseTxt = "True";
							l_return_txt =l_event_type;
						}
						else
						{
							responseTxt = "False";
							l_return_txt = "Either no claims has been processed from this bill number or Claims has been rejected, Reversal cannot be processed again.";
						}
						
					}
					if (l_event_type.equals("REV"))
					{
						if (l_approval_status.equals("A")||l_approval_status.equals("P"))
						{
							responseTxt = "False";
							l_return_txt = "Reversal has already been processed from this bill number, Reversal cannot be processed again.";
						}
						else
						{
							responseTxt = "True";
						}
					}
					if (l_event_type.equals("EOC"))
					{
						if (l_approval_status.equals("P")||l_approval_status.equals("W")||l_approval_status.equals("D"))
						{
							responseTxt = "True";
							l_return_txt = l_event_type ;
						}
						else
						{
							responseTxt = "False";
							l_return_txt = "EOC has been rejected from this bill number, EOC Reversal cannot be processed again.";
						}
					}
				}
				if (l_request.equals("EOC"))
				{
					if (!(l_event_type.length() > 0))
					{
						responseTxt = "False";
						l_return_txt = "Claims has not been processed from this bill number, End of Case cannot be processed.";
					}
					if (l_event_type.equals("CLA"))
					{
						if (l_approval_status.equals("P")||l_approval_status.equals("W")||l_approval_status.equals("D"))
						{
							responseTxt = "True";
						}	
						else
						{
							responseTxt = "False";
							l_return_txt = "Claims has not been processed / Rejected from this bill number, End of Case cannot be processed.";
						}
					}
					if (l_event_type.equals("CLE"))
					{
						if (l_approval_status.equals("P")||l_approval_status.equals("W")||l_approval_status.equals("D"))
						{
							responseTxt = "False";
							l_return_txt = "Claims End of Case has been processed for this bill number, End of Case cannot be processed.";							
						}	
						else
						{
							responseTxt = "True";
						}
					}
					if (l_event_type.equals("REV"))
					{
						if (l_approval_status.equals("A")||l_approval_status.equals("P"))
						{
							responseTxt = "False";
							l_return_txt = "Reversal has been processed from this bill number, End of Case cannot be processed now.";
						}	
						else
						{
							responseTxt = "True";
						}
					}
					if (l_event_type.equals("EOC"))
					{
						if (l_approval_status.equals("P"))
						{
							responseTxt = "False";
							l_return_txt = "End of Case has already been processed from this bill number, EOC cannot be processed again.";
						}
						else
						{
							responseTxt = "True";
						}
					}
				}
			}		
            else
			{
				if (l_event_type.length()>0)
				{
					if (l_request.equals("CLA"))
					{
						responseTxt = "False";
						l_return_txt = "Claims has been processed from this bill number, Cannot be processed again.";
					}
				}
				
				if (l_request.equals("EOC") || l_request.equals("REV") )
				{
					responseTxt = "False";
					l_return_txt = "Claims has not been processed from this bill number, Cannot be processed.";
			    }
			}
			if (l_debug_YN.equals("Y")) System.out.println("Validate Transaction Response Text..."+responseTxt);
			if (l_debug_YN.equals("Y")) System.out.println("Validate Transaction Return Text..."+l_return_txt);
		}
		catch(Exception exp)
		{
			if (l_debug_YN.equals("Y")) System.out.println("Exception in ValidateTransaction "+exp.getMessage());
			exp.printStackTrace(System.err);
			return "False"+"$!^"+"Exception has occured while validating the bill number";
		}
		finally
		{			
			closeDBResources(rs, pstmt, Conn);	
		}
		return responseTxt+"$!^"+l_return_txt;
	}

	public String getRaceCode(String raceCode){
		String l_app_msg = "";
		Connection Conn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;
		String query="";
		String l_race_code = "", l_race_desc = "", l_element_id = "";
		l_errcd = "S";
       try
		{
		   l_app_msg = "Inside getRaceCode...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			Conn =  ConnectionManager.getConnection();
			query = "select LONG_DESC FROM MP_RACE where RACE_CODE = ? " ;

			pstmt = Conn.prepareStatement(query);
			pstmt.setString(1, raceCode);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
			   l_race_desc = rs.getString("LONG_DESC")==null?"":rs.getString("LONG_DESC");
			}

			if (rs.isBeforeFirst() && rs.getRow() > 0)
			{			
				while(rs.next())
				{
				   l_race_desc = rs.getString("LONG_DESC")==null?"":rs.getString("LONG_DESC");
				}
			}
			else
			{
				l_element_id = "DEFAULT_RACE_CODE";

				l_race_code = FetchStdCntrlSeg(l_segment_id, l_element_id, l_standard_code);
				if (l_race_code.indexOf("Error")>=0)
				{
					l_errcd = "E";
					l_errmsg = l_race_code;
				}
				l_app_msg = "Race Code... "+l_race_code;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			}

			l_app_msg = ":: Race Description...: "+l_race_desc;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			if (l_race_desc.length() > 0)
			{
				if (l_race_desc.toLowerCase().equals("asian"))
				{
					l_race_code = "A";
				}
				else if (l_race_desc.toLowerCase().equals("black"))
				{
					l_race_code = "B";
				}
				else if (l_race_desc.toLowerCase().equals("coloured"))
				{
					l_race_code = "C";
				}
				else if (l_race_desc.toLowerCase().equals("white"))
				{
					l_race_code = "W";
				}
			}
		}
		catch(Exception e)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + e.getMessage() ;
		}
		finally
		{			
			closeDBResources(rs, pstmt, Conn);	
		}
		return l_race_code;
	}

	public String fetchReferNo(String actionKey)
	{
		String l_app_msg = "";
		Connection Conn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;

		
		String l_event_type = "", l_event_query ="";
		String l_patient_id = "", l_encounter_id = "", l_facility_id = "", l_episode_type = "", l_episode_id = "", l_visit_id = "";

		String l_doc_type_code = "", l_doc_no_str = "";
		int l_doc_no = 0, l_srl_no = 0;
		l_errcd = "S";

		String  l_trans_ref_no = "", l_request = "", l_case_no = "", l_approval_status = "";

		try
		{
			l_app_msg = "Inside fetchReferNo...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_app_msg = "Fetching Request... ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_request = FetchFieldValue(actionKey, "<REQUEST>", null, l_field_separator, "ProcessRequest");
			l_app_msg = "Request... "+l_request;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_event_type = FetchFieldValue(actionKey, "<EVENT_TYPE>", null, l_field_separator, "ProcessRequest");
			l_app_msg = "Event Type... "+l_event_type;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_app_msg = "Fetching Facility ID ... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_facility_id = FetchFieldValue(actionKey,"<FACILITY_ID>",null,l_field_separator, "GenerateClaimsRequestXML");
			l_app_msg = "Facility Id... "+l_facility_id;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_app_msg = "Fetching Patient ID ... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_patient_id = FetchFieldValue(actionKey,"<PATIENT_ID>",null,l_field_separator, "GenerateClaimsRequestXML");
			l_app_msg = "Patient Id... "+l_patient_id;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_app_msg = "Fetching Encounter ID ... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_encounter_id = FetchFieldValue(actionKey,"<ENCOUNTER_ID>",null,l_field_separator, "GenerateClaimsRequestXML");
			l_app_msg = "Encounter Id... "+l_encounter_id;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_app_msg = "Fetching Episode Type... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_episode_type = FetchFieldValue(actionKey,"<EPISODE_TYPE>",null,l_field_separator, "GenerateClaimsRequestXML");
			l_app_msg = "Episode Type... "+l_episode_type;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_app_msg = "Fetching Episode ID... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_episode_id = FetchFieldValue(actionKey,"<EPISODE_ID>",null,l_field_separator, "GenerateClaimsRequestXML");
			l_app_msg = "Episode Id... "+l_episode_id;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_app_msg = "Fetching Visit ID... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_visit_id = FetchFieldValue(actionKey,"<VISIT_ID>",null,l_field_separator, "GenerateClaimsRequestXML");
			l_app_msg = "Visit Id... "+l_visit_id;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_doc_type_code = FetchFieldValue(actionKey, "<BILL_DOC_TYPE_CODE>", null, l_field_separator, "GenerateClaimsRequestXML");
			l_app_msg = "Document Type Code... "+l_doc_type_code;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_doc_no_str = FetchFieldValue(actionKey, "<BILL_DOC_NO>", null, l_field_separator, "GenerateClaimsRequestXML");
			l_app_msg = "Document Number Str... "+l_doc_no_str;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);	

			l_doc_no = Integer.parseInt(l_doc_no_str);
			

			Conn =  ConnectionManager.getConnection();						

			l_event_query = "Select FACILITY_ID, PATIENT_ID, EPISODE_ID, VISIT_ID, DOC_TYPE_CODE, DOC_NUM, TRANS_TYPE, EVENT_TYPE, SRL_NO, CASE_NUM, APPROVAL_STATUS "
								+"  from xf_eclaims_trx_hdr "
								+"	where srl_no in (select max(SRL_NO) from xf_eclaims_trx_hdr "
								+"						where FACILITY_ID = ? and PATIENT_ID = ? and EPISODE_ID = ? and VISIT_ID = ? "
								+"							and DOC_TYPE_CODE = ? and DOC_NUM = ? and APPROVAL_STATUS in ('P','W') )";

			if (l_debug_YN.equals("Y"))	System.out.println("l_event_query...."+l_event_query);

			pstmt = Conn.prepareStatement(l_event_query);
			pstmt.setString(1, l_facility_id);
			pstmt.setString(2, l_patient_id);
			pstmt.setString(3, l_episode_id);
			pstmt.setString(4, l_visit_id);
			pstmt.setString(5, l_doc_type_code);
			pstmt.setInt(6, l_doc_no);

			rs = pstmt.executeQuery();

			while(rs.next())
			{
			   l_event_type = rs.getString("EVENT_TYPE");
			   l_srl_no = rs.getInt("SRL_NO");
			   l_case_no = rs.getString("CASE_NUM");
			   l_approval_status = rs.getString("APPROVAL_STATUS");
			}
			
			l_trans_ref_no = String.valueOf(l_srl_no);
		}
		catch(Exception e)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + "Error in fetching the transaction reference number - " + e.getMessage() ;

			return l_errmsg;
		}
		finally
		{			
			closeDBResources(rs, pstmt, Conn);	
		}

		if (l_debug_YN.equals("Y"))	System.out.println("l_trans_ref_no...."+l_trans_ref_no+ "$!^" + l_event_type);

		return l_trans_ref_no + "/" + l_event_type;
	}

	public String UpdateDuplicateClaim(Map params,String actionKey,String response)
	{

		Connection Conn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;

		String l_app_msg = "",l_interactive_log = "",l_eclaims_header_log = "",l_eclaims_item_log = "",l_eclaims_status_log = "", l_response_return = "";

		String l_event_type = "";
		String l_patient_id = "", l_encounter_id = "", l_facility_id = "", l_episode_type = "", l_episode_id = "", l_visit_id = "";

		String l_doc_type_code = "", l_doc_no_str = "";
		int l_doc_no = 0, l_srl_no = 0;
		l_errcd = "S";

		String l_request = "", l_case_no = "", l_approval_status = "";

		String l_trans_query = "";
		try
			{
				l_app_msg = "Inside UpdateDuplicateClaim...";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = "Fetching Request... ";
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

				l_request = FetchFieldValue(actionKey, "<REQUEST>", null, l_field_separator, "ProcessRequest");
				l_app_msg = "Request... "+l_request;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				l_event_type = FetchFieldValue(actionKey, "<EVENT_TYPE>", null, l_field_separator, "ProcessRequest");
				l_app_msg = "Event Type... "+l_event_type;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				l_app_msg = "Fetching Facility ID ... ";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				l_facility_id = FetchFieldValue(actionKey,"<FACILITY_ID>",null,l_field_separator, "GenerateClaimsRequestXML");
				l_app_msg = "Facility Id... "+l_facility_id;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				l_app_msg = "Fetching Patient ID ... ";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				l_patient_id = FetchFieldValue(actionKey,"<PATIENT_ID>",null,l_field_separator, "GenerateClaimsRequestXML");
				l_app_msg = "Patient Id... "+l_patient_id;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				l_app_msg = "Fetching Encounter ID ... ";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				l_encounter_id = FetchFieldValue(actionKey,"<ENCOUNTER_ID>",null,l_field_separator, "GenerateClaimsRequestXML");
				l_app_msg = "Encounter Id... "+l_encounter_id;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				l_app_msg = "Fetching Episode Type... ";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				l_episode_type = FetchFieldValue(actionKey,"<EPISODE_TYPE>",null,l_field_separator, "GenerateClaimsRequestXML");
				l_app_msg = "Episode Type... "+l_episode_type;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				l_app_msg = "Fetching Episode ID... ";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				l_episode_id = FetchFieldValue(actionKey,"<EPISODE_ID>",null,l_field_separator, "GenerateClaimsRequestXML");
				l_app_msg = "Episode Id... "+l_episode_id;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				l_app_msg = "Fetching Visit ID... ";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				l_visit_id = FetchFieldValue(actionKey,"<VISIT_ID>",null,l_field_separator, "GenerateClaimsRequestXML");
				l_app_msg = "Visit Id... "+l_visit_id;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				l_doc_type_code = FetchFieldValue(actionKey, "<BILL_DOC_TYPE_CODE>", null, l_field_separator, "GenerateClaimsRequestXML");
				l_app_msg = "Document Type Code... "+l_doc_type_code;
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

				l_doc_no_str = FetchFieldValue(actionKey, "<BILL_DOC_NO>", null, l_field_separator, "GenerateClaimsRequestXML");
				l_app_msg = "Document number Str... "+l_doc_no_str;
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);	

				l_doc_no = Integer.parseInt(l_doc_no_str);
			
				Conn =  ConnectionManager.getConnection();						

				l_trans_query = "Select FACILITY_ID, PATIENT_ID, EPISODE_ID, VISIT_ID, DOC_TYPE_CODE, DOC_NUM, TRANS_TYPE, EVENT_TYPE, SRL_NO, CASE_NUM, APPROVAL_STATUS "
									+"  from xf_eclaims_trx_hdr "
									+"	where srl_no in (select max(SRL_NO) from xf_eclaims_trx_hdr "
									+"						where FACILITY_ID = ? and PATIENT_ID = ? and EPISODE_ID = ? and VISIT_ID = ? "
									+"							and DOC_TYPE_CODE = ? and DOC_NUM = ? and  EVENT_TYPE = ? and APPROVAL_STATUS ='99')";

				if (l_debug_YN.equals("Y"))	System.out.println("l_trans_query...."+l_trans_query);

				pstmt = Conn.prepareStatement(l_trans_query);
				pstmt.setString(1, l_facility_id);
				pstmt.setString(2, l_patient_id);
				pstmt.setString(3, l_episode_id);
				pstmt.setString(4, l_visit_id);
				pstmt.setString(5, l_doc_type_code);
				pstmt.setInt(6, l_doc_no);
				pstmt.setString(7, l_request);

				rs = pstmt.executeQuery();

				while(rs.next())
				{
				   l_event_type = rs.getString("EVENT_TYPE");
				   l_srl_no = rs.getInt("SRL_NO");
				   l_case_no = rs.getString("CASE_NUM");
				   l_approval_status = rs.getString("APPROVAL_STATUS");
				}

				l_app_msg = "l_srl_no"+l_srl_no;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				params.put("MSG_ID",String.valueOf(l_srl_no));
				params.put("TRANS_STATUS","P");
			
				l_app_msg = "Inserting Interface Audit data...";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
				
				l_interactive_log = UpdateInteractiveDetails(params);
				if (l_interactive_log.indexOf("Error")>=0)
				{
					l_errcd = "E";
					l_errmsg = l_interactive_log;
				}
                l_response_return = l_interactive_log;
				l_app_msg = "Interactive Log... "+l_interactive_log+ " - Error Status... "+l_errcd;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				if (l_errcd.equals("S"))
				{
					l_eclaims_header_log = UpdateEClaimsHeaderDetails(params);
					if (l_eclaims_header_log.indexOf("Error")>=0)
					{
						l_errcd = "E";
						l_errmsg = l_eclaims_header_log;
					}
                    l_response_return = l_eclaims_header_log;
					l_app_msg = "Eclaims Header Log... "+l_eclaims_header_log;
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

					l_eclaims_item_log = UpdateEClaimsItemDetails(params);
					if (l_eclaims_item_log.indexOf("Error")>=0)
					{
						l_errcd = "E";
					}
                    l_response_return = l_eclaims_item_log;
					l_app_msg = "Eclaims Item Log... "+l_eclaims_item_log;
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				}
				l_app_msg = "Error Status... "+l_errcd;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				if (l_errcd.equals("S"))
				{
					l_app_msg = " Updating Status log... ";
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);		

					l_eclaims_status_log = ParseClaimsStatus(response, params);

					if (l_eclaims_status_log.indexOf("Error")>=0)
					{
						l_errcd = "E";

					}
					l_app_msg = " Updating Item Status log... ";
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);		

					l_eclaims_status_log = ParseClaimsItemStatus(response, params);

					if (l_eclaims_status_log.indexOf("Error")>=0)
					{
						l_errcd = "E";
					}
					l_response_return =  l_eclaims_status_log;
					
					l_app_msg = "Response return  Eclaims Status Log... "+l_response_return;
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				}
			
			}
			catch (Exception e)
			{
				l_errcd = "E";
				l_errmsg = "Error in (UpdateDuplicateClaim) "+ e.getMessage();
			}
			finally
			{			
				closeDBResources(rs, pstmt, Conn);	
			}
			return l_response_return;
	}


	public boolean CheckForClaimNetworkError(String actionKey)
	{

		Connection Conn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;

		String l_app_msg = "";

		String l_event_type = "";
		String l_patient_id = "", l_encounter_id = "", l_facility_id = "", l_episode_type = "", l_episode_id = "", l_visit_id = "";

		String l_doc_type_code = "", l_doc_no_str = "";
		int l_doc_no = 0;
		l_errcd = "S";

		String  l_request = "", l_case_no = "";


		boolean l_record_flag = false;

		String l_trans_query = "";
		try
			{
				l_app_msg = "Inside QueryForClaimNetworkError...";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = "Fetching Request... ";
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

				l_request = FetchFieldValue(actionKey, "<REQUEST>", null, l_field_separator, "ProcessRequest");
				l_app_msg = "Request... "+l_request;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				l_event_type = FetchFieldValue(actionKey, "<EVENT_TYPE>", null, l_field_separator, "ProcessRequest");
				l_app_msg = "Event Type... "+l_event_type;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				l_app_msg = "Fetching Facility ID ... ";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				l_facility_id = FetchFieldValue(actionKey,"<FACILITY_ID>",null,l_field_separator, "GenerateClaimsRequestXML");
				l_app_msg = "Facility Id... "+l_facility_id;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				l_app_msg = "Fetching Patient ID ... ";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				l_patient_id = FetchFieldValue(actionKey,"<PATIENT_ID>",null,l_field_separator, "GenerateClaimsRequestXML");
				l_app_msg = "Patient Id... "+l_patient_id;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				l_app_msg = "Fetching Encounter ID ... ";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				l_encounter_id = FetchFieldValue(actionKey,"<ENCOUNTER_ID>",null,l_field_separator, "GenerateClaimsRequestXML");
				l_app_msg = "Encounter Id... "+l_encounter_id;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				l_app_msg = "Fetching Episode Type... ";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				l_episode_type = FetchFieldValue(actionKey,"<EPISODE_TYPE>",null,l_field_separator, "GenerateClaimsRequestXML");
				l_app_msg = "Episode Type... "+l_episode_type;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				l_app_msg = "Fetching Episode ID... ";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				l_episode_id = FetchFieldValue(actionKey,"<EPISODE_ID>",null,l_field_separator, "GenerateClaimsRequestXML");
				l_app_msg = "Episode Id... "+l_episode_id;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				l_app_msg = "Fetching Visit ID... ";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				l_visit_id = FetchFieldValue(actionKey,"<VISIT_ID>",null,l_field_separator, "GenerateClaimsRequestXML");
				l_app_msg = "Visit Id... "+l_visit_id;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				l_doc_type_code = FetchFieldValue(actionKey, "<BILL_DOC_TYPE_CODE>", null, l_field_separator, "GenerateClaimsRequestXML");
				l_app_msg = "Document Type Code... "+l_doc_type_code;
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

				l_doc_no_str = FetchFieldValue(actionKey, "<BILL_DOC_NO>", null, l_field_separator, "GenerateClaimsRequestXML");
				l_app_msg = "Document Number Str... "+l_doc_no_str;
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);	

				l_doc_no = Integer.parseInt(l_doc_no_str);
			
				Conn =  ConnectionManager.getConnection();						

				l_trans_query = "(select max(SRL_NO) from xf_eclaims_trx_hdr "
									+"						where FACILITY_ID = ? and PATIENT_ID = ? and EPISODE_ID = ? and VISIT_ID = ? "
									+"							and DOC_TYPE_CODE = ? and DOC_NUM = ? and  EVENT_TYPE = ? and APPROVAL_STATUS ='99')";

				if (l_debug_YN.equals("Y"))	System.out.println("l_trans_query...."+l_trans_query);

				pstmt = Conn.prepareStatement(l_trans_query);
				pstmt.setString(1, l_facility_id);
				pstmt.setString(2, l_patient_id);
				pstmt.setString(3, l_episode_id);
				pstmt.setString(4, l_visit_id);
				pstmt.setString(5, l_doc_type_code);
				pstmt.setInt(6, l_doc_no);
				pstmt.setString(7, l_request);

				rs = pstmt.executeQuery();

				while(rs.next())
				{
				   l_record_flag = true;
				}			
			
			}
			catch (Exception e)
			{
				l_record_flag = false;
				return l_record_flag;
			}
			finally
			{			
				closeDBResources(rs, pstmt, Conn);	
			}

			return l_record_flag;			
	}


	public String UpdateClaimReversal(Map params,String actionKey,String response)
	{

		Connection dbConn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;

		String l_app_msg = "",l_interactive_log = "",l_eclaims_header_log = "", l_response_return = "";

		String l_event_type = "";
		String l_patient_id = "", l_encounter_id = "", l_facility_id = "", l_episode_type = "", l_episode_id = "", l_visit_id = "";

		String l_doc_type_code = "", l_doc_no_str = "";
		int l_doc_no = 0, l_srl_no = 0;
		l_errcd = "S";

		String  l_trans_ref_no = "", l_request = "", l_case_no = "", l_approval_status = "";

		String l_trans_query = "";
		try
			{
				l_app_msg = "Inside UpdateClaimReversal...";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = "Fetching Request... ";
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

				l_request = FetchFieldValue(actionKey, "<REQUEST>", null, l_field_separator, "ProcessRequest");
				l_app_msg = "Request... "+l_request;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				l_event_type = FetchFieldValue(actionKey, "<EVENT_TYPE>", null, l_field_separator, "ProcessRequest");
				l_app_msg = "Event Type... "+l_event_type;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				l_trans_ref_no= FetchFieldValue(actionKey, "<TRANS_REF_ID>", null, l_field_separator, "ProcessRequest");
				l_app_msg = "Trans Reference Number... "+l_trans_ref_no;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				l_app_msg = "Fetching Facility ID ... ";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				l_facility_id = FetchFieldValue(actionKey,"<FACILITY_ID>",null,l_field_separator, "GenerateClaimsRequestXML");
				l_app_msg = "Facility Id... "+l_facility_id;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				l_app_msg = "Fetching Patient ID ... ";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				l_patient_id = FetchFieldValue(actionKey,"<PATIENT_ID>",null,l_field_separator, "GenerateClaimsRequestXML");
				l_app_msg = "Patient Id... "+l_patient_id;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				l_app_msg = "Fetching Encounter ID ... ";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				l_encounter_id = FetchFieldValue(actionKey,"<ENCOUNTER_ID>",null,l_field_separator, "GenerateClaimsRequestXML");
				l_app_msg = "Encounter Id... "+l_encounter_id;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				l_app_msg = "Fetching Episode Type... ";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				l_episode_type = FetchFieldValue(actionKey,"<EPISODE_TYPE>",null,l_field_separator, "GenerateClaimsRequestXML");
				l_app_msg = "Episode Type... "+l_episode_type;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				l_app_msg = "Fetching Episode ID... ";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				l_episode_id = FetchFieldValue(actionKey,"<EPISODE_ID>",null,l_field_separator, "GenerateClaimsRequestXML");
				l_app_msg = "Episode Id... "+l_episode_id;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				l_app_msg = "Fetching Visit ID... ";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				l_visit_id = FetchFieldValue(actionKey,"<VISIT_ID>",null,l_field_separator, "GenerateClaimsRequestXML");
				l_app_msg = "Visit Id... "+l_visit_id;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				l_doc_type_code = FetchFieldValue(actionKey, "<BILL_DOC_TYPE_CODE>", null, l_field_separator, "GenerateClaimsRequestXML");
				l_app_msg = "Document Type Code... "+l_doc_type_code;
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

				l_doc_no_str = FetchFieldValue(actionKey, "<BILL_DOC_NO>", null, l_field_separator, "GenerateClaimsRequestXML");
				l_app_msg = "Document Number Str... "+l_doc_no_str;
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);	

				l_doc_no = Integer.parseInt(l_doc_no_str);
			
				dbConn =  ConnectionManager.getConnection();						

				l_trans_query = "Select FACILITY_ID, PATIENT_ID, EPISODE_ID, VISIT_ID, DOC_TYPE_CODE, DOC_NUM, TRANS_TYPE, EVENT_TYPE, SRL_NO, CASE_NUM, APPROVAL_STATUS "
									+"  from xf_eclaims_trx_hdr "
									+"	where srl_no in (select max(SRL_NO) from xf_eclaims_trx_hdr "
									+"						where FACILITY_ID = ? and PATIENT_ID = ? and EPISODE_ID = ? and VISIT_ID = ? "
									+"							and DOC_TYPE_CODE = ? and DOC_NUM = ? and  SRL_NO < ? and APPROVAL_STATUS in ('P','A','W'))";

				if (l_debug_YN.equals("Y"))	System.out.println("l_trans_query...."+l_trans_query);
				if (l_debug_YN.equals("Y"))	System.out.println("l_trans_ref_no...."+Integer.parseInt(l_trans_ref_no));

				pstmt = dbConn.prepareStatement(l_trans_query);
				pstmt.setString(1, l_facility_id);
				pstmt.setString(2, l_patient_id);
				pstmt.setString(3, l_episode_id);
				pstmt.setString(4, l_visit_id);
				pstmt.setString(5, l_doc_type_code);
				pstmt.setInt(6, l_doc_no);
				pstmt.setInt(7,Integer.parseInt(l_trans_ref_no));

				rs = pstmt.executeQuery();

				while(rs.next())
				{
				   l_event_type = rs.getString("EVENT_TYPE");
				   l_srl_no = rs.getInt("SRL_NO");
				   l_case_no = rs.getString("CASE_NUM");
				   l_approval_status = rs.getString("APPROVAL_STATUS");
				}

				l_app_msg = "l_srl_no"+l_srl_no;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				params.put("CLAIM_NUM", String.valueOf(l_srl_no));
			
				l_app_msg = "Inserting Interface Audit data...";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
				
				l_interactive_log = UpdateInteractiveDetails(params);
				if (l_interactive_log.indexOf("Error")>=0)
				{
					l_errcd = "E";
					l_errmsg = l_interactive_log;
				}
                l_response_return = l_interactive_log;
				l_app_msg = "Interactive Log... "+l_interactive_log+ " - Error Status... "+l_errcd;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				if (l_errcd.equals("S"))
				{
					l_eclaims_header_log = UpdateEClaimsHeaderDetails(params);
					if (l_eclaims_header_log.indexOf("Error")>=0)
					{
						l_errcd = "E";
						l_errmsg = l_eclaims_header_log;
					}
                    l_response_return = l_eclaims_header_log;
					l_app_msg = "Eclaims Header Log... "+l_eclaims_header_log;
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				}
				l_app_msg = "Error Status... "+l_errcd;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = "Inserting Interface Audit data...";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
				
				l_interactive_log = UpdateInteractiveDetails(params);
				if (l_interactive_log.indexOf("Error")>=0)
				{
					l_errcd = "E";
					l_errmsg = l_interactive_log;
				}
                l_response_return = l_interactive_log;
				l_app_msg = "Interactive Log... "+l_interactive_log+ " - Error Status... "+l_errcd;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				if (l_errcd.equals("S"))
				{
					l_eclaims_header_log = UpdateEClaimsHeaderDetails(params);
					if (l_eclaims_header_log.indexOf("Error")>=0)
					{
						l_errcd = "E";
						l_errmsg = l_eclaims_header_log;
					}
                    l_response_return = l_eclaims_header_log;
					l_app_msg = "Eclaims Header Log... "+l_eclaims_header_log;
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				}
				l_app_msg = "Error Status... "+l_errcd;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			}
			catch (Exception e)
			{
				l_errcd = "E";
				l_errmsg = "Error in (UpdateDuplicateClaim) "+ e.getMessage();
				l_response_return = l_errmsg;
			}
			finally {
				closeDBResources(rs, pstmt, dbConn);	
			}
			return l_response_return;
	}

	public CLOB stringToClob(String stringData, Connection Conn) 
	{
        CLOB clob = null;

        try 
		{
            clob = oracle.sql.CLOB.createTemporary(Conn, false, CLOB.DURATION_SESSION);
            clob.setString(1, stringData);
        } catch (SQLException sqlException) {
            System.out.println("Exception thrown in stringtoClob function... SQL Exception... " + sqlException.getMessage());
        }
 
        return clob;
	}
}
