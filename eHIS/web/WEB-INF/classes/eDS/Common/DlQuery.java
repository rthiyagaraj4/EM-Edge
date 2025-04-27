/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eDS.Common;

public class DlQuery {

	public static final String DL_DIET_TYPE = "INSERT INTO DS_DIET_TYPE(diet_type,long_desc,short_desc,age_group_code,"+
												"diet_category_code,default_feed_type,default_yn,diet_cycle_type,order_catalog_code,"+
			                                    "ip_diet_type_yn,dc_diet_type_yn,op_diet_type_yn,em_diet_type_yn,APPL_STAFF_ORDER_YN,APPL_ATT_YN,eff_status,added_by_id,added_date,added_facility_id,added_at_ws_no,modified_by_id,"+
												"modified_date,MODIFIED_FACILITY_ID,modified_at_ws_no) "+
												" values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)"; //ML-MMOH-CRF-0418 Modified aginst CRF-0419 & CRF-0820 & CRF-0670

	public static final String DL_DIET_UPDATE = "update DS_DIET_TYPE "+
												"set long_desc = ?, "+
												"short_desc = ?, "+
												"age_group_code = ?, "+
												"default_feed_type = ?, "+
												"default_yn = ?, "+
												"diet_cycle_type = ?, "+
												"ip_diet_type_yn = ?, "+//ML-MMOH-CRF-0820
												"dc_diet_type_yn = ?, "+//ML-MMOH-CRF-0820
												"op_diet_type_yn = ?, "+
												"em_diet_type_yn = ?, "+
												"APPL_STAFF_ORDER_YN = ?, "+
												"APPL_ATT_YN = ?, "+//ML-MMOH-CRF-0670
												"eff_status = ?, "+
												"modified_by_id = ?, "+
												"modified_date = sysdate, "+
												"MODIFIED_FACILITY_ID = ?, "+
												"modified_at_ws_no = ? "+
												"where diet_type = ? ";  //ML-MMOH-CRF-0418 Modified aginst CRF-0419

	public static final String DL_DIET_CHECK_PK = "SELECT COUNT(diet_type) FROM ds_diet_type WHERE diet_type = ?";


	public static final String DL_GET_MEAL_CLASS = 	"SELECT meal_class,long_desc,short_desc,eff_status, "+
													"APPL_STAFF_ORDER_YN, "+
													"EDIT_MENU_APPL_YN , "+
													"APPL_ATT_YN ,BED_CLASS_CODE FROM ds_meal_class "+
													"WHERE meal_class = ?";//ML-MMOH-CRF-0419-US8 ,ML-MMOH-CRF-0669-US1 and ML-MMOH-CRF-1005
													
	public static final String DL_PLACE_DIET_ORDER = "select distinct to_char(a.visit_Adm_Date_Time,'DD/MM/YYYY HH24:MI:SS'),a.encounter_Id,a.patient_Id,TRIM(m.patient_name) patient_name, m.sex, to_char(m.date_Of_Birth,'DD/MM/YYYY'),a.assign_Care_Locn_Type, a.assign_Care_Locn_Code, i.short_Desc,a.assign_Room_Num, a.assign_Bed_Num,a.patient_Class,a.discharge_date_time,a.adt_status,a.visit_adm_date_time vst_dt_tm, get_age (m.date_of_birth) || ' / ' || DECODE (m.sex, 'M', 'Male', 'F', 'Female', 'Unknown') age from Pr_Encounter a, Mp_Patient m,Mp_Episode_Type_Vw v, Ip_Nursing_Unit_Lang_Vw i,ds_epsd_diet_profile_hdr hdr,ds_epsd_dietician_referral ref"; //ML-MMOH-SCF-2366

	public static final String DL_INSERT_MEAL_CLASS = "INSERT INTO DS_MEAL_CLASS(MEAL_CLASS,LONG_DESC,SHORT_DESC,"+
														"EFF_STATUS,ADDED_BY_ID,ADDED_DATE,ADDED_FACILITY_ID,ADDED_AT_WS_NO,"+
														"MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_FACILITY_ID,MODIFIED_AT_WS_NO,APPL_STAFF_ORDER_YN,EDIT_MENU_APPL_YN,APPL_ATT_YN,BED_CLASS_CODE)"+
														" VALUES(?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?,?,?,?)"; //ML-MMOH-CRF-0419-US8 , ML-MMOH-CRF-0669-US1 and ML-MMOH-CRF-1005
													

	public static final String DL_UPDATE_MEAL_CLASS = 	"UPDATE ds_meal_class "+
														"SET LONG_DESC = ?, "+
														"SHORT_DESC = ?, "+
														"APPL_STAFF_ORDER_YN = ?, "+
														"EDIT_MENU_APPL_YN = ?, "+
														"APPL_ATT_YN = ? ,"+
														"EFF_STATUS = ?, "+
														"MODIFIED_BY_ID = ?, "+
														"MODIFIED_DATE = SYSDATE, "+
														"MODIFIED_FACILITY_ID = ?, "+
														"MODIFIED_AT_WS_NO = ? ,"+
														"BED_CLASS_CODE = ? "+
														"WHERE MEAL_CLASS = ? "; //ML-MMOH-CRF-0419-US8 and ML-MMOH-CRF-0669-US1 & CRF-673

	public static final String DL_MEAL_CLASS_CHECK_PK = "SELECT COUNT(meal_class) FROM ds_meal_class WHERE meal_class = ?";

	public static final String DL_GET_MEAL_TYPE = 	"SELECT meal_type,long_desc,short_desc,meal_order,opmealorder_yn,eff_status,em_meal_order_yn,suppl_diet_order_yn,st_meal_order_yn,SERVING_START_TIME,SERVING_END_TIME,IRREGULAR_START_TIME,IRREGULAR_END_TIME,IP_MEAL_ORDER_YN,DOC_MEAL_ORDER_YN,OPS_MEAL_ORDER_YN,ONC_MEAL_ORDER_YN,STF_MEAL_ORDER_YN,STU_MEAL_ORDER_YN,SERVING_START_TIME_OP,SERVING_END_TIME_OP,IRREGULAR_START_TIME_OP,IRREGULAR_END_TIME_OP,SERVING_START_TIME_EM,SERVING_END_TIME_EM,IRREGULAR_START_TIME_EM,IRREGULAR_END_TIME_EM,IRREGULAR_START_TIME_SUP,IRREGULAR_END_TIME_SUP,SERVING_START_TIME_SUP,SERVING_END_TIME_SUP,SERVING_START_TIME_DOC,SERVING_END_TIME_DOC,IRREGULAR_START_TIME_DOC,IRREGULAR_END_TIME_DOC,SERVING_START_TIME_ONC,SERVING_END_TIME_ONC,IRREGULAR_START_TIME_ONC,IRREGULAR_END_TIME_ONC,SERVING_START_TIME_OPS,SERVING_END_TIME_OPS,IRREGULAR_START_TIME_OPS,IRREGULAR_END_TIME_OPS,SERVING_START_TIME_STF,SERVING_END_TIME_STF,IRREGULAR_START_TIME_STF,IRREGULAR_END_TIME_STF,SERVING_START_TIME_STU,SERVING_END_TIME_STU,IRREGULAR_START_TIME_STU,IRREGULAR_END_TIME_STU "+
													"FROM ds_meal_type "+
													"WHERE meal_type = ?";//MMS-QH-CRF-0079 &ML-MMOH-CRF-0820 & CRF-1006 and Modified Against ML-MMOH-CRF-0825-US3

	/*public static final String DL_INSERT_MEAL_TYPE = 	"INSERT INTO ds_meal_type(MEAL_TYPE,LONG_DESC,SHORT_DESC,MEAL_ORDER,"+
														"EFF_STATUS,OPMEALORDER_YN,EM_MEAL_ORDER_YN,ADDED_BY_ID,ADDED_DATE,ADDED_FACILITY_ID,ADDED_AT_WS_NO,"+
														"MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_FACILITY_ID,MODIFIED_AT_WS_NO) "+
														" VALUES(?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";
	*/
	//ML_MMOH_CRF_0409 & MMS-QH-CRF-0079 & ML-MMOH-CRF-0820
	public static final String DL_INSERT_MEAL_TYPE = 	"INSERT INTO			ds_meal_type(MEAL_TYPE,LONG_DESC,SHORT_DESC,MEAL_ORDER,"+
														"EFF_STATUS,OPMEALORDER_YN,EM_MEAL_ORDER_YN,SUPPL_DIET_ORDER_YN,ST_MEAL_ORDER_YN,ADDED_BY_ID,ADDED_DATE,ADDED_FACILITY_ID,ADDED_AT_WS_NO,"+
														"MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_FACILITY_ID,MODIFIED_AT_WS_NO,SERVING_START_TIME,SERVING_END_TIME,IRREGULAR_START_TIME,IRREGULAR_END_TIME,IP_MEAL_ORDER_YN,DOC_MEAL_ORDER_YN,OPS_MEAL_ORDER_YN,ONC_MEAL_ORDER_YN,STF_MEAL_ORDER_YN,STU_MEAL_ORDER_YN, "+				
														"SERVING_START_TIME_OP,SERVING_END_TIME_OP,IRREGULAR_START_TIME_OP,IRREGULAR_END_TIME_OP,SERVING_START_TIME_EM,SERVING_END_TIME_EM,IRREGULAR_START_TIME_EM,IRREGULAR_END_TIME_EM,SERVING_START_TIME_SUP,SERVING_END_TIME_SUP,IRREGULAR_START_TIME_SUP,IRREGULAR_END_TIME_SUP,SERVING_START_TIME_DOC,SERVING_END_TIME_DOC,IRREGULAR_START_TIME_DOC,IRREGULAR_END_TIME_DOC,SERVING_START_TIME_ONC,SERVING_END_TIME_ONC,IRREGULAR_START_TIME_ONC,IRREGULAR_END_TIME_ONC,SERVING_START_TIME_OPS,SERVING_END_TIME_OPS,IRREGULAR_START_TIME_OPS,IRREGULAR_END_TIME_OPS,SERVING_START_TIME_STF,SERVING_END_TIME_STF,IRREGULAR_START_TIME_STF,IRREGULAR_END_TIME_STF,SERVING_START_TIME_STU,SERVING_END_TIME_STU,IRREGULAR_START_TIME_STU,IRREGULAR_END_TIME_STU)"+
														" VALUES(?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; //Modified Against ML-MOH-CRF-1006 & ML-MOH-CRF-825
				
	
	//ML_MMOH_CRF_0409
	public static final String DL_UPDATE_MEAL_TYPE = 	"UPDATE ds_meal_type "+
														"SET LONG_DESC = ?, "+
														"SHORT_DESC = ?, "+
														"MEAL_ORDER = ?, "+
														"EFF_STATUS = ?, "+
														"OPMEALORDER_YN = ?, "+
														"EM_MEAL_ORDER_YN = ?, "+
														"SUPPL_DIET_ORDER_YN = ?, "+//MMS-QH-CRF-0079
														"ST_MEAL_ORDER_YN = ?, "+//ML-MMOH-CRF-0820
														"MODIFIED_BY_ID = ?, "+
														"MODIFIED_DATE = SYSDATE, "+
														"MODIFIED_FACILITY_ID = ?, "+
														"MODIFIED_AT_WS_NO = ?, "+
														"SERVING_START_TIME=?, "+
														"SERVING_END_TIME=?, "+
														"IRREGULAR_START_TIME=?, "+
														"IRREGULAR_END_TIME=?, "+
														"IP_MEAL_ORDER_YN=?, "+
														"DOC_MEAL_ORDER_YN=?, "+
														"OPS_MEAL_ORDER_YN=?, "+
														"ONC_MEAL_ORDER_YN=?, "+
														"STF_MEAL_ORDER_YN=?, "+
														"STU_MEAL_ORDER_YN=?, "+
														"SERVING_START_TIME_OP=?, "+
														"SERVING_END_TIME_OP=?, "+
														"IRREGULAR_START_TIME_OP=?, "+
														"IRREGULAR_END_TIME_OP=?, "+
														"SERVING_START_TIME_EM=?, "+
														"SERVING_END_TIME_EM=?, "+
														"IRREGULAR_START_TIME_EM=?, "+
														"IRREGULAR_END_TIME_EM=?, "+
														"SERVING_START_TIME_SUP=?, "+
														"SERVING_END_TIME_SUP=?, "+
														"IRREGULAR_START_TIME_SUP=?, "+
														"IRREGULAR_END_TIME_SUP=?, "+
														"SERVING_START_TIME_DOC=?, "+
														"SERVING_END_TIME_DOC=?, "+
														"IRREGULAR_START_TIME_DOC=?, "+
														"IRREGULAR_END_TIME_DOC=?, "+
														"SERVING_START_TIME_OPS=?, "+
														"SERVING_END_TIME_OPS=?, "+
														"IRREGULAR_START_TIME_OPS=?, "+
														"IRREGULAR_END_TIME_OPS=?, "+
														"SERVING_START_TIME_ONC=?, "+
														"SERVING_END_TIME_ONC=?, "+
														"IRREGULAR_START_TIME_ONC=?, "+
														"IRREGULAR_END_TIME_ONC=?, "+
														"SERVING_START_TIME_STF=?, "+
														"SERVING_END_TIME_STF=?, "+
														"IRREGULAR_START_TIME_STF=?, "+
														"IRREGULAR_END_TIME_STF=?, "+
														"SERVING_START_TIME_STU=?, "+
														"SERVING_END_TIME_STU=?, "+
														"IRREGULAR_START_TIME_STU=?, "+
														"IRREGULAR_END_TIME_STU=? "+
														"WHERE MEAL_TYPE = ? "; //Modified Against ML-MOH-CRF-1006 and ML-MMOH-CRF-0825-US3

	public static final String DL_MEAL_TYPE_CHECK_PK = "SELECT COUNT(meal_type) FROM ds_meal_type WHERE meal_type = ?";

	public static final String DL_GET_ITEM_TYPE  = 		"SELECT item_type,long_desc,short_desc,comm_formula_yn,appl_diet_category,eff_status "+
														"FROM ds_item_type "+
														"WHERE item_type = ?";

	public static final String DL_INSERT_ITEM_TYPE = 	"INSERT INTO ds_item_type(ITEM_TYPE,LONG_DESC,SHORT_DESC,COMM_FORMULA_YN,"+
														"APPL_DIET_CATEGORY,EFF_STATUS,ADDED_BY_ID,ADDED_DATE,ADDED_FACILITY_ID,ADDED_AT_WS_NO,"+
														"MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_FACILITY_ID,MODIFIED_AT_WS_NO) "+
														" VALUES(?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";

	public static final String DL_UPDATE_ITEM_TYPE = 	"UPDATE ds_item_type "+
														"SET LONG_DESC = ?, "+
														"SHORT_DESC = ?, "+
														"COMM_FORMULA_YN = ?, "+
														"APPL_DIET_CATEGORY = ?, "+
														"EFF_STATUS = ?, "+
														"MODIFIED_BY_ID = ?, "+
														"MODIFIED_DATE = SYSDATE, "+
														"MODIFIED_FACILITY_ID = ?, "+
														"MODIFIED_AT_WS_NO = ? "+
														"WHERE ITEM_TYPE = ? ";

	public static final String DL_ITEM_TYPE_CHECK_PK = "SELECT COUNT(item_type) FROM ds_item_type WHERE item_type = ?";

	public static final String DL_DS_DIET_CATEGORY  =   "select diet_category_code code,description description "+
														" from ds_diet_category_lang_vw where language_id = ? "+
														" order by description";

	public static final String DL_GET_FEED_TYPE  = 		"SELECT feed_type,long_desc,short_desc,eff_status "+
														"FROM ds_feed_type "+
														"WHERE feed_type = ?";

	public static final String DL_INSERT_FEED_TYPE = 	"INSERT INTO ds_feed_type(FEED_TYPE,LONG_DESC,SHORT_DESC,"+
														"EFF_STATUS,ADDED_BY_ID,ADDED_DATE,ADDED_FACILITY_ID,ADDED_AT_WS_NO,"+
														"MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_FACILITY_ID,MODIFIED_AT_WS_NO) "+
														" VALUES(?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";

	public static final String DL_UPDATE_FEED_TYPE = 	"UPDATE ds_feed_type "+
														"SET LONG_DESC = ?, "+
														"SHORT_DESC = ?, "+
														"EFF_STATUS = ?, "+
														"MODIFIED_BY_ID = ?, "+
														"MODIFIED_DATE = SYSDATE, "+
														"MODIFIED_FACILITY_ID = ?, "+
														"MODIFIED_AT_WS_NO = ? "+
														"WHERE FEED_TYPE = ? ";

	public static final String DL_FEED_TYPE_CHECK_PK = "SELECT COUNT(feed_type) FROM ds_feed_type WHERE feed_type = ?";

	public static final String DL_GET_DELIVERY_INSTRUCTIONS  = 		"SELECT instr_code,long_desc,eff_status "+
																	"FROM ds_delivery_instr "+
																	"WHERE instr_code = ?";

	public static final String DL_INSERT_DELIVERY_INSTRUCTIONS = 	"INSERT INTO ds_delivery_instr(INSTR_CODE,LONG_DESC,"+
																	"EFF_STATUS,ADDED_BY_ID,ADDED_DATE,ADDED_FACILITY_ID,ADDED_AT_WS_NO,"+
																	"MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_FACILITY_ID,MODIFIED_AT_WS_NO) "+
																	" VALUES(?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";

	public static final String DL_UPDATE_DELIVERY_INSTRUCTIONS = 	"UPDATE ds_delivery_instr "+
																	"SET LONG_DESC = ?, "+
																	"EFF_STATUS = ?, "+
																	"MODIFIED_BY_ID = ?, "+
																	"MODIFIED_DATE = SYSDATE, "+
																	"MODIFIED_FACILITY_ID = ?, "+
																	"MODIFIED_AT_WS_NO = ? "+
																	"WHERE INSTR_CODE = ? ";

	public static final String DL_DELIVERY_INSTRUCTIONS_CHECK_PK = 	"SELECT COUNT(instr_code) FROM ds_delivery_instr "+
																	" WHERE instr_code = ?";

	public static final String DL_COMPLAINTS_CHECK_PK 	= 		"SELECT COUNT(complaint_code) FROM ds_complaints "+
																" WHERE complaint_code = ?";

	public static final String DL_GET_COMPLAINTS  		= 		"SELECT complaint_code,long_desc,short_desc,eff_status "+
																"FROM ds_complaints "+
																"WHERE complaint_code = ?";

	public static final String DL_INSERT_COMPLAINTS 	= 		"INSERT INTO ds_complaints(COMPLAINT_CODE,LONG_DESC,SHORT_DESC,"+
																"EFF_STATUS,ADDED_BY_ID,ADDED_DATE,ADDED_FACILITY_ID,ADDED_AT_WS_NO,"+
																"MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_FACILITY_ID,MODIFIED_AT_WS_NO) "+
																" VALUES(?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";

	public static final String DL_UPDATE_COMPLAINTS 	= 		"UPDATE ds_complaints "+
																"SET LONG_DESC = ?, "+
																"SHORT_DESC = ?, "+
																"EFF_STATUS = ?, "+
																"MODIFIED_BY_ID = ?, "+
																"MODIFIED_DATE = SYSDATE, "+
																"MODIFIED_FACILITY_ID = ?, "+
																"MODIFIED_AT_WS_NO = ? "+
																"WHERE COMPLAINT_CODE = ? ";

	public static final String DL_GET_DIET_CATEGORY  		= 	"SELECT diet_category_code,description,order_type_code "+
																"FROM ds_diet_category "+
																"WHERE diet_category_code = ?";

	public static final String DL_UPDATE_DIET_CATEGORY 	= 		"UPDATE ds_complaints "+
																"SET LONG_DESC = ?, "+
																"SHORT_DESC = ?, "+
																"EFF_STATUS = ?, "+
																"MODIFIED_BY_ID = ?, "+
																"MODIFIED_DATE = SYSDATE, "+
																"MODIFIED_FACILITY_ID = ?, "+
																"MODIFIED_AT_WS_NO = ? "+
																"WHERE COMPLAINT_CODE = ? ";


	public static final String DL_DS_DIET_TYPE  		= 	"SELECT diet_type,short_desc "+
															"FROM ds_diet_type "+
															"WHERE eff_status = 'E'";

	public static final String DL_DS_MEAL_CATEGORY  	= 	"SELECT meal_category_code,description "+
															"FROM DS_MEAL_CATEGORY ";

	public static final String DL_DS_MEAL_CLASS  		= 	"SELECT meal_class,short_desc "+
															"FROM ds_meal_class "+
															"WHERE eff_status = 'E'";

	public static final String DL_UPDATE_MEAL_CATEGORY 	= 	"UPDATE ds_meal_category "+
															"SET default_diet_type = ?, "+
															"default_meal_class = ?, "+
															"MODIFIED_BY_ID = ?, "+
															"MODIFIED_DATE = SYSDATE, "+
															"MODIFIED_FACILITY_ID = ?, "+
															"MODIFIED_AT_WS_NO = ? "+
															"WHERE description = ? ";

	public static final String DL_GET_MEAL_CATEGORY  	= 	"SELECT default_diet_type,default_meal_class "+
															"FROM ds_meal_category "+
															"WHERE description = ?";

	public static final String DL_DS_NURSING_UNIT  		=	"select nursing_unit_code,short_desc "+
															"from ip_nursing_unit_lang_vw where language_id = ? "+
															"and eff_status  ='E' and facility_id = ? order by short_desc";

	public static final String DL_GET_NUTRIENTS         =	"select nutrients_code,long_desc,short_desc,uom_code,"+
															"nutrient_conversion,energy_conversion,eff_status "+
															"from ds_nutrients_lang_vw "+
															"where language_id = ? "+
															"and nutrients_code = ? ";

	public static final String DL_INSERT_NUTRIENTS 	= 		"INSERT INTO ds_nutrients(NUTRIENTS_CODE,LONG_DESC,SHORT_DESC,"+
															"UOM_CODE,NUTRIENT_CONVERSION,ENERGY_CONVERSION,"+
															"EFF_STATUS,ADDED_BY_ID,ADDED_DATE,ADDED_FACILITY_ID,ADDED_AT_WS_NO,"+
															"MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_FACILITY_ID,MODIFIED_AT_WS_NO) "+
															" VALUES(?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";

	public static final String DL_UPDATE_NUTRIENTS 	= 		"UPDATE ds_nutrients "+
															"SET LONG_DESC = ?, "+
															"SHORT_DESC = ?, "+
															"UOM_CODE = ?, "+
															"NUTRIENT_CONVERSION = ?, "+
															"ENERGY_CONVERSION = ?, "+
															"EFF_STATUS = ?, "+
															"MODIFIED_BY_ID = ?, "+
															"MODIFIED_DATE = SYSDATE, "+
															"MODIFIED_FACILITY_ID = ?, "+
															"MODIFIED_AT_WS_NO = ? "+
															"WHERE NUTRIENTS_CODE = ? ";

	public static final String DL_DS_GET_UOM 	    =		"select uom_code,short_desc "+
															"from am_uom_lang_vw "+
															"where eff_status = 'E' and language_id = ? ";

	public static final String DL_NUTRIENTS_CHECK_PK 	= 	"SELECT COUNT(nutrients_code) FROM ds_nutrients "+
															" WHERE nutrients_code = ?";

	public static final String DL_GET_INGREDIENTS         =	"select ingredient_code,long_desc,short_desc,eff_status "+
															"from ds_ingredient "+
															"where ingredient_code = ? ";

	public static final String DL_INSERT_INGREDIENTS 	= 	"INSERT INTO ds_ingredient(INGREDIENT_CODE,LONG_DESC,SHORT_DESC,"+
															"STOCK_UOM_CODE,ITEM_CODE,"+
															"EFF_STATUS,ADDED_BY_ID,ADDED_DATE,ADDED_FACILITY_ID,ADDED_AT_WS_NO,"+
															"MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_FACILITY_ID,MODIFIED_AT_WS_NO) "+
															" VALUES(?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";

	public static final String DL_UPDATE_INGREDIENTS 	= 	"UPDATE ds_ingredient "+
															"SET LONG_DESC = ?, "+
															"SHORT_DESC = ?, "+
															"STOCK_UOM_CODE = ?, "+
															"ITEM_CODE = ?, "+
															"EFF_STATUS = ?, "+
															"MODIFIED_BY_ID = ?, "+
															"MODIFIED_DATE = SYSDATE, "+
															"MODIFIED_FACILITY_ID = ?, "+
															"MODIFIED_AT_WS_NO = ? "+
															"WHERE INGREDIENT_CODE = ? ";

	public static final String DL_INGREDIENTS_CHECK_PK 	= 	"SELECT COUNT(ingredient_code) FROM ds_ingredient "+
															" WHERE ingredient_code = ?";

	public static final String DL_GET_FOOD_ITEM       =		"select food_item_code,long_desc,short_desc,item_type,serving_uom_code, "+
															"calorific_cont_per_uom,prep_uom,prep_factor,prep_base_qty,eff_status "+
															"from ds_food_item_lang_vw "+
															"where language_id = ? and food_item_code = ? ";

	public static final String DL_DS_ITEM_TYPE       =		"select item_type,short_desc "+
															"from ds_item_type_lang_vw "+
															"where language_id = ? and eff_status = 'E' ";

	public static final String DL_INSERT_FOOD_ITEM 	= 		"INSERT INTO ds_food_item(food_item_code,long_desc,short_desc,"+
															"item_type,serving_uom_code,calorific_cont_per_uom,prep_uom,prep_factor,"+
															"prep_base_qty,EFF_STATUS,ADDED_BY_ID,ADDED_DATE,ADDED_FACILITY_ID,ADDED_AT_WS_NO,"+
															"MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_FACILITY_ID,MODIFIED_AT_WS_NO) "+
															" VALUES(?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";

	public static final String DL_UPDATE_FOOD_ITEM 	= 		"UPDATE ds_food_item "+
															"SET long_desc = ?, "+
															"short_desc = ?, "+
															"item_type = ?, "+
															"serving_uom_code = ?, "+
															"calorific_cont_per_uom = ?, "+
															"prep_uom = ?, "+
															"prep_factor = ?, "+
															"prep_base_qty = ?, "+
															"EFF_STATUS = ?, "+
															"MODIFIED_BY_ID = ?, "+
															"MODIFIED_DATE = SYSDATE, "+
															"MODIFIED_FACILITY_ID = ?, "+
															"MODIFIED_AT_WS_NO = ? "+
															"WHERE food_item_code = ? ";

	public static final String DL_GET_COM_FOOD_ITEM       =	"select comm_formula_code,long_desc,short_desc,item_type,"+
															"serving_uom_code,calorific_content_per_uom,prep_uom,"+
															"prep_factor,prep_base_qty,item_code,eff_status "+
															"from ds_comm_formula_lang_vw "+
															"where language_id = ? and comm_formula_code = ? ";


	public static final String DL_INSERT_COM_FOOD_ITEM 	= 	"INSERT INTO ds_comm_formula(comm_formula_code,long_desc,short_desc,"+
															"item_type,serving_uom_code,calorific_content_per_uom,prep_uom,"+
															"prep_factor,prep_base_qty,item_code,EFF_STATUS,ADDED_BY_ID,"+
															"ADDED_DATE,ADDED_FACILITY_ID,ADDED_AT_WS_NO,MODIFIED_BY_ID,"+
															"MODIFIED_DATE,MODIFIED_FACILITY_ID,MODIFIED_AT_WS_NO) "+
															" VALUES(?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";

	public static final String DL_UPDATE_COM_FOOD_ITEM 	= 	"UPDATE ds_comm_formula "+
															"SET long_desc = ?, "+
															"short_desc = ?, "+
															"serving_uom_code = ?, "+
															"calorific_content_per_uom = ?, "+
															"prep_uom = ?, "+
															"prep_factor = ?, "+
															"prep_base_qty = ?, "+
															"item_code = ?, "+
															"EFF_STATUS = ?, "+
															"MODIFIED_BY_ID = ?, "+
															"MODIFIED_DATE = SYSDATE, "+
															"MODIFIED_FACILITY_ID = ?, "+
															"MODIFIED_AT_WS_NO = ? "+
															"WHERE comm_formula_code = ? ";

	public static final String DL_DS_COM_ITEM_TYPE       =	"select item_type,short_desc "+
															"from ds_item_type_lang_vw "+
															"where language_id = ? and comm_formula_yn = 'Y' and eff_status = 'E' ";

	public static final String DL_DS_COM_NUTRIENTS		=	"select nutrients_code,short_desc from ds_nutrients_lang_vw "+
															"where language_id = ? and eff_status = 'E'";

	public static final String DL_DS_COM_NUTRIENTS_UOM	=	"select uom_code from ds_nutrients_lang_vw where language_id = ?"+
															" and nutrients_code = ?";

	public static final String DL_DS_COM_FORM_CODE		=	"select comm_formula_code,short_desc "+
															"from ds_comm_formula_lang_vw where language_id = ?";

	public static final String DL_COM_FOOD_ITEM_CHECK_PK 	= 	"SELECT COUNT(comm_formula_code) FROM ds_comm_formula "+
																" WHERE comm_formula_code = ?";

	public static final String DL_COM_NUT_LIST			=	"select comm.nutrient_code,nut.short_desc, comm.content_value, nut.uom_code "+
															"from ds_comm_formula_nutrients comm, ds_nutrients nut "+
															"where comm.nutrient_code = nut.nutrients_code "+
															"and nut.eff_status = 'E' and comm.comm_formula_code = ? "+
															"order by 1";

	public static final String DL_INSERT_COM_NUTRIENTS	= 	"insert into ds_comm_formula_nutrients(comm_formula_code,"+
															"nutrient_code,content_value,ADDED_BY_ID,ADDED_DATE,"+
															"ADDED_FACILITY_ID,ADDED_AT_WS_NO,MODIFIED_BY_ID,MODIFIED_DATE,"+
															"MODIFIED_FACILITY_ID,MODIFIED_AT_WS_NO) "+
															" values(?,?,?,?,sysdate,?,?,?,sysdate,?,?)";

	public static final String DL_UPDATE_COM_NUTRIENTS	= 	"update ds_comm_formula_nutrients "+
															"set content_value = ?, "+
															"MODIFIED_BY_ID = ?, "+
															"MODIFIED_DATE = SYSDATE, "+
															"MODIFIED_FACILITY_ID = ?, "+
															"MODIFIED_AT_WS_NO = ? "+
															"WHERE comm_formula_code = ? "+
															"AND nutrient_code = ?";

	public static final String DL_DEL_COM_NUTRIENTS		= 	"delete from ds_comm_formula_nutrients "+
															"WHERE comm_formula_code = ? "+
															"AND nutrient_code = ?";

	public static final String DL_FOOD_ITEM_CHECK_PK 	= 	"SELECT COUNT(food_item_code) FROM ds_food_item "+
															" WHERE food_item_code = ?";

	public static final String DL_GET_KITCHEN 			= 	"SELECT kitchen_code,long_desc,short_desc,eff_status "+
															"FROM ds_kitchens "+
															"WHERE kitchen_code = ? and operating_facility_id = ?";

	public static final String DL_INSERT_KITCHEN		= 	"INSERT INTO ds_kitchens(kitchen_code,LONG_DESC,SHORT_DESC,"+
															"EFF_STATUS,ADDED_BY_ID,ADDED_DATE,ADDED_FACILITY_ID,ADDED_AT_WS_NO,"+
															"MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_FACILITY_ID,MODIFIED_AT_WS_NO,operating_facility_id) "+
															" VALUES(?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?)";

	public static final String DL_UPDATE_KITCHEN 		= 	"UPDATE ds_kitchens "+
															"SET LONG_DESC = ?, "+
															"SHORT_DESC = ?, "+
															"EFF_STATUS = ?, "+
															"MODIFIED_BY_ID = ?, "+
															"MODIFIED_DATE = SYSDATE, "+
															"MODIFIED_FACILITY_ID = ?, "+
															"MODIFIED_AT_WS_NO = ? "+
															"WHERE kitchen_code = ? ";

	public static final String DL_KITCHEN_CHECK_PK 		= 	"SELECT COUNT(kitchen_code) FROM ds_kitchens WHERE kitchen_code = ?";

	public static final String DL_GET_KITCHEN_CODE 		= 	"SELECT kitchen_code,long_desc,short_desc "+
															"FROM ds_kitchens_lang_vw "+ 
															"WHERE language_id = ? "+
															"and operating_facility_id = ? "+
															"ORDER BY 3";	//(short_desc,order by 3) Added Against KDAH-350-CRF

	public static final String DL_INS_KITCHEN_AREA		=	"insert into ds_kitchen_area(operating_facility_id,kitchen_code,"+
															"kitchen_area_code,long_desc,short_desc,eff_status,ADDED_BY_ID,"+
															"ADDED_DATE,ADDED_FACILITY_ID,ADDED_AT_WS_NO,"+
															"MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_FACILITY_ID,MODIFIED_AT_WS_NO)"+
															" values(?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)";

	public static final String DL_UPD_KITCHEN_AREA		=	"UPDATE ds_kitchen_area "+
															"SET LONG_DESC = ?, "+
															"SHORT_DESC = ?, "+
															"EFF_STATUS = ?, "+
															"MODIFIED_BY_ID = ?, "+
															"MODIFIED_DATE = SYSDATE, "+
															"MODIFIED_FACILITY_ID = ?, "+
															"MODIFIED_AT_WS_NO = ? "+
															"WHERE kitchen_code = ? "+
															"AND kitchen_area_code = ?";

	//IN:39878 - Added by Abirami
	public static final String DL_DEL_KITCHEN_AREA_ITEMS=	"delete from ds_kitchen_area_items "+
															"where operating_facility_id = ? "+
															"AND kitchen_code = ? "+
															"AND kitchen_area_code = ?";
	public static final String DL_DEL_KITCHEN_AREA		=	"delete from ds_kitchen_area "+
															"where operating_facility_id = ? "+
															"AND kitchen_code = ? "+
															"AND kitchen_area_code = ?";


	public static final String DL_DS_FOOD_ITEM			= 	"select food_item_code,short_desc " +
															"from ds_food_item_lang_vw where language_id = ?" +
															" and eff_status = 'E' order by short_desc";

	public static final String DL_DS_GET_NUTRIENTS      =  	"select nutrients_code,short_desc from ds_nutrients";

	public static final String DL_DS_GET_NUTRIENTS_FOOD	=	"select food.food_item_code,food.nutrient_code,nutrients.short_desc,"+
															"food.content_value "+
															"from ds_food_item_nutrients food,ds_nutrients nutrients "+
															"where food.nutrient_code = nutrients.nutrients_code "+
															"and food.food_item_code = ? "+
															"order by food.food_item_code";

	public static final String DL_INS_NUTRIENTS_FOOD	=	"insert into ds_food_item_nutrients(food_item_code,nutrient_code,"+
															"content_value,ADDED_BY_ID,ADDED_DATE,ADDED_FACILITY_ID,ADDED_AT_WS_NO,"+
															"MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_FACILITY_ID,MODIFIED_AT_WS_NO) "+
															"values(?,?,?,?,sysdate,?,?,?,sysdate,?,?) ";

	public static final String DL_UPD_NUTRIENTS_FOOD	=	"update ds_food_item_nutrients "+
															"set content_value = ?, "+
															"MODIFIED_BY_ID = ?, "+
															"MODIFIED_DATE = SYSDATE, "+
															"MODIFIED_FACILITY_ID = ?, "+
															"MODIFIED_AT_WS_NO = ? "+
															"WHERE food_item_code = ? "+
															"AND nutrient_code = ?";

	public static final String DL_DEL_NUTRIENTS_FOOD	=	"delete from ds_food_item_nutrients "+
															"where food_item_code = ? "+
															"AND nutrient_code = ?";

	public static final String DL_GET_MEAL_ATTENDENTS	=	"select nursing_unit_code,dflt_patient_order_yn,deflt_attendents "+
															"from ds_nursing_unit_for_dflt_atten";

	public static final String DL_INSERT_MEAL_ATTENDENTS =	"insert into ds_nursing_unit_for_dflt_atten(facility_id,"+
															"meal_category_code,nursing_unit_code,dflt_patient_order_yn,"+
															"deflt_attendents,ADDED_BY_ID,ADDED_DATE,ADDED_FACILITY_ID,ADDED_AT_WS_NO,"+
															"MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_FACILITY_ID,MODIFIED_AT_WS_NO) "+
															"values(?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?) ";

	public static final String DL_UPDATE_MEAL_ATTENDENTS =	"update ds_nursing_unit_for_dflt_atten "+
															"set dflt_patient_order_yn = ?, "+
															"deflt_attendents = ?, "+
															"MODIFIED_BY_ID = ?, "+
															"MODIFIED_DATE = SYSDATE, "+
															"MODIFIED_FACILITY_ID = ?, "+
															"MODIFIED_AT_WS_NO = ? "+
															"WHERE nursing_unit_code = ? ";

	public static final String DL_DELETE_MEAL_ATTENDENTS =	"delete from ds_nursing_unit_for_dflt_atten "+
															"where facility_id = ? and "+
															"meal_category_code = ? and  "+
															"nursing_unit_code = ? ";

	public static final String DL_DS_MEAL_TYPE			=	"select meal_type, short_desc from ds_meal_type_lang_vw "+
															"where eff_status = 'E' and language_id = ? order by meal_order";

	public static final String DL_DS_GET_MENU			=	"select menu_code,short_desc from ds_menu_lang_vw "+
															"where language_id = ? and eff_status = 'E' and diet_type = ? and meal_class = ? and meal_type = ? ";
	
	public static final String DL_DS_GET_MENU_FOR_QUERY_CRITERIA			=	"select menu_code,short_desc from ds_menu_lang_vw "+
			"where language_id = ? and eff_status = 'E' ";	

	public static final String DL_GET_MENU_TIME_TABLE	=	"select kitchen_code,diet_type,meal_class,meal_type,day_no,menu_code,"+
															"eff_status from ds_diet_menu_time_table where kitchen_code = ? and "+
															"diet_type = ? and meal_class = ? and meal_type = ? and day_no = ? "+
															"and menu_code = ?";

	public static final String DL_GET_DAY_NO			=	"select menu_sched_cycle_days,meal_plan_ref_day_no "+
															"from ds_diet_menu_sched_cycle where diet_type = ? "+
															"and meal_class=?";

	public static final String DL_UPDATE_MENU_TIME_TAB	=	"UPDATE ds_diet_menu_time_table "+
															"set menu_code = ?, "+
															"eff_status = ?, "+
															"MODIFIED_BY_ID = ?, "+
															"MODIFIED_DATE = SYSDATE, "+
															"MODIFIED_FACILITY_ID = ?, "+
															"MODIFIED_AT_WS_NO = ? "+
															"where kitchen_code = ? and "+
															"diet_type = ? and "+
															"meal_class = ? and "+
															"meal_type = ? and "+
															"day_no = ? "; 

	public static final String DL_INSERT_MENU_CYCLE		=	"INSERT INTO "+
															"ds_diet_menu_sched_cycle(operating_facility_id, "+
															"diet_type,meal_class,menu_sched_cycle_days, "+
															"meal_plan_ref_date, meal_plan_ref_day_no, eff_status, "+
															"ADDED_BY_ID, ADDED_DATE, ADDED_FACILITY_ID, ADDED_AT_WS_NO, "+
															"MODIFIED_BY_ID, MODIFIED_DATE,  MODIFIED_FACILITY_ID, MODIFIED_AT_WS_NO) "+
															"values(?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)";  

	public static final String DL_UPDATE_MENU_CYCLE		=	"UPDATE ds_diet_menu_sched_cycle "+
															"set menu_sched_cycle_days = ?, "+
															"meal_plan_ref_day_no = ?, "+
															"meal_plan_ref_date = ?, "+
															"eff_status = ?, "+
															"MODIFIED_BY_ID = ?, "+
															"MODIFIED_DATE = SYSDATE, "+
															"MODIFIED_FACILITY_ID = ?, "+
															"MODIFIED_AT_WS_NO = ? "+
															"WHERE DIET_TYPE = ? "+
															"AND MEAL_CLASS = ? "; 

	public static final String  DL_INSERT_MENU_TIME_TAB =	"INSERT INTO ds_diet_menu_time_table(operating_facility_id,"+
															"kitchen_code,diet_type,meal_class,meal_type,menu_code,day_no,eff_status,"+
															"ADDED_BY_ID,ADDED_DATE,ADDED_FACILITY_ID,ADDED_AT_WS_NO,"+
															"MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_FACILITY_ID,MODIFIED_AT_WS_NO,PATIENT_CLASS) "+
															"values(?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?)";
															//Modified Against ML-MOH-CRF-1006-US6

	public static final String DL_MENU_TIME_CHECK_PK	=	"SELECT COUNT(KITCHEN_CODE) FROM DS_DIET_MENU_TIME_TABLE "+
															"WHERE operating_facility_id = ? AND KITCHEN_CODE = ? AND diet_type = ? AND "+
															"meal_class= ? AND MEAL_TYPE = ? AND DAY_NO = ?";

	public static final String 	DL_GET_MENU_CYCLE		=	"select diet_type,meal_class,menu_sched_cycle_days,"+
															"meal_plan_ref_day_no,MEAL_PLAN_REF_DATE,eff_status "+
															"from ds_diet_menu_sched_cycle where diet_type = ? "+
															" and meal_class = ? and operating_facility_id = ?";

	public static final String DL_MENU_CYCLE_PK_CHK		=	"SELECT COUNT(diet_type) FROM ds_diet_menu_sched_cycle "+
															"WHERE diet_type = ? AND meal_class = ? AND operating_facility_id = ?";

	public static final String DL_WARDS_KITCHEN_CODE	=	"select kitchen_code,short_desc from ds_kitchens_lang_vw "+
															"where language_id = ? and eff_status = 'E' and operating_facility_id = ?";

	public static final String DL_DS_INGREDIENT			=	"select ingredient_code,short_desc from ds_ingredient_lang "+
															"where language_id = ?";

	/* public static final String DL_FOOD_ITEM_INGREDIENT	=	"select ingredient_code,ingredient_qty,ingredient_uom,eff_status "+
															"from ds_food_item_ingredients where food_item_code = ?";
															 *///Commented Against PMG2017-COMN-CRF-0012.1-US004
	 public static final String DL_FOOD_ITEM_INGREDIENT	=	"select ingredient_code, ds_get_desc.ds_ingredient(ingredient_code,'en','2') ingredient_desc,ingredient_qty,ingredient_uom,am_get_desc.am_uom (ingredient_uom,'en', '2')serving_uom_desc,eff_status "+
															"from ds_food_item_ingredients where food_item_code = ?";//Modified Against PMG2017-COMN-CRF-0012.1-US004
 
	public static final String DL_FOOD_UOM_QTY			=	"select prep_uom,prep_base_qty from ds_food_item_lang_vw "+
															"where language_id = ? and food_item_code = ?";

	public static final String DL_UPDATE_RECPIE 		= 	"UPDATE ds_food_item_ingredients "+
															"SET ingredient_qty = ?, "+
															"ingredient_uom = ?, "+
															"eff_status = ?, "+
															"MODIFIED_BY_ID = ?, "+
															"MODIFIED_DATE = SYSDATE, "+
															"MODIFIED_FACILITY_ID = ?, "+
															"MODIFIED_AT_WS_NO = ? "+
															"WHERE food_item_code = ? " +
															"and ingredient_code = ?";

	public static final String DL_DELETE_RECPIE 		= 	"delete from ds_food_item_ingredients "+
															"where food_item_code = ? and "+
															"ingredient_code = ? ";

	public static final String DL_INSERT_RECPIE			=	"Insert into ds_food_item_ingredients(food_item_code,ingredient_code,"+
															"ingredient_qty,ingredient_uom,eff_status,ADDED_BY_ID,ADDED_DATE,"+
															"ADDED_FACILITY_ID,ADDED_AT_WS_NO,MODIFIED_BY_ID,MODIFIED_DATE,"+
															"MODIFIED_FACILITY_ID,MODIFIED_AT_WS_NO) values(?,?,?,?,?,?,"+
															"sysdate,?,?,?,sysdate,?,?)";

	public static final String DL_GET_MENU				=	"select menu_code,long_desc,short_desc,diet_type,meal_type,"+
															"meal_class,eff_from_date,eff_to_date,eff_status,patient_class from ds_menu_lang_vw "+
															"where language_id = ? and menu_code = ?";//Modified Against ML-MOH-CRF-1006-US5

	public static final String DL_GET_UOM_CODE			=	"select serving_uom_code from ds_items where language_id = ? "+
															"and item_type = ? and food_item_code = ?";

	public static final String DL_INSERT_MENU			=	"insert into ds_menu(menu_code,long_desc,short_desc,diet_type,meal_type,"+
															"meal_class,eff_status,eff_from_date,eff_to_date,added_by_id,"+
															"added_date,added_facility_id,added_at_ws_no,"+
															"modified_by_id,modified_date,modified_facility_id,modified_at_ws_no,PATIENT_CLASS) "+
															"values(?,?,?,?,?,?,?,?,to_date(?,'DD/MM/YYYY'),?,sysdate,?,?,?,sysdate,?,?,?)"; //Modified Against ML-MOH-CRF-1006-US5

	public static final String DL_INSERT_MENU_ITEM		=	"insert into ds_menu_item(menu_code,item_sl,item_type,item_code,item_qty,"+
															"added_by_id,added_date,added_facility_id,added_at_ws_no,"+
															"modified_by_id,modified_date,modified_facility_id,modified_at_ws_no) "+
															"values(?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)";

	public static final String DL_UPDATE_MENU 			= 	"UPDATE ds_menu "+
															"SET long_desc = ?, "+
															"short_desc = ?, "+
															"diet_type = ?, "+
															"meal_type = ?, "+
															"meal_class = ?, "+
															"eff_status = ?, "+
															"eff_from_date = ?, "+
															"eff_to_date = to_date(?,'DD/MM/YYYY'), "+
															"MODIFIED_BY_ID = ?, "+
															"MODIFIED_DATE = SYSDATE, "+
															"MODIFIED_FACILITY_ID = ?, "+
															"MODIFIED_AT_WS_NO = ?, "+
															"PATIENT_CLASS = ? "+
															"WHERE menu_code = ? "; //Modified Against ML-MOH-CRF-1006-US5

	public static final String DL_UPDATE_MENU_ITEM 		= 	"UPDATE ds_menu_item "+
															"SET item_qty = ?, "+
															"MODIFIED_BY_ID = ?, "+
															"MODIFIED_DATE = SYSDATE, "+
															"MODIFIED_FACILITY_ID = ?, "+
															"MODIFIED_AT_WS_NO = ? "+
															"WHERE menu_code = ? and item_type = ? and item_code = ?";

	public static final String DL_DELETE_MENU_ITEM 		= 	"delete from ds_menu_item "+
															"where menu_code = ? and item_type = ? and item_code = ? and item_sl = ? ";

	public static final String DL_MENU_CHECK_PK			=	"SELECT COUNT(menu_code) FROM ds_menu "+
															" WHERE menu_code = ?";

	//public static final String DL_GET_MENU_ITEM			=	"select item_sl,item_type,item_code,item_qty from / where menu_code = ?";
	/* public static final String DL_GET_MENU_ITEM			=	"select menuItem.item_sl,menuItem.item_type,menuItem.item_code,itm.short_desc,item_qty from ds_menu_item menuItem,ds_items itm where menu_code = ? and itm.food_item_code=menuItem.item_code and itm.item_type=menuItem.item_type and itm.eff_status = 'E' and language_id= ?"; */
	//Commented Aganist PMG2017-COMN-CRF-0012.1-US003
	public static final String DL_GET_MENU_ITEM			= "select menuItem.item_sl,menuItem.item_type,menuItem.item_code,itmty.short_desc Item_Type_SDes,itm.short_desc Item_SDes,item_qty from ds_menu_item menuItem,ds_items itm, ds_item_type itmty where menu_code = ? and itm.food_item_code=menuItem.item_code and itm.item_type=menuItem.item_type and itmty.item_type = menuitem.item_type and itm.eff_status = 'E' and language_id= ? order by menuitem.item_sl";//Modified Aganist PMG2017-COMN-CRF-0012.1-US003
	
	public static final String DL_INSERT_WARDS_FOR_KITCHEN			=	"insert into DS_WARDS_FOR_KITCHEN (ADDED_BY_ID, ADDED_DATE, ADDED_FACILITY_ID," +
																		"ADDED_AT_WS_NO, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_FACILITY_ID, MODIFIED_AT_WS_NO," +
																		"OPERATING_FACILITY_ID, KITCHEN_CODE, WARD_CODE) values (?, sysdate, ?, ?, ?, sysdate, ?, ?, ?, ?, ?)";

	public static final String DL_DELETE_WARDS_FOR_KITCHEN	=	"delete from DS_WARDS_FOR_KITCHEN where OPERATING_FACILITY_ID=? and KITCHEN_CODE=? and WARD_CODE=?";
	public static final String DL_DIET_CATEGORY = "select orOrderType.order_Type_Code,orOrderType.short_Desc from Or_Order_Type_Lang_Vw orOrderType where orOrderType.order_Category = ? and   orOrderType.language_Id like ? and orOrderType.eff_Status ='E' order by 2 ";
	
	public static final String DL_UPDATE_CATEGORY = "update DS_DIET_CATEGORY set DESCRIPTION=?, ADDED_BY_ID=?, ADDED_DATE=sysdate, ADDED_FACILITY_ID=?, ADDED_AT_WS_NO=?, ORDER_TYPE_CODE=? where DIET_CATEGORY_CODE=?";

	//CRF-230 changes
	//Insert Queries::
	/*public static final String DL_INSERT_OPMEALORDERHDR = "insert into DS_OP_DIET_ORDER_HDR(Facility_Id, Patient_Id, Encounter_Id, App_No, Serving_date, Kitchen, DietType, Remarks, Modified_YN, " +
															" ADDED_BY_ID, ADDED_DATE, ADDED_FACILITY_ID, ADDED_AT_WS_NO, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_FACILITY_ID, MODIFIED_AT_WS_NO) " +
															" values( ?,?,?,?,to_date(?,'DD/MM/YYYY'),?,?,?,?,?,sysdate,?,?,?,sysdate,?,? ) ";
															*/
	//vikash added for ds 417 crf
	public static final String DL_INSERT_OPMEALORDERHDR = "insert into DS_OP_DIET_ORDER_HDR(Facility_Id, Patient_Id, Encounter_Id, App_No, Serving_date, Kitchen, DietType, Remarks, Modified_YN, " +
			" ADDED_BY_ID, ADDED_DATE, ADDED_FACILITY_ID, ADDED_AT_WS_NO, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_FACILITY_ID, MODIFIED_AT_WS_NO,PREP_INSTR,MENU_TYPE) " +
			" values( ?,?,?,?,to_date(?,'DD/MM/YYYY'),?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?,? ) ";//CRF-0684-US006
	
	public static final String DL_INSERT_OPMEALORDERDTL = "insert into DS_OP_DIET_ORDER_DTL(Facility_Id, Patient_Id, Encounter_Id, App_No, Serving_date, MealType, DietType, Status, Acknowledge_Date_Time, "+
															" ADDED_BY_ID, ADDED_DATE, ADDED_FACILITY_ID, ADDED_AT_WS_NO, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_FACILITY_ID, MODIFIED_AT_WS_NO,IRREGULAR_FLAG_YN)  "+
															" values( ?,?,?,?,to_date(?,'DD/MM/YYYY'),?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,? ) "; //Modidifed Against ML-MMOH-CRF-0825
	
	public static final String DL_INSERT_OPFOODDISLIKES = "insert into DS_PATIENT_OP_FOOD_DISLIKES(Facility_Id, Patient_Id, Encounter_Id, App_No, Item_Code, "+
															" ADDED_BY_ID, ADDED_DATE, ADDED_FACILITY_ID, ADDED_AT_WS_NO, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_FACILITY_ID, MODIFIED_AT_WS_NO) " + 
															" values( ?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)";
	
	public static final String DL_INSERT_OPSPLITEMS = "insert into DS_OP_DIET_SPL_ITEMS(Facility_Id, Patient_Id, Encounter_Id, App_No, Item_Type, Item_Code, Quantity, Meal_Type, " +
															" ADDED_BY_ID, ADDED_DATE, ADDED_FACILITY_ID, ADDED_AT_WS_NO, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_FACILITY_ID, MODIFIED_AT_WS_NO) " +
															" values( ?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,? ) ";
	
	//Delete Queries::
	public static final String DL_DELETE_OPMEALORDERDTL_APPT = "Delete from DS_OP_DIET_ORDER_DTL where  Facility_Id = ? and App_No = ?";
	
	public static final String DL_DELETE_OPMEALORDERDTL_ENCT = "Delete from DS_OP_DIET_ORDER_DTL where  Facility_Id = ? and Encounter_Id = ?";
	
//	public static final String DL_DELETE_OPMEALORDERDTL = "Delete from DS_OP_DIET_ORDER_DTL where  Facility_Id = ? and Encounter_Id = ? and App_No = ?";
	
//	public static final String DL_DELETE_OPFOODDISLIKES = "Delete from DS_PATIENT_OP_FOOD_DISLIKES where Facility_Id = ? and Encounter_Id = ? and App_No = ? ";
	
	public static final String DL_DELETE_OPFOODDISLIKES_APPT = "Delete from DS_PATIENT_OP_FOOD_DISLIKES where Facility_Id = ? and App_No = ? ";
	
	public static final String DL_DELETE_OPFOODDISLIKES_ENCT = "Delete from DS_PATIENT_OP_FOOD_DISLIKES where Facility_Id = ? and Encounter_Id = ? ";
	
	//public static final String DL_DELETE_OPSPLITEMS     = "Delete from DS_OP_DIET_SPL_ITEMS where Facility_Id = ? and Encounter_Id = ? and App_No = ? ";
	
	public static final String DL_DELETE_OPSPLITEMS_APPT     = "Delete from DS_OP_DIET_SPL_ITEMS where Facility_Id = ? and App_No = ? ";
	
	public static final String DL_DELETE_OPSPLITEMS_ENCT     = "Delete from DS_OP_DIET_SPL_ITEMS where Facility_Id = ? and Encounter_Id = ? ";
	
	//Update Queries::
	public static final String DL_UPDATE_OPMEALORDERHDR = "update DS_OP_DIET_ORDER_HDR set DietType = ?, Remarks = ?, Modified_YN = ? "+
			"where Facility_Id = ? and Encounter_Id = ? and App_No = ? and Kitchen = ? ";
	
	/*public static final String DL_UPDATE_OPMEALORDERHDR_APPT = "update DS_OP_DIET_ORDER_HDR set DietType = ?, Remarks = ?, Modified_YN = ? "+
															"where Facility_Id = ? and  App_No = ? and Kitchen = ? ";
															*/
	public static final String DL_UPDATE_OPMEALORDERHDR_APPT = "update DS_OP_DIET_ORDER_HDR set DietType = ?, Remarks = ?, Modified_YN = ?,PREP_INSTR=?, MENU_TYPE=? "+
			"where Facility_Id = ? and  App_No = ? and Kitchen = ? ";//vikash added for crf 417 and //CRF-0684-US006
			
/*	public static final String DL_UPDATE_OPMEALORDERHDR_ENCT = "update DS_OP_DIET_ORDER_HDR set DietType = ?, Remarks = ?, Modified_YN = ? "+
															"where Facility_Id = ? and Encounter_Id = ? and Kitchen = ? ";*/
	public static final String DL_UPDATE_OPMEALORDERHDR_ENCT = "update DS_OP_DIET_ORDER_HDR set DietType = ?, Remarks = ?, Modified_YN = ?,PREP_INSTR=?,MENU_TYPE=? "+
			"where Facility_Id = ? and Encounter_Id = ? and Kitchen = ? ";//vikash added for crf 417 and //CRF-0684-US006
	
	public static final String DL_UPDATE_OPMEALORDERDTL_APPT = "update DS_OP_DIET_ORDER_DTL set status = ?, ACKNOWLEDGE_DATE_TIME = to_date(?,'DD/MM/YYYY hh24:mi')"+
			"where Facility_Id = ? and  App_No = ? and MealType= ? and trunc(SERVING_DATE) = to_date(?, 'dd/mm/yyyy')"; 
	
	public static final String DL_UPDATE_OPMEALORDERDTL_ENCT = "update DS_OP_DIET_ORDER_DTL set status = ?, ACKNOWLEDGE_DATE_TIME = to_date(?,'DD/MM/YYYY hh24:mi') "+
			"where Facility_Id = ? and Encounter_Id = ? and MealType= ? and trunc(SERVING_DATE) = to_date(?, 'dd/mm/yyyy')";

	public static final String DL_INSERT_SPECIALITIES_FOR_KITCHEN			=	"insert into DS_SPECIALITY_FOR_KITCHEN (ADDED_BY_ID, ADDED_DATE, ADDED_FACILITY_ID," +
			"ADDED_AT_WS_NO, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_FACILITY_ID, MODIFIED_AT_WS_NO," +
			"OPERATING_FACILITY_ID, KITCHEN_CODE, SPECIALITY_CODE) values (?, sysdate, ?, ?, ?, sysdate, ?, ?, ?, ?, ?)";

public static final String DL_DELETE_SPECIALITIES_FOR_KITCHEN	=	"delete from DS_SPECIALITY_FOR_KITCHEN where OPERATING_FACILITY_ID=? and KITCHEN_CODE=? and SPECIALITY_CODE=?";

public static final String DS_SPECIALITIES	=	"select distinct speciality_code, short_desc from Am_Speciality_lang_vw where language_id=? order by short_desc";

//CRF-412 changes
//Insert Queries::
/*public static final String DL_INSERT_EMMEALORDERHDR = "insert into DS_EM_DIET_ORDER_HDR(Facility_Id, Patient_Id, Encounter_Id, Serving_date, Kitchen, Diet_Type, Remarks, Modified_YN, " +
														" ADDED_BY_ID, ADDED_DATE, ADDED_FACILITY_ID, ADDED_AT_WS_NO, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_FACILITY_ID, MODIFIED_AT_WS_NO) " +
														" values( ?,?,?,to_date(?,'DD/MM/YYYY'),?,?,?,?,?,sysdate,?,?,?,sysdate,?,? ) ";
*/
public static final String DL_INSERT_EMMEALORDERHDR = "insert into DS_EM_DIET_ORDER_HDR(Facility_Id, Patient_Id, Encounter_Id, Serving_date, Kitchen, Diet_Type, Remarks, Modified_YN, " +
		" ADDED_BY_ID, ADDED_DATE, ADDED_FACILITY_ID, ADDED_AT_WS_NO, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_FACILITY_ID, MODIFIED_AT_WS_NO, PREP_INSTR, MENU_TYPE) " +
		" values( ?,?,?,to_date(?,'DD/MM/YYYY'),?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?,?) ";//CRF-417 & //CRF-0684-US006

public static final String DL_INSERT_EMMEALORDERDTL = "insert into DS_EM_DIET_ORDER_DTL(Facility_Id, Patient_Id, Encounter_Id, Serving_date, Meal_Type, Diet_Type, Status, Acknowledge_Date_Time, "+
														" ADDED_BY_ID, ADDED_DATE, ADDED_FACILITY_ID, ADDED_AT_WS_NO, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_FACILITY_ID, MODIFIED_AT_WS_NO, IRREGULAR_FLAG_YN)  "+
														" values( ?,?,?,to_date(?,'DD/MM/YYYY'),?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,? )"; //Modified Against ML-MOH-CRF-825

public static final String DL_INSERT_EMFOODDISLIKES = "insert into DS_PATIENT_EM_FOOD_DISLIKES(Facility_Id, Patient_Id, Encounter_Id, Item_Code, "+
														" ADDED_BY_ID, ADDED_DATE, ADDED_FACILITY_ID, ADDED_AT_WS_NO, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_FACILITY_ID, MODIFIED_AT_WS_NO) " + 
														" values( ?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)";

public static final String DL_INSERT_EMSPLITEMS = "insert into DS_EM_DIET_SPL_ITEMS(Facility_Id, Patient_Id, Encounter_Id, Item_Type, Item_Code, Quantity, Meal_Type, " +
														" ADDED_BY_ID, ADDED_DATE, ADDED_FACILITY_ID, ADDED_AT_WS_NO, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_FACILITY_ID, MODIFIED_AT_WS_NO) " +
														" values( ?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,? ) ";

/*
public static final String DL_UPDATE_EMMEALORDERHDR = "update DS_EM_DIET_ORDER_HDR set Diet_Type = ?, Remarks = ?, Modified_YN = ? "+
		"where Facility_Id = ? and Encounter_Id = ? and Kitchen = ? ";
*/
public static final String DL_UPDATE_EMMEALORDERHDR = "update DS_EM_DIET_ORDER_HDR set Diet_Type = ?, Remarks = ?, Modified_YN = ?,PREP_INSTR=? , MENU_TYPE=? "+
		"where Facility_Id = ? and Encounter_Id = ? and Kitchen = ? ";//CRF-417 and CRF-0684
		
public static final String DL_DELETE_EMMEALORDERDTL = "Delete from DS_EM_DIET_ORDER_DTL where Facility_Id = ? and Encounter_Id = ? ";

public static final String DL_DELETE_EMFOODDISLIKES = "Delete from DS_PATIENT_EM_FOOD_DISLIKES where Facility_Id = ? and Encounter_Id = ? ";

public static final String DL_DELETE_EMSPLITEMS     = "Delete from DS_EM_DIET_SPL_ITEMS where Facility_Id = ? and Encounter_Id = ? ";

public static final String DL_UPDATE_EMMEALORDERDTL= "update DS_EM_DIET_ORDER_DTL set status = ?, ACKNOWLEDGE_DATE_TIME = to_date(?,'DD/MM/YYYY hh24:mi') "+
		"where Facility_Id = ? and Encounter_Id = ? and Meal_Type= ? and trunc(SERVING_DATE) = to_date(?, 'dd/mm/yyyy')";

//ML-MMOH-CRF-412 Starts here
    public static final String DL_GET_TEXTURE_OF_DIET = "SELECT texture_of_diet,long_desc,short_desc,eff_status "+
													"FROM ds_texture_of_diet "+
													"WHERE texture_of_diet = ?";

	public static final String DL_INSERT_TEXTURE_OF_DIET = 	"INSERT INTO ds_texture_of_diet(TEXTURE_OF_DIET,LONG_DESC,SHORT_DESC,"+
														"EFF_STATUS,ADDED_BY_ID,ADDED_DATE,ADDED_FACILITY_ID,ADDED_AT_WS_NO,"+
														"MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_FACILITY_ID,MODIFIED_AT_WS_NO) "+
														" VALUES(?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";

	public static final String DL_UPDATE_TEXTURE_OF_DIET = 	"UPDATE ds_texture_of_diet "+
														"SET LONG_DESC = ?, "+
														"SHORT_DESC = ?, "+
														"EFF_STATUS = ?, "+
														"MODIFIED_BY_ID = ?, "+
														"MODIFIED_DATE = SYSDATE, "+
														"MODIFIED_FACILITY_ID = ?, "+
														"MODIFIED_AT_WS_NO = ? "+
														"WHERE TEXTURE_OF_DIET = ? ";

	public static final String DL_TEXTURE_OF_DIET_CHECK_PK = "SELECT COUNT(texture_of_diet) FROM ds_texture_of_diet WHERE texture_of_diet = ?";
//ML-MMOH-CRF-412 Ends here	
	//MMS-QH-CRF-0079
	public static final String DL_WARDS_FOR_KITCHEN_SETUP="select count(*) from Ds_Wards_Kitchen_Vw where operating_Facility_Id = ? and  NURSING_UNIT_CODE=? and linked_yn = 'Y'";

	public static final String DL_WARD_LIST ="select nursing_unit_code,short_Desc from DS_WARDS_KITCHEN_VW  where LINKED_YN='Y' and  operating_facility_id =?";

	public static final String DL_MEAL_TYPE_LIST ="select meal_type,short_Desc from ds_meal_type_lang_vw where LANGUAGE_ID =? ORDER BY 2"; // Modified Against KDAH-CRF-350
	//MMS-QH-CRF-0079-US11
	
	//ML-MMOH-CRF-0419-US001 Starts Here
	public static final String DL_GET_DIET_REQUEST_LOCATION_CODE = 	"SELECT location_code,long_desc,short_desc,eff_status,DEFAULT_DIET_REQUEST_LOCATION "+
																	"FROM ds_diet_request_loc "+
																	"WHERE location_code = ?";
													
	public static final String DL_INSERT_DIET_REQUEST_LOCATION_CODE = 	"INSERT INTO            					ds_diet_request_loc(LOCATION_CODE,LONG_DESC,SHORT_DESC,DEFAULT_DIET_REQUEST_LOCATION,"+
																		"EFF_STATUS,ADDED_BY_ID,ADDED_DATE,ADDED_FACILITY_ID,ADDED_AT_WS_NO,"+
																		"MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_FACILITY_ID,MODIFIED_AT_WS_NO) "+
																		" VALUES(?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";
														
													
    public static final String DL_UPDATE_DIET_REQUEST_LOCATION_CODE = 	"UPDATE ds_diet_request_loc "+
																		"SET LONG_DESC = ?, "+
																		"SHORT_DESC = ?, "+
																		"DEFAULT_DIET_REQUEST_LOCATION = ?, "+
																		"EFF_STATUS = ?, "+
																		"MODIFIED_BY_ID = ?, "+
																		"MODIFIED_DATE = SYSDATE, "+
																		"MODIFIED_FACILITY_ID = ?, "+
																		"MODIFIED_AT_WS_NO = ? "+
																		"WHERE LOCATION_CODE = ? ";

	public static final String DL_DIET_REQUEST_LOCATION_CODE_CHECK_PK = "SELECT COUNT(LOCATION_CODE) FROM ds_diet_request_loc WHERE LOCATION_CODE = ?";

	//ML-MMOH-CRF-0419-US001 Ends Here

//ML-MMOH-CRF-0684-US001 Starts Here
	public static final String DL_GET_MENU_TYPE = 	"SELECT MENU_TYPE,long_desc,short_desc,eff_status, "+
													"DEFAULT_YN, "+
													"APPL_FOR_IP_YN, APPL_FOR_OP_YN,"+
													"APPL_FOR_EM_YN, "+
													"APPL_FOR_STAFF_YN FROM ds_menu_type "+
													"WHERE MENU_TYPE = ?";							

	public static final String DL_INSERT_MENU_TYPE = "INSERT INTO			ds_menu_type(MENU_TYPE,LONG_DESC,SHORT_DESC,DEFAULT_YN,"+
							"APPL_FOR_IP_YN,APPL_FOR_OP_YN,APPL_FOR_EM_YN,APPL_FOR_STAFF_YN,"+
							"EFF_STATUS,ADDED_BY_ID,ADDED_DATE,ADDED_FACILITY_ID,ADDED_AT_WS_NO,"+
							"MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_FACILITY_ID,MODIFIED_AT_WS_NO)"+
							" VALUES(?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";	

	public static final String DL_UPDATE_MENU_TYPE = 	"UPDATE ds_menu_type "+
														"SET LONG_DESC = ?, "+
														"SHORT_DESC = ?, "+
														"DEFAULT_YN = ?, "+
														"APPL_FOR_IP_YN = ?, "+
														"APPL_FOR_OP_YN = ?, "+
														"APPL_FOR_EM_YN = ?, "+
														"APPL_FOR_STAFF_YN = ?, "+
														"EFF_STATUS = ?, "+
														"MODIFIED_BY_ID = ?, "+
														"MODIFIED_DATE = SYSDATE, "+
														"MODIFIED_FACILITY_ID = ?, "+
														"MODIFIED_AT_WS_NO = ? "+
														"WHERE MENU_TYPE = ? ";

	public static final String DL_MENU_TYPE_CHECK_PK = "SELECT COUNT(menu_type) FROM ds_menu_type WHERE menu_type = ?";
	//ML-MMOH-CRF-0684-US001 Ends Here	
	//KDAH-CRF-0680
	public static final String DL_DS_MENU_TYPE = "SELECT menu_type,short_desc FROM Ds_Menu_Type WHERE eff_status = 'E'";
	//KDAH-CRF-0680
	//KDAH-CRF-351
	public static final String DL_DS_FEED_TYPE = "SELECT feed_Type,short_desc FROM Ds_Feed_Type WHERE eff_status = 'E'";
	//KDAH-CRF-351
	// Added Against Start KDAH-CRF-350
	public static final String DL_AM_PATIENT_CLASS = "SELECT PATIENT_CLASS,SHORT_DESC FROM AM_PATIENT_CLASS_LANG_VW WHERE LANGUAGE_ID= ? ORDER BY 2";
	
	public static final String DL_MEAL_CLASS_VW = "SELECT MEAL_CLASS,SHORT_DESC FROM DS_MEAL_CLASS_LANG_VW WHERE LANGUAGE_ID= ? ORDER BY 2";
	public static final String DL_DIET_TYPE_VW = "SELECT DIET_TYPE,SHORT_DESC FROM DS_DIET_TYPE_LANG_VW WHERE LANGUAGE_ID= ? ORDER BY 2";
	// Added Against End KDAH-CRF-350
	
	public static final String DL_ITEM_TYPE_DESC = "select short_desc item_Type_Desc from ds_item_type where item_type=?";
	// Added Against PMG2017-COMN-CRF-0012.1-US003
	
	public static final String DL_INGREDIENT_DESC = "select short_desc ingredient_Desc from ds_ingredient where ingredient_code=?";
	// Added Against PMG2017-COMN-CRF-0012.1-US004 
}