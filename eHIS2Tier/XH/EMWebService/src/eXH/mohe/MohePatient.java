package eXH.mohe;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import oracle.net.aso.e;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import eXH.util.ConnectionManager;
import eXH.util.EMDataSource;
import eXH.util.XHJSONUtil;
import eXH.util.XHUtil;


public class MohePatient {
	
	static LinkedHashMap<String, HashMap<String, String>> new_hash_map = new LinkedHashMap<String, HashMap<String,String>>();
	static LinkedHashMap<String, HashMap<String, String>> new_hash_map_1 = new LinkedHashMap<String, HashMap<String,String>>();
	static StringBuffer query3 = new StringBuffer();
	static Map<String, Object> l_response_json = new HashMap<String, Object>();
	
	public static String l_debug_YN = "N";
	public static final String l_standard_code = "JSONSTD";
	public static final String l_segment_id = "MP1";
	public static String l_pat_no_gen_yn="";
	
	static String site_id="";
	static String l_pat_no_ctrl="";
	static String l_site_id ="";
	static String l_pat_ser_grp = "";
	static boolean transaction_completed = false;
	static String l_facility_id="";
	static String l_language_id = "";
	static String l_patient_prefix="";
	static String keyStr = "";
	static String valueStr = "";
	static String regn_facility_id ="N";
	static String added_by_id ="INTERFACE";
	static String added_date ="";
	static String added_at_ws_no ="INTERFACE";
	static String modified_at_ws_no ="INTERFACE";
	static String modified_by_id="INTERFACE";
	static String modified_date ="";
	static String modified_facility_id ="";
	static String citizen_yn ="Y";
	static String l_biling_class_code="";
	static String l_settlement_ind="";
	static String l_settlement_type="";
	static String l_cur_acct_seq_no="1";
	static String l_app_msg="";
	static String l_country_name ="";
	static String l_status = "", l_status_desc = "", l_responseJsonString = "";
	

	public static String PatientDetails(String actionKey) throws JsonGenerationException, JsonMappingException, IOException {
	 
 		 
		String  l_in_JSON ="",l_request_ref_no="",l_request_type="",l_request_date_time="" ;
		
		String l_first_name = "", l_second_name = "", l_surname = "", l_gender = "", l_date_of_birth = "", l_mobile_no = "", l_email_id = "";
		
		String l_nationality = "", l_address_line_1 = "", l_address_line_2 = "", l_address_line_3 = "";
		
		String l_city = "", l_district = "",l_state= "",l_postal_code= "",l_country= "", l_postal_code_str = "";
		
		String l_city_code= "", l_district_code = "", l_state_code = "", l_nationality_code = "",l_country_code ="";
		
		String l_race_id = "", l_element_id = "";
		
		String query ="", l_debug_yn = "";
		
		String l_errcd ="";
		
		String l_billing_group_code = "" , l_payer_group_code = "" , l_payer_code = "" , l_policy_type_code = "" , l_policy_number = "" , l_policy_start_date = "";
		
		String l_policy_end_date  = "" , l_non_ins_blng_grp_id = "" , l_financial_details = "" , l_patient_id  = "";
		
		int l_postal_count = 0, l_address_count = 0;
		
		String l_religion_code = "";
		
		String l_national_id= "" , l_alternate_id = "", l_alternate_id_2 = "";
		
		String l_acct_seq_no ="";
		int l_acct_seq_no_next = 1;
		String l_patient_id_1 = "";
		String l_patient_id_2 = "";
		String l_patient_id_3 = "";
		String l_patient_id_4 = "";
        	
		ObjectMapper objMapper = new ObjectMapper();
		
		Connection con				= null;
		PreparedStatement pstmt		= null;
		ResultSet rset				= null;
		
		LinkedHashMap<String, String> MP_PATIENT = null;
		LinkedHashMap<String, String> MP_PAT_ADDRESSES= null;
		LinkedHashMap<String, String> MP_PAT_OTH_DTLS= null;
		LinkedHashMap<String, String> BL_PATIENT_FIN_DTLS= null;
		LinkedHashMap<String, String> BL_ENCOUNTER_PAYER_PRIORITY= null;
		LinkedHashMap<String, String> BL_ENCOUNTER_PAYER_PRIORITY_ANOTHER = null;
		LinkedHashMap<String, String> MP_PAT_REL_CONTACTS= null;
		LinkedHashMap<String, String> MP_PAT_DOCUMENTS= null;
		
		
		try
		{
			con =  EMDataSource.getConnection();

			query = "select NVL(DEBUG_YN, 'N') DEBUG_YN FROM XH_PARAM " ;

			pstmt = con.prepareStatement(query);
			rset = pstmt.executeQuery();
			while(rset.next())
			{
			   l_debug_yn = rset.getString("DEBUG_YN");
			}

			l_debug_YN = l_debug_yn;

		}
		catch(Exception e)
		{
		}		
		finally {
			XHUtil.closeDBResources(rset, pstmt, null);
			EMDataSource.returnConnection(con);
		}
		
		try {
		
			l_in_JSON = XHJSONUtil.createJsonObject(actionKey);
			
			l_app_msg = " ::: Reading in Request Number ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_request_ref_no = XHJSONUtil.getJsonRequestString(l_in_JSON, "request_ref_no");
			if (l_debug_YN.equals("Y")) System.out.println(" ::: Request Ref No ::: "+l_request_ref_no);
			
			l_app_msg = " ::: Reading in Request Type ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_request_type = XHJSONUtil.getJsonRequestString(l_in_JSON, "request_type");
			if (l_debug_YN.equals("Y")) System.out.println(" ::: Request Type ::: "+l_request_type);
			
			l_app_msg = " ::: Reading in Request Date Time ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_request_date_time = XHJSONUtil.getJsonRequestString(l_in_JSON, "request_date_time");		
			if (l_debug_YN.equals("Y")) System.out.println(" ::: Request Date Time ::: "+l_request_date_time);
			
			l_app_msg = " ::: Reading in Patient Data - Facility ID ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_facility_id =XHJSONUtil.getJsonArrayObjString(l_in_JSON, "patient_data", "facility_id");
			if (l_debug_YN.equals("Y")) System.out.println(" ::: Facility Id ::: "+l_facility_id);
			
			try {
							
				l_app_msg = " ::: Reading in Patient Series Group ::: ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				 
				String query1 = "SELECT PAT_SER_GRP_CODE FROM MP_PAT_SER_FACILITY WHERE SITE_OR_FACILITY = 'S' AND SITE_OR_FACILITY_ID = ? and ROWNUM = '1' ";
				con = EMDataSource.getConnection();				
				pstmt = con.prepareStatement(query1);
				if (l_debug_YN.equals("Y")) System.out.println(" ::: Query 1 ::: "+query1);
				pstmt.setString(1,l_facility_id);
				rset = pstmt.executeQuery();
				
				while(rset.next()){
					l_pat_ser_grp = rset.getString("PAT_SER_GRP_CODE");
					if (l_debug_YN.equals("Y")) System.out.println(" ::: Patient Series Group ::: "+l_pat_ser_grp);
				}
				if (l_debug_YN.equals("Y")) System.out.println(" ::: Patient Series Group ::: "+l_pat_ser_grp);
			}catch (Exception e) {   
				
				l_errcd = "E";
				l_status_desc = "Exception in "+l_app_msg+ " - "+e.getMessage();			
				return l_status_desc;
				
			}
			finally {
				EMDataSource.returnConnection(con);
				XHUtil.closeDBResources(rset, pstmt, null);
			}
			
			if("".equals(l_pat_ser_grp.trim())){
				return "Patient Series Group not Configured for this Facility ID to Generate the new Patient ID";
			}
			
			l_app_msg = " ::: Reading in Patient Data - Patient Prefix ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_patient_prefix =XHJSONUtil.getJsonArrayObjString(l_in_JSON, "patient_data", "patient_prefix");
			if (l_debug_YN.equals("Y")) System.out.println(" ::: Patient Prefix ::: "+l_patient_prefix);
			
			l_app_msg = " ::: Reading in Patient Data - First Name ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_first_name =XHJSONUtil.getJsonArrayObjString(l_in_JSON, "patient_data", "first_name");
			if (l_debug_YN.equals("Y")) System.out.println(" ::: First Name ::: "+l_first_name);
			
			l_app_msg = " ::: Reading in Patient Data - Second Name ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_second_name =XHJSONUtil.getJsonArrayObjString(l_in_JSON, "patient_data", "second_name");
			if (l_debug_YN.equals("Y")) System.out.println(" ::: Second Name ::: "+l_second_name);
			
			l_app_msg = " ::: Reading in Patient Data - Surname ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_surname =XHJSONUtil.getJsonArrayObjString(l_in_JSON, "patient_data", "surname");
			if (l_debug_YN.equals("Y")) System.out.println(" ::: Surname ::: "+l_surname);
			
			l_app_msg = " ::: Reading in Patient Data - National ID ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);			
			
			l_national_id =XHJSONUtil.getJsonArrayObjString(l_in_JSON, "patient_data", "national_id");
			if (l_debug_YN.equals("Y")) System.out.println(" ::: National ID ::: "+l_national_id);
			
			l_app_msg = " ::: Reading in Patient Data - Alternate ID ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);			
			
			l_alternate_id =XHJSONUtil.getJsonArrayObjString(l_in_JSON, "patient_data", "alternate_id");
			if (l_debug_YN.equals("Y")) System.out.println(" ::: Alternate ID ::: "+l_alternate_id);
			
			
			l_app_msg = " ::: Reading in Patient Data - Gender ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);			
			
			l_gender =XHJSONUtil.getJsonArrayObjString(l_in_JSON, "patient_data", "gender");
			if (l_debug_YN.equals("Y")) System.out.println(" ::: Gender ::: "+l_gender);
			
			l_app_msg = " ::: Reading in Patient Data - Date Of Birth ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_date_of_birth =XHJSONUtil.getJsonArrayObjString(l_in_JSON, "patient_data", "date_of_birth");
			if (l_debug_YN.equals("Y")) System.out.println(" ::: Date of Birth ::: "+l_date_of_birth);
			
			l_app_msg = " ::: Reading in Patient Data - Mobile No ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_mobile_no =XHJSONUtil.getJsonArrayObjString(l_in_JSON, "patient_data", "mobile_no");
			if (l_debug_YN.equals("Y")) System.out.println(" ::: Mobile No ::: "+l_mobile_no);
			
			l_app_msg = " ::: Reading in Patient Data - EmailId ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
						
			l_email_id =XHJSONUtil.getJsonArrayObjString(l_in_JSON, "patient_data", "email_id");
			if (l_debug_YN.equals("Y")) System.out.println(" ::: Email ID ::: "+l_email_id);
			
			l_app_msg = " ::: Reading in Patient Data - Nationality ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_nationality =XHJSONUtil.getJsonArrayObjString(l_in_JSON, "patient_data", "nationality");
			if (l_debug_YN.equals("Y")) System.out.println(" ::: Nationality ::: "+l_nationality);
			
			l_app_msg = " ::: Reading in Patient Data - AddressLine1 ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_address_line_1 =XHJSONUtil.getJsonArrayObjString(l_in_JSON, "patient_data", "address_line_1");
			if (l_debug_YN.equals("Y")) System.out.println(" ::: Address Line 1 ::: "+l_address_line_1);
			
			l_app_msg = " ::: Reading in Patient Data - AddressLine2 ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_address_line_2 =XHJSONUtil.getJsonArrayObjString(l_in_JSON, "patient_data", "address_line_2");
			if (l_debug_YN.equals("Y")) System.out.println(" ::: Address Line 2 ::: "+l_address_line_2);
			
			l_app_msg = " ::: Reading in Patient Data - AddressLine3 ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
	
			l_address_line_3 =XHJSONUtil.getJsonArrayObjString(l_in_JSON, "patient_data", "address_line_3");
			if (l_debug_YN.equals("Y")) System.out.println(" ::: Address Line 3 ::: "+l_address_line_3);
			
			l_app_msg = " ::: Reading in Patient Data - City ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
		
			
			l_city =XHJSONUtil.getJsonArrayObjString(l_in_JSON, "patient_data", "city");
			if (l_debug_YN.equals("Y")) System.out.println(" ::: City :::  "+l_city);
			
			l_app_msg = " ::: Reading in Patient Data - District ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_district =XHJSONUtil.getJsonArrayObjString(l_in_JSON, "patient_data", "district");
			if (l_debug_YN.equals("Y")) System.out.println(" ::: District :::  "+l_district);
			
			l_app_msg = " ::: Reading in Patient Data - State ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_state =XHJSONUtil.getJsonArrayObjString(l_in_JSON, "patient_data", "state");
			if (l_debug_YN.equals("Y")) System.out.println(" ::: State :::  "+l_state);
			
			l_app_msg = " ::: Reading in Patient Data - Postal Code ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_postal_code =XHJSONUtil.getJsonArrayObjString(l_in_JSON, "patient_data", "postal_code");
			if (l_debug_YN.equals("Y")) System.out.println(" ::: Postal Code ::: "+l_postal_code);
			
			l_app_msg = " ::: Reading in Patient Data - Country ::: ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			l_country =XHJSONUtil.getJsonArrayObjString(l_in_JSON, "patient_data", "country");
			if (l_debug_YN.equals("Y")) System.out.println(" ::: Country ::: "+l_country);	
			
			if(l_in_JSON.contains("financial_details"))
			{
				l_app_msg = " ::: Reading in Patient Data - Financial Details ::: ";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				Map<String, Object> patDocument = new HashMap<String, Object>(); 
				List<Integer> financial = null;
				
				try {
				
					patDocument = new ObjectMapper()
		        		.readValue(l_in_JSON, new TypeReference<Map<String, Object>>() {});
	
					List<Object> patList = (List<Object>) patDocument.get("patient_data");
					Map<String, Object> patMap = (Map<String, Object>) patList.get(0);
					
					if (l_debug_YN.equals("Y")) System.out.println(" ::: patMap ::: "+patMap.toString());
					
					financial = (List<Integer>) patMap.get("financial_details");
					
					if (l_debug_YN.equals("Y")) System.out.println(" ::: financial.size() ::: "+financial.size());
					
					if (financial.size()>0)
					{		
						List<Object> finList = (List<Object>) patMap.get("financial_details");
						Map<String, Object> finMap = (Map<String, Object>) finList.get(0);
						
						if (l_debug_YN.equals("Y")) System.out.println(" ::: finMap ::: "+finMap.toString());			
						
					}
				
				}catch (Exception e){
					if (l_debug_YN.equals("Y")) System.out.println(e.getMessage());
				}
				
				if (financial.size()>0)
				{
					l_financial_details =XHJSONUtil.getJsonArrayObjString(l_in_JSON, "patient_data", "financial_details");
					if (l_debug_YN.equals("Y")) System.out.println(" ::: Financial Details ::: "+l_financial_details);
					
					l_financial_details = l_financial_details.replace("[", "");
					l_financial_details = l_financial_details.replace("]", "");
					if (l_debug_YN.equals("Y")) System.out.println(" ::: Financial Details After::: "+l_financial_details);
					
					l_app_msg = " ::: Reading in Financial Details - Billing Group Code ::: ";
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
					
					l_billing_group_code =XHJSONUtil.getJsonRequestString( l_financial_details , "billing_group_code");
					if (l_debug_YN.equals("Y")) System.out.println(" ::: Billing Group Code ::: "+l_billing_group_code);
					
					l_app_msg = " ::: Reading in Financial Details - Payer Group Code ::: ";
					if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
					
					l_payer_group_code =XHJSONUtil.getJsonRequestString(l_financial_details, "payer_group_code");
					if (l_debug_YN.equals("Y")) System.out.println(" ::: Payer Group Code ::: "+l_payer_group_code);
					
					l_app_msg = " ::: Reading in Financial Details - Payer Code ::: ";
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
					
					l_payer_code =XHJSONUtil.getJsonRequestString(l_financial_details, "payer_code");
					if (l_debug_YN.equals("Y")) System.out.println(" ::: Payer Code ::: "+l_payer_code);
					
					l_app_msg = " ::: Reading in Financial Details - Policy Type Code ::: ";
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
					
					l_policy_type_code =XHJSONUtil.getJsonRequestString(l_financial_details, "policy_type_code");
					if (l_debug_YN.equals("Y")) System.out.println(" ::: Payer Code ::: "+l_policy_type_code);
					
					l_app_msg = " ::: Reading in Financial Details - Policy Number ::: ";
					if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
					
					l_policy_number = XHJSONUtil.getJsonRequestString(l_financial_details , "policy_number");
					if (l_debug_YN.equals("Y")) System.out.println(" ::: Policy Number ::: "+l_policy_number);
					
					l_app_msg = " ::: Reading in Financial Details- Policy Start Date ::: ";
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
					
					l_policy_start_date = XHJSONUtil.getJsonRequestString(l_financial_details , "policy_start_date");
					if (l_debug_YN.equals("Y")) System.out.println(" ::: Policy Start Date ::: "+l_policy_start_date);
					
					l_app_msg = " ::: Reading in Financial Details - Policy End Date ::: ";
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
					
					l_policy_end_date = XHJSONUtil.getJsonRequestString(l_financial_details , "policy_end_date");
					if (l_debug_YN.equals("Y")) System.out.println(" ::: Policy End Date ::: "+l_policy_start_date);
					
					l_app_msg = " ::: Reading in Financial Details - Non Insurance Billng Group Id ::: ";
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
					
					l_non_ins_blng_grp_id = XHJSONUtil.getJsonRequestString(l_financial_details , "non_ins_blng_grp_id");
					if (l_debug_YN.equals("Y")) System.out.println(" ::: Non Insurance Billng Group Id ::: "+l_non_ins_blng_grp_id);	
				}
			}
			// l_alternate_id_2 added here
			l_app_msg = " ::: Reading in Patient Data - Alternate ID 2 ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);			
			
			l_alternate_id_2 =XHJSONUtil.getJsonArrayObjString(l_in_JSON, "patient_data", "alternate_id_2");
			if (l_debug_YN.equals("Y")) System.out.println(" ::: Alternate ID 2 ::: "+l_alternate_id_2);
			
			l_patient_id =XHJSONUtil.getJsonArrayObjString(l_in_JSON, "patient_data", "patient_id");
			if (l_debug_YN.equals("Y")) System.out.println(" ::: Patient ID  ::: "+l_patient_id);
			
			
		}
		catch(Exception e){
			
			l_errcd = "E";
			l_status_desc = "Exception in "+l_app_msg+ " - "+e.getMessage();
		
			return l_status_desc;
			
		}
		
		try {
				
				/*l_app_msg = " ::: Reading in Patient Series Group ::: ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				
				l_element_id = "PAT_SER_GRP_CODE";
				
				l_pat_ser_grp = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code);
				if (l_debug_YN.equals("Y")) System.out.println(" ::: Patient Serice group ::: "+l_pat_ser_grp);*/
				 
				String query1 = "select gen_pat_id_yn ,pat_no_ctrl from MP_PAT_SER_GRP where PAT_SER_GRP_CODE = ? ";
				//String query2 = "select site_id from sm_site_param ";
				con = EMDataSource.getConnection();
				
				l_app_msg = " ::: Reading in Patient Series Group for ::: "+l_pat_ser_grp;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				
				pstmt = con.prepareStatement(query1);
				if (l_debug_YN.equals("Y")) System.out.println(" ::: Query 1 ::: "+query1);
				pstmt.setString(1,l_pat_ser_grp);
				rset = pstmt.executeQuery();
				
				while(rset.next()){
					l_pat_no_gen_yn = rset.getString("gen_pat_id_yn");
				    l_pat_no_ctrl = rset.getString("pat_no_ctrl");
				if (l_debug_YN.equals("Y")) System.out.println("l_pat_no_gen_yn"+l_pat_no_gen_yn);
				if (l_debug_YN.equals("Y")) System.out.println("l_pat_no_ctrl"+l_pat_no_ctrl);
				}
				
				/*if (rset!= null) rset.close(); 
				if (pstmt!= null) pstmt.close(); 
				
				l_app_msg = " ::: Reading in Site Param ::: ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				
				pstmt = con.prepareStatement(query2);
				rset = pstmt.executeQuery();
				while(rset.next()){
					l_site_id = rset.getString("site_id");					
				}
				if (l_debug_YN.equals("Y")) System.out.println(" ::: Site Id ::: "+l_site_id);	*/
			}catch (Exception e) {   
				
				l_errcd = "E";
				l_status_desc = "Exception in "+l_app_msg+ " - "+e.getMessage();
			
				return l_status_desc;
				
			}
			finally {
				EMDataSource.returnConnection(con);
				XHUtil.closeDBResources(rset, pstmt, null);
			}

		try
		{
				l_element_id ="LANG_ID";
				l_language_id = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code);
				if (l_debug_YN.equals("Y")) System.out.println(" ::: Language Id ::: "+l_language_id);
				 
				l_element_id ="RACE_ID";
				l_race_id = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code);
				if (l_debug_YN.equals("Y")) System.out.println(" ::: Race Id  ::: "+l_race_id);
				 	
			 	l_app_msg = " ::: Reading in Billing Group Id,Settlement Type,Biling Class code,Settlement Ind ::: ";
			 	if (l_debug_YN.equals("Y"))
			 		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				 	
				l_element_id ="BLNG_CLASS_CODE";
				l_biling_class_code= FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code);
				if (l_debug_YN.equals("Y")) System.out.println(" ::: Billing class Code ::: "+l_biling_class_code);
				 	
				l_element_id ="SETTLEMENT_IND";
				l_settlement_ind = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code);
				if (l_debug_YN.equals("Y")) System.out.println(" ::: settlement Id ::: "+l_settlement_ind);
				 	
				l_element_id ="SLMT_TYPE_CODE";
				l_settlement_type = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code);
				if (l_debug_YN.equals("Y")) System.out.println(" ::: Settlement Type ::: "+l_settlement_type);
				
				l_element_id ="RELGN_CODE";
				
				l_religion_code = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code);
				if (l_debug_YN.equals("Y")) System.out.println(" ::: Settlement Type ::: "+l_settlement_type); 	
		}catch (Exception e) {
		
			l_errcd = "E";
			l_status_desc = "Exception in "+l_app_msg+ " - "+e.getMessage();
		
			return l_status_desc;
		}
		
		String Patient_name = "";
	
		Patient_name = PatientName(l_patient_prefix, l_first_name, l_second_name, l_surname);
	
		l_app_msg = " ::: Patient Name ::: "+Patient_name;
		if (l_debug_YN.equals("Y"))
		System.out.println(l_app_msg);
			
		 try {
	 		
				l_app_msg = " ::: Fetching Patient_Id, Nationality_Id, Alternatr_Id_2 ::: ";
				StringBuffer whereClause = new StringBuffer();
				StringBuffer whereCond = new StringBuffer();
				con = EMDataSource.getConnection();
				String query5 =  "select patient_id from mp_patient " ;
				whereClause.append(" where ");
				
				if (l_national_id.length()>0) 
					whereCond.append(" national_id_no = ? ");	
				
				if ((l_alternate_id_2.length()>0) && (whereCond.length()>0))
					whereCond.append(" and alt_id2_no = ? ");
				else if (l_alternate_id_2.length()>0)
					whereCond.append(" alt_id2_no = ? ");					
				
				if ((l_patient_id.length()>0) && (whereCond.length()>0))
					whereCond.append(" AND patient_id = ? ");
				else if (l_patient_id.length()>0)
					whereCond.append(" patient_id = ? ");
				
				whereClause.append(whereCond);
				
				query5 = query5 + whereClause.toString();
				//System.out.println("query5.."+query5);
				pstmt = con.prepareStatement(query5);
				
				if (l_national_id.length()>0) 
					pstmt.setString(1, l_national_id);				
				
				if (l_alternate_id_2.length()>0) 
					pstmt.setString(2, l_alternate_id_2);
				else
				{
					if (l_patient_id.length()>0) 
						pstmt.setString(2, l_patient_id);
				}
				
				if(l_alternate_id_2.length()>0 && l_patient_id.length()>0)
					pstmt.setString(3,l_patient_id);
				
				rset = pstmt.executeQuery();	
				
				
				while(rset.next()){		
						l_patient_id_2 = rset.getString("patient_id");
						
				}
				//if (l_debug_YN.equals("Y")) System.out.println(" ::: l_patient_id_2 ::: "+l_patient_id_2);
					
					if (pstmt != null) pstmt.close();
					if (rset != null) rset.close();
					
			 }catch (Exception e1) {
				 
				l_errcd = "E";
				l_status_desc = "Exception in "+l_app_msg+ " - "+e1.getMessage();
				e1.printStackTrace();
				
				return l_status_desc;
			}finally {
				EMDataSource.returnConnection(con);
				XHUtil.closeDBResources(rset, pstmt, null);
			}
			
				
		try
		{	
				
			MP_PATIENT = new LinkedHashMap<String, String>();
			MP_PAT_ADDRESSES= new LinkedHashMap<String, String>();
			MP_PAT_OTH_DTLS= new LinkedHashMap<String, String>();
			MP_PAT_REL_CONTACTS= new LinkedHashMap<String, String>();
			MP_PAT_DOCUMENTS= new LinkedHashMap<String, String>();
			BL_PATIENT_FIN_DTLS= new LinkedHashMap<String, String>();
			BL_ENCOUNTER_PAYER_PRIORITY= new LinkedHashMap<String, String>();
			BL_ENCOUNTER_PAYER_PRIORITY_ANOTHER = new LinkedHashMap<String, String>();	
			
			new_hash_map = new LinkedHashMap<String, HashMap<String,String>>();
			new_hash_map_1 = new LinkedHashMap<String, HashMap<String,String>>();
			
			if (l_request_type.equals("REGPAT"))
			{
				/*if(l_pat_no_gen_yn.equals("Y") && "".equals(l_patient_id.trim()))
		    	{
					l_patient_id_3 = generatePatientID();
		    	}	
				else
					l_patient_id_3 = l_patient_id_2;
				*/
				if (l_first_name.length()>0)
				{
					MP_PATIENT.put("NAME_PREFIX", l_patient_prefix);
					MP_PATIENT.put("PATIENT_NAME", Patient_name);
					MP_PATIENT.put("FIRST_NAME", l_first_name);
					MP_PATIENT.put("SECOND_NAME", l_second_name);
					MP_PATIENT.put("FAMILY_NAME", l_surname);
					MP_PATIENT.put("SEX", l_gender);
					MP_PATIENT.put("DATE_OF_BIRTH", "TO_DATE('"+l_date_of_birth+"','DD/MM/YYYY')");
					MP_PATIENT.put("CONTACT1_NO", l_mobile_no);
					MP_PATIENT.put("EMAIL_ID", l_email_id);
					MP_PATIENT.put("NATIONALITY_CODE", l_nationality); //l_nationality	
					MP_PATIENT.put("ADDED_BY_ID", added_by_id);
					MP_PATIENT.put("ADDED_DATE", "SYSDATE");
					MP_PATIENT.put("ADDED_AT_WS_NO", added_at_ws_no);
					MP_PATIENT.put("ADDED_FACILITY_ID", l_facility_id);
					MP_PATIENT.put("MODIFIED_BY_ID", modified_by_id);
					MP_PATIENT.put("MODIFIED_DATE","SYSDATE");
					MP_PATIENT.put("MODIFIED_AT_WS_NO", modified_at_ws_no);
					MP_PATIENT.put("MODIFIED_FACILITY_ID", l_facility_id);
					MP_PATIENT.put("PAT_SER_GRP_CODE", l_pat_ser_grp);
					MP_PATIENT.put("REGN_FACILITY_ID", l_facility_id);
					MP_PATIENT.put("LANGUAGE_ID", l_language_id);
					MP_PATIENT.put("RACE_CODE", l_race_id);
					MP_PATIENT.put("CITIZEN_YN", "Y");
					MP_PATIENT.put("PREF_FACILITY_ID", l_facility_id );
					MP_PATIENT.put("REGN_DATE","trunc(SYSDATE)"); //Registration_Date
					MP_PATIENT.put("GENERAL_ALERT","Y");
					MP_PATIENT.put("RELGN_CODE",l_religion_code);
					MP_PATIENT.put("NATIONAL_ID_NO",l_national_id);
					MP_PATIENT.put("ALT_ID1_NO",l_alternate_id);
					MP_PATIENT.put("ALT_ID2_NO",l_alternate_id_2);//l_alternate_id_2
					//MP_PATIENT.put("PATIENT_ID", l_patient_id_3);							
					MP_PATIENT.put("REGION_CODE", l_state_code); //l_state
					MP_PATIENT.put("RES_AREA_CODE", l_district_code); //l_district
					MP_PATIENT.put("RES_TOWN_CODE", l_city_code); //l_city	
					new_hash_map.put("MP_PATIENT", MP_PATIENT);
				}
				
				if(l_pat_no_gen_yn.equals("Y") && "".equals(l_patient_id.trim()) && !(l_patient_id_2.length()>0))
		    	{
					l_patient_id_3 = generatePatientID();
		    	}	
				else
				{
					l_patient_id_3 = l_patient_id_2;
				}
				
				if (l_first_name.length()>0)
				{
					MP_PATIENT.put("PATIENT_ID", l_patient_id_3);	
					new_hash_map.put("MP_PATIENT", MP_PATIENT);
				}
				
				if (l_address_line_1.length()>0)
				{
					MP_PAT_ADDRESSES.put("PATIENT_ID", l_patient_id_3);
					MP_PAT_ADDRESSES.put("ADDR1_LINE1", l_address_line_1);
					MP_PAT_ADDRESSES.put("ADDR1_LINE2", l_address_line_2);
					MP_PAT_ADDRESSES.put("ADDR1_LINE3", l_address_line_3);
					MP_PAT_ADDRESSES.put("POSTAL1_CODE", l_postal_code);
					MP_PAT_ADDRESSES.put("REGION1_CODE", l_state); //l_state
					MP_PAT_ADDRESSES.put("RES_AREA1_CODE", l_district); //l_district
					MP_PAT_ADDRESSES.put("RES_TOWN1_CODE", l_city); //l_city
					MP_PAT_ADDRESSES.put("COUNTRY1_CODE", l_country);//l_country
					MP_PAT_ADDRESSES.put("ADDED_BY_ID", added_by_id);
					MP_PAT_ADDRESSES.put("ADDED_DATE", "SYSDATE");
					MP_PAT_ADDRESSES.put("ADDED_AT_WS_NO", added_at_ws_no);
					MP_PAT_ADDRESSES.put("ADDED_FACILITY_ID", l_facility_id);
					MP_PAT_ADDRESSES.put("MODIFIED_BY_ID", modified_by_id);
					MP_PAT_ADDRESSES.put("MODIFIED_DATE","SYSDATE");
					MP_PAT_ADDRESSES.put("MODIFIED_AT_WS_NO", modified_at_ws_no);
					MP_PAT_ADDRESSES.put("MODIFIED_FACILITY_ID", l_facility_id);	
					MP_PAT_ADDRESSES.put("ADDR1_TYPE", "RES");
				
					MP_PAT_OTH_DTLS.put("PATIENT_ID", l_patient_id_3);
					MP_PAT_OTH_DTLS.put("LIVING_DEPENDENCY", "UN");
					MP_PAT_OTH_DTLS.put("LIVING_ARRANGEMENT", "U");
					MP_PAT_OTH_DTLS.put("ADDED_BY_ID", added_by_id);
					MP_PAT_OTH_DTLS.put("ADDED_DATE", "SYSDATE");
					MP_PAT_OTH_DTLS.put("ADDED_AT_WS_NO", added_at_ws_no);
					MP_PAT_OTH_DTLS.put("ADDED_FACILITY_ID", l_facility_id);
					MP_PAT_OTH_DTLS.put("MODIFIED_BY_ID", modified_by_id);
					MP_PAT_OTH_DTLS.put("MODIFIED_DATE","SYSDATE");
					MP_PAT_OTH_DTLS.put("MODIFIED_AT_WS_NO", modified_at_ws_no);
					MP_PAT_OTH_DTLS.put("MODIFIED_FACILITY_ID", l_facility_id);	
					
					MP_PAT_REL_CONTACTS.put("PATIENT_ID", l_patient_id_3);
					MP_PAT_REL_CONTACTS.put("CONTACT1_ROLE", "NEXT");
					MP_PAT_REL_CONTACTS.put("CONTACT2_ROLE", "FRST");
					MP_PAT_REL_CONTACTS.put("ADDED_BY_ID", added_by_id);
					MP_PAT_REL_CONTACTS.put("ADDED_DATE", "SYSDATE");
					MP_PAT_REL_CONTACTS.put("ADDED_AT_WS_NO", added_at_ws_no);
					MP_PAT_REL_CONTACTS.put("ADDED_FACILITY_ID", l_facility_id);
					MP_PAT_REL_CONTACTS.put("MODIFIED_BY_ID", modified_by_id);
					MP_PAT_REL_CONTACTS.put("MODIFIED_DATE","SYSDATE");
					MP_PAT_REL_CONTACTS.put("MODIFIED_AT_WS_NO", modified_at_ws_no);
					MP_PAT_REL_CONTACTS.put("MODIFIED_FACILITY_ID", l_facility_id);	
					
					MP_PAT_DOCUMENTS.put("PATIENT_ID", l_patient_id_3);
					MP_PAT_DOCUMENTS.put("ADDED_BY_ID", added_by_id);
					MP_PAT_DOCUMENTS.put("ADDED_DATE", "SYSDATE");
					MP_PAT_DOCUMENTS.put("ADDED_AT_WS_NO", added_at_ws_no);
					MP_PAT_DOCUMENTS.put("ADDED_FACILITY_ID", l_facility_id);
					MP_PAT_DOCUMENTS.put("MODIFIED_BY_ID", modified_by_id);
					MP_PAT_DOCUMENTS.put("MODIFIED_DATE","SYSDATE");
					MP_PAT_DOCUMENTS.put("MODIFIED_AT_WS_NO", modified_at_ws_no);
					MP_PAT_DOCUMENTS.put("MODIFIED_FACILITY_ID", l_facility_id);
				}
			}
			
			
			if ("".equals(l_patient_id_2.trim()) && (l_request_type.equals("REGPAT")) && !(l_patient_id_2.length()>0))
			{					
			    l_app_msg = " ::: Inserting Patient Details - Demographic Information ::: ";
			    if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
			    
			   /* new_hash_map.clear();		
			    
			    if (MP_PATIENT.size()>0)
					new_hash_map.put("MP_PATIENT", MP_PATIENT);*/
			    
				
					if (MP_PAT_ADDRESSES.size()>0)							
						new_hash_map.put("MP_PAT_ADDRESSES", MP_PAT_ADDRESSES);
					
					if (MP_PAT_OTH_DTLS.size()>0)	
						new_hash_map.put("MP_PAT_OTH_DTLS", MP_PAT_OTH_DTLS);
					
					if (MP_PAT_REL_CONTACTS.size()>0)	
						new_hash_map.put("MP_PAT_REL_CONTACTS", MP_PAT_REL_CONTACTS);
					
					if (MP_PAT_DOCUMENTS.size()>0)	
						new_hash_map.put("MP_PAT_DOCUMENTS", MP_PAT_DOCUMENTS);
					
					if (new_hash_map.size()>0)	
						InserData(new_hash_map);

				
					new_hash_map.clear();					
					
					if(!("".equals(l_billing_group_code.trim())))
					{
						BL_PATIENT_FIN_DTLS.put("PATIENT_ID", l_patient_id_3);
						BL_PATIENT_FIN_DTLS.put("CUR_ACCT_SEQ_NO", l_cur_acct_seq_no);
						BL_PATIENT_FIN_DTLS.put("BLNG_GRP_ID", l_billing_group_code ); //added
						BL_PATIENT_FIN_DTLS.put("CUST_CODE", l_payer_code); //added
						BL_PATIENT_FIN_DTLS.put("BLNG_CLASS_CODE", l_biling_class_code);
						BL_PATIENT_FIN_DTLS.put("SETTLEMENT_IND", l_settlement_ind);
						BL_PATIENT_FIN_DTLS.put("SLMT_TYPE_CODE", l_settlement_type);
						BL_PATIENT_FIN_DTLS.put("POLICY_TYPE_CODE", l_policy_type_code); //added
						BL_PATIENT_FIN_DTLS.put("POLICY_NUMBER", l_policy_number); //added
						BL_PATIENT_FIN_DTLS.put("POLICY_START_DATE", "TO_DATE('"+l_policy_start_date+"','dd/MM/yyyy')"); //added
						BL_PATIENT_FIN_DTLS.put("POLICY_EXPIRY_DATE", "TO_DATE('"+l_policy_end_date+"','dd/MM/yyyy')"); //added
						BL_PATIENT_FIN_DTLS.put("CUST_GROUP_CODE", l_payer_group_code); //added
						BL_PATIENT_FIN_DTLS.put("NON_INS_BLNG_GRP_ID",l_non_ins_blng_grp_id); //added
						BL_PATIENT_FIN_DTLS.put("ADDED_BY_ID", added_by_id);
						BL_PATIENT_FIN_DTLS.put("ADDED_DATE", "SYSDATE");
						BL_PATIENT_FIN_DTLS.put("ADDED_AT_WS_NO", added_at_ws_no);
						BL_PATIENT_FIN_DTLS.put("ADDED_FACILITY_ID", l_facility_id);
						BL_PATIENT_FIN_DTLS.put("MODIFIED_BY_ID", modified_by_id);
						BL_PATIENT_FIN_DTLS.put("MODIFIED_DATE","SYSDATE");
						BL_PATIENT_FIN_DTLS.put("MODIFIED_AT_WS_NO", modified_at_ws_no);
						BL_PATIENT_FIN_DTLS.put("MODIFIED_FACILITY_ID", l_facility_id);				
						new_hash_map.put("BL_PATIENT_FIN_DTLS", BL_PATIENT_FIN_DTLS);
					
						BL_ENCOUNTER_PAYER_PRIORITY.put("PATIENT_ID", l_patient_id_3);
						BL_ENCOUNTER_PAYER_PRIORITY.put("OPERATING_FACILITY_ID", l_facility_id);
						BL_ENCOUNTER_PAYER_PRIORITY.put("EPISODE_TYPE", "R");
						BL_ENCOUNTER_PAYER_PRIORITY.put("ACCT_SEQ_NO", "1");
						BL_ENCOUNTER_PAYER_PRIORITY.put("ACCT_SEQ_EFF_FROM_DATE", "SYSDATE");
						BL_ENCOUNTER_PAYER_PRIORITY.put("ENC_REGN_DATE_TIME", "SYSDATE");
						BL_ENCOUNTER_PAYER_PRIORITY.put("BLNG_GRP_ID", l_billing_group_code); //added
						BL_ENCOUNTER_PAYER_PRIORITY.put("SETTLEMENT_IND", "X");
						BL_ENCOUNTER_PAYER_PRIORITY.put("CUST_CODE", l_payer_code); //added
						BL_ENCOUNTER_PAYER_PRIORITY.put("PRIORITY", "1");
						BL_ENCOUNTER_PAYER_PRIORITY.put("POLICY_TYPE_CODE", l_policy_type_code); //added
						BL_ENCOUNTER_PAYER_PRIORITY.put("POLICY_NUMBER", l_policy_number); //added	
						BL_ENCOUNTER_PAYER_PRIORITY.put("POLICY_START_DATE", "TO_DATE('"+l_policy_start_date+"','dd/MM/yyyy')"); //added
						BL_ENCOUNTER_PAYER_PRIORITY.put("POLICY_EXPIRY_DATE", "TO_DATE('"+l_policy_end_date+"','dd/MM/yyyy')"); //added
						BL_ENCOUNTER_PAYER_PRIORITY.put("CREDIT_AUTH_DATE", "SYSDATE"); //added
						BL_ENCOUNTER_PAYER_PRIORITY.put("EFFECTIVE_FROM", "TO_DATE('"+l_policy_start_date+"','dd/MM/yyyy')"); //added
						BL_ENCOUNTER_PAYER_PRIORITY.put("EFFECTIVE_TO", "TO_DATE('"+l_policy_end_date+"','dd/MM/yyyy')"); //added
						BL_ENCOUNTER_PAYER_PRIORITY.put("CUST_GROUP_CODE", l_payer_group_code); //added
						BL_ENCOUNTER_PAYER_PRIORITY.put("ADDED_BY_ID", added_by_id);
						BL_ENCOUNTER_PAYER_PRIORITY.put("ADDED_DATE", "SYSDATE");
						BL_ENCOUNTER_PAYER_PRIORITY.put("ADDED_AT_WS_NO", added_at_ws_no);
						BL_ENCOUNTER_PAYER_PRIORITY.put("ADDED_FACILITY_ID", l_facility_id);
						BL_ENCOUNTER_PAYER_PRIORITY.put("MODIFIED_BY_ID", modified_by_id);
						BL_ENCOUNTER_PAYER_PRIORITY.put("MODIFIED_DATE","SYSDATE");
						BL_ENCOUNTER_PAYER_PRIORITY.put("MODIFIED_AT_WS_NO", modified_at_ws_no);
						BL_ENCOUNTER_PAYER_PRIORITY.put("MODIFIED_FACILITY_ID", l_facility_id);
						BL_ENCOUNTER_PAYER_PRIORITY.put("MAND_ADDL_INFO_RECORDED_YN", "N");
						BL_ENCOUNTER_PAYER_PRIORITY.put("PRE_INV_YN", "N");
						BL_ENCOUNTER_PAYER_PRIORITY.put("PRE_INV_FIN_YN", "N");
						BL_ENCOUNTER_PAYER_PRIORITY.put("INT_RESPONSE_CODE", "0");
						BL_ENCOUNTER_PAYER_PRIORITY.put("INT_VALIDITY_TYPE", "0");
						new_hash_map.put("BL_ENCOUNTER_PAYER_PRIORITY", BL_ENCOUNTER_PAYER_PRIORITY);
						InserData(new_hash_map);
						//if (l_debug_YN.equals("Y")) System.out.println(" ::: Insert data completed for BL_ENCOUNTER_PAYER_PRIORITY::: ");
					
						new_hash_map.clear();
						BL_ENCOUNTER_PAYER_PRIORITY_ANOTHER.put("PATIENT_ID", l_patient_id_3);
						BL_ENCOUNTER_PAYER_PRIORITY_ANOTHER.put("OPERATING_FACILITY_ID",l_facility_id);
						BL_ENCOUNTER_PAYER_PRIORITY_ANOTHER.put("EPISODE_TYPE", "R");
						BL_ENCOUNTER_PAYER_PRIORITY_ANOTHER.put("ACCT_SEQ_NO", "1");
						BL_ENCOUNTER_PAYER_PRIORITY_ANOTHER.put("ACCT_SEQ_EFF_FROM_DATE", "SYSDATE");
						BL_ENCOUNTER_PAYER_PRIORITY_ANOTHER.put("ENC_REGN_DATE_TIME", "SYSDATE");
						BL_ENCOUNTER_PAYER_PRIORITY_ANOTHER.put("BLNG_GRP_ID",l_non_ins_blng_grp_id ); //added
						BL_ENCOUNTER_PAYER_PRIORITY_ANOTHER.put("SETTLEMENT_IND", "C");
						BL_ENCOUNTER_PAYER_PRIORITY_ANOTHER.put("ADDED_BY_ID", added_by_id);
						BL_ENCOUNTER_PAYER_PRIORITY_ANOTHER.put("ADDED_DATE", "SYSDATE");
						BL_ENCOUNTER_PAYER_PRIORITY_ANOTHER.put("ADDED_AT_WS_NO", added_at_ws_no);
						BL_ENCOUNTER_PAYER_PRIORITY_ANOTHER.put("ADDED_FACILITY_ID", l_facility_id);
						BL_ENCOUNTER_PAYER_PRIORITY_ANOTHER.put("MODIFIED_BY_ID", modified_by_id);
						BL_ENCOUNTER_PAYER_PRIORITY_ANOTHER.put("MODIFIED_DATE","SYSDATE");
						BL_ENCOUNTER_PAYER_PRIORITY_ANOTHER.put("MODIFIED_AT_WS_NO", modified_at_ws_no);
						BL_ENCOUNTER_PAYER_PRIORITY_ANOTHER.put("MODIFIED_FACILITY_ID", l_facility_id);
						BL_ENCOUNTER_PAYER_PRIORITY_ANOTHER.put("MAND_ADDL_INFO_RECORDED_YN", "N");
						BL_ENCOUNTER_PAYER_PRIORITY_ANOTHER.put("PRE_INV_YN", "N");
						BL_ENCOUNTER_PAYER_PRIORITY_ANOTHER.put("PRE_INV_FIN_YN", "N");
						BL_ENCOUNTER_PAYER_PRIORITY_ANOTHER.put("INT_RESPONSE_CODE", "0");
						BL_ENCOUNTER_PAYER_PRIORITY_ANOTHER.put("INT_VALIDITY_TYPE", "0");
						new_hash_map.put("BL_ENCOUNTER_PAYER_PRIORITY", BL_ENCOUNTER_PAYER_PRIORITY_ANOTHER);
						InserData(new_hash_map);
						//if (l_debug_YN.equals("Y")) System.out.println(" ::: Insert data completed after BL_ENCOUNTER_PAYER_PRIORITY_ANOTHER::: ");
						new_hash_map.clear();		
				}
				l_patient_id = l_patient_id_3;//Storing the patient_id			
				//if (l_debug_YN.equals("Y")) System.out.println("::: Insert data completed");
			}  
			}catch (Exception e1) {
		
		
				//if (l_debug_YN.equals("Y")) System.out.println("return l_status_desc"+l_status_desc);
					 
				l_errcd = "E";
				l_status_desc = "Exception in "+l_app_msg+ " - "+e1.getMessage();
				//if (l_debug_YN.equals("Y")) System.out.println("return l_status_desc"+l_status_desc);
				
				
				return l_status_desc;	
			}
			
			if (l_debug_YN.equals("Y")) System.out.println("*************UpdateData***************");
			if (l_patient_id_2.length()>0 && (l_request_type.equals("REGPAT")))
			{				
			   try {
				   
					l_app_msg = " ::: Updating Patient Details ::: ";
					
					if (MP_PATIENT.size()>0)
						new_hash_map.put("MP_PATIENT", MP_PATIENT);
					
					if (MP_PAT_ADDRESSES.size()>0)							
						new_hash_map.put("MP_PAT_ADDRESSES", MP_PAT_ADDRESSES);
					
					if (MP_PAT_OTH_DTLS.size()>0)	
						new_hash_map.put("MP_PAT_OTH_DTLS", MP_PAT_OTH_DTLS);
					
					if (MP_PAT_REL_CONTACTS.size()>0)	
						new_hash_map.put("MP_PAT_REL_CONTACTS", MP_PAT_REL_CONTACTS);
					
					if (MP_PAT_DOCUMENTS.size()>0)	
						new_hash_map.put("MP_PAT_DOCUMENTS", MP_PAT_DOCUMENTS);
					
					if (new_hash_map.size()>0)	
						UpdateData(new_hash_map, l_patient_id_2);
					
					new_hash_map.clear();
					
					try
					{
						l_app_msg = " ::: Fetching Patient_Id matched with Acct_Seq_no ::: ";
						String query4 = "select max(acct_seq_no) from bl_encounter_payer_priority where patient_id = ? ";
						if (l_debug_YN.equals("Y")) System.out.println(" ::: Acct_Seq_No Query  ::: "+query4);
						con = EMDataSource.getConnection();
							
						pstmt = con.prepareStatement(query4);
						pstmt.setString(1, l_patient_id_2);
						rset = pstmt.executeQuery();		
						
						while(rset.next()){		
							 l_acct_seq_no = rset.getString(1);	
							 
								
							if (l_debug_YN.equals("Y")) System.out.println(" ::: l_acct_seq_no ::: "+l_acct_seq_no);
						}
						
						if(l_acct_seq_no == null)
						{
							l_acct_seq_no_next =1;
						}
						else
						{
							l_acct_seq_no_next = Integer.parseInt(l_acct_seq_no)+1;
						}
					
						//if (l_debug_YN.equals("Y")) System.out.println("l_acct_seq_no_next.."+l_acct_seq_no_next);
					}
					catch(Exception e)
					{
						//if (l_debug_YN.equals("Y")) System.out.println("return l_status_desc"+l_status_desc);
						 
						l_errcd = "E";
						l_status_desc = "Exception in "+l_app_msg+ " - "+e.getMessage();
						//if (l_debug_YN.equals("Y")) System.out.println("return l_status_desc"+l_status_desc);
						return l_status_desc;
					}
					finally
					{
						EMDataSource.returnConnection(con);
						XHUtil.closeDBResources(rset, pstmt, null);
					}
					
					/*if (pstmt != null) pstmt.close();
					if (rset != null) rset.close();*/
					try
					{
					
						l_app_msg = " ::: Fetching Patient_Id ::: ";
						String query5 = "select patient_id from bl_patient_fin_dtls where patient_id = ? ";
						if (l_debug_YN.equals("Y")) System.out.println(" ::: Patient_id  ::: "+query5);
						con = EMDataSource.getConnection();
							
						pstmt = con.prepareStatement(query5);
						pstmt.setString(1, l_patient_id_2);
						rset = pstmt.executeQuery();		
						
						while(rset.next()){		
							 l_patient_id_4 = rset.getString("patient_id");	
							 
								
							//if (l_debug_YN.equals("Y")) System.out.println(" ::: l_patient_id_4 ::: "+l_patient_id_4);
						}
						
						if (l_debug_YN.equals("Y")) System.out.println(" ::: l_patient_id_4 ::: "+l_patient_id_4);
					}
					catch(Exception e)
					{
						//if (l_debug_YN.equals("Y")) System.out.println("return l_status_desc"+l_status_desc);
						 
						l_errcd = "E";
						l_status_desc = "Exception in "+l_app_msg+ " - "+e.getMessage();
						//if (l_debug_YN.equals("Y")) System.out.println("return l_status_desc"+l_status_desc);
						return l_status_desc;
					}
					finally
					{
						EMDataSource.returnConnection(con);
						XHUtil.closeDBResources(rset, pstmt, null);
					}
					
					/*if (pstmt != null) pstmt.close();
					if (rset != null) rset.close();*/
					
					BL_PATIENT_FIN_DTLS= new LinkedHashMap<String, String>();
					BL_ENCOUNTER_PAYER_PRIORITY= new LinkedHashMap<String, String>();
					BL_ENCOUNTER_PAYER_PRIORITY_ANOTHER= new LinkedHashMap<String, String>();
					
					if(!("".equals(l_billing_group_code.trim())))	
					{									    
						if(l_patient_id_4.equals(l_patient_id_2) && l_patient_id_4.length()>0)
						{
						    BL_PATIENT_FIN_DTLS.put("PATIENT_ID", l_patient_id_2);
							BL_PATIENT_FIN_DTLS.put("CUR_ACCT_SEQ_NO", String.valueOf(l_acct_seq_no_next));
							BL_PATIENT_FIN_DTLS.put("BLNG_GRP_ID", l_billing_group_code ); //added
							BL_PATIENT_FIN_DTLS.put("CUST_CODE", l_payer_code); //added
							BL_PATIENT_FIN_DTLS.put("BLNG_CLASS_CODE", l_biling_class_code);
							BL_PATIENT_FIN_DTLS.put("SETTLEMENT_IND", l_settlement_ind);
							BL_PATIENT_FIN_DTLS.put("SLMT_TYPE_CODE", l_settlement_type);
							BL_PATIENT_FIN_DTLS.put("POLICY_TYPE_CODE", l_policy_type_code); //added
							BL_PATIENT_FIN_DTLS.put("POLICY_NUMBER", l_policy_number); //added
							BL_PATIENT_FIN_DTLS.put("POLICY_START_DATE", "TO_DATE('"+l_policy_start_date+"','dd/MM/yyyy')"); //added
							BL_PATIENT_FIN_DTLS.put("POLICY_EXPIRY_DATE", "TO_DATE('"+l_policy_end_date+"','dd/MM/yyyy')"); //added
							BL_PATIENT_FIN_DTLS.put("CUST_GROUP_CODE", l_payer_group_code); //added
							BL_PATIENT_FIN_DTLS.put("NON_INS_BLNG_GRP_ID",l_non_ins_blng_grp_id); //added
							
							new_hash_map_1.put("BL_PATIENT_FIN_DTLS", BL_PATIENT_FIN_DTLS);
							UpdateData(new_hash_map_1, l_patient_id_2);
						}
						else
						{
							System.out.println("BL_FIN_PATIENT_DETAILS");
							BL_PATIENT_FIN_DTLS.put("PATIENT_ID", l_patient_id_2);
							BL_PATIENT_FIN_DTLS.put("CUR_ACCT_SEQ_NO", String.valueOf(l_acct_seq_no_next));
							BL_PATIENT_FIN_DTLS.put("BLNG_GRP_ID", l_billing_group_code ); //added
							BL_PATIENT_FIN_DTLS.put("CUST_CODE", l_payer_code); //added
							BL_PATIENT_FIN_DTLS.put("BLNG_CLASS_CODE", l_biling_class_code);
							BL_PATIENT_FIN_DTLS.put("SETTLEMENT_IND", l_settlement_ind);
							BL_PATIENT_FIN_DTLS.put("SLMT_TYPE_CODE", l_settlement_type);
							BL_PATIENT_FIN_DTLS.put("POLICY_TYPE_CODE", l_policy_type_code); //added
							BL_PATIENT_FIN_DTLS.put("POLICY_NUMBER", l_policy_number); //added
							BL_PATIENT_FIN_DTLS.put("POLICY_START_DATE", "TO_DATE('"+l_policy_start_date+"','dd/MM/yyyy')"); //added
							BL_PATIENT_FIN_DTLS.put("POLICY_EXPIRY_DATE", "TO_DATE('"+l_policy_end_date+"','dd/MM/yyyy')"); //added
							BL_PATIENT_FIN_DTLS.put("CUST_GROUP_CODE", l_payer_group_code); //added
							BL_PATIENT_FIN_DTLS.put("NON_INS_BLNG_GRP_ID",l_non_ins_blng_grp_id); //added
							BL_PATIENT_FIN_DTLS.put("ADDED_BY_ID", added_by_id);
							BL_PATIENT_FIN_DTLS.put("ADDED_DATE", "SYSDATE");
							BL_PATIENT_FIN_DTLS.put("ADDED_AT_WS_NO", added_at_ws_no);
							BL_PATIENT_FIN_DTLS.put("ADDED_FACILITY_ID", l_facility_id);
							BL_PATIENT_FIN_DTLS.put("MODIFIED_BY_ID", modified_by_id);
							BL_PATIENT_FIN_DTLS.put("MODIFIED_DATE","SYSDATE");
							BL_PATIENT_FIN_DTLS.put("MODIFIED_AT_WS_NO", modified_at_ws_no);
							BL_PATIENT_FIN_DTLS.put("MODIFIED_FACILITY_ID", l_facility_id);
							
							new_hash_map_1.put("BL_PATIENT_FIN_DTLS", BL_PATIENT_FIN_DTLS);
							InserData(new_hash_map_1);
						}
					
						BL_ENCOUNTER_PAYER_PRIORITY.put("PATIENT_ID", l_patient_id_2);
						BL_ENCOUNTER_PAYER_PRIORITY.put("OPERATING_FACILITY_ID", l_facility_id);
						BL_ENCOUNTER_PAYER_PRIORITY.put("EPISODE_TYPE", "R");
						BL_ENCOUNTER_PAYER_PRIORITY.put("ACCT_SEQ_NO",String.valueOf(l_acct_seq_no_next));
						BL_ENCOUNTER_PAYER_PRIORITY.put("ACCT_SEQ_EFF_FROM_DATE", "SYSDATE");
						BL_ENCOUNTER_PAYER_PRIORITY.put("ENC_REGN_DATE_TIME", "SYSDATE");
						BL_ENCOUNTER_PAYER_PRIORITY.put("BLNG_GRP_ID", l_billing_group_code); //added
						BL_ENCOUNTER_PAYER_PRIORITY.put("SETTLEMENT_IND", "X");
						BL_ENCOUNTER_PAYER_PRIORITY.put("CUST_CODE", l_payer_code); //added
						BL_ENCOUNTER_PAYER_PRIORITY.put("PRIORITY", "1");
						BL_ENCOUNTER_PAYER_PRIORITY.put("POLICY_TYPE_CODE", l_policy_type_code); //added
						BL_ENCOUNTER_PAYER_PRIORITY.put("POLICY_NUMBER", l_policy_number); //added	
						BL_ENCOUNTER_PAYER_PRIORITY.put("POLICY_START_DATE", "TO_DATE('"+l_policy_start_date+"','dd/MM/yyyy')"); //added
						BL_ENCOUNTER_PAYER_PRIORITY.put("POLICY_EXPIRY_DATE", "TO_DATE('"+l_policy_end_date+"','dd/MM/yyyy')"); //added
						BL_ENCOUNTER_PAYER_PRIORITY.put("CREDIT_AUTH_DATE", "SYSDATE"); //added
						BL_ENCOUNTER_PAYER_PRIORITY.put("EFFECTIVE_FROM", "TO_DATE('"+l_policy_start_date+"','dd/MM/yyyy')"); //added
						BL_ENCOUNTER_PAYER_PRIORITY.put("EFFECTIVE_TO", "TO_DATE('"+l_policy_end_date+"','dd/MM/yyyy')"); //added
						BL_ENCOUNTER_PAYER_PRIORITY.put("CUST_GROUP_CODE", l_payer_group_code); //added
						BL_ENCOUNTER_PAYER_PRIORITY.put("ADDED_BY_ID", added_by_id);
						BL_ENCOUNTER_PAYER_PRIORITY.put("ADDED_DATE", "SYSDATE");
						BL_ENCOUNTER_PAYER_PRIORITY.put("ADDED_AT_WS_NO", added_at_ws_no);
						BL_ENCOUNTER_PAYER_PRIORITY.put("ADDED_FACILITY_ID", l_facility_id);
						BL_ENCOUNTER_PAYER_PRIORITY.put("MODIFIED_BY_ID", modified_by_id);
						BL_ENCOUNTER_PAYER_PRIORITY.put("MODIFIED_DATE","SYSDATE");
						BL_ENCOUNTER_PAYER_PRIORITY.put("MODIFIED_AT_WS_NO", modified_at_ws_no);
						BL_ENCOUNTER_PAYER_PRIORITY.put("MODIFIED_FACILITY_ID", l_facility_id);
						BL_ENCOUNTER_PAYER_PRIORITY.put("MAND_ADDL_INFO_RECORDED_YN", "N");
						BL_ENCOUNTER_PAYER_PRIORITY.put("PRE_INV_YN", "N");
						BL_ENCOUNTER_PAYER_PRIORITY.put("PRE_INV_FIN_YN", "N");
						BL_ENCOUNTER_PAYER_PRIORITY.put("INT_RESPONSE_CODE", "0");
						BL_ENCOUNTER_PAYER_PRIORITY.put("INT_VALIDITY_TYPE", "0");
						
						new_hash_map_1.clear();
						new_hash_map_1.put("BL_ENCOUNTER_PAYER_PRIORITY", BL_ENCOUNTER_PAYER_PRIORITY);
						InserData(new_hash_map_1);
						
						new_hash_map_1.clear();
						
						BL_ENCOUNTER_PAYER_PRIORITY_ANOTHER.put("PATIENT_ID", l_patient_id_2);
						BL_ENCOUNTER_PAYER_PRIORITY_ANOTHER.put("OPERATING_FACILITY_ID",l_facility_id);
						BL_ENCOUNTER_PAYER_PRIORITY_ANOTHER.put("EPISODE_TYPE", "R");
						BL_ENCOUNTER_PAYER_PRIORITY_ANOTHER.put("ACCT_SEQ_NO", String.valueOf(l_acct_seq_no_next));
						BL_ENCOUNTER_PAYER_PRIORITY_ANOTHER.put("ACCT_SEQ_EFF_FROM_DATE", "SYSDATE");
						BL_ENCOUNTER_PAYER_PRIORITY_ANOTHER.put("ENC_REGN_DATE_TIME", "SYSDATE");
						BL_ENCOUNTER_PAYER_PRIORITY_ANOTHER.put("BLNG_GRP_ID",l_non_ins_blng_grp_id ); //added
						BL_ENCOUNTER_PAYER_PRIORITY_ANOTHER.put("SETTLEMENT_IND", "C");
						BL_ENCOUNTER_PAYER_PRIORITY_ANOTHER.put("ADDED_BY_ID", added_by_id);
						BL_ENCOUNTER_PAYER_PRIORITY_ANOTHER.put("ADDED_DATE", "SYSDATE");
						BL_ENCOUNTER_PAYER_PRIORITY_ANOTHER.put("ADDED_AT_WS_NO", added_at_ws_no);
						BL_ENCOUNTER_PAYER_PRIORITY_ANOTHER.put("ADDED_FACILITY_ID", l_facility_id);
						BL_ENCOUNTER_PAYER_PRIORITY_ANOTHER.put("MODIFIED_BY_ID", modified_by_id);
						BL_ENCOUNTER_PAYER_PRIORITY_ANOTHER.put("MODIFIED_DATE","SYSDATE");
						BL_ENCOUNTER_PAYER_PRIORITY_ANOTHER.put("MODIFIED_AT_WS_NO", modified_at_ws_no);
						BL_ENCOUNTER_PAYER_PRIORITY_ANOTHER.put("MODIFIED_FACILITY_ID", l_facility_id);
						BL_ENCOUNTER_PAYER_PRIORITY_ANOTHER.put("MAND_ADDL_INFO_RECORDED_YN", "N");
						BL_ENCOUNTER_PAYER_PRIORITY_ANOTHER.put("PRE_INV_YN", "N");
						BL_ENCOUNTER_PAYER_PRIORITY_ANOTHER.put("PRE_INV_FIN_YN", "N");
						BL_ENCOUNTER_PAYER_PRIORITY_ANOTHER.put("INT_RESPONSE_CODE", "0");
						BL_ENCOUNTER_PAYER_PRIORITY_ANOTHER.put("INT_VALIDITY_TYPE", "0");														
						
						new_hash_map_1.put("BL_ENCOUNTER_PAYER_PRIORITY", BL_ENCOUNTER_PAYER_PRIORITY_ANOTHER);
						InserData(new_hash_map_1);
						new_hash_map_1.clear();
							
					}
					
						
				}catch (Exception e1) {
					 
					l_errcd = "E";
					l_status_desc = "Exception in "+l_app_msg+ " - "+e1.getMessage();
					
					return l_status_desc;
						
					
				}/*finally {
					EMDataSource.returnConnection(con);
					XHUtil.closeDBResources(rset, pstmt, null);
				}*/
			   l_patient_id = l_patient_id_2;
			   return "Patient Data Updated Successfully"+ l_patient_id;
			}
			//l_patient_id = l_patient_id_2;	
		 //System.out.println("l_patient_id data return"+l_patient_id);
	     return l_patient_id;
		
	}


	private static void UpdateData(
			LinkedHashMap<String, HashMap<String, String>> new_hash_map_1 , String Patient_id) {
		Connection con	= null;
		PreparedStatement pstmt	= null;
		ResultSet rs =null;
		Set<String> tableKeys = new_hash_map_1.keySet();
		String UpdateStr = "";
		int count = 0;
		//System.out.println("tableKeys: "+tableKeys);
		try
		{	
			l_app_msg = " ::: Inside Update Data ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			con = EMDataSource.getConnection();
			for(String tableKey: tableKeys){
				
				LinkedHashMap<String, String> tHashMap = (LinkedHashMap)new_hash_map_1.get(tableKey);
				
				Set<String> columnKeys = tHashMap.keySet();
				for(String columnKey: columnKeys){
					keyStr = keyStr + columnKey +"=";  
					
					if (tHashMap.get(columnKey).contains("DATE"))
						keyStr = keyStr +""+tHashMap.get(columnKey) +""+",";
					else
						keyStr = keyStr + "\'"+tHashMap.get(columnKey) + "\'"+",";
					
				}	
				
				//System.out.println("keyStr..."+keyStr+"KeyString length.."+keyStr.length());
				keyStr = keyStr.substring(0,keyStr.length() -1 );
				//if (l_debug_YN.equals("Y")) System.out.println("keyStr: "+keyStr);
				//valueStr = valueStr.substring(0,valueStr.length() -1 );
				
				l_app_msg = " ::: Updating the Values ::: ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				
				UpdateStr =  " update "+tableKey+ " SET "+keyStr+" where patient_id = ? ";
				if (l_debug_YN.equals("Y")) System.out.println(" ::: Update Query ::: "+UpdateStr.toString());		
				
				//if(pstmt!=null) pstmt.close();
				pstmt = con.prepareStatement(UpdateStr.toString());
				pstmt.setString(1 , Patient_id);
				count = pstmt.executeUpdate();
				
				if (l_debug_YN.equals("Y")) System.out.println(" ::: Count ::: "+count);
				
				if (count > 0)
				{
					con.commit();
					if (l_debug_YN.equals("Y"))  System.out.println(" ::: Updated Success ::: ");
				}else{
					con.rollback();
				}
				keyStr = ""; valueStr = "";	
			}
			if(pstmt != null) pstmt.close();
		}
		catch (Exception e)
		{
			 l_status = "0";
			 l_status_desc = "Exception in "+l_app_msg+ " - "+e.getMessage();
			 keyStr = ""; valueStr = "";
			 e.printStackTrace();
		}
		 finally {
				EMDataSource.returnConnection(con);
				XHUtil.closeDBResources(rs, pstmt, null);
			}
		
		
	}


	public static void InserData(HashMap<String, HashMap<String, String>> new_hash_map) 
	{		
		Connection con	= null;
		PreparedStatement pstmt	= null;
		ResultSet rs =null;
		Set<String> tableKeys = new_hash_map.keySet();
		String insertStr = "";
		int count = 0;

		try
		{	
			l_app_msg = " ::: Inside Insert Data ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			con = EMDataSource.getConnection();
			for(String tableKey: tableKeys){
			
				LinkedHashMap<String, String> tHashMap = (LinkedHashMap)new_hash_map.get(tableKey);
				
				Set<String> columnKeys = tHashMap.keySet();
				for(String columnKey: columnKeys){
					keyStr = keyStr + columnKey + ",";    
					
					//System.out.println("Bhuvi111: "+tHashMap.get(columnKey));
					if (tHashMap.get(columnKey).contains("DATE"))
						valueStr = valueStr +""+tHashMap.get(columnKey) +""+",";
					else
						valueStr = valueStr + "\'"+tHashMap.get(columnKey) + "\'"+",";
					
				}	

				keyStr = keyStr.substring(0,keyStr.length() -1 );
				valueStr = valueStr.substring(0,valueStr.length() -1 );
				
				l_app_msg = " ::: Inserting the Values ::: ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				
				insertStr =  " Insert into "+tableKey+ " ("+keyStr+") VALUES ("+valueStr+") ";
				if (l_debug_YN.equals("Y")) System.out.println(" ::: Insert Query ::: "+insertStr.toString());		
				
				//if(pstmt!=null) pstmt.close();
				pstmt = con.prepareStatement(insertStr.toString());
				count = pstmt.executeUpdate();
				
				if (l_debug_YN.equals("Y")) System.out.println(" ::: Count ::: "+count);
				
				if (count == 1)
				{
					con.commit();
					if (l_debug_YN.equals("Y"))  System.out.println(" ::: Inserted Success ::: ");
				}else{
					con.rollback();
					if (l_debug_YN.equals("Y"))  System.out.println(" ::: RollBack Success ::: ");
				}
				keyStr = ""; valueStr = "";	
			}
			if(pstmt != null) pstmt.close();
		}
		catch (Exception e)
		{
			 l_status = "0";
			 l_status_desc = "Exception in "+l_app_msg+ " - "+e.getMessage();	
			 keyStr = ""; valueStr = "";
			 e.printStackTrace();
			 //if (l_debug_YN.equals("Y"))  System.out.println(" ::: Status Desc InserData ::: "+l_status_desc);
			 
		}
		 finally {
				EMDataSource.returnConnection(con);
				XHUtil.closeDBResources(rs, pstmt, null);
			}
		
	
	}

	public static String generatePatientID()
	{
		l_app_msg = " ::: Inside GeneratePatientID ::: ";
		if (l_debug_YN.equals("Y"))  System.out.println(l_app_msg);
		String gen_patient_id = "";
		String p_err_msg	= "";
		CallableStatement cs = null;
		 
		Connection con					= null;
		PreparedStatement pstmt			= null;
		ResultSet rset					= null;
		  
		 try
		  {

			 if(l_pat_no_gen_yn.equals("Y"))
	            {
			 		if (l_debug_YN.equals("Y"))  System.out.println(" ::: l_pat_no_gen_yn ::: "+l_pat_no_gen_yn);
					
					con = EMDataSource.getConnection();
					
					 cs = con.prepareCall("{call generate_patient_id(?,?,?,?,?,?,?) }");
					
					 cs.setString( 1 ,l_pat_ser_grp);
					 cs.setString( 2 ,l_facility_id );
					 cs.setString( 3 ,"1" );
					 cs.setString( 4 ,"0" );
					 cs.setString( 5 ,new_hash_map.get("MP_PATIENT").get("SEX"));
					 cs.registerOutParameter(6,Types.VARCHAR);
					 cs.registerOutParameter(7,Types.VARCHAR);
	                 @SuppressWarnings("unused")
	                 String Site_or_Facility = "S";
				     cs.execute();
					 gen_patient_id = cs.getString(6);
					 if (l_debug_YN.equals("Y")) System.out.println(" ::: Generated Patient Id ::: "+gen_patient_id);
					 p_err_msg		= cs.getString(7);
					 System.out.println("::: p_err_msg :::"+p_err_msg);
	            }
			 if (gen_patient_id==null)
			 {
				 gen_patient_id = "";
			 }
			 if (p_err_msg==null)
			 {
				 p_err_msg = "";
			 }
			 
			 if(cs != null)  cs.close();
			 
			 if  (!p_err_msg.equals(""))
				{
					transaction_completed = false;
					if (l_debug_YN.equals("Y")) System.out.println(" ::: Error Message ::: "+p_err_msg);
				}
			  else
				{
					transaction_completed = true;
					if (l_debug_YN.equals("Y")) System.out.println(" ::: Error Message ::: "+p_err_msg);
				}
			 if(rset != null) rset.close();
		  }
		
			 catch(Exception e)
				{
					 transaction_completed = false;
					 l_status = "0";
					 l_status_desc = "Exception in "+l_app_msg+ " - "+e.getMessage();
					 
					if (l_debug_YN.equals("Y")) System.out.println(" ::: Status Desc generatePatientID ::: "+l_status_desc);
					e.printStackTrace();
				}finally {
					EMDataSource.returnConnection(con);
					XHUtil.closeDBResources(rset, pstmt, null);
				}
		
		 return gen_patient_id;
		 
	}
	
	public static String FetchStdCntrlSegMethod(String segmentID, String elementId,String standardCode) {
		
		Connection dbConn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		String query = "";
		String l_app_msg = "", l_field_value = "";

		l_app_msg = " ::: Inside FetchStdCntrlSegMethod ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

		l_app_msg = " ::: Segment ID ::: " + segmentID + " ::: Element ID ::: "	+ elementId + " ::: Standard Code ::: " + standardCode;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

		l_app_msg = " ::: Retrieving ::: " + elementId + " ::: Value ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

		try {
			dbConn = EMDataSource.getConnection();
			if (l_debug_YN.equals("Y")) System.out.println(dbConn.toString());
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
			if (l_debug_YN.equals("Y")) System.out.println(" ::: Fetch control l_field_value ::: "+l_field_value);

		} catch (Exception e) {
			l_field_value = "Error in " + l_app_msg + " : " + e.getMessage();
			if (l_debug_YN.equals("Y")) System.out.println(" ::: Field Value ::: "+l_field_value);
			e.printStackTrace();
		} finally {
			EMDataSource.returnConnection(dbConn);
			XHUtil.closeDBResources(rs, pstmt, null);
		}
		return l_field_value;
	}
	
	public static String PatientName(String name_prefix, String first_name,String second_name, String family_name) {
		l_app_msg = " ::: Inside Patient Name ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		l_app_msg = " ::: Name Prefix ::: "+ name_prefix + " ::: First Name ::: "+ first_name + " ::: Second Name ::: "+ second_name + " ::: Family Name ::: "+ family_name;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		String logic = "PR+< >+1N+< >+2N+< >+FN";
		String derivedName = "";
		derivedName = "";
		int j = 0;
		String[] arr = new String[10];
		arr = logic.split("\\+");
		for (int i = 0; i < arr.length; i++) {
			if (l_debug_YN.equals("Y")) System.out.println(" ::: Array ::: " + arr[i]);

		}

		for (j = 0; j < arr.length; j++) {

			if (arr[j].equals("1N") && name_prefix != null) {
				if (first_name != " ") {
					derivedName = derivedName + first_name;
					if (l_debug_YN.equals("Y")) System.out.println(" ::: first_name derivedName :::" + derivedName);
				}

			} else if (arr[j].equals("2N") && second_name != null) {
				if (second_name != " ")
					derivedName = derivedName + second_name;
				if (l_debug_YN.equals("Y")) System.out.println(" ::: second_name derivedName ::: " + derivedName);
			} else if (arr[j].equals("FN") && family_name != null) {
				if (family_name != " ") {
					derivedName = derivedName + family_name;
					if (l_debug_YN.equals("Y")) System.out.println(" ::: family_name derivedName ::: " + derivedName);
				}
			}

			else if (arr[j].equals("PR") && name_prefix != null) {
				if (name_prefix != "") {
					derivedName = derivedName + name_prefix;
					if (l_debug_YN.equals("Y")) System.out.println(" ::: name_prefix derivedName ::: " + derivedName);

				}
			}

			else {
				if (arr[j] != "1N" && arr[j] != "2N" && arr[j] != "3N"
						&& arr[j] != "FN" && arr[j] != "PR") {
					int arLen = arr[j].length();

					if (l_debug_YN.equals("Y")) System.out.println("arLen.." + arLen);

					String tempVal = arr[j].substring(1, arLen - 1);

					if (derivedName == "")
						tempVal = "";

					derivedName = derivedName + tempVal;

				}

			}
		}
		return derivedName;
	}

}
	