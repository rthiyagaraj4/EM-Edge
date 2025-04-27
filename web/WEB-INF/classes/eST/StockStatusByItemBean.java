/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eST;

import eST.Common.StTransaction;
import java.io.Serializable;
import java.util.HashMap;
import java.util.ArrayList;

public class StockStatusByItemBean extends StTransaction implements Serializable{

	private String item_code;
	private String stock_qty;
	private String reorder_level;
	private String class_desc;
	private String pack_size;
	private String reorder_store;
	private String last_issue_store_desc;
	private String last_issue_date;
	private String sole_source;
	private String special_item;
	private String anal3_desc;
	private String item_remarks;
	private String manufacturer_name;
	private String anal1_desc;
	private String autoclaveable;
	private String anal2_desc;
	private String qty_primary_store;
	private String bin_location;
	private String store_code;
	private String item_specification;
	private String mtd_rec_qty;
	private String mtd_iss_qty;
	private String ytd_issue_qty;
	private String ytd_cons_qty;
	private String mtd_cons_qty;

	public String getYtd_cons_qty() {
		 return ytd_cons_qty;
	}
	public String getMtd_cons_qty() {
		 return mtd_cons_qty;
	}
	
	public String getMtd_rec_qty() {
		 return mtd_rec_qty;
	}

	public String getMtd_iss_qty() {
		 return mtd_iss_qty;
	}

	public String getYtd_issue_qty() {
		 return ytd_issue_qty;
	}

	public String getItem_specification() {
		 return item_specification;
	}

	public String getQty_primary_store() {
		 return qty_primary_store;
	}
	
	public String getBin_location() {
		 return bin_location;
	}
	
	public void setStore_code(String store_code) {
		 this.store_code = store_code;  
	}

	public String getStore_code( ) {
		 return store_code;
	}

	public void setItem_code(String item_code) {
		 this.item_code = item_code;  
	}

	public String getItem_code( ) {
		 return item_code;
	}

	public String getLast_issue_store_desc( ) {
		 return last_issue_store_desc;
	}

	public String getLast_issue_date( ) {
		 return last_issue_date;
	}

	public String getStock_qty( ) {
			 return stock_qty;
	}

	public String getReorder_level( ) {
		 return reorder_level;
	}

	public String getReorder_store( ) {
		 return reorder_store;
	}

	public String getClass_desc( ) {
		 return class_desc;
	}

	public String getPack_size( ) {
		 return pack_size;
	}
	
	public String getSole_source( ) {
		 return sole_source;
	}
	
	public String getSpecial_item( ) {
		 return special_item;
	}

	public String getAnal3_desc( ) {
		 return anal3_desc;
	}
	
	public String getItem_remarks( ) {
		 return item_remarks;
	}
	
	public String getManufacturer_name( ) {
		 return manufacturer_name;
	}

	public String getAnal1_desc( ) {
		 return anal1_desc;
	}

	public String getAutoclaveable( ) {
		 return autoclaveable;
	}
	
	public String getAnal2_desc( ) {
		 return anal2_desc;
	}

	public void loadData() throws Exception {	
		try	{
		HashMap hmRecord			=		null;
		HashMap hmRecord_bin		=		null;
		HashMap hmRecord_ytd		=		null;
		

		ArrayList alParameters		=		new ArrayList();
		ArrayList alParameters1		=		new ArrayList();
		if (!this.store_code.equals(""))	{
			alParameters.add(this.store_code);
		}
		alParameters.add(this.item_code);
		alParameters.add(getLanguageId());
		alParameters.add(getLoginById());  //CRF792

		ArrayList alParameters_lang	=		new ArrayList();
		alParameters_lang.add(this.item_code);
		alParameters_lang.add(getLanguageId());
		alParameters_lang.add(getLoginFacilityId());
		alParameters_lang.add(getLoginById()); //CRF792

		if (this.store_code.equals(""))	{
		/*** CRF792 **/	
		 //hmRecord				=		fetchRecord(getStRepositoryValue("SQL_ST_STOCK_STATUS_BY_ITEM_SELECT2"), alParameters_lang);
		 hmRecord				=		fetchRecord("SELECT   SOLE_SOURCE, SPECIAL_ITEM, ITEM_REMARKS, AUTOCLAVEABLE,MANUFACTURER_NAME, ANAL1_DESC, ANAL2_DESC, ANAL3_DESC,ITEM_CLASS_CODE, ITEM_CLASS_DESC, CURR_PACK_SIZE, REORDER_LEVEL,SUM (NVL (QTY_ON_HAND, 0) * EQVL_VALUE) QTY_ON_HAND,TO_CHAR (MAX (TO_DATE (LAST_ISSUE_DATE, 'dd/mm/yyyy')),'dd/mm/yyyy') LAST_ISSUE_DATE,SUM (NVL (QTY_REORDER_STORE, 0) * EQVL_VALUE) QTY_REORDER_STORE,SUM (NVL (QTY_OTHER_STORE, 0) * EQVL_VALUE) QTY_OTHER_STORE,SUM (NVL (QTY_PRIMARY_STORE, 0) * EQVL_VALUE) QTY_PRIMARY_STORE,ITEM_SPECIFICATION FROM (SELECT   STORE_CODE, SOLE_SOURCE, SPECIAL_ITEM, ITEM_REMARKS,AUTOCLAVEABLE, MANUFACTURER_NAME, ANAL1_DESC, ANAL2_DESC,ANAL3_DESC, ITEM_CLASS_CODE, ITEM_CLASS_DESC,CURR_PACK_SIZE, REORDER_LEVEL, SUM (QOH) QTY_ON_HAND,LAST_ISSUE_DATE,SUM(CASE WHEN CHK_STK_LVL_FOR_PUR_YN = 'Y' THEN NVL (QOH, 0) ELSE 0 END) QTY_REORDER_STORE,SUM(CASE WHEN CHK_STK_LVL_FOR_PUR_YN = 'N' THEN NVL (QOH, 0) ELSE 0 END) QTY_OTHER_STORE,SUM (CASE WHEN STORE_CODE = '' THEN NVL (QOH, 0) ELSE 0 END) QTY_PRIMARY_STORE,EQVL_VALUE, ITEM_SPECIFICATION FROM (SELECT DISTINCT D.STORE_CODE STORE_CODE,B.SOLE_SOURCE_YN SOLE_SOURCE,B.SPECIAL_ITEM_YN SPECIAL_ITEM,B.ITEM_REMARKS ITEM_REMARKS,A.AUTOCLAVEABLE_YN AUTOCLAVEABLE,F.SHORT_NAME MANUFACTURER_NAME,G.SHORT_DESC ANAL1_DESC,H.SHORT_DESC ANAL2_DESC,I.SHORT_DESC ANAL3_DESC,B.ITEM_CLASS_CODE ITEM_CLASS_CODE,C.SHORT_DESC ITEM_CLASS_DESC,A.CURR_PACK_SIZE CURR_PACK_SIZE,A.REORDER_LEVEL REORDER_LEVEL,D.QTY_ON_HAND QOH,(SELECT EQVL_VALUE FROM MM_ITEM_UOM_DEFN WHERE ITEM_CODE = D.ITEM_CODE AND EQVL_UOM_CODE = D.DEF_ISSUE_UOM AND UOM_CODE = B.GEN_UOM_CODE UNION SELECT EQVL_VALUE FROM AM_UOM_EQVL WHERE EQVL_UOM_CODE = D.DEF_ISSUE_UOM AND UOM_CODE = GEN_UOM_CODE UNION SELECT 1 FROM DUAL WHERE D.DEF_ISSUE_UOM = B.GEN_UOM_CODE) EQVL_VALUE,TO_CHAR(NVL (D.LAST_ISSUE_DATE,TO_DATE ('01/01/1800','dd/mm/yyyy')),'dd/mm/yyyy') LAST_ISSUE_DATE,E.CHK_STK_LVL_FOR_PUR_YN CHK_STK_LVL_FOR_PUR_YN,D.ITEM_CODE ITEM_CODE,D.DEF_ISSUE_UOM DEF_ISSUE_UOM,B.GEN_UOM_CODE GEN_UOM_CODE,B.ITEM_SPECIFICATION ITEM_SPECIFICATION FROM ST_ITEM A,MM_ITEM_LANG_VW B,MM_ITEM_CLASS_LANG_VW C,ST_ITEM_STORE D,ST_STORE E,AM_MANUFACTURER_LANG_VW F,MM_ITEM_ANALYSIS_LANG_VW G,MM_ITEM_ANALYSIS_LANG_VW H,MM_ITEM_ANALYSIS_LANG_VW I,MM_STORE_LANG_VW J,ST_ACC_ENTITY_PARAM K,ST_USER_ACCESS_FOR_STORE L WHERE A.ITEM_CODE = B.ITEM_CODE AND B.ITEM_CLASS_CODE = C.ITEM_CLASS_CODE AND D.STORE_CODE = E.STORE_CODE AND A.ITEM_CODE = D.ITEM_CODE AND B.EFF_STATUS = 'E' AND B.MANUFACTURER_ID = F.MANUFACTURER_ID(+) AND B.ITEM_ANAL1_CODE = G.ITEM_ANAL_CODE(+) AND B.ITEM_ANAL2_CODE = H.ITEM_ANAL_CODE(+) AND B.ITEM_ANAL3_CODE = I.ITEM_ANAL_CODE(+) AND A.ITEM_CODE = ? AND B.LANGUAGE_ID = F.LANGUAGE_ID(+) AND B.LANGUAGE_ID = G.LANGUAGE_ID(+) AND B.LANGUAGE_ID = H.LANGUAGE_ID(+) AND B.LANGUAGE_ID = I.LANGUAGE_ID(+) AND B.LANGUAGE_ID = C.LANGUAGE_ID AND B.LANGUAGE_ID = ? AND J.FACILITY_ID LIKE ? AND J.STORE_CODE = D.STORE_CODE AND J.LANGUAGE_ID = B.LANGUAGE_ID AND L.USER_ID LIKE DECODE (K.RESTRICT_VIEW_STK_STATUS,'ALL', '%',?) AND D.STORE_CODE = L.STORE_CODE) GROUP BY ITEM_CLASS_CODE,ITEM_CLASS_DESC,CURR_PACK_SIZE,REORDER_LEVEL,SOLE_SOURCE,SPECIAL_ITEM,ITEM_REMARKS,AUTOCLAVEABLE,MANUFACTURER_NAME,ANAL1_DESC,ANAL2_DESC,ANAL3_DESC,ITEM_CODE,DEF_ISSUE_UOM,GEN_UOM_CODE,LAST_ISSUE_DATE,STORE_CODE,ITEM_SPECIFICATION,EQVL_VALUE) GROUP BY SOLE_SOURCE,SPECIAL_ITEM,ITEM_REMARKS,AUTOCLAVEABLE,MANUFACTURER_NAME,ANAL1_DESC,ANAL2_DESC,ANAL3_DESC,ITEM_CLASS_CODE,ITEM_CLASS_DESC,CURR_PACK_SIZE,REORDER_LEVEL,ITEM_SPECIFICATION",alParameters_lang); 		 
		  hmRecord_bin		=		fetchRecord(getStRepositoryValue("SQL_ST_STOCK_STATUS_BY_ITEM_BIN_LOC2"), this.item_code);
		  /***==== CRF792 ====**/
		}
		else {
			/*** CRF792 **/
		 //hmRecord				=		fetchRecord(getStRepositoryValue("SQL_ST_STOCK_STATUS_BY_ITEM_SELECT"), alParameters);
		  hmRecord = fetchRecord("SELECT   SOLE_SOURCE, SPECIAL_ITEM, ITEM_REMARKS, AUTOCLAVEABLE, MANUFACTURER_NAME,   ANAL1_DESC, ANAL2_DESC, ANAL3_DESC, ITEM_CLASS_CODE, ITEM_CLASS_DESC, CURR_PACK_SIZE,    REORDER_LEVEL, SUM (QOH) QTY_ON_HAND, TO_CHAR (MAX (TO_DATE(LAST_ISSUE_DATE1, 'DD/MM/YYYY')),'DD/MM/YYYY') LAST_ISSUE_DATE, SUM(CASE WHEN CHK_STK_LVL_FOR_PUR_YN = 'Y' THEN QOH ELSE 0 END ) QTY_REORDER_STORE, SUM(CASE WHEN CHK_STK_LVL_FOR_PUR_YN = 'N' THEN QOH ELSE 0 END ) QTY_OTHER_STORE, SUM(CASE WHEN STORE_CODE = ? THEN QOH ELSE 0 END ) QTY_PRIMARY_STORE, ITEM_SPECIFICATION FROM ( SELECT   DISTINCT B.SOLE_SOURCE_YN SOLE_SOURCE, B.SPECIAL_ITEM_YN SPECIAL_ITEM, B.ITEM_REMARKS ITEM_REMARKS, A.AUTOCLAVEABLE_YN AUTOCLAVEABLE, F.SHORT_NAME MANUFACTURER_NAME, G.SHORT_DESC ANAL1_DESC,           H.SHORT_DESC ANAL2_DESC, I.SHORT_DESC ANAL3_DESC, B.ITEM_CLASS_CODE ITEM_CLASS_CODE, C.SHORT_DESC ITEM_CLASS_DESC, A.CURR_PACK_SIZE CURR_PACK_SIZE, A.REORDER_LEVEL REORDER_LEVEL,  D.QTY_ON_HAND QOH, D.LAST_ISSUE_DATE LAST_ISSUE_DATE1, E.CHK_STK_LVL_FOR_PUR_YN CHK_STK_LVL_FOR_PUR_YN, D.STORE_CODE STORE_CODE, B.ITEM_SPECIFICATION ITEM_SPECIFICATION FROM ST_ITEM A, MM_ITEM_LANG_VW B,           MM_ITEM_CLASS_LANG_VW C, ST_ITEM_STORE D, ST_STORE E, AM_MANUFACTURER_LANG_VW F, MM_ITEM_ANALYSIS_LANG_VW G, MM_ITEM_ANALYSIS_LANG_VW H, MM_ITEM_ANALYSIS_LANG_VW I, ST_ACC_ENTITY_PARAM K, ST_USER_ACCESS_FOR_STORE L WHERE A.ITEM_CODE = B.ITEM_CODE AND B.ITEM_CLASS_CODE = C.ITEM_CLASS_CODE AND D.STORE_CODE = E.STORE_CODE AND A.ITEM_CODE = D.ITEM_CODE AND B.EFF_STATUS = 'E' AND B.MANUFACTURER_ID = F.MANUFACTURER_ID(+) AND B.ITEM_ANAL1_CODE = G.ITEM_ANAL_CODE(+) AND B.ITEM_ANAL2_CODE = H.ITEM_ANAL_CODE(+) AND B.ITEM_ANAL3_CODE = I.ITEM_ANAL_CODE(+) AND A.ITEM_CODE = ? AND B.LANGUAGE_ID = F.LANGUAGE_ID(+) AND B.LANGUAGE_ID = G.LANGUAGE_ID(+) AND B.LANGUAGE_ID = H.LANGUAGE_ID(+) AND B.LANGUAGE_ID = I.LANGUAGE_ID(+) AND B.LANGUAGE_ID = C.LANGUAGE_ID AND B.LANGUAGE_ID = ? AND L.USER_ID LIKE DECODE (K.RESTRICT_VIEW_STK_STATUS, 'ALL', '%', ? ) AND D.STORE_CODE = L.STORE_CODE)  GROUP BY ITEM_CLASS_CODE, ITEM_CLASS_DESC, CURR_PACK_SIZE, REORDER_LEVEL, SOLE_SOURCE, SPECIAL_ITEM, ITEM_REMARKS, AUTOCLAVEABLE, MANUFACTURER_NAME, ANAL1_DESC, ANAL2_DESC, ANAL3_DESC, ITEM_SPECIFICATION",alParameters);
	     hmRecord_bin			=		fetchRecord(getStRepositoryValue("SQL_ST_STOCK_STATUS_BY_ITEM_BIN_LOC"), alParameters);
		 bin_location			=		(String)hmRecord_bin.get("BIN_DESC");
		 /***==== CRF792 ====**/
		}
		/*** CRF792 **/
		//ArrayList alParameters_lang_1	=		new ArrayList();
		//alParameters_lang_1.add(this.item_code);
		//alParameters_lang_1.add(getLanguageId());
		//HashMap hmRecord_sp		=		fetchRecord(getStRepositoryValue("SQL_ST_STOCK_STATUS_BY_ITEM_STORE_SP"), alParameters_lang_1);
		/***==== CRF792 ====**/
		alParameters1.add(login_facility_id);
		alParameters1.add(this.item_code);
		/*** CRF792 **/
		alParameters1.add(getLoginById());
		//hmRecord_ytd			=		fetchRecord("SELECT SUM (CASE WHEN CURR_PROC_MONTH = MOVE_MONTH THEN GRN_QTY ELSE 0 END) MTD_REC_QTY, SUM (CASE WHEN CURR_PROC_MONTH = MOVE_MONTH AND CURR_PROC_YEAR = MOVE_YEAR THEN   NVL (ABS (OUT_ISS_QTY_NS), 0) + NVL (ABS (OUT_ISS_QTY_ST), 0) + NVL (ABS (OUT_URG_QTY_NS), 0) + NVL (ABS (OUT_URG_QTY_ST), 0)  ELSE 0 END ) MTD_ISS_QTY, SUM (CASE WHEN CURR_PROC_YEAR = MOVE_YEAR THEN NVL (ABS (OUT_ISS_QTY_NS), 0) + NVL (ABS (OUT_ISS_QTY_ST), 0) + NVL (ABS (OUT_URG_QTY_NS), 0) + NVL (ABS (OUT_URG_QTY_ST), 0) ELSE 0 END ) YTD_ISSUE_QTY FROM ST_ITEM_MOVE_SUMM A, ST_FACILITY_PARAM B  WHERE B.FACILITY_ID = ? AND A.ITEM_CODE =? AND A.MOVE_YEAR = B.CURR_PROC_YEAR", alParameters1);

		//hmRecord_ytd = fetchRecord("SELECT SUM (CASE WHEN curr_proc_month = move_month THEN grn_qty ELSE 0 END) mtd_rec_qty, SUM (CASE WHEN curr_proc_month = move_month AND curr_proc_year = move_year THEN   NVL (ABS (out_iss_qty_ns), 0) + NVL (ABS (out_iss_qty_st), 0) + NVL (ABS (out_urg_qty_ns), 0) + NVL (ABS (out_urg_qty_st), 0) ELSE 0 END ) mtd_iss_qty, SUM (CASE WHEN curr_proc_year = move_year THEN   NVL (ABS (out_iss_qty_ns), 0) + NVL (ABS (out_iss_qty_st), 0) + NVL (ABS (out_urg_qty_ns), 0) + NVL (ABS (out_urg_qty_st), 0) ELSE 0 END ) ytd_issue_qty   FROM (SELECT DISTINCT b.curr_proc_year curr_proc_year, move_year, b.curr_proc_month curr_proc_month, move_month, grn_qty, out_iss_qty_ns, out_iss_qty_st, out_urg_qty_ns, out_urg_qty_st FROM st_item_move_summ a, st_facility_param b, st_acc_entity_param c, st_user_access_for_store d WHERE b.facility_id = ? AND a.item_code = ? AND a.move_year = b.curr_proc_year AND d.user_id LIKE DECODE (c.restrict_view_stk_status, 'ALL', '%', ? ) AND a.store_code = d.store_code)", alParameters1);
		
		//Added by Rabbani #INC no : 39203 on  09/04/2013 
		hmRecord_ytd = fetchRecord("SELECT SUM (CASE WHEN curr_proc_month = move_month THEN grn_qty ELSE 0 END) mtd_rec_qty, SUM (CASE WHEN curr_proc_month = move_month AND curr_proc_year = move_year THEN   NVL (ABS (out_iss_qty_ns), 0) + NVL (ABS (out_iss_qty_st), 0) + NVL (ABS (out_urg_qty_ns), 0) + NVL (ABS (out_urg_qty_st), 0) ELSE 0 END ) mtd_iss_qty, SUM (CASE WHEN curr_proc_year = move_year THEN   NVL (ABS (out_iss_qty_ns), 0) + NVL (ABS (out_iss_qty_st), 0) + NVL (ABS (out_urg_qty_ns), 0) + NVL (ABS (out_urg_qty_st), 0) ELSE 0 END ) ytd_issue_qty   FROM (SELECT DISTINCT b.curr_proc_year curr_proc_year, move_year, b.curr_proc_month curr_proc_month, move_month, grn_qty, out_iss_qty_ns, out_iss_qty_st, out_urg_qty_ns, out_urg_qty_st FROM st_item_move_summ a, st_facility_param b, st_acc_entity_param c, st_user_access_for_store d WHERE b.facility_id LIKE ? AND a.item_code = ? AND a.move_year = b.curr_proc_year AND d.user_id LIKE DECODE (c.restrict_view_stk_status, 'ALL', '%', ? ) AND a.store_code = d.store_code)", alParameters1);
		/***==== CRF792 ====**/
		mtd_rec_qty				=		(String)hmRecord_ytd.get("MTD_REC_QTY");
		mtd_iss_qty				=		(String)hmRecord_ytd.get("MTD_ISS_QTY");
		ytd_issue_qty			=		(String)hmRecord_ytd.get("YTD_ISSUE_QTY");
		/*** CRF792 **/
		//item_specification		=		(String)hmRecord_sp.get("ITEM_SPECIFICATION");
		item_specification		=		(String)hmRecord.get("ITEM_SPECIFICATION");
		/***==== CRF792 ====**/
		stock_qty				=		(String)hmRecord.get("QTY_ON_HAND");
		reorder_level			=		(String)hmRecord.get("REORDER_LEVEL");
		class_desc				=		(String)hmRecord.get("ITEM_CLASS_DESC");
		pack_size				=		(String)hmRecord.get("CURR_PACK_SIZE");
		reorder_store			=		(String)hmRecord.get("QTY_REORDER_STORE");
		//last_issue_store_desc =		(String)hmRecord.get("LAST_ISSUE_STORE_DESC");
		last_issue_date			=		checkForNull((String)hmRecord.get("LAST_ISSUE_DATE"));
		alParameters1		=		new ArrayList();
		alParameters1.add(login_facility_id);
		alParameters1.add(this.item_code);
		alParameters1.add(getLoginById());
		alParameters1.add(login_facility_id);
		alParameters1.add(this.item_code);
		/*** CRF792 **/
		alParameters1.add(getLoginById());
		//hmRecord_ytd			=		fetchRecord("SELECT (SELECT ABS(SUM(SRT_QTY_NS+SRT_QTY+SAL_QTY+SAL_QTY_NS))  FROM ST_ITEM_MOVE_SUMM WHERE FACILITY_ID = ? AND ITEM_CODE = ?  AND MOVE_YEAR = SUBSTR (ST_GET_POST_MTH_YR (TO_CHAR (TO_DATE (SYSDATE, 'DD/MM/YYYY'))),3,4) AND MOVE_MONTH  = SUBSTR (ST_GET_POST_MTH_YR (TO_CHAR (TO_DATE (SYSDATE, 'DD/MM/YYYY'))),1,2)) MTD_CONS_QTY,(SELECT ABS(SUM(SRT_QTY_NS+SRT_QTY+SAL_QTY+SAL_QTY_NS))  FROM ST_ITEM_MOVE_SUMM WHERE FACILITY_ID = ? AND ITEM_CODE = ?  AND MOVE_YEAR = SUBSTR (ST_GET_POST_MTH_YR (TO_CHAR (TO_DATE (SYSDATE, 'DD/MM/YYYY'))),3,4)) YTD_CONS_QTY FROM DUAL", alParameters1);
 		//hmRecord_ytd = fetchRecord("SELECT (SELECT ABS (SUM (srt_qty_ns + srt_qty + sal_qty + sal_qty_ns) ) FROM (SELECT DISTINCT a.store_code, item_code, move_year, move_month, a.srt_qty_ns srt_qty_ns, a.srt_qty srt_qty, a.sal_qty sal_qty, a.sal_qty_ns sal_qty_ns FROM st_item_move_summ a, st_acc_entity_param b, st_user_access_for_store c WHERE facility_id = ? AND item_code = ? AND move_year = SUBSTR (st_get_post_mth_yr (TO_CHAR (TO_DATE (SYSDATE, 'DD/MM/YYYY' ) ) ), 3, 4 ) AND move_month = SUBSTR (st_get_post_mth_yr (TO_CHAR (TO_DATE (SYSDATE, 'DD/MM/YYYY' ) ) ), 1, 2 ) AND a.store_code = c.store_code AND c.user_id LIKE DECODE (b.restrict_view_stk_status, 'ALL', '%', ? ))) mtd_cons_qty, (SELECT ABS (SUM (srt_qty_ns + srt_qty + sal_qty + sal_qty_ns) ) FROM (SELECT DISTINCT a.store_code, item_code, move_year, move_month, a.srt_qty_ns srt_qty_ns, a.srt_qty srt_qty, a.sal_qty sal_qty, a.sal_qty_ns sal_qty_ns FROM st_item_move_summ a, st_acc_entity_param b, st_user_access_for_store c WHERE facility_id = ? AND item_code = ? AND move_year = SUBSTR (st_get_post_mth_yr (TO_CHAR (TO_DATE (SYSDATE, 'DD/MM/YYYY' ) ) ), 3, 4 ) AND a.store_code = c.store_code AND c.user_id LIKE DECODE (b.restrict_view_stk_status, 'ALL', '%', ? ))) ytd_cons_qty   FROM DUAL",alParameters1);
		
		//Added by Rabbani #INC no : 39203 on  09/04/2013 
 		hmRecord_ytd = fetchRecord("SELECT (SELECT ABS (SUM (srt_qty_ns + srt_qty + sal_qty + sal_qty_ns) ) FROM (SELECT DISTINCT a.store_code, item_code, move_year, move_month, a.srt_qty_ns srt_qty_ns, a.srt_qty srt_qty, a.sal_qty sal_qty, a.sal_qty_ns sal_qty_ns FROM st_item_move_summ a, st_acc_entity_param b, st_user_access_for_store c WHERE facility_id LIKE ? AND item_code = ? AND move_year = SUBSTR (st_get_post_mth_yr (TO_CHAR (TO_DATE (SYSDATE, 'DD/MM/YYYY' ) ) ), 3, 4 ) AND move_month = SUBSTR (st_get_post_mth_yr (TO_CHAR (TO_DATE (SYSDATE, 'DD/MM/YYYY' ) ) ), 1, 2 ) AND a.store_code = c.store_code AND c.user_id LIKE DECODE (b.restrict_view_stk_status, 'ALL', '%', ? ))) mtd_cons_qty, (SELECT ABS (SUM (srt_qty_ns + srt_qty + sal_qty + sal_qty_ns) ) FROM (SELECT DISTINCT a.store_code, item_code, move_year, move_month, a.srt_qty_ns srt_qty_ns, a.srt_qty srt_qty, a.sal_qty sal_qty, a.sal_qty_ns sal_qty_ns FROM st_item_move_summ a, st_acc_entity_param b, st_user_access_for_store c WHERE facility_id LIKE ? AND item_code = ? AND move_year = SUBSTR (st_get_post_mth_yr (TO_CHAR (TO_DATE (SYSDATE, 'DD/MM/YYYY' ) ) ), 3, 4 ) AND a.store_code = c.store_code AND c.user_id LIKE DECODE (b.restrict_view_stk_status, 'ALL', '%', ? ))) ytd_cons_qty   FROM DUAL",alParameters1);
		/***==== CRF792 ====**/
		ytd_cons_qty			=		(String)hmRecord_ytd.get("YTD_CONS_QTY");
		mtd_cons_qty			=		(String)hmRecord_ytd.get("MTD_CONS_QTY");
		if(last_issue_date.equals("01/01/1800"))
		{
			last_issue_date		=		null;
		}
		
		sole_source				=		(String)hmRecord.get("SOLE_SOURCE");
		special_item			=		(String)hmRecord.get("SPECIAL_ITEM");
		anal3_desc				=		(String)hmRecord.get("ANAL3_DESC");
		item_remarks			=		(String)hmRecord.get("ITEM_REMARKS");
		manufacturer_name		=		(String)hmRecord.get("MANUFACTURER_NAME");
		anal1_desc				=		(String)hmRecord.get("ANAL1_DESC");
		autoclaveable			=		(String)hmRecord.get("AUTOCLAVEABLE");
		anal2_desc				=		(String)hmRecord.get("ANAL2_DESC");
		qty_primary_store		=		(String)hmRecord.get("QTY_PRIMARY_STORE");
		
		}
		catch(Exception e) {
				e.printStackTrace();
			}
		}
	public void clear()
	{
	this.item_code			=	"";
	this.stock_qty			=	"";
	this.reorder_level		=	"";
	this.class_desc			=	"";
	this.pack_size			=	"";
	this.sole_source		=	"";
	this.special_item		=	"";
	this.anal3_desc			=	"";
	this.item_remarks		=	"";
	this.manufacturer_name	=	"";
	this.anal1_desc			=	"";
	this.autoclaveable		=	"";
	this.anal2_desc			=	"";
	this.qty_primary_store	=	"";
	this.bin_location		=	"";
	this.store_code			=	"";
	this.item_specification	=	"";
	this.mtd_rec_qty		=	"";
	this.mtd_iss_qty		=	"";
	this.ytd_issue_qty		=	"";
	this.ytd_cons_qty		=	"";
	this.mtd_cons_qty		=	"";
	}
	public double getRound(double number){
		number				=		number*100;
		long l				=		(long)number;
		return	((double)l)/100;
	}
/*Method moved to Adapter class as this is used commonly in more than 8 functions Mahesh 14/12/2009*/
/*	public String getAccessCostDetails(){
		String cost_yn			  = "N";	
		HashMap view_cost_yn	  = new HashMap();
		try{
			view_cost_yn = fetchRecord(getStRepositoryValue("ST_SQL_VIEW_COST_YN_SELECT"),getLoginById());
		}catch(Exception e){
			cost_yn = "";
		}
		if(view_cost_yn.size() > 0){
			//Check For Null is added on 14/12/2009 By Mahesh
			cost_yn = checkForNull((String)view_cost_yn.get("VIEW_COST_YN"),"N");
		}
		return cost_yn;
	}
*/
//Added by Rabbani #Inc no :39203 on  18-APR-2013
public ArrayList getFacility_names(){
	
	 ArrayList array = new ArrayList();
	 ArrayList alFacilitydata = new ArrayList();
		try{
		
		array.add(getLanguageId());
		array.add(getLoginById());
		System.out.println("array==>" +array);
	    alFacilitydata = fetchRecords("SELECT a.FACILITY_ID,FACILITY_NAME FROM SM_FACILITY_PARAM_LANG_VW a,st_facility_param b ,SM_FACILITY_FOR_USER c WHERE A.facility_id = B.facility_id AND LANGUAGE_ID = ?  and a.FACILITY_ID = c.FACILITY_ID AND c.appl_user_id = ? ORDER BY 2",array);
		}catch(Exception e) {
		  e.printStackTrace();
		}
		return alFacilitydata;
	}
	
}
