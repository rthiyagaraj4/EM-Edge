package eXH.iqvia;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import eXH.util.EMDataSource;
import eXH.util.XHUtil;

public class IqviaPractitionerRoleUpdateTransaction {

	public static String l_debug_YN = "N";

	public String l_errcd = "N", l_errmsg = "";

	String l_in_JSON = "", l_app_msg = "";

	String[] str_facility = null,  str_pract = null, str_org = null, str_spl_code = null;
	
	public String PractRoleUpdateTransRequestMethod(String applicationId, String actionKey) 
			throws ParseException, java.text.ParseException, JsonGenerationException, JsonMappingException, IOException{

		String l_status = "", l_responseJsonString = "";
		//String[] str= null;
		Map<String, Object> l_response_json = new LinkedHashMap<String, Object>();
		ObjectMapper objMapper = new ObjectMapper();
		
		l_app_msg = "::: Inside IQVIA PractitionerRoleDetails ::: ";
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg); 

		String returnFinalMessage = StringUtils.EMPTY, returnFacilityFinalMessage = StringUtils.EMPTY, multi_specialty = StringUtils.EMPTY;
	
		String returnPractIdFinalMessage="The Practitioner Id cannot be blank";		
		String returnEmplStatusFinalMessage="The Employee Status cannot be blank";
		String returnEffStatusFinalMessage="The EFF Status cannot be blank";
		String returnPractPhoneNoFinalMessage="The Phone number cannot be blank";
		String returnPractEmailIdFinalMessage="The Phone number cannot be blank";
		String returnPractFaxFinalMessage="The Phone number cannot be blank";
		//String returnSpecialtyCodingFinalMessage="The Specialty Coding cannot be blank";
		
		String l_practitioner_id="";
		String l_phone="", l_email_id="", l_fax="";
		String l_period_start="", l_period_end="";
		String l_facility_id="",l_added_facility_id="", l_modified_facility_id="", l_added_at_ws_no="", l_modified_at_ws_no="";
		String l_code="",l_display="", l_specialty="", l_multi_specialty_code="";
		
		String l_app_msg = "", l_eff_status="", l_empl_status="";

		Connection dbConn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;
		String query = "", l_debug_yn = "";

		Map<String, String> params = new HashMap<String, String>();
		Map<String, String> specialtyparams = new HashMap<String, String>();
		
		JSONObject json = (JSONObject) new JSONParser().parse(actionKey);

		try
		{
			dbConn =  EMDataSource.getConnection();
			query = "select NVL(DEBUG_YN, 'N') DEBUG_YN FROM XH_PARAM" ;

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

		l_app_msg = "::: Inside IQVIA PractitionerRoleDetails Request ::: ";
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg); 


		l_app_msg = "::: Inside IQVIA PractitionerRoleDetails Application ID ::: "+applicationId;
		if (l_debug_YN.equals("Y"))	
			System.out.println(l_app_msg);		


		l_app_msg = "::: Inside IQVIA PractitionerRoleDetails Action Key ::: "+actionKey;
		if (l_debug_YN.equals("Y"))	
			System.out.println(l_app_msg);

		try{	

			if(l_errcd.equals("N")){

				JSONArray identifier_array = (JSONArray)json.get("identifier");

				for(int i=0; i<identifier_array.size(); i++) {
					JSONObject jsonObj = (JSONObject) identifier_array.get(i);
							l_practitioner_id = (String)jsonObj.get("value");
				}

				l_app_msg = "::: Fetching Practitioner Role ID ::: ";
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

				l_app_msg = "Practitioner Role ID : " + l_practitioner_id;
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				params.put("PRACTITIONER_ID", l_practitioner_id);

			}

			if(l_errcd.equals("N")){
				l_app_msg = "::: Fetching Practitioner Role Employee Status ::: ";
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

				l_empl_status="F";

				l_app_msg = "Practitioner Role Employee Status : " + l_empl_status;
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

				params.put("EMPL_STATUS", l_empl_status);		
			}

			if(l_errcd.equals("N")){
				l_app_msg = "::: Fetching Practitioner Role EFF Status ::: ";
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

				l_eff_status = json.get("active").toString();

				if(l_eff_status.equals("true")){
					l_eff_status = "E";
				}else if(l_eff_status.equals("false")){
					l_eff_status = "D";
				}

				l_app_msg = "Practitioner Role EFF Status : " + l_eff_status;
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

				params.put("EFF_STATUS", l_eff_status);		
			}

			if(l_errcd.equals("N")){

				JSONArray telecom_array = (JSONArray)json.get("telecom");

				l_app_msg = "::: Fetching Telecom ::: ";
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

				for(int i=0; i<telecom_array.size(); i++) {
					JSONObject jsonObj = (JSONObject) telecom_array.get(i);
					String telecom_system = (String) jsonObj.get("system");

					if(telecom_system !=null){
						if("phone".equals(telecom_system)){
							l_phone = (String) jsonObj.get("value");
	
							if (l_phone.equals(StringUtils.EMPTY) || l_phone.equals(null)) {
								l_errcd = "E";
								return l_errcd + "#"
										+ returnPractPhoneNoFinalMessage;
							} else {
								params.put("MOBILE_NUM", l_phone);
							}		
						}
						if("email".equals(telecom_system)){
							l_email_id = (String) jsonObj.get("value");
							if (l_email_id.equals(StringUtils.EMPTY) || l_email_id.equals(null)) {
								l_errcd = "E";
								return l_errcd + "#"
										+ returnPractEmailIdFinalMessage;
							} else {
								params.put("EMAIL_ID", l_email_id);
							}		
						}
						if("fax".equals(telecom_system)){
							l_fax = (String) jsonObj.get("value");
							if (l_fax.equals(StringUtils.EMPTY) || l_fax.equals(null)) {
								l_errcd = "E";
								return l_errcd + "#"
										+ returnPractFaxFinalMessage;
							} else {
								params.put("FAX_NUM", l_fax);
							}		
						}
					}
				}
				

				l_app_msg = "Practitioner Phone No : " + l_phone;
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				
				l_app_msg = "Practitioner Email ID : " + l_email_id;
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				
				l_app_msg = "Practitioner Fax : " + l_fax;
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
	
			}
			
			if(l_errcd.equals("N")){
				l_app_msg = "::: Fetching Practitioner Facility Id ::: ";
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

				JSONObject organization = (JSONObject)json.get("organization");
				
				l_facility_id = organization.get("reference").toString();

				str_org = l_facility_id.split("/");
						
				l_app_msg = "Practitioner Facility Id : " + str_org[1];
				
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				params.put("FACILITY_ID", str_org[1]);					
			}
			
			if(l_errcd.equals("N")){
				l_app_msg = "::: Fetching Practitioner Role Employee Period ::: ";
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

				JSONObject period = (JSONObject)json.get("period");
				
				l_period_start = period.get("start").toString();

				l_app_msg = "Practitioner Period Start Date: " + l_period_start;
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				
				l_period_end = period.get("end").toString();
				
				l_app_msg = "Practitioner Period Start Date: " + l_period_end;
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				
				params.put("EFF_DATE_FROM", l_period_start);	
				params.put("EFF_DATE_TO", l_period_end);	
			}
			
			if(l_errcd.equals("N")){
				l_app_msg = "::: Fetching Practitioner Added At Ws No ::: ";
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

				l_added_at_ws_no = "INTERFACE";

				l_app_msg = "Practitioner Added At Ws No : " + l_added_at_ws_no;
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				params.put("ADDED_AT_WS_NO", l_added_at_ws_no);				
			}
			
			if(l_errcd.equals("N")){
				l_app_msg = "::: Fetching Practitioner Added Facility Id ::: ";
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

				l_added_facility_id = "DF";

				l_app_msg = "Practitioner Added Facility Id : " + l_added_facility_id;
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				params.put("ADDED_FACILITY_ID", l_added_facility_id);					
			}
			
			if(l_errcd.equals("N")){
				l_app_msg = "::: Fetching Practitioner Modified At Ws No ::: ";
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

				l_modified_at_ws_no = "INTERFACE";

				l_app_msg = "Practitioner Modified At Ws No : " + l_modified_at_ws_no;
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				params.put("MODIFIED_AT_WS_NO", l_modified_at_ws_no);			
			}
			
			if(l_errcd.equals("N")){
				l_app_msg = "::: Fetching Practitioner Modified Facility ID ::: ";
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

				l_modified_facility_id = "DF";

				l_app_msg = "Practitioner Modified Facility ID : " + l_modified_facility_id;
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				params.put("MODIFIED_FACILITY_ID", l_modified_facility_id);					
			}

			if(l_errcd.equals("N")){

				l_app_msg = "::: Fetching Practitioner Specialty ::: ";
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

				JSONArray specialty_array = (JSONArray)json.get("specialty");

				if(specialty_array.size() >0){
					JSONObject CodingObj1 = (JSONObject) specialty_array.get(0);	
					
					JSONArray coding_array = (JSONArray) CodingObj1.get("coding");
					
					JSONObject coding_obj = (JSONObject) coding_array.get(0);

					l_code = (String) coding_obj.get("code");
					l_display = (String) coding_obj.get("display");
					
					l_app_msg = "Practitioner Role Specialty Code: "+l_code;
					if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);					
					
					l_app_msg = "Practitioner Role Specialty Display: "+l_display;
					if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
					
					l_specialty = FetchSpecialtyMethod(l_code);
					
					l_app_msg = "Practitioner Role Specialty : "+l_specialty;
					if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
					
					params.put("PRIMARY_SPECIALITY_CODE", l_specialty);
					
					if(specialty_array.size() >1){
						for(int i=1;i<specialty_array.size();i++){
							JSONObject CodingObj2 = (JSONObject) specialty_array.get(i);	
							
							JSONArray coding_multi_array = (JSONArray) CodingObj2.get("coding");

							JSONObject coding_multi_obj = (JSONObject) coding_multi_array.get(0);
	
							l_code = (String) coding_multi_obj.get("code");
							l_display = (String) coding_multi_obj.get("display");
							
							l_app_msg = "Practitioner Role Multi Specialty Code: "+l_code;
							if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);					
							
							l_app_msg = "Practitioner Role Multi Specialty Display: "+l_display;
							if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
							
							l_multi_specialty_code = FetchSpecialtyMethod(l_code);
							
							specialtyparams.put("SPECIALITY_CODE", l_multi_specialty_code);
							
							l_app_msg = "IQVIA Practitioner Role SpecialtyParams ...";
							if (l_debug_YN.equals("Y")) System.out.println(l_app_msg+" :::::: "+specialtyparams);	
							
							multi_specialty = FetchMultiSpecialtyMethod(specialtyparams, params);
							
							l_app_msg = "Practitioner Role Multi Specialty : "+multi_specialty;
							if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
							
							str_spl_code  = multi_specialty.split("#");
							if("E".equals(str_spl_code[0])){
								l_errcd="E";
								return l_errcd+"#" + str_spl_code[1];
							}
						}
					}
				}
					
			}
			
			if(l_errcd.equals("N")){
				
				l_app_msg = "::: Fetching Practitioner Facility ::: ";
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				
				returnFacilityFinalMessage = insertPractitionerFacility(params);
				
				str_facility  = returnFacilityFinalMessage.split("#");
				if("E".equals(str_facility[0])){
					l_errcd="E";
					return l_errcd+"#" + str_facility[1];
				}

			}
			
			l_app_msg = "IQVIA Practitioner Role Params ...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg+" :::::: "+params);	

			l_app_msg = "Inserting Params Practitioner Role into the table ..";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			

			returnFinalMessage = updatePratitionerRole(params);
			
			
		}catch(Exception e){
			e.printStackTrace();
			l_errcd="E";
			if(l_practitioner_id ==null || l_practitioner_id==""){
				return l_errcd+"#" + returnPractIdFinalMessage;
			}else if(l_empl_status ==null || l_empl_status ==""){
				return l_errcd+"#" + returnEmplStatusFinalMessage;	
			}else if(l_eff_status ==null || l_eff_status ==""){
				return l_errcd+"#" + returnEffStatusFinalMessage;	
			}		
		}	
		//return returnFinalMessage;
		
		str_pract  = returnFinalMessage.split("#");		

		if("S".equals(str_pract[0])){
			//l_status = "1";
			l_response_json.put("Status", str_pract[0]);
			//l_response_json.put("Status", l_status);
			l_response_json.put("status_desc", str_pract[1]);
			
			l_responseJsonString = objMapper.writeValueAsString(l_response_json);
			
			return str_pract[0] +"#"+ l_responseJsonString;
			
		}else{
			//l_status = "0";
			l_response_json.put("Status", str_pract[0]);
			//l_response_json.put("Status", l_status);
			l_response_json.put("status_desc", str_pract[1]);
			
			l_responseJsonString = objMapper.writeValueAsString(l_response_json);
			
			return str_pract[0] +"#"+ l_responseJsonString;
			
		}

	}

	public static String FetchSpecialtyMethod(String elementId) {
		Connection dbConn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;

		String query = "";
		String l_app_msg = "", l_field_value = "";

		l_app_msg = "::: Inside FetchSpecialtyMethod ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		
		l_app_msg = "::: FetchSpecialtyMethod Retrieving "+ elementId + " Value...";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		try
		{
			dbConn =  EMDataSource.getConnection();
			
			query = "SELECT PK_VALUE FROM XH_OTH_APPL_DATA_SKEY WHERE TABLE_ID = 'AM_SPECIALITY' AND APPLICATION_ID = 'IQVIA' " +
					"AND EXT_PK_ID = ?"; 

			pstmt = dbConn.prepareStatement(query);
			pstmt.setString(1, elementId);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
			   l_field_value = rs.getString("PK_VALUE");
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
	  
	public static String FetchMultiSpecialtyMethod(Map<String,String> specialtyparams, Map<String,String> params) {
		
		String l_app_msg = ""; 
		String l_err_code = "S", l_err_msg = "Success";
		String finalMessage = StringUtils.EMPTY;
		
		l_app_msg = "::: Inside Update Practitioner Role FetchMultiSpecialtyMethod ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

		Connection dbConn = null;
		PreparedStatement pstmt = null;
		int insertCount = 0;
		
		String practfacilitystmt = "INSERT INTO AM_PRACT_SPECIALITIES (FACILITY_ID, PRACTITIONER_ID, SPECIALITY_CODE, " +
				" ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) " +
				"VALUES (?, ?, ?, ?, ?, ?, ?) ";
				
		l_app_msg = "::: Inside FetchMultiSpecialtyMethod  practfacilitystmt ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg+" :::: "+practfacilitystmt);
		
		try{
			
			dbConn = EMDataSource.getConnection();
			
			pstmt = dbConn.prepareStatement(practfacilitystmt);
			
			pstmt.setString(1, params.get("FACILITY_ID"));
			l_app_msg = "::: Inserting the FACILITY_ID ::: "+params.get("FACILITY_ID");
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			pstmt.setString(2, params.get("PRACTITIONER_ID"));
			l_app_msg = "::: Inserting the PRACTITIONER_ID ::: "+params.get("PRACTITIONER_ID");
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			pstmt.setString(3, specialtyparams.get("SPECIALITY_CODE"));
			l_app_msg = "::: Inserting the FACILITY_ID ::: "+params.get("FACILITY_ID");
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			pstmt.setString(4, params.get("ADDED_AT_WS_NO"));
			l_app_msg = "::: Inserting the ADDED_AT_WS_NO ::: "+params.get("ADDED_AT_WS_NO");
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			pstmt.setString(5, params.get("ADDED_FACILITY_ID"));
			l_app_msg = "::: Inserting the ADDED_FACILITY_ID ::: "+params.get("ADDED_FACILITY_ID");
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
			pstmt.setString(6, params.get("MODIFIED_AT_WS_NO"));
			l_app_msg = "::: Inserting the MODIFIED_AT_WS_NO ::: "+params.get("MODIFIED_AT_WS_NO");
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			pstmt.setString(7, params.get("MODIFIED_FACILITY_ID"));
			l_app_msg = "::: Inserting the MODIFIED_FACILITY_ID ::: "+params.get("MODIFIED_FACILITY_ID");
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			insertCount = pstmt.executeUpdate();

			if (insertCount == 1) {
				finalMessage = "Practitioner Specialty Inserted Successfully";
				l_err_code = "S";
				dbConn.commit();
			} else {
				finalMessage = "Error in Inserting the Practitioner Specialty";
				l_err_code = "E";
				dbConn.rollback();
			}
			
			
		}catch (Exception exp) {
			l_err_code = "E";
			l_err_msg = exp.getMessage();
			exp.printStackTrace(System.err);
			System.out.println("(IqviaTransaction :: FetchMultiSpecialtyMethod) Exception " + exp);
			return l_err_code + "#"+ l_err_msg;
		}		
		finally {
			XHUtil.closeDBResources(null, pstmt, null);
			EMDataSource.returnConnection(dbConn);
		}
		return l_err_code +"#"+ finalMessage;
	}
	
	public String insertPractitionerFacility(Map<String,String> params){
		
		String l_app_msg = ""; 
		String l_err_code = "S", l_err_msg = "Success";
		String finalMessage = StringUtils.EMPTY;

		l_app_msg = "::: Inside Update Practitioner Role ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

		Connection dbConn = null;
		PreparedStatement pstmt = null;
		int insertCount = 0;
		
		String practfacilitystmt = "INSERT INTO AM_PRACT_FOR_FACILITY (FACILITY_ID, PRACTITIONER_ID, EFF_STATUS, " +
				"ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) " +
				"VALUES (?,?,?,?,?,?,?) ";  
		
		l_app_msg = "::: Inside insertPratitioner  practinsertstmt ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg+" :::: "+practfacilitystmt);
		
		try{
			
			dbConn = EMDataSource.getConnection();
			
			pstmt = dbConn.prepareStatement(practfacilitystmt);

			pstmt.setString(1, params.get("FACILITY_ID"));
			l_app_msg = "::: Inserting the FACILITY_ID ::: "+params.get("FACILITY_ID");
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			pstmt.setString(2, params.get("PRACTITIONER_ID"));
			l_app_msg = "::: Inserting the PRACTITIONER_ID ::: "+params.get("PRACTITIONER_ID");
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			pstmt.setString(3, params.get("EFF_STATUS"));
			l_app_msg = "::: Inserting the EFF_STATUS ::: "+params.get("EFF_STATUS");
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				
			pstmt.setString(4, params.get("ADDED_AT_WS_NO"));
			l_app_msg = "::: Inserting the ADDED_AT_WS_NO ::: "+params.get("ADDED_AT_WS_NO");
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			pstmt.setString(5, params.get("ADDED_FACILITY_ID"));
			l_app_msg = "::: Inserting the ADDED_FACILITY_ID ::: "+params.get("ADDED_FACILITY_ID");
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
			pstmt.setString(6, params.get("MODIFIED_AT_WS_NO"));
			l_app_msg = "::: Inserting the MODIFIED_AT_WS_NO ::: "+params.get("MODIFIED_AT_WS_NO");
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			pstmt.setString(7, params.get("MODIFIED_FACILITY_ID"));
			l_app_msg = "::: Inserting the MODIFIED_FACILITY_ID ::: "+params.get("MODIFIED_FACILITY_ID");
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			insertCount = pstmt.executeUpdate();

			if (insertCount == 1) {
				finalMessage = "Practitioner Facility Inserted Successfully";
				l_errcd = "S";
				dbConn.commit();
			} else {
				finalMessage = "Error in Inserting the Practitioner Facility";
				l_errcd = "E";
				dbConn.rollback();
			}
			
			
		}catch (Exception exp) {
			l_err_code = "E";
			l_err_msg = exp.getMessage();
			exp.printStackTrace(System.err);
			System.out.println("(IqviaTransaction :: insertPractitionerFacility) Exception " + exp);
			return l_err_code + "#"+ l_err_msg;
		}		
		finally {
			XHUtil.closeDBResources(null, pstmt, null);
			EMDataSource.returnConnection(dbConn);
		}
		return l_errcd +"#"+ finalMessage;
	}
	
	
	
	public String updatePratitionerRole(Map<String,String> params){

		String l_app_msg = ""; String practroleupdatestmt = StringUtils.EMPTY;

		String finalMessage = StringUtils.EMPTY;

		l_app_msg = "::: Inside Update Practitioner Role ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

		String practitionerId = "SELECT * FROM AM_PRACTITIONER WHERE PRACTITIONER_ID =" + "'" +params.get("PRACTITIONER_ID")+ "'";

		l_app_msg = "::: Inside Update Practitioner Role practitionerId ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg+" :::: "+practitionerId);

		practroleupdatestmt = "UPDATE AM_PRACTITIONER SET EMPL_STATUS = ?, EFF_STATUS = ?, " +
				"MOBILE_NUM  = ?, EMAIL_ID = ?, FAX_NUM = ?, PRIMARY_SPECIALITY_CODE = ? " +
				"WHERE PRACTITIONER_ID =" + "'" +params.get("PRACTITIONER_ID")+ "'";

		l_app_msg = "::: Inside Update Practitioner Role practroleupdatestmt ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg+" :::: "+practroleupdatestmt);


		Connection dbConn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmtForSelect = null;
		ResultSet rs = null;

		int updateCount = 0;
		int practitionerIdCount = 0;

		String l_err_code = "S", l_err_msg = "Success";


		try
		{
			dbConn = EMDataSource.getConnection();

			pstmtForSelect = dbConn.prepareStatement(practitionerId, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			rs = pstmtForSelect.executeQuery();

			if (rs != null) 
			{
				rs.last();   
				practitionerIdCount = rs.getRow();
			}

			l_app_msg = " ::: Inside Update Practitioner Role practitionerIdCount ::: ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg+" :::: "+practitionerIdCount);


			if (practitionerIdCount == 0) {
				l_app_msg = " ::: Inside Update Practitioner Role PractitionerId does not exist ::: ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg + " :::: "
							+ params.get("PRACTITIONER_ID"));

				finalMessage = "Update not allowed, Practitioner ID does not exist";

			}
			else {

				pstmt = dbConn.prepareStatement(practroleupdatestmt);		

				pstmt.setString(1, params.get("EMPL_STATUS"));
				l_app_msg = "::: Updating the EMPL_STATUS ::: "+ params.get("EMPL_STATUS");
				if (l_debug_YN.equals("Y"))System.out.println(l_app_msg);

				pstmt.setString(2, params.get("EFF_STATUS"));
				l_app_msg = "::: Updating the EFF_STATUS ::: "+params.get("EFF_STATUS");
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				pstmt.setString(3, params.get("MOBILE_NUM"));
				l_app_msg = "::: Updating the MOBILE_NUM ::: "+params.get("MOBILE_NUM");
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				
				pstmt.setString(4, params.get("EMAIL_ID"));
				l_app_msg = "::: Updating the EMAIL_ID ::: "+params.get("EMAIL_ID");
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				
				pstmt.setString(5, params.get("FAX_NUM"));
				l_app_msg = "::: Updating the FAX_NUM ::: "+params.get("FAX_NUM");
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				
				pstmt.setString(6, params.get("PRIMARY_SPECIALITY_CODE"));
				l_app_msg = "::: Updating the PRIMARY_SPECIALITY_CODE ::: "+params.get("PRIMARY_SPECIALITY_CODE");
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				updateCount = pstmt.executeUpdate();

				if (updateCount == 1) {
					finalMessage = "Practitioner Role Record Updated Successfully";
					l_errcd = "S";
					dbConn.commit();
				} else {
					finalMessage = "Practitioner Role Error in Updating the record";
					l_errcd = "E";
					dbConn.rollback();
				}
			}

		}catch (NullPointerException  npexp) {
			l_err_code = "E";
			l_err_msg = npexp.getMessage();
			npexp.printStackTrace(System.err);
			System.out.println("(IqviaTransaction :: UpdatePratitionerRole) Null Pointer Exception " + npexp);
			return l_err_code + "#"+ l_err_msg;
		}	
		catch (Exception exp) {
			l_err_code = "E";
			l_err_msg = exp.getMessage();
			exp.printStackTrace(System.err);
			System.out.println("(IqviaTransaction :: UpdatePratitionerRole) Exception " + exp);
			return l_err_code + "#"+ l_err_msg;
		}		
		finally {
			XHUtil.closeDBResources(null, pstmt, null);
			EMDataSource.returnConnection(dbConn);
		}
		return l_errcd +"#"+ finalMessage;
	}
	
	public String PractRoleUpdateErrorMethod(String applicationId, String actionKey) 
			throws JsonGenerationException, JsonMappingException, IOException{
		
		String l_status = "", l_responseJsonString = "", l_error_pract_role ="E#Error in Updating the record, Practitioner ID not available";
		String[] str= null;
		Map<String, Object> l_response_json = new LinkedHashMap<String, Object>();
		ObjectMapper objMapper = new ObjectMapper();

		str = l_error_pract_role.split("#");
		
		l_status = "0";
		l_response_json.put("Status Code", str[0]);
		l_response_json.put("Status", l_status);
		l_response_json.put("Status Message", str[1]);
		
		l_responseJsonString = objMapper.writeValueAsString(l_response_json);
		
		return str[0] +"#"+ l_responseJsonString;
	}
}
