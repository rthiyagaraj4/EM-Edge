/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMM.Common ;

import eCommon.Common.* ;

//public interface MmInterface extends CommonInterface {
public abstract class MmInterface {
 
	/* SQL statements start */

	/* Queries for MM Material Group Starts */
	public static String SQL_MM_MTRL_GRP_CODE_EXISTS		=	" select count(*) count from mm_material_group where material_group_code = ? " ;
	public static String SQL_MM_MTRL_GRP_INSERT				=	" insert into mm_material_group ( material_group_code, long_desc, short_desc, eff_status, added_by_id, added_date, added_at_ws_no, added_facility_id,modified_by_id, modified_date, modified_at_ws_no, modified_facility_id ) values ( ?, ?, ?, ?, ?, SYSDATE, ?, ?, ?, SYSDATE, ?, ? )" ;
	public static String SQL_MM_MTRL_GRP_UPDATE				=	" update mm_material_group set long_desc = ?, short_desc = ?, eff_status = ?, modified_by_id = ?, modified_date = SYSDATE, modified_at_ws_no = ?, modified_facility_id = ? where material_group_code = ?" ;
	//public static final String SQL_MM_MTRL_GRP_QUERYCRIT	=	" select material_group_code, long_desc,short_desc,eff_status from mm_material_group where upper(material_group_code) like upper(?) and short_desc like upper(?) and eff_status like upper(?) ";
	/* Queries for MM Material Group Ends */

	/* Queries for MM Item Class Starts */
	public static String SQL_MM_ITEM_CLASS_CODE_EXISTS		=	" select count(*) count from mm_item_class where item_class_code = ? " ;
	public static String SQL_MM_ITEM_CLASS_INSERT			=	" insert into mm_item_class ( item_class_code, long_desc, short_desc, eff_status, appl_ss_yn, appl_st_yn, appl_po_yn, added_by_id, added_date, added_at_ws_no, added_facility_id,modified_by_id, modified_date, modified_at_ws_no, modified_facility_id ) values ( ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, ?, ?, ?, SYSDATE, ?, ? )" ;
	public static String SQL_MM_ITEM_CLASS_UPDATE			=	" update mm_item_class set long_desc = ?, short_desc = ?, eff_status = ?, appl_ss_yn = ?, appl_st_yn = ?, appl_po_yn = ?,  modified_by_id = ?, modified_date = SYSDATE, modified_at_ws_no = ?, modified_facility_id = ? where item_class_code = ?" ;
	//public static final String SQL_MM_ITEM_CLASS_QUERYCRIT	=	" select item_class_code, long_desc, short_desc, eff_status from mm_item_class where upper(item_class_code) like upper(?) and short_desc like upper(?) and eff_status like upper(?) ";
	public static String SQL_MM_ITEM_CLASS_MODIFY			=	" select item_class_code, long_desc, short_desc, eff_status, appl_ss_yn, appl_st_yn, appl_po_yn from mm_item_class where item_class_code = ?";
	/* Queries for MM Item Class Ends */
	
	/* Queries for MM Item Analysis Starts */
	public static String SQL_MM_ITEM_ANAL_CODE_EXISTS		=	" select count(*) count from mm_item_analysis where item_anal_code = ? " ;
	public static String SQL_MM_ITEM_ANAL_INSERT			=	" insert into mm_item_analysis ( item_anal_code, long_desc, short_desc, eff_status, added_by_id, added_date, added_at_ws_no, added_facility_id,modified_by_id, modified_date, modified_at_ws_no, modified_facility_id ) values ( ?, ?, ?, ?, ?, SYSDATE, ?, ?, ?, SYSDATE, ?, ? )" ;
	public static String SQL_MM_ITEM_ANAL_UPDATE			=	" update mm_item_analysis set long_desc = ?, short_desc = ?, eff_status = ?, modified_by_id = ?, modified_date = SYSDATE, modified_at_ws_no = ?, modified_facility_id = ? where item_anal_code = ?" ;
	//public static final String SQL_MM_ITEM_ANAL_QUERYCRIT	=	" select item_anal_code, long_desc, short_desc, eff_status from mm_item_analysis where upper(item_anal_code) like upper(?) and short_desc like upper(?) and eff_status like upper(?) ";
	public static String SQL_MM_ITEM_ANAL_MODIFY			=	" select item_anal_code, long_desc, short_desc, eff_status from mm_item_analysis where item_anal_code = ?";
	/* Queries for MM Item Analysis Ends */

	/* Queries for MM Item Master Starts */
	public static String SQL_MM_ITEMMASTER_EXISTS			=	" select count(*) count from mm_item where item_code = ? " ;
	public static String SQL_MM_ITEM_MASTER_SUPPLIER		=	" select supp_code, short_name from st_supplier  order by 2 ";
	public static String SQL_MM_ITEM_MASTER_PURCHASE		=	" select uom_code,short_desc from am_uom where stock_uom_yn='Y' and eff_status = 'E' order by short_desc ";
	public static String SQL_MM_ITEM_MASTER_CLASS			=	" select item_class_code,short_desc from mm_item_class where eff_status = 'E' order by short_desc ";
	public static String SQL_MM_ITEM_MASTER_ANALYSIS		=	" select item_anal_code,short_desc from mm_item_analysis where eff_status = 'E' order by short_desc " ;
	public static String SQL_MM_MATERIAL_SELECT				=	" select MATERIAL_GROUP_CODE, short_desc from mm_material_group  order by 2";
	public static String SQL_MM_ITEMMASTER_INSERT			=	" INSERT INTO MM_ITEM ( ITEM_CODE, CATEGORY_TYPE_CODE, MATERIAL_GROUP_CODE, ALPHA_CODE, LONG_DESC, SHORT_DESC, ITEM_REMARKS, ITEM_SPECIFICATION, SOLE_SOURCE_YN, CURR_SUPP_CODE, SPECIAL_ITEM_YN, GEN_UOM_CODE, PUR_UOM_CODE, PUR_GEN_UOM_CONV, ITEM_CLASS_CODE, ITEM_ANAL1_CODE, ITEM_ANAL2_CODE, ITEM_ANAL3_CODE, QTY_ON_ORDER,LAST_PUR_ADVICE_DATE, PR_BASED_BUDGET_YN, UNIT_COST, EFF_STATUS, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID ) VALUES  ( ? , ? , ? , ? , ? , ? , ? , ? ,? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? ,to_date(?,'dd/mm/yyyy'), ? , ? , ? , ? , sysdate , ? , ? , ? ,sysdate , ? , ?  )";
	public static String SQL_MM_ITEM_MASTER_UPDATE			=	" UPDATE MM_ITEM SET CATEGORY_TYPE_CODE = ? , MATERIAL_GROUP_CODE = ? , ALPHA_CODE = ? , LONG_DESC = ? , SHORT_DESC = ? , ITEM_REMARKS = ? , ITEM_SPECIFICATION = ? , SOLE_SOURCE_YN = ? , CURR_SUPP_CODE = ? , SPECIAL_ITEM_YN = ? , GEN_UOM_CODE = ? , PUR_UOM_CODE = ? , PUR_GEN_UOM_CONV = ? , ITEM_CLASS_CODE = ? , ITEM_ANAL1_CODE = ? , ITEM_ANAL2_CODE = ? , ITEM_ANAL3_CODE = ? , QTY_ON_ORDER = ? , LAST_PUR_ADVICE_DATE = to_date(?,'dd/mm/yyyy') , PR_BASED_BUDGET_YN = ? , UNIT_COST = ? , EFF_STATUS = ? , MODIFIED_BY_ID = ? , MODIFIED_DATE = SYSDATE , MODIFIED_AT_WS_NO = ? , MODIFIED_FACILITY_ID = ?  WHERE ITEM_CODE = ? ";
	public static String SQL_MM_ITEM_MASTER_QUERYCRIT		=	" select item_code, alpha_code, short_desc, category_type_code, eff_status from mm_item where upper(item_code) like upper(?) and alpha_code like upper(?) and short_desc like upper(?)  and category_type_code like upper(?)  and eff_status like upper(?) ";	
	public static String SQL_MM_ITEMMASTER_MODIFY			=	" SELECT ITEM_CODE, CATEGORY_TYPE_CODE, MATERIAL_GROUP_CODE, ALPHA_CODE, LONG_DESC, SHORT_DESC, ITEM_REMARKS, ITEM_SPECIFICATION, SOLE_SOURCE_YN, CURR_SUPP_CODE, SPECIAL_ITEM_YN, GEN_UOM_CODE, PUR_UOM_CODE, PUR_GEN_UOM_CONV, ITEM_CLASS_CODE, ITEM_ANAL1_CODE, ITEM_ANAL2_CODE, ITEM_ANAL3_CODE, QTY_ON_ORDER, to_char(LAST_PUR_ADVICE_DATE,'dd/mm/yyyy') LAST_PUR_ADVICE_DATE, PR_BASED_BUDGET_YN, UNIT_COST, EFF_STATUS FROM MM_ITEM WHERE ITEM_CODE = ? " ;
	/* Queries for MM Item Master Ends */

	/* Queries for MM Brand Name Starts */
	public static String SQL_MM_BRANDNAME_EXISTS			=	" select count(*) count from mm_brand_trade_names where brand_trade_name_code = ? " ;
	public static String SQL_MM_BRANDNAME_INSERT			=	" INSERT INTO MM_BRAND_TRADE_NAMES ( BRAND_TRADE_NAME_CODE, MANUFACTURER_CODE, LONG_DESC, SHORT_DESC, EFF_STATUS, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID ) VALUES  ( ? , ? , ? , ? , ? , ? , sysdate , ? , ? , ? , sysdate , ? , ?  )" ;
	public static String SQL_MM_BRANDNAME_UPDATE			=	" update mm_brand_trade_names set long_desc = ?, short_desc = ?, manufacturer_code = ?, eff_status = ?, modified_by_id = ?, modified_date = SYSDATE, modified_at_ws_no = ?, modified_facility_id = ? where brand_trade_name_code = ?" ;
	public static String SQL_MM_BRAND_NAME_SELECT			=	" select manufacturer_code,long_name from mm_manufacturer where eff_status='E' " ;
	//public static final String SQL_MM_BRANDNAME_QUERYCRIT	=	" select brand_trade_name_code, long_desc,short_desc,manufacturer_code,eff_status from mm_brand_trade_names where upper(brand_trade_name_code) like upper(?) and long_desc like upper(?) and eff_status like upper(?) ";
	/* Queries for MM Brand Name Ends */

	/* Queries for MM Bin Location Starts */
	public static String SQL_MM_BINLOCATION_EXISTS			=	" select count(*) count from mm_bin_location where bin_location_code = ? " ;
	public static String SQL_MM_BINLOCATION_INSERT			=	" insert into mm_bin_location ( bin_location_code, store_code, long_desc, short_desc, eff_status, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id ) values  ( ? , ? , ? , ? , ? , ? , sysdate , ? , ? , ? , sysdate , ? , ?  )" ;
	public static String SQL_MM_BINLOCATION_UPDATE			=	" update mm_bin_location set long_desc = ?, short_desc = ?, store_code = ?, eff_status = ?, modified_by_id = ?, modified_date = SYSDATE, modified_at_ws_no = ?, modified_facility_id = ? where bin_location_code = ?" ;
	public static String SQL_MM_STORE_SELECT				=	" select store_code,long_desc from mm_store where eff_status='E' " ;
	//public static final String SQL_MM_BINLOCATION_QUERYCRIT	=	" select bin_location_code, long_desc,short_desc,store_code,eff_status from mm_bin_location where upper(bin_location_code) like upper(?) and long_desc like upper(?) and eff_status like upper(?) ";
	/* Queries for MM Bin Location Ends */


	/* SQL statements end */

	/* JNDI locations start */
	public static String JNDI_MM_MASTER_CODE			=	"java:comp/env/ejb/eMM/MasterCode" ;
	/* JNDI locations end */

	/* OPERATION MODE declaration start */
	//public static final int SINGLE_INSERT				=	1;
	//public static final int SINGLE_UPDATE				=	2;
	//public static final int MULTIPLE_INSERT				=	3;
	/* OPERATION MODE declaration end */

	/* FUNCTION ID declaration start */
	public static final	int MM_MATERIAL_GROUP			=	1;
	public static final	int MM_ITEM_CLASS				=	2;
	public static final	int MM_ITEM_ANALYSIS			=	3;
	public static final	int MM_ITEM_MASTER				=	4;
	public static final	int MM_MANUFACTURER				=	5;
	public static final	int MM_STORE					=	6;
	public static final	int MM_BRAND_NAME				=	7;
	public static final	int MM_BIN_LOCATION				=	8;
	public static final	int MM_MULTI_BIN_LOCATION		=	9;
	/* FUNCTION ID declaration end */

	/* Queries for MM Store Starts */
	public static String SQL_MM_STORE_CODE_EXISTS		=	" select count(*) count from mm_store where store_code = ? " ;
	public static String SQL_MM_STORE_INSERT			=	" insert into mm_store ( store_code, long_desc, short_desc, facility_id, dept_code, cust_code, store_incharge_name, store_incharge_title, store_location, external_yn, eff_status, added_by_id, added_date, added_at_ws_no, added_facility_id,modified_by_id, modified_date, modified_at_ws_no, modified_facility_id ) values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, ?, ?, ?, SYSDATE, ?, ? )" ;
	public static String SQL_MM_STORE_UPDATE			=	" update mm_store set long_desc = ?, short_desc = ?, dept_code =?, cust_code = ?, store_incharge_name = ?, store_incharge_title = ?, store_location = ?, external_yn = ?, eff_status = ?, modified_by_id = ?, modified_date = SYSDATE, modified_at_ws_no = ?, modified_facility_id = ? where store_code = ?" ;
	public static String SQL_MM_STORE_MODIFY			=	" select store_code, long_desc, short_desc, dept_code, cust_code, store_incharge_name, store_incharge_title, store_location, external_yn, eff_status from mm_store where store_code=? and facility_id=?" ;
	public static String SQL_MM_STORE_DEPT				=	" Select a.dept_code,b.short_desc from am_facility_dept a , am_dept b where  a.operating_facility_id = ? and a.dept_code = b.dept_code order by short_desc";
	public static String SQL_MM_STORE_CUST				=	" Select cust_code,short_name from ar_customer   order by short_name";
	public static String SQL_MM_STORE_AR_MODULE_SEARCH	=	" select count(*) total from sm_modules_facility where module_id='AR'and facility_id=?";
	public static String SQL_MM_STORE_QUERYCRIT			=	" select store_code,long_desc, short_desc, eff_status from mm_store where upper(store_code) like upper(?) and short_desc like upper(?)  and eff_status like upper(?) and facility_id like upper(?) ";
	/* Queries for MM Store Ends */

		/* Queries for MM Manufacturer Starts */
	public static String SQL_MM_MANUFACTURER_CODE_EXISTS	=	" select count(*) count from mm_manufacturer where manufacturer_code = ? " ;
	public static String SQL_MM_MANUFACTURER_INSERT			=	" insert into mm_manufacturer ( manufacturer_code, long_name, short_name, ln1_address, ln2_address, ln3_address, ln4_address, tel_num, tlx_num, fax_num, email, website, eff_status, added_by_id, added_date, added_at_ws_no, added_facility_id,modified_by_id, modified_date, modified_at_ws_no, modified_facility_id ) values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, ?, ?, ?, SYSDATE, ?, ? )" ;
	public static String SQL_MM_MANUFACTURER_UPDATE			=	" update mm_manufacturer set long_name = ?, short_name = ?, ln1_address =?, ln2_address = ?, ln3_address = ?, ln4_address = ?, tel_num = ?, tlx_num = ?, fax_num = ?, email = ?, website = ?,eff_status = ?, modified_by_id = ?, modified_date = SYSDATE, modified_at_ws_no = ?, modified_facility_id = ? where manufacturer_code = ?" ;
	public static String SQL_MM_MANUFACTURER_MODIFY			=	" select manufacturer_code, long_name, short_name, ln1_address, ln2_address, ln3_address, ln4_address, tel_num, tlx_num, fax_num, email, website, eff_status from mm_manufacturer where manufacturer_code=? " ;
	public static String SQL_MM_MANUFACTURER_QUERYCRIT		=	" select manufacturer_code,long_name, short_name, eff_status from mm_manufacturer where upper(manufacturer_code) like upper(?) and short_name like upper(?)  and eff_status like upper(?) ";
	/* Queries for MM Manufacturer Ends */
} 
