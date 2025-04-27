package eXH.iqvia;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import eXH.util.EMDataSource;
import eXH.util.XHUtil;


public class IqviaPractitionerTransaction {

	public static String l_debug_YN = "N";

	public String l_errcd = "N", l_errmsg = "";

	String l_in_JSON = "", l_app_msg = "";

	public String PractInsertTransRequestMethod(String applicationId, String actionKey) 
			throws ParseException, java.text.ParseException, JsonGenerationException, JsonMappingException, IOException{	
		
		String l_status = "", l_responseJsonString = "";
		String[] str = null;
		Map<String, Object> l_response_json = new LinkedHashMap<String, Object>();
		ObjectMapper objMapper = new ObjectMapper();
		
		l_app_msg = "::: Inside IQVIA PractInsertDetails ::: ";
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg); 

		String returnFinalMessage = StringUtils.EMPTY;
		
		String returnPractIdFinalMessage="The Practitioner Id cannot be blank";		
		String returnPractNameFinalMessage="The Practitioner Name cannot be blank";		
		String returnShortNameFinalMessage="The Short Name cannot be blank";			
		String returnGenderFinalMessage="The Gender cannot be blank";
		String returnDOBFinalMessage="The Day Of Birth cannot be blank";
		String returnEffStatusFinalMessage="The EFF Status cannot be blank";
		String returnQualifyTextFinalMessage="The Qualification Degree cannot be blank";
		String returnQualifyPeriodFinalMessage="The Qualification Time Period cannot be blank";
		String returnQualifyIssuerFinalMessage="The Qualification College/University cannot be blank";
		String returnPractPhoneNoFinalMessage="The Phone number cannot be blank";
		String returnPractEmailIdFinalMessage="The Phone number cannot be blank";
		String returnPractFaxFinalMessage="The Phone number cannot be blank";

		String l_pract_type="", l_practitioner_id="", l_practitioner_name="", l_short_name="", l_primary_speciality_code="";
		String l_gender="", l_date_of_birth="", l_eff_status="", l_empl_status="";
		String l_added_facility_id="", l_modified_facility_id="", l_added_at_ws_no="", l_modified_at_ws_no="";
		String l_qualify_text="", l_qualify_period="", l_qualify_issuer="";
		String l_phone="", l_email_id="", l_fax="";
		
		String l_app_msg = "";

		Connection dbConn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;
		String query = "", l_debug_yn = "";

		Map<String, String> params = new HashMap<String, String>();

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

		l_app_msg = "::: Inside IQVIA PractInsertDetails Request ::: ";
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg); 


		l_app_msg = "::: Inside IQVIA PractInsertDetails Application ID ::: "+applicationId;
		if (l_debug_YN.equals("Y"))	
			System.out.println(l_app_msg);		


		l_app_msg = "::: Inside IQVIA PractInsertDetails Action Key ::: "+actionKey;
		if (l_debug_YN.equals("Y"))	
			System.out.println(l_app_msg);

		try{	

			if(l_errcd.equals("N")){
				l_app_msg = "::: Fetching Practitioner Type ::: ";
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

				l_pract_type =  "TB";
				
				l_app_msg = "Practitioner Type : " + l_pract_type;
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				params.put("PRACT_TYPE", l_pract_type);		
			}

			if(l_errcd.equals("N")){

				JSONArray identifier_array = (JSONArray)json.get("identifier");

				l_app_msg = "::: Fetching Practitioner ID ::: ";
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

				for(int i=0; i<identifier_array.size(); i++) {
					JSONObject jsonObj = (JSONObject) identifier_array.get(i);
					String identifier_use = (String) jsonObj.get("use");

					if(identifier_use !=null){
						if("usual".equals(identifier_use)){
							l_practitioner_id = (String) jsonObj.get("value");
							if (l_practitioner_id.equals(StringUtils.EMPTY) || l_practitioner_id.equals(null)) {
								l_errcd = "E";
								return l_errcd + "#"
										+ returnPractIdFinalMessage;
							} else {
								params.put("PRACTITIONER_ID", l_practitioner_id);
								params.put("APC_NO", l_practitioner_id);			
							}		
						}				
					}
				}

				l_app_msg = "Practitioner ID : " + l_practitioner_id;
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				
				l_app_msg = "APC No : " + l_practitioner_id;
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
	
			}

			if(l_errcd.equals("N")){

				JSONArray name_array = (JSONArray)json.get("name");

				l_app_msg = "::: Fetching Practitioner Name ::: ";
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

				for(int i=0; i<name_array.size(); i++) {
					JSONObject jsonObj = (JSONObject) name_array.get(i);

					String name_use = (String) jsonObj.get("use");

					if(name_use !=null){
						if("official".equals(name_use)){

							@SuppressWarnings("unchecked")
							List<String> prefix = (List<String>) jsonObj.get("prefix");
							for(String prefixValue:prefix){
								l_practitioner_name = l_practitioner_name + " " + prefixValue;

							}

							@SuppressWarnings("unchecked")
							List<String> given = (List<String>) jsonObj.get("given");
							for(String givenValue:given){
								l_practitioner_name = l_practitioner_name + " " + givenValue;
							}

							l_practitioner_name = l_practitioner_name + " " + (String)jsonObj.get("family");

							@SuppressWarnings("unchecked")
							List<String> suffix = (List<String>) jsonObj.get("suffix");
							for(String suffixValue:suffix){
								l_practitioner_name = l_practitioner_name + " " + suffixValue;
							}

							@SuppressWarnings("unchecked")
							List<String> shortname = (List<String>) jsonObj.get("given");
							for(String shortnameValue:shortname){
								l_short_name = shortnameValue;
							}
						}				
					}
				}

				
				l_app_msg = "Practitioner Name : " + l_practitioner_name;
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				if(l_practitioner_name.equals(StringUtils.EMPTY)){
					l_errcd="E";
					return l_errcd+"#" + returnPractNameFinalMessage;
				}else{
					params.put("PRACTITIONER_NAME", l_practitioner_name);
				}
				

				l_app_msg = "::: Fetching Practitioner Short Name ::: ";
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

				l_app_msg = "Practitioner Short Name : " + l_short_name;
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				if(l_short_name.equals(StringUtils.EMPTY)){
					l_errcd="E";
					return l_errcd+"#" + returnShortNameFinalMessage;
				}else{
					params.put("SHORT_NAME", l_short_name);
				}
				
			}

			if(l_errcd.equals("N")){
				l_app_msg = "::: Fetching Practitioner Gender ::: ";
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);			

				l_app_msg = "Practitioner Gender : " + l_gender;
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

				if(json.containsKey("gender")){
					l_gender = json.get("gender").toString();
				}else{
					l_errcd="E";
					return l_errcd+"#" + returnGenderFinalMessage;
				}
				
				if(l_gender.equals("female") || l_gender.equals("Female") || l_gender.equals("FEMALE")){

					l_gender = "F"; 

					if (l_gender.indexOf("Error")>=0)
					{
						l_errcd = "E";
						l_errmsg = l_gender;
					}
				}else if(l_gender.equals("male") || l_gender.equals("Male") || l_gender.equals("MALE")){

					l_gender = "M"; 

					if (l_gender.indexOf("Error")>=0)
					{
						l_errcd = "E";
						l_errmsg = l_gender;
					}
				}else{

					l_gender = "U"; 

					if (l_gender.indexOf("Error")>=0)
					{
						l_errcd = "E";
						l_errmsg = l_gender;
					}
				}

				l_app_msg = "Practitioner Gender F/M/U: " + l_gender;
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				params.put("GENDER", l_gender);	
			}

			if(l_errcd.equals("N")){
				l_app_msg = "::: Fetching Practitioner Date Of Birth ::: ";
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

				if(json.containsKey("birthDate")){
					l_date_of_birth = json.get("birthDate").toString();
				}else{
					l_errcd="E";
					return l_errcd+"#" + returnDOBFinalMessage;
				}
				
				l_app_msg = "Practitioner Date Of Birth : " + l_date_of_birth;
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

				//15-Apr-94
				DateFormat dateofbirth = new SimpleDateFormat("yyyy-MM-dd");
				Date dob = (Date)dateofbirth.parse(l_date_of_birth);
				DateFormat datenew = new SimpleDateFormat("dd-MMM-yy");
				String dobInString = datenew.format(dob);

				l_app_msg = "Practitioner Date Of Birth as required format: " + dobInString;
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				params.put("DATE_OF_BIRTH", dobInString);	
	
			}

			if(l_errcd.equals("N")){
				l_app_msg = "::: Fetching Practitioner Employee Status ::: ";
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				
				l_empl_status="F";

				l_app_msg = "Practitioner Employee Status : " + l_empl_status;
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				params.put("EMPL_STATUS", l_empl_status);	
			}

			if(l_errcd.equals("N")){
				l_app_msg = "::: Fetching Practitioner EFF Status ::: ";
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

				if(json.containsKey("active")){
					l_eff_status = json.get("active").toString();
				}else{
					l_errcd="E";
					return l_errcd+"#" + returnEffStatusFinalMessage;
				}
				
				if(l_eff_status.equals("true")){
					l_eff_status = "E";
				}else{
					l_eff_status = "D";
				}
				l_app_msg = "Practitioner EFF Status : " + l_eff_status;
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				params.put("EFF_STATUS", l_eff_status);	
				
			}

			if(l_errcd.equals("N")){
				l_app_msg = "::: Fetching Practitioner Primary Speciality Code ::: ";
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

				l_primary_speciality_code = "TB";

				l_app_msg = "Practitioner Primary Speciality Code : " + l_primary_speciality_code;
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				params.put("PRIMARY_SPECIALITY_CODE", l_primary_speciality_code);			
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

				l_app_msg = "::: Fetching Practitioner Qualification ::: ";
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

				JSONArray qualification_array = (JSONArray)json.get("qualification");

				System.out.print("qualification_array"+qualification_array);

				for(int i=0; i<qualification_array.size(); i++) { 
					JSONObject jsonObj1	= null;
					JSONObject jsonObj2 = null;
					JSONObject jsonObj3 = null;
					JSONObject jsonObj4 = null;

					if(qualification_array.size()>0){
						jsonObj1 = (JSONObject) qualification_array.get(0);
						JSONObject l_code = (JSONObject) jsonObj1.get("code");
						JSONObject l_period = (JSONObject) jsonObj1.get("period");
						JSONObject l_issuer = (JSONObject) jsonObj1.get("issuer");
						
						if(l_code.isEmpty()){
							l_errcd="E";
							return l_errcd+"#" + returnQualifyTextFinalMessage;
						}else{
							l_qualify_text = l_code.get("text").toString();
						}
						if(l_period.isEmpty()){
							l_errcd="E";
							return l_errcd+"#" + returnQualifyPeriodFinalMessage;
						}else{
							l_qualify_period = l_period.get("start").toString();
						}
						if(l_issuer.isEmpty()){
							l_errcd="E";
							return l_errcd+"#" + returnQualifyIssuerFinalMessage;
						}else{
							l_qualify_issuer = l_issuer.get("display").toString();
						}
						
						l_app_msg = "Practitioner Degree_1: " + l_qualify_text;
						if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
						params.put("DEGREE_1", l_qualify_text);

						l_app_msg = "Practitioner Degree_1 Year: " + l_qualify_period;
						if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
						params.put("DEGREE_1_YEAR", l_qualify_period);

						l_app_msg = "Practitioner Degree_1 College/University: " + l_qualify_issuer;
						if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
						params.put("DEGREE_1_UNIV", l_qualify_issuer);
					
					}

					if(qualification_array.size()>1){
						jsonObj2 = (JSONObject) qualification_array.get(1); 
							
						JSONObject l_code = (JSONObject) jsonObj2.get("code");
						JSONObject l_period = (JSONObject) jsonObj2.get("period");
						JSONObject l_issuer = (JSONObject) jsonObj2.get("issuer");
												
						if(l_code.isEmpty()){
							l_errcd="E";
							return l_errcd+"#" + returnQualifyTextFinalMessage;
						}else{
							l_qualify_text = l_code.get("text").toString();
						}
						if(l_period.isEmpty()){
							l_errcd="E";
							return l_errcd+"#" + returnQualifyPeriodFinalMessage;
						}else{
							l_qualify_period = l_period.get("start").toString();
						}
						if(l_issuer.isEmpty()){
							l_errcd="E";
							return l_errcd+"#" + returnQualifyIssuerFinalMessage;
						}else{
							l_qualify_issuer = l_issuer.get("display").toString();
						}

						l_app_msg = "Practitioner Degree_2: " + l_qualify_text;
						if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
						params.put("DEGREE_2", l_qualify_text);

						l_app_msg = "Practitioner Degree_2 Year: " + l_qualify_period;
						if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
						params.put("DEGREE_2_YEAR", l_qualify_period);

						l_app_msg = "Practitioner Degree_2 College/University: " + l_qualify_issuer;
						if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
						params.put("DEGREE_2_UNIV", l_qualify_issuer);
					}

					if(qualification_array.size()>2){
						jsonObj3 = (JSONObject) qualification_array.get(2);
						JSONObject l_code = (JSONObject) jsonObj3.get("code");
						JSONObject l_period = (JSONObject) jsonObj3.get("period");
						JSONObject l_issuer = (JSONObject) jsonObj3.get("issuer");

						if(l_code.isEmpty()){
							l_errcd="E";
							return l_errcd+"#" + returnQualifyTextFinalMessage;
						}else{
							l_qualify_text = l_code.get("text").toString();
						}
						if(l_period.isEmpty()){
							l_errcd="E";
							return l_errcd+"#" + returnQualifyPeriodFinalMessage;
						}else{
							l_qualify_period = l_period.get("start").toString();
						}
						if(l_issuer.isEmpty()){
							l_errcd="E";
							return l_errcd+"#" + returnQualifyIssuerFinalMessage;
						}else{
							l_qualify_issuer = l_issuer.get("display").toString();
						}

						l_app_msg = "Practitioner Degree_3: " + l_qualify_text;
						if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
						params.put("DEGREE_3", l_qualify_text);

						l_app_msg = "Practitioner Degree_3 Year: " + l_qualify_period;
						if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
						params.put("DEGREE_3_YEAR", l_qualify_period);

						l_app_msg = "Practitioner Degree_3 College/University: " + l_qualify_issuer;
						if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
						params.put("DEGREE_3_UNIV", l_qualify_issuer);
					}

					if(qualification_array.size()>3){
						jsonObj4 = (JSONObject) qualification_array.get(3);
						JSONObject l_code = (JSONObject) jsonObj4.get("code");
						JSONObject l_period = (JSONObject) jsonObj4.get("period");
						JSONObject l_issuer = (JSONObject) jsonObj4.get("issuer");

						if(l_code.isEmpty()){
							l_errcd="E";
							return l_errcd+"#" + returnQualifyTextFinalMessage;
						}else{
							l_qualify_text = l_code.get("text").toString();
						}
						if(l_period.isEmpty()){
							l_errcd="E";
							return l_errcd+"#" + returnQualifyPeriodFinalMessage;
						}else{
							l_qualify_period = l_period.get("start").toString();
						}
						if(l_issuer.isEmpty()){
							l_errcd="E";
							return l_errcd+"#" + returnQualifyIssuerFinalMessage;
						}else{
							l_qualify_issuer = l_issuer.get("display").toString();
						}

						l_app_msg = "Practitioner Degree_4: " + l_qualify_text;
						if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
						params.put("DEGREE_4", l_qualify_text);

						l_app_msg = "Practitioner Degree_4 Year: " + l_qualify_period;
						if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
						params.put("DEGREE_4_YEAR", l_qualify_period);

						l_app_msg = "Practitioner Degree_4 College/University: " + l_qualify_issuer;
						if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
						params.put("DEGREE_4_UNIV", l_qualify_issuer);
					}
				}//for loop
			}

			if(l_errcd.equals("N")){

				JSONArray telecom_array = (JSONArray)json.get("telecom");

				System.out.println("telecom_array--"+telecom_array);
				
				l_app_msg = "::: Fetching Telecom ::: ";
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

				System.out.println("telecom_array.size()--"+telecom_array.size());
				
				for(int i=0; i<telecom_array.size(); i++) {
					JSONObject jsonObj = (JSONObject) telecom_array.get(i);
					String telecom_system = (String) jsonObj.get("system");

					System.out.println("telecom_system--"+telecom_system);
					
					if(telecom_system !=null){
						if("phone".equals(telecom_system)){
							l_phone = (String) jsonObj.get("value");
							
							System.out.println("l_phone--"+l_phone);
							
							
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
			
			l_app_msg = "IQVIA Practitioner  Params ...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg+" :::::: "+params);	

			l_app_msg = "Inserting Params Practitioner into the table ..";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			returnFinalMessage = insertPractitioner(params);
			
		}catch(Exception e){
			e.printStackTrace();
			l_errcd="E";
		}	
		str = returnFinalMessage.split("#");	

		if("S".equals(str[0])){
			//l_status = "1";
			l_response_json.put("Status", str[0]);
			//l_response_json.put("Status", l_status);
			l_response_json.put("status_desc", str[1]);
			
			l_responseJsonString = objMapper.writeValueAsString(l_response_json);
			
			return str[0] +"#"+ l_responseJsonString;
			
		}else{
			//l_status = "0";
			l_response_json.put("Status", str[0]);
			//l_response_json.put("Status", l_status);
			l_response_json.put("status_desc", str[1]);
			
			l_responseJsonString = objMapper.writeValueAsString(l_response_json);
			
			return str[0] +"#"+ l_responseJsonString;
			
		}	

	} 

	public String insertPractitioner(Map<String,String> params){

		String l_app_msg = "";

		String finalMessage = StringUtils.EMPTY;

		l_app_msg = "::: Inside insertPratitioner  ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

		String practitionerId = "SELECT * FROM AM_PRACTITIONER WHERE PRACTITIONER_ID =" + "'" +params.get("PRACTITIONER_ID")+ "'";


		l_app_msg = "::: Inside insertPratitioner  practitionerId ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg+" :::: "+practitionerId);


		String practinsertstmt = "INSERT INTO AM_PRACTITIONER (PRACT_TYPE, PRACTITIONER_ID, PRACTITIONER_NAME, SHORT_NAME, " +
				"PRIMARY_SPECIALITY_CODE, GENDER, DATE_OF_BIRTH, EMPL_STATUS, EFF_STATUS, ADDED_AT_WS_NO, ADDED_FACILITY_ID, " +
				"MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, " +
				"DEGREE_1, DEGREE_1_YEAR, DEGREE_1_UNIV, DEGREE_2, DEGREE_2_YEAR, DEGREE_2_UNIV, " +
				"DEGREE_3, DEGREE_3_YEAR, DEGREE_3_UNIV, DEGREE_4, DEGREE_4_YEAR, DEGREE_4_UNIV, " +
				"MOBILE_NUM, EMAIL_ID, FAX_NUM, APC_NO) " +
				"VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,? ,?, ?) ";  

		l_app_msg = "::: Inside insertPratitioner  practinsertstmt ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg+" :::: "+practinsertstmt);


		Connection dbConn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmtForSelect = null;
		ResultSet rs = null;

		int insertCount = 0;
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

			l_app_msg = "::: Inside insertPratitioner  practitionerIdCount ::: ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg+" :::: "+practitionerIdCount);

			if(practitionerIdCount > 0 ){
				l_app_msg = "::: Inside insertPratitioner  PractitionerId already Exists ::: ";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg+" :::: "+params.get("PRACTITIONER_ID"));

				finalMessage = "Practitioner ID Already Exists";

			}
			else {

				pstmt = dbConn.prepareStatement(practinsertstmt);

				pstmt.setString(1, params.get("PRACT_TYPE"));
				l_app_msg = "::: Inserting the PRACT_TYPE ::: "+params.get("PRACT_TYPE");
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				pstmt.setString(2, params.get("PRACTITIONER_ID"));
				l_app_msg = "::: Inserting the PRACTITIONER_ID ::: "+params.get("PRACTITIONER_ID");
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				pstmt.setString(3, params.get("PRACTITIONER_NAME"));
				l_app_msg = "::: Inserting the PRACTITIONER_NAME ::: "+params.get("PRACTITIONER_NAME");
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				pstmt.setString(4, params.get("SHORT_NAME"));
				l_app_msg = "::: Inserting the SHORT_NAME ::: "+params.get("SHORT_NAME");
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				pstmt.setString(5, params.get("PRIMARY_SPECIALITY_CODE"));
				l_app_msg = "::: Inserting the PRIMARY_SPECIALITY_CODE ::: "+params.get("PRIMARY_SPECIALITY_CODE");
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				pstmt.setString(6, params.get("GENDER"));
				l_app_msg = "::: Inserting the GENDER ::: "+params.get("GENDER");
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				pstmt.setString(7, params.get("DATE_OF_BIRTH"));
				l_app_msg = "::: Inserting the DATE_OF_BIRTH ::: "+params.get("DATE_OF_BIRTH");
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				pstmt.setString(8, params.get("EMPL_STATUS"));
				l_app_msg = "::: Inserting the EMPL_STATUS ::: "+params.get("EMPL_STATUS");
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				pstmt.setString(9, params.get("EFF_STATUS"));
				l_app_msg = "::: Inserting the EFF_STATUS ::: "+params.get("EFF_STATUS");
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				pstmt.setString(10, params.get("ADDED_AT_WS_NO"));
				l_app_msg = "::: Inserting the ADDED_AT_WS_NO ::: "+params.get("ADDED_AT_WS_NO");
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				pstmt.setString(11, params.get("ADDED_FACILITY_ID"));
				l_app_msg = "::: Inserting the ADDED_FACILITY_ID ::: "+params.get("ADDED_FACILITY_ID");
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				pstmt.setString(12, params.get("MODIFIED_AT_WS_NO"));
				l_app_msg = "::: Inserting the MODIFIED_AT_WS_NO ::: "+params.get("MODIFIED_AT_WS_NO");
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				pstmt.setString(13, params.get("MODIFIED_FACILITY_ID"));
				l_app_msg = "::: Inserting the MODIFIED_FACILITY_ID ::: "+params.get("MODIFIED_FACILITY_ID");
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				pstmt.setString(14, params.get("DEGREE_1"));
				l_app_msg = "::: Inserting the DEGREE_1 ::: "+params.get("DEGREE_1");
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				pstmt.setString(15, params.get("DEGREE_1_YEAR"));
				l_app_msg = "::: Inserting the DEGREE_1_YEAR ::: "+params.get("DEGREE_1_YEAR");
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				pstmt.setString(16, params.get("DEGREE_1_UNIV"));
				l_app_msg = "::: Inserting the DEGREE_1_UNIV ::: "+params.get("DEGREE_1_UNIV");
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				pstmt.setString(17, params.get("DEGREE_2"));
				l_app_msg = "::: Inserting the DEGREE_2 ::: "+params.get("DEGREE_2");
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				pstmt.setString(18, params.get("DEGREE_2_YEAR"));
				l_app_msg = "::: Inserting the DEGREE_2_YEAR ::: "+params.get("DEGREE_2_YEAR");
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				pstmt.setString(19, params.get("DEGREE_2_UNIV"));
				l_app_msg = "::: Inserting the DEGREE_2_UNIV ::: "+params.get("DEGREE_2_UNIV");
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				pstmt.setString(20, params.get("DEGREE_3"));
				l_app_msg = "::: Inserting the DEGREE_3 ::: "+params.get("DEGREE_3");
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				pstmt.setString(21, params.get("DEGREE_3_YEAR"));
				l_app_msg = "::: Inserting the DEGREE_3_YEAR ::: "+params.get("DEGREE_3_YEAR");
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				pstmt.setString(22, params.get("DEGREE_3_UNIV"));
				l_app_msg = "::: Inserting the DEGREE_3_UNIV ::: "+params.get("DEGREE_3_UNIV");
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				pstmt.setString(23, params.get("DEGREE_4"));
				l_app_msg = "::: Inserting the DEGREE_4 ::: "+params.get("DEGREE_4");
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				pstmt.setString(24, params.get("DEGREE_4_YEAR"));
				l_app_msg = "::: Inserting the DEGREE_4_YEAR ::: "+params.get("DEGREE_4_YEAR");
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				pstmt.setString(25, params.get("DEGREE_4_UNIV"));
				l_app_msg = "::: Inserting the DEGREE_4_UNIV ::: "+params.get("DEGREE_4_UNIV");
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

				pstmt.setString(26, params.get("MOBILE_NUM"));
				l_app_msg = "::: Inserting the MOBILE_NUM ::: "+params.get("MOBILE_NUM");
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				
				pstmt.setString(27, params.get("EMAIL_ID"));
				l_app_msg = "::: Inserting the EMAIL_ID ::: "+params.get("EMAIL_ID");
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				
				pstmt.setString(28, params.get("FAX_NUM"));
				l_app_msg = "::: Inserting the FAX_NUM ::: "+params.get("FAX_NUM");
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
					
				pstmt.setString(29, params.get("APC_NO"));
				l_app_msg = "::: Inserting the APC_NO ::: "+params.get("APC_NO");
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				
				insertCount = pstmt.executeUpdate();

				if (insertCount == 1) {
					finalMessage = "Practitioner Record Inserted Successfully";
					l_errcd = "S";
					dbConn.commit();
				} else {
					finalMessage = "Error in Inserting the Practitioner record";
					l_errcd = "E";
					dbConn.rollback();
				}		
			}

		}catch (Exception exp) {
			l_err_code = "E";
			l_err_msg = exp.getMessage();
			exp.printStackTrace(System.err);
			System.out.println("(IqviaTransaction :: InsertPratitioner) Exception " + exp);
			return l_err_code + "#"+ l_err_msg;
		}		
		finally {
			XHUtil.closeDBResources(null, pstmt, null);
			EMDataSource.returnConnection(dbConn);
		}

	return l_errcd +"#"+ finalMessage;

	}
}
