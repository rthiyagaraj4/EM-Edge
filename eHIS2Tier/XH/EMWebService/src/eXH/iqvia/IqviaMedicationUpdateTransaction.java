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
public class IqviaMedicationUpdateTransaction 
{
	public static String l_debug_YN = "N";

	public String l_errcd = "N", l_field_separator = "$!^";
	public String l_errmsg = "";

	String l_in_JSON = "";

	String l_app_msg = "";
	
	public String MedicationUpdateTransRequestMethod(String applicationId, String actionKey) 
			throws ParseException, java.text.ParseException, JsonGenerationException, JsonMappingException, IOException{
		
		String l_status = "", l_responseJsonString = "";
		String[] str = null;
		Map<String, Object> l_response_json = new LinkedHashMap<String, Object>();
		ObjectMapper objMapper = new ObjectMapper();
		
		l_app_msg = "::: Inside IQVIA MedicationUpdateDetails ::: ";
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg); 

		String returnFinalMessage = StringUtils.EMPTY;
		
		String returnItemCodeFinalMessage="The ItemCodecannot be blank";
		String returnLongDescFinalMessage="The Long Description cannot be blank";
		String returnManufacturerIdFinalMessage="The ManufacturerId cannot be blank";
		String returnEffStatusFinalMessage="The EffStatus cannot be blank";
		String returnAlphaCodeFinalMessage="The Alpha code cannot be blank";
		
		String l_item_code="",l_category_type_code="",l_Material_Group_Code="",l_alpha_code="",l_long_desc="", l_short_desc="",l_manufacturer_id="";
		String l_gen_uom_code="",l_item_class_code="",l_eff_status="";
		//String l_hsn_no="";
		
		String l_app_msg = "",l_alpha_code1="",l_item_code1="", l_sole_source_yn="Y";
	
		String l_interface="INTERFACE", l_facility_id = "DF";
		
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
		
		l_app_msg = "::: Inside IQVIA MedicationUpdateDetails Request ::: ";
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg); 
		
		l_app_msg = "::: Inside IQVIA MedicationUpdateDetails Application ID ::: "+applicationId;
		if (l_debug_YN.equals("Y"))	
			System.out.println(l_app_msg);	
		
		l_app_msg = "::: Inside IQVIA MedicationUpdateDetails Action Key ::: "+actionKey;
		if (l_debug_YN.equals("Y"))	
			System.out.println(l_app_msg);
		
		try
		{
			
			if(l_errcd.equals("N"))
			{
			
				JSONObject jsonObj=(JSONObject)json.get("code");
				JSONArray coding_array = (JSONArray)jsonObj.get("coding");
				
				l_app_msg = "::: Fetching Item Code ::: ";
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				
				for(int i=0; i<coding_array.size(); i++)
				{
					JSONObject json_Obj = (JSONObject) coding_array.get(i);
					String code_coding_code = (String) json_Obj.get("code");
					
					if(code_coding_code !=null)
					{
						l_item_code1=(String) json_Obj.get("code");
						
						l_item_code=l_item_code1.toUpperCase();
						
						if (l_item_code.equals(StringUtils.EMPTY) || l_item_code.equals(null))
						{
							l_errcd = "E";
							return l_errcd + "#"
									+ returnItemCodeFinalMessage;
						}
						else 
						{
							params.put("ITEM_CODE", l_item_code);
						}		
					}
				
				  }
				
				l_app_msg = "Item Code : " + l_item_code;
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				
			}
			
			if(l_errcd.equals("N"))
			{
				l_app_msg = "::: Fetching Category Type code ::: ";
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

				l_category_type_code =  "ST";
				
				l_app_msg = "Category Type code : " + l_category_type_code;
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				params.put("CATEGORY_TYPE_CODE", l_category_type_code);		
			}
			
			if(l_errcd.equals("N")){
				l_app_msg = "::: Fetching Material Group Code ::: ";
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

				l_Material_Group_Code=  "TB";
				
				l_app_msg = "Material Group Code : " + l_Material_Group_Code;
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				params.put("MATERIAL_GROUP_CODE", l_Material_Group_Code);		
			}
	
			
			if(l_errcd.equals("N"))
			{
				JSONObject jsonObj=(JSONObject)json.get("code");
				JSONArray coding_array = (JSONArray)jsonObj.get("coding");
				
				l_app_msg = "::: Fetching Alpha Code  ::: ";
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				
				for(int i=0; i<coding_array.size(); i++)
				{
					JSONObject json_Obj = (JSONObject) coding_array.get(i);
					String code_coding_code = (String) json_Obj.get("code");
					
					if(code_coding_code !=null)
					{
						 l_alpha_code1=(String) json_Obj.get("code");
						
						l_alpha_code= l_alpha_code1.replaceAll("[^a-zA-Z0-9]","");

						
						if (l_alpha_code.equals(StringUtils.EMPTY) || l_alpha_code.equals(null))
						{
							l_errcd = "E";
							return l_errcd + "#"
									+ returnAlphaCodeFinalMessage;
						}
						else 
						{
							params.put("ALPHA_CODE", l_alpha_code);
						}		
					}
				
				  }
				
				l_app_msg = "Alpha Code : " + l_alpha_code;
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
					
				
			}
			
			if(l_errcd.equals("N"))
			{
				JSONObject jsonObj=(JSONObject)json.get("code");
				JSONArray coding_array = (JSONArray)jsonObj.get("coding");
				
				l_app_msg = "::: Fetching Long Description ::: ";
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				
				for(int i=0; i<coding_array.size(); i++)
				{
					JSONObject json_Obj = (JSONObject) coding_array.get(i);
					String code_coding_display = (String) json_Obj.get("display");
					
					if(code_coding_display !=null)
					{
						l_long_desc=(String) json_Obj.get("display");
						
						if (l_long_desc.equals(StringUtils.EMPTY) || l_long_desc.equals(null))
						{
							l_errcd = "E";
							return l_errcd + "#"
									+ returnLongDescFinalMessage;
						}
						else 
						{
							params.put("LONG_DESC", l_long_desc);
						}		
					}
				
				  }

				l_app_msg = "Long Description : " + l_long_desc;
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				
			}
			
			if(l_errcd.equals("N"))
			{
				JSONObject jsonObj=(JSONObject)json.get("code");
				JSONArray coding_array = (JSONArray)jsonObj.get("coding");
				
				l_app_msg = "::: Fetching Short Description ::: ";
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				
				for(int i=0; i<coding_array.size(); i++)
				{
					JSONObject json_Obj = (JSONObject) coding_array.get(i);
					String code_coding_display = (String) json_Obj.get("display");
					
					if(code_coding_display !=null)
					{
						l_short_desc=(String) json_Obj.get("display");
						
						if (l_long_desc.equals(StringUtils.EMPTY) || l_long_desc.equals(null))
						{
							l_errcd = "E";
							return l_errcd + "#"
									+ returnLongDescFinalMessage;
						}
						else 
						{
							params.put("SHORT_DESC", l_short_desc);
						}		
					}
				
				  }

				l_app_msg = "Short Description : " + l_short_desc;
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				
			}
			
			if(l_errcd.equals("N"))
			{
				JSONArray contained_array = (JSONArray)json.get("contained");
				
				l_app_msg = "::: Fetching MANUFACTURER ID ::: ";
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				
				for(int i=0; i<contained_array.size(); i++) 
				{
					JSONObject jsonObj = (JSONObject) contained_array.get(i);
					String contained_id = (String) jsonObj.get("id");
					
					if(contained_id !=null)
					{
						l_manufacturer_id=(String) jsonObj.get("id");
						
					}
						if (l_manufacturer_id.equals(StringUtils.EMPTY) || l_manufacturer_id.equals(null)) 
						{
							l_errcd = "E";
							return l_errcd + "#"
									+ returnManufacturerIdFinalMessage;
						} 
						else 
						{
							params.put("SOLE_SOURCE_YN", l_sole_source_yn);
							
							l_app_msg = "::: Fetching SOLE_SOURCE_YN ::: "+l_sole_source_yn;
							if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
							
							params.put("MANUFACTURER_ID", l_manufacturer_id);
							
						}				
				}
				
				l_app_msg = "MANUFACTURER ID : " + l_manufacturer_id;
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
						
			}
			
			if(l_errcd.equals("N"))
			{
				l_app_msg = "::: Fetching GEN UOM CODE ::: ";
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				
				JSONArray ingredient_array = (JSONArray)json.get("ingredient");
				
				System.out.print("ingredient_array"+ingredient_array);
				
				for(int i=0; i<ingredient_array.size(); i++) 
				{
					JSONObject jsonObj = (JSONObject) ingredient_array.get(i); 
					
					JSONObject itemCodeableConcept_object = (JSONObject) jsonObj.get("itemCodeableConcept");
					JSONArray coding_array = (JSONArray)itemCodeableConcept_object.get("coding");
					for(int j=0; j<coding_array.size();j++)
					{
						JSONObject jsonObj1= (JSONObject) coding_array.get(j);
						String display_desc = (String) jsonObj1.get("display");
						
						if(display_desc !=null)
						{
							if("Vancomycin Hydrochloride".equals(display_desc))
							{
								JSONObject ingredient_strength = (JSONObject) jsonObj.get("strength");
								JSONObject strength_numerator=(JSONObject)ingredient_strength.get("numerator");
								String numerator_code=(String) strength_numerator.get("code").toString().toUpperCase();
								JSONObject strength_denominator=(JSONObject)ingredient_strength.get("denominator");
								String denominator_code=(String) strength_denominator.get("code").toString().toUpperCase();
						
								l_gen_uom_code =numerator_code+denominator_code;
							}
						}
					}
					
				}
				
				l_app_msg = "GEN UOM CODE : " + l_gen_uom_code;
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				params.put("GEN_UOM_CODE", l_gen_uom_code);	
			
			}
			
			if(l_errcd.equals("N"))
			{
				l_app_msg = "::: Fetching ITEM CLASS CODE ::: ";
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

				l_item_class_code =  "TB";
				
				l_app_msg = "ITEM CLASS CODE : " + l_item_class_code;
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				params.put("ITEM_CLASS_CODE", l_item_class_code);	
			}
			
			if(l_errcd.equals("N")){
				l_app_msg = "::: Fetching Medication EFF Status ::: ";
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

				if(json.containsKey("status")){
					l_eff_status = json.get("status").toString();
				}else{
					l_errcd="E";
					return l_errcd+"#" + returnEffStatusFinalMessage;
				}
				
				if(l_eff_status.equals("active") || l_eff_status.equals("ACTIVE") || l_eff_status.equals("Active")  ){
					l_eff_status = "E";
				}else{
					l_eff_status = "D";
				}
				l_app_msg = "Medication EFF Status : " + l_eff_status;
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				params.put("EFF_STATUS", l_eff_status);	
				
			}
			
		/*	if(l_errcd.equals("N"))
			{
				l_app_msg = "::: Fetching HSN NO ::: ";
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);

				l_hsn_no =  "HS";
				
				l_app_msg = "HSN NO : " + l_item_class_code;
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				params.put("ITEM_CLASS_CODE", l_item_class_code);	
			} */
			
			params.put("ADDED_BY_ID", l_interface);
			params.put("ADDED_AT_WS_NO", l_interface);
			params.put("ADDED_FACILITY_ID", l_facility_id);
			params.put("MODIFIED_BY_ID", l_interface);
			params.put("MODIFIED_AT_WS_NO", l_interface);
			params.put("MODIFIED_FACILITY_ID", l_facility_id);
			
			l_app_msg = "IQVIA Medication  Params ...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg+" :::::: "+params);	

			l_app_msg = "Updating Params Medication into the table ..";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			returnFinalMessage = updateMedication(params);	
			
			
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
	
	public String updateMedication(Map<String,String> params)
	{
		String l_app_msg = ""; String medicationupdatestmt = StringUtils.EMPTY;

		String finalMessage = StringUtils.EMPTY;
		
		l_app_msg = "::: Inside Update Medication  ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

		String itemCode = "SELECT * FROM MM_ITEM WHERE ITEM_CODE =" + "'" +params.get("ITEM_CODE")+ "'";
		
		l_app_msg = "::: Inside Update Medication itemCodestment ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg+" :::: "+itemCode);
		
		
		medicationupdatestmt="UPDATE MM_ITEM SET CATEGORY_TYPE_CODE=?, MATERIAL_GROUP_CODE=?, ALPHA_CODE=?, LONG_DESC=?, SHORT_DESC=?, MANUFACTURER_ID=?, " +
				" GEN_UOM_CODE=?, ITEM_CLASS_CODE=?, EFF_STATUS=?, HSN_NO=?, ADDED_BY_ID=?,ADDED_AT_WS_NO=?,ADDED_FACILITY_ID=?,MODIFIED_BY_ID=?,"+
				" MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=?,SOLE_SOURCE_YN=?" +
				" WHERE ITEM_CODE=" + "'" +params.get("ITEM_CODE")+ "'";
				
		l_app_msg = "::: Inside Update Medication  medicationupdatestmt ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg+" :::: "+medicationupdatestmt);
		
		Connection dbConn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmtForSelect = null;
		ResultSet rs = null;

		int updateCount = 0;
		int medicationIdCount = 0;

		String l_err_code = "S", l_err_msg = "Success";
		
		try
		{
			dbConn = EMDataSource.getConnection();

			pstmtForSelect = dbConn.prepareStatement(itemCode, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			rs = pstmtForSelect.executeQuery();
			
			if (rs != null) 
			{
				rs.last();   
				medicationIdCount = rs.getRow();
			}

			l_app_msg = " ::: Inside Update Medication medicationIdCount ::: ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg+" :::: "+medicationIdCount);
			
			if (medicationIdCount == 0)
			{
				l_app_msg = " ::: Inside Update Medication ItemCode does not exist ::: ";
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg + " :::: "+ params.get("ITEM_CODE"));
				
				finalMessage = "Update not allowed, ItemCode does not exist";
			}
			else 
			{
				
				pstmt = dbConn.prepareStatement(medicationupdatestmt);
				
				pstmt.setString(1, params.get("CATEGORY_TYPE_CODE"));
				l_app_msg = "::: Updating the CATEGORY_TYPE_CODE ::: "+ params.get("CATEGORY_TYPE_CODE");
				if (l_debug_YN.equals("Y"))System.out.println(l_app_msg);
				
				pstmt.setString(2, params.get("MATERIAL_GROUP_CODE"));
				l_app_msg = "::: Updating the MATERIAL_GROUP_CODE ::: "+ params.get("MATERIAL_GROUP_CODE");
				if (l_debug_YN.equals("Y"))System.out.println(l_app_msg);
				
				pstmt.setString(3, params.get("ALPHA_CODE"));
				l_app_msg = "::: Updating the ALPHA_CODE ::: "+ params.get("ALPHA_CODE");
				if (l_debug_YN.equals("Y"))System.out.println(l_app_msg);
				
				pstmt.setString(4, params.get("LONG_DESC"));
				l_app_msg = "::: Updating the LONG_DESC ::: "+ params.get("LONG_DESC");
				if (l_debug_YN.equals("Y"))System.out.println(l_app_msg);
				
				pstmt.setString(5, params.get("SHORT_DESC"));
				l_app_msg = "::: Updating the SHORT_DESC ::: "+ params.get("SHORT_DESC");
				if (l_debug_YN.equals("Y"))System.out.println(l_app_msg);
				
				pstmt.setString(6, params.get("MANUFACTURER_ID"));
				l_app_msg = "::: Updating the MANUFACTURER_ID ::: "+ params.get("MANUFACTURER_ID");
				if (l_debug_YN.equals("Y"))System.out.println(l_app_msg);
				
				pstmt.setString(7, params.get("GEN_UOM_CODE"));
				l_app_msg = "::: Updating the GEN_UOM_CODE ::: "+ params.get("GEN_UOM_CODE");
				if (l_debug_YN.equals("Y"))System.out.println(l_app_msg);
				
				pstmt.setString(8, params.get("ITEM_CLASS_CODE"));
				l_app_msg = "::: Updating the ITEM_CLASS_CODE ::: "+ params.get("ITEM_CLASS_CODE");
				if (l_debug_YN.equals("Y"))System.out.println(l_app_msg);
				
				pstmt.setString(9, params.get("EFF_STATUS"));
				l_app_msg = "::: Updating the EFF_STATUS ::: "+ params.get("EFF_STATUS");
				if (l_debug_YN.equals("Y"))System.out.println(l_app_msg);
				
				pstmt.setString(10, params.get("HSN_NO"));
				l_app_msg = "::: Updating the HSN_NO ::: "+ params.get("HSN_NO");
				if (l_debug_YN.equals("Y"))System.out.println(l_app_msg);
				
				pstmt.setString(11, params.get("ADDED_BY_ID"));
				l_app_msg = "::: Inserting the ADDED_BY_ID ::: "+ params.get("ADDED_BY_ID");
				if (l_debug_YN.equals("Y"))System.out.println(l_app_msg);
				
				pstmt.setString(12, params.get("ADDED_AT_WS_NO"));
				l_app_msg = "::: Inserting the ADDED_AT_WS_NO ::: "+ params.get("ADDED_AT_WS_NO");
				if (l_debug_YN.equals("Y"))System.out.println(l_app_msg);
				
				pstmt.setString(13, params.get("ADDED_FACILITY_ID"));
				l_app_msg = "::: Inserting the ADDED_FACILITY_ID ::: "+ params.get("ADDED_FACILITY_ID");
				if (l_debug_YN.equals("Y"))System.out.println(l_app_msg);
				
				pstmt.setString(14, params.get("MODIFIED_BY_ID"));
				l_app_msg = "::: Inserting the MODIFIED_BY_ID ::: "+ params.get("MODIFIED_BY_ID");
				if (l_debug_YN.equals("Y"))System.out.println(l_app_msg);
				
				pstmt.setString(15, params.get("MODIFIED_AT_WS_NO"));
				l_app_msg = "::: Inserting the MODIFIED_AT_WS_NO ::: "+ params.get("MODIFIED_AT_WS_NO");
				if (l_debug_YN.equals("Y"))System.out.println(l_app_msg);
				
				pstmt.setString(16, params.get("MODIFIED_FACILITY_ID"));
				l_app_msg = "::: Inserting the MODIFIED_FACILITY_ID ::: "+ params.get("MODIFIED_FACILITY_ID");
				if (l_debug_YN.equals("Y"))System.out.println(l_app_msg);
				
				pstmt.setString(17, params.get("SOLE_SOURCE_YN"));
				l_app_msg = "::: Inserting the SOLE_SOURCE_YN ::: "+ params.get("SOLE_SOURCE_YN");
				if (l_debug_YN.equals("Y"))System.out.println(l_app_msg);
				
				updateCount = pstmt.executeUpdate();
				
				if (updateCount == 1) {
					finalMessage = "Medication Record Updated Successfully";
					l_errcd = "S";
					dbConn.commit();
				} else {
					finalMessage = "Error in Updating the Medication record";
					l_errcd = "E";
					dbConn.rollback();
				}
				
			}
			
		}catch (NullPointerException  npexp) {
			l_err_code = "E";
			l_err_msg = npexp.getMessage();
			npexp.printStackTrace(System.err);
			System.out.println("(IqviaTransaction :: UpdateMedication) Null Pointer Exception " + npexp);
			return l_err_code + "#"+ l_err_msg;
		}	
		catch (Exception exp) {
			l_err_code = "E";
			l_err_msg = exp.getMessage();
			exp.printStackTrace(System.err);
			System.out.println("(IqviaTransaction :: UpdateMedication) Exception " + exp);
			return l_err_code + "#"+ l_err_msg;
		}		
		finally {
			XHUtil.closeDBResources(null, pstmt, null);
			EMDataSource.returnConnection(dbConn);
		}
		return l_errcd +"#"+ finalMessage;


	}
}
