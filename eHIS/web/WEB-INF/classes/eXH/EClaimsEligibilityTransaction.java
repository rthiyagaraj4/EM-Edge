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
import eXH.XHUtil;

import webbeans.eCommon.ConnectionManager;
import org.apache.commons.lang.StringEscapeUtils;

public class EClaimsEligibilityTransaction 
{

	//Class variables 
	public static final String l_segment_id = "ELC";
	public static final String l_standard_code = "ECLASTD";	

	public static final String l_field_separator= "$!^";

	public static String l_debug_YN = "N";

	public static Connection dbConn =  null;

	public String l_errcd = "S";
    public String l_errmsg = "";
    public String l_ack_text = "";	
    public String l_errorCode = "";
	
	static boolean stopRequested = false;

	//public String actionKey = "<PATIENT_ID>LD00000083$!^<ENCOUNTER_ID>$!^<REQUEST>IDC$!^<REQUEST_TYPE>ELCREQ$!^<MEMBER_ID>7011275294080$!^<DEPD_CODE>1$!^<DEPD_RELN>1$!^<CUST_CD>603174$!^<DEST_CD>603174$!^<USER>SETHU$!^<FACILITY_ID>LD$!^<TRANS_ID>$!^";
	//public String actionKey = "<PATIENT_ID>LD00000083$!^<ENCOUNTER_ID>$!^<REQUEST>IDC$!^<REQUEST_TYPE>ELCRES$!^<MEMBER_ID>7011275294080$!^<DEPD_CODE>1$!^<DEPD_RELN>1$!^<CUST_CD>603174$!^<DEST_CD>603174$!^<USER>SETHU$!^<FACILITY_ID>LD$!^<TRANS_ID>5$!^";

	public String ProcessRequest(String profileId, String applicationId, String actionKey){

		String l_app_msg = "";
		String l_request = "", l_request_type = "", l_response_str = "";

		//Connection dbConn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;

		String query = "", l_debug_yn = "";

		l_app_msg = " ::: Inside TransRequestMethod ::: ";
		System.out.println(l_app_msg);		
		System.out.println("::: actionKey : "+actionKey);
		try
		{
			
			
			dbConn =  ConnectionManager.getConnection();
			query = "select NVL(DEBUG_YN, 'N') DEBUG_YN FROM XH_PARAM " ;
			System.out.println("::: XH_PARAM query : "+query);

			pstmt = dbConn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
			   l_debug_yn = rs.getString("DEBUG_YN");
			}
            l_debug_YN = l_debug_yn;
			System.out.println("::: XH_PARAM l_debug_yn : "+l_debug_yn);

		}
		catch(Exception e)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + e.getMessage() ;
			e.printStackTrace();
			System.out.println("::: XH_PARAM l_debug_yn : "+l_debug_yn);
		}
		finally
		{
			XHUtil.closeDBResources(rs, pstmt, null);
		}
		l_app_msg = " ::: Fetching Request... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_request = FetchFieldValue(actionKey, "<REQUEST>", null, l_field_separator, "TransRequestMethod");
		if (l_request.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_request;
		}
		l_app_msg = " ::: l_request : "+l_request;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_app_msg = " ::: Fetching Request Type... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_request_type = FetchFieldValue(actionKey, "<REQUEST_TYPE>", null, l_field_separator, "TransRequestMethod");
		if (l_request_type.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_request_type;
		}
		l_app_msg = " ::: l_request_type : "+l_request_type;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		if (l_request_type.equals("ELCREQ"))
		{
			l_response_str = GenerateRequestXML(applicationId, actionKey);
		}
		if (l_request_type.equals("ELCRES"))
		{
			l_response_str = FetchResponseXML(applicationId, actionKey);
		}
		if (l_request_type.equals("ELCUPD"))
		{
			l_response_str = SetPatientDetails(applicationId, actionKey);
		}
			return l_response_str;
	}	
	
	public String GenerateRequestXML(String applicationId, String actionKey){
		String l_app_msg = "";
		String l_trans_value = "";

		int l_trans_id = 0;

		String l_patient_id = "", l_encounter_id = "", l_request = "", l_request_type = "", l_user_id = "", l_facility_id = "", l_cust_code = "", l_dest_code = "", l_episode_type = "", l_wca_num = "",l_auth_num="", l_episode_id = "", l_visit_id = "",l_admission_type = "";
		String l_xml_string = "", l_request_msg = "", l_response_msg = "", l_response_str = "", l_response_return = "";
		String l_member_id = "",  l_depd_code = "", l_depd_reln = "",l_surname = "",l_initial = "";

		String l_blng_grp_id = "",  l_settlement_ind = "";

		String l_file_type = "", l_file_id = "", l_case_nbr = "";

		String l_request_date = "", l_file_name = "", l_file_directory = "", l_file_directory_requested = "";

		String l_write_log = "", l_interactive_log = "", l_eclaims_log = "", l_eclaims_status_log = "", l_workstation_id = "";

		String l_response_status = "", l_response_file_type = "", l_response_file_name = "", l_response = "";
        String l_res_type = "",l_warn_code = "",l_warn_desc = "",l_trans_num = "", l_approval_status = "",l_rej_code = "",l_rej_desc = "",l_mem_num = "";

		java.sql.Timestamp sqlDate = null;

		HashMap<String, Comparable<String>> reqParams = null;

		int l_error_count = 0;
		String l_msg_format = "", l_error_code_desc = "", l_error_code = "", l_error_desc = "",l_pc_number = "", l_ws_number = "" ;
			
		l_app_msg = "Inside GenerateRequestXML...";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_app_msg = " ::: Fetching Patient ID ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_patient_id = FetchFieldValue(actionKey,"<PATIENT_ID>",null,l_field_separator, "TransRequestMethod");
		if (l_patient_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_patient_id ;
		}
		l_app_msg = " ::: l_patient_id : "+l_patient_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = " ::: Fetching Encounter ID ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	


		l_encounter_id = FetchFieldValue(actionKey,"<ENCOUNTER_ID>",null,l_field_separator, "TransRequestMethod");
		if (l_encounter_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_encounter_id ;
		}
		l_app_msg = " ::: l_encounter_id : "+l_encounter_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = " ::: Fetching Episode ID ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_episode_id = FetchFieldValue(actionKey,"<EPISODE_ID>",null,l_field_separator, "TransRequestMethod");
		if (l_episode_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_episode_id ;
		}
		l_app_msg = " ::: l_episode_id : "+l_episode_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = " ::: Fetching Episode Type... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_episode_type = FetchFieldValue(actionKey,"<EPISODE_TYPE>",null,l_field_separator, "TransRequestMethod");
		if (l_episode_type.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_episode_type ;
		}
		l_app_msg = " ::: l_episode_type : "+l_episode_type;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = " ::: Fetching Visit ID... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_visit_id = FetchFieldValue(actionKey,"<VISIT_ID>",null,l_field_separator, "TransRequestMethod");
		if (l_visit_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_visit_id ;
		}
		l_app_msg = " ::: l_visit_id : "+l_visit_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = " ::: Fetching Request... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_request = FetchFieldValue(actionKey, "<REQUEST>", null, l_field_separator, "TransRequestMethod");
		if (l_request.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_request;
		}
		l_app_msg = " ::: l_request : "+l_request;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_app_msg = " ::: Fetching Request Type... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_request_type = FetchFieldValue(actionKey, "<REQUEST_TYPE>", null, l_field_separator, "TransRequestMethod");
		if (l_request_type.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_request_type;
		}
		l_app_msg = " ::: l_request_type : "+l_request_type;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);		
		
		l_app_msg = " ::: Fetching User ID ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_user_id = FetchFieldValue(actionKey,"<USER>",null,l_field_separator, "TransRequestMethod");
		if (l_user_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_user_id;
		}
		l_app_msg = " ::: l_user_id : "+l_user_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = " ::: Fetching Workstation ID ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_workstation_id = FetchFieldValue(actionKey,"<WS_NO>",null,l_field_separator, "TransRequestMethod");
		if (l_workstation_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_workstation_id;
		}
		l_app_msg = " ::: l_workstation_id : "+l_workstation_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = " ::: Fetching Facility ID ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_facility_id = FetchFieldValue(actionKey,"<FACILITY_ID>",null,l_field_separator, "TransRequestMethod");
		if (l_facility_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_facility_id;
		}
		l_app_msg = " ::: l_facility_id : "+l_facility_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = " ::: Fetching Customer Code... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_cust_code = FetchFieldValue(actionKey, "<CUST_CD>", null, l_field_separator, "TransRequestMethod");
		if (l_cust_code.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_cust_code;
		}
		l_app_msg = " ::: l_cust_code : "+l_cust_code;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_app_msg = " ::: Fetching Billing Group ID... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_blng_grp_id = FetchFieldValue(actionKey, "<BLNG_GRP_ID>", null, l_field_separator, "TransRequestMethod");
		if (l_blng_grp_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_blng_grp_id;
		}
		l_app_msg = " ::: l_blng_grp_id : "+l_blng_grp_id;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_app_msg = " ::: Fetching Settlement Index... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_settlement_ind = FetchFieldValue(actionKey, "<SETTLEMENT_IND>", null, l_field_separator, "TransRequestMethod");
		if (l_settlement_ind.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_settlement_ind;
		}
		l_app_msg = " ::: l_settlement_ind : "+l_settlement_ind;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_app_msg = " ::: Fetching Destination Code... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_dest_code = FetchFieldValue(actionKey, "<DEST_CD>", null, l_field_separator, "TransRequestMethod");
		if (l_dest_code.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_dest_code;
		}
		l_app_msg = " ::: l_dest_code : "+l_dest_code;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_app_msg = " ::: Fetching Member ID... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_member_id = FetchFieldValue(actionKey, "<MEMBER_ID>", null, l_field_separator, "TransRequestMethod");
		if (l_member_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_member_id;
		}
		l_app_msg = " ::: l_member_id : "+l_member_id;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_app_msg = " ::: Fetching Surname... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_surname = FetchFieldValue(actionKey, "<SURNAME>", null, l_field_separator, "TransRequestMethod");
		if (l_surname.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_surname;
		}
		l_app_msg = " ::: l_surname : "+l_surname;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_app_msg = " ::: Fetching Initial... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_initial = FetchFieldValue(actionKey, "<INITIAL>", null, l_field_separator, "TransRequestMethod");
		if (l_initial.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_initial;
		}
		l_app_msg = " ::: l_initial : "+l_initial;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_app_msg = " ::: Fetching Depd Code... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_depd_code = FetchFieldValue(actionKey, "<DEPD_CODE>", null, l_field_separator, "TransRequestMethod");
		if (l_depd_code.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_depd_code;
		}
		l_app_msg = " ::: l_depd_code : "+l_depd_code;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_app_msg = " ::: Fetching Depd reln... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_depd_reln = FetchFieldValue(actionKey, "<DEPD_RELN>", null, l_field_separator, "TransRequestMethod");
		if (l_depd_reln.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_depd_reln;
		}
		l_app_msg = " ::: l_depd_reln : "+l_depd_reln;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_app_msg = " ::: Fetching WCA Number... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_wca_num = FetchFieldValue(actionKey, "<WCA_NUM>", null, l_field_separator, "TransRequestMethod");
		if (l_wca_num.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_wca_num;
		}
		l_app_msg = " ::: l_wca_num : "+l_wca_num;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		
		 l_app_msg = " ::: Fetching Update Type ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_admission_type = FetchFieldValue(actionKey,"<ADMISSION_TYPE>",null,l_field_separator, "TransRequestMethod");
		if (l_admission_type.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_admission_type ;
		}
		l_app_msg = " ::: l_admission_type : "+l_admission_type;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = " ::: Calling FetchXMLFormat ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		if (l_errcd.equals("S"))
		{
			l_xml_string = FetchXMLFormat(l_request, applicationId, "XML");
			if (l_xml_string.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_xml_string;
			}
			l_app_msg = " ::: XML String Generated : "+l_xml_string;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		}

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
				l_trans_id = Integer.parseInt(l_trans_value);
			}	
		}

		l_app_msg = " ::: Calling Request Mesage Build Method... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		if (l_errcd.equals("S"))
		{
			l_request_msg = CreateXMLMessage(l_request, actionKey, l_patient_id, l_trans_value, l_xml_string);
			if (l_request_msg.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_request_msg;
			}
			l_app_msg = "::: l_request_msg : "+l_request_msg;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		}

		l_app_msg = "Calling Fetch Protocol Method...";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		if (l_errcd.equals("S"))
		{
			l_file_directory = FetchProtocolDetails("ECLAIMSPL");
			if (l_file_directory.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_file_directory;
			}
			l_app_msg = " ::: File  Directory : "+l_file_directory;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		}

		l_app_msg = "Calling Create File Name Method...";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		if (l_errcd.equals("S"))
		{
			if (!(l_episode_id.length() > 0))
			{
				l_file_type = "P";
				l_file_id = l_patient_id;
			}
			else
			{
				l_file_type = "A";
				l_file_id = l_episode_id;
			}

			l_case_nbr = l_request + l_file_type + l_file_id;

			l_request_msg = l_request_msg.replaceAll("#authNo",l_wca_num);	
			l_request_msg = l_request_msg.replaceAll("#caseNo",l_case_nbr);			

			l_app_msg = "::: L_REQUEST_MSG after replace case number ::: "+l_request_msg;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_file_name = CreateFileName(l_request_type, l_trans_value, l_case_nbr,l_facility_id);
			if (l_file_name.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_file_name;
			}
			l_app_msg = " ::: File Name : "+l_file_name;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		}

		l_app_msg = "Calling Write File Method - Error Status... "+l_errcd ;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		if (l_errcd.equals("S"))
		{
			l_write_log = WriteFile(l_file_name, l_file_directory, l_request_msg);
			if (l_write_log.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_write_log;
			}
			l_app_msg = " ::: l_write_log : "+l_write_log;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		}

		l_app_msg = "Calling Write File into Requested folder Method - Error Status... "+l_errcd ;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		if (l_errcd.equals("S"))
		{

			l_file_directory_requested = l_file_directory + File.separator + "Requested";

			l_app_msg = " ::: File Directory Requested : "+l_file_directory_requested;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_write_log = WriteFile(l_file_name, l_file_directory_requested, l_request_msg);
			if (l_write_log.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_write_log;
			}
			l_app_msg = " ::: l_write_log : "+l_write_log;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		}

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
		}

		l_app_msg = "::: l_request_date : "+sqlDate;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = "Setting  reqParams value...";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		try
		{		

			reqParams = new HashMap<String, Comparable<String>>();
			reqParams.put("LOGIN_USER", l_user_id);
			reqParams.put("CLIENT_MACHINE", l_workstation_id); 
			reqParams.put("PGM_ID", "ECLAIMS");
			reqParams.put("MODULE_ID", "XB");
			reqParams.put("SESSION_ID", l_request_type);

			reqParams.put("MSG_ID", l_trans_value);
			reqParams.put("REQUEST_DATE", sqlDate.toString()); 
			reqParams.put("REQUEST_TEXT", l_request_msg); 
			reqParams.put("APPLICATION_ID", applicationId);
			reqParams.put("FACILITY_ID", l_facility_id);
			reqParams.put("MESSAGE_DATE", sqlDate.toString()); 
			reqParams.put("EVENT_TYPE", l_request);
			reqParams.put("PATIENT_ID", l_patient_id);
			reqParams.put("ADMISSION_TYPE", l_admission_type);
			if (!(l_episode_type.length() > 0))
			{
				l_episode_type = "XXX";
			}

			reqParams.put("EPISODE_TYPE", l_episode_type);
			if (!(l_encounter_id.length() > 0))
			{
				l_encounter_id = "XXX";
			}
			reqParams.put("ENCOUNTER_ID", l_encounter_id);
			
			if (!(l_episode_id.length() > 0))
			{
				l_episode_id = "XXX";
			}
			reqParams.put("EPISODE_ID", l_episode_id);

			if (!(l_visit_id.length() > 0))
			{
				l_visit_id = "XXX";
			}
			reqParams.put("VISIT_ID", l_visit_id);
			
			reqParams.put("ACC_NO", actionKey);
			reqParams.put("EXT_ACC_NO", "");
			reqParams.put("REQUEST_SYNTAX", actionKey);
			reqParams.put("ACK_MSG_ID", "");
			reqParams.put("PROTOCOL_LINK_ID", "ECLAIMSPL");
			reqParams.put("ADDED_BY_ID", l_user_id); 
			reqParams.put("ADDED_BY_DATE", sqlDate.toString()); 
			reqParams.put("MODIFIED_BY_ID", l_user_id); 
			reqParams.put("MODIFIED_BY_DATE", sqlDate.toString()); 
			reqParams.put("ADDED_BY_FACILITY", l_facility_id);
			reqParams.put("MODIFIED_BY_FACILITY", l_facility_id);
			reqParams.put("RESPONSE_TEXT", ""); 
			reqParams.put("RESPONSE_SYNTAX", "");
			reqParams.put("PROFILE", ""); 
			reqParams.put("ERROR_TEXT", ""); 
			reqParams.put("ACK_TEXT", "");
			reqParams.put("ACK_SYNTAX", "");
			
			if (!(l_cust_code.length() > 0))
			{
				l_cust_code = "XXX";
			}

			reqParams.put("CUST_CODE", l_cust_code);
			reqParams.put("DEST_CODE", l_dest_code);
			reqParams.put("MEMBERSHIP_NUM", l_member_id);
			reqParams.put("M_SURNAME", l_surname);
			reqParams.put("M_INITIAL", l_initial);
			reqParams.put("DEPD_CODE", l_depd_code);
			reqParams.put("DEPD_RELN", l_depd_reln);
			reqParams.put("INPUT_FILE_NAME", l_file_name);	
			reqParams.put("CASE_NUM", l_case_nbr);
			reqParams.put("CLAIM_NUM", l_trans_value);

			if (!(l_blng_grp_id.length() > 0))
			{
				l_blng_grp_id = "XXX";
			}

			reqParams.put("BLNG_GRP_ID", l_blng_grp_id);
			reqParams.put("SETTLEMENT_IND", l_settlement_ind);
			if (!(l_wca_num.length() > 0))
			{
				l_wca_num = "XXX";
			}
			reqParams.put("WCA_NUM", l_wca_num);

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
			
			l_eclaims_log = UpdateEClaimsDetails(reqParams);
			if (l_eclaims_log.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_eclaims_log;
			}

			l_app_msg = " ::: l_eclaims_log : "+l_eclaims_log;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		}
		catch (Exception e)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + " - "+ e.getMessage();
		}	

		l_app_msg = "Calling GetResponseMessage...";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		l_response_msg = GetResponseMessage(l_request, l_trans_value,l_request_type, l_case_nbr,l_facility_id);
		if (l_response_msg.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_response_msg;
		}

		l_response_msg = l_response_msg.replaceAll("INCOME ESTIMATOR","INCOME_ESTIMATOR");	
		
		l_app_msg = "::: Getting Response Message at Line 558 : "+l_response_msg+ " ::: l_errcd : "+l_errcd;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

		reqParams.put("FILE_NAME_FOR_NRL_RESP", "XXX");
		reqParams.put("INBOUND_XML_REPLY", "XXX");
		reqParams.put("FILE_NAME_FOR_REJ_RESP", "XXX");	
		reqParams.put("INBOUND_XML_REJ", "XXX");
		reqParams.put("FILE_NAME_FOR_FAILED_RESP", "XXX");
		reqParams.put("INBOUND_XML_FAIL", "XXX");	
		reqParams.put("REQUEST_STATUS", "XXX");
		reqParams.put("REPONSE_SYNTAX", "XXX");

		l_app_msg = " ::: Fetching Response Details... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		reqParams.put("REPONSE_SYNTAX", l_response_msg);

		l_app_msg = " ::: Fetching Status... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_response_status = FetchFieldValue(l_response_msg, "<STATUS>", null, l_field_separator, "TransRequestMethod");
		if (l_response_status.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_response_status;
		}
		l_app_msg = " ::: l_response_status : "+l_response_status;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_app_msg = " ::: Fetching Response File Type... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_response_file_type = FetchFieldValue(l_response_msg, "<FILE_TYPE>", null, l_field_separator, "TransRequestMethod");
		if (l_response_file_type.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_response_file_type;
		}
		l_app_msg = " ::: l_response_file_type : "+l_response_file_type;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_app_msg = " ::: Fetching Response File Name... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_response_file_name = FetchFieldValue(l_response_msg, "<FILE_NAME>", null, l_field_separator, "TransRequestMethod");
		if (l_response_file_name.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_response_file_name;
		}
		l_app_msg = " ::: l_response_file_name : "+l_response_file_name;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_app_msg = " ::: Fetching Response Message... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_response = FetchFieldValue(l_response_msg, "<RESPONSE>", null, l_field_separator, "TransRequestMethod");
		if (l_response.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_response;

		}
		l_app_msg = " ::: l_response : "+l_response;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);		

		reqParams.put("REQUEST_STATUS", l_response_status);
		reqParams.put("WARN_CODE", "XXX");
		reqParams.put("WARN_DESC", "XXX");
		reqParams.put("REJ_CODE", "XXX");
		reqParams.put("REJ_DESC", "XXX");
		reqParams.put("AUTHORIZATION_NUM", "XXX");
		reqParams.put("APPROVAL_STATUS", "XXX");

		if (l_response_status.equals("09"))
		{
			reqParams.put("APPROVAL_STATUS", "99");
		}		
		
		if (l_errcd.equals("S") && !l_response_status.equals("09") && l_response_file_name.toLowerCase().indexOf("fail") ==-1)
		{

			l_app_msg = " ::: Fetching Approval Status... ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);				

			l_approval_status = parseResponseXml(l_response,"TX","res");
			if (l_approval_status.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_approval_status;
			}
			else
				reqParams.put("APPROVAL_STATUS", l_approval_status);

			l_app_msg = " ::: l_approval_status : "+l_approval_status;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);


			l_app_msg = " ::: Fetching Authorization Number... ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_auth_num = parseResponseXml(l_response,"AUTHS","hnet");

			l_app_msg = " ::: l_auth_num : "+l_auth_num;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			l_app_msg = " ::: l_wca_num : "+l_wca_num;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			if (l_response_str.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_response_str;
			}
			else
			{			
				l_errcd = "S";
				l_errmsg  = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_response_str;

				/*
				if(l_wca_num.equals("XXX") || l_wca_num.length()<=0){
					reqParams.put("AUTHORIZATION_NUM", l_auth_num);					
				}
				else{
					reqParams.put("AUTHORIZATION_NUM", l_wca_num);					
				}
				*/

				reqParams.put("AUTHORIZATION_NUM", l_auth_num);	
			}
            
			l_app_msg = " ::: Updating Authorization Details... ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_response_str = UpdateAuthorizationDetails(reqParams);				
			l_app_msg = " ::: Update Authorization Details l_response_str: "+ l_response_str;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg); 				
			if (l_response_str.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg  = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_response_str;
			}

			l_app_msg = " ::: l_errmsg : "+l_errmsg;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);				
		}			

		if (l_response_file_type.equals("ELCREP"))
		{
			reqParams.put("FILE_NAME_FOR_NRL_RESP", l_response_file_name);
			reqParams.put("INBOUND_XML_REPLY", l_response);
		}
		if (l_response_file_type.equals("ELCREJ"))
		{
			reqParams.put("FILE_NAME_FOR_REJ_RESP", l_response_file_name);
			reqParams.put("INBOUND_XML_REJ", l_response);
		}
		if (l_response_file_type.equals("ELCFAI"))
		{
			reqParams.put("FILE_NAME_FOR_FAILED_RESP", l_response_file_name);
			reqParams.put("INBOUND_XML_FAIL", l_response);
		}
		
		/*************/
		
		reqParams.put("ACKNOWLEDGEMENT_TEXT", "XXX");

		if (l_errcd.equals("S") && !(l_response_status.equals("09")) )
		{
			if(l_response_file_name.toLowerCase().indexOf("fail") >=0)
			{
					if(l_response.length() > 0)
					{
						l_approval_status = "F";

						l_pc_number = l_response.substring(0, 2);
						l_app_msg = " ::: l_pc_number : "+l_pc_number;
						if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

						l_ws_number =l_response.substring(2, 5);
						l_app_msg = " ::: l_ws_number : "+l_ws_number;
						if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

						l_msg_format =l_response.substring(5, 7);
						l_app_msg = " ::: l_msg_format : "+l_msg_format;
						if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

						l_error_count =Integer.parseInt(l_response.substring(7, 9));
						l_app_msg = " ::: l_error_count : "+l_error_count;
						if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

						l_error_code_desc = l_response.substring(9, l_response.length());
						l_app_msg = " ::: l_error_code_desc : "+l_error_code_desc;
						if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
						int start = 0;
						int end = 0;

						for (int i=0;i< l_error_count; i++)
						{
							start = end;
							end = end+4;

							l_error_code += l_error_code_desc.substring(start, end)+"##";
							l_app_msg = " ::: l_error_code : "+l_error_code;
							if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

                            start = end;
							end = end+19;

							l_error_desc += l_error_code_desc.substring(start,end)+"##";
							l_app_msg = " ::: l_error_desc : "+l_error_desc;
							if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
							
							l_app_msg = " ::: start : "+start;
							if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
							l_app_msg = " ::: end : "+end;
							if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

						}

						l_app_msg = " ::: l_errmsg : "+l_errmsg;
						if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
						l_res_type = "Failed";

						l_mem_num = l_member_id;
						
						l_response_str = l_pc_number+"$!^"+l_ws_number+"$!^"+l_msg_format+"$!^"+l_error_count+"$!^"+l_error_code+"$!^"+l_approval_status+"$!^"+l_mem_num+"$!^"+l_error_desc+"$!^"+l_res_type+"$!^";
						l_response_return = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_response_str;

						reqParams.put("ACKNOWLEDGEMENT_TEXT", l_response);
						reqParams.put("APPROVAL_STATUS", l_approval_status);
					}
					else{
						l_response_str = "Error in Reading the file - No Response found";
						l_errcd = "E";
						l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_response_str;

					}
				}
            else
			{
				l_app_msg = " ::: Fetching Claim Number... ";
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);				

				l_case_nbr = parseResponseXml(l_response,"TX","case_nbr");
				if (l_case_nbr.indexOf("Error")>=0)
				{
					l_errcd = "E";
					l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_case_nbr;
				}
				l_app_msg = " ::: l_case_nbr : "+l_case_nbr;
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

				l_app_msg = " ::: Fetching Response Type... ";
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

				if (l_approval_status.equals("A"))
				{
					l_res_type = "Authorized";
				}
				else if (l_approval_status.equals("R"))
				{
					l_res_type = "Rejected";
				}
				else if (l_approval_status.equals(""))
				{
					l_res_type = "";
				}

				l_app_msg = "Calling ParseResponseXml...";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				if(l_approval_status.equals("A"))
				{
					l_app_msg = " ::: Fetching Res Member number... ";
					if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

					l_mem_num = parseResponseXml(l_response,"MEM","ch_id");
					if (l_warn_code.indexOf("Error")>=0)
					{
						l_errcd = "E";
						l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_mem_num;
					}
					
					l_app_msg = " ::: l_mem_num : "+l_mem_num;
					if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

					if(!(l_mem_num.length()>0)){
						l_mem_num = l_member_id;
					}

					if(l_request.equals("IEC") )
					{	
						
						l_app_msg = " ::: l_res_type : "+l_res_type;
						if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);				
						
						l_app_msg = " ::: Fetching warn Code... ";
						if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

						l_warn_code = parseResponseXml(l_response,"WARN","cd");
						if (l_warn_code.indexOf("Error")>=0)
						{
							l_errcd = "E";
							l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_warn_code;
						}
						l_app_msg = " ::: l_warn_code : "+l_warn_code;
						if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

						l_app_msg = " ::: Fetching warn desc... ";
						if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

						l_warn_desc = parseResponseXml(l_response,"WARN","desc");
						if (l_warn_desc.indexOf("Error")>=0)
						{
							l_errcd = "E";
							l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_warn_desc;
						}
						l_app_msg = " ::: l_warn_desc : "+l_warn_desc;
						if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

						l_app_msg = " ::: Fetching transaction reference number... ";
						if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

						l_trans_num = parseResponseXml(l_response,"TX","tx_nbr");
						if (l_trans_num.indexOf("Error")>=0)
						{
							l_errcd = "E";
							l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_auth_num;
						}
						l_app_msg = " ::: l_trans_num : "+l_trans_num;
						if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg); 

						if (l_errcd.equals("S"))
						{
						   l_response_str = l_case_nbr+"$!^"+l_res_type+"$!^"+l_warn_code+"$!^"+l_warn_desc+"$!^"+l_auth_num+"$!^"+l_approval_status+"$!^"+l_mem_num;
						   l_response_return = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_response_str;

						   reqParams.put("ACKNOWLEDGEMENT_TEXT", l_response_str);
						   reqParams.put("WARN_CODE", l_warn_code);
						   reqParams.put("WARN_DESC", l_warn_desc);

						}

					}
					else if (l_request.equals("UEC"))
					{
						l_app_msg = " ::: Updating Emp Details... ";
						if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

						l_response_str = updateEmpDetails(l_request, l_response,actionKey,l_trans_value,l_patient_id);
						if (l_response_str.indexOf("Error")>=0)
						{
							l_errcd = "E";
							l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_response_str;
						}
						l_app_msg = " ::: l_response_str : "+l_response_str;
						if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

						 l_response_str = l_case_nbr+"$!^"+l_res_type+"$!^"+l_warn_code+"$!^"+l_warn_desc+"$!^"+l_auth_num+"$!^"+l_approval_status+"$!^"+l_mem_num;
						 l_response_return = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_response_str;
					}
					else
					{
						l_response_str = ParseResponseMessage(l_request, l_response,actionKey);
						if (l_response_str.indexOf("Error")>=0)
						{
							l_errcd = "E";
							l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_response_str;
						}
						else
						{
							l_errcd = "S";
							l_response_return = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^"+l_case_nbr+"$!^"+l_res_type+"$!^"+l_response_str+"$!^"+l_warn_desc+"$!^"+l_auth_num+"$!^"+l_approval_status+"$!^"+l_mem_num;
							//l_response_return = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_response_str+ "$!^" +l_auth_num+"$!^"+l_approval_status+"$!^"+l_claims_num+"$!^"+l_res_type;
							reqParams.put("ACKNOWLEDGEMENT_TEXT", l_response_str);
						}		
					}
				}
				if (l_approval_status.equals("R"))
				{
					l_app_msg = " ::: l_res_type : "+l_res_type;
						if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);				
						
						l_app_msg = " ::: Fetching Rej Code... ";
						if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

						l_rej_code = parseResponseXml(l_response,"RJ","cd");
						if (l_rej_code.indexOf("Error")>=0)
						{
							l_errcd = "E";
							l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_rej_code;
						}
						l_app_msg = " ::: l_rej_code : "+l_rej_code;
						if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

						l_app_msg = " ::: Fetching Rej desc... ";
						if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

						l_rej_desc = parseResponseXml(l_response,"RJ","desc");
						if (l_warn_desc.indexOf("Error")>=0)
						{
							l_errcd = "E";
							l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_rej_desc;
						}
						l_app_msg = " ::: l_rej_desc : "+l_rej_desc;
						if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

						l_app_msg = " ::: Fetching transaction reference number... ";
						if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

						l_trans_num = parseResponseXml(l_response,"TX","tx_nbr");
						if (l_trans_num.indexOf("Error")>=0)
						{
							l_errcd = "E";
							l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_auth_num;
						}
						l_app_msg = " ::: l_trans_num : "+l_trans_num;
						if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg); 

						if (l_errcd.equals("S"))
						{
						   l_response_str = l_case_nbr+"$!^"+l_res_type+"$!^"+l_rej_code+"$!^"+l_rej_desc+"$!^"+l_auth_num+"$!^"+l_approval_status+"$!^"+l_mem_num;
						   l_response_return = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_response_str;

						   reqParams.put("ACKNOWLEDGEMENT_TEXT", l_response_str);
						   reqParams.put("REJ_CODE", l_warn_code);
						   reqParams.put("REJ_DESC", l_warn_desc);
						}
				}

				l_eclaims_status_log = ParseClaimsStatus(l_response, reqParams);
				if (l_eclaims_status_log.indexOf("Error")>=0)
				{
					l_errcd = "E";
				}
				
				l_app_msg = "::: l_eclaims_status_log : "+l_eclaims_status_log;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			}	 
		}

		reqParams.put("RESPONSE_TEXT", l_response);		
		reqParams.put("STATUS", l_errcd);	
		reqParams.put("ERROR_MESSAGE", l_errmsg);

		l_app_msg = "Updating Interface Audit data...";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		
		l_interactive_log = UpdateInteractiveDetails(reqParams);
		if (l_interactive_log.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_interactive_log;
		}
		l_app_msg = "::: l_interactive_log : "+l_interactive_log;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		l_app_msg = "Updating EClaims data...";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		
		l_eclaims_log = UpdateEClaimsDetails(reqParams);
		if (l_eclaims_log.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_eclaims_log;
		}
		l_app_msg = "::: l_eclaims_log : "+l_eclaims_log;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

		/*

		l_eclaims_status_log = ParseClaimsStatus(l_response, reqParams);
		if (l_eclaims_status_log.indexOf("Error")>=0)
		{
			l_errcd = "E";
		}
		
		l_app_msg = "::: l_eclaims_status_log : "+l_eclaims_status_log;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

		*/

		l_app_msg = "::: Sethu Status : "+l_errcd;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

		if ((l_errcd.equals("S")) || (l_errcd.equals("E") && l_response_status.equals("09")))
		{
			try
			{
				dbConn.commit();
			}
			catch (Exception e)
			{
				l_app_msg = "::: Error in Commiting the data updated : "+e.getMessage();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			}
			finally
			{			
				closeDBResources(null, null, dbConn);			
			}
		}
		else
		{
			try
			{
				dbConn.rollback();
			}
			catch (Exception e)
			{
				l_app_msg = "::: Error in rollback the data updated : "+e.getMessage();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			}
			finally
			{			
				closeDBResources(null, null, dbConn);	
				reqParams.clear();
			}
		}

		if (l_errcd.equals("S"))
		{
			return l_response_return;
		}
		else
		{
			return l_errmsg;
		}
		
	}	

	public String FetchResponseXML(String applicationId, String actionKey){
		String l_app_msg = "";
		String l_trans_value = "";

		String l_patient_id = "", l_encounter_id = "", l_request = "", l_request_type = "", l_user_id = "", l_facility_id = "", l_cust_code = "", l_dest_code = "", l_workstation_id = "",l_auth_num = "", l_episode_id = "", l_visit_id = "", l_episode_type = "",l_admission_type = "";
		String l_response_msg = "", l_response_str = "", l_response_return = "";

		String l_blng_grp_id = "",  l_settlement_ind = "";

		String l_request_date = "", l_file_name = "";

		String l_file_type = "", l_file_id = "", l_case_nbr = "";

		String l_interactive_log = "", l_eclaims_log = "", l_eclaims_status_log = "";
		String l_res_type = "",l_warn_code = "",l_warn_desc = "",l_trans_num = "", l_approval_status = "",l_rej_code = "",l_rej_desc = "";

		String l_response_status = "", l_response_file_type = "", l_response_file_name = "",l_member_id = "", l_response = "",l_surname = "",l_initial = "",l_mem_num = "",l_depd_code = "",l_depd_reln = "",l_wca_num = "";

		java.sql.Timestamp sqlDate = null;

		int l_pc_number = 0, l_ws_number = 0, l_error_count = 0;
		String l_msg_format = "", l_error_code_desc = "", l_error_code = "", l_error_desc = "";

		HashMap<String, Comparable<String>> reqParams = null;
			
		l_app_msg = "Inside FetchResponseXML...";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_app_msg = " ::: Fetching Transaction Value... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_trans_value = FetchFieldValue(actionKey, "<TRANS_ID>", null, l_field_separator, "TransRequestMethod");
		if (l_trans_value.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" +"$!^" + l_app_msg + "$!^" + l_trans_value;
		}
		l_app_msg = " ::: l_trans_value : "+l_trans_value;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_app_msg = " ::: Fetching Patient ID ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_patient_id = FetchFieldValue(actionKey,"<PATIENT_ID>",null,l_field_separator, "TransRequestMethod");
		if (l_patient_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_patient_id;
		}
		l_app_msg = " ::: l_patient_id : "+l_patient_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = " ::: Fetching Encounter ID ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_encounter_id = FetchFieldValue(actionKey,"<ENCOUNTER_ID>",null,l_field_separator, "TransRequestMethod");
		if (l_encounter_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_encounter_id;
		}
		l_app_msg = " ::: l_encounter_id : "+l_encounter_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = " ::: Fetching Episode ID ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_episode_id = FetchFieldValue(actionKey,"<EPISODE_ID>",null,l_field_separator, "TransRequestMethod");
		if (l_episode_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_episode_id ;
		}
		l_app_msg = " ::: l_episode_id : "+l_episode_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = " ::: Fetching Episode Type... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_episode_type = FetchFieldValue(actionKey,"<EPISODE_TYPE>",null,l_field_separator, "TransRequestMethod");
		if (l_episode_type.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_episode_type ;
		}
		l_app_msg = " ::: l_episode_type : "+l_episode_type;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = " ::: Fetching Visit ID... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_visit_id = FetchFieldValue(actionKey,"<VISIT_ID>",null,l_field_separator, "TransRequestMethod");
		if (l_visit_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_visit_id ;
		}
		l_app_msg = " ::: l_visit_id : "+l_visit_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	


		l_app_msg = " ::: Fetching Request... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_request = FetchFieldValue(actionKey, "<REQUEST>", null, l_field_separator, "TransRequestMethod");
		if (l_request.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_request;
		}
		l_app_msg = " ::: l_request : "+l_request;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_app_msg = " ::: Fetching Request Type... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_request_type = FetchFieldValue(actionKey, "<REQUEST_TYPE>", null, l_field_separator, "TransRequestMethod");
		if (l_request_type.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_request_type;
		}
		l_app_msg = " ::: l_request_type : "+l_request_type;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);		
		
		l_app_msg = " ::: Fetching User ID ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_user_id = FetchFieldValue(actionKey,"<USER>",null,l_field_separator, "TransRequestMethod");
		if (l_user_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_user_id;
		}
		l_app_msg = " ::: l_user_id : "+l_user_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_workstation_id = FetchFieldValue(actionKey,"<WS_NO>",null,l_field_separator, "TransRequestMethod");
		if (l_workstation_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_workstation_id;
		}
		l_app_msg = " ::: l_workstation_id : "+l_workstation_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = " ::: Fetching Facility ID ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_facility_id = FetchFieldValue(actionKey,"<FACILITY_ID>",null,l_field_separator, "TransRequestMethod");
		if (l_facility_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_facility_id;
		}
		l_app_msg = " ::: l_facility_id : "+l_facility_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = " ::: Fetching Customer Code... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_cust_code = FetchFieldValue(actionKey, "<CUST_CD>", null, l_field_separator, "TransRequestMethod");
		if (l_cust_code.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_dest_code;
		}
		l_app_msg = " ::: l_cust_code : "+l_cust_code;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_app_msg = " ::: Fetching Billing Group ID... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_blng_grp_id = FetchFieldValue(actionKey, "<BLNG_GRP_ID>", null, l_field_separator, "TransRequestMethod");
		if (l_blng_grp_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_blng_grp_id;
		}
		l_app_msg = " ::: l_blng_grp_id : "+l_blng_grp_id;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_app_msg = " ::: Fetching Settlement Index... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_settlement_ind = FetchFieldValue(actionKey, "<SETTLEMENT_IND>", null, l_field_separator, "TransRequestMethod");
		if (l_settlement_ind.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_settlement_ind;
		}
		l_app_msg = " ::: l_settlement_ind : "+l_settlement_ind;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_app_msg = " ::: Fetching Destination Code... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_dest_code = FetchFieldValue(actionKey, "<DEST_CD>", null, l_field_separator, "TransRequestMethod");
		if (l_dest_code.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_dest_code;
		}
		l_app_msg = " ::: l_dest_code : "+l_dest_code;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_app_msg = " ::: Fetching Episode Type... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_member_id = FetchFieldValue(actionKey,"<MEMBER_ID>",null,l_field_separator, "TransRequestMethod");
		if (l_member_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_member_id ;
		}
		l_app_msg = " ::: l_member_id : "+l_member_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = " ::: Fetching Surname... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_app_msg = " ::: Fetching Depd Code... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_depd_code = FetchFieldValue(actionKey, "<DEPD_CODE>", null, l_field_separator, "TransRequestMethod");
		if (l_depd_code.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_depd_code;
		}
		l_app_msg = " ::: l_depd_code : "+l_depd_code;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_app_msg = " ::: Fetching Depd reln... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_depd_reln = FetchFieldValue(actionKey, "<DEPD_RELN>", null, l_field_separator, "TransRequestMethod");
		if (l_depd_reln.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_depd_reln;
		}
		l_app_msg = " ::: l_depd_reln : "+l_depd_reln;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_app_msg = " ::: Fetching WCA Number... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_wca_num = FetchFieldValue(actionKey, "<WCA_NUM>", null, l_field_separator, "TransRequestMethod");
		if (l_wca_num.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_wca_num;
		}
		l_app_msg = " ::: l_wca_num : "+l_wca_num;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);


		l_surname = FetchFieldValue(actionKey, "<SURNAME>", null, l_field_separator, "TransRequestMethod");
		if (l_surname.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_surname;
		}
		l_app_msg = " ::: l_surname : "+l_surname;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_app_msg = " ::: Fetching Initial... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_initial = FetchFieldValue(actionKey, "<INITIAL>", null, l_field_separator, "TransRequestMethod");
		if (l_initial.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_initial;
		}

		l_app_msg = " ::: l_initial : "+l_initial;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		 l_app_msg = " ::: Fetching Update Type ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_admission_type = FetchFieldValue(actionKey,"<ADMISSION_TYPE>",null,l_field_separator, "TransRequestMethod");
		if (l_admission_type.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_admission_type ;
		}
		l_app_msg = " ::: l_admission_type : "+l_admission_type;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = " ::: Calling FetchXMLFormat ... ";
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
		}

		l_app_msg = "::: l_request_date : "+sqlDate;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = "Setting  reqParams value...";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		try
		{
			reqParams = new HashMap<String, Comparable<String>>();
			reqParams.put("LOGIN_USER", l_user_id);
			reqParams.put("CLIENT_MACHINE", l_workstation_id); 
			reqParams.put("PGM_ID", "ECLAIMS");
			reqParams.put("MODULE_ID", "XB");
			reqParams.put("SESSION_ID", l_request_type);

			reqParams.put("MSG_ID", l_trans_value);
			reqParams.put("REQUEST_DATE", sqlDate.toString()); 
			reqParams.put("APPLICATION_ID", applicationId);
			reqParams.put("FACILITY_ID", l_facility_id);
			reqParams.put("MESSAGE_DATE", sqlDate.toString()); 
			reqParams.put("EVENT_TYPE", l_request);
			reqParams.put("PATIENT_ID", l_patient_id);
			reqParams.put("ADMISSION_TYPE", l_admission_type);

			reqParams.put("ADDED_BY_ID", l_user_id); 
			reqParams.put("ADDED_BY_DATE", sqlDate.toString());
			reqParams.put("MODIFIED_BY_ID", l_user_id); 
			reqParams.put("MODIFIED_BY_DATE", sqlDate.toString()); 
			reqParams.put("ADDED_BY_FACILITY", l_facility_id);
			reqParams.put("MODIFIED_BY_FACILITY", l_facility_id);
		
            reqParams.put("MEMBERSHIP_NUM", l_member_id);
			reqParams.put("M_SURNAME", l_surname);
			reqParams.put("M_INITIAL", l_initial);
			reqParams.put("DEPD_CODE", l_depd_code);
			reqParams.put("DEPD_RELN", l_depd_reln);

			reqParams.put("INPUT_FILE_NAME", l_file_name);	
			reqParams.put("CASE_NUM", l_case_nbr);
			reqParams.put("CLAIM_NUM", l_trans_value);

			if (!(l_wca_num.length() > 0))
			{
				l_wca_num = "XXX";
			}
			reqParams.put("WCA_NUM", l_wca_num);


			if (!(l_cust_code.length() > 0))
			{
				l_cust_code = "XXX";
			}

			reqParams.put("CUST_CODE", l_cust_code);
			reqParams.put("DEST_CODE", l_dest_code);
			if (!(l_episode_type.length() > 0))
			{
				l_episode_type = "XXX";
			}

			reqParams.put("EPISODE_TYPE", l_episode_type);
			if (!(l_encounter_id.length() > 0))
			{
				l_encounter_id = "XXX";
			}
			reqParams.put("ENCOUNTER_ID", l_encounter_id);
			if (!(l_episode_id.length() > 0))
			{
				l_episode_id = "XXX";
			}
			reqParams.put("EPISODE_ID", l_episode_id);

			if (!(l_visit_id.length() > 0))
			{
				l_visit_id = "XXX";
			}
			reqParams.put("VISIT_ID", l_visit_id);

			if (!(l_blng_grp_id.length() > 0))
			{
				l_blng_grp_id = "XXX";
			}

			reqParams.put("BLNG_GRP_ID", l_blng_grp_id);
			reqParams.put("SETTLEMENT_IND", l_settlement_ind);
		}
		catch (Exception e)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + " - "+ e.getMessage();
		}	

		if (l_episode_id.equals("XXX"))
		{
			l_file_type = "P";
			l_file_id = l_patient_id;
		}
		else
		{
			l_file_type = "A";
			l_file_id = l_episode_id;
		}

		l_case_nbr = l_request + l_file_type + l_file_id;

		l_app_msg = "::: l_case_nbr Generated : "+l_case_nbr;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);


		l_app_msg = "Calling GetResponseMessage...";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		l_response_msg = GetResponseMessage(l_request, l_trans_value, l_request_type, l_case_nbr,l_facility_id);
		if (l_response_msg.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_response_msg;
		}

		l_response_msg = l_response_msg.replaceAll("INCOME ESTIMATOR","INCOME_ESTIMATOR");	

		l_app_msg = "::: Getting Response Message at Line 1457 : "+l_response_msg+ " ::: l_errcd : "+l_errcd;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

		reqParams.put("FILE_NAME_FOR_NRL_RESP", "XXX");
		reqParams.put("INBOUND_XML_REPLY", "XXX");
		reqParams.put("FILE_NAME_FOR_REJ_RESP", "XXX");	
		reqParams.put("INBOUND_XML_REJ", "XXX");
		reqParams.put("FILE_NAME_FOR_FAILED_RESP", "XXX");
		reqParams.put("INBOUND_XML_FAIL", "XXX");	
		reqParams.put("REPONSE_SYNTAX", "XXX");

		reqParams.put("AUTHORIZATION_NUM", "XXX");
		reqParams.put("APPROVAL_STATUS", "XXX");
        reqParams.put("REQUEST_STATUS","XXX");
        reqParams.put("WARN_CODE","XXX");
		reqParams.put("WARN_DESC", "XXX");
		

		l_app_msg = " ::: Fetching Response Details... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_app_msg = " ::: Fetching Status... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		reqParams.put("REPONSE_SYNTAX", l_response_msg);

		l_response_status = FetchFieldValue(l_response_msg, "<STATUS>", null, l_field_separator, "TransRequestMethod");
		if (l_response_status.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_response_status;
		}
		l_app_msg = " ::: l_response_status : "+l_response_status;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_app_msg = " ::: Fetching Response File Type... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_response_file_type = FetchFieldValue(l_response_msg, "<FILE_TYPE>", null, l_field_separator, "TransRequestMethod");
		if (l_response_file_type.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_response_file_type;
		}
		l_app_msg = " ::: l_response_file_type : "+l_response_file_type;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_app_msg = " ::: Fetching Response File Name... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_response_file_name = FetchFieldValue(l_response_msg, "<FILE_NAME>", null, l_field_separator, "TransRequestMethod");
		if (l_response_file_name.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_response_file_name;
		}
		l_app_msg = " ::: l_response_file_name : "+l_response_file_name;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_app_msg = " ::: Fetching Response Message... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_response = FetchFieldValue(l_response_msg, "<RESPONSE>", null, l_field_separator, "TransRequestMethod");
		if (l_response.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_response;
		}
		l_app_msg = " ::: l_response : "+l_response;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		reqParams.put("REQUEST_STATUS", l_response_status);
		reqParams.put("WARN_CODE", "XXX");
		reqParams.put("WARN_DESC", "XXX");
		
		l_app_msg = " ::: Fetching Authorization Number... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		if (l_errcd.equals("S") && !l_response_status.equals("09")&& l_response_file_name.toLowerCase().indexOf("fail") ==-1)
		{			
			l_app_msg = " ::: Fetching Approval Status... ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);				

			l_approval_status = parseResponseXml(l_response,"TX","res");
			if (l_approval_status.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_approval_status;
			}
			else
				reqParams.put("APPROVAL_STATUS", l_approval_status);

			l_app_msg = " ::: Fetching Authorization Number... ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_auth_num = parseResponseXml(l_response,"AUTHS","hnet");

			l_app_msg = " ::: l_auth_num : "+l_auth_num;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			l_app_msg = " ::: l_wca_num : "+l_wca_num;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			if (l_response_str.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_response_str;
			}
			else
			{
				l_errcd = "S";
				l_errmsg  = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_response_str;
				if(l_wca_num.equals("XXX") || l_wca_num.length()<=0){
					reqParams.put("AUTHORIZATION_NUM", l_auth_num);					
				}
				else{
					reqParams.put("AUTHORIZATION_NUM", l_wca_num);					
				}
			}
			l_app_msg = " ::: l_auth_num : "+l_auth_num;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_app_msg = " ::: Updating Authorization Details... ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_response_str = UpdateAuthorizationDetails(reqParams);				
			l_app_msg = " ::: Update Authorization Details l_response_str: "+ l_response_str;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg); 				
			if (l_response_str.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_response_str ;
			}

			l_app_msg = " ::: l_errmsg : "+l_errmsg;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);	

			l_app_msg = " ::: Fetching Claim Number... ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_case_nbr = parseResponseXml(l_response,"TX","case_nbr");
			if (l_case_nbr.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_case_nbr;
			}
			l_app_msg = " ::: l_case_nbr : "+l_case_nbr;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_app_msg = " ::: Fetching Response Type... ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			if (l_approval_status.equals("A"))
			{
				l_res_type = "Authorized";
			}
			else if (l_approval_status.equals("R"))
			{
				l_res_type = "Rejected";
			}
			else if (l_approval_status.equals(""))
			{
				l_res_type = "";
			}
			l_app_msg = " ::: l_res_type : "+l_res_type;
		    if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);	
				
		}			
		if (l_response_file_type.equals("ELCREP"))
		{
			reqParams.put("FILE_NAME_FOR_NRL_RESP", l_response_file_name);
			reqParams.put("INBOUND_XML_REPLY", l_response);
		}
		if (l_response_file_type.equals("ELCREJ"))
		{
			reqParams.put("FILE_NAME_FOR_REJ_RESP", l_response_file_name);
			reqParams.put("INBOUND_XML_REJ", l_response);
		}
		if (l_response_file_type.equals("ELCFAI"))
		{
			reqParams.put("FILE_NAME_FOR_FAILED_RESP", l_response_file_name);
			reqParams.put("INBOUND_XML_FAIL", l_response);
		}	
			
		/******/
		reqParams.put("ACKNOWLEDGEMENT_TEXT", "XXX");

		l_app_msg = " ::: L_ERRCD : "+l_errcd+" ::: L_RESPONSE_STATUS : "+l_response_status;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);	

		if (l_errcd.equals("S") && !(l_response_status.equals("09")) )
		{
			if(l_response_file_name.toLowerCase().indexOf("fail") >=0)
			{
					if(l_response.length() > 0)
					{
						l_approval_status = "F";

						l_pc_number = Integer.parseInt(l_response.substring(0, 2));
						l_app_msg = " ::: l_pc_number : "+l_pc_number;
						if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

						l_ws_number =Integer.parseInt(l_response.substring(2, 5));
						l_app_msg = " ::: l_ws_number : "+l_ws_number;
						if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

						l_msg_format =l_response.substring(5, 7);
						l_app_msg = " ::: l_msg_format : "+l_msg_format;
						if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

						l_error_count =Integer.parseInt(l_response.substring(7, 9));
						l_app_msg = " ::: l_error_count : "+l_error_count;
						if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

						l_error_code_desc = l_response.substring(9, l_response.length());
						l_app_msg = " ::: l_error_code_desc : "+l_error_code_desc;
						if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
						int start = 0;
						int end = 0;

						for (int i=0;i< l_error_count; i++)
						{
							start = end;
							end = end+4;

							l_error_code += l_error_code_desc.substring(start, end)+"##";
							l_app_msg = " ::: l_error_code : "+l_error_code;
							if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

                            start = end;
							end = end+19;

							l_error_desc += l_error_code_desc.substring(start,end)+"##";
							l_app_msg = " ::: l_error_desc : "+l_error_desc;
							if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
							
							l_app_msg = " ::: start : "+start;
							if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
							l_app_msg = " ::: end : "+end;
							if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

						}

						l_app_msg = " ::: l_errmsg : "+l_errmsg;
						if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
						l_res_type = "Failed";

						l_mem_num = l_member_id;
						
						l_response_str = l_pc_number+"$!^"+l_ws_number+"$!^"+l_msg_format+"$!^"+l_error_count+"$!^"+l_error_code+"$!^"+l_approval_status+"$!^"+l_mem_num+"$!^"+l_error_desc+"$!^"+l_res_type+"$!^";
						l_response_return = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_response_str;

						reqParams.put("ACKNOWLEDGEMENT_TEXT", l_response);
						reqParams.put("APPROVAL_STATUS", l_approval_status);
					}
					else{
						l_response_str = "Error in Reading the file - No Response found";
						l_errcd = "E";
						l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_response_str;

					}
				}
            else
			{
			l_app_msg = "Calling ParseResponseMessage...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			if(l_approval_status.equals("A"))
			{
				l_app_msg = " ::: Fetching Res Member number... ";
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

				l_mem_num = parseResponseXml(l_response,"MEM","ch_id");
				if (l_warn_code.indexOf("Error")>=0)
				{
					l_errcd = "E";
					l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_mem_num;
				}
				l_app_msg = " ::: l_mem_num : "+l_mem_num;
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

				if(!(l_mem_num.length()>0)){
						l_mem_num = l_member_id;
				}

				if(l_request.equals("IEC") )
				{			
					l_app_msg = " ::: Fetching warn Code... ";
					if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

					l_warn_code = parseResponseXml(l_response,"WARN","cd");
					if (l_warn_code.indexOf("Error")>=0)
					{
						l_errcd = "E";
						l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_warn_code;
					}
					l_app_msg = " ::: l_warn_code : "+l_warn_code;
					if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

					l_app_msg = " ::: Fetching warn desc... ";
					if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

					l_warn_desc = parseResponseXml(l_response,"WARN","desc");
					if (l_warn_desc.indexOf("Error")>=0)
					{
						l_errcd = "E";
						l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_warn_desc;
					}
					l_app_msg = " ::: l_warn_desc : "+l_warn_desc;
					if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);


					if (l_errcd.equals("S"))
					{
						reqParams.put("WARN_CODE",l_warn_code);
						reqParams.put("WARN_DESC", l_warn_desc);

					   l_response_str = l_case_nbr+"$!^"+l_res_type+"$!^"+l_warn_code+"$!^"+l_warn_desc+"$!^"+l_auth_num+"$!^"+l_approval_status+"$!^"+l_mem_num;
					   l_response_return = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_response_str;
					   //S$!^269$!^ ::: l_auth_num : 44$!^44$!^Authorized$!^$!^$!^44$!^A
					  // l_response_return = l_claims_num+"$!^"+l_res_type+"$!^"+l_warn_code+"$!^"+l_warn_desc+"$!^"+l_auth_num+"$!^"+l_approval_status;
					   reqParams.put("ACKNOWLEDGEMENT_TEXT", l_response_str);
					}
				}
				else if(l_request.equals("UEC"))
				{
                    l_app_msg = " ::: Updated Emp Details... ";
					if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

					l_response_str = updateEmpDetails(l_request, l_response,actionKey,l_trans_value,l_patient_id);
					if (l_response_str.indexOf("Error")>=0)
					{
						l_errcd = "E";
						l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_response_str;
					}
					l_app_msg = " ::: l_response_str : "+l_response_str;
					if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

					 l_response_str = l_case_nbr+"$!^"+l_res_type+"$!^"+l_warn_code+"$!^"+l_warn_desc+"$!^"+l_auth_num+"$!^"+l_approval_status+"$!^"+l_mem_num;
					 l_response_return = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_response_str;
				}
				else
				{
					l_response_str = ParseResponseMessage(l_request, l_response,actionKey);
					if (l_response_str.indexOf("Error")>=0)
					{
						l_errcd = "E";
						l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_response_str;
					}
					else
					{
						l_errcd = "S";					    
						l_response_return = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^"+l_case_nbr+"$!^"+l_res_type+"$!^"+l_response_str+"$!^"+l_warn_desc+"$!^"+l_auth_num+"$!^"+l_approval_status+"$!^"+l_mem_num;

						//l_response_return = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_response_str + "$!^" +l_auth_num+"$!^"+l_approval_status;
						//l_response_return = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_response_str+ "$!^" +l_auth_num+"$!^"+l_approval_status+"$!^"+l_claims_num+"$!^"+l_res_type;

						reqParams.put("ACKNOWLEDGEMENT_TEXT", l_response_str);
					}		
				}
			}		

			if(l_approval_status.equals("R"))
			{
				l_app_msg = " ::: l_res_type : "+l_res_type;
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);				
				
				l_app_msg = " ::: Fetching Rej Code... ";
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

				l_rej_code = parseResponseXml(l_response,"RJ","cd");
				if (l_rej_code.indexOf("Error")>=0)
				{
					l_errcd = "E";
					l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_rej_code;
				}
				l_app_msg = " ::: l_rej_code : "+l_rej_code;
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

				l_app_msg = " ::: Fetching Rej desc... ";
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

				l_rej_desc = parseResponseXml(l_response,"RJ","desc");
				if (l_warn_desc.indexOf("Error")>=0)
				{
					l_errcd = "E";
					l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_rej_desc;
				}
				l_app_msg = " ::: l_rej_desc : "+l_rej_desc;
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

				l_app_msg = " ::: Fetching transaction reference number... ";
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

				l_trans_num = parseResponseXml(l_response,"TX","tx_nbr");
				if (l_trans_num.indexOf("Error")>=0)
				{
					l_errcd = "E";
					l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_auth_num;
				}
				l_app_msg = " ::: l_trans_num : "+l_trans_num;
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg); 

				if (l_errcd.equals("S"))
				{
				   l_response_str = l_case_nbr+"$!^"+l_res_type+"$!^"+l_rej_code+"$!^"+l_rej_desc+"$!^"+l_auth_num+"$!^"+l_approval_status+"$!^"+l_mem_num;
				   l_response_return = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_response_str;

				   reqParams.put("ACKNOWLEDGEMENT_TEXT", l_response_str);
				   reqParams.put("REJ_CODE", l_warn_code);
				   reqParams.put("REJ_DESC", l_warn_desc);
				}
			}

			l_app_msg = "Parse Claims Status...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_eclaims_status_log = ParseClaimsStatus(l_response, reqParams);
			if (l_eclaims_status_log.indexOf("Error")>=0)
			{
				l_errcd = "E";
			}
			
			l_app_msg = "::: l_eclaims_status_log : "+l_eclaims_status_log;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		}
        }
		reqParams.put("RESPONSE_TEXT", l_response);
		reqParams.put("STATUS", l_errcd);	
		reqParams.put("ERROR_MESSAGE", l_errmsg);

		l_app_msg = "Updating Interface Audit data...";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		
		l_interactive_log = UpdateInteractiveDetails(reqParams);
		if (l_interactive_log.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_interactive_log;
		}
		
		l_app_msg = "Updating EClaims data...";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		
		l_eclaims_log = UpdateEClaimsDetails(reqParams);
		if (l_eclaims_log.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_trans_value + "$!^" + l_app_msg + "$!^" + l_eclaims_log;
		}	
		
		l_app_msg = "::: Sethu Status : "+l_errcd;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

		if ((l_errcd.equals("S")) || (l_errcd.equals("E") && l_response_status.equals("09")))
		{
			try
			{
				dbConn.commit();
			}
			catch (Exception e)
			{
				l_app_msg = "::: Error in Commiting the data updated : "+e.getMessage();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			}
			finally
			{			
				closeDBResources(null, null, dbConn);			
			}			
		}
		else
		{
			try
			{
				dbConn.rollback();
			}
			catch (Exception e)
			{
				l_app_msg = "::: Error in rollback the data updated : "+e.getMessage();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			}
			finally
			{			
				closeDBResources(null, null, dbConn);	
				reqParams.clear();
			}
		}

		if (l_errcd.equals("S"))
		{
			return l_response_return;
		}
		else
		{
			return l_errmsg;
		}
		
	}	

	public String ParseClaimsStatus(String response, Map params)
	{
		//Connection dbConn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;

		String l_insert_stmt = "";

		String l_app_msg ="", l_errcd ="S", l_errmsg ="", l_return_msg = "";	
		
		String l_facility_id = "", l_patient_id = "", l_episode_id = "", l_episode_type = "", l_visit_id = "";
		int l_trans_value = 0;

		String l_status_type = "", l_status_code = "", l_status_desc = "", l_status_attr = "", l_status_tag = "", l_status_count_str = "",l_count_stmt = "";

		int l_status_count = 0, l_insert_count = 0, l_tot_insert_count = 0,l_inserted_status_count = 0;

        try{

			l_app_msg = " Inside ParseClaimsStatus...";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_status_type = parseResponseXml(response,"TX","res");

			l_app_msg = " ::: Status Type ::: "+l_status_type;
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

			l_app_msg = " ::: Status Attribute ::: "+l_status_attr;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_status_count_str = parseResponseXml(response,"CNT",l_status_attr);

			l_app_msg = " ::: Status l_status_count_str ::: "+l_status_count_str;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			if (l_status_count_str.length()>0)
			{
				l_status_count = Integer.parseInt(l_status_count_str);
			}

			l_app_msg = " ::: Status Count ::: "+l_status_count;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_app_msg = " ::: Status Count ::: "+l_status_count;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			InputSource is = new InputSource();
			is.setCharacterStream(new StringReader(response));

			Document doc = db.parse(is);

			if (l_status_type.equals("R"))
			{
				l_status_tag = "RJ";
			}
			if (l_status_type.equals("W"))
			{
				l_status_tag = "WARN";
			}
			if (l_status_type.equals("A"))
			{
				l_status_tag = "WARN";
			}

			NodeList statusNodesList = doc.getElementsByTagName(l_status_tag);

			//dbConn =  ConnectionManager.getConnection();
			 
			if (statusNodesList != null)
			{
				l_status_count = statusNodesList.getLength();

				l_app_msg = " ::: Status NodesList Length ::: "+l_status_count;
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

				for (int i = 0; i < statusNodesList.getLength(); i++) 
				{
					l_status_code = ""; l_status_desc = "";

					if (statusNodesList.item(i).getNodeType() == Node.ELEMENT_NODE) 
					{
						Element el = (Element) statusNodesList.item(i);
						l_status_code = StringEscapeUtils.unescapeXml(el.getAttribute("cd"));
						l_status_desc = StringEscapeUtils.unescapeXml(el.getAttribute("desc"));
					}

					l_app_msg = " ::: Status Code ::: "+l_status_code+" ::: Status Desc ::: "+ l_status_desc;
					if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

					l_facility_id = params.get("FACILITY_ID").toString();
					l_app_msg = "::: FACILITY_ID : "+ l_facility_id;
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);					
					
					l_patient_id = params.get("PATIENT_ID").toString();
					l_app_msg = "::: PATIENT_ID : "+ l_patient_id;
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

					l_episode_id = params.get("EPISODE_ID").toString();
					l_app_msg = "::: EPISODE_ID : "+ l_episode_id;
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

					l_episode_type = params.get("EPISODE_TYPE").toString();
					l_app_msg = "::: EPISODE_TYPE : "+ l_episode_type;
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

					l_visit_id = params.get("VISIT_ID").toString();
					l_app_msg = "::: VISIT_ID : "+ l_visit_id;
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);					

					l_trans_value =  Integer.parseInt(params.get("MSG_ID").toString()) ;
					
					l_count_stmt = " Select count(*) COUNT FROM XF_ECLAIMS_STATUS_DTL "
					                +" WHERE SRL_NO = ? " 
									+" AND STATUS_TYPE = ? "
									+" AND STATUS_CODE = ? "
									+" AND STATUS_DESC = ? ";

					l_app_msg = "::: l_count_stmt : "+ l_count_stmt;
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

					pstmt = dbConn.prepareStatement(l_count_stmt);					
					
					pstmt.setInt(1, l_trans_value);
					pstmt.setString(2, l_status_type);
					pstmt.setString(3, l_status_code);
					pstmt.setString(4, l_status_desc);

					rs = pstmt.executeQuery();
                    while(rs.next()){
						l_inserted_status_count = rs.getInt("COUNT");
					}

					if(pstmt != null) pstmt.close();
					if(rs != null) rs.close();

                    l_app_msg = "::: l_inserted_status_count : "+ l_inserted_status_count;
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

					if(l_inserted_status_count<=0){

						l_app_msg = " ::: FACILITY_ID : "+ l_facility_id + " ::: PATIENT_ID : " + l_patient_id + " ::: EPISODE_ID : "+ l_episode_id + " ::: EPISODE_TYPE : " + l_episode_type + " ::: VISIT_ID : "+ l_visit_id + " ::: SRL_NO : "+ l_trans_value + " ::: STATUS TYPE : "+ l_status_type+ " ::: STATUS CODE : "+ l_status_code + " ::: STATUS DESC : "+ l_status_desc;
						if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

						l_insert_stmt = " INSERT INTO XF_ECLAIMS_STATUS_DTL (FACILITY_ID, PATIENT_ID, EPISODE_ID, EPISODE_TYPE, VISIT_ID, SRL_NO, "       
										+" STATUS_TYPE, STATUS_CODE, STATUS_DESC ) "
										+" VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

						pstmt = dbConn.prepareStatement(l_insert_stmt);					
						pstmt.setString(1, l_facility_id);
						pstmt.setString(2, l_patient_id);
						
						if (!(l_episode_id.equals("XXX")))
							pstmt.setInt(3, Integer.parseInt(l_episode_id));
						else
							pstmt.setString(3, "");					
						
						if (!(l_episode_type.equals("XXX")))
							pstmt.setString(4, l_episode_type);
						else
							pstmt.setString(4, "");

						if (!(l_visit_id.equals("XXX")))
							pstmt.setInt(5, Integer.parseInt(l_visit_id));
						else
							pstmt.setString(5, "");
						
						pstmt.setInt(6, l_trans_value);
						pstmt.setString(7, l_status_type);
						pstmt.setString(8, l_status_code);
						pstmt.setString(9, l_status_desc);

						l_insert_count = pstmt.executeUpdate();
						
						l_tot_insert_count = l_tot_insert_count + l_insert_count;

						l_app_msg = " ::: UPDATE XF_ECLAIMS_STATUS_DTL : SRL_NO : "+l_trans_value +" :: UpdateCount :: " +l_insert_count;
						if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);						
					  }
					 else{
                            l_tot_insert_count = l_status_count;
				      }
					l_app_msg = " ::: UPDATE XF_ECLAIMS_STATUS_DTL : L_TOT_INSERT_COUNT : "+l_tot_insert_count +" :: L_STATUS_COUNT : "+l_status_count;
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				 }
				
					
				if (l_tot_insert_count == l_status_count)
				{
					//dbConn.commit();	
					l_errcd = "S";
					l_errmsg = "EClaims Transaction Status details table updated successfully ";
					l_return_msg = l_errcd + "$!^"+ l_errmsg;
				}
				else
				{
					//dbConn.rollback();	
					l_errcd = "E";
					l_errmsg = " Error in updating Transaction Status details table Records ";	
					l_return_msg = l_errcd + "$!^"+ l_errmsg;
				}
			}

		}
		catch (Exception e)
		{
			e.printStackTrace();
			l_errcd = "E";
			l_errmsg = "Error in Parsing Response Item Details : "+ e.getMessage();
			l_return_msg = l_errcd + "$!^"+ l_errmsg;
			return l_return_msg;
		}
		finally
		{
			XHUtil.closeDBResources(rs, pstmt, null);
		}
		
		return l_return_msg;
	}

	public String FetchXMLFormat(String request, String applicationID, String column){

		Connection Conn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;

		String query = "";
		String l_app_msg = "", l_application_id ="", l_clob_string = "";

		java.sql.Clob l_clob_xml_data = null, l_clob_xsl_data = null;

		l_app_msg = " ::: Inside FetchXMLFormat ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = " ::: Request : "+ request + " ::: Application ID : "+applicationID;
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
			l_clob_string = "Error in "+ l_app_msg + " : " +  e.getMessage();
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

		l_app_msg = " ::: Inside FetchProtocolDetails ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = " ::: Protocol Link ID : "+ protocolLinkID ;
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
			closeDBResources(rs, pstmt, Conn);				
		}	
		
		l_app_msg = " ::: l_file_directory : "+l_file_directory;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		return l_file_directory;
	}

	public HashMap FetchPatientDetails(String patientID){

		Connection Conn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;

		String query = "";
		String l_app_msg = "";

		String l_patient_id = "", l_national_id_no = "", l_name_prefix = "", l_first_name = "", l_third_name = "", l_family_name = "", l_patient_name = "", l_sex = "", l_date_of_birth = "", l_race_code = "";

		String l_addr1_line1 = "", l_addr1_line2 = "", l_postal1_code = "", l_res_town_desc = "", l_res_area_desc = "";

		String l_passport_id = "";

		HashMap patientDetailsMap = new HashMap();

		l_app_msg = " ::: Inside FetchPatientDetails ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = " ::: Patient ID : "+ patientID;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		
		try
		{
			Conn =  ConnectionManager.getConnection();
			query = "Select a.PATIENT_ID, nvl(NATIONAL_ID_NO,'') NATIONAL_ID_NO, nvl(a.ALT_ID1_NO,'') ALT_ID1_NO, nvl(NAME_PREFIX,'') NAME_PREFIX, nvl(FIRST_NAME,'') FIRST_NAME, "
						+" NVL (FAMILY_NAME, '') FAMILY_NAME, nvl(THIRD_NAME,'') THIRD_NAME, nvl(PATIENT_NAME,'') PATIENT_NAME, decode(NVL (sex, ''), 'M', '1', 'F', '2') SEX, "
						+" TO_CHAR(NVL (date_of_birth, ''), 'yyyymmdd')  DATE_OF_BIRTH,  nvl(RACE_CODE,'') RACE_CODE,  nvl(ADDR1_LINE1,'') ADDR1_LINE1, nvl(ADDR1_LINE2,'') ADDR1_LINE2, "
						+" nvl(POSTAL1_CODE,'') POSTAL1_CODE, nvl(REGION1_CODE,'') REGION1_CODE, nvl(RES_AREA1_CODE,'')  RES_AREA1_CODE, nvl(RES_TOWN1_CODE,'') RES_TOWN1_CODE, "
						+" NVL (c.LONG_DESC, '') CITY_DESC,  NVL (d.LONG_DESC, '') REGION_DESC "
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
			   l_postal1_code = rs.getString("POSTAL1_CODE")==null?"XYZ":rs.getString("POSTAL1_CODE");
			   l_res_town_desc = rs.getString("CITY_DESC")==null?"XYZ":rs.getString("CITY_DESC");
			   l_passport_id = rs.getString("ALT_ID1_NO")==null?"XYZ":rs.getString("ALT_ID1_NO");
			   l_res_area_desc = rs.getString("REGION_DESC")==null?"XYZ":rs.getString("REGION_DESC");
			}

			l_app_msg = " ::: Patient Details : "+ l_patient_id + " ::: " + l_national_id_no + " ::: " + l_name_prefix + " ::: " + l_first_name + " ::: " + l_third_name + " ::: " + l_family_name + " ::: " + l_patient_name + " ::: " + l_sex + " ::: " + l_date_of_birth + " ::: " + l_race_code + " ::: " + l_addr1_line1 + " ::: " + l_addr1_line2 + " ::: " + l_postal1_code + " ::: " + l_res_town_desc + " ::: "+ l_passport_id+ " ::: "+ l_res_area_desc;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			patientDetailsMap.put("PATIENT_ID", l_patient_id);
			
			l_app_msg = " ::: Patient Details NATIONAL_ID : "+ l_national_id_no;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			patientDetailsMap.put("NATIONAL_ID", l_national_id_no); 

			l_app_msg = " ::: Patient Details NAME_PREFIX : "+ l_name_prefix;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			patientDetailsMap.put("NAME_PREFIX", l_name_prefix);

			l_app_msg = " ::: Patient Details FIRST_NAME : "+ l_first_name;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			patientDetailsMap.put("FIRST_NAME", l_first_name);

			l_app_msg = " ::: Patient Details THIRD_NAME : "+ l_third_name;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			patientDetailsMap.put("THIRD_NAME", l_third_name);

			l_app_msg = " ::: Patient Details FAMILY_NAME : "+ l_family_name;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			patientDetailsMap.put("FAMILY_NAME", l_family_name);

			l_app_msg = " ::: Patient Details PATIENT_NAME : "+ l_patient_name;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			patientDetailsMap.put("PATIENT_NAME", l_patient_name); 

			l_app_msg = " ::: Patient Details SEX : "+ l_sex;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			patientDetailsMap.put("SEX", l_sex); 

			l_app_msg = " ::: Patient Details DATE_OF_BIRTH : "+ l_date_of_birth;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			patientDetailsMap.put("DATE_OF_BIRTH", l_date_of_birth);

			l_app_msg = " ::: Patient Details RACE_CODE : "+ l_race_code;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			patientDetailsMap.put("RACE_CODE", l_race_code);

			l_app_msg = " ::: Patient Details ADDR1_LINE1 : "+ l_addr1_line1;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			patientDetailsMap.put("ADDR1_LINE1", l_addr1_line1); 

			l_app_msg = " ::: Patient Details ADDR1_LINE2 : "+ l_addr1_line2;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			patientDetailsMap.put("ADDR1_LINE2", l_addr1_line2);

			l_app_msg = " ::: Patient Details POSTAL1_CODE : "+ l_postal1_code;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			patientDetailsMap.put("POSTAL1_CODE", l_postal1_code);

			l_app_msg = " ::: Patient Details CITY_DESC : "+ l_res_town_desc;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			patientDetailsMap.put("CITY_DESC", l_res_town_desc);

			l_app_msg = " ::: Patient Details PASSPORT_ID : "+ l_passport_id;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			patientDetailsMap.put("PASSPORT_ID", l_passport_id);

			l_app_msg = " ::: Patient Details AREA_DESC : "+ l_res_area_desc;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			patientDetailsMap.put("AREA_DESC", l_res_area_desc);

			l_app_msg = " ::: patientDetailsMap Size : "+ patientDetailsMap.size();
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

	public String CreateXMLMessage(String request, String actionKey, String patientId, String seqNo, String xmlString){

		String l_app_msg = "";

		String l_xml_msg = "";

		l_app_msg = " ::: Inside CreateXMLMessage ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = " ::: Request : "+ request + " ::: Patient ID : "+ patientId + " ::: XML String : " + xmlString;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		
		try
		{
			if (request.equals("IDC") || request.equals("FAM") || request.equals("IEC") || request.equals("UEC"))
			{
				l_xml_msg = CreateELCXMLMessage(request, actionKey, patientId, seqNo, xmlString);
			}
		}
		catch (Exception e)
		{
			l_xml_msg = "Error in "+ l_app_msg + " : " +  e.getMessage();
		}		

		l_app_msg = " ::: l_xml_msg ::: "+l_xml_msg;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

		return l_xml_msg;
	}

	public String CreateELCXMLMessage(String request, String actionKey, String patientId, String seqNo, String xmlString){

		String l_app_msg = "";
		String l_element_id = "", l_segment_id = "ELC", l_standard_code = "ECLASTD";

		String l_xml_msg = "";

		String l_document_ver_no = "", l_hospital_no = "", l_tx_cd = "", l_msg_fmt = "", l_orig = "", l_bin = "";
		String l_vend_id = "", l_vend_ver = "", l_pay_adv = "", l_clm_orig = "", l_cntry_cd = "", l_sect_cd = "";
		String l_request_date = "";

		String l_facility_id = "",l_encounter_id = "", l_admission_type = "";

		String l_patient_id = "", l_national_id_no = "", l_name_prefix = "", l_first_name = "", l_third_name = "", l_family_name = "", l_race_code = "", l_patient_name = "", l_sex = "", l_date_of_birth = "", l_passport_id = "";

		String  l_member_id = "",l_wca_num = "",  l_depd_code = "", l_depd_reln = "", l_dest_code = "",l_surname = "",l_initial = "", l_race_cd = "";

		String l_addr1_line1 = "", l_addr1_line2 = "", l_postal1_code = "",  l_res_town_desc = "",l_episode_type = "", l_res_area_desc = "";
        
		String l_adm_dt = "", l_adm_tm = "", l_dis_dt = "", l_dis_tm = "", l_deceased_date = "",  l_los = "1.00", l_adm_ind = "", l_prm_diag = "",l_primary_yn = "",l_ip_stg = "",l_adm_diag = "",l_adm_tag = "" ;

        //Connection dbConn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;
        String query = "";

		String l_seq_no = seqNo;
		HashMap patDetailMap = null;

		l_app_msg = " ::: Inside CreateELCXMLMessage ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = " ::: Request : "+ request + " ::: Patient ID : "+ patientId + " ::: XML String : " + xmlString;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		
		try
		{
			l_app_msg = " ::: Fetching Patient Id... ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_patient_id = FetchFieldValue(actionKey, "<PATIENT_ID>", null, l_field_separator, "CreateELCXMLMessage");
			if (l_patient_id.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_patient_id;
			}
			l_app_msg = " ::: l_patient_id : "+l_patient_id;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_app_msg = " ::: Fetching Facility ID ... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_facility_id = FetchFieldValue(actionKey,"<FACILITY_ID>",null,l_field_separator, "TransRequestMethod");
			if (l_facility_id.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_facility_id;
			}
			l_app_msg = " ::: l_facility_id : "+l_facility_id;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_app_msg = " ::: Fetching Encounter ID ... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_encounter_id = FetchFieldValue(actionKey,"<ENCOUNTER_ID>",null,l_field_separator, "TransRequestMethod");
			if (l_encounter_id.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_encounter_id;
			}
			l_app_msg = " ::: l_encounter_id : "+l_encounter_id;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_app_msg = " ::: Fetching Admission Type ... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_admission_type = FetchFieldValue(actionKey,"<ADMISSION_TYPE>",null,l_field_separator, "TransRequestMethod");
			if (l_admission_type.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_admission_type;
			}
			l_app_msg = " ::: l_admission_type : "+l_admission_type;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_app_msg = " ::: Fetching Episode Type... ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_episode_type = FetchFieldValue(actionKey, "<EPISODE_TYPE>", null, l_field_separator, "CreateELCXMLMessage");
			if (l_episode_type.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_episode_type;
			}
			l_app_msg = " ::: l_episode_type : "+l_episode_type;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_app_msg = " ::: Fetching Member ID... ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_member_id = FetchFieldValue(actionKey, "<MEMBER_ID>", null, l_field_separator, "CreateELCXMLMessage");
			if (l_member_id.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_member_id;
			}
			l_app_msg = " ::: l_member_id : "+l_member_id;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_app_msg = " ::: Fetching WCA Number... ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_wca_num = FetchFieldValue(actionKey, "<WCA_NUM>", null, l_field_separator, "TransRequestMethod");
			if (l_wca_num.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_wca_num;
			}
			l_app_msg = " ::: l_wca_num : "+l_wca_num;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);


			l_app_msg = " ::: Fetching Surname... ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_surname = FetchFieldValue(actionKey, "<SURNAME>", null, l_field_separator, "CreateELCXMLMessage");
			if (l_surname.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_surname;
			}
			l_app_msg = " ::: l_surname : "+l_surname;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_app_msg = " ::: Fetching Initial... ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_initial = FetchFieldValue(actionKey, "<INITIAL>", null, l_field_separator, "TransRequestMethod");
			if (l_initial.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_initial;
			}
			l_app_msg = " ::: l_initial : "+l_initial;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_app_msg = " ::: Fetching Depd Code... ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_depd_code = FetchFieldValue(actionKey, "<DEPD_CODE>", null, l_field_separator, "TransRequestMethod");
			if (l_depd_code.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_depd_code;
			}
			l_app_msg = " ::: l_depd_code : "+l_depd_code;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_app_msg = " ::: Fetching Depd reln... ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_depd_reln = FetchFieldValue(actionKey, "<DEPD_RELN>", null, l_field_separator, "TransRequestMethod");
			if (l_depd_reln.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_depd_reln;
			}
			l_app_msg = " ::: l_depd_reln : "+l_depd_reln;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_app_msg = " ::: Fetching Destination Code... ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_dest_code = FetchFieldValue(actionKey, "<DEST_CD>", null, l_field_separator, "TransRequestMethod");
			if (l_dest_code.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_dest_code;
			}
			l_app_msg = " ::: l_dest_code : "+l_dest_code;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_app_msg = "Retrieving Document Version No...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_element_id = "DOCUMENT_VER_NO";

			l_document_ver_no = FetchStdCntrlSeg(l_segment_id, l_element_id, l_standard_code);
			if (l_document_ver_no.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_document_ver_no;
			}
			l_app_msg = " ::: l_document_ver_no : "+l_document_ver_no;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			/*
			l_app_msg = "Retrieving Hospital No...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_element_id = "HOSPITAL_NO";

			l_hospital_no = FetchStdCntrlSeg(l_segment_id, l_element_id, l_standard_code);
			if (l_hospital_no.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_hospital_no;
			}	
			l_app_msg = " ::: l_hospital_no : "+l_hospital_no;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
             */

			l_app_msg = "Retrieving TX_CD...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_element_id = "TX_CD_"+request;

			l_tx_cd = FetchStdCntrlSeg(l_segment_id, l_element_id, l_standard_code);
			if (l_tx_cd.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_tx_cd;
			}	
			l_app_msg = " ::: l_tx_cd : "+l_tx_cd;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_app_msg = "Retrieving MSG_FMT...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_element_id = "MSG_FMT";

			l_msg_fmt = FetchStdCntrlSeg(l_segment_id, l_element_id, l_standard_code);
			if (l_msg_fmt.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_msg_fmt;
			}	
			l_app_msg = " ::: l_msg_fmt : "+l_msg_fmt;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_app_msg = "Retrieving ORIG...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_element_id = "ORIG";

			l_orig = FetchStdCntrlSeg(l_segment_id, l_element_id, l_standard_code);
			if (l_orig.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_orig;
			}	
			l_app_msg = " ::: l_orig : "+l_orig;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_app_msg = "Retrieving BIN...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_element_id = "BIN";

			l_bin = FetchStdCntrlSeg(l_segment_id, l_element_id, l_standard_code);
			if (l_bin.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_bin;
			}	
			l_app_msg = " ::: l_bin : "+l_bin;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_app_msg = "Retrieving VEND_ID...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_element_id = "VEND_ID";

			l_vend_id = FetchStdCntrlSeg(l_segment_id, l_element_id, l_standard_code);
			if (l_vend_id.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_vend_id;
			}	
			l_app_msg = " ::: l_vend_id : "+l_vend_id;
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

			l_app_msg = " ::: l_vend_ver : "+l_vend_ver;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_app_msg = "Retrieving PAY_ADV...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_element_id = "PAY_ADV";

			l_pay_adv = FetchStdCntrlSeg(l_segment_id, l_element_id, l_standard_code);
			if (l_pay_adv.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_pay_adv;
			}	
			l_app_msg = " ::: l_pay_adv : "+l_pay_adv;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_app_msg = "Retrieving CLM_ORIG...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_element_id = "CLM_ORIG";

			l_clm_orig = FetchStdCntrlSeg(l_segment_id, l_element_id, l_standard_code);
			if (l_clm_orig.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_clm_orig;
			}	
			l_app_msg = " ::: l_clm_orig : "+l_clm_orig;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_app_msg = "Retrieving CNTRY_CD...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_element_id = "CNTRY_CD";

			l_cntry_cd = FetchStdCntrlSeg(l_segment_id, l_element_id, l_standard_code);
			if (l_cntry_cd.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_cntry_cd;
			}	
			l_app_msg = " ::: l_cntry_cd : "+l_cntry_cd;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_app_msg = "Retrieving SECT_CD...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_element_id = "SECT_CD";

			l_sect_cd = FetchStdCntrlSeg(l_segment_id, l_element_id, l_standard_code);
			if (l_sect_cd.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_sect_cd;
			}	
			l_app_msg = " ::: l_sect_cd : "+l_sect_cd;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_app_msg = "Retrieving ADM_IND...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_element_id = "ADM_IND";

			l_adm_ind = FetchStdCntrlSeg("ECL", l_element_id, l_standard_code);
			if (l_adm_ind.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_adm_ind;
			}
			l_app_msg = " ::: l_adm_ind : "+l_adm_ind;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_app_msg = " Getting Formatted Date Time... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_request_date = getFormattedStringDate("yyyyMMdd", new java.util.Date());

			l_app_msg = " ::: l_request_date : "+l_request_date;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_app_msg = " Replacing XML with Document details... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			xmlString = xmlString.replaceAll("#docverno", l_document_ver_no.toUpperCase());
			xmlString = xmlString.replaceAll("#seqNo", l_seq_no.toUpperCase());
			xmlString = xmlString.replaceAll("#destCode", StringEscapeUtils.escapeXml(l_dest_code.toUpperCase()));

			xmlString = xmlString.replaceAll("#date", l_request_date);
			xmlString = xmlString.replaceAll("#transCode", l_tx_cd);
			xmlString = xmlString.replaceAll("#msgFmt", StringEscapeUtils.escapeXml(l_msg_fmt.toUpperCase()));
			xmlString = xmlString.replaceAll("#orig", l_orig.toUpperCase());
			xmlString = xmlString.replaceAll("#bin", l_bin.toUpperCase());

			xmlString = xmlString.replaceAll("#vendId", l_vend_id.toUpperCase());
			xmlString = xmlString.replaceAll("#vendVersion", l_vend_ver.toUpperCase());
			xmlString = xmlString.replaceAll("#cntryCode", l_cntry_cd.toUpperCase());
			xmlString = xmlString.replaceAll("#sectCode", l_sect_cd.toUpperCase());			
			xmlString = xmlString.replaceAll("#payAdv", l_pay_adv.toUpperCase());
			xmlString = xmlString.replaceAll("#clmOrig", l_clm_orig.toUpperCase());
			

			xmlString = xmlString.replaceAll("#memberId", StringEscapeUtils.escapeXml(l_member_id.toUpperCase()));
			xmlString = xmlString.replaceAll("#memSurname", StringEscapeUtils.escapeXml(l_surname.toUpperCase()));
			xmlString = xmlString.replaceAll("#memInitial", StringEscapeUtils.escapeXml(l_initial.toUpperCase()));
			xmlString = xmlString.replaceAll("#relationship", StringEscapeUtils.escapeXml(l_depd_reln.toUpperCase()));
			xmlString = xmlString.replaceAll("#dependantCode", StringEscapeUtils.escapeXml(l_depd_code.toUpperCase()));

			l_app_msg = "Retrieving Hospital No...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_element_id = "HOSPITAL_NO";

			l_hospital_no = XHUtil.getHospitalNo(l_facility_id);
			if (l_hospital_no.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_hospital_no;
			}	
			l_app_msg = " ::: l_hospital_no : "+l_hospital_no;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			xmlString = xmlString.replaceAll("#hospNo", l_hospital_no.toUpperCase());

			l_app_msg = " Fetching Patient details... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			patDetailMap = new HashMap(FetchPatientDetails(patientId));

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
					l_app_msg = " ::: l_errmsg : "+l_errmsg;
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
					l_first_name = patDetailMap.get("FIRST_NAME").toString()==null?"":patDetailMap.get("FIRST_NAME").toString();					
					l_sex = patDetailMap.get("SEX").toString()==null?"":patDetailMap.get("SEX").toString();
					l_addr1_line1 = patDetailMap.get("ADDR1_LINE1").toString()==null?"":patDetailMap.get("ADDR1_LINE1").toString();
					l_addr1_line2 = patDetailMap.get("ADDR1_LINE2").toString()==null?"":patDetailMap.get("ADDR1_LINE2").toString();
					l_race_code = patDetailMap.get("RACE_CODE").toString()==null?"":patDetailMap.get("RACE_CODE").toString();
					l_res_town_desc = patDetailMap.get("CITY_DESC").toString()==null?"":patDetailMap.get("CITY_DESC").toString();
					l_postal1_code = patDetailMap.get("POSTAL1_CODE").toString()==null?"":patDetailMap.get("POSTAL1_CODE").toString();	
					l_passport_id = patDetailMap.get("PASSPORT_ID").toString()==null?"":patDetailMap.get("PASSPORT_ID").toString();
					l_res_area_desc = patDetailMap.get("AREA_DESC").toString()==null?"":patDetailMap.get("AREA_DESC").toString();

					l_app_msg = " ::: After Getting Patient Details from patDetailMap:  ::: " + l_national_id_no + " ::: " + l_name_prefix + " ::: " + l_first_name + " ::: " + l_third_name + " ::: " + l_family_name + " ::: " + l_patient_name + " ::: " + l_sex + " ::: " + l_date_of_birth + " ::: " + l_race_code + " ::: " + l_addr1_line1 + " ::: " + l_addr1_line2 + " ::: " + l_postal1_code + " ::: " + l_res_town_desc + " ::: " + l_passport_id+ " ::: " + l_res_area_desc;
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

					if (l_race_code.length()>0)
					{
						l_race_cd = getRaceCode(l_race_code);
					}
					l_app_msg = " ::: Race Code Returned:  ::: " + l_race_cd;
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

					l_app_msg = " ::: l_name_prefix after substring:  ::: " + l_name_prefix;
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

					xmlString = xmlString.replaceAll("#raceCode", l_race_cd);

					xmlString = xmlString.replaceAll("#patientId", StringEscapeUtils.escapeXml(patientId.toUpperCase()));
					xmlString = xmlString.replaceAll("#surname", StringEscapeUtils.escapeXml(l_family_name.toUpperCase()));
					xmlString = xmlString.replaceAll("#initial", StringEscapeUtils.escapeXml(l_name_prefix.toUpperCase()));
					xmlString = xmlString.replaceAll("#dob", l_date_of_birth.toUpperCase());
					xmlString = xmlString.replaceAll("#nationalId", StringEscapeUtils.escapeXml(l_national_id_no.toUpperCase()));
					xmlString = xmlString.replaceAll("#firstname", StringEscapeUtils.escapeXml(l_first_name.toUpperCase()));
					xmlString = xmlString.replaceAll("#gender", l_sex.toUpperCase());
					xmlString = xmlString.replaceAll("#addrLine1", StringEscapeUtils.escapeXml(l_addr1_line1.toUpperCase()));
					xmlString = xmlString.replaceAll("#addrLine2", StringEscapeUtils.escapeXml(l_addr1_line2.toUpperCase()));
					xmlString = xmlString.replaceAll("#raceCode", StringEscapeUtils.escapeXml(l_race_code.toUpperCase()));
					xmlString = xmlString.replaceAll("#city", StringEscapeUtils.escapeXml(l_res_town_desc.toUpperCase()));
					xmlString = xmlString.replaceAll("#postCode", StringEscapeUtils.escapeXml(l_postal1_code.toUpperCase()));	
                    xmlString = xmlString.replaceAll("#passport", StringEscapeUtils.escapeXml(l_passport_id.toUpperCase()));
					xmlString = xmlString.replaceAll("#prov", StringEscapeUtils.escapeXml(l_res_area_desc.toUpperCase()));
					xmlString = xmlString.replaceAll("XYZ", "");

					l_app_msg = " ::: xmlString:  ::: " + xmlString;
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

					l_adm_tag = "<ADMISS dt=\"#admdt\" tm=\"#admtm\" prm_diag=\"#admdiagcd\"/>";
                  
					l_app_msg = " Fetching admission and discharge date and time... ";
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

					/*

					query = "SELECT TO_CHAR (visit_adm_date_time, 'yyyymmdd') visit_adm_date, TO_CHAR (visit_adm_date_time, 'hh24miss') visit_adm_time, "
								+" TO_CHAR (nvl(discharge_date_time,visit_adm_date_time), 'yyyymmdd') disch_date, TO_CHAR (nvl(discharge_date_time,to_date(visit_adm_date_time ||' 23:59','dd/mm/yyyy hh24:mi:ss')), 'hh24miss') disch_time, DECEASED_DATE_TIME, "
								+" to_char(decode(PATIENT_CLASS,'OP', 1, 'IP', (to_date(nvl(discharge_date_time, nvl(DECEASED_DATE_TIME,sysdate)),'dd/mm/yyyy') - TO_DATE (visit_adm_date_time, 'dd/mm/yyyy') ), 1),99999.99) LOS "
								+" FROM pr_encounter "
								+" WHERE facility_id = ? AND encounter_id = ? AND patient_id = ?";

					*/

					l_app_msg = " ::: Facility Id: " + l_facility_id + " ::: Encounter ID: "+ l_encounter_id + " ::: Patient ID: "+ l_patient_id ;
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

					if (l_encounter_id.length()>0)
					{
						query = "SELECT TO_CHAR (visit_adm_date_time, 'yyyymmdd') visit_adm_date, TO_CHAR (visit_adm_date_time, 'hh24miss') visit_adm_time, "
							+" TO_CHAR (decode(PATIENT_CLASS, 'OP', nvl(discharge_date_time,visit_adm_date_time), 'AE', nvl(discharge_date_time,visit_adm_date_time), discharge_date_time), 'yyyymmdd') disch_date, "
							+" TO_CHAR (decode(PATIENT_CLASS,'OP',nvl(discharge_date_time,to_date(visit_adm_date_time ||' 23:59','dd/mm/yyyy hh24:mi:ss')), 'AE',nvl(discharge_date_time,to_date(visit_adm_date_time ||' 23:59','dd/mm/yyyy hh24:mi:ss')), discharge_date_time,'dd/mm/yyyy hh24:mi:ss'), 'hh24miss') disch_time, "
							+" DECEASED_DATE_TIME, "
							+" to_char(decode(PATIENT_CLASS,'OP', 1, 'IP', (to_date(nvl(discharge_date_time, nvl(DECEASED_DATE_TIME,sysdate)),'dd/mm/yyyy') - TO_DATE (visit_adm_date_time, 'dd/mm/yyyy') ), 1),99999.99) LOS "
							+" FROM pr_encounter "
							+" WHERE facility_id = ? AND encounter_id = ? AND patient_id = ?";

						pstmt = dbConn.prepareStatement(query);
						pstmt.setString(1, l_facility_id);
						pstmt.setString(2, l_encounter_id);
						pstmt.setString(3, l_patient_id);
						
						rs = pstmt.executeQuery();

						while(rs.next())
						{
							l_adm_dt = rs.getString("VISIT_ADM_DATE")==null?"":rs.getString("VISIT_ADM_DATE");
							l_adm_tm = rs.getString("VISIT_ADM_TIME")==null?"":rs.getString("VISIT_ADM_TIME");
							l_dis_dt = rs.getString("DISCH_DATE")==null?"":rs.getString("DISCH_DATE");
							l_dis_tm = rs.getString("DISCH_TIME")==null?"":rs.getString("DISCH_TIME");
							l_deceased_date = rs.getString("DECEASED_DATE_TIME")==null?"":rs.getString("DECEASED_DATE_TIME");
							l_los = rs.getString("LOS")==null?"1.00":rs.getString("LOS");
						}
					}

					l_app_msg = " ::: Admission Date: " + l_adm_dt + " ::: Admission Time: "+ l_adm_tm + " ::: Discharge Date: "+ l_dis_dt + " ::: Discharge Time: "+ l_dis_tm + " ::: Deceased Date Time: "+ l_deceased_date + " ::: LOS Time: "+ l_los;
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

					if (!(Double.parseDouble(l_los)>0))
					{
						l_los = "1.00";
					}
					
					l_app_msg = " ::: Admission Date: " + l_adm_dt + " ::: Admission Time: "+ l_adm_tm + " ::: Discharge Date: "+ l_dis_dt + " ::: Discharge Time: "+ l_dis_tm + " ::: Deceased Date Time: "+ l_deceased_date + " ::: LOS Time: "+ l_los;
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
					
					xmlString = xmlString.replaceAll("#los", l_los);

					if (l_adm_dt.length()>0)
						xmlString = xmlString.replaceAll("#admdate", l_adm_dt);
					else
						xmlString = xmlString.replaceAll("#admdate", l_request_date);	
					
					l_app_msg = " ::: xmlString:  ::: " + xmlString;
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

					l_adm_tag = l_adm_tag.replaceAll("#admdt", l_adm_dt);
					l_adm_tag = l_adm_tag.replaceAll("#admtm", l_adm_tm);

					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();

					l_app_msg = " Fetching diagnosis codes... ";
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

					query = "select TERM_CODE, B.DIAG_CLASS_TYPE, nvl(a.ENC_STAGE,'') ENC_STAGE  from PR_DIAGNOSIS_ENC_DTL a, MR_DIAG_CLASS b " +
							"where A.DIAG_CLASS_CODE = B.DIAG_CLASS_CODE and patient_id = ? and encounter_id = ? ";	

					pstmt = dbConn.prepareStatement(query);
					pstmt.setString(1, l_patient_id);
					pstmt.setString(2, l_encounter_id);		

					l_app_msg = " Fetching diagnosis codes l_facility_id ::: "+l_facility_id+" ::: "+l_encounter_id+" ::: "+l_patient_id;
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

					rs = pstmt.executeQuery();

					while(rs.next())
					{						
						l_prm_diag = rs.getString("TERM_CODE")==null?"":rs.getString("TERM_CODE");
						l_primary_yn = rs.getString("DIAG_CLASS_TYPE")==null?"":rs.getString("DIAG_CLASS_TYPE");
						l_ip_stg = rs.getString("ENC_STAGE")==null?"":rs.getString("ENC_STAGE");

						l_app_msg = " Diagnosis data l_prm_diag ::: "+l_prm_diag+" ::: "+l_primary_yn+" ::: "+l_ip_stg;
						if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

						if (l_ip_stg.equals("A") && l_primary_yn.equals("PD"))
						{
							l_adm_diag = l_prm_diag;
						}						
						if (l_ip_stg.equals("") && l_primary_yn.equals("PD"))
						{
							l_adm_diag = l_prm_diag;
						}
					}

					l_app_msg = " Diagnosis data l_adm_diag ::: "+l_adm_diag;
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

					l_adm_tag = l_adm_tag.replaceAll("#admdiagcd", StringEscapeUtils.escapeXml(l_adm_diag.toUpperCase()));
					if (l_admission_type.equals("2"))
					{
						xmlString = xmlString.replaceAll("#admiss", l_adm_tag);
					}
					else 
					{
						xmlString = xmlString.replaceAll("#admiss", "");
					}
							
				}
			}

			

			l_xml_msg = xmlString;

		}
		catch (Exception e)
		{
			l_xml_msg = "Error in "+ l_app_msg + " : " +  e.getMessage();
		}		
		finally
		{
			XHUtil.closeDBResources(rs, pstmt, null);
		}

		l_app_msg = " ::: l_xml_msg ::: "+l_xml_msg;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

		return l_xml_msg;
	}

	public String CreateFileName(String requestType, String seqNo, String caseNbr,String l_facility_id)
	{
		String l_app_msg = "";
		String l_element_id = "", l_segment_id = "ELC", l_standard_code = "ECLASTD";

		String l_file_name = "", l_file_prefix = "", l_hospital_no = "";

		l_app_msg = " ::: Inside CreateFileName ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = " ::: requestType : "+requestType+" ::: seqNo : "+seqNo+ " :::  caseNbr : "+caseNbr;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		//l_element_id = "HOSPITAL_NO";

		/*l_hospital_no = FetchStdCntrlSeg(l_segment_id, l_element_id, l_standard_code);
		if (l_hospital_no.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_hospital_no;

			return "Error" + "$!^"+ "Error in fetching hospital no" + "$!^"+ l_app_msg + "$!^" + l_errmsg; 
		}
		l_app_msg = " ::: l_hospital_no : "+l_hospital_no;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);*/

		
		l_app_msg = "Retrieving Hospital No...";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		//l_element_id = "HOSPITAL_NO";

		l_hospital_no = XHUtil.getHospitalNo(l_facility_id);
		if (l_hospital_no.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_hospital_no;
		}	
		l_app_msg = " ::: l_hospital_no : "+l_hospital_no;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		
		l_element_id = requestType+"_FILE";

		l_file_prefix = FetchStdCntrlSeg(l_segment_id, l_element_id, l_standard_code);
		if (l_hospital_no.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_file_prefix;

			return "Error" + "$!^"+ "Error in fetching l_file_prefix" + "$!^"+ l_app_msg + "$!^" + l_errmsg; 
		}
		l_app_msg = " ::: l_file_prefix : "+l_file_prefix;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		/*l_file_prefix = "RealtimeReq";
		if (requestType.equals("ELCREQ"))
		{
			l_file_prefix = "RealtimeReq";
		}
		if (requestType.equals("ELCREP"))
		{
			l_file_prefix = "RealtimeReply";
		}
		if (requestType.equals("ELCREJ"))
		{
			l_file_prefix = "RealtimeRej";
		}
		if (requestType.equals("ELCFAI"))
		{
			l_file_prefix = "RealtimeFail";
		}
		*/
		l_file_name = l_file_prefix + "." + l_hospital_no + caseNbr + seqNo;

		l_app_msg = " ::: l_file_name : "+l_file_name;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		

		return l_file_name;

	}

	public String WriteFile(String fileName, String filePath, String message)
	{
		String l_app_msg = "";

		String l_file_name = "";

		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;

		l_app_msg = " ::: Inside WriteFile ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		try {

				File dir = new File(filePath);
 
				if (!dir.exists()) {
					dir.mkdir();
				}

				l_file_name = filePath+File.separator+fileName+".xml";

				l_app_msg = " ::: l_file_name ::: "+l_file_name;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				fileWriter = new FileWriter(l_file_name);
				bufferedWriter = new BufferedWriter(fileWriter);
				bufferedWriter.write(message);
				bufferedWriter.close();
			}
			catch(IOException ex) {
				return "Error" + "$!^"+ "Error in writing file" + "$!^"+ l_app_msg + "$!^" + l_file_name + "$!^" + ex.getMessage(); 
			}		

		return "S";

	}

	public String ReadResponseFile(String fileName, String filePath)
	{
		String l_app_msg = "", l_xml_msg = ""; String line = null;

		String l_file_name = "";

		FileReader fileReader = null;
		BufferedReader bufferedReader = null;

		l_app_msg = " ::: Inside WriteFile ::: ";
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

	public String FetchResponseMessage(String directoryName, String fileName, int seconds,String l_request_type)
	{		
		String l_response_msg = "";
		String l_app_msg = "", l_file_name = "";
		String search  = "Processed";

		try{

			l_app_msg = "Inside FetchResponseMessage ::: ";
	        if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_file_name = fileName +".xml";

			l_app_msg = " ::: directoryName : "+ directoryName +" ::: fileName : "+l_file_name + " ::: seconds : " + seconds;
	        if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			File folder = new File(directoryName);
			
			File[] listOfFiles = folder.listFiles();

			l_app_msg = "::: List of Files array Length: "+listOfFiles.length ;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			stopRequested = false;

			for (int i = 0; i < listOfFiles.length; i++) 
			{
				if (listOfFiles[i].isFile()) 
				{
					if (l_debug_YN.equals("Y"))  System.out.println(listOfFiles[i].getName());
					if ((listOfFiles[i].getName().toLowerCase()).equals(l_file_name.toLowerCase())) 
					{
						String filename = directoryName+ File.separator+listOfFiles[i].getName();	
						if (l_debug_YN.equals("Y")) System.out.println(" ::: "+filename);

						l_response_msg = XHUtil.readFile(filename);
						
						l_app_msg = "FetchResponseMessage::: read success :: l_response_msg : "+l_response_msg ;
						if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
						if(directoryName.toLowerCase().indexOf(search.toLowerCase()) == -1){
							doMove(directoryName,listOfFiles[i].getName(),"Processed");
						}
						stopRequested = true;
						
						break;
					}
				}
			}	
			l_app_msg = "::: stopRequested: "+stopRequested ;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			if (!(stopRequested))
			{
				l_response_msg = "FILE_NOT_FOUND";
			}
	           
		}
		catch(Exception e)
		{
			return "Error" + "$!^"+ l_app_msg + "$!^" + l_file_name + "$!^" + e.getMessage(); 
		}

		return l_response_msg;
	}
	private  void doMove(String directory,String fileName, String folderName) {
		        // File (or Directory) to be moved
        File file = new File(directory+File.separator+fileName);
 
        // Destination directory
        File dir = new File(directory+File.separator+folderName);
 
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


	public static void readStop() {
		stopRequested = true;
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
			System.out.println("SQL. Could not convert CLOB to string ::: "+e.toString());
			return e.toString();
		}
		catch (IOException e)
		{
			System.out.println("IO. Could not convert CLOB to string ::: "+e.toString());
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

		l_app_msg = " ::: Inside FetchStdCntrlSeg ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = " ::: Segment ID : "+ segmentID + " ::: Element ID : " + elementId + " ::: Standard Code : "+ standardCode;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		
		l_app_msg = " ::: Retrieving "+ elementId + " Value...";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

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
			   l_field_value = rs.getString("DEFAULT_VALUE");
			}
			
		}
		catch(Exception e)
		{
			l_field_value = "Error in "+ l_app_msg + " : " +  e.getMessage();
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

		l_app_msg = " ::: Inside FetchResponseWaitTime ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = " ::: Plugin Type : "+ pluginType;
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
			
		}
		catch(Exception e)
		{
			l_field_value = "Error in "+ l_app_msg + " : " +  e.getMessage();
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

		l_app_msg = " ::: Inside GenerateTransIDMethod ::: ";
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
			l_field_value = "Error in "+ l_app_msg + " : " +  e.getMessage();
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
		int l_wait_time = 0;

		String l_processed_directory = "";
		
		boolean l_next_file_flag = true;

		int l_file_flag = 0, l_no_file_flag = 0;

		String l_success_flag = "";

		l_app_msg = "Inside GetResponseMessage...";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = "::: l_request : "+l_request+ " ::: l_trans_value : "+l_trans_value+" ::: l_case_nbr : "+l_case_nbr;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

		try
		{	
			l_app_msg = "Calling Fetch Protocol Method Error Status..."+l_errcd;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			if (l_errcd.equals("S"))
			{
				l_file_directory = FetchProtocolDetails("ECLAIMSPL");
				if (l_file_directory.indexOf("Error")>=0)
				{
					l_errcd = "E";
					l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_file_directory;
					return l_errmsg;
				}
				l_app_msg = " ::: File  Directory : "+l_file_directory;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			}

			l_app_msg = " ::: Directory Name : "+l_file_directory;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_app_msg = "Calling FetchResponseWaitTime...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			
			l_wait_time_str = FetchResponseWaitTime("ECLAIMS");
			if (l_wait_time_str.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_wait_time_str;
				return l_errmsg;
			}

			l_app_msg = " ::: l_wait_time_str : "+l_wait_time_str+" ::: Error Status ::: "+l_errcd;
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

				l_app_msg = " ::: l_file_flag : "+l_file_flag;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				if (l_no_file_flag>2)
				{
					l_next_file_flag = false;
					l_app_msg = " ::: Before Break Response Message :::  "+l_response_msg;
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
					break;
				}

				if (l_file_flag == 0)
				{
					l_request_type = "ELCREP";
					l_success_flag = "01";
				}
				if (l_file_flag == 1)
				{
					l_request_type = "ELCREJ";
					l_success_flag = "02";
				}
				if (l_file_flag == 2)
				{
					l_request_type = "ELCFAI";
					l_success_flag = "03";
				}

				l_app_msg = "Calling Create File Name...";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
					
				l_file_name = CreateFileName(l_request_type, l_trans_value, l_case_nbr,l_facility_id);
				if (l_file_name.indexOf("Error")>=0)
				{
					l_errcd = "E";
					l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_file_name;
					return l_errmsg;
				}
				l_app_msg = " ::: File Name : "+l_file_name;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				
				l_response_msg = FetchResponseMessage(l_file_directory, l_file_name, l_wait_time, l_request_event_type);
				if (l_response_msg.indexOf("Error")>=0)
				{
					l_errcd = "E";
					l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_response_msg;
					l_next_file_flag = false;
				}
				l_app_msg = " ::: l_response_msg : "+l_response_msg+" ::: Error Status ::: "+l_errcd;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				if (l_errcd.equals("S"))
				{
					if (l_response_msg.equals("FILE_NOT_FOUND"))
					{

						if(l_request_event_type.equals("ELCRES"))
						{
							l_processed_directory = l_file_directory+ File.separator +"Processed";

							l_response_msg = FetchResponseMessage(l_processed_directory, l_file_name, l_wait_time, l_request_event_type);
							if (l_response_msg.indexOf("Error")>=0)
							{
								l_errcd = "E";
								l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_response_msg;
								l_next_file_flag = false;
							}
							l_app_msg = " ::: l_response_msg : "+l_response_msg;
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

				
				l_app_msg = " Inside l_no_file_flag>2:::  "+l_response_msg;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			}
		}
		catch (Exception e)
		{
			l_app_msg = " Error in reading the file - "+e.getMessage();
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			l_success_flag = "4";
			l_file_name = "";
			l_response_msg = "<STATUS>" + l_success_flag + "$!^<FILE_TYPE>" + l_request_type + "$!^<FILE_NAME>" + l_file_name + "$!^<RESPONSE>" + l_app_msg +"$!^";
			return l_response_msg;
		}
		
		l_app_msg = " ::: Return Response Message :::  "+l_response_msg;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		return l_response_msg;

	}

	public String ParseResponseMessage(String request, String responseMsg,String actionKey)
	{
		
		String l_app_msg = "";
		String l_response_str = "", l_xsl_string = "",l_dep_rln = "";

		l_app_msg = "Inside ParseResponseMessage...";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		XHUtil xhUtil = null;

		try
		{	
			xhUtil = new XHUtil();	
					
			l_app_msg = " ::: Calling FetchXMLFormat ... ";
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
				l_app_msg = " ::: XSL String Generated : "+l_xsl_string;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			}

			l_app_msg = " ::: Fetching Dependent code... ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_dep_rln = FetchFieldValue(actionKey, "<DEPD_RELN>", null, l_field_separator, "ParseResponseMessage");
			if (l_dep_rln.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_dep_rln;
			}
			l_app_msg = " ::: l_dep_rln : "+l_dep_rln;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

            l_xsl_string = l_xsl_string.replaceAll("#depRln", l_dep_rln);

			l_app_msg = " ::: Calling XHUTIL.transformData ... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
            
			l_response_str  = xhUtil.transformData(responseMsg, l_xsl_string);
			if (l_response_str.indexOf("Error")>=0)
			{
				l_errcd = "E";
				//l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_response_str;

                l_errmsg = l_response_str;
			    l_app_msg = " ::: l_errmsg : "+l_errmsg;
			    if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				return l_errmsg;
			}
			l_app_msg = " ::: l_response_str : "+l_response_str;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
				
		}
		catch (Exception e)
		{
			l_app_msg = " ::: l_response_str : "+e.getMessage();
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		}

		return l_response_str;

	}

	public String updateEmpDetails(String request, String l_response, String actionKey, String l_srl_no,String l_membership_num){

		String  l_app_msg = "",errorMsg = "";
		//Connection dbConn = null;
		String l_addr_line_1 = "", l_addr_line_2 = "", l_addr_suburb = "", l_addr_city = "", l_addr_post_cd = "", l_addr_prov_name = ""; 			
		String l_tele_phone_work = "", l_tele_phone_home = "", l_cell_number = ""; 			
		String l_emp_date = "", l_emp_name = "", l_inc_cons_nbr = "", l_inc_pred_income = "";

		int l_trans_value = 0 , l_count = 0;

        int l_addr_count = 0, l_tel_count = 0, l_emp_count = 0, l_income_count = 0;

		ResultSet rs=null;
		PreparedStatement pstmt = null;

		String query = "", l_update_stmt = "",l_insert_stmt  = "";
		int l_update_count = 0, l_insert_count = 0;
	
		l_app_msg = " ::: Inside updateEmpDetails... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_app_msg = " ::: L_SRL_NO ::: "+l_srl_no+" ::: L_MEMBERSHIP_NUM ::: "+l_membership_num;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		try
		{
			//dbConn =  ConnectionManager.getConnection();

			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			InputSource is = new InputSource();
			is.setCharacterStream(new StringReader(l_response));

			Document doc = db.parse(is);

			NodeList addrNodesList = doc.getElementsByTagName("ADDR");

			l_addr_count = addrNodesList.getLength();

			if (l_addr_count <=0)
			{
				addrNodesList = doc.getElementsByTagName("ADR");
				l_addr_count = addrNodesList.getLength();
			} 
			 
			if (addrNodesList != null)
			{
				l_addr_count = addrNodesList.getLength();

				l_app_msg = " ::: Address NodesList Length ::: "+l_addr_count;
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

				if (l_addr_count>0)
				{			
					for (int i = 0; i < 1; i++) 
					{
						if (addrNodesList.item(i).getNodeType() == Node.ELEMENT_NODE) 
						{
							Element el = (Element) addrNodesList.item(i);
							l_addr_line_1 = StringEscapeUtils.unescapeXml(el.getAttribute("line_1"));
							l_addr_line_2 = StringEscapeUtils.unescapeXml(el.getAttribute("line_2"));
							l_addr_suburb = StringEscapeUtils.unescapeXml(el.getAttribute("suburb"));
							l_addr_city = StringEscapeUtils.unescapeXml(el.getAttribute("city"));
							l_addr_post_cd = StringEscapeUtils.unescapeXml(el.getAttribute("post_cd"));
							l_addr_prov_name = StringEscapeUtils.unescapeXml(el.getAttribute("prov"));
						}
					}

					l_app_msg = " ::: Address l_addr_line_1 ::: "+l_addr_line_1+" ::: l_addr_line_2 ::: "+l_addr_line_2+" ::: suburb ::: "+l_addr_suburb+" ::: city ::: "+l_addr_city+" ::: post_cd ::: "+l_addr_post_cd+" ::: l_addr_prov_name ::: "+l_addr_prov_name;
					if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				}
			}

			NodeList telNodesList = doc.getElementsByTagName("TEL");
			 
			if (telNodesList != null)
			{
				l_tel_count = telNodesList.getLength();

				l_app_msg = " ::: Telephone NodesList Length ::: "+l_tel_count;
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

				if (l_tel_count>0)
				{	
					for (int i = 0; i < 1; i++) 
					{
						if (telNodesList.item(i).getNodeType() == Node.ELEMENT_NODE) 
						{
							Element el = (Element) telNodesList.item(i);
							l_tele_phone_home = StringEscapeUtils.unescapeXml(el.getAttribute("tel_nbr_home"));
							l_tele_phone_work = StringEscapeUtils.unescapeXml(el.getAttribute("tel_nbr_work"));
							l_cell_number = StringEscapeUtils.unescapeXml(el.getAttribute("cell_nbr"));
						}
					}
					l_app_msg = " ::: l_tele_phone_home ::: "+l_tele_phone_home+" ::: l_tele_phone_work ::: "+l_tele_phone_work+" ::: l_cell_number ::: "+l_cell_number;
					if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				}
			}

			NodeList empNodesList = doc.getElementsByTagName("EMP");
			 
			if (empNodesList != null)
			{
				l_emp_count = empNodesList.getLength();

				l_app_msg = " ::: Employee NodesList Length ::: "+l_emp_count;
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

				if (l_emp_count>0)
				{	
					for (int i = 0; i < 1; i++) 
					{
						if (empNodesList.item(i).getNodeType() == Node.ELEMENT_NODE) 
						{
							Element el = (Element) empNodesList.item(i);
							l_emp_name = StringEscapeUtils.unescapeXml(el.getAttribute("empl"));
							l_emp_date = StringEscapeUtils.unescapeXml(el.getAttribute("info_dt"));
						}
					}
					l_app_msg = " ::: l_emp_name ::: "+l_emp_name+" ::: l_emp_date ::: "+l_emp_date;
					if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				}
			}

			NodeList incomeNodesList = doc.getElementsByTagName("INCOME_ESTIMATOR");
			 
			if (empNodesList != null)
			{
				l_income_count = incomeNodesList.getLength();

				l_app_msg = " ::: Employee NodesList Length ::: "+l_income_count;
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

				if (l_income_count>0)
				{	
					for (int i = 0; i < 1; i++) 
					{
						if (incomeNodesList.item(i).getNodeType() == Node.ELEMENT_NODE) 
						{
							Element el = (Element) incomeNodesList.item(i);
							l_inc_cons_nbr = StringEscapeUtils.unescapeXml(el.getAttribute("tu_consumer_nbr"));
							l_inc_pred_income = StringEscapeUtils.unescapeXml(el.getAttribute("tu_predicted_income"));
						}

					}
					l_app_msg = " ::: l_inc_cons_nbr ::: "+l_inc_cons_nbr+" ::: l_inc_pred_income ::: "+l_inc_pred_income;
					if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				}
			}
		}
		catch (Exception e)
		{
			l_errcd = "E";
			l_errmsg = "Error in UPDATEEMPDETAILS : "+l_trans_value +" ::: "+ l_app_msg + " : " +  e.getMessage();
			errorMsg = l_errmsg;
			return errorMsg;
		}
		
		try
		{

			if (l_addr_count>0 || l_tel_count>0 || l_emp_count>0 || l_income_count>0 )
			{
				l_trans_value = Integer.parseInt(l_srl_no);

				//dbConn = ConnectionManager.getConnection();
				query = " select count(*) COUNT from XF_ECLAIMS_PAT_DETAILS where MEMBERSHIP_NUM = ?" ;

				pstmt = dbConn.prepareStatement(query);
				pstmt.setString(1, l_membership_num);

				rs = pstmt.executeQuery();
				while(rs.next())
				{
				   l_count = rs.getInt("COUNT");
				}

				l_app_msg = " ::: XF_ECLAIMS_PAT_DETAILS Count : "+l_count+" for the MEMBERSHIP_NUM ::: "+l_membership_num;
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
				if(l_count>0)
				{
					l_app_msg = " ::: Inside UPDATE XF_ECLAIMS_PAT_DETAILS : ";
					if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

					try
					   {
							pstmt = null;
				
							l_update_stmt = " UPDATE XF_ECLAIMS_PAT_DETAILS "
											+" SET	ADDR_LINE_1	= ?, "
											+" ADDR_LINE_2	    = ?, "
											+" ADDR_SUBURB		= ?, "
											+" ADDR_CITY	    = ?, "
											+" ADDR_POST_CD		= ?, "
											+" TELE_PHONE_WORK	= ?, "
											+" TELE_PHONE_HOME	= ?, "
											+" CELL_NUMBER	    = ?, "
											+" EMP_DATE		    = ?, "
											+" EMP_NAME	        = ?, "
											+" INC_CONS_NBR		= ?, "
											+" INC_PRED_INCOME	= ?, "
											+" SRL_NO           = ? "
											+" WHERE MEMBERSHIP_NUM   = ? " ;

							pstmt = dbConn.prepareStatement(l_update_stmt);
							pstmt.setString(1, l_addr_line_1);
							pstmt.setString(2, l_addr_line_2);
							pstmt.setString(3, l_addr_suburb);
							pstmt.setString(4, l_addr_city);
							pstmt.setString(5, l_addr_post_cd);
							pstmt.setString(6, l_tele_phone_work);
							pstmt.setString(7, l_tele_phone_home);
							pstmt.setString(8, l_cell_number);
							pstmt.setString(9, l_emp_date);
							pstmt.setString(10, l_emp_name);
							pstmt.setString(11, l_inc_cons_nbr);
							pstmt.setString(12, l_inc_pred_income);
							pstmt.setInt(13, l_trans_value);
							pstmt.setString(14, l_membership_num);
				

							l_update_count = pstmt.executeUpdate();

							l_app_msg = " ::: UPDATE XF_ECLAIMS_PAT_DETAILS : SRL_NO : "+l_srl_no +" :: UpdateCount :: " +l_update_count;
							if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
							
							if (l_update_count == 1)
							{
								//dbConn.commit();		
								l_errcd = "S";
								l_errmsg = "Eclaims Pat Details table updated successfully ";

								errorMsg = "Eclaims Pat Details table updated successfully ";
							}
							else
							{
								//dbConn.rollback();	
								l_errcd = "E";
								l_errmsg = " Error in updating Eclaims Pat Details  Records ";	
								
								errorMsg = l_errmsg;

								return errorMsg;
							}

						}
						catch(Exception e)
						{
							l_errcd = "E";
							l_errmsg = "Error in UPDATEEMPDETAILS update : "+l_trans_value +" ::: "+ l_app_msg + " : " +  e.getMessage();
							errorMsg = l_errmsg;
							return errorMsg;
						}
						finally
						{			
							closeDBResources(rs, pstmt, null);				
						}	
				}
				else
				{
					l_app_msg = " ::: Inside INSERT XF_ECLAIMS_PAT_DETAILS ::: ";
					if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

					try
						{
							pstmt = null;

							l_insert_stmt = " INSERT into XF_ECLAIMS_PAT_DETAILS (ADDR_LINE_1, ADDR_LINE_2, ADDR_SUBURB, ADDR_CITY, ADDR_POST_CD,"
												+" TELE_PHONE_WORK, TELE_PHONE_HOME, CELL_NUMBER, "
												+" EMP_DATE, EMP_NAME, INC_CONS_NBR, INC_PRED_INCOME, MEMBERSHIP_NUM, SRL_NO) "
												+" values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

							l_app_msg = " ::: l_insert_stmt : "+l_insert_stmt;
							if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

							pstmt = dbConn.prepareStatement(l_insert_stmt);

							pstmt.setString(1, l_addr_line_1);
							pstmt.setString(2, l_addr_line_2);
							pstmt.setString(3, l_addr_suburb);
							pstmt.setString(4, l_addr_city);
							pstmt.setString(5, l_addr_post_cd);
							pstmt.setString(6, l_tele_phone_work);
							pstmt.setString(7, l_tele_phone_home);
							pstmt.setString(8, l_cell_number);
							pstmt.setString(9, l_emp_date);
							pstmt.setString(10, l_emp_name);
							pstmt.setString(11, l_inc_cons_nbr);
							pstmt.setString(12, l_inc_pred_income);
							pstmt.setString(13, l_membership_num);
							pstmt.setInt(14, l_trans_value);
					
							l_insert_count = pstmt.executeUpdate();	
							
							l_app_msg = " ::: l_insert_count : "+ l_insert_count;
							if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
							
							if(l_insert_count == 1) {
								l_errcd = "S";
								l_errmsg = "Eclaims Patient Details table inserted successfully ";
								errorMsg = "Eclaims Patient Details table inserted successfully ";
								//dbConn.commit();				
							}
							else {		
								l_errcd = "E";
								errorMsg = "Error in inserting EClaims Patient Details table";
								return errorMsg;
							}
						}
						catch(Exception e)
						{
							l_errcd = "E";
							l_errmsg = "Error in UPDATEEMPDETAILS Insert "+ l_app_msg + " : " +  e.getMessage();
						}
						finally
						{			
							closeDBResources(rs, pstmt, null);				
						}	
				}
			}
		}
		catch (Exception e) {
			l_errcd = "E";
			l_errmsg = "Error in UPDATEEMPDETAILS : "+l_trans_value +" ::: "+ l_app_msg + " : " +  e.getMessage();
			errorMsg = l_errmsg;
			e.printStackTrace();
			return errorMsg;
		}
		finally {
			closeDBResources(rs, pstmt, null);
		}

		return errorMsg;
      
	}


	public String UpdateInteractiveDetails(Map params)
	{
		Connection dbConnInt = null;

		ResultSet rs=null;
		PreparedStatement pstmt = null;
		String query = "", l_insert_stmt = "", l_update_stmt = "";
		String errorCode = "", errorMsg = "";
		String l_episode_type = "", l_encounter_id = "";

		String l_response_msg = "", l_response_str = "", l_errcd = "", l_errmsg = "", l_response_syntax = "";
		int l_trans_value = 0;

		java.sql.Timestamp l_current_date = null;

		String l_app_msg = "";

		int l_interactive_count = 0, l_insert_count = 0, l_update_count = 0;

		try
		{
			l_app_msg = "Inside UpdateInteractiveDetails...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_trans_value = Integer.parseInt(params.get("MSG_ID").toString());

			l_app_msg = " ::: PGM_ID : "+ params.get("PGM_ID").toString() + " ::: TRX_NO : " + l_trans_value + " ::: EVENT_TYPE : "+ params.get("EVENT_TYPE").toString();
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);				

			dbConnInt = ConnectionManager.getConnection();
			query = " select count(*) INTERACTIVE_COUNT from XH_INTERACTIVE_INTEGRATION where PGM_ID = ? and TRX_NO = ? and EVENT_TYPE = ? " ;

			pstmt = dbConnInt.prepareStatement(query);
			pstmt.setString(1, params.get("PGM_ID").toString());
			pstmt.setInt(2, l_trans_value);
			pstmt.setString(3, params.get("EVENT_TYPE").toString());

			rs = pstmt.executeQuery();
			while(rs.next())
			{
			   l_interactive_count = rs.getInt("INTERACTIVE_COUNT");
			}
			
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
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_response_str = params.get("ACKNOWLEDGEMENT_TEXT").toString();
				l_app_msg = "::: ACKNOWLEDGEMENT_TEXT : "+ l_response_str;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_errcd = params.get("STATUS").toString();
				l_app_msg = "::: STATUS : "+ l_errcd;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_errmsg = params.get("ERROR_MESSAGE").toString();
				l_app_msg = "::: ERROR_MESSAGE : "+ l_errmsg;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
				
				l_response_syntax = params.get("REPONSE_SYNTAX").toString();
				l_app_msg = "::: REPONSE_SYNTAX : "+ l_response_syntax;
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

					pstmt = dbConnInt.prepareStatement(l_update_stmt);
					pstmt.setString(1, l_response_msg);
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
						dbConnInt.commit();		
						errorCode = "S";
						errorMsg = "Interactive Integartion Transaction table updated successfully ";
					}
					else
					{
						dbConnInt.rollback();	
						l_errcd = "E";
						l_errmsg = " Error in updating Interactive Integration Records ";	
						
						errorCode = "E";
						errorMsg = l_errmsg;

						return errorCode +"$!^"+errorMsg;
					}

				}
				catch(Exception e)
				{
					l_errcd = "E";
					l_errmsg = "Error in MSG_ID : "+l_trans_value +" ::: "+ l_app_msg + " : " +  e.getMessage();
					errorCode = "E";
					errorMsg = l_errmsg;
					return errorCode +"$!^"+errorMsg;
				}
				finally
				{			
					closeDBResources(rs, pstmt, dbConnInt);				
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

				l_app_msg = "::: EPISODE_TYPE : " + l_episode_type;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = "::: ENCOUNTER_ID : "+ params.get("ENCOUNTER_ID").toString();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_encounter_id = params.get("ENCOUNTER_ID").toString();

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

				try
				{
					pstmt = null;

					l_insert_stmt = " INSERT into XH_INTERACTIVE_INTEGRATION (USER_ID, MACHINE_NAME, WS_NO, PGM_ID, MODULE_ID, "				
										+" SESSION_ID, REQUEST_DATE, REQUEST_TEXT, APPLICATION_ID, MESSAGE_ID, "
										+" FACILITY_ID, MESSAGE_DATE, EVENT_TYPE, PATIENT_ID, EPISODE_TYPE, "
										+" ENCOUNTER_ID, ACCESSION_NUM, REQUEST_SYNTAX, PROTOCOL_LINK_ID, ADDED_BY_ID, "
										+" ADDED_DATE, MODIFIED_BY_ID, MODIFIED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, "
										+" MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, TRX_NO, PROFILE_ID) "
										+" values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";			

					pstmt = dbConnInt.prepareStatement(l_insert_stmt);

					pstmt.setString(1, params.get("LOGIN_USER").toString());
					pstmt.setString(2, params.get("CLIENT_MACHINE").toString());
					pstmt.setString(3, params.get("CLIENT_MACHINE").toString());
					pstmt.setString(4, params.get("PGM_ID").toString());
					pstmt.setString(5, params.get("MODULE_ID").toString());
					
					pstmt.setString(6, params.get("SESSION_ID").toString());
					pstmt.setTimestamp(7, l_current_date);
					pstmt.setString(8, params.get("REQUEST_TEXT").toString());
					pstmt.setString(9, params.get("APPLICATION_ID").toString());
					pstmt.setString(10, params.get("MSG_ID").toString());

					pstmt.setString(11, params.get("FACILITY_ID").toString());
					pstmt.setTimestamp(12, l_current_date);
					pstmt.setString(13, params.get("EVENT_TYPE").toString());
					pstmt.setString(14, params.get("PATIENT_ID").toString());

					if (l_episode_type.equals("XXX"))
						pstmt.setString(15, "");
					else
						pstmt.setString(15, params.get("EPISODE_TYPE").toString());

					if (l_encounter_id.equals("XXX"))
						pstmt.setInt(16, 0);
					else
						pstmt.setLong(16, Long.parseLong(l_encounter_id));
										
					pstmt.setString(17, params.get("ACC_NO").toString());
					pstmt.setString(18, params.get("REQUEST_SYNTAX").toString());
					pstmt.setString(19, params.get("PROTOCOL_LINK_ID").toString());
					pstmt.setString(20, XHDBAdapter.isNullReplace(params.get("ADDED_BY_ID").toString(), params.get("LOGIN_USER").toString()));

					pstmt.setTimestamp(21, l_current_date);
					pstmt.setString(22, XHDBAdapter.isNullReplace(params.get("MODIFIED_BY_ID").toString(), params.get("LOGIN_USER").toString()));
					pstmt.setTimestamp(23, l_current_date);
					pstmt.setString(24, params.get("CLIENT_MACHINE").toString());
					pstmt.setString(25, XHDBAdapter.isNullReplace(params.get("ADDED_BY_FACILITY").toString(), params.get("FACILITY_ID").toString()));

					pstmt.setString(26, params.get("CLIENT_MACHINE").toString());
					pstmt.setString(27, XHDBAdapter.isNullReplace(params.get("ADDED_BY_FACILITY").toString(), params.get("FACILITY_ID").toString()));
					pstmt.setInt(28, l_trans_value);
					pstmt.setString(29, params.get("PROFILE").toString());		
					
					l_insert_count = pstmt.executeUpdate();	
					
					l_app_msg = " ::: l_insert_count : "+ l_insert_count;
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
					
					if(l_insert_count == 1) {
						errorCode = "S";
						errorMsg = "Interactive Integration table inserted successfully ";
						dbConnInt.commit();				
					}
					else {	
						dbConnInt.rollback();	
						errorMsg = "Error in inserting Interactive Integration table";
						return "E" +"$!^"+errorMsg;
					}
				}
				catch(Exception e)
				{
					l_errcd = "E";
					l_errmsg = "Error in "+ l_app_msg + " : " +  e.getMessage();
				}
				finally
				{			
					closeDBResources(rs, pstmt, dbConnInt);				
				}	
			}
		}
		catch (Exception exp) {
			exp.printStackTrace();
			System.out.println("(UpdateInteractiveDetails) Exception " + exp.getMessage());
			return "E" +"$!^"+exp.getMessage();
		}
		finally {
			closeDBResources(rs, pstmt, null);
		}

		return errorCode +"$!^"+ errorMsg;
	}

	public String UpdateEClaimsDetails(Map params)
	{
		//Connection dbConn = null;

		ResultSet rs=null;
		PreparedStatement pstmt = null;
		String query = "", l_insert_stmt = "", l_update_stmt = "";
		String errorCode = "", errorMsg = "";
		String l_encounter_id = "", l_wca_num = "", l_episode_id = "", l_episode_type = "", l_visit_id = "";

		String l_where_condition = "";

		java.sql.Timestamp l_current_date = null;

		String l_errcd = "", l_errmsg = "";
		int l_trans_value = 0;

		String l_app_msg = "";

		int l_eclaims_count = 0, l_insert_count = 0, l_update_count = 0;

		String l_file_name_for_nrl_resp = "", l_inbound_xml_reply = "", l_file_name_for_rej_resp = "", l_inbound_xml_rej = "", l_file_name_for_failed_resp = "", l_inbound_xml_fail = "", l_request_status = "", l_authorization_num = "", l_approval_status = "";

		String l_facility_id = "", l_patient_id = "", l_cust_code = "", l_dest_code = "", l_warn_code="",l_warn_desc="";
        
		String l_surname = "",l_initial = "";

		String l_blng_grp_id = "", l_settlement_ind = "";

		String whereCond = "";

		try
		{
			l_app_msg = "Inside UpdateEClaimsDetails...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_facility_id = params.get("FACILITY_ID").toString();
			l_app_msg = "::: FACILITY_ID : "+ l_facility_id;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_patient_id = params.get("PATIENT_ID").toString();
			l_app_msg = "::: PATIENT_ID : "+ l_patient_id;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_cust_code = params.get("CUST_CODE").toString();
			l_app_msg = "::: CUST_CODE : "+ l_cust_code;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_blng_grp_id = params.get("BLNG_GRP_ID").toString();
			l_app_msg = "::: BLNG_GRP_ID : "+ l_blng_grp_id;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_settlement_ind = params.get("SETTLEMENT_IND").toString();
			l_app_msg = "::: SETTLEMENT_IND : "+ l_settlement_ind;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_dest_code = params.get("DEST_CODE").toString();
			l_app_msg = "::: DEST_CODE : "+ l_dest_code;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_episode_type = params.get("EPISODE_TYPE").toString();
			l_app_msg = "::: EPISODE_TYPE : "+ l_episode_type;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			if (!(l_episode_type.equals("XXX")))
			{
				l_where_condition = " AND EPISODE_TYPE = ? ";
			}

			l_episode_id = params.get("EPISODE_ID").toString();
			l_app_msg = "::: EPISODE_ID : "+ l_episode_id;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);				

			if (!(l_episode_id.equals("XXX")))
			{
				l_where_condition = l_where_condition + " AND EPISODE_ID = ? ";
			}

			l_visit_id = params.get("VISIT_ID").toString();
			l_app_msg = "::: VISIT_ID : "+ l_visit_id;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			if (!(l_visit_id.equals("XXX")))
			{
				l_where_condition = l_where_condition + " AND VISIT_ID = ? ";
			}

            l_surname = params.get("M_SURNAME").toString();
			l_app_msg = "::: M_SURNAME : "+ l_surname;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_initial = params.get("M_INITIAL").toString();
			l_app_msg = "::: M_INITIAL : "+ l_initial;
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

			l_app_msg = "::: whereCond : "+ whereCond;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			

			l_app_msg = " ::: FACILITY_ID : "+ l_facility_id + " ::: PATIENT_ID : " + l_patient_id + " ::: CUST_CODE : "+ l_cust_code + " ::: DEST_CODE : " + l_dest_code + " ::: SRL_NO : "+ l_trans_value + " ::: BLNG_GRP_ID : " +l_blng_grp_id;

			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			//dbConn = ConnectionManager.getConnection();
			query = " select count(*) CLAIMS_COUNT from XF_ECLAIMS_TRX_HDR "
						+" where FACILITY_ID = ? and PATIENT_ID = ?  AND DESTINATION_CODE = ? and SRL_NO = ? " 
						+ whereCond;

			if (l_where_condition.length() > 0)
			{
				query = query + l_where_condition;
			}

			l_app_msg = "::: QUERY : "+ query;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			pstmt = dbConn.prepareStatement(query);
			pstmt.setString(1, l_facility_id);
			pstmt.setString(2, l_patient_id);
			pstmt.setString(3, l_dest_code);
			pstmt.setInt(4, l_trans_value);
			if (l_settlement_ind.equals("C"))
			{
				pstmt.setString(5, l_blng_grp_id);
			}
			else if (l_settlement_ind.equals("X") || l_settlement_ind.equals("R"))
			{
				pstmt.setString(5, l_cust_code);
			}

			if (!(l_episode_type.equals("XXX")))
			{
				pstmt.setString(6, l_episode_type);
			}
			if (!(l_episode_id.equals("XXX")))
			{
				pstmt.setInt(7, Integer.parseInt(l_episode_id));
			}
			if (!(l_visit_id.equals("XXX")))
			{
				pstmt.setInt(8, Integer.parseInt(l_visit_id));
			}

			rs = pstmt.executeQuery();
			while(rs.next())
			{
			   l_eclaims_count = rs.getInt("CLAIMS_COUNT");
			}
			
			l_app_msg = " ::: CLAIMS_COUNT : "+ l_eclaims_count;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			if (l_eclaims_count > 0 )
			{
				//update XF_ECLAIMS_TRX_HDR table 
				l_app_msg = "Inside UPDATE XF_ECLAIMS_TRX_HDR table...";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_current_date = new java.sql.Timestamp(System.currentTimeMillis());
				
				l_file_name_for_nrl_resp = params.get("FILE_NAME_FOR_NRL_RESP").toString();
				l_app_msg = "::: FILE_NAME_FOR_NRL_RESP : "+ l_file_name_for_nrl_resp;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				if (l_file_name_for_nrl_resp.equals("XXX"))
				{
					l_file_name_for_nrl_resp = "";
				}

				l_inbound_xml_reply = params.get("INBOUND_XML_REPLY").toString();
				l_app_msg = "::: INBOUND_XML_REPLY : "+ l_inbound_xml_reply;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				if (l_inbound_xml_reply.equals("XXX"))
				{
					l_inbound_xml_reply = "";
				}

				l_file_name_for_rej_resp = params.get("FILE_NAME_FOR_REJ_RESP").toString();
				l_app_msg = "::: FILE_NAME_FOR_REJ_RESP : "+ l_file_name_for_rej_resp;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				if (l_file_name_for_rej_resp.equals("XXX"))
				{
					l_file_name_for_rej_resp = "";
				}

				l_inbound_xml_rej = params.get("INBOUND_XML_REJ").toString();
				l_app_msg = "::: INBOUND_XML_REJ : "+ l_inbound_xml_rej;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				if (l_inbound_xml_rej.equals("XXX"))
				{
					l_inbound_xml_rej = "";
				}
				
				l_file_name_for_failed_resp = params.get("FILE_NAME_FOR_FAILED_RESP").toString();
				l_app_msg = "::: FILE_NAME_FOR_FAILED_RESP : "+ l_file_name_for_failed_resp;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				if (l_file_name_for_failed_resp.equals("XXX"))
				{
					l_file_name_for_failed_resp = "";
				}

				l_inbound_xml_fail = params.get("INBOUND_XML_FAIL").toString();
				l_app_msg = "::: INBOUND_XML_FAIL : "+ l_inbound_xml_fail;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				if (l_inbound_xml_fail.equals("XXX"))
				{
					l_inbound_xml_fail = "";
				}				

				l_approval_status = params.get("APPROVAL_STATUS").toString();
				l_app_msg = "::: APPROVAL STATUS : "+ l_approval_status;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				if (l_approval_status.equals("XXX"))
				{
					l_approval_status = "";
				}

				l_request_status = params.get("REQUEST_STATUS").toString();
				l_app_msg = "::: request_status : "+ l_request_status;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				if (l_request_status.equals("XXX"))
				{
					l_request_status = "";
				}

				l_authorization_num = params.get("AUTHORIZATION_NUM").toString();
				l_app_msg = "::: AUTHORIZATION_NUM : "+ l_authorization_num;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);		
				
				if (l_authorization_num.equals("XXX"))
				{
					l_authorization_num = "";
				}

				l_warn_code = params.get("WARN_CODE").toString();
				l_app_msg = "::: warn_code : "+ l_warn_code;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				if (l_warn_code.equals("XXX"))
				{
					l_warn_code = "";
				}

				l_warn_desc = params.get("WARN_DESC").toString();
				l_app_msg = "::: warn_desc : "+ l_warn_desc;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				if (l_warn_desc.equals("XXX"))
				{
					l_warn_desc = "";
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
									+" AUTHORIZATION_NUM			= ?, "
									+" APPROVAL_STATUS				= ?, "
									+" WARN_CODE			        = ?, "
									+" WARN_DESC			        = ?, "
									+" MODIFIED_DATE				= ?  "
									+" WHERE FACILITY_ID	= ? " 
										+" AND PATIENT_ID	= ? " 										
										+" AND DESTINATION_CODE	= ? " 
										+" AND SRL_NO		= ? " ;

					if (whereCond.length() > 0)
					{
						l_update_stmt = l_update_stmt + whereCond;
					}					
					
					if (l_where_condition.length() > 0)
					{
						l_update_stmt = l_update_stmt + l_where_condition;
					}

					l_app_msg = "::: L_UPDATE_STMT : "+ l_update_stmt;
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

					pstmt = dbConn.prepareStatement(l_update_stmt);
					pstmt.setString(1, l_file_name_for_nrl_resp);
					pstmt.setString(2, l_inbound_xml_reply);
					pstmt.setString(3, l_file_name_for_rej_resp);
					pstmt.setString(4, l_inbound_xml_rej);
					pstmt.setString(5, l_file_name_for_failed_resp);
					pstmt.setString(6, l_inbound_xml_fail);
					pstmt.setString(7, l_request_status);
					pstmt.setString(8, l_authorization_num);
					pstmt.setString(9, l_approval_status);
					pstmt.setString(10, l_warn_code);
					pstmt.setString(11, l_warn_desc);
					pstmt.setTimestamp(12, l_current_date);
					pstmt.setString(13, l_facility_id);
					pstmt.setString(14, l_patient_id);
					//pstmt.setString(15, l_cust_code);
					pstmt.setString(15, l_dest_code);
					pstmt.setInt(16, l_trans_value);
					if (l_settlement_ind.equals("C"))
					{
						pstmt.setString(17, l_blng_grp_id);
					}
					else if (l_settlement_ind.equals("X") || l_settlement_ind.equals("R"))
					{
						pstmt.setString(17, l_cust_code);
					}

					if (!(l_episode_type.equals("XXX")))
					{
						pstmt.setString(18, l_episode_type);
					}
					if (!(l_episode_id.equals("XXX")))
					{
						pstmt.setInt(19, Integer.parseInt(l_episode_id));
					}
					if (!(l_visit_id.equals("XXX")))
					{
						pstmt.setInt(20, Integer.parseInt(l_visit_id));
					}

					l_update_count = pstmt.executeUpdate();

					l_app_msg = " ::: UPDATE XF_ECLAIMS_TRX_HDR : SRL_NO : "+l_trans_value +" :: UpdateCount :: " +l_update_count;
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
					
					if (l_update_count == 1)
					{
						//dbConn.commit();	
						l_errcd = "S";
						errorCode = "S";
						errorMsg = "EClaims Transaction table updated successfully ";
					}
					else
					{
						//dbConn.rollback();	
						l_errcd = "E";
						l_errmsg = " Error in updating EClaims Transaction Header Records ";	
						errorCode = "E";
						errorMsg = l_errmsg;
					}

				}
				catch(Exception e)
				{
					l_errcd = "E";
					l_errmsg = "Error in updating EClaims Transaction Header Details : "+l_trans_value +" ::: "+ l_app_msg + " : " +  e.getMessage();

					errorCode = "E";
					errorMsg = l_errmsg;

					l_app_msg = " ::: UPDATE EClaims Transaction Header Exception Message : "+e.getMessage();
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

					return l_errcd + "$!^" + l_errmsg;

				}
				finally
				{			
					closeDBResources(rs, pstmt, null);				
				}	

			}
			else
			{
				// Insert into XF_ECLAIMS_TRX_HDR table
				l_app_msg = "Inside INSERT XF_ECLAIMS_TRX_HDR table...";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_current_date = new java.sql.Timestamp(System.currentTimeMillis());

				l_app_msg = " ::: FACILITY_ID : "+ params.get("FACILITY_ID").toString();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				l_app_msg = "::: PATIENT_ID : "+ params.get("PATIENT_ID").toString();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_encounter_id = params.get("ENCOUNTER_ID").toString();

				l_app_msg = "::: ENCOUNTER_ID : "+ l_encounter_id;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_episode_id = params.get("EPISODE_ID").toString();

				l_app_msg = "::: EPISODE_ID : "+  l_episode_id;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_episode_type = params.get("EPISODE_TYPE").toString();

				l_app_msg = "::: EPISODE_TYPE : "+  l_episode_type;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = "::: CUST_CODE : " + params.get("CUST_CODE").toString();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = "::: DESTINATION_CODE : "+ params.get("DEST_CODE").toString();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = "::: MEMBERSHIP_NUM : "+ params.get("MEMBERSHIP_NUM").toString();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = "::: WCA_NUMBER : "+ params.get("WCA_NUM").toString();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_wca_num = params.get("WCA_NUM").toString();
				if (l_wca_num.equals("XXX"))
				{
					l_wca_num = "";
				}

				l_app_msg = "::: DEPENDENT_NUM : " + params.get("DEPD_CODE").toString();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = "::: DEPENDENT_RELATIONSHIP : "+ params.get("DEPD_RELN").toString();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = "::: TRANS_TYPE : " + params.get("SESSION_ID").toString();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = "::: EVENT_TYPE : "+ params.get("EVENT_TYPE").toString();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				
				l_app_msg = "::: CASE_NUM : "+ params.get("CASE_NUM").toString();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = "::: CLAIM_NUM : " + params.get("CLAIM_NUM").toString();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = "::: SRL_NO : "+ params.get("MSG_ID").toString();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = "::: ACCESSION_NUM : "+ params.get("ACC_NO").toString();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = "::: REQUEST_DATE : " + l_current_date;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				l_app_msg = "::: OUTBOUND_TYPE : O";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = "::: FILE_NAME_FOR_OUTBOUND : " + params.get("INPUT_FILE_NAME").toString();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = "::: OUTBOUND_XML : "+ params.get("REQUEST_TEXT").toString();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = "::: ADDED_BY_ID : "+ XHDBAdapter.isNullReplace(params.get("ADDED_BY_ID").toString(), params.get("LOGIN_USER").toString());
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = "::: ADDED_DATE : " + l_current_date;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = "::: MODIFIED_BY_ID : "+ XHDBAdapter.isNullReplace(params.get("MODIFIED_BY_ID").toString(), params.get("LOGIN_USER").toString());
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = "::: MODIFIED_BY_DATE : "+ l_current_date;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = "::: ADDED_AT_WS_NO : "+ params.get("CLIENT_MACHINE").toString();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = "::: MODIFIED_AT_WS_NO : "+ params.get("CLIENT_MACHINE").toString();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = " ::: FACILITY_ID : "+ params.get("FACILITY_ID").toString() + " ::: PATIENT_ID : "+ params.get("PATIENT_ID").toString() ;

				l_insert_stmt = " INSERT into XF_ECLAIMS_TRX_HDR (FACILITY_ID, PATIENT_ID, EPISODE_ID, CUST_CODE, DESTINATION_CODE, "				
									+" MEMBERSHIP_NUM, WCA_NUMBER, DEPENDENT_NUM, DEPENDENT_RELATIONSHIP, TRANS_TYPE, "
									+" EVENT_TYPE, CASE_NUM, CLAIM_NUM, SRL_NO, ACCESSION_NUM, "
									+" REQUEST_DATE, OUTBOUND_TYPE, FILE_NAME_FOR_OUTBOUND, OUTBOUND_XML, ADDED_BY_ID, "
									+" ADDED_DATE, MODIFIED_BY_ID, MODIFIED_DATE, ADDED_AT_WS_NO, MODIFIED_AT_WS_NO, EPISODE_TYPE, VISIT_ID, MEMBERSHIP_SURNAME, MEMBERSHIP_INITIAL, BLNG_GRP_ID) "
									+" values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";			

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

				pstmt.setString(5, params.get("DEST_CODE").toString());

				pstmt.setString(6, params.get("MEMBERSHIP_NUM").toString());
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
				pstmt.setString(19, params.get("REQUEST_TEXT").toString());
				pstmt.setString(20, XHDBAdapter.isNullReplace(params.get("ADDED_BY_ID").toString(), params.get("LOGIN_USER").toString()));

				pstmt.setTimestamp(21, l_current_date);
				pstmt.setString(22, XHDBAdapter.isNullReplace(params.get("MODIFIED_BY_ID").toString(), params.get("LOGIN_USER").toString()));
				pstmt.setTimestamp(23, l_current_date);
				pstmt.setString(24, params.get("CLIENT_MACHINE").toString());
				pstmt.setString(25, params.get("CLIENT_MACHINE").toString());	

				if (l_episode_type.equals("XXX"))
					pstmt.setString(26, null);
				else
					pstmt.setString(26, l_episode_type);

				if (l_visit_id.equals("XXX"))
					pstmt.setInt(27, 0);
				else
					pstmt.setLong(27, Integer.parseInt(l_visit_id));

				if (l_surname.equals("XXX"))
					pstmt.setString(28, null);
				else
					pstmt.setString(28, l_surname);

				if (l_initial.equals("XXX"))
					pstmt.setString(29, null);
				else
					pstmt.setString(29, l_initial);

				if (l_blng_grp_id.equals("XXX"))
					pstmt.setString(30, null);
				else
					pstmt.setString(30, l_blng_grp_id);

				l_insert_count = pstmt.executeUpdate();	
				
				l_app_msg = " ::: l_insert_count : "+ l_insert_count;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				
				if(l_insert_count == 1) {
					errorCode = "S";
					errorMsg = "EClaims Transaction details inserted successfully ";
					//dbConn.commit();				
				}
				else {				
					errorMsg = "Error in inserting EClaims Transaction details ";
					return "E" +"$!^"+errorMsg;
				}
			}
		}
		catch (Exception exp) {
			exp.printStackTrace();
			System.out.println("(UpdateEClaimsDetails) Exception " + exp.getMessage());
			return "E" +"$!^ Error in (UpdateEClaimsDetails) Exception  - "+exp.getMessage();
		}
		finally {
			closeDBResources(rs, pstmt, null);
		}

		return errorCode +"$!^"+ errorMsg;
	}
	
	public static String getFormattedStringDate(String format,Date date)
    {	
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		dateFormat.setTimeZone(TimeZone.getTimeZone("CAT"));
		String dateFormatted = dateFormat.format(date);
		return dateFormatted;
    }
    
	public String SetPatientDetails(String applicationId, String actionKey) 
	{
		String l_app_msg = "";
		String l_update_type = "";

		String l_patient_id = "", l_first_name = "", l_family_name = "", l_initial= "", l_sex = "", l_dob = "", l_national_id = "" ,l_trans_id = "", l_preData = "", l_auth_num = "",l_memData = "";
		String l_claims_num ="",l_res_type = "",l_warn_code = "",l_warn_desc = "" ,l_request_type="",l_user_id="",l_workstation_id="";
		String l_membership_num ="",l_wca_num = "",l_dependent_num = "",l_dependent_relation = "",l_mem_surname = "",l_mem_initial = "";

		String l_facility_id = "", l_episode_type = "", l_episode_id = "", l_cust_code = "",l_admission_type = "", l_encounter_id = "", l_visit_id = "";

		String l_blng_grp_id = "",  l_settlement_ind = "";

		HashMap reqParams = new HashMap();
			
		l_app_msg = "Inside SetPatientDetails...";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

        l_app_msg = " ::: Fetching Resquest Type ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		l_request_type = FetchFieldValue(actionKey,"<REQUEST>",null,l_field_separator, "SetPatientDetails");
		if (l_request_type.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_request_type ;
		}
		l_app_msg = " ::: l_request_type : "+l_request_type;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		l_app_msg = " ::: Fetching Update Type ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_update_type = FetchFieldValue(actionKey,"<UPDATE_TYPE>",null,l_field_separator, "SetPatientDetails");
		if (l_update_type.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_update_type ;
		}
		l_app_msg = " ::: l_update_type : "+l_update_type;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		        l_app_msg = " ::: Fetching Update Type ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_admission_type = FetchFieldValue(actionKey,"<ADMISSION_TYPE>",null,l_field_separator, "SetPatientDetails");
		if (l_admission_type.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_admission_type ;
		}
		l_app_msg = " ::: l_admission_type : "+l_admission_type;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	


		l_app_msg = " ::: Fetching Facility ID... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_facility_id = FetchFieldValue(actionKey,"<FACILITY_ID>",null,l_field_separator, "SetPatientDetails");
		if (l_facility_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_facility_id ;
		}
		l_app_msg = " ::: l_facility_id : "+l_facility_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = " ::: Fetching Patient ID... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_patient_id = FetchFieldValue(actionKey,"<PATIENT_ID>",null,l_field_separator, "SetPatientDetails");
		if (l_patient_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_patient_id ;
		}
		l_app_msg = " ::: l_patient_id : "+l_patient_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		l_app_msg = " ::: Fetching Episode Type... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_episode_type = FetchFieldValue(actionKey,"<EPISODE_TYPE>",null,l_field_separator, "SetPatientDetails");
		if (l_episode_type.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_episode_type ;
		}
		l_app_msg = " ::: l_episode_type : "+l_episode_type;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = " ::: Fetching Episode ID... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_episode_id = FetchFieldValue(actionKey,"<EPISODE_ID>",null,l_field_separator, "SetPatientDetails");
		if (l_episode_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_episode_id ;
		}
		l_app_msg = " ::: l_episode_id : "+l_episode_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

		l_app_msg = " ::: Fetching Visit ID... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_visit_id = FetchFieldValue(actionKey,"<VISIT_ID>",null,l_field_separator, "SetPatientDetails");
		if (l_visit_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_visit_id ;
		}
		l_app_msg = " ::: l_visit_id : "+l_visit_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

		l_app_msg = " ::: Fetching Encounter ID... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_encounter_id = FetchFieldValue(actionKey,"<ENCOUNTER_ID>",null,l_field_separator, "SetPatientDetails");
		if (l_encounter_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_encounter_id ;
		}
		l_app_msg = " ::: l_encounter_id : "+l_encounter_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);		

		l_app_msg = " ::: Fetching Customer Code... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_cust_code = FetchFieldValue(actionKey,"<CUST_CODE>",null,l_field_separator, "SetPatientDetails");
		if (l_cust_code.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_cust_code ;
		}
		l_app_msg = " ::: l_cust_code : "+l_cust_code;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

		l_app_msg = " ::: Fetching Billing Group ID... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_blng_grp_id = FetchFieldValue(actionKey, "<BLNG_GRP_ID>", null, l_field_separator, "SetPatientDetails");
		if (l_blng_grp_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_blng_grp_id;
		}
		l_app_msg = " ::: l_blng_grp_id : "+l_blng_grp_id;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_app_msg = " ::: Fetching Settlement Index... ";
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_settlement_ind = FetchFieldValue(actionKey, "<SETTLEMENT_IND>", null, l_field_separator, "SetPatientDetails");
		if (l_settlement_ind.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_settlement_ind;
		}
		l_app_msg = " ::: l_settlement_ind : "+l_settlement_ind;
		if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

		l_app_msg = " ::: Fetching Authorization number ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_auth_num = FetchFieldValue(actionKey,"<AUTHORIZATION_NUM>",null,l_field_separator, "SetPatientDetails");
		if (l_auth_num.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_auth_num;
		}
		l_app_msg = " ::: l_auth_num : "+l_auth_num;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);		

		l_app_msg = " ::: Fetching Transaction Id ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_trans_id = FetchFieldValue(actionKey,"<TRANS_ID>",null,l_field_separator, "SetPatientDetails");
		if (l_trans_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_trans_id;
		}
		l_app_msg = " ::: l_trans_id : "+l_trans_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		
		l_app_msg = " ::: Fetching Claims Number ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_claims_num = FetchFieldValue(actionKey,"<CLAIMS_NUMBER>",null,l_field_separator, "SetPatientDetails");
		if (l_claims_num.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_claims_num;
		}
		l_app_msg = " ::: l_claims_num : "+l_claims_num;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				
		l_app_msg = " ::: Fetching response type... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_res_type = FetchFieldValue(actionKey,"<RESPONSE_TYPE>",null,l_field_separator, "SetPatientDetails");
		if (l_res_type.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_res_type;
	    }
		l_app_msg = " ::: l_res_type : "+l_res_type;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

        l_app_msg = " ::: Fetching warning code ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		l_warn_code = FetchFieldValue(actionKey,"<WARNING_CODE>",null,l_field_separator, "SetPatientDetails");
		if (l_warn_code.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_warn_code;
		}
		l_app_msg = " ::: l_warn_code : "+l_warn_code;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

        l_app_msg = " ::: Fetching warning desc ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		l_warn_desc = FetchFieldValue(actionKey,"<WARNING_DESC>",null,l_field_separator, "SetPatientDetails");
		if (l_warn_desc.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_warn_desc;
		}
		l_app_msg = " ::: l_warn_desc : "+l_warn_desc;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		
		 l_app_msg = " ::: Fetching membership number ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		l_membership_num = FetchFieldValue(actionKey,"<MEMBERSHIP_NUMBER>",null,l_field_separator, "SetPatientDetails");
		if (l_membership_num.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_membership_num;
		}
		l_app_msg = " ::: l_membership_num : "+l_membership_num;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

		
		 l_app_msg = " ::: Fetching membership surname ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		l_mem_surname = FetchFieldValue(actionKey,"<MEM_SURNAME>",null,l_field_separator, "SetPatientDetails");
		if (l_mem_surname.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_mem_surname;
		}
		l_app_msg = " ::: l_mem_surname : "+l_mem_surname;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

		
		 l_app_msg = " ::: Fetching membership initial ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		l_mem_initial = FetchFieldValue(actionKey,"<MEM_INITIAL>",null,l_field_separator, "SetPatientDetails");
		if (l_mem_initial.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_mem_initial;
		}
		l_app_msg = " ::: l_membership_num : "+l_mem_initial;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		l_app_msg = " ::: Fetching WCA number ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		l_wca_num = FetchFieldValue(actionKey,"<WCA_NUMBER>",null,l_field_separator, "SetPatientDetails");
		if (l_wca_num.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_wca_num;
		}
		l_app_msg = " ::: l_wca_num : "+l_wca_num;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		l_app_msg = " ::: Fetching dependent number ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		l_dependent_num = FetchFieldValue(actionKey,"<DEPENDENT_NUMBER>",null,l_field_separator, "SetPatientDetails");
		if (l_dependent_num.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_dependent_num;
		}
		l_app_msg = " ::: l_dependent_num : "+l_dependent_num;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = " ::: Fetching dependent relation ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		l_dependent_relation = FetchFieldValue(actionKey,"<DEPENDENT_RELATION>",null,l_field_separator, "SetPatientDetails");
		if (l_dependent_relation.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_dependent_relation;
		}
		l_app_msg = " ::: l_dependent_relation : "+l_dependent_relation;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		l_user_id = FetchFieldValue(actionKey,"<USER>",null,l_field_separator, "SetPatientDetails");
		if (l_user_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_user_id;
		}
		l_app_msg = " ::: l_user_id : "+l_user_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = " ::: Fetching Workstation ID ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_workstation_id = FetchFieldValue(actionKey,"<WS_NO>",null,l_field_separator, "SetPatientDetails");
		if (l_workstation_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_workstation_id;
		}
		l_app_msg = " ::: l_workstation_id : "+l_workstation_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

        reqParams.put("CLAIMS_NUMBER", "XXX");
		reqParams.put("RESPONSE_TYPE", "XXX");
		reqParams.put("WARNING_CODE", "XXX");
		reqParams.put("WARNING_DESC", "XXX");


		//"<REQUEST>"+checkType+"$!^<REQUEST_TYPE>ELCUPD$!^<UPDATE_TYPE>"+update_type+"$!^<CLAIMS_NUMBER>"+claims_number+"$!^<RESPONSE_TYPE>"+response_type+"$!^
		//<WARNING_CODE>"+warning_code+"$!^<WARNING_DESC>"+warning_code_desc+"$!^<AUTHORIZATION_NUM>"+auth_num+"$!^<TRANS_ID>"+transId+"$!^<PATIENT_ID>"+patientId+"$!^";
        if(l_update_type.equals("2"))
		{
			l_app_msg = " ::: Fetching First Name ... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_first_name = FetchFieldValue(actionKey,"<FIRST_NAME>",null,l_field_separator, "SetPatientDetails");
			if (l_first_name.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_first_name ;
			}
			l_app_msg = " ::: l_first_name : "+l_first_name;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_app_msg = " ::: Fetching Family name... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_family_name = FetchFieldValue(actionKey,"<FAMILY_NAME>",null,l_field_separator, "SetPatientDetails");
			if (l_family_name.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_family_name ;
			}
			l_app_msg = " ::: l_family_name : "+l_family_name;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_app_msg = " ::: Fetching Initial... ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_initial = FetchFieldValue(actionKey, "<NAME_SUFFIX>", null, l_field_separator, "SetPatientDetails");
			if (l_initial.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_initial;
			}
			l_app_msg = " ::: l_initial : "+l_initial;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			l_app_msg = " ::: Fetching National Id... ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

			 l_national_id = FetchFieldValue(actionKey, "<NATIONAL_ID>", null, l_field_separator, "SetPatientDetails");
			if ( l_national_id.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" +  l_national_id;
			}
			l_app_msg = " ::: l_national_id : "+l_national_id;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);		

			l_app_msg = " ::: Fetching Date of birth ... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_dob = FetchFieldValue(actionKey,"<DATE_OF_BIRTH>",null,l_field_separator, "SetPatientDetails");
			if (l_dob.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_dob;
			}
			l_app_msg = " ::: l_dob : "+l_dob;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);			

			l_app_msg = " ::: Fetching Gender ... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_sex = FetchFieldValue(actionKey,"<SEX>",null,l_field_separator, "SetPatientDetails");
			if (l_sex.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_sex;
			}
			l_app_msg = " ::: l_sex : "+l_sex;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			
			l_app_msg = " ::: Fetching previous patient data ... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_preData = FetchFieldValue(actionKey,"<PREVIOUS_DATA>",null,l_field_separator, "SetPatientDetails");
			if (l_preData.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_preData;
			}
			l_app_msg = " ::: l_preData : "+l_preData;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_app_msg = " ::: Fetching previous member data ... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_memData = FetchFieldValue(actionKey,"<MEM_DETAILS>",null,l_field_separator, "SetPatientDetails");
			if (l_memData.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_memData;
			}
			l_app_msg = " ::: l_memData : "+l_memData;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			if(l_initial.equals("NA")||l_initial.equals(" ") ){
				l_initial="";
			}
		}
					
		try
		{
			l_app_msg = "Before Inserting into map... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			reqParams.put("FACILITY_ID", l_facility_id);
			reqParams.put("PATIENT_ID", l_patient_id);
			reqParams.put("EPISODE_TYPE", l_episode_type);
			reqParams.put("EPISODE_ID", l_episode_id);
			reqParams.put("ENCOUNTER_ID", l_encounter_id);

			if (!(l_visit_id.length()>0))
			{
				l_visit_id = "XXX";
			}
			reqParams.put("VISIT_ID", l_visit_id);

			if (!(l_cust_code.length() > 0))
			{
				l_cust_code = "XXX";
			}
			
			reqParams.put("CUST_CODE", l_cust_code);
			reqParams.put("ADMISSION_TYPE", l_admission_type);

			reqParams.put("AUTHORIZATION_NUM", l_auth_num);
			reqParams.put("UPDATE_TYPE", l_update_type);
			reqParams.put("TRANS_ID", l_trans_id);

		    reqParams.put("USER_ID", l_user_id);
		    reqParams.put("WORK_STATION", l_workstation_id);

			reqParams.put("CLAIMS_NUMBER", l_claims_num);

			if(l_request_type.equals("IEC"))
			{
				reqParams.put("RESPONSE_TYPE", l_res_type);
				reqParams.put("WARNING_CODE", l_warn_code);
				reqParams.put("WARNING_DESC", l_warn_desc); 
			}

			reqParams.put("MEMBERSHIP_NUMBER", l_membership_num);
			reqParams.put("WCA_NUMBER", l_wca_num);
			reqParams.put("MEM_SURNAME", l_mem_surname);
			reqParams.put("MEM_INITIAL", l_mem_initial);
			reqParams.put("DEPENDENT_NUMBER", l_dependent_num);
			reqParams.put("DEPENDENT_RELATION", l_dependent_relation);

			if (!(l_blng_grp_id.length() > 0))
			{
				l_blng_grp_id = "XXX";
			}

			reqParams.put("BLNG_GRP_ID", l_blng_grp_id);
			reqParams.put("SETTLEMENT_IND", l_settlement_ind);

			l_app_msg = "After Inserting First Set...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			if(l_update_type.equals("2")){
				
				reqParams.put("FIRST_NAME", l_first_name); 
				reqParams.put("FAMILY_NAME", l_family_name);
				reqParams.put("NATIONAL_ID_NO", l_national_id);
				reqParams.put("NAME_PREFIX", l_initial);
				reqParams.put("DATE_OF_BIRTH", l_dob);
				reqParams.put("SEX", l_sex);
				reqParams.put("PREVIOUS_DATA", l_preData);
				reqParams.put("MEM_DETAILS", l_memData);

				l_app_msg = "After Inserting Second Set...";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			}

			l_app_msg = UpdateTransactionDetails(reqParams);
			reqParams.clear();
			return l_app_msg;
		}
		catch (Exception e)
		{
			l_errcd = "E";
			l_errmsg = "Error in setting request params : "+l_app_msg+ " - "+ e.getMessage();
			return "E" + "$!^" + l_errmsg;
		}
	}

	public String UpdateTransactionDetails(Map params)
	{
		String l_app_msg = "";
		String l_return_msg = "", l_update_reponse_msg = "" ;

		String l_update_type = "";

		try
		{
			l_app_msg = " Inside Update Transaction Details Method...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_update_type = params.get("UPDATE_TYPE").toString();
			l_app_msg = "::: UPDATE_TYPE : "+ l_update_type;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);             

			if(l_update_type.equals("2"))
			{				
				l_update_reponse_msg = UpdateMemberDetails(params);				
				l_app_msg = " ::: Update Member Details Response : "+ l_update_reponse_msg;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				if (l_update_reponse_msg.indexOf("Error")>=0)
				{
					l_errcd = "E";
					l_errmsg = l_update_reponse_msg;
				}
			}

			/*l_update_reponse_msg = UpdateAuthorizationDetails(params);				
			l_app_msg = " ::: Update Authorization Details : "+ l_update_reponse_msg;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg); 				
			if (l_update_reponse_msg.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_update_reponse_msg;
			}*/
			
			l_return_msg = l_errcd + "$!^" + l_update_reponse_msg;

		}		
		catch (Exception exp) {
			exp.printStackTrace();
			System.out.println("(UpdateTransactionDetails) Exception " + exp.getMessage());
			return "E" +"$!^"+exp.getMessage();
		}
		return l_return_msg;
	}
	/******** Update Patient Details ************/
	public String UpdatePatientDetails(Map params)
	{
		//Connection dbConn = null;

		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String  l_update_patient = "",l_update_eclaims="", l_update_type = "",l_name_prefix_qry = "", l_name_prefix = "";
		String  errorMsg = "";
        //java.sql.Timestamp l_dob=null;
		String l_app_msg = "", l_dob = "";
        int l_name_prefix_count=0;
		java.util.Date date = null;
		java.sql.Date sqlDob = null;
		java.sql.Timestamp  l_current_date= null;

		String l_update_patient_status = "";
        
		int l_eclaims_count = 0, l_patient_count = 0;

		try
		{
			l_app_msg = "Inside UpdatePatientDetails Method...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			dbConn = ConnectionManager.getConnection();

			l_name_prefix_qry = " SELECT COUNT(*) COUNT FROM MP_NAME_PREFIX WHERE NAME_PREFIX=?";


            l_update_patient = " UPDATE MP_PATIENT "
									+" SET	FIRST_NAME  = ?, "
									+" FAMILY_NAME      = ?, "
									+" NAME_PREFIX      = ?, "
									+" DATE_OF_BIRTH    = ?, "
									+" NATIONAL_ID_NO   = ?, "
									+" SEX      = ? ,"
									+" MODIFIED_AT_WS_NO = ?,"
									+" MODIFIED_BY_ID = ?, "
									+" MODIFIED_DATE =?, "
									+" MODIFIED_FACILITY_ID = ?" 
									+"  WHERE PATIENT_ID = ? " ;

			l_update_eclaims = " UPDATE XF_ECLAIMS_TRX_HDR "
									+" SET	UPDATE_STATUS  = ?, "
									+" PREVIOUS_PAT_DATA   = ? "
									+" WHERE SRL_NO = ? " ;

			l_update_type = params.get("UPDATE_TYPE").toString();
			l_app_msg = "::: UPDATE_TYPE : "+ l_update_type;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg); 
									
            l_app_msg = "::: PATIENT_ID : "+ params.get("PATIENT_ID").toString();
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);			

			l_app_msg = "::: MSG_ID : " + params.get("MSG_ID").toString();
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_app_msg = "::: AUTHORIZATION_NUM : "+ params.get("AUTHORIZATION_NUM").toString();
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_app_msg = "::: CLAIMS_NUMBER : "+ params.get("CLAIMS_NUMBER").toString();
		    if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_app_msg = "::: RESPONSE_TYPE : "+ params.get("RESPONSE_TYPE").toString();
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_app_msg = "::: WARNING_CODE : "+ params.get("WARNING_CODE").toString();
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_app_msg = "::: WARNING_DESC : "+ params.get("WARNING_DESC").toString();
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_app_msg = " ::: FIRST_NAME : "+ params.get("FIRST_NAME").toString();
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_app_msg = "::: FAMILY_NAME : "+  params.get("FAMILY_NAME").toString();
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_app_msg = "::: DATE_OF_BIRTH : "+ l_dob;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_app_msg = "::: NATIONAL_ID_NO : "+  params.get("NATIONAL_ID_NO").toString();
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_app_msg = "::: NAME_PREFIX : " + params.get("NAME_PREFIX").toString();
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_app_msg = "::: SEX : "+ params.get("SEX").toString();
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_app_msg = "::: PREVIOUS_DATA : "+ params.get("PREVIOUS_DATA").toString();
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_app_msg = "::: User Id : "+ params.get("USER_ID").toString();
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_app_msg = "::: WORK STATION ID : "+ params.get("WORK_STATION").toString();
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_dob = params.get("DATE_OF_BIRTH").toString();

			l_app_msg = ":::String DATE_OF_BIRTH : "+ l_dob;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
			try
			{
				date = sdf.parse(l_dob); 
				sqlDob = new java.sql.Date(date.getTime());	
			
			}
			catch (Exception e)
			{
				System.out.println(e.getMessage());
			}
			l_current_date = new java.sql.Timestamp(System.currentTimeMillis());

			l_name_prefix = params.get("NAME_PREFIX").toString();

			if (!l_name_prefix.equals(""))
			{
				pstmt = dbConn.prepareStatement(l_name_prefix_qry);
				pstmt.setString(1, l_name_prefix);

				rs = pstmt.executeQuery();
				while(rs.next())
				{
				   l_name_prefix_count = rs.getInt("COUNT");
				}				
			}
			else
			{
				l_name_prefix_count = 1;
			}
			 
			
			l_app_msg = "::: l_name_prefix_count : "+ l_name_prefix_count;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			if(l_name_prefix_count == 1)
			{
				pstmt = dbConn.prepareStatement(l_update_patient);

				pstmt.setString(1, params.get("FIRST_NAME").toString());
				pstmt.setString(2, params.get("FAMILY_NAME").toString());
				pstmt.setString(3, params.get("NAME_PREFIX").toString());
				pstmt.setDate(4,sqlDob);
				pstmt.setString(5, params.get("NATIONAL_ID_NO").toString());
				pstmt.setString(6, params.get("SEX").toString());
				pstmt.setString(7, params.get("WORK_STATION").toString());
				pstmt.setString(8, params.get("USER_ID").toString());
				pstmt.setTimestamp(9, l_current_date);
				pstmt.setString(10, params.get("FACILITY_ID").toString());
				pstmt.setString(11, params.get("PATIENT_ID").toString());

				l_patient_count = pstmt.executeUpdate();	
			}
			else
			{
               errorMsg = "Error in updating Patient Details - No name prefix found";
               //dbConn.commit();		
			   return errorMsg;
			}
			l_app_msg = " ::: Patient Update Count : "+ l_patient_count;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);			
            
			
			// Update ECLAIMS Transaction HDR Table

			if (l_patient_count == 1)
				l_update_patient_status = "S";
			else
				l_update_patient_status = "E";
			
			l_app_msg = " ::: Updating Eclaims Header : "+ l_update_patient_status;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			pstmt = dbConn.prepareStatement(l_update_eclaims);
			pstmt.setString(1, l_update_patient_status);
			pstmt.setString(2, params.get("PREVIOUS_DATA").toString());
			pstmt.setString(3, params.get("TRANS_ID").toString());

			l_eclaims_count = pstmt.executeUpdate();

			l_app_msg = " ::: EClaims Update Count : "+ l_eclaims_count;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);		
         
			if((l_patient_count == 1) && (l_eclaims_count == 1)) {
				errorMsg = "Patient Details updated successfully ";
				//dbConn.commit();				
			}
			else if (l_patient_count != 1)
			{							
				errorMsg = "Error in updating Patient Details";				
				//dbConn.commit();		
				return errorMsg;
			}
			else if (l_eclaims_count != 1)
			{							
				errorMsg = "Error in updating EClaims Transaction Details";				
				dbConn.commit();		
				return errorMsg;
			}
		}	
		catch (Exception exp) {
			exp.printStackTrace();
			System.out.println("(UpdatePatientDetails) Exception " + exp.getMessage());
			return "Error in UpdatePatientDetails ::: "+exp.getMessage();
		}
		finally {
			closeDBResources(rs, pstmt, dbConn);
		}

		return errorMsg;
	}
	public String UpdateMemberDetails(Map params)
	{
		Connection Conn = null;

		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String l_update_mem_qry = "",l_insert_mem_qry = "",l_delete_mem_qry="", l_update_type = "",l_mem_qry = "", l_mem_details = "";
		String errorMsg = "";
        //java.sql.Timestamp l_dob=null;
		String l_app_msg = "", l_dob = "" , l_scheme_date = "";
        int l_mem_count = 0;
		java.util.Date date = null;
		java.util.Date date1 = null;

		java.sql.Date sqlDob = null;
		java.sql.Date sqlSchemeDate = null;

		String l_update_mem_status = "";
		String  dep_code = "";
        
		int l_mem_update_count = 0;

		String l_blng_grp_id = "",  l_settlement_ind = "", l_cust_code = "";

		try
		{
			l_app_msg = "Inside UpdateMemberDetails Method...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			Conn = ConnectionManager.getConnection();

			l_mem_qry = "SELECT COUNT(*) COUNT FROM XF_ECLAIMS_MEM_DETAILS  where  MEMBERSHIP_NUM = ? and  CUST_CODE = ? and DEPD_CD = ?";

            l_update_mem_qry = " UPDATE XF_ECLAIMS_MEM_DETAILS "
									+" SET	DOB  = ?, "
									+" ID_NBR    = ?, "
									+" SNAME     = ?, "
									+" FNAME     = ?, "
									+" INITS     = ?, "
									+" GENDER    = ?, " 
									+" STATUS    = ?, "
									+" SCHEME_NAME    = ?, "
									+" SCHEME_DATE    = ? "
									+" WHERE MEMBERSHIP_NUM = ? " 
									+" AND CUST_CODE = ? " 
									+" AND DEPD_CD = ? " ;


            l_insert_mem_qry = " INSERT into XF_ECLAIMS_MEM_DETAILS(CUST_CODE, MEMBERSHIP_NUM, DEPD_CD, DOB, ID_NBR, SNAME, FNAME, INITS, GENDER, STATUS ,SCHEME_NAME , SCHEME_DATE)"
									+" values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";	

			l_delete_mem_qry = "DELETE FROM XF_ECLAIMS_MEM_DETAILS  WHERE MEMBERSHIP_NUM = ? and  CUST_CODE = ? and DEPD_CD not in(#dep_code)";

			

			l_update_type = params.get("UPDATE_TYPE").toString();
			l_app_msg = "::: UPDATE_TYPE : "+ l_update_type;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg); 
									
            l_app_msg = "::: CUST_CODE : "+ params.get("CUST_CODE").toString();
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);		
			
			l_blng_grp_id = params.get("BLNG_GRP_ID").toString();
			l_app_msg = "::: BLNG_GRP_ID : "+ l_blng_grp_id;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_settlement_ind = params.get("SETTLEMENT_IND").toString();
			l_app_msg = "::: SETTLEMENT_IND : "+ l_settlement_ind;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			if (l_settlement_ind.equals("C"))
			{
				l_cust_code = l_blng_grp_id;
			}
			else if (l_settlement_ind.equals("X") || l_settlement_ind.equals("R"))
			{
				l_cust_code = params.get("CUST_CODE").toString();
			}


			l_app_msg = "::: MEMBERSHIP_NUMBER : " + params.get("MEMBERSHIP_NUMBER").toString();
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_app_msg = "::: TRANS_ID : " + params.get("TRANS_ID").toString();
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

            l_mem_details = params.get("MEM_DETAILS").toString();

			l_app_msg = "::: MEM_DETAILS : "+ l_mem_details;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			String [] membersdata= l_mem_details.split("@@");

			l_app_msg = "::: membersdata.length : "+ membersdata.length;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			for(int i=0;i<membersdata.length;i++)
			{
                String [] memdata= membersdata[i].split("##");

				l_app_msg = "::: memdata.length : "+ memdata.length;
			    if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

                if(i==0){
                   dep_code = memdata[0];
				}
				else{
				   dep_code += ","+memdata[0];
				}
				pstmt = Conn.prepareStatement(l_mem_qry);
				pstmt.setString(1, params.get("MEMBERSHIP_NUMBER").toString());
				pstmt.setString(2, l_cust_code);
				pstmt.setString(3, memdata[0]);


				rs = pstmt.executeQuery();

				while(rs.next())
				{
				   l_mem_count = rs.getInt("COUNT");
				}
				
				l_app_msg = "::: l_mem_count : "+ l_mem_count;
			    if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_dob = memdata[1];

				l_app_msg = ":::String DATE_OF_BIRTH : "+ l_dob;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_scheme_date = memdata[9];

				l_app_msg = ":::String l_scheme_date Date : "+ l_scheme_date;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				try
				{
					date = sdf.parse(l_dob);
					
					sqlDob = new java.sql.Date(date.getTime());

					/*SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMdd");
					SimpleDateFormat format2 = new SimpleDateFormat("dd/MM/yyyy");
					Date date2 = format1.parse(l_scheme_date);
					String date_str = format2.format(date2);

					l_app_msg = ":::String date_str Date : "+ date_str;
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

					SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
					date1 = sdf1.parse(date_str);
					sqlSchemeDate = new java.sql.Date(date1.getTime());
                    */
					date1 = sdf.parse(l_scheme_date);
					
					sqlSchemeDate = new java.sql.Date(date1.getTime());

					//date1 = sdf.parse(date_str);	
					
					l_app_msg = ":::String sqlSchemeDate Date : "+ sqlSchemeDate;
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				}
				catch (Exception e)
				{
					System.out.println(e.getMessage());
				}


				if(l_mem_count<=0){

					pstmt = Conn.prepareStatement(l_insert_mem_qry);

					pstmt.setString(1, l_cust_code);
					pstmt.setString(2, params.get("MEMBERSHIP_NUMBER").toString());
					pstmt.setString(3, memdata[0]);
					pstmt.setDate(4,sqlDob);
					pstmt.setString(5, memdata[2]);
					pstmt.setString(6, memdata[3]);
					pstmt.setString(7, memdata[4]);
					pstmt.setString(8, memdata[5]);
					pstmt.setString(9, memdata[6]);
					pstmt.setString(10, memdata[7]);
					pstmt.setString(11, memdata[8]);
					pstmt.setDate(12, sqlSchemeDate);

				    l_mem_update_count =l_mem_update_count+ pstmt.executeUpdate();
				}
				else{
                    pstmt = Conn.prepareStatement(l_update_mem_qry);
					pstmt.setDate(1,sqlDob);
					pstmt.setString(2, memdata[2]);
					pstmt.setString(3, memdata[3]);
					pstmt.setString(4, memdata[4]);
					pstmt.setString(5, memdata[5]);
					pstmt.setString(6, memdata[6]);
					pstmt.setString(7, memdata[7]);
					pstmt.setString(8, memdata[8]);
					pstmt.setDate(9, sqlSchemeDate);
					pstmt.setString(10, params.get("MEMBERSHIP_NUMBER").toString());
					pstmt.setString(11, l_cust_code);
					pstmt.setString(12, memdata[0]);
					l_mem_update_count = l_mem_update_count + pstmt.executeUpdate();
					
				}
			
			
			l_app_msg = " ::: Member Update Count : "+ l_mem_update_count;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);			
            
			}
			// Update ECLAIMS Transaction HDR Table

			if (l_mem_update_count == membersdata.length)
				l_update_mem_status = "S";
			else
				l_update_mem_status = "E";

			if(l_mem_update_count == membersdata.length )
			{
				l_app_msg = " ::: Deleting Member details : "+ l_update_mem_status;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_app_msg = " ::: dep_code : "+ dep_code;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				l_delete_mem_qry = l_delete_mem_qry.replaceAll("#dep_code",dep_code);

				l_app_msg = " ::: l_delete_mem_qry : "+ l_delete_mem_qry;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				pstmt = Conn.prepareStatement(l_delete_mem_qry);
				pstmt.setString(1, params.get("MEMBERSHIP_NUMBER").toString());
				pstmt.setString(2, l_cust_code);
				errorMsg = "Member Details updated successfully ";
				Conn.commit();
				
			}
			else
			{
				errorMsg = "Error in updating EClaims Member Details";				
				Conn.rollback();		
				return errorMsg;
			}
		}
		
		catch (Exception exp) {
			exp.printStackTrace();
			System.out.println("(UpdateMemberDetails) Exception " + exp.getMessage());
			return "Error in UpdateMemberDetails ::: "+exp.getMessage();
		}
		finally {
			closeDBResources(rs, pstmt, Conn);
		}
       
		return errorMsg;
	}
	/******** Update Patient Financial / Episode Financial Details ************/
	public String UpdateAuthorizationDetails(Map params)
	{
		//Connection Conn = null;

		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String l_update_episode_fin_dtls = "" , l_update_patient_fin_dtls = "", l_admission_type = "", l_update_visit_fin_dtls = "";
		String errorMsg = "";
        //java.sql.Timestamp l_dob=null;
		String l_app_msg = "";
		String l_warn_code = "", l_warn_desc = "";


		java.sql.Timestamp l_current_date = null;

       	int l_episode_count = 0, l_patient_fin_count = 0,l_eclaims_count = 0;

		String l_episode_type = "", l_visit_id = "";

		String l_update_eclaims = "";

		String l_blng_grp_id = "",  l_settlement_ind = "", l_where_cond = "";

		try
		{
			l_app_msg = "Inside UpdateAuthorizationDetails Method...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			//Conn = ConnectionManager.getConnection(); 
			
			l_update_eclaims = " UPDATE XF_ECLAIMS_TRX_HDR "
									+" SET	UPDATE_STATUS  = ?, "
									+" MEMBERSHIP_NUM   = ? "
									+" WHERE SRL_NO = ? " ;
			
			// Inpatient and DayCare
			l_update_episode_fin_dtls = " update BL_EPISODE_FIN_DTLS set CREDIT_AUTH_REF = ?, CREDIT_AUTH_DATE = ? ,MEMBERSHIP_NUM_SAP = ? , DEPENDANT_NUM_SAP = ?,DEPENDANT_RELATION_SAP = ?,WCA_NUMBER_SAP = ?, WARN_CODE = ?, WARN_DESC = ?,MODIFIED_AT_WS_NO = ?,MODIFIED_BY_ID = ?,MODIFIED_DATE =?,MODIFIED_FACILITY_ID = ?, MEMBERSHIP_SURNAME = ?, MEMBERSHIP_INITIAL = ?"
											+" where OPERATING_FACILITY_ID = ? and EPISODE_TYPE = ? and EPISODE_ID = ? and PATIENT_ID = ? ";
			//Outpatient and Emergency
			l_update_visit_fin_dtls = " update BL_VISIT_FIN_DTLS set CREDIT_AUTH_REF = ?, CREDIT_AUTH_DATE = ?, MEMBERSHIP_NUM_SAP = ?, DEPENDANT_NUM_SAP = ?, DEPENDANT_RELATION_SAP = ? , WCA_NUMBER_SAP = ?, WARN_CODE = ?, WARN_DESC = ?, MODIFIED_AT_WS_NO = ?, MODIFIED_BY_ID = ?, MODIFIED_DATE = ?, MODIFIED_FACILITY_ID = ?, MEMBERSHIP_SURNAME = ?, MEMBERSHIP_INITIAL = ?"
											+" where OPERATING_FACILITY_ID = ? and EPISODE_TYPE = ? and EPISODE_ID = ? and PATIENT_ID = ? ";
											

			//Preadmission
			l_update_patient_fin_dtls = "update BL_PATIENT_FIN_DTLS set CREDIT_AUTH_REF = ?, CREDIT_AUTH_DATE = ? ,MEMBERSHIP_NUM_SAP = ? , DEPENDANT_NUM_SAP = ?,DEPENDANT_RELATION_SAP = ? ,WCA_NUMBER_SAP = ?, WARN_CODE = ?, WARN_DESC = ? , MODIFIED_AT_WS_NO = ?, MODIFIED_BY_ID = ? ,MODIFIED_DATE = ?, MODIFIED_FACILITY_ID = ?, MEMBERSHIP_SURNAME = ?, MEMBERSHIP_INITIAL = ?"
											+" where PATIENT_ID = ? ";

			l_current_date = new java.sql.Timestamp(System.currentTimeMillis());
			l_app_msg = "::: Current Date : "+ l_current_date;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg); 

			l_admission_type = params.get("ADMISSION_TYPE").toString();
			l_app_msg = "::: Admission Type : "+ l_admission_type;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg); 
		  
            l_app_msg = "::: PATIENT_ID : "+ params.get("PATIENT_ID").toString();
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			
			l_app_msg = "::: CUST_CODE : "+ params.get("CUST_CODE").toString();
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_app_msg = "::: MSG_ID : " + params.get("MSG_ID").toString();
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_app_msg = "::: FACILITY_ID : "+ params.get("FACILITY_ID").toString();
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_episode_type = params.get("EPISODE_TYPE").toString();
			
			l_app_msg = "::: EPISODE_TYPE : "+ l_episode_type;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_app_msg = "::: EPISODE_ID : " + params.get("EPISODE_ID").toString();
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_visit_id = params.get("VISIT_ID").toString();
			l_app_msg = "::: VISIT_ID : " + l_visit_id;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_app_msg = "::: ENCOUNTER_ID : " + params.get("ENCOUNTER_ID").toString();
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_app_msg = "::: AUTHORIZATION_NUM : "+ params.get("AUTHORIZATION_NUM").toString();
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
            
			l_warn_code = params.get("WARN_CODE").toString();
			if(l_warn_code.equals("XXX")){
                l_warn_code = " ";
			}

			l_app_msg = "::: WARN_CODE : "+ l_warn_code;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_warn_desc = params.get("WARN_DESC").toString();
			if(l_warn_desc.equals("XXX")){
                l_warn_desc = " ";
			}
			l_app_msg = "::: WARN_DESC : "+ l_warn_code;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_app_msg = "::: MEMBERSHIP_NUM : "+ params.get("MEMBERSHIP_NUM").toString();
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

            l_app_msg = "::: WCA_NUM : "+ params.get("WCA_NUM").toString();
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_app_msg = "::: M_SURNAME : "+ params.get("M_SURNAME").toString();
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

            l_app_msg = "::: M_INITIAL : "+ params.get("M_INITIAL").toString();
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_app_msg = "::: DEPD_CODE : "+ params.get("DEPD_CODE").toString();
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

            l_app_msg = "::: DEPD_RELN : "+ params.get("DEPD_RELN").toString();
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

            l_app_msg = "::: LOGIN_USER : "+ params.get("LOGIN_USER").toString();
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_app_msg = "::: CLIENT_MACHINE : "+ params.get("CLIENT_MACHINE").toString();
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_blng_grp_id = params.get("BLNG_GRP_ID").toString();
			l_app_msg = "::: BLNG_GRP_ID : "+ l_blng_grp_id;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			l_settlement_ind = params.get("SETTLEMENT_IND").toString();
			l_app_msg = "::: SETTLEMENT_IND : "+ l_settlement_ind;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			if (l_settlement_ind.equals("C"))
			{
				l_where_cond = " and BLNG_GRP_ID = ? ";
			}
			else if (l_settlement_ind.equals("X") || l_settlement_ind.equals("R"))
			{
				l_where_cond = " and CUST_CODE = ? ";
			}

			l_app_msg = " ::: Updating Eclaims Header : ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			pstmt = dbConn.prepareStatement(l_update_eclaims);
			pstmt.setString(1,"S");
			pstmt.setString(2, params.get("MEMBERSHIP_NUM").toString());
			pstmt.setString(3, params.get("MSG_ID").toString());

			l_eclaims_count = pstmt.executeUpdate();

			l_app_msg = " ::: EClaims Update Count : "+ l_eclaims_count;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			// Update Episode Fin Details Table

			if (l_admission_type.equals("1"))
			{
				l_update_patient_fin_dtls = l_update_patient_fin_dtls + l_where_cond;

				l_app_msg = " ::: Patient Fin Details Update Query : "+ l_update_patient_fin_dtls;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				pstmt = dbConn.prepareStatement(l_update_patient_fin_dtls);

				pstmt.setString(1, params.get("AUTHORIZATION_NUM").toString());
				pstmt.setTimestamp(2, l_current_date);
                pstmt.setString(3, params.get("MEMBERSHIP_NUM").toString());
                pstmt.setString(4, params.get("DEPD_CODE").toString());
				pstmt.setString(5, params.get("DEPD_RELN").toString());
				pstmt.setString(6, params.get("WCA_NUM").toString());
				pstmt.setString(7, l_warn_code);
				pstmt.setString(8, l_warn_desc);
				pstmt.setString(9, params.get("CLIENT_MACHINE").toString());
				pstmt.setString(10, params.get("LOGIN_USER").toString());
				pstmt.setTimestamp(11, l_current_date);				
				pstmt.setString(12, params.get("FACILITY_ID").toString());
				pstmt.setString(13, params.get("M_SURNAME").toString());
				pstmt.setString(14, params.get("M_INITIAL").toString());
				pstmt.setString(15, params.get("PATIENT_ID").toString());

				if (l_settlement_ind.equals("C"))
				{
					pstmt.setString(16, params.get("BLNG_GRP_ID").toString());
				}
				else if (l_settlement_ind.equals("X") || l_settlement_ind.equals("R"))
				{
					pstmt.setString(16, params.get("CUST_CODE").toString());
				}
				
				l_patient_fin_count = pstmt.executeUpdate();

				l_app_msg = " ::: Patient Fin Details Update Count : "+ l_patient_fin_count;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			}
			else
			{
				
				
				if (l_episode_type.equals("I") || l_episode_type.equals("D"))
				{
					l_update_episode_fin_dtls = l_update_episode_fin_dtls + l_where_cond;
					
					l_app_msg = " ::: Episode Fin Details Update Query for Inpatient : "+ l_update_episode_fin_dtls;
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

					pstmt = dbConn.prepareStatement(l_update_episode_fin_dtls);
				}
				if (l_episode_type.equals("O") || l_episode_type.equals("E"))
				{
					l_update_visit_fin_dtls = l_update_visit_fin_dtls + l_where_cond+" and visit_id = ? ";

					l_app_msg = " ::: Episode Fin Details Update Query for Outpatient: "+ l_update_visit_fin_dtls;
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

					pstmt = dbConn.prepareStatement(l_update_visit_fin_dtls);
				}
				
                pstmt.setString(1, params.get("AUTHORIZATION_NUM").toString());
				pstmt.setTimestamp(2, l_current_date);
                pstmt.setString(3, params.get("MEMBERSHIP_NUM").toString());
                pstmt.setString(4, params.get("DEPD_CODE").toString());
				pstmt.setString(5, params.get("DEPD_RELN").toString());
				pstmt.setString(6, params.get("WCA_NUM").toString());
				pstmt.setString(7, l_warn_code);
				pstmt.setString(8, l_warn_desc);
                pstmt.setString(9, params.get("CLIENT_MACHINE").toString());
				pstmt.setString(10, params.get("LOGIN_USER").toString());
				pstmt.setTimestamp(11, l_current_date);
				pstmt.setString(12, params.get("FACILITY_ID").toString());
                pstmt.setString(13, params.get("M_SURNAME").toString());
				pstmt.setString(14, params.get("M_INITIAL").toString());
				pstmt.setString(15, params.get("FACILITY_ID").toString());
				pstmt.setString(16, params.get("EPISODE_TYPE").toString());
				pstmt.setString(17, params.get("EPISODE_ID").toString());
				pstmt.setString(18, params.get("PATIENT_ID").toString());			

				if (l_settlement_ind.equals("C"))
				{
					pstmt.setString(19, params.get("BLNG_GRP_ID").toString());
				}
				else if (l_settlement_ind.equals("X") || l_settlement_ind.equals("R"))
				{
					pstmt.setString(19, params.get("CUST_CODE").toString());
				}

				if (l_episode_type.equals("O") || l_episode_type.equals("E"))
				{
					if (l_visit_id.equals("XXX"))
					{
						l_visit_id = "0";
					}

				    pstmt.setInt(20, Integer.parseInt(l_visit_id));
				}

				l_episode_count = pstmt.executeUpdate();

				l_app_msg = " ::: Episode Fin Details Update Count : "+ l_episode_count;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				
			}

			if (l_admission_type.equals("1"))
			{
				if(l_patient_fin_count == 1)
				{
					errorMsg = "Patient Financial Details updated successfully ";
					//Conn.commit();				
				}
				else 
				{				
					errorMsg = "Error in updating Patient Financial Details";
					//Conn.rollback();	
					return errorMsg;
				}
			}
			else
			{
				if(l_episode_count == 1)
				{
					errorMsg = "Patient Episode Details updated successfully ";
					//Conn.commit();				
				}
				else 
				{	
					errorMsg = "Error in updating Patient Episode Details";
					//Conn.rollback();	
					return errorMsg;
				}
			}

		}
		
		catch (Exception exp) {
			exp.printStackTrace();
			System.out.println("(updateAuthorisationDetails) Exception " + exp.getMessage());
			return "Error "+exp.getMessage();
		}
		finally {
			closeDBResources(rs, pstmt, null);
		}

		return  errorMsg;
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
			    l_app_msg = " ::: Inside parseResponseXml : "+response +"::: tagName : "+tagName+" ::: attrName : "+attrName;
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
				}				

				l_app_msg = " ::: attrValue : "+attrValue;
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			}
			catch (Exception e)
			{
				l_errcd = "E";
				l_errmsg = "Error in parsing request Xml : "+ e.getMessage();
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
				l_app_msg = " ::: l_race_code : "+l_race_code;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			}


			l_app_msg = ":: l_race_desc :: "+l_race_desc;
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
			XHUtil.closeDBResources(rs, pstmt, Conn);
		}
		return l_race_code;
	}
}
