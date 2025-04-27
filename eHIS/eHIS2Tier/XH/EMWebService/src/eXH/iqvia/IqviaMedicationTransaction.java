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
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import eXH.util.EMDataSource;
import eXH.util.XHUtil;

public class IqviaMedicationTransaction
{
	public static String l_debug_YN = "N";

	public String l_errcd = "N", l_field_separator = "$!^";
	public String l_errmsg = "";

	String l_in_JSON = "";

	String l_app_msg = "",l_status_desc = "";
	
	public String MedicationInsertTransRequestMethod(String applicationId, String actionKey) 
			throws ParseException, java.text.ParseException, JsonGenerationException, JsonMappingException, IOException{
		
		String l_status = "", l_responseJsonString = "";
		String[] str = null;
		Map<String, Object> l_response_json = new LinkedHashMap<String, Object>();
		ObjectMapper objMapper = new ObjectMapper();

		l_app_msg = "::: Inside IQVIA MedicationInsertDetails ::: ";
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
		
		String l_interface="INTERFACE", l_facility_id = "DF";
		
		String l_app_msg = "";
		String l_alpha_code1="" ,l_item_code_orig="",l_item_code1="",l_sole_source_yn="Y";
		int insertCount= 0;

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
		
		l_app_msg = "::: Inside IQVIA MedicationInsertDetails Request ::: ";
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg); 


		l_app_msg = "::: Inside IQVIA MedicationInsertDetails Application ID ::: "+applicationId;
		if (l_debug_YN.equals("Y"))	
			System.out.println(l_app_msg);		


		l_app_msg = "::: Inside IQVIA MedicationInsertDetails Action Key ::: "+actionKey;
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
						l_item_code_orig=(String) json_Obj.get("code");
						
						params.put("PK_VALUE", l_item_code_orig);
						
						l_item_code=l_item_code_orig.toUpperCase();
					
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
						
	//					
					/*	params.put("ITEM_CODE", l_item_code);		
						insertItem(params); */
						
					try{
						
						String query1 = "SELECT COUNT(*) AS n FROM XH_OTH_APPL_DATA_SKEY WHERE EXT_PK_ID = ? ";
						dbConn = EMDataSource.getConnection();
						
						l_app_msg = " ::: Reading in XH_OTH_APPL_DATA_SKEY::: EXT_PK_ID ::: "+l_item_code_orig;
						if (l_debug_YN.equals("Y"))
							System.out.println(l_app_msg);
						
						pstmt = dbConn.prepareStatement(query1);
						
						if (l_debug_YN.equals("Y")) System.out.println(" ::: Query 1 ::: "+query1);
						pstmt.setString(1,l_item_code_orig);
						rs = pstmt.executeQuery();
						rs.next();
						if (rs.getInt("n") == 0)
						{
							String query2=" INSERT INTO XH_OTH_APPL_DATA_SKEY (TABLE_ID, APPLICATION_ID, PK_VALUE, DESC1_VALUE, DESC2_VALUE, DESC3_VALUE,ADDED_BY_ID,"+
									" ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, " +
									"MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,EXT_PK_ID, OUTBOUND_YN)" +
									" VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
							dbConn = EMDataSource.getConnection();
							pstmt = dbConn.prepareStatement(query2);
							
							pstmt.setString(1,"MM_ITEM");
							pstmt.setString(2,"IQVIA");
							pstmt.setString(3,params.get("ITEM_CODE"));
							pstmt.setString(4,params.get("LONG_DESC"));
							pstmt.setString(5,params.get("SHORT_DESC"));
							pstmt.setString(6,params.get("SHORT_DESC"));
							pstmt.setString(7,l_interface);
							pstmt.setTimestamp(8,new java.sql.Timestamp(System.currentTimeMillis()));
							pstmt.setString(9,l_interface);
							pstmt.setString(10,l_facility_id);
							pstmt.setString(11,l_interface);
							pstmt.setTimestamp(12,new java.sql.Timestamp(System.currentTimeMillis()));
							pstmt.setString(13,l_interface);
							pstmt.setString(14,l_facility_id);
							pstmt.setString(15,params.get("PK_VALUE"));
							pstmt.setString(16,"X");
							
							l_app_msg = " ::: Reading in XH_OTH_APPL_DATA_SKEY::: EXT_PK_ID ::: "+l_item_code_orig;
							if (l_debug_YN.equals("Y"))
								System.out.println(l_app_msg);
							
							insertCount = pstmt.executeUpdate();
							
							if (insertCount == 1) {
				
								l_app_msg = ":::Inside insertion into  XH_OTH_APPL_DATA_SKEY inserted successfully::: ";
								if (l_debug_YN.equals("Y")) System.out.println(l_app_msg+" :::: "+params.get("PK_VALUE"));
								
								dbConn.commit();
							} else {
								
								l_app_msg = ":::Inside insertion into  XH_OTH_APPL_DATA_SKEY inserted successfully::: ";
								if (l_debug_YN.equals("Y")) System.out.println(l_app_msg+" :::: "+params.get("PK_VALUE"));
								
								dbConn.rollback();
							}	
						}
					}catch (Exception e) {   
						
						l_errcd = "E";
						l_status_desc = "Exception in "+l_app_msg+ " - "+e.getMessage();
						System.out.println(l_status_desc);
						
						return l_status_desc;
						
					}
					finally {
						EMDataSource.returnConnection(dbConn);
						XHUtil.closeDBResources(rs, pstmt, null);
					}
					
	//				
						
						
					}
				
				  }
				
				l_app_msg = "Item Code ::::" + l_item_code + "::::External Item Code:"+l_item_code_orig ;
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
								System.out.println("Strength fetched");
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
				
				l_app_msg = "HSN NO : " + l_hsn_no;
				if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
				params.put("HSN_NO", l_hsn_no);	
			}    */
			
			params.put("ADDED_BY_ID", l_interface);
			params.put("ADDED_AT_WS_NO", l_interface);
			params.put("ADDED_FACILITY_ID", l_facility_id);
			params.put("MODIFIED_BY_ID", l_interface);
			params.put("MODIFIED_AT_WS_NO", l_interface);
			params.put("MODIFIED_FACILITY_ID", l_facility_id);
			
			l_app_msg = "IQVIA Medication  Params ...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg+" :::::: "+params);	

			l_app_msg = "Inserting Params Medication into the table ..";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			returnFinalMessage = insertMedication(params);	
			
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
	
/*	
	public void insertItem(Map<String,String> params)
	{
		String l_item_code1="";
		String itemCode1 = "SELECT * FROM XH_OTH_APPL_DATA_SKEY WHERE PK_VALUE =" + "'" +params.get("PK_VALUE")+ "'";
		
		l_app_msg = "::: Inside Insert Medication itemCode into XH_OTH_APPL_DATA_SKEY ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg+" :::: "+params.get("PK_VALUE"));
		
		Connection dbConn1 = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmtForSelect1 = null;
		ResultSet rs1 = null;

		int insertCount1 = 0;
		int medicationIdCount1 = 0;
		
		
		
		try
		{
			dbConn1 = EMDataSource.getConnection();

			pstmtForSelect1 = dbConn1.prepareStatement(itemCode1, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			String medicationinsertstmt1=" INSERT INTO XH_OTH_APPL_DATA_SKEY (TABLE_ID, APPLICATION_ID, PK_VALUE, DESC1_VALUE, DESC2_VALUE, DESC3_VALUE,ADDED_BY_ID,"+
									" ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, " +
									"MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,EXT_PK_ID, OUTBOUND_YN)" +
									" VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
			rs1 = pstmtForSelect1.executeQuery();
			
			if (rs1 == null) 
			{
				rs1.last();   
				medicationIdCount1 = rs1.getRow();
			}
			
			l_app_msg = "::: Inside insertMedication  medicationIdCount ::: ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg+" :::: "+medicationIdCount1);
			
			if(medicationIdCount1 > 0 ){
				l_app_msg = "::: Inside insertMedication  ItemCode already Exists ::: ";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg+" :::: "+params.get("ITEM_CODE"));

								
			l_app_msg = ":::ItemCode Already Exists  XH_OTH_APPL_DATA_SKEY ::: ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg+" :::: "+params.get("PK_VALUE"));

			}
			else
			{	
				pstmt1 = dbConn1.prepareStatement(medicationinsertstmt1);
				
				pstmt1.setString(1,"MM_ITEM");
				pstmt1.setString(2,"IQVIA");
				pstmt1.setString(3,params.get("ITEM_CODE"));
				pstmt1.setString(4,params.get("LONG_DESC"));
				pstmt1.setString(5,params.get("SHORT_DESC"));
				pstmt1.setString(6,"");
				pstmt1.setString(7,params.get("ADDED_BY_ID"));
				pstmt1.setTimestamp(8,new java.sql.Timestamp(System.currentTimeMillis()));
				pstmt1.setString(9,params.get("ADDED_AT_WS_NO"));
				pstmt1.setString(10, params.get("ADDED_FACILITY_ID"));
				pstmt1.setString(11,params.get("MODIFIED_BY_ID"));
				pstmt1.setTimestamp(12,new java.sql.Timestamp(System.currentTimeMillis()));
				pstmt1.setString(13, params.get("MODIFIED_AT_WS_NO"));
				pstmt1.setString(14, params.get("MODIFIED_FACILITY_ID"));
				pstmt1.setString(15,params.get("PK_VALUE"));
				pstmt1.setString(16,"X");
				
				l_app_msg = ":::Fetching l_item_code_orig ::: "+params.get("PK_VALUE");
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg+" :::: "+params.get("ITEM_CODE"));
				
										
				insertCount1 = pstmt1.executeUpdate();
				System.out.println("insert count"+insertCount1);
				if (insertCount1 == 1) {
					l_app_msg = ":::Inside insertion into  XH_OTH_APPL_DATA_SKEY inserted successfully::: ";
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg+" :::: "+params.get("PK_VALUE"));
					dbConn1.commit();
				} else {
					l_app_msg = ":::Inside insertion into  XH_OTH_APPL_DATA_SKEY inserted unsuccessfull::: ";
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg+" :::: "+params.get("PK_VALUE"));
					dbConn1.rollback();
				}	
			}
				
				
			}catch (Exception exp){}
		finally {
			XHUtil.closeDBResources(null, pstmt1, null);
			EMDataSource.returnConnection(dbConn1);
		}
		
	} */
	
	public String insertMedication(Map<String,String> params)
	{
		String l_app_msg = "";

		String finalMessage = StringUtils.EMPTY;

		l_app_msg = "::: Inside insertMedication  ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		String itemCode = "SELECT * FROM MM_ITEM WHERE ITEM_CODE =" + "'" +params.get("ITEM_CODE")+ "'";
		
		l_app_msg = "::: Inside Insert Medication itemCode ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg+" :::: "+itemCode);
		
		String medicationinsertstmt= " INSERT INTO MM_ITEM (ITEM_CODE, CATEGORY_TYPE_CODE, MATERIAL_GROUP_CODE, ALPHA_CODE, LONG_DESC, SHORT_DESC, " +
					"MANUFACTURER_ID, GEN_UOM_CODE, ITEM_CLASS_CODE, EFF_STATUS, HSN_NO,ADDED_BY_ID,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID," +
				"MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,SOLE_SOURCE_YN) " +
					" VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?,?,?,?) ";

		l_app_msg = "::: Inside insertMedication  medicationinsertstmt ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg+" :::: "+medicationinsertstmt);


		Connection dbConn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmtForSelect = null;
		ResultSet rs = null;

		int insertCount = 0;
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
			
			l_app_msg = "::: Inside insertMedication  medicationIdCount ::: ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg+" :::: "+medicationIdCount);
			
			if(medicationIdCount > 0 ){
				l_app_msg = "::: Inside insertMedication  ItemCode already Exists ::: ";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg+" :::: "+params.get("ITEM_CODE"));

				finalMessage = "ItemCode Already Exists";

			}
			else
			{
				pstmt = dbConn.prepareStatement(medicationinsertstmt);
				
				pstmt.setString(1, params.get("ITEM_CODE"));
				l_app_msg = "::: Inserting the ITEM_CODE ::: "+params.get("ITEM_CODE");
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				
				pstmt.setString(2, params.get("CATEGORY_TYPE_CODE"));
				l_app_msg = "::: Inserting the CATEGORY_TYPE_CODE ::: "+ params.get("CATEGORY_TYPE_CODE");
				if (l_debug_YN.equals("Y"))System.out.println(l_app_msg);
				
				pstmt.setString(3, params.get("MATERIAL_GROUP_CODE"));
				l_app_msg = "::: Inserting the MATERIAL_GROUP_CODE ::: "+ params.get("MATERIAL_GROUP_CODE");
				if (l_debug_YN.equals("Y"))System.out.println(l_app_msg);
				
				pstmt.setString(4, params.get("ALPHA_CODE"));
				l_app_msg = "::: Inserting the ALPHA_CODE ::: "+ params.get("ALPHA_CODE");
				if (l_debug_YN.equals("Y"))System.out.println(l_app_msg);
				
				pstmt.setString(5, params.get("LONG_DESC"));
				l_app_msg = "::: Inserting the LONG_DESC ::: "+ params.get("LONG_DESC");
				if (l_debug_YN.equals("Y"))System.out.println(l_app_msg);
				
				pstmt.setString(6, params.get("SHORT_DESC"));
				l_app_msg = "::: Inserting the SHORT_DESC ::: "+ params.get("SHORT_DESC");
				if (l_debug_YN.equals("Y"))System.out.println(l_app_msg);
				
				pstmt.setString(7, params.get("MANUFACTURER_ID"));
				l_app_msg = "::: Inserting the MANUFACTURER_ID ::: "+ params.get("MANUFACTURER_ID");
				if (l_debug_YN.equals("Y"))System.out.println(l_app_msg);
				
				pstmt.setString(8, params.get("GEN_UOM_CODE"));
				l_app_msg = "::: Inserting the GEN_UOM_CODE ::: "+ params.get("GEN_UOM_CODE");
				if (l_debug_YN.equals("Y"))System.out.println(l_app_msg);
				
				pstmt.setString(9, params.get("ITEM_CLASS_CODE"));
				l_app_msg = "::: Inserting the ITEM_CLASS_CODE ::: "+ params.get("ITEM_CLASS_CODE");
				if (l_debug_YN.equals("Y"))System.out.println(l_app_msg);
				
				pstmt.setString(10, params.get("EFF_STATUS"));
				l_app_msg = "::: Inserting the EFF_STATUS ::: "+ params.get("EFF_STATUS");
				if (l_debug_YN.equals("Y"))System.out.println(l_app_msg);
				
				pstmt.setString(11, params.get("HSN_NO"));
				l_app_msg = "::: Inserting the HSN_NO ::: "+ params.get("HSN_NO");
				if (l_debug_YN.equals("Y"))System.out.println(l_app_msg);
				
				pstmt.setString(12, params.get("ADDED_BY_ID"));
				l_app_msg = "::: Inserting the ADDED_BY_ID ::: "+ params.get("ADDED_BY_ID");
				if (l_debug_YN.equals("Y"))System.out.println(l_app_msg);
				
				pstmt.setString(13, params.get("ADDED_AT_WS_NO"));
				l_app_msg = "::: Inserting the ADDED_AT_WS_NO ::: "+ params.get("ADDED_AT_WS_NO");
				if (l_debug_YN.equals("Y"))System.out.println(l_app_msg);
				
				pstmt.setString(14, params.get("ADDED_FACILITY_ID"));
				l_app_msg = "::: Inserting the ADDED_FACILITY_ID ::: "+ params.get("ADDED_FACILITY_ID");
				if (l_debug_YN.equals("Y"))System.out.println(l_app_msg);
				
				pstmt.setString(15, params.get("MODIFIED_BY_ID"));
				l_app_msg = "::: Inserting the MODIFIED_BY_ID ::: "+ params.get("MODIFIED_BY_ID");
				if (l_debug_YN.equals("Y"))System.out.println(l_app_msg);
				
				pstmt.setString(16, params.get("MODIFIED_AT_WS_NO"));
				l_app_msg = "::: Inserting the MODIFIED_AT_WS_NO ::: "+ params.get("MODIFIED_AT_WS_NO");
				if (l_debug_YN.equals("Y"))System.out.println(l_app_msg);
				
				pstmt.setString(17, params.get("MODIFIED_FACILITY_ID"));
				l_app_msg = "::: Inserting the MODIFIED_FACILITY_ID ::: "+ params.get("MODIFIED_FACILITY_ID");
				if (l_debug_YN.equals("Y"))System.out.println(l_app_msg);
				
				pstmt.setString(18, params.get("SOLE_SOURCE_YN"));
				l_app_msg = "::: Inserting the SOLE_SOURCE_YN ::: "+ params.get("SOLE_SOURCE_YN");
				if (l_debug_YN.equals("Y"))System.out.println(l_app_msg);
				
				insertCount = pstmt.executeUpdate();
				
				if (insertCount == 1) {
					finalMessage = "Medication Record Inserted Successfully";
					l_errcd = "S";
					dbConn.commit();
				} else {
					finalMessage = "Error in Inserting the Medication record";
					l_errcd = "E";
					dbConn.rollback();
				}		
				
				
			}		
			
		}catch (Exception exp) {
			l_err_code = "E";
			l_err_msg = exp.getMessage();
			exp.printStackTrace(System.err);
			System.out.println("(IqviaTransaction :: InsertMedication) Exception " + exp);
			return l_err_code + "#"+ l_err_msg;
		}		
		finally {
			XHUtil.closeDBResources(null, pstmt, null);
			EMDataSource.returnConnection(dbConn);
		}
		return l_errcd +"#"+ finalMessage;
 

	}
}
