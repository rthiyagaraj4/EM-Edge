package eXH.practo;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import eXH.util.EMDataSource;
import eXH.util.XHJSONUtil;
import eXH.util.XHUtil;


public class PractoPatient {
	
	static LinkedHashMap<String, HashMap<String, String>> new_hash_map = new LinkedHashMap<String, HashMap<String,String>>();
	//static List<Map<String,String>> searPatientDets = new ArrayList<Map<String,String>>(); 
	static StringBuffer query3 = new StringBuffer();
	static Map<String, Object> l_response_json = new HashMap<String, Object>();
	
	public static String l_debug_YN = "N";
	public static final String l_standard_code = "HTTPCC";
	public static final String l_segment_id = "PWS";
	public static String l_pat_no_gen_yn="";
	
	static String site_id="";
	static String l_pat_no_ctrl="";
	static String l_site_id ="";
	static String alt_id1_no="";
	static String l_pat_ser_grp = "";
	static boolean transaction_completed	= false;
	static String Patient_id = null;
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
	static String l_blng_grp_id ="";
	static String l_biling_group_id ="";
	static String l_biling_class_code="";
	static String l_settlement_ind="";
	static String l_settlement_type="";
	static String l_cur_acct_seq_no="1";
	static String l_app_msg="";
	static String l_country_name ="";
	static String l_status = "", l_status_desc = "", l_responseJsonString = "";

	public static String PatientDetails(String actionKey)
			throws JsonGenerationException, JsonMappingException, IOException {

		String l_in_JSON = "", l_request_ref_no = "", l_request_type = "", l_request_date_time = "";

		String l_first_name = "", l_second_name = "", l_surname = "", l_gender = "", l_date_of_birth = "", l_mobile_no = "", l_email_id = "";
		
		String l_nationality = "", l_address_line_1 = "", l_address_line_2 = "", l_address_line_3 = "", l_address_line_4 = "";
		
		String l_city = "", l_district = "",l_state= "",l_postal_code= "",l_country= "", l_postal_code_str = "";
		
		String l_city_code= "", l_district_code = "", l_state_code = "", l_nationality_code = "", l_country_code = "";
		
		String l_race_id = "", l_element_id = "";
		
		String query ="", l_debug_yn = "";
		
		int l_postal_count = 0, l_address_count = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			con = EMDataSource.getConnection();

			query = "select NVL(DEBUG_YN, 'N') DEBUG_YN FROM XH_PARAM " ;

			pstmt = con.prepareStatement(query);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				l_debug_yn = rset.getString("DEBUG_YN");
			}

			l_debug_YN = l_debug_yn;

		} catch (Exception e) {
		} finally {
			XHUtil.closeDBResources(rset, pstmt, null);
			EMDataSource.returnConnection(con);
		}
		
		try {
			
			l_status_desc = "";
		
			l_in_JSON = XHJSONUtil.createJsonObject(actionKey);
			
			l_app_msg = " ::: Reading in Request Number ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_request_ref_no = XHJSONUtil.getJsonRequestString(l_in_JSON,
					"request_ref_no");
			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: Request Ref No ::: "
						+ l_request_ref_no);

			l_app_msg = " ::: Reading in Request Type ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_request_type = XHJSONUtil.getJsonRequestString(l_in_JSON,
					"request_type");
			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: Request Type ::: " + l_request_type);

			l_app_msg = " ::: Reading in Request Date Time ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_request_date_time = XHJSONUtil.getJsonRequestString(l_in_JSON,
					"request_date_time");
			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: Request Date Time ::: "
						+ l_request_date_time);

			l_app_msg = " ::: Reading in Patient Data - Facility ID ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_facility_id = XHJSONUtil.getJsonArrayObjString(l_in_JSON,
					"patient_data", "facility_id");
			l_facility_id = l_facility_id.trim();
			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: Facility Id ::: " + l_facility_id);

			l_app_msg = " ::: Reading in Patient Data - Patient Prefix ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_patient_prefix = XHJSONUtil.getJsonArrayObjString(l_in_JSON,
					"patient_data", "patient_prefix");
			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: Patient Prefix ::: "
						+ l_patient_prefix);

			l_app_msg = " ::: Reading in Patient Data - First Name ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_first_name = XHJSONUtil.getJsonArrayObjString(l_in_JSON,
					"patient_data", "first_name");
			l_first_name = l_first_name.trim();
			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: First Name ::: " + l_first_name);

			l_app_msg = " ::: Reading in Patient Data - Second Name ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_second_name = XHJSONUtil.getJsonArrayObjString(l_in_JSON,
					"patient_data", "second_name");
			l_second_name = l_second_name.trim();
			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: Second Name ::: " + l_second_name);

			l_app_msg = " ::: Reading in Patient Data - Surname ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_surname = XHJSONUtil.getJsonArrayObjString(l_in_JSON,
					"patient_data", "surname");
			l_surname = l_surname.trim();
			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: Surname ::: " + l_surname);

			l_app_msg = " ::: Reading in Patient Data - Gender ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_gender = XHJSONUtil.getJsonArrayObjString(l_in_JSON,
					"patient_data", "gender");
			l_gender = l_gender.trim();
			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: Gender ::: " + l_gender);

			l_app_msg = " ::: Reading in Patient Data - Date Of Birth ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_date_of_birth = XHJSONUtil.getJsonArrayObjString(l_in_JSON,
					"patient_data", "date_of_birth");
			l_date_of_birth = l_date_of_birth.trim();
			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: Date of Birth ::: " + l_date_of_birth);

			l_app_msg = " ::: Reading in Patient Data - Mobile No ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_mobile_no = XHJSONUtil.getJsonArrayObjString(l_in_JSON,
					"patient_data", "mobile_no");
			l_mobile_no = l_mobile_no.trim();
			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: Mobile No ::: " + l_mobile_no);

			l_app_msg = " ::: Reading in Patient Data - EmailId ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_email_id = XHJSONUtil.getJsonArrayObjString(l_in_JSON,
					"patient_data", "email_id");
			l_email_id = l_email_id.trim();
			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: Email ID ::: " + l_email_id);

			l_app_msg = " ::: Reading in Patient Data - Nationality ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_nationality_code = XHJSONUtil.getJsonArrayObjString(l_in_JSON,
					"patient_data", "nationality_code");
			l_nationality_code = l_nationality_code.trim();			
			if (l_nationality_code.indexOf("Error") >= 0 || l_nationality_code.trim().equals("")) {
				l_nationality_code = "";
			}
			
			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: Nationality Code ::: " + l_nationality_code);

			l_nationality = XHJSONUtil.getJsonArrayObjString(l_in_JSON,
					"patient_data", "nationality");
			l_nationality = l_nationality.trim();
			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: Nationality ::: " + l_nationality);

			l_app_msg = " ::: Reading in Patient Data - AddressLine1 ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_address_line_1 = XHJSONUtil.getJsonArrayObjString(l_in_JSON,
					"patient_data", "address_line_1");
			l_address_line_1 = l_address_line_1.trim();
			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: Address Line 1 ::: "
						+ l_address_line_1);

			l_app_msg = " ::: Reading in Patient Data - AddressLine2 ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_address_line_2 = XHJSONUtil.getJsonArrayObjString(l_in_JSON,
					"patient_data", "address_line_2");
			l_address_line_2 = l_address_line_2.trim();
			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: Address Line 2 ::: "
						+ l_address_line_2);

			l_app_msg = " ::: Reading in Patient Data - AddressLine3 ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_address_line_3 = XHJSONUtil.getJsonArrayObjString(l_in_JSON,
					"patient_data", "address_line_3");
			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: Address Line 3 ::: "
						+ l_address_line_3);
			
			l_app_msg = " ::: Reading in Patient Data - AddressLine4 ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_address_line_4 = XHJSONUtil.getJsonArrayObjString(l_in_JSON,
					"patient_data", "address_line_4");
			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: Address Line 4 ::: "
						+ l_address_line_3);

			l_app_msg = " ::: Reading in Patient Data - City ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_city_code = XHJSONUtil.getJsonArrayObjString(l_in_JSON,
					"patient_data", "city_code");
			if (l_city_code.indexOf("Error") >= 0 || l_city_code.trim().equals("")) {
				l_city_code = "";
			}
			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: City Code :::  " + l_city_code);

			l_city = XHJSONUtil.getJsonArrayObjString(l_in_JSON,
					"patient_data", "city");
			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: City :::  " + l_city);			
			
			l_app_msg = " ::: Reading in Patient Data - District ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_district_code = XHJSONUtil.getJsonArrayObjString(l_in_JSON,
					"patient_data", "district_code");
			if (l_district_code.indexOf("Error") >= 0 || l_district_code.trim().equals("")) {
				l_district_code = "";
			}
			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: DIstrict Code :::  " + l_district_code);

			l_district = XHJSONUtil.getJsonArrayObjString(l_in_JSON,
					"patient_data", "district");
			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: District :::  " + l_district);

			l_app_msg = " ::: Reading in Patient Data - State ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_state_code = XHJSONUtil.getJsonArrayObjString(l_in_JSON,
					"patient_data", "state_code");
			if (l_state_code.indexOf("Error") >= 0 || l_state_code.trim().equals("")) {
				l_state_code = "";
			}
			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: State Code :::  " + l_state_code);

			l_state = XHJSONUtil.getJsonArrayObjString(l_in_JSON,
					"patient_data", "state");
			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: State :::  " + l_state);

			l_app_msg = " ::: Reading in Patient Data - Postal Code ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_postal_code = XHJSONUtil.getJsonArrayObjString(l_in_JSON,
					"patient_data", "postal_code");
			l_postal_code = l_postal_code.trim();
			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: Postal Code ::: " + l_postal_code);

			l_app_msg = " ::: Reading in Patient Data - Country ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			l_country_code = XHJSONUtil.getJsonArrayObjString(l_in_JSON,
					"patient_data", "country_code");
			if (l_country_code.indexOf("Error") >= 0 || l_country_code.trim().equals("")) {
				l_country_code = "";
			}
			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: Country Code :::  " + l_country_code);

			l_country = XHJSONUtil.getJsonArrayObjString(l_in_JSON,
					"patient_data", "country");
			l_country = l_country.trim();
			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: Country ::: " + l_country);

		} catch (Exception e) {

			l_status_desc = "Exception in " + l_app_msg + " - "
					+ e.getMessage();

			return l_status_desc;

		}
		
		try {
			
			l_status_desc = "";
			l_app_msg = " ::: Reading in Patient Series Group ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_element_id = "PAT_SER_GRP_CODE";

			l_pat_ser_grp = FetchStdCntrlSegMethod(l_segment_id, l_element_id,
					l_standard_code);
			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: Patient Serice group ::: "
						+ l_pat_ser_grp);

			String query1 = "select gen_pat_id_yn ,pat_no_ctrl from MP_PAT_SER_GRP where PAT_SER_GRP_CODE = ? ";
			// String query2 = "select site_id from sm_site_param ";
			con = EMDataSource.getConnection();

			l_app_msg = " ::: Reading in Patient Series Group for ::: "
					+ l_pat_ser_grp;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			pstmt = con.prepareStatement(query1);
			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: Query 1 ::: " + query1);
			pstmt.setString(1, l_pat_ser_grp);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				l_pat_no_gen_yn = rset.getString("gen_pat_id_yn");
				l_pat_no_ctrl = rset.getString("pat_no_ctrl");
				if (l_debug_YN.equals("Y"))
					System.out.println("l_pat_no_gen_yn" + l_pat_no_gen_yn);
				if (l_debug_YN.equals("Y"))
					System.out.println("l_pat_no_ctrl" + l_pat_no_ctrl);
			}
		} catch (Exception e) {

			l_status_desc = "Exception in " + l_app_msg + " - "
					+ e.getMessage();

			return l_status_desc;

		} finally {
			EMDataSource.returnConnection(con);
			XHUtil.closeDBResources(rset, pstmt, null);
		}

		try {
			
			l_status_desc = "";

			l_app_msg = " ::: Reading in Site Param ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			String query2 = "select site_id from sm_site_param ";
			con = EMDataSource.getConnection();

			pstmt = con.prepareStatement(query2);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				l_site_id = rset.getString("site_id");
			}
			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: Site Id ::: " + l_site_id);

		} catch (Exception e) {

			l_status_desc = "Exception in " + l_app_msg + " - "
					+ e.getMessage();

			return l_status_desc;
		} finally {
			EMDataSource.returnConnection(con);
			XHUtil.closeDBResources(rset, pstmt, null);
		}

		l_app_msg = " ::: Assigning Patient Details - Nationality-Code ::: ";
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);

		try {
			l_status_desc = "";
			l_app_msg = "Reading in Nationality-Code";
			
			String query3 = "Select COUNTRY_CODE from mp_country ";
			
			if (l_nationality_code.length()>0)
				query3 = query3 + "where COUNTRY_CODE = ?";
			else if (l_nationality.length()>0)
				query3 = query3 + "where trim(lower(LONG_DESC)) = lower(?)";			
					
			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: Query 3 ::: " + query3);
			con = EMDataSource.getConnection();

			pstmt = con.prepareStatement(query3);			
			
			if (l_nationality_code.length()>0)
				pstmt.setString(1, l_nationality_code);
			else if (l_nationality.length()>0)
				pstmt.setString(1, l_nationality);
			
			rset = pstmt.executeQuery();

			while (rset.next()) {
				l_nationality_code = rset.getString("COUNTRY_CODE");
				if (l_debug_YN.equals("Y"))
					System.out.println(" ::: Nationality Code ::: "
							+ l_nationality_code);
			}
			
			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: Nationality Code ::: "
						+ l_nationality_code);

		} catch (Exception e1) {

			l_status_desc = "Exception in " + l_app_msg + " - "
					+ e1.getMessage();

			return l_status_desc;

		} finally {
			EMDataSource.returnConnection(con);
			XHUtil.closeDBResources(rset, pstmt, null);
		}

		l_app_msg = " ::: Assigning Patient Details - Country_Name ::: ";
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);

		try {
			l_status_desc = "";  
			l_app_msg = " ::: Reading in country_Name ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			String query4 = "Select COUNTRY_CODE from mp_country ";
			
			if (l_country_code.length()>0)
				query4 = query4 + "where COUNTRY_CODE = ?";			
			else if (l_country.length()>0)
				query4 = query4 + "where trim(lower(LONG_NAME)) = lower(?)";			
			
			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: Query 4 ::: " + query4);
			
			con = EMDataSource.getConnection();
			pstmt = con.prepareStatement(query4);
			
			if (l_country_code.length()>0)
				pstmt.setString(1, l_country_code);
			else if (l_country.length()>0)
				pstmt.setString(1, l_country);			
			
			rset = pstmt.executeQuery();

			while (rset.next()) {
				l_country_name = rset.getString("COUNTRY_CODE");
				if (l_debug_YN.equals("Y"))
					System.out.println(" ::: Country Name ::: "
							+ l_country_name);

			}
		} catch (Exception e) {

			l_status_desc = "Exception in " + l_app_msg + " - "
					+ e.getMessage();

			return l_status_desc;

		} finally {
			EMDataSource.returnConnection(con);
			XHUtil.closeDBResources(rset, pstmt, null);
		}

		l_app_msg = " ::: Assigning Language_id and Race_id ::: ";
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);

		try {
			l_status_desc = "";
			l_element_id = "LANG_ID";
			l_language_id = FetchStdCntrlSegMethod(l_segment_id, l_element_id,
					l_standard_code);
			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: Language Id ::: " + l_language_id);

			l_element_id = "RACE_ID";
			l_race_id = FetchStdCntrlSegMethod(l_segment_id, l_element_id,
					l_standard_code);
			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: Race Id  ::: " + l_race_id);

			l_app_msg = " ::: Reading in Billing Group Id,Settlement Type,Biling Class code,Settlement Ind ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			if (l_nationality_code.equalsIgnoreCase("515"))
				l_element_id = "BLNG_GRP_ID";
			else
				l_element_id = "BLNG_GRP_ID_FOR";
			
			l_biling_group_id = FetchStdCntrlSegMethod(l_segment_id,
					l_element_id, l_standard_code);
			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: Billing Group Id ::: "
						+ l_biling_group_id);

			l_element_id = "BLNG_CLASS_CODE";
			l_biling_class_code = FetchStdCntrlSegMethod(l_segment_id,
					l_element_id, l_standard_code);
			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: Billing class Code ::: "
						+ l_biling_class_code);

			l_element_id = "SETTLEMENT_IND";
			l_settlement_ind = FetchStdCntrlSegMethod(l_segment_id,
					l_element_id, l_standard_code);
			if (l_debug_YN.equals("Y"))
				System.out
						.println(" ::: settlement Id ::: " + l_settlement_ind);

			l_element_id = "SLMT_TYPE_CODE";
			l_settlement_type = FetchStdCntrlSegMethod(l_segment_id,
					l_element_id, l_standard_code);
			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: Settlement Type ::: "
						+ l_settlement_type);

		} catch (Exception e) {

			l_status_desc = "Exception in " + l_app_msg + " - "
					+ e.getMessage();

			return l_status_desc;

		}

		try {
			String Patient_name = "";

			Patient_name = PatientName(l_patient_prefix, l_first_name,
					l_second_name, l_surname);

			l_app_msg = " ::: Patient Name ::: " + Patient_name;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			LinkedHashMap<String, String> MP_PATIENT = new LinkedHashMap<String, String>();

			l_app_msg = " ::: Assigning Patient Details - Demographic Information ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			MP_PATIENT.put("NAME_PREFIX", l_patient_prefix);
			MP_PATIENT.put("PATIENT_NAME", Patient_name);
			MP_PATIENT.put("FIRST_NAME", l_first_name);
			MP_PATIENT.put("SECOND_NAME", l_second_name);
			MP_PATIENT.put("FAMILY_NAME", l_surname);
			MP_PATIENT.put("SEX", l_gender);
			MP_PATIENT.put("DATE_OF_BIRTH", "TO_DATE('"+l_date_of_birth+"','DD/MM/YYYY')");
			MP_PATIENT.put("CONTACT2_NO", l_mobile_no);
			MP_PATIENT.put("EMAIL_ID", l_email_id);
			MP_PATIENT.put("NATIONALITY_CODE", l_nationality_code); // l_nationality
			MP_PATIENT.put("ADDED_BY_ID", added_by_id);
			MP_PATIENT.put("ADDED_DATE", "SYSDATE");
			MP_PATIENT.put("ADDED_AT_WS_NO", added_at_ws_no);
			MP_PATIENT.put("ADDED_FACILITY_ID", l_facility_id);
			MP_PATIENT.put("MODIFIED_BY_ID", modified_by_id);
			MP_PATIENT.put("MODIFIED_DATE", "SYSDATE");
			MP_PATIENT.put("MODIFIED_AT_WS_NO", modified_at_ws_no);
			MP_PATIENT.put("MODIFIED_FACILITY_ID", l_facility_id);
			MP_PATIENT.put("PAT_SER_GRP_CODE", l_pat_ser_grp);
			MP_PATIENT.put("REGN_FACILITY_ID", l_facility_id);
			MP_PATIENT.put("LANGUAGE_ID", l_language_id);
			MP_PATIENT.put("RACE_CODE", l_race_id);
			MP_PATIENT.put("CITIZEN_YN", "Y");
			MP_PATIENT.put("PREF_FACILITY_ID", l_facility_id);
			MP_PATIENT.put("REGN_DATE", "trunc(SYSDATE)"); // Registration_Date
			MP_PATIENT.put("GENERAL_ALERT", "Y");

			l_app_msg = " ::: Assigning Patient Details - Address Information ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			l_postal_count = 0;
			l_address_count = 0;

			try {
				l_status_desc = ""; 
				l_app_msg = " ::: Reading Postal Code Details ::: ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				query3 = new StringBuffer();

				query3.append("SELECT POSTAL_CODE ");
				query3.append(" FROM MP_POSTAL_CODE ");
				query3.append(" WHERE LONG_DESC = ? ");

				con = EMDataSource.getConnection();

				pstmt = con.prepareStatement(query3.toString());
				pstmt.setString(1, l_postal_code);

				rset = pstmt.executeQuery();

				while (rset.next()) {
					l_postal_count++;
					l_postal_code_str = rset.getString("POSTAL_CODE");
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: Postal Code str ::: "
								+ l_postal_code_str);
				}

				if (l_postal_count == 0) {
					l_status = "0";
					l_status_desc = "Exception in " + l_app_msg
							+ " - Postal Code - " + l_postal_code
							+ " does not match ";
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: Status Desc ::: "
								+ l_status_desc);
				}

			}

			catch (Exception e) {

				l_status_desc = "Exception in " + l_app_msg + " - "
						+ e.getMessage();

				return l_status_desc;

			} finally {
				EMDataSource.returnConnection(con);
				XHUtil.closeDBResources(rset, pstmt, null);
			}

			l_app_msg = " ::: Reading in Address Details ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			try {
				l_status_desc = "";

				query3 = new StringBuffer();
					 	
				query3.append("SELECT POSTAL_CODE, TOWN_CODE, TOWN, DISTRICT_CODE, DISTRICT, STATE_CODE, STATE ");
				query3.append(" FROM XH_POSTAL_ADD_VW ");
				query3.append(" WHERE postal_desc = ? ");
				
				if (l_city_code.length()>0)
					query3.append(" AND TOWN_CODE = ? ");
				else if (l_city.length()>0)
					query3.append(" AND lower(TOWN) = ? ");
					 	
				if (l_district_code.length()>0)
					query3.append(" AND DISTRICT_CODE = ? ");
				else if (l_district.length()>0)
					query3.append(" AND lower(DISTRICT) =? ");

				if (l_state_code.length()>0)
					query3.append(" AND STATE_CODE = ? ");
				else if (l_state.length() > 0)
					query3.append(" AND lower(STATE) = ? ");

				l_app_msg = " ::: Query ::: " + query3.toString();
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				con = EMDataSource.getConnection();
				pstmt = con.prepareStatement(query3.toString());
				pstmt.setString(1, l_postal_code.toString());
				
				if (l_city_code.length()>0)
					pstmt.setString(2, l_city_code);
				else if (l_city.length() > 0) {
					pstmt.setString(2, l_city.toLowerCase());
					l_app_msg = " ::: 2 City ::: " + l_city.toLowerCase();
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);
				}
				
				if (l_city_code.length() > 0 && l_district_code.length() > 0) {
					pstmt.setString(3, l_district_code);
				}
				else if (l_city.length() > 0 && l_district.length() > 0) {
					pstmt.setString(3, l_district.toLowerCase());
					l_app_msg = " ::: 3 District ::: "
							+ l_district.toLowerCase();
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);
				}
				else if (l_district_code.length() > 0)
				{
					pstmt.setString(2, l_district_code);
				}
				else if (l_district.length() > 0) {
					pstmt.setString(2, l_district.toLowerCase());
					l_app_msg = " ::: 2 District ::: "
							+ l_district.toLowerCase();
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);
				}
				
				if (l_city_code.length() > 0 && l_district_code.length() > 0 && l_state_code.length() > 0) {
					pstmt.setString(4, l_state_code);
				}
				else if (l_city.length() > 0 && l_district.length() > 0 && l_state.length() > 0) {
					pstmt.setString(4, l_state.toLowerCase());
					l_app_msg = " ::: 4 State ::: " + l_state.toLowerCase();
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);
				}
				else if (l_city_code.length() > 0 && l_state_code.length() > 0) {
					pstmt.setString(3, l_state_code);
				} 
				else if (l_city.length() > 0 && l_state.length() > 0) {
					pstmt.setString(3, l_state.toLowerCase());
					l_app_msg = " ::: 3 State ::: " + l_state.toLowerCase();
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);

				}
				else if (l_district_code.length() > 0 && l_state_code.length() > 0) {
					pstmt.setString(3, l_state_code);
				} 
				else if (l_district.length() > 0 && l_state.length() > 0) {
					pstmt.setString(3, l_state.toLowerCase());
					l_app_msg = " ::: 3 State ::: " + l_state.toLowerCase();
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);
				}
				else if (l_state_code.length() > 0) {
					pstmt.setString(2, l_state_code);
				} 
				else if (l_state.length() > 0) {
					pstmt.setString(2, l_state.toLowerCase());
					l_app_msg = " ::: 2 State ::: " + l_state.toLowerCase();
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);
				}

				rset = pstmt.executeQuery();

				while (rset.next()) {

					l_address_count++;
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: ADDRESS COUNT ::: "
								+ l_address_count);

					l_city_code = rset.getString("TOWN_CODE");
					l_district_code = rset.getString("DISTRICT_CODE");
					l_state_code = rset.getString("STATE_CODE");
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: City Code ::: " + l_city_code);
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: District Code ::: "+ l_district_code);
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: State Code ::: "+ l_state_code);
				}

				if (l_address_count > 1) {
					l_city_code = "";
					l_district_code = "";
					l_state_code = "";					
				}
				
				if (l_debug_YN.equals("Y"))
					System.out.println(" ::: City Code ::: " + l_city_code);
				if (l_debug_YN.equals("Y"))
					System.out.println(" ::: District Code ::: "+ l_district_code);
				if (l_debug_YN.equals("Y"))
					System.out.println(" ::: State Code ::: "+ l_state_code);

			} catch (Exception e) {

				l_status_desc = "Exception in " + l_app_msg + " - "
						+ e.getMessage();

				return l_status_desc;

			} finally {
				EMDataSource.returnConnection(con);
				XHUtil.closeDBResources(rset, pstmt, null);
			}

			LinkedHashMap<String, String> MP_PAT_ADDRESSES = new LinkedHashMap<String, String>();

			MP_PAT_ADDRESSES.put("ADDR1_LINE1", l_address_line_1);
			MP_PAT_ADDRESSES.put("ADDR1_LINE2", l_address_line_2);
			MP_PAT_ADDRESSES.put("ADDR1_LINE3", l_address_line_3);
			MP_PAT_ADDRESSES.put("ADDR1_LINE4", l_address_line_4);
			MP_PAT_ADDRESSES.put("POSTAL1_CODE", l_postal_code_str);
			MP_PAT_ADDRESSES.put("REGION1_CODE", l_state_code); // l_state
			MP_PAT_ADDRESSES.put("RES_AREA1_CODE", l_district_code); // l_district
			MP_PAT_ADDRESSES.put("RES_TOWN1_CODE", l_city_code); // l_city
			MP_PAT_ADDRESSES.put("COUNTRY1_CODE", l_country_name);// l_country
			MP_PAT_ADDRESSES.put("ADDED_BY_ID", added_by_id);
			MP_PAT_ADDRESSES.put("ADDED_DATE", "SYSDATE");
			MP_PAT_ADDRESSES.put("ADDED_AT_WS_NO", added_at_ws_no);
			MP_PAT_ADDRESSES.put("ADDED_FACILITY_ID", l_facility_id);
			MP_PAT_ADDRESSES.put("MODIFIED_BY_ID", modified_by_id);
			MP_PAT_ADDRESSES.put("MODIFIED_DATE", "SYSDATE");
			MP_PAT_ADDRESSES.put("MODIFIED_AT_WS_NO", modified_at_ws_no);
			MP_PAT_ADDRESSES.put("MODIFIED_FACILITY_ID", l_facility_id);
			MP_PAT_ADDRESSES.put("ADDR1_TYPE", "RES");

			new_hash_map.put("MP_PATIENT", MP_PATIENT);

			if (l_pat_no_gen_yn.equals("Y")) {
				Patient_id = generatePatientID();
			} else {
				new_hash_map.get(Patient_id);
				transaction_completed = true;
			}

			MP_PATIENT.put("PATIENT_ID", Patient_id);
			MP_PAT_ADDRESSES.put("PATIENT_ID", Patient_id);
			MP_PATIENT.put("REGION_CODE", l_state_code); // l_state
			MP_PATIENT.put("RES_AREA_CODE", l_district_code); // l_district
			MP_PATIENT.put("RES_TOWN_CODE", l_city_code); // l_city

			LinkedHashMap<String, String> MP_PAT_OTH_DTLS = new LinkedHashMap<String, String>();
			MP_PAT_OTH_DTLS.put("PATIENT_ID", Patient_id);
			MP_PAT_OTH_DTLS.put("LIVING_DEPENDENCY", "UN");
			MP_PAT_OTH_DTLS.put("LIVING_ARRANGEMENT", "U");
			MP_PAT_OTH_DTLS.put("ADDED_BY_ID", added_by_id);
			MP_PAT_OTH_DTLS.put("ADDED_DATE", "SYSDATE");
			MP_PAT_OTH_DTLS.put("ADDED_AT_WS_NO", added_at_ws_no);
			MP_PAT_OTH_DTLS.put("ADDED_FACILITY_ID", l_facility_id);
			MP_PAT_OTH_DTLS.put("MODIFIED_BY_ID", modified_by_id);
			MP_PAT_OTH_DTLS.put("MODIFIED_DATE", "SYSDATE");
			MP_PAT_OTH_DTLS.put("MODIFIED_AT_WS_NO", modified_at_ws_no);
			MP_PAT_OTH_DTLS.put("MODIFIED_FACILITY_ID", l_facility_id);

			LinkedHashMap<String, String> MP_PAT_REL_CONTACTS = new LinkedHashMap<String, String>();
			MP_PAT_REL_CONTACTS.put("PATIENT_ID", Patient_id);
			MP_PAT_REL_CONTACTS.put("CONTACT1_ROLE", "NEXT");
			MP_PAT_REL_CONTACTS.put("CONTACT2_ROLE", "FRST");
			MP_PAT_REL_CONTACTS.put("ADDED_BY_ID", added_by_id);
			MP_PAT_REL_CONTACTS.put("ADDED_DATE", "SYSDATE");
			MP_PAT_REL_CONTACTS.put("ADDED_AT_WS_NO", added_at_ws_no);
			MP_PAT_REL_CONTACTS.put("ADDED_FACILITY_ID", l_facility_id);
			MP_PAT_REL_CONTACTS.put("MODIFIED_BY_ID", modified_by_id);
			MP_PAT_REL_CONTACTS.put("MODIFIED_DATE", "SYSDATE");
			MP_PAT_REL_CONTACTS.put("MODIFIED_AT_WS_NO", modified_at_ws_no);
			MP_PAT_REL_CONTACTS.put("MODIFIED_FACILITY_ID", l_facility_id);

			LinkedHashMap<String, String> MP_PAT_DOCUMENTS = new LinkedHashMap<String, String>();
			MP_PAT_DOCUMENTS.put("PATIENT_ID", Patient_id);
			MP_PAT_DOCUMENTS.put("ADDED_BY_ID", added_by_id);
			MP_PAT_DOCUMENTS.put("ADDED_DATE", "SYSDATE");
			MP_PAT_DOCUMENTS.put("ADDED_AT_WS_NO", added_at_ws_no);
			MP_PAT_DOCUMENTS.put("ADDED_FACILITY_ID", l_facility_id);
			MP_PAT_DOCUMENTS.put("MODIFIED_BY_ID", modified_by_id);
			MP_PAT_DOCUMENTS.put("MODIFIED_DATE", "SYSDATE");
			MP_PAT_DOCUMENTS.put("MODIFIED_AT_WS_NO", modified_at_ws_no);
			MP_PAT_DOCUMENTS.put("MODIFIED_FACILITY_ID", l_facility_id);

			LinkedHashMap<String, String> BL_PATIENT_FIN_DTLS = new LinkedHashMap<String, String>();

			BL_PATIENT_FIN_DTLS.put("PATIENT_ID", Patient_id);
			BL_PATIENT_FIN_DTLS.put("CUR_ACCT_SEQ_NO", l_cur_acct_seq_no);
			BL_PATIENT_FIN_DTLS.put("BLNG_GRP_ID", l_biling_group_id);
			BL_PATIENT_FIN_DTLS.put("BLNG_CLASS_CODE", l_biling_class_code);
			BL_PATIENT_FIN_DTLS.put("SETTLEMENT_IND", l_settlement_ind);
			BL_PATIENT_FIN_DTLS.put("SLMT_TYPE_CODE", l_settlement_type);
			BL_PATIENT_FIN_DTLS.put("ADDED_BY_ID", added_by_id);
			BL_PATIENT_FIN_DTLS.put("ADDED_BY_ID", added_by_id);
			BL_PATIENT_FIN_DTLS.put("ADDED_BY_ID", added_by_id);
			BL_PATIENT_FIN_DTLS.put("ADDED_BY_ID", added_by_id);
			BL_PATIENT_FIN_DTLS.put("ADDED_DATE", "SYSDATE");
			BL_PATIENT_FIN_DTLS.put("ADDED_AT_WS_NO", added_at_ws_no);
			BL_PATIENT_FIN_DTLS.put("ADDED_FACILITY_ID", l_facility_id);
			BL_PATIENT_FIN_DTLS.put("MODIFIED_BY_ID", modified_by_id);
			BL_PATIENT_FIN_DTLS.put("MODIFIED_DATE", "SYSDATE");
			BL_PATIENT_FIN_DTLS.put("MODIFIED_AT_WS_NO", modified_at_ws_no);
			BL_PATIENT_FIN_DTLS.put("MODIFIED_FACILITY_ID", l_facility_id);

			LinkedHashMap<String, String> BL_ENCOUNTER_PAYER_PRIORITY = new LinkedHashMap<String, String>();
			BL_ENCOUNTER_PAYER_PRIORITY.put("PATIENT_ID", Patient_id);
			BL_ENCOUNTER_PAYER_PRIORITY.put("OPERATING_FACILITY_ID", "KH");
			BL_ENCOUNTER_PAYER_PRIORITY.put("EPISODE_TYPE", "R");
			BL_ENCOUNTER_PAYER_PRIORITY.put("ACCT_SEQ_NO", "1");
			BL_ENCOUNTER_PAYER_PRIORITY
					.put("ACCT_SEQ_EFF_FROM_DATE", "SYSDATE");
			BL_ENCOUNTER_PAYER_PRIORITY.put("ENC_REGN_DATE_TIME", "SYSDATE");
			BL_ENCOUNTER_PAYER_PRIORITY.put("BLNG_GRP_ID", l_biling_group_id);
			BL_ENCOUNTER_PAYER_PRIORITY.put("SETTLEMENT_IND", l_settlement_ind);
			BL_ENCOUNTER_PAYER_PRIORITY.put("ADDED_BY_ID", added_by_id);
			BL_ENCOUNTER_PAYER_PRIORITY.put("ADDED_DATE", "SYSDATE");
			BL_ENCOUNTER_PAYER_PRIORITY.put("ADDED_AT_WS_NO", added_at_ws_no);
			BL_ENCOUNTER_PAYER_PRIORITY.put("ADDED_FACILITY_ID", l_facility_id);
			BL_ENCOUNTER_PAYER_PRIORITY.put("MODIFIED_BY_ID", modified_by_id);
			BL_ENCOUNTER_PAYER_PRIORITY.put("MODIFIED_DATE", "SYSDATE");
			BL_ENCOUNTER_PAYER_PRIORITY.put("MODIFIED_AT_WS_NO",
					modified_at_ws_no);
			BL_ENCOUNTER_PAYER_PRIORITY.put("MODIFIED_FACILITY_ID",
					l_facility_id);
			BL_ENCOUNTER_PAYER_PRIORITY.put("MAND_ADDL_INFO_RECORDED_YN", "N");
			BL_ENCOUNTER_PAYER_PRIORITY.put("PRE_INV_YN", "N");
			BL_ENCOUNTER_PAYER_PRIORITY.put("PRE_INV_FIN_YN", "N");
			BL_ENCOUNTER_PAYER_PRIORITY.put("INT_RESPONSE_CODE", "0");
			BL_ENCOUNTER_PAYER_PRIORITY.put("INT_VALIDITY_TYPE", "0");

			new_hash_map.put("MP_PAT_ADDRESSES", MP_PAT_ADDRESSES);
			new_hash_map.put("MP_PAT_OTH_DTLS", MP_PAT_OTH_DTLS);
			new_hash_map.put("MP_PAT_REL_CONTACTS", MP_PAT_REL_CONTACTS);
			new_hash_map.put("MP_PAT_DOCUMENTS", MP_PAT_DOCUMENTS);
			new_hash_map.put("BL_PATIENT_FIN_DTLS", BL_PATIENT_FIN_DTLS);
			new_hash_map.put("BL_ENCOUNTER_PAYER_PRIORITY",
					BL_ENCOUNTER_PAYER_PRIORITY);
			if (l_debug_YN.equals("Y"))
				System.out.println("NewHashMap" + new_hash_map);

			l_status_desc = InserData(new_hash_map);
			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: Insert data completed ::: ");
			
			if (l_status_desc.length()>0)
				Patient_id = l_status_desc;

			System.out.println(" ::: Patient Id ::: " + Patient_id);

		} catch (Exception e) {

			l_status_desc = "Exception in " + l_app_msg + " - "
					+ e.getMessage();

			return l_status_desc;
		}

		return Patient_id;

	}

	public static String InserData(
			HashMap<String, HashMap<String, String>> new_hash_map) {
		Connection con = null;
		PreparedStatement pstmt = null;
		Set<String> tableKeys = new_hash_map.keySet();
		String insertStr = "";
		int count = 0;
		boolean insertFlag = false;
		String tableName = "";

		try {
			
			l_status_desc = "";
			l_app_msg = " ::: Inside Insert Data ::: ";
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			con = EMDataSource.getConnection();
			for(String tableKey: tableKeys){
				
				insertFlag = false;

				LinkedHashMap<String, String> tHashMap = (LinkedHashMap<String, String>) new_hash_map
						.get(tableKey);

				Set<String> columnKeys = tHashMap.keySet();
				
				keyStr = "";
				valueStr = "";
				
				tableName = tableKey;
				
				for(String columnKey: columnKeys){
					keyStr = keyStr + columnKey + ",";    
					
					l_app_msg = " ::: Reading  Columnkey ::: ";
					if (l_debug_YN.equals("Y"))
						System.out.println(l_app_msg);

					if (tHashMap.get(columnKey).contains("DATE"))
						valueStr = valueStr + "" + tHashMap.get(columnKey) + ""
								+ ",";
					else
						valueStr = valueStr + "\'" + tHashMap.get(columnKey)
								+ "\'" + ",";

				}

				keyStr = keyStr.substring(0,keyStr.length() -1 );
				valueStr = valueStr.substring(0,valueStr.length() -1 );
				
				l_app_msg = " ::: Inserting the Values ::: ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				insertStr = " Insert into " + tableKey + " (" + keyStr
						+ ") VALUES (" + valueStr + ") ";
				if (l_debug_YN.equals("Y"))
					System.out.println(" ::: Insert Query ::: "
							+ insertStr.toString());

				if (pstmt != null)
					pstmt.close();
				pstmt = con.prepareStatement(insertStr.toString());
				count = pstmt.executeUpdate();

				if (l_debug_YN.equals("Y"))
					System.out.println(" ::: Count ::: " + count);
				
				if (count > 0){
					insertFlag = true;
				}
				
				/*

				if (count == 1) {
					con.commit();
					if (l_debug_YN.equals("Y"))
						System.out.println(" ::: Inserted Success ::: ");
				} else {
					con.rollback();
				}
				
				*/
				keyStr = "";
				valueStr = "";
			}
			
			if (insertFlag) {
				con.commit();
				if (l_debug_YN.equals("Y"))
					System.out.println(" ::: Inserted Success ::: ");
			} else {
				con.rollback();
			}
		} catch (Exception e) {
			l_status = "0";
			l_status_desc = "Exception in saving the data in " + tableName + ", "+ l_app_msg + " - " + e.getMessage();
			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: Status Desc ::: " + l_status_desc);
			
			try{
				con.rollback();
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
			}
			

		} finally {
			EMDataSource.returnConnection(con);
			XHUtil.closeDBResources(null, pstmt, null);
		}
		
		return l_status_desc;		
	
	}

	public static String generatePatientID() {
		l_app_msg = " ::: Inside GeneratePatientID ::: ";
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);
		String gen_patient_id = "";
		String p_err_msg	= "";
		CallableStatement cs = null;

		Connection con = null;
		try {
			
			l_status_desc = "";

			if (l_pat_no_ctrl.equals("Z")) {
				if (l_debug_YN.equals("Y"))
					System.out.println(" ::: Pat No Ctrl ::: " + l_pat_no_ctrl);

				con = EMDataSource.getConnection();

				cs = con.prepareCall("{call generate_patient_id(?,?,?,?,?,?,?) }");

				cs.setString(1, l_pat_ser_grp);
				cs.setString(2, l_site_id);
				cs.setString(3, "1");
				cs.setString(4, "0");
				cs.setString(5, new_hash_map.get("MP_PATIENT").get("SEX"));
				cs.registerOutParameter(6, Types.VARCHAR);
				cs.registerOutParameter(7, Types.VARCHAR);
				@SuppressWarnings("unused")
				String Site_or_Facility = "S";

			}

			cs.execute();
			gen_patient_id = cs.getString(6);
			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: Generated Patient Id ::: "
						+ gen_patient_id);
			p_err_msg = cs.getString(7);

			if (gen_patient_id == null) {
				gen_patient_id = "";
			}
			if (p_err_msg == null) {
				p_err_msg = "";
			}

			if (!p_err_msg.equals("")) {
				transaction_completed = false;
				if (l_debug_YN.equals("Y"))
					System.out.println(" ::: Error Message ::: " + p_err_msg);
			} else {
				transaction_completed = true;
				if (l_debug_YN.equals("Y"))
					System.out.println(" ::: Error Message ::: " + p_err_msg);
			}
		}

		catch (Exception e) {
			transaction_completed = false;
			l_status = "0";
			l_status_desc = "Exception in " + l_app_msg + " - "
					+ e.getMessage();

			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: Status Desc ::: " + l_status_desc);
		} finally {
			EMDataSource.returnConnection(con);
			XHUtil.closeDBResources(null, cs, null);
		}

		return gen_patient_id;

	}

	public static String FetchStdCntrlSegMethod(String segmentID,
			String elementId, String standardCode) {

		Connection dbConn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		String query = "";
		String l_app_msg = "", l_field_value = "";

		l_app_msg = " ::: Inside FetchStdCntrlSegMethod ::: ";
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);

		l_app_msg = " ::: Segment ID ::: " + segmentID + " ::: Element ID ::: "
				+ elementId + " ::: Standard Code ::: " + standardCode;
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);

		l_app_msg = " ::: Retrieving ::: " + elementId + " ::: Value ::: ";
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);

		try {
			dbConn = EMDataSource.getConnection();
			if (l_debug_YN.equals("Y"))
				System.out.println(dbConn.toString());
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
			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: Fetch control l_field_value ::: "
						+ l_field_value);

		} catch (Exception e) {
			l_field_value = "Error in " + l_app_msg + " : " + e.getMessage();
			if (l_debug_YN.equals("Y"))
				System.out.println(" ::: Field Value ::: " + l_field_value);
			e.printStackTrace();
		} finally {
			EMDataSource.returnConnection(dbConn);
			XHUtil.closeDBResources(rs, pstmt, null);
		}
		return l_field_value;
	}

	public static String PatientName(String name_prefix, String first_name,
			String second_name, String family_name) {
		l_app_msg = " ::: Inside Patient Name ::: ";
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);

		l_app_msg = " ::: Name Prefix ::: " + name_prefix
				+ " ::: First Name ::: " + first_name + " ::: Second Name ::: "
				+ second_name + " ::: Family Name ::: " + family_name;
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg);

		String logic = "PR+< >+1N+< >+2N+< >+FN";
		String derivedName = "";
		derivedName = "";
		int j = 0;
		String[] arr = new String[10];
		arr = logic.split("\\+");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(" ::: Array ::: " + arr[i]);

		}

		for (j = 0; j < arr.length; j++) {

			if (arr[j].equals("1N") && name_prefix != null) {
				if (first_name != " ") {
					derivedName = derivedName + first_name;
					System.out.println(" ::: first_name derivedName :::"
							+ derivedName);
				}

			} else if (arr[j].equals("2N") && second_name != null) {
				if (second_name != " ")
					derivedName = derivedName + second_name;
				System.out.println(" ::: second_name derivedName ::: "
						+ derivedName);
			} else if (arr[j].equals("FN") && family_name != null) {
				if (family_name != " ") {
					derivedName = derivedName + family_name;
					System.out.println(" ::: family_name derivedName ::: "
							+ derivedName);
				}
			}

			else if (arr[j].equals("PR") && name_prefix != null) {
				if (name_prefix != "") {
					derivedName = derivedName + name_prefix;
					System.out.println(" ::: name_prefix derivedName ::: "
							+ derivedName);

				}
			}

			else {
				if (arr[j] != "1N" && arr[j] != "2N" && arr[j] != "3N"
						&& arr[j] != "FN" && arr[j] != "PR") {
					int arLen = arr[j].length();

					System.out.println("arLen.." + arLen);

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
	