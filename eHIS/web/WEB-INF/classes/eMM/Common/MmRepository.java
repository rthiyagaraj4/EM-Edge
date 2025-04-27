/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 /*
-------------------------------------------------------------------------------------------------------------------------------------------
Date		       Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------
09/05/2017		IN062881		B.Badmavathi								     PO Mandatory in GRN 
05/07/2017		IN060124		SooryaPrakash M						             GHL-CRF-0405
7/1/2019		IN069010		Sharanraj												 GHL-CRF-0548.1
13/5/2021		TFS:14012		Shazana												MO-CRF-20165
--------------------------------------------------------------------------------------------------------------------------------------------
*/ 
package eMM.Common;
import java.util.*;

public class MmRepository {

    //Changed on 3/13/2006
	//private static	MmRepository	instance;
	private			static int				i			=	0;
	public static final int	SINGLE_INSERT		=	1;
	public static final int	SINGLE_UPDATE		=	2;
	public static final int	MULTIPLE_INSERT		=	3;
    
	private static	HashMap			dataMap;

    //private MmRepository() { //throws Exception
	static { //throws Exception
        dataMap	=	new HashMap();
        load();
    }

 
    public static String getMmKeyValue( String key ) { //throws Exception
		return ( getValue( key ) );
    }

	public static int getI() {
		return i;
	}

    private static String getValue( String key ) { //throws Exception
        String value = "";
        try {
            //new code
            if (dataMap ==null)
            {
				dataMap	=	new HashMap();
		        load();
            }
			//end of new code
			value = String.valueOf(dataMap.get( key ) );
            if ( value == null ) {
                 value = key + " : Key not found" ;
			}
        }
		catch ( Exception e ) {
			value = key + " : Key not found " +e.toString();
        }
        return value;
    }

    protected void finalize() throws Throwable {
        if ( dataMap != null )	dataMap = null;
    }

    private static void load() { //throws Exception
		/* SQL statements start */

		dataMap.put("MANDATORY_IMAGE",			"&nbsp;<img	src='../../eCommon/images/mandatory.gif' align='center'>");
		dataMap.put("YES_IMAGE", "<img src='../../eCommon/images/enabled.gif' align='center'>");
		dataMap.put("NO_IMAGE",	"<img src='../../eCommon/images/disabled.gif' align='center'>");
		dataMap.put("SQL_SM_REPORT_SELECT_INTERNAL_REQUEST","SELECT internal_request_yn FROM sm_report WHERE module_id = ? AND report_id = ?");


		/* For Menu Creation */
		dataMap.put("SQL_SM_SUB_FUNCTION_SELECT_MENU",			"SELECT 'R' table_name,master_code, a.incl_yn,a.subfunction_id,master_code_desc,'subfunctions[\"'||a.subfunction_id||'\"]='''|| function_parameters ||'?module_id=' ||a.module_id||'&function_id='||a.subfunction_id||'&function_name='||subfunction_name||'&function_type='||subfunction_type||'&access='||a.insert_access_yn||a.update_access_yn||a.query_only_access_yn||a.delete_access_yn ||a.print_access_yn||''';' subfunctions FROM sm_sfunc_rstrn_resp a, sm_subfunction b, sm_master_code c WHERE a.subfunction_id=b.subfunction_id AND a.subfunction_id=c.table_id(+) AND a.resp_id=? AND a.menu_id=? AND a.function_id=? UNION SELECT 'M'table_name, master_code, a.incl_yn, a.subfunction_id, master_code_desc,'subfunctions[\"'||a.subfunction_id||'\"]='''|| function_parameters ||'?module_id=' ||a.module_id||'&function_id='||a.subfunction_id||'&function_name='||subfunction_name||'&function_type='||subfunction_type||'&access='||a.insert_access_yn||a.update_access_yn||a.query_only_access_yn||a.delete_access_yn ||a.print_access_yn||''';' subfunctions FROM sm_menu_sfunc_dtl a, sm_subfunction b, sm_master_code c WHERE a.subfunction_id=b.subfunction_id AND a.subfunction_id=c.table_id(+) AND a.module_id=? AND a.menu_id=? AND a.function_id=? AND a.module_id=b.module_id AND a.module_id=c.module_id ORDER BY 1 DESC,master_code");
			
//		 dataMap.put("SQL_SM_SUB_FUNCTION_SELECT_MENU",	"SELECT 'masters[\"'||b.subfunction_id||'\"]='''||function_parameters||'?module_id=' || a.module_id ||'&function_id='||b.subfunction_id||'&function_name='||subfunction_name||' &function_type='||subfunction_type||'&access='||c.INSERT_ACCESS_YN||c.UPDATE_ACCESS_YN||c.QUERY_ONLY_ACCESS_YN||c.DELETE_ACCESS_YN|| c.PRINT_ACCESS_YN||''';' master FROM sm_master_code a, sm_subfunction b ,sm_menu_sfunc_dtl c WHERE a.module_id =? AND a.module_id = b.module_id AND a.table_id=b.subfunction_id AND a.table_id=c.subfunction_id  ORDER BY master_code");
//		 dataMap.put("SQL_SM_MASTER_CODE_SELECT_MENUV2","SELECT table_id,master_code_desc FROM sm_master_code WHERE module_id= ? ORDER BY master_code");
//		 dataMap.put("SQL_SM_MASTER_CODE_SELECT_MENUV3","SELECT a.subfunction_id, b.master_code_desc,a.incl_yn FROM sm_menu_sfunc_dtl a,sm_master_code b WHERE a.function_id = (?) AND a.subfunction_id=b.table_id  AND a.incl_yn = 'Y' ORDER BY b.master_code");
		 dataMap.put("SQL_SM_MASTER_CODE_SELECT_REPORTS","SELECT master_code,master_code_desc FROM sm_master_code_lang_vw sm_master_code WHERE module_id= ?  AND table_id <> 'MM_ITEM' AND language_id=? ORDER BY master_code");
		 dataMap.put("SQL_MM_ITEM_ANALYSIS_LOOKUP",		"SELECT item_anal_code code,short_desc description FROM mm_item_analysis_lang_vw mm_item_analysis WHERE eff_status = 'E' AND language_id LIKE ? AND item_anal_code LIKE UPPER(?)  AND  UPPER(short_desc) LIKE UPPER(?)  ORDER BY item_anal_code");
		 dataMap.put("SQL_MM_ITEM_CLASS_LOOKUP",		"SELECT item_class_code code,short_desc description FROM mm_item_class_lang_vw mm_item_class WHERE eff_status = 'E' AND language_id LIKE ? AND item_class_code LIKE UPPER(?)  AND  UPPER(short_desc) LIKE UPPER(?)  ORDER BY item_class_code");
		 dataMap.put("SQL_MM_STORE_LOOKUP",				"SELECT store_code code,short_desc description FROM mm_store_lang_vw WHERE eff_status = 'E' AND language_id LIKE ? AND store_code LIKE  UPPER(?)  AND  UPPER(short_desc) LIKE UPPER(?)  ORDER BY store_code");
		 dataMap.put("SQL_MM_DEPARTMENT_LOOKUP",		"SELECT dept_code code, AM_GET_DESC.AM_DEPT(dept_code,'spl','2') description FROM am_facility_dept WHERE  operating_facility_id LIKE( ?) AND dept_code LIKE UPPER(?)  AND  AM_GET_DESC.AM_DEPT(dept_code,'spl','2') LIKE UPPER(?) ORDER BY 1");
		 dataMap.put("SQL_MM_BINLOCATION_LOOKUP",		"SELECT bin_location_code code,short_desc description FROM mm_bin_location_lang_vw mm_bin_location WHERE  eff_status='E' AND language_id LIKE ? AND bin_location_code LIKE UPPER(?)  AND  UPPER(short_desc) LIKE UPPER(?)  ORDER BY bin_location_code");
		 dataMap.put("SQL_MM_TRN_REMARKS_LOOKUP",		"SELECT trn_remarks_code code,remarks_desc description FROM mm_trn_remarks_lang_vw mm_trn_remarks WHERE eff_status = 'E' AND language_id LIKE ? AND  UPPER(module_id) LIKE UPPER(?)  AND  UPPER(trn_type) LIKE UPPER(?) AND trn_remarks_code LIKE UPPER(?)   AND  UPPER(remarks_desc) LIKE UPPER(?)   ORDER BY trn_remarks_code");
		 dataMap.put("SQL_MM_TRN_REMARKS_LOOKUP_LANG",		"SELECT trn_remarks_code  code,remarks_desc  description FROM  mm_trn_remarks_lang_vw  WHERE  eff_status = 'E'  AND  UPPER(module_id)  LIKE  UPPER(?)   AND   UPPER(trn_type)  LIKE  UPPER(?)     AND   trn_remarks_code   LIKE   UPPER(?)     AND    UPPER(remarks_desc)   LIKE  UPPER(?)");
//		 dataMap.put("SQL_MM_TRN_REMARKS_LOOKUP",		"SELECT trn_remarks_code code, remarks_desc description FROM mm_trn_remarks WHERE  eff_status='E'AND trn_remarks_code LIKE UPPER(?)  AND  UPPER(remarks_desc) LIKE UPPER(?) ORDER BY trn_remarks_code");

		 dataMap.put("SQL_MM_DOC_TYPE_CODE",			"SELECT NVL(sya.DOC_NUM_GEN_FLAG,'N') || st.doc_type_code doc_type_code, syd.short_desc doc_type_desc FROM st_trn_doc_type st, sy_acc_entity_doc_type sya, SY_DOC_TYPE_MASTER syd WHERE st.doc_type_code = sya.doc_type_code AND sya.doc_type_code = syd.doc_type_code AND syd.ENTITY_OR_FACILITY_BASED='F' AND st.eff_status = 'E' AND st.trn_type_code = ? AND st.facility_id = ? ORDER BY syd.short_desc ");
		 dataMap.put("SQL_MM_STORE",					"SELECT store_code, short_desc FROM st_store WHERE eff_status='E' ORDER BY short_desc ");

		 dataMap.put("SQL_MM_PARAMETER_SELECT",			"SELECT module_id, rstrct_lgn_to_sngl_mtrl_grp_yn, decentralised_inventory_yn, grn_penalty_yn, grn_penalty_percentage, receive_bonus_yn, receive_sample_yn FROM MM_PARAMETER " );
		 dataMap.put("SQL_MM_PARAMETER_INSERT",			"INSERT INTO MM_PARAMETER ( module_id, rstrct_lgn_to_sngl_mtrl_grp_yn, decentralised_inventory_yn, grn_penalty_yn, grn_penalty_percentage, receive_bonus_yn, receive_sample_yn, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, ?, ?, ?, SYSDATE, ?, ? )" );
		 dataMap.put("SQL_MM_PARAMETER_UPDATE",			"UPDATE MM_PARAMETER set module_id = ?, rstrct_lgn_to_sngl_mtrl_grp_yn = ?, decentralised_inventory_yn = ?, grn_penalty_yn = ?, grn_penalty_percentage = ?, receive_bonus_yn = ?, receive_sample_yn = ?, modified_by_id = ?, modified_date = SYSDATE, modified_at_ws_no = ?, modified_facility_id = ?" );


		/* Queries for MM Material Group Starts */
		 dataMap.put("SQL_MM_MTRL_GRP_CODE_EXISTS",		"SELECT count(*) count FROM mm_material_group WHERE material_group_code = ? " );
		 dataMap.put("SQL_MM_MTRL_GRP_INSERT",			"INSERT INTO mm_material_group ( material_group_code, long_desc, short_desc, eff_status, added_by_id, added_date, added_at_ws_no, added_facility_id,modified_by_id, modified_date, modified_at_ws_no, modified_facility_id ) VALUES ( ?, ?, ?, ?, ?, SYSDATE, ?, ?, ?, SYSDATE, ?, ? )" );
		 dataMap.put("SQL_MM_MTRL_GRP_UPDATE",			"UPDATE mm_material_group SET long_desc = ?, short_desc = ?, eff_status = ?, modified_by_id = ?, modified_date = SYSDATE, modified_at_ws_no = ?, modified_facility_id = ? WHERE material_group_code = ?" );
		 dataMap.put("SQL_MM_MTRL_GRP_QUERYCRIT",		"SELECT material_group_code, long_desc,short_desc,eff_status FROM mm_material_group_lang_vw WHERE UPPER(material_group_code) LIKE UPPER(?) AND short_desc LIKE UPPER(?) AND eff_status LIKE UPPER(?) AND language_id = ?");
		/* Queries for MM Material Group Ends */

		/* Queries for MM Item Class Starts */
		 dataMap.put("SQL_MM_ITEM_CLASS_CODE_EXISTS",	"SELECT count(*) count FROM mm_item_class WHERE item_class_code = ? " );
		 dataMap.put("SQL_MM_ITEM_CLASS_INSERT",		"INSERT INTO mm_item_class ( item_class_code, long_desc, short_desc, eff_status, appl_ss_yn, appl_st_yn, appl_po_yn, added_by_id, added_date, added_at_ws_no, added_facility_id,modified_by_id, modified_date, modified_at_ws_no, modified_facility_id ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, ?, ?, ?, SYSDATE, ?, ? )" );
		 dataMap.put("SQL_MM_ITEM_CLASS_UPDATE",		"UPDATE mm_item_class SET long_desc = ?, short_desc = ?, eff_status = ?, appl_ss_yn = ?, appl_st_yn = ?, appl_po_yn = ?,  modified_by_id = ?, modified_date = SYSDATE, modified_at_ws_no = ?, modified_facility_id = ? WHERE item_class_code = ?" );
		 dataMap.put("SQL_MM_ITEM_CLASS_QUERYCRIT",		"SELECT ITEM_CLASS_CODE,LONG_DESC,SHORT_DESC,EFF_STATUS FROM MM_ITEM_CLASS WHERE UPPER(ITEM_CLASS_CODE) LIKE UPPER(?) AND UPPER(SHORT_DESC) LIKE UPPER(?)AND EFF_STATUS LIKE UPPER(?)");
		 dataMap.put("SQL_MM_ITEM_CLASS_MODIFY",		"SELECT item_class_code, long_desc, short_desc, eff_status, appl_ss_yn, appl_st_yn, appl_po_yn FROM mm_item_class_lang_vw WHERE item_class_code = ? AND language_id = ?");
		 dataMap.put("SQL_MM_MODULE_EXIST_SELECT",		"SELECT module_id  FROM sm_module WHERE module_id in ('PO','SS','ST') AND install_yn ='Y'");
		/* Queries for MM Item Class Ends */

		/* Queries for MM Item Analysis Starts */
		 dataMap.put("SQL_MM_ITEM_ANAL_CODE_EXISTS",	"SELECT count(*) count FROM mm_item_analysis WHERE item_anal_code = ? " );
		 dataMap.put("SQL_MM_ITEM_ANAL_INSERT",			"INSERT INTO mm_item_analysis ( item_anal_code, long_desc, short_desc, eff_status, added_by_id, added_date, added_at_ws_no, added_facility_id,modified_by_id, modified_date, modified_at_ws_no, modified_facility_id ) VALUES ( ?, ?, ?, ?, ?, SYSDATE, ?, ?, ?, SYSDATE, ?, ? )" );
		 dataMap.put("SQL_MM_ITEM_ANAL_UPDATE",			"UPDATE mm_item_analysis SET long_desc = ?, short_desc = ?, eff_status = ?, modified_by_id = ?, modified_date = SYSDATE, modified_at_ws_no = ?, modified_facility_id = ? WHERE item_anal_code = ?" );
		 dataMap.put("SQL_MM_ITEM_ANAL_QUERYCRIT",		"SELECT item_anal_code, long_desc, short_desc, eff_status FROM mm_item_analysis_lang_vw  WHERE UPPER(item_anal_code) LIKE UPPER(?) AND UPPER(short_desc) LIKE UPPER(?) AND eff_status LIKE UPPER(?) AND language_id = ? ");
		 dataMap.put("SQL_MM_ITEM_ANAL_MODIFY",			"SELECT item_anal_code, long_desc, short_desc, eff_status FROM mm_item_analysis WHERE item_anal_code = ?");
		/* Queries for MM Item Analysis Ends */

		/* Queries for MM Transaction Remarks Starts  Added on 10/19/2004*/
		 dataMap.put("SQL_MM_TRN_REMARKS_CODE_EXISTS",	 "SELECT count(*) count FROM mm_trn_remarks WHERE  trn_remarks_code  = ?  and trn_type = ? and module_id = ? " );
		 dataMap.put("SQL_MM_TRN_REMARKS_INSERT",	 "INSERT INTO mm_trn_remarks (module_id,trn_type, trn_remarks_code,remarks_desc,eff_status,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id, modified_date, modified_at_ws_no, modified_facility_id ) VALUES ( ?,?,?,?, ?, ?, SYSDATE, ?, ?, ?, SYSDATE, ?, ? )" );
		 dataMap.put("SQL_MM_TRN_REMARKS_UPDATE",	 "UPDATE mm_trn_remarks SET remarks_desc = ?, eff_status = ?, modified_by_id = ?, modified_date = SYSDATE, modified_at_ws_no = ?, modified_facility_id = ? WHERE trn_remarks_code = ?" );
		 dataMap.put("SQL_MM_TRN_REMARKS_QUERYCRIT", "SELECT trn_remarks_code, remarks_desc, eff_status , module_id,trn_type FROM mm_trn_remarks_lang_vw WHERE UPPER(trn_remarks_code) LIKE UPPER(?) AND UPPER(remarks_desc) LIKE UPPER(?) AND eff_status LIKE UPPER(?)AND  module_id LIKE UPPER(?)AND trn_type LIKE UPPER(?) AND language_id = ? ");
		 dataMap.put("SQL_MM_TRN_REMARKS_MODIFY",	 "SELECT trn_remarks_code,remarks_desc,eff_status,module_id,trn_type FROM mm_trn_remarks_lang_vw WHERE trn_remarks_code= ? AND language_id = ?");
		 dataMap.put("SQL_MM_TRN_REMARKS",	 "SELECT trn_remarks_code code, remarks_desc description FROM mm_trn_remarks WHERE   trn_remarks_code LIKE UPPER(?)  AND  UPPER(remarks_desc) LIKE UPPER(?)");
//		 dataMap.put("SQL_MM_TRN_REMARKS_ST",	 "SELECT trn_remarks_code code, remarks_desc description FROM mm_trn_remarks WHERE   UPPER(module_id) LIKE UPPER(?) AND  UPPER(trn_type) LIKE UPPER(?)");
	 	 dataMap.put("SQL_MODULE_ID","select MODULE_ID,MODULE_NAME from SM_MODULE where module_id in ('SS','ST','PO') and install_yn='Y'");
		/* Queries for MM Transaction Remarks Ends */

		/* Queries for MM Item Master Starts */
		 dataMap.put("SQL_MM_ITEMMASTER_EXISTS",		"SELECT count(*) count FROM mm_item WHERE item_code = ? " );
		 dataMap.put("SQL_MM_ITEM_MASTER_SUPPLIER",		"SELECT supp_code code, short_name description FROM ap_supplier_lang_vw WHERE status is NULL   AND  supp_code LIKE UPPER(?)  AND  UPPER(short_name) LIKE UPPER(?) AND language_id = ");
		 dataMap.put("SQL_MM_ITEM_MASTER_SUPPLIER_EXIST","SELECT count(*) total FROM ap_supplier WHERE supp_code LIKE UPPER(?)");
		 dataMap.put("SQL_MM_ITEM_MASTER_PURCHASE",		"SELECT uom_code,short_desc FROM am_uom_lang_vw WHERE stock_uom_yn='Y' AND eff_status = 'E' AND language_id = ? ORDER BY short_desc");
		 dataMap.put("SQL_MM_ITEM_MASTER_CLASS",		"SELECT item_class_code,short_desc FROM mm_item_class_lang_vw mm_item_class WHERE eff_status = 'E' AND language_id = ? ORDER BY short_desc");
		 dataMap.put("SQL_MM_ITEM_MASTER_ANALYSIS",		"SELECT item_anal_code,short_desc FROM mm_item_analysis_lang_vw WHERE eff_status = 'E' AND language_id=? ORDER BY short_desc");
		 dataMap.put("SQL_MM_ITEMMASTER_INSERT",		"INSERT INTO mm_item ( item_code, category_type_code, material_group_code,alpha_code, long_desc, short_desc, item_remarks, item_specification, sole_source_yn, curr_supp_code, special_item_yn, gen_uom_code, item_class_code, item_anal1_code,item_anal2_code, item_anal3_code, cssd_component_yn,manufacturer_id,ps_item_yn,initial_cost,current_cost_date,last_cost,last_cost_date,next_last_cost,next_last_cost_date,last_receipt_date, unit_cost, billable_item_yn ,eff_status,imported_item_yn,essential_item_yn,reimbursable_item_yn,reimbursable_ind, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id,direct_sale_allowed_yn ) VALUES  ( ? , ? , ? , ? , ? , ? , ? , ? ,? , ? , ? , ? , ? , ? , ? , ?, ?, ?, ?, ?,TO_DATE(?,'dd/mm/yyyy'),?,TO_DATE(?,'dd/mm/yyyy'),?,TO_DATE(?,'dd/mm/yyyy'),TO_DATE(?,'dd/mm/yyyy'),? , ?,? , ?,?,?,?,?, SYSDATE , ? , ? ,? ,SYSDATE , ? , ? ,? )");

		 dataMap.put("SQL_MM_ITEM_MASTER_UPDATE",		"UPDATE mm_item SET category_type_code = ? , material_group_code = ? , alpha_code = ? , long_desc = ? ,short_desc = ? , item_remarks = ? , item_specification = ? , sole_source_yn = ? , curr_supp_code = ? , special_item_yn = ? , gen_uom_code = ? , item_class_code = ? , item_anal1_code = ? , item_anal2_code = ? , item_anal3_code = ? ,cssd_component_yn = ?,manufacturer_id = ?,ps_item_yn = ?,initial_cost = ?,current_cost_date = TO_DATE(?,'dd/mm/yyyy'), last_cost = ? ,last_cost_date = TO_DATE(?,'dd/mm/yyyy'), next_last_cost = ?, next_last_cost_date = TO_DATE(?,'dd/mm/yyyy') ,last_receipt_date = TO_DATE(?,'dd/mm/yyyy'),unit_cost = ? , billable_item_yn =? ,eff_status = ?,imported_item_yn=?,essential_item_yn=?,reimbursable_item_yn=?,reimbursable_ind=?, modified_by_id = ? , modified_date = SYSDATE , modified_at_ws_no = ? , modified_facility_id = ? ,direct_sale_allowed_yn = ? WHERE item_code = ?");
		 dataMap.put("SQL_MM_ITEM_MASTER_QUERYCRIT",	"SELECT curr_supp_code,item_code, alpha_code, short_desc, category_type_code, eff_status FROM mm_item_lang_vw WHERE item_code LIKE UPPER(?) AND UPPER(alpha_code) LIKE UPPER(?) AND UPPER(short_desc) LIKE UPPER(?)  AND UPPER(category_type_code) LIKE UPPER(?)  AND eff_status LIKE UPPER(?) AND UPPER(NVL(curr_supp_code,'X')) LIKE UPPER(?) AND UPPER(special_item_yn) LIKE UPPER(?) AND sole_source_yn LIKE (?) AND UPPER(NVL(manufacturer_id,'X')) LIKE UPPER(?) AND language_id = ?");
		 dataMap.put("SQL_MM_ITEM_MASTER_QUERYCRIT_CREATE", "SELECT curr_supp_code,item_code, alpha_code, short_desc, category_type_code, eff_status FROM mm_item WHERE SOUNDEX(UPPER(short_desc)) = SOUNDEX(UPPER(?)) or UPPER(short_desc) LIKE UPPER(?)");
		 dataMap.put("SQL_MM_ITEMMASTER_MODIFY_WHEN_AP_INS","SELECT item_code, category_type_code, material_group_code, alpha_code, long_desc, short_desc, item_remarks, item_specification, sole_source_yn, curr_supp_code,ss.short_name curr_supp_desc,special_item_yn, gen_uom_code, item_class_code, item_anal1_code, item_anal2_code, item_anal3_code,  unit_cost, mi.eff_status, cssd_component_yn,manufacturer_id,ps_item_yn,initial_cost, TO_CHAR(current_cost_date,'dd/mm/yyyy') current_cost_date,last_cost,	TO_CHAR(last_cost_date,'dd/mm/yyyy') last_cost_date,TO_CHAR(next_last_cost_date,'dd/mm/yyyy')next_last_cost_date,next_last_cost, TO_CHAR(last_receipt_date,'dd/mm/yyyy') last_receipt_date ,mi.billable_item_yn,direct_sale_allowed_yn,imported_item_yn imported_item,essential_item_yn essential_item,reimbursable_ind reimburse_type,reimbursable_item_yn FROM mm_item_lang_vw mi , ap_supplier_lang_vw ss WHERE  mi.curr_supp_code = ss.supp_code(+) AND mi.item_code = ? AND mi.language_id = ss.language_id(+) AND mi.language_id = ? " );
		 dataMap.put("SQL_MM_ITEMMASTER_MODIFY",		"SELECT item_code, category_type_code, material_group_code, alpha_code, long_desc, short_desc, item_remarks, item_specification, sole_source_yn, null curr_supp_code,null curr_supp_desc,special_item_yn, gen_uom_code, item_class_code, item_anal1_code, item_anal2_code, item_anal3_code,  unit_cost, mi.eff_status, cssd_component_yn,manufacturer_id,ps_item_yn,initial_cost, TO_CHAR(current_cost_date,'dd/mm/yyyy') current_cost_date,last_cost,	TO_CHAR(last_cost_date,'dd/mm/yyyy') last_cost_date,TO_CHAR(next_last_cost_date,'dd/mm/yyyy')next_last_cost_date,next_last_cost, TO_CHAR(last_receipt_date,'dd/mm/yyyy') last_receipt_date  FROM mm_item_lang_vw mi  WHERE  mi.item_code = ? AND language_id = ? " );
		 dataMap.put("SQL_MM_MANUFACTURER_SELECT",		"SELECT manufacturer_id,short_name FROM am_manufacturer_lang_vw am_manufacturer WHERE  eff_status='E' AND language_id = ? ORDER BY short_name" );
		 dataMap.put("SQL_MM_ITEM_AP_MODULE_SEARCH",	"SELECT count(*) total FROM sm_modules_facility WHERE module_id='AP' AND operational_yn='Y' and facility_id=?");
		 dataMap.put("SQL_ST_ITEM_SELECT_COUNT",	"SELECT count(*) total FROM st_item where item_code=?");
//		 dataMap.put("SQL_MM_ITEM_BILLING_YN" , "SELECT INSTALL_YN FROM SM_MODULE WHERE MODULE_ID='BL' " );
 		 dataMap.put("SQL_MM_ITEM_BILLING_YN" , "SELECT COUNT(*) CNT FROM SM_MODULE WHERE MODULE_ID='BL'  AND INSTALL_YN='Y'" );
		/* Queries for MM Item Master Ends */


		/* Queries for MM Bin Location Starts */
		 dataMap.put("SQL_MM_BINLOCATION_EXISTS",		"SELECT count(*) count FROM mm_bin_location WHERE bin_location_code = ? AND store_code = ? " );
		 dataMap.put("SQL_MM_BINLOCATION_INSERT",		"INSERT INTO mm_bin_location ( bin_location_code, store_code, long_desc, short_desc, eff_status, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id ) VALUES  ( ? , ? , ? , ? , ? , ? , sysdate , ? , ? , ? , sysdate , ? , ?  )" );
		 dataMap.put("SQL_MM_BINLOCATION_UPDATE",		"UPDATE mm_bin_location SET long_desc = ?, short_desc = ?, eff_status = ?, modified_by_id = ?, modified_date = SYSDATE, modified_at_ws_no = ?, modified_facility_id = ? WHERE bin_location_code = ? AND store_code = ? " );
		 dataMap.put("SQL_MM_STORE_SELECT",				"SELECT store_code,short_desc FROM mm_store_lang_vw mm_store WHERE eff_status='E' AND language_id = ? ORDER BY short_desc" );
		// dataMap.put("SQL_MM_BINLOCATION_QUERYCRIT",	"SELECT bin_location_code, mb.long_desc,mb.short_desc,ms.short_desc store_desc,mb.eff_status,mb.store_code store_code FROM mm_bin_location mb, mm_store ms WHERE mb.store_code = ms.store_code AND bin_location_code LIKE UPPER(?) AND UPPER(mb.long_desc) LIKE UPPER(?) AND mb.eff_status LIKE UPPER(?) AND ms.facility_id = (?) AND UPPER(mb.store_code) LIKE UPPER(?) ");
			/*Modified On  29/04/2005  for Eff_status of mm_store*/
		dataMap.put("SQL_MM_BINLOCATION_QUERYCRIT",	"SELECT bin_location_code, mb.long_desc,mb.short_desc,ms.short_desc store_desc,mb.eff_status,mb.store_code store_code FROM mm_bin_location_lang_vw mb, mm_store_lang_vw ms WHERE mb.store_code = ms.store_code AND bin_location_code LIKE UPPER(?) AND UPPER(mb.long_desc) LIKE UPPER(?) AND mb.eff_status LIKE UPPER(?) AND ms.eff_status='E' AND ms.facility_id = (?) AND UPPER(mb.store_code) LIKE UPPER(?) AND mb.language_id = ms.language_id AND mb.language_id = ?");
		 dataMap.put("SQL_MM_BINLOCATION_MODIFY",       "SELECT bin_location_code, long_desc,short_desc, store_code, eff_status FROM mm_bin_location WHERE store_code = ? AND bin_location_code = ? ");
		/* Queries for MM Bin Location Ends */

		/* Queries for MM Store Starts */
		dataMap.put("SQL_MM_STORE_CODE_EXISTS",			"SELECT count(*) count FROM mm_store WHERE store_code = ? " );
		dataMap.put("SQL_MM_STORE_INSERT",				"INSERT INTO mm_store ( store_code, long_desc, short_desc, facility_id, dept_code, cust_code, store_incharge_name, store_incharge_title, store_location, external_yn, contact_ref,eff_status, added_by_id, added_date, added_at_ws_no, added_facility_id,modified_by_id, modified_date, modified_at_ws_no, modified_facility_id,PO_dept_code ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, ?, ?, ?, SYSDATE, ?, ? ,?)" );
		
		dataMap.put("SQL_MM_STORE_UPDATE",				"UPDATE mm_store SET long_desc = ?, short_desc = ?, dept_code =?, cust_code = ?, store_incharge_name = ?, store_incharge_title = ?, store_location = ?, external_yn = ?, contact_ref = ? ,eff_status = ?, modified_by_id = ?, modified_date = SYSDATE, modified_at_ws_no = ?, modified_facility_id = ?,PO_dept_code=? WHERE store_code = ?" );

		dataMap.put("SQL_MM_STORE_MODIFY",				"SELECT store_code, long_desc, short_desc, dept_code, cust_code, store_incharge_name, store_incharge_title, store_location, contact_ref ,external_yn, eff_status,PO_dept_code FROM mm_store_lang_vw mm_store WHERE store_code=? AND facility_id=? AND language_id = ?" );
		dataMap.put("SQL_MM_STORE_DEPT",				"SELECT dept_code,dept_short_desc FROM am_facility_dept_vw WHERE  operating_facility_id = ? and eff_status='E' ORDER BY dept_short_desc");
		dataMap.put("SQL_MM_STORE_CUST",				"SELECT cust_code,short_name FROM ar_customer_lang_vw WHERE language_id = ? ORDER BY short_name");
		dataMap.put("SQL_MM_STORE_AR_MODULE_SEARCH",	"select OPERATIONAL_YN from  sm_modules_Acct_entity where module_id='AR' and acct_entity_id=?");
		dataMap.put("SQL_MM_STORE_QUERYCRIT1",			"SELECT PO_DEPT_CODE,store_code, ms.long_desc, ms.short_desc,am_get_desc.am_dept (ad.dept_code, ?, '2') dept_code, external_yn,ms.eff_status,am.short_desc po_dept_desc FROM mm_store ms, am_facility_dept_vw ad,am_dept_lang_vw am WHERE ms.dept_code = ad.dept_code(+) AND ms.facility_id = ad.operating_facility_id(+) AND UPPER (store_code) LIKE UPPER (?) AND UPPER (ms.short_desc) LIKE UPPER (?) AND ms.eff_status LIKE UPPER (?) AND UPPER (NVL (ms.dept_code, 'X')) LIKE UPPER (?) AND external_yn LIKE (?) AND ms.facility_id LIKE UPPER (?) and am.dept_code(+) = ms.PO_DEPT_CODE and am.language_id(+) = ?");

		dataMap.put("SQL_MM_STORE_QUERYCRIT2",			"SELECT PO_DEPT_CODE,store_code, ms.long_desc, ms.short_desc,am_get_desc.am_dept (ad.dept_code, ?, '2') dept_code, external_yn,ms.eff_status,decode(INTERFACE_TO_EXTERNAL_PO_YN,'Y',am.short_desc,'') po_dept_desc FROM mm_store ms, am_facility_dept_vw ad,am_dept_lang_vw am,st_acc_entity_param stac WHERE ms.dept_code = ad.dept_code(+) AND ms.facility_id = ad.operating_facility_id(+) AND UPPER (store_code) LIKE UPPER (?) AND UPPER (ms.short_desc) LIKE UPPER (?) AND ms.eff_status LIKE UPPER (?) AND UPPER (NVL (ms.dept_code, 'X')) LIKE UPPER (?) AND external_yn LIKE (?) AND ms.facility_id LIKE UPPER (?) and am.dept_code(+) = ms.PO_DEPT_CODE and am.language_id(+) = ? and stac.ACC_ENTITY_ID = ?");

		/* Queries for MM Parameter Starts */
		//dataMap.put("SQL_MM_PARAMETER_ADMIN_SINGLE",			"SELECT receive_bonus_yn,receive_sample_yn,dflt_batch_id,dflt_trade_id, Ss_period_end_scope ,St_period_end_scope ,Po_period_end_scope ,Decentralized_inv_yn FROM mm_parameter" ); Modified for GDOH-CRF-0109
		dataMap.put("SQL_MM_PARAMETER_ADMIN_SINGLE",			"SELECT receive_bonus_yn,receive_sample_yn,dflt_batch_id,dflt_trade_id, Ss_period_end_scope ,St_period_end_scope ,Po_period_end_scope ,Decentralized_inv_yn ,po_mandatory_yn FROM mm_parameter" ); 
		dataMap.put("SQL_MM_PARAMETER_ADMIN_EXIST",			"SELECT count(*) total FROM mm_parameter where module_id=?");
		dataMap.put("SQL_MM_MODULE_INSTALLED_CHECK",		"SELECT count(*)  COUNT FROM sm_module WHERE module_id= ? AND install_yn ='Y' ");
		//dataMap.put("SQL_MM_PARAMETER_ADMIN_INSERT",	"INSERT INTO mm_parameter ( receive_bonus_yn, receive_sample_yn, dflt_batch_id, dflt_trade_id, ss_period_end_scope, st_period_end_scope, po_period_end_scope, decentralized_inv_yn, added_by_id, added_date, added_at_ws_no, added_facility_id,modified_by_id, modified_date, modified_at_ws_no, modified_facility_id ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, ?, ?, ?, SYSDATE, ?, ? )" );Modified for GDOH-CRF-0109
		dataMap.put("SQL_MM_PARAMETER_ADMIN_INSERT",	"INSERT INTO mm_parameter ( receive_bonus_yn, receive_sample_yn, dflt_batch_id, dflt_trade_id, ss_period_end_scope, st_period_end_scope, po_period_end_scope, decentralized_inv_yn, po_mandatory_yn, added_by_id, added_date, added_at_ws_no, added_facility_id,modified_by_id, modified_date, modified_at_ws_no, modified_facility_id ) VALUES (  ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, ?, ?, ?, SYSDATE, ?, ? )" );//Removed Extra ? mark for SS PMG2017-SS-CRF-0002
		//dataMap.put("SQL_MM_PARAMETER_ADMIN_UPDATE",			"UPDATE mm_parameter SET receive_bonus_yn = ?, receive_sample_yn = ?, dflt_batch_id = ?, dflt_trade_id = ?, ss_period_end_scope=?, st_period_end_scope=?, po_period_end_scope=?, decentralized_inv_yn=?, modified_by_id = ?, modified_date = SYSDATE, modified_at_ws_no = ?, modified_facility_id = ? WHERE module_id = ?" );Modified for GDOH-CRF-0109
		dataMap.put("SQL_MM_PARAMETER_ADMIN_UPDATE",			"UPDATE mm_parameter SET receive_bonus_yn = ?, receive_sample_yn = ?, dflt_batch_id = ?, dflt_trade_id = ?, ss_period_end_scope=?, st_period_end_scope=?, po_period_end_scope=?, decentralized_inv_yn=?, po_mandatory_yn=?, modified_by_id = ?, modified_date = SYSDATE, modified_at_ws_no = ?, modified_facility_id = ? WHERE module_id = ?" );
		/* Queries for MM Store Ends */

		/* Queries for MM Trade Name For Item starts*/
		dataMap.put("SQL_MM_ITEM_LOOKUP",					"SELECT item_code code,long_desc description FROM mm_item_lang_vw mm_item WHERE eff_status = 'E' AND language_id LIKE ? AND sole_source_yn = 'N' AND item_code LIKE UPPER(?)  AND  UPPER(long_desc) LIKE UPPER(?)  ORDER BY long_desc");

		dataMap.put("SQL_MM_ITEM_UOM_LOOKUP",					"SELECT b.item_code code,long_desc description FROM mm_item_lang_vw mm_item , st_item b WHERE eff_status = 'E'   /*AND sole_source_yn = 'N' */ AND mm_item.item_code = b.item_code AND b.item_code LIKE UPPER(?)  AND  UPPER(long_desc) LIKE UPPER(?)  AND language_id = "); 

		dataMap.put("SQL_AM_TRADE_NAME_LOOKUP",				"SELECT am.trade_id code,am.long_name description FROM am_trade_name_lang_vw am WHERE am.eff_status = 'E'  AND language_id LIKE ? AND am.trade_id LIKE (?)  AND  UPPER(am.long_name) LIKE UPPER(?)  ORDER BY 2");


		dataMap.put("SQL_GET_AM_TRADE_NAME",				"SELECT am.trade_id code,am.long_name description FROM am_trade_name_lang_vw am WHERE am.eff_status = 'E' AND am.trade_id = ? AND language_id = ?");







		dataMap.put("SQL_AM_MANUFACTURER_DETAILS_SELECT",	"SELECT am.trade_id code, am.manufacturer_id manufacturer_id, mn.short_name manufacturer_name FROM am_trade_name_lang_vw am, am_manufacturer_lang_vw mn WHERE am.manufacturer_id = mn.manufacturer_id AND am.trade_id=? AND am.language_id = mn.language_id AND am.language_id = ?");


		dataMap.put("SQL_AM_TRADE_NAME_CHECK",	"SELECT count(*) count FROM am_trade_name WHERE trade_id = ?");



		dataMap.put("SQL_MM_TRADE_NAME_FOR_ITEM_SELECT",	"SELECT tn.item_code item_code, mm.long_desc item_name, tn.trade_id trade_id, am.long_name trade_name,mn.manufacturer_id manufacturer_id, mn.long_name manufacturer_name FROM mm_trade_name_for_item tn, mm_item_lang_vw mm,am_trade_name_lang_vw am, am_manufacturer_lang_vw mn WHERE tn.item_code = mm.item_code AND tn.trade_id = am.trade_id AND am.manufacturer_id = mn.manufacturer_id AND tn.item_code=? AND  mm.language_id = am.language_id AND mm.language_id = mn.language_id AND mm.language_id = ?");
		dataMap.put("SQL_MM_TRADE_NAME_FOR_ITEM_INSERT",	"INSERT into mm_trade_name_for_item ( item_code,trade_id,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id) VALUES (?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)");
		dataMap.put("SQL_MM_TRADE_NAME_FOR_ITEM_QUERY_RESULT",	"SELECT ti.item_code item_code, mm.long_desc long_desc, ti.trade_id trade_id, am.long_name long_name, am.manufacturer_id manufacturer_id,mn.manufacturer_id,mn.long_name       manufacturer_name FROM mm_item_lang_vw mm, mm_trade_name_for_item ti,  am_trade_name_lang_vw am, am_manufacturer_lang_vw mn WHERE ti.item_code = mm.item_code AND ti.trade_id = am.trade_id AND am.manufacturer_id = mn.manufacturer_id AND ti.item_code LIKE UPPER(?) AND UPPER(mm.long_desc) LIKE UPPER(?) AND ti.trade_id LIKE UPPER(?) AND UPPER(am.long_name) LIKE UPPER(?) AND mm.language_id = am.language_id AND mm.language_id  = mn.language_id AND mm.language_id  = ?");

		/* Queries for MM Trade Name For Item ends*/

		/* SQL statements end */

		/*CODE_SETUP*/
		dataMap.put("SQL_SM_SUBFUNCTION_SELECT_MENU_SCRIPT",	"SELECT 'masters[\"'||a.subfunction_id||'\"]='''|| function_parameters ||'?module_id=' ||a.module_id||'&function_id='||a.subfunction_id||'&function_name='||subfunction_name||'&function_type='||subfunction_type||'&access='||b.insert_access_yn||b.update_access_yn||b.query_only_access_yn||b.delete_access_yn ||b.print_access_yn||''';' master FROM  sm_subfunction a,sm_menu_sfunc_dtl b WHERE a.module_id=? AND a.subfunction_id=b.subfunction_id");
		dataMap.put("SQL_SM_MASTER_CODE_SELECT_MENU",			"SELECT b.master_code,a.subfunction_id, b.master_code_desc,a.incl_yn FROM sm_menu_sfunc_dtl a,sm_master_code b WHERE a.function_id = (?) AND a.subfunction_id=b.table_id AND a.incl_yn = 'Y' ORDER BY b.master_code");

		/*CODE_SETUP ENDS*/
		/* JNDI locations start */
         dataMap.put( "JNDI_MM_MASTER_CODE", "java:comp/env/ejb/eMM/MasterCode");

			/* Queries for MM Supplier set up */
		//dataMap.put("SQL_MM_SUPPLIER_CODE_INSERT", "insert into ap_supplier (SUPP_CODE,SUPP_ALPHA_CODE,LONG_NAME,SHORT_NAME,ADDED_BY_ID,ADDED_DATE,MODIFIED_BY_ID,MODIFIED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,STATUS) values (?,?,?,?,?,sysdate,?,sysdate,?,?,?,?,?) ");
		dataMap.put("SQL_MM_SUPPLIER_CODE_INSERT", "insert into ap_supplier (SUPP_CODE,BANK_NO,SUPP_ALPHA_CODE,ACC_NO,SHORT_NAME,BANK_ACC_NAME,LONG_NAME,BRANCH_NO,ADD1_DESC,CURRENCY_CODE,ADD2_DESC,STATUS,ADD3_DESC,ZIP_DESC,TEL_NUM,FAX_NUM,EMAIL_ID,CONTACT_NAME_PUR,CONTACT_NAME_TITLE_PUR,ADDED_BY_ID,ADDED_DATE,MODIFIED_BY_ID,MODIFIED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,sysdate,?,?,?,?) ");

		
		dataMap.put("SQL_MM_SUPPLIER_GROUP_CODE_EXISTS" , "SELECT count(*) count FROM ap_supplier WHERE SUPP_CODE = ? " );
		dataMap.put("SQL_MM_SUPPLIER_CODE_QUERY_RESULT" , " select SUPP_CODE,LONG_NAME,SHORT_NAME,STATUS from ap_supplier_lang_vw ap_supplier where SUPP_CODE LIKE UPPER ( ? ) AND UPPER(SHORT_NAME) LIKE UPPER(?) AND nvl(status,'X') like ? AND language_id = ?");
		//dataMap.put("SQL_MM_SUPPLIER_CODE_SELECT_SINGLE" , " select SUPP_CODE,SUPP_ALPHA_CODE,LONG_NAME,SHORT_NAME,STATUS from ap_supplier_lang_vw where SUPP_CODE= ? AND language_id = ?" );
		dataMap.put("SQL_MM_SUPPLIER_CODE_SELECT_SINGLE" , " select SUPP_CODE,BANK_NO,SUPP_ALPHA_CODE,ACC_NO,SHORT_NAME,BANK_ACC_NAME,LONG_NAME,BRANCH_NO,ADD1_DESC,CURRENCY_CODE,ADD2_DESC,STATUS,ADD3_DESC,ZIP_DESC,TEL_NUM,FAX_NUM,EMAIL_ID,CONTACT_NAME_PUR,CONTACT_NAME_TITLE_PUR from ap_supplier_lang_vw where SUPP_CODE= ? AND language_id = ?" );


//		dataMap.put("SQL_MM_SUPPLIER_CODE_UPDATE", " UPDATE ap_supplier set SUPP_ALPHA_CODE=?,LONG_NAME=?,SHORT_NAME=?,ADDED_BY_ID=?,ADDED_DATE=SYSDATE,MODIFIED_BY_ID=?,MODIFIED_DATE=SYSDATE,ADDED_AT_WS_NO=?,ADDED_FACILITY_ID=?,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=?,STATUS=? where SUPP_CODE=? ");  // Modified on 5/31/2006 for updating modification details
		//dataMap.put("SQL_MM_SUPPLIER_CODE_UPDATE", " UPDATE ap_supplier set SUPP_ALPHA_CODE=?,LONG_NAME=?,SHORT_NAME=?, MODIFIED_BY_ID=?,MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=?,STATUS=? where SUPP_CODE=? ");
		dataMap.put("SQL_MM_SUPPLIER_CODE_UPDATE", " UPDATE ap_supplier set BANK_NO=?,SUPP_ALPHA_CODE=?,ACC_NO=?,SHORT_NAME=?,BANK_ACC_NAME=?,LONG_NAME=?,BRANCH_NO=?,ADD1_DESC=?,CURRENCY_CODE=?,ADD2_DESC=?,STATUS=?,ADD3_DESC=?,ZIP_DESC=?,TEL_NUM=?,FAX_NUM=?,EMAIL_ID=?,CONTACT_NAME_PUR=?,CONTACT_NAME_TITLE_PUR=?,MODIFIED_BY_ID=?,MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=? where SUPP_CODE=? ");


		dataMap.put("SQL_AP_SUPPLIER_SELECT_LOOKUP","SELECT supp_code code, short_name description FROM ap_supplier_lang_vw ap_supplier where status is null AND language_id LIKE ? AND NVL(ACC_ENTITY_CODE,'ZZ')='ZZ' AND supp_code LIKE UPPER(?) AND UPPER(short_name) LIKE UPPER(?)  order by short_name");
		dataMap.put("SQL_AP_MATERAILS_SELECT_LOOKUP","SELECT MATERIAL_GROUP_CODE code, SHORT_DESC description FROM  MM_MATERIAL_GROUP_LANG_VW MM_MATERIAL_GROUP WHERE EFF_STATUS='E' AND language_id LIKE ? AND MATERIAL_GROUP_CODE LIKE UPPER( ? ) AND UPPER(SHORT_DESC) LIKE UPPER(?) ORDER BY SHORT_DESC");

        /* JNDI locations end */
		/* Queries for MM Matrials Group Starts */
		 dataMap.put("SQL_MM_MATRIALS_GROUP_CODE_EXISTS","SELECT count(*) count FROM mm_material_group WHERE material_group_code = ? " );
		 dataMap.put("SQL_MM_MATRIALS_GROUP_INSERT_MASTER",	"INSERT INTO mm_material_group ( material_group_code, long_desc, short_desc, eff_status, added_by_id, added_date, added_at_ws_no, added_facility_id,modified_by_id, modified_date, modified_at_ws_no, modified_facility_id ) VALUES ( ?, ?, ?, ?, ?, SYSDATE, ?, ?, ?, SYSDATE, ?, ? )" );
		 dataMap.put("SQL_MM_MATRIALS_GROUP_UPDATE",	"UPDATE mm_material_group SET long_desc = ?, short_desc = ?, eff_status = ?, modified_by_id = ?, modified_date = SYSDATE, modified_at_ws_no = ?, modified_facility_id = ? WHERE material_group_code = ?" );
		 dataMap.put("SQL_MM_MATRIALS_GROUP_QUERYCRIT",	"SELECT material_group_code, long_desc, short_desc, eff_status FROM mm_material_group_lang_vw mm_material_group WHERE UPPER(material_group_code) LIKE UPPER(?) AND UPPER(short_desc) LIKE UPPER(?) AND eff_status LIKE UPPER(?) AND language_id = ?");
		 dataMap.put("SQL_MM_MATRIALS_GROUP_MODIFY",	"SELECT material_group_code, long_desc, short_desc, eff_status FROM mm_material_group_lang_vw WHERE material_group_code = ? AND LANGUAGE_ID=?");
		/* Queries for MM Matrials Group Ends */

		
		//for Materials Group in item master	

		// dataMap.put("SQL_MM_MATRIALS_GROUP_CODE_DESC",	"select SHORT_DESC,LONG_DESC from mm_material_group where EFF_STATUS ='E' and ADDED_FACILITY_ID=?");
		 dataMap.put("SQL_MM_MATRIALS_GROUP_CODE_DESC",	"select material_group_code,short_DESC from mm_material_group_lang_vw mm_material_group where EFF_STATUS ='E' AND language_id = ? ORDER BY short_desc");
		 dataMap.put("SQL_MM_MATRIALS_GROUP_CODE_DESC_1",	"SELECT  mm_material_group.material_group_code, mm_material_group.short_desc, 'I' db_action, 'D' eff_status  FROM mm_material_group_lang_vw mm_material_group  WHERE material_group_code NOT IN (SELECT material_group_code FROM  mm_user_material_group WHERE user_id =? ) and mm_material_group.language_id=? and mm_material_group.eff_status = 'E' UNION ALL SELECT   mm_material_group.material_group_code, mm_material_group.short_desc,'U' db_action,  a.eff_status FROM mm_material_group_lang_vw mm_material_group,mm_user_material_group a WHERE mm_material_group.language_id=? and a.user_id =?  and mm_material_group.material_group_code=a.material_group_code and mm_material_group.eff_status = 'E' ORDER BY 2");


		/* For Administration-->User acces for store */
		dataMap.put("SQL_SM_APPL_USER_USER_LOOK_UP", "SELECT appl_user_id code,	appl_user_name description FROM	sm_appl_user_lang_vw sm_appl_user where appl_user_id	like UPPER(?) AND UPPER(appl_user_name)	like UPPER(?) AND eff_status='E' AND language_id = ");
		dataMap.put("SQL_MM_MATRIALS_GROUP_EXIST_SELECT","SELECT material_group_code FROM mm_user_material_group WHERE user_id =?");
		dataMap.put("SQL_MM_MATRIALS_GROUP_INSERT","INSERT INTO MM_USER_MATERIAL_GROUP( USER_ID,MATERIAL_GROUP_CODE,EFF_STATUS, ADDED_BY_ID, ADDED_DATE,ADDED_AT_WS_NO, ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID ) VALUES  (? ,? ,? ,?,SYSDATE, ?, ?,?,SYSDATE,?,?)");			
		dataMap.put("SQL_MM_PARAMAETER_SELECT1", "select st_period_end_scope from mm_parameter"); 
			// Ends Function 1
	/*Friday, August 13, 2004 Item Master*/
		//dataMap.put("SQL_MM_ITEM_MATRIALS_QUERY","SELECT DISTINCT b.item_code,b.short_desc,b.alpha_code,h.SHORT_DESC MATERIAL_GROUP_CODE ,DECODE(b.CATEGORY_TYPE_CODE,'ST','Inventory','NS','Non Inventory','Asserts') CATEGORY_TYPE_CODE ,c.SHORT_DESC item_class,b.EFF_STATUS ,b.GEN_UOM_CODE  FROM MM_ITEM_LANG_VW	b,MM_ITEM_CLASS_LANG_VW	c,AM_UOM_LANG_VW d ,AM_MANUFACTURER_LANG_VW	e,MM_TRADE_NAME_FOR_ITEM f,AM_TRADE_NAME_LANG_VW g ,mm_material_group_lang_vw h WHERE b.eff_status='E'  AND b.ITEM_CLASS_CODE=c.ITEM_CLASS_CODE(+) AND b.gen_uom_code=d.uom_code(+) AND	b.manufacturer_id=e.manufacturer_id(+) AND b.item_code=f.item_code(+) AND	   f.trade_id=g.trade_id(+)AND b.MATERIAL_GROUP_CODE = h.MATERIAL_GROUP_CODE(+) AND b.CATEGORY_TYPE_CODE = 'ST' AND UPPER(b.item_code) LIKE	UPPER(NVL(?,'%')) AND UPPER(b.short_desc) LIKE UPPER(NVL(?,'%')) AND UPPER(b.alpha_code) LIKE UPPER(NVL(?,'%')) AND UPPER(NVL(f.trade_id,'%'))  LIKE	UPPER(NVL(?,'%')) AND UPPER(NVL(g.short_name,'%')) LIKE UPPER(NVL(?,'%'))	 AND b.ps_item_yn LIKE DECODE(?,'A','%',?) AND b.sole_source_yn LIKE DECODE(?,'A','%',?) AND NVL(b.manufacturer_id,'%')LIKE DECODE(?,'','%',?)	AND NVL(b.ITEM_CLASS_CODE,'%')LIKE DECODE(?,'','%',?) AND NVL(b.ITEM_ANAL1_CODE,'%')LIKE DECODE(?,'','%',?) AND	NVL(b.ITEM_ANAL2_CODE,'%')LIKE DECODE(?,'','%',?) AND NVL(b.ITEM_ANAL3_CODE,'%')LIKE DECODE(?,'','%',?) AND UPPER(NVL(b.ITEM_REMARKS ,'%')) LIKE	UPPER(NVL(?,'%')) AND b.EFF_STATUS LIKE DECODE(?,'A','%',?) AND b.SPECIAL_ITEM_YN LIKE DECODE(?,'A','%',?) AND b.language_id= c.language_id(+) AND b.language_id= d.language_id(+) AND b.language_id= e.language_id(+) AND b.language_id= h.language_id(+) AND b.language_id = ? AND g.language_id(+) = ?"); 
		dataMap.put("SQL_MM_ITEM_MATRIALS_QUERY","SELECT DISTINCT b.item_code,b.short_desc,b.alpha_code,h.SHORT_DESC MATERIAL_GROUP_CODE ,DECODE(b.CATEGORY_TYPE_CODE,'ST','Inventory','NS','Non Inventory','Asserts') CATEGORY_TYPE_CODE ,c.SHORT_DESC item_class,b.EFF_STATUS ,b.GEN_UOM_CODE, d.SHORT_DESC gen_uom_desc FROM MM_ITEM_LANG_VW	b,MM_ITEM_CLASS_LANG_VW	c,AM_UOM_LANG_VW d ,AM_MANUFACTURER_LANG_VW	e,MM_TRADE_NAME_FOR_ITEM f,AM_TRADE_NAME_LANG_VW g ,mm_material_group_lang_vw h WHERE b.eff_status='E'  AND b.ITEM_CLASS_CODE=c.ITEM_CLASS_CODE(+) AND b.gen_uom_code=d.uom_code(+) AND	b.manufacturer_id=e.manufacturer_id(+) AND b.item_code=f.item_code(+) AND	   f.trade_id=g.trade_id(+)AND b.MATERIAL_GROUP_CODE = h.MATERIAL_GROUP_CODE(+) AND b.CATEGORY_TYPE_CODE = 'ST' AND UPPER(b.item_code) LIKE	UPPER(NVL(?,'%')) AND UPPER(b.short_desc) LIKE UPPER(NVL(?,'%')) AND UPPER(b.alpha_code) LIKE UPPER(NVL(?,'%')) AND UPPER(NVL(f.trade_id,'%'))  LIKE	UPPER(NVL(?,'%')) AND UPPER(NVL(g.short_name,'%')) LIKE UPPER(NVL(?,'%'))	 AND b.ps_item_yn LIKE DECODE(?,'A','%',?) AND b.sole_source_yn LIKE DECODE(?,'A','%',?) AND NVL(b.manufacturer_id,'%')LIKE DECODE(?,'','%',?)	AND NVL(b.ITEM_CLASS_CODE,'%')LIKE DECODE(?,'','%',?) AND NVL(b.ITEM_ANAL1_CODE,'%')LIKE DECODE(?,'','%',?) AND	NVL(b.ITEM_ANAL2_CODE,'%')LIKE DECODE(?,'','%',?) AND NVL(b.ITEM_ANAL3_CODE,'%')LIKE DECODE(?,'','%',?) AND UPPER(NVL(b.ITEM_REMARKS ,'%')) LIKE	UPPER(NVL(?,'%')) AND b.EFF_STATUS LIKE DECODE(?,'A','%',?) AND b.SPECIAL_ITEM_YN LIKE DECODE(?,'A','%',?) AND b.language_id= c.language_id(+) AND b.language_id= d.language_id(+) AND b.language_id= e.language_id(+) AND b.language_id= h.language_id(+) AND b.language_id = ? AND g.language_id(+) = ?");//Added gen_uom_desc against ML-MMOH-SCF-0382 


		dataMap.put("SQL_MM_ITEM_UOM_DEFN_INSERT","INSERT INTO MM_ITEM_UOM_DEFN (ITEM_CODE,UOM_CODE,EQVL_UOM_CODE,EQVL_VALUE,EFF_STATUS,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID)VALUES(?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)");
		dataMap.put("SQL_MM_ITEM_UOM_DEFN_CODE_EXISTS","SELECT COUNT(*) FROM MM_ITEM_UOM_DEFN WHERE ITEM_CODE=? AND UOM_CODE=? AND EQVL_UOM_CODE=? ");
		dataMap.put("SQL_MM_ITEM_UOM_DEFN_SELECT","SELECT ITEM_CODE, UOM_CODE, EQVL_UOM_CODE,EQVL_VALUE,EFF_STATUS FROM MM_ITEM_UOM_DEFN WHERE ITEM_CODE=?");
		dataMap.put("SQL_MM_ITEM_UOM_DEFN_SELECT_EQUI_UOM","SELECT uom_code,short_desc FROM am_uom_lang_vw WHERE stock_uom_yn='Y' AND eff_status = 'E' AND language_id = ? ORDER BY short_desc");
		dataMap.put("SQL_MM_ITEM_UOM_DEFN_SELECT_UOM","SELECT uom_code,short_desc FROM am_uom_lang_vw WHERE stock_uom_yn='Y' AND eff_status = 'E' AND language_id = ? ORDER BY short_desc");
		dataMap.put("SQL_MM_ITEM_UOM_DEFN_UPDATE","UPDATE MM_ITEM_UOM_DEFN SET  EQVL_VALUE = ?, EFF_STATUS = ?, MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?,MODIFIED_FACILITY_ID= ? WHERE ITEM_CODE= ? AND UOM_CODE = ? AND EQVL_UOM_CODE =?");
		dataMap.put("SQL_MM_ITEM_UOM_DEFN_QUERYCRIT","SELECT IUD.ITEM_CODE, MI.SHORT_DESC ITEM_DESC , IUD.UOM_CODE,AU.SHORT_DESC UOM_DESC , IUD.EQVL_UOM_CODE,AU1.SHORT_DESC EQVL_UOM_DESC , IUD.EQVL_VALUE EQVL_VALUE, IUD.EFF_STATUS EFF_STATUS FROM   MM_ITEM_UOM_DEFN IUD, MM_ITEM MI, AM_UOM AU, AM_UOM AU1  WHERE  MI.ITEM_CODE = IUD.ITEM_CODE  AND AU.UOM_CODE = IUD. UOM_CODE AND AU1.UOM_CODE = IUD.EQVL_UOM_CODE AND  upper(IUD.ITEM_CODE) LIKE Upper(?) AND upper(MI.SHORT_DESC) LIKE UPPER(?) AND upper(IUD.UOM_CODE) LIKE Upper(?)   AND upper(AU.SHORT_DESC) LIKE Upper(?)  AND AU1.UOM_CODE LIKE Upper(?)     AND upper(AU1.SHORT_DESC) LIKE Upper(?)  AND upper(IUD.EFF_STATUS) LIKE Upper(?)");
		dataMap.put("SQL_MM_VIEW_COST_QUERYCRITERIA","Select a.appl_user_id APPL_USER_ID, b.appl_user_name APPL_USER_NAME, a.view_cost_yn VIEW_COST_YN from MM_VIEW_COST_FOR_USER a, sm_appl_user b where  a.appl_user_id = b.appl_user_id and upper(a.appl_user_id) like upper(?) and upper(b.appl_user_name) like upper(?) and upper(a.view_cost_yn) like upper(?)");
		dataMap.put("SQL_MM_BIN_LOCATION_SELECT", "SELECT store_code,short_desc FROM mm_store_lang_vw mm_store WHERE eff_status='E' AND language_id = ?  AND facility_id = ? ORDER BY short_desc");
		dataMap.put("SQL_MM_USER_MATERIAL_GROUP_UPDATE","update mm_user_material_group  set eff_status=?,modified_by_id=?,modified_date=sysdate,modified_at_ws_no=?,modified_facility_id=? where user_id=? and material_group_code=?");		
		dataMap.put("SQL_AP_CURRENCY_CODE_SELECT_SINGLE","SELECT currency_code, short_desc FROM sy_foreign_currency_lang_vw WHERE language_id = ? ORDER BY 2");

		//CRF-29966
		dataMap.put("SQL_MM_ITEM_LOOKUP_FOR_ITEM_IMAGE",					"SELECT b.item_code code,short_desc description FROM mm_item_lang_vw mm_item , st_item b WHERE eff_status = 'E'  AND mm_item.item_code = b.item_code AND b.item_code LIKE UPPER(?)  AND  UPPER(short_desc) LIKE UPPER(?)  AND language_id = ");

		dataMap.put("SQL_MM_ITEM_IMAGE_CATLG_INSERT",		"INSERT INTO MM_ITEM_IMAGE_CATLG ( FACILITY_ID, ITEM_CODE, SRL_NO, FILE_NAME,  added_by_id, added_date, added_at_ws_no, added_facility_id,modified_by_id, modified_date, modified_at_ws_no, modified_facility_id ) VALUES ( ?, ?, ?, ?, ?, SYSDATE, ?, ?, ?, SYSDATE, ?, ? )" );
		
		dataMap.put("SQL_MM_ITEM_IMAGE_CATLG_QUERYCRIT",	"SELECT a.item_code, b.SHORT_DESC SHORT_DESC, srl_no, file_name FROM mm_item_image_catlg a, mm_item b WHERE  a.item_code = b.item_code AND UPPER (a.item_code) LIKE UPPER (?) AND UPPER (b.SHORT_DESC) LIKE UPPER (?) AND FACILITY_ID = ? AND UPPER (FILE_NAME) LIKE UPPER (?)");

		dataMap.put("SQL_MM_ITEM_IMAGE_CATLG_UPDATE",		"UPDATE MM_ITEM_IMAGE_CATLG SET FILE_NAME = ?,  modified_by_id = ?, modified_date = SYSDATE, modified_at_ws_no = ?, modified_facility_id = ? WHERE ITEM_CODE = ? AND FACILITY_ID=? AND SRL_NO=?" );
		dataMap.put("SQL_MM_ITEM_IMAGE_CATLG_DELETE",		"DELETE FROM  MM_ITEM_IMAGE_CATLG  WHERE ITEM_CODE = ? AND FACILITY_ID=? AND SRL_NO=?" );
		dataMap.put("SQL_MP_COUNTRY_CODE_SELECT_SINGLE",	"SELECT COUNTRY_CODE, SHORT_NAME FROM mp_country_lang_vw WHERE language_id = ? ORDER BY 2");
		dataMap.put("SQL_ST_PO_ENTITY_PARAMETERS",	"SELECT INTERFACE_TO_EXTERNAL_PO_YN FROM ST_ACC_ENTITY_PARAM WHERE ACC_ENTITY_ID = ?");//Added for GDOH-CRF-0109
		dataMap.put("SQL_MM_ITEM_TOT_QTY_ON_HAND",	"select sum(qty_on_hand) SUM from st_item_store where item_code = ?");//Added for GHL-CRF-0405
		 
		dataMap.put("SQL_MM_ITEM_TECH_NAME",	"select item_tech_name_code code,short_desc description from mm_item_tech_name_lang_vw where item_tech_name_code like upper(?) and upper(short_desc) like upper(?) AND language_id = ");//Sharanraj GHL-CRF-0548.1
		
		/* Queries for MM Catalog Code Starts - MO-CRF-20165 */   
		dataMap.put("SQL_MM_CATALOG_CODE_INSERT",			"INSERT INTO MM_CATALOG_CODE ( catalog_code, long_desc, short_desc, eff_status, added_by_id, added_date, added_at_ws_no, added_facility_id,modified_by_id, modified_date, modified_at_ws_no, modified_facility_id ) VALUES ( ?, ?, ?, ?, ?, SYSDATE, ?, ?, ?, SYSDATE, ?, ? )" );
		 dataMap.put("SQL_MM_CATALOG_CODE_EXISTS",	"SELECT count(*) count FROM MM_CATALOG_CODE WHERE catalog_code = ? " );
		 dataMap.put("SQL_MM_CATALOG_CODE_UPDATE",			"UPDATE MM_CATALOG_CODE SET long_desc = ?, short_desc = ?, eff_status = ?, modified_by_id = ?, modified_date = SYSDATE, modified_at_ws_no = ?, modified_facility_id = ? WHERE catalog_code = ?" );
		 dataMap.put("SQL_MM_CATALOG_CODE_QUERYCRIT",		"SELECT catalog_code, long_desc, short_desc, eff_status FROM MM_CATALOG_CODE  WHERE UPPER(catalog_code) LIKE UPPER(?) AND UPPER(short_desc) LIKE UPPER(?) AND eff_status LIKE UPPER(?) "); 
		 dataMap.put("SQL_MM_CATALOG_CODE_MODIFY",			"SELECT catalog_code, long_desc, short_desc, eff_status FROM MM_CATALOG_CODE WHERE catalog_code = ?");
		/* Queries for MM Catalog Code Ends */  
		dataMap.put("SQL_MM_USER_ACCESS_FOR_METERIAL_USER_LOOKUP_SELECT", "SELECT appl_user_id code, appl_user_name description FROM	sm_appl_user_lang_vw sm_appl_user where appl_user_id	like UPPER(?) AND UPPER(appl_user_name)	like UPPER(?) AND eff_status='E' AND language_id = '~LOCALE_ID`'");
		dataMap.put("SQL_MM_TRADE_NAME_FOR_ITEM_TRADENAME_LOOKUP",				"SELECT am.trade_id code,am.long_name description FROM am_trade_name_lang_vw am WHERE am.eff_status = 'E'   AND am.trade_id LIKE (?)  AND  UPPER(am.long_name) LIKE UPPER(?) AND language_id  = '~LOCALE_ID`'  ORDER BY 2");
		dataMap.put("SQL_MM_TRADENAMEFORITEM_ITEM_LOOKUP",					"SELECT item_code code,long_desc description FROM mm_item_lang_vw mm_item WHERE eff_status = 'E'  AND sole_source_yn = 'N' AND item_code LIKE UPPER(?)  AND  UPPER(long_desc) LIKE UPPER(?) AND language_id = '~LOCALE_ID`' ORDER BY long_desc");
		dataMap.put("SQL_MM_TRADENAMEFORITEM_ITEM_LOOKUP_MOHE",		"SELECT item_code code,long_desc description FROM mm_item_lang_vw mm_item WHERE eff_status = 'E' AND item_code LIKE UPPER(?)  AND  UPPER(long_desc) LIKE UPPER(?) AND language_id = '~LOCALE_ID`' ORDER BY long_desc"); //Added for MOHE-CRF-0167 US001
	}  
}
