<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date       		Edit History      	Name       	Rev.Date   		Rev.By    	Description
--------------------------------------------------------------------------------------------------------------
05/05/2016		IN0059478			B.Badmavathi					ML-MMOH-SCF-0355
20/7/2021		TFS21623			Shazana							ST-MOHE-CRF-0084.1-US010/01 - Stock Status by Store
---------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="eST.*, eST.Common.* , eCommon.Common.*,java.util.*,webbeans.eCommon.*,java.text.NumberFormat,java.text.DecimalFormat,java.sql.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<html>
	<head>
		<title></title>
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
		request.setCharacterEncoding("UTF-8");
		String locale			=	(String)session.getAttribute("LOCALE");
		String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eCommon/js/rowcolor.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
	<!--<script language="javascript" src="../../eCommon/js/messages.js"></script> -->
		<script language="Javascript" src="../../eST/js/StCommon.js"></script>
	<!--<script language="javascript" src="../../eST/js/StMessages.js"></script> -->
		<script language="Javascript" src="../../eST/js/StockStatusByStore.js"> </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body>
<form name="formStockStatusByStoreResult" id="formStockStatusByStoreResult">
<%
	String bean_id					=		"StockStatusByStoreBean";
	String bean_name				=		"eST.StockStatusByStoreBean";
	StockStatusByStoreBean bean		=		(StockStatusByStoreBean) getBeanObject(bean_id,  bean_name, request );  
	bean.setLanguageId(locale);
	bean.clear();
	String item_code_img ="display:none";
	String item_desc_img ="display:none";
	String qoh_img ="display:none";
	String base_uom_qoh_img ="display:none";
	String item_value_img ="display:none";
	String s1 ="../../eST/images/Ascending.gif";
	String s2 ="../../eST/images/Descending.gif";
	String sort_order = request.getParameter("sort_order");
	//String user_id = (String) session.getValue( "login_user");
	String item_code				=		request.getParameter( "item_code" )==null?"":request.getParameter( "item_code" ) ;
	String store_code_from				=		request.getParameter( "store_code_from")==null?"":request.getParameter( "store_code_from") ;
	String store_code_to				=		request.getParameter( "store_code_to")==null?"":request.getParameter( "store_code_to") ;
	String item_desc				=		request.getParameter( "item_desc" )==null?"":request.getParameter( "item_desc" ) ;
	//String store_desc				=		request.getParameter( "store_desc")==null?"":request.getParameter( "store_desc") ;
	String stock_level				=		request.getParameter( "stock_level")==null?"":request.getParameter( "stock_level" ) ;
	String fm_item_class			=		request.getParameter( "fm_item_class")==null?"":request.getParameter( "fm_item_class" ) ;
	String to_item_class			=		request.getParameter( "to_item_class")==null?"":request.getParameter( "to_item_class" ) ;
	String fm_anal1					=		request.getParameter( "fm_anal1")==null?"":request.getParameter( "fm_anal1" ) ;
	String to_anal1					=		request.getParameter( "to_anal1")==null?"":request.getParameter( "to_anal1" ) ;
	String fm_anal2					=		request.getParameter( "fm_anal2")==null?"":request.getParameter( "fm_anal2" ) ;
	String to_anal2					=		request.getParameter( "to_anal2")==null?"":request.getParameter( "to_anal2" ) ;
	String fm_anal3					=		request.getParameter( "fm_anal3")==null?"":request.getParameter( "fm_anal3" ) ;
	String to_anal3					=		request.getParameter( "to_anal3")==null?"":request.getParameter( "to_anal3" ) ;
	String stock_item				=		request.getParameter( "stock_item" ).trim( )==null?"":request.getParameter( "stock_item" ) ;
	String classvalue				=		"";
	boolean searched				=		(request.getParameter("searched") == null) ?false:true;
	DecimalFormat dfTest1 = new DecimalFormat("###,###.00");
	//Connection con=null; //21623  // MOHE-ICN-0015
	boolean restrict_stores_user_access_yn =false;
	String strFacilityParam			= "";
	String restrictInReportYN		= "";//end
	String accessCostDetails		= bean.checkForNull(bean.getAccessCostDetails(),"N"); //MOHE-ICN-0015
	//System.err.println("===accessCostDetails"+accessCostDetails);
	//String ACC_ENTITY_ID				=		(String)session.getAttribute("ACC_ENTITY_ID");
	
	
	// Added By Rams 12/15/2009 For the Decimal CRF 537.1 Begins
	/* @Name - Rams
 * @Date - 12/15/2009
 * @Inc# - CRF 537.1
 * @Desc - For the Decimal related display
 */
	 /** @Name - Priya
	* @Date - 01/02/2010
	* @Inc# - 15496 (SRR20056-CRF-0537.2)
	* @Desc - To use common method, the previous coding has been removed
	*/
int no_of_decimals=bean.getNoOfDecimals(); 
	//END
/**
		 * @Name - Priya
		 * @Date - 07/06/2010
		 * @Inc# - 
		 * @Desc -  To get no of decimals for cost 
		 */
		 int noOfDecimalsForCost=Integer.parseInt(bean.getNoOfDecimalsCost());

	try{
		//con						= ConnectionManager.getConnection(request);//21623 start//MOHE-ICN-0015
		restrict_stores_user_access_yn = bean.getRestrictUserAccessStores(); //eCommon.Common.CommonBean.isSiteSpecific(con, "ST","ST_RESTRICT_USER_ACCESS_STORES"); //MOHE-ICN-0015
		strFacilityParam = bean.getRestrictUserAccessStore();
		if(strFacilityParam== null || strFacilityParam.equals(""))
			strFacilityParam = "N"; 
		if(restrict_stores_user_access_yn){
			if(strFacilityParam.equals("Y")){
				restrictInReportYN = "Y";
			}else{
				restrictInReportYN = "N"; 
			}
		}//END 
		
		CommonBean.setLoginFacilityId((String) session.getValue("facility_id"));
		store_code_from					=		CommonBean.checkForNull(store_code_from);
		store_code_to					=		CommonBean.checkForNull(store_code_to);
		item_code					=		CommonBean.checkForNull(item_code);
		//store_desc					=		CommonBean.checkForNull(store_desc)+"%";
		item_desc					=		CommonBean.checkForNull(item_desc,"%")+"%";
		stock_item					=		CommonBean.checkForNull(stock_item,"%");
		
		HashMap sqlMap				=		new HashMap();
		HashMap funcMap				=		new HashMap();
		ArrayList displayFields		=		new ArrayList();
		ArrayList chkFields			=		new ArrayList();
		String curr_item_store		=		"";
		String prev_item_store		=		"";
		//sqlMap.put("sqlData", eST.Common.StRepository.getStKeyValue("SQL_ST_STOCK_STATUS_BY_STORE"));
		
			//String sql ="SELECT   A.STORE_CODE, B.SHORT_DESC STORE_DESC, A.ITEM_CODE ITEM_CODE,         C.SHORT_DESC ITEM_DESC, A.STOCK_ITEM_YN, NVL (A.QTY_ON_HAND, 0) QTY_ON_HAND, C.GEN_UOM_CODE,         D.SHORT_DESC UOM_DESC,A.DEF_ISSUE_UOM,F.SHORT_DESC ISSUE_UOM, ROUND ((  NVL ((ROUND (A.ITEM_VALUE, 3)), 0)/ DECODE (NVL (A.QTY_ON_HAND, 0), 0, 1, A.QTY_ON_HAND)),3) UNIT_COST, ITEM_VALUE,         F.SHORT_DESC STOCK_UOM_DESC,(SUM (NVL (STB.QTY_ON_HAND, 0) - NVL (STB.COMMITTED_QTY, 0))) AVAIL_QTY,	NVL(NVL (A.QTY_ON_HAND, 0)*  NVL (DECODE(              (SELECT EQVL_VALUE FROM MM_ITEM_UOM_DEFN WHERE ITEM_CODE = A.ITEM_CODE AND EQVL_UOM_CODE = A.DEF_ISSUE_UOM AND UOM_CODE = C.GEN_UOM_CODE),NULL,(SELECT EQVL_VALUE FROM AM_UOM_EQVL WHERE EQVL_UOM_CODE = A.DEF_ISSUE_UOM AND UOM_CODE = C.GEN_UOM_CODE),(SELECT EQVL_VALUE FROM MM_ITEM_UOM_DEFN  WHERE ITEM_CODE = A.ITEM_CODE AND EQVL_UOM_CODE = A.DEF_ISSUE_UOM               AND UOM_CODE = C.GEN_UOM_CODE)),1),0) BASE_UOM_QOH,  ROUND(NVL (  (SUM (  NVL (STB.QTY_ON_HAND, 0)- NVL (STB.COMMITTED_QTY, 0)))/ NVL ( DECODE((SELECT EQVL_VALUE FROM MM_ITEM_UOM_DEFN WHERE ITEM_CODE = A.ITEM_CODE AND EQVL_UOM_CODE = A.DEF_ISSUE_UOM  AND UOM_CODE = C.GEN_UOM_CODE),NULL, ( SELECT EQVL_VALUE FROM AM_UOM_EQVL WHERE EQVL_UOM_CODE = A.DEF_ISSUE_UOM AND UOM_CODE = C.GEN_UOM_CODE ), (SELECT EQVL_VALUE FROM MM_ITEM_UOM_DEFN WHERE ITEM_CODE = A.ITEM_CODE         AND EQVL_UOM_CODE = A.DEF_ISSUE_UOM AND UOM_CODE = C.GEN_UOM_CODE)),1), 0),2) ISSUE_UOM_AVL, A.REORDER_LEVEL REORDER_LEVEL FROM ST_ITEM_STORE A, MM_STORE_LANG_VW B, MM_ITEM_LANG_VW C, AM_UOM_LANG_VW D, AM_UOM_LANG_VW F, ST_STORE E, ST_ITEM_BATCH STB   WHERE A.STORE_CODE = B.STORE_CODE AND A.ITEM_CODE = C.ITEM_CODE  AND C.GEN_UOM_CODE = D.UOM_CODE     AND A.DEF_ISSUE_UOM = F.UOM_CODE  AND F.LANGUAGE_ID = D.LANGUAGE_ID AND A.STORE_CODE BETWEEN  ?  AND ? AND A.STORE_CODE IN (SELECT STORE_CODE FROM ST_USER_ACCESS_FOR_STORE WHERE  USER_ID = ?)  AND A.ITEM_CODE = NVL (?, A.ITEM_CODE) AND UPPER (C.SHORT_DESC) LIKE UPPER (?) AND (   (NVL (A.QTY_ON_HAND, 0) >= 0 AND 'A' =?) OR (NVL (A.QTY_ON_HAND, 0) > 0 AND 'S' = ?)  OR (NVL (A.QTY_ON_HAND, 0) = 0 AND 'Z' = ?) OR (NVL (A.QTY_ON_HAND, 0) < NVL (REORDER_LEVEL, 0) AND 'B' = ?))     AND (A.STOCK_ITEM_YN LIKE UPPER (?)) AND B.EFF_STATUS = 'E'  AND E.STORE_CODE = B.STORE_CODE AND E.STORE_TYPE_FLAG != 'N' AND B.LANGUAGE_ID = C.LANGUAGE_ID AND B.LANGUAGE_ID = D.LANGUAGE_ID AND B.LANGUAGE_ID =?     AND NVL (C.ITEM_CLASS_CODE, 'X') BETWEEN NVL (?, NVL (C.ITEM_CLASS_CODE,'X')) AND NVL (?, NVL(C.ITEM_CLASS_CODE,'X')) AND NVL (C.ITEM_ANAL1_CODE, 'X') BETWEEN NVL (?, NVL(C.ITEM_ANAL1_CODE, 'X')) AND NVL (?, NVL (C.ITEM_ANAL1_CODE,'X')) AND NVL (C.ITEM_ANAL2_CODE, 'X') BETWEEN NVL (?, NVL (C.ITEM_ANAL2_CODE,'X')) AND NVL (?, NVL (C.ITEM_ANAL2_CODE,'X')) AND NVL (C.ITEM_ANAL3_CODE, 'X') BETWEEN NVL (?, NVL (C.ITEM_ANAL3_CODE,'X')) AND NVL (?, NVL (C.ITEM_ANAL3_CODE,'X')) AND FACILITY_ID =? AND A.STORE_CODE = STB.STORE_CODE(+) AND A.ITEM_CODE = STB.ITEM_CODE(+)GROUP BY A.STORE_CODE, B.SHORT_DESC, A.ITEM_CODE, C.SHORT_DESC, A.STOCK_ITEM_YN, A.QTY_ON_HAND, C.GEN_UOM_CODE, D.SHORT_DESC, A.ITEM_VALUE, A.QTY_ON_HAND, A.DEF_ISSUE_UOM,  C.GEN_UOM_CODE, D.SHORT_DESC, F.SHORT_DESC, A.REORDER_LEVEL";

			//String sql ="SELECT   store_code, store_desc, itm_code, item_desc, stock_item_yn, qty_on_hand, gen_uom_code, uom_desc, def_issue_uom, issue_uom, unit_cost, item_value, stock_uom_desc, (SUM (NVL (bt_qty_on_hand, 0) - NVL (committed_qty, 0))) avail_qty, base_uom_qoh, ROUND (NVL (  (SUM (NVL (bt_qty_on_hand, 0) - NVL (committed_qty, 0))) / NVL (DECODE ((SELECT eqvl_value FROM mm_item_uom_defn WHERE item_code = itm_code AND eqvl_uom_code = def_issue_uom AND uom_code = gen_uom_code), NULL, (SELECT NVL (eqvl_value, 1) FROM am_uom_eqvl WHERE eqvl_uom_code = def_issue_uom AND uom_code = gen_uom_code), (SELECT eqvl_value FROM mm_item_uom_defn WHERE item_code = itm_code AND eqvl_uom_code = def_issue_uom AND uom_code = gen_uom_code) ), 1 ), 0 ), 4 ) issue_uom_avl, reorder_level FROM (SELECT DISTINCT stb.batch_id, a.store_code, b.short_desc store_desc, a.item_code itm_code, c.short_desc item_desc, a.stock_item_yn, NVL (a.qty_on_hand, 0) qty_on_hand, c.gen_uom_code gen_uom_code, d.short_desc uom_desc, a.def_issue_uom def_issue_uom, f.short_desc issue_uom, ROUND ((  NVL ((ROUND (a.item_value, 3)), 0) / DECODE (NVL (a.qty_on_hand, 0), 0, 1, a.qty_on_hand ) ), 3 ) unit_cost, item_value, f.short_desc stock_uom_desc, stb.qty_on_hand bt_qty_on_hand, stb.committed_qty committed_qty, NVL (  NVL (a.qty_on_hand, 0) * NVL (DECODE ((SELECT eqvl_value FROM mm_item_uom_defn WHERE item_code = a.item_code AND eqvl_uom_code = a.def_issue_uom AND uom_code = c.gen_uom_code), NULL, (SELECT NVL (eqvl_value, 1) FROM am_uom_eqvl WHERE eqvl_uom_code = a.def_issue_uom AND uom_code = c.gen_uom_code), (SELECT eqvl_value FROM mm_item_uom_defn WHERE item_code = a.item_code AND eqvl_uom_code = a.def_issue_uom AND uom_code = c.gen_uom_code) ), 1 ), 0 ) base_uom_qoh, a.reorder_level reorder_level FROM st_item_store a, mm_store_lang_vw b, mm_item_lang_vw c, am_uom_lang_vw d, am_uom_lang_vw f, st_store e, st_item_batch stb, st_acc_entity_param i, st_user_access_for_store j WHERE a.store_code = b.store_code AND a.item_code = c.item_code AND c.gen_uom_code = d.uom_code AND a.def_issue_uom = f.uom_code AND f.language_id = d.language_id AND a.store_code BETWEEN ? AND  ? AND a.item_code = NVL (?, a.item_code) AND UPPER (c.short_desc) LIKE UPPER (?) AND (   (NVL (a.qty_on_hand, 0) >= 0 AND 'A' = ?) OR (NVL (a.qty_on_hand, 0) > 0 AND 'S' = ?) OR (NVL (a.qty_on_hand, 0) = 0 AND 'Z' = ?) OR ( NVL (a.qty_on_hand, 0) < NVL (reorder_level, 0) AND 'B' = ? ) ) AND (a.stock_item_yn LIKE UPPER (?)) AND b.eff_status = 'E' AND e.store_code = b.store_code AND e.store_type_flag != 'N' AND b.language_id = c.language_id AND b.language_id = d.language_id AND b.language_id = ? AND NVL (c.item_class_code, 'X') BETWEEN NVL (?, NVL (c.item_class_code, 'X')) AND NVL (?, NVL (c.item_class_code, 'X')) AND NVL (c.item_anal1_code, 'X') BETWEEN NVL (?, NVL (c.item_anal1_code, 'X')) AND NVL (?, NVL (c.item_anal1_code, 'X')) AND NVL (c.item_anal2_code, 'X') BETWEEN NVL (?, NVL (c.item_anal2_code, 'X')) AND NVL (?, NVL (c.item_anal2_code, 'X')) AND NVL (c.item_anal3_code, 'X') BETWEEN NVL (?, NVL (c.item_anal3_code, 'X')) AND NVL (?, NVL (c.item_anal3_code, 'X')) AND facility_id = ? AND a.store_code = stb.store_code(+) AND a.item_code = stb.item_code(+) AND j.user_id LIKE DECODE (i.restrict_view_stk_status, 'ALL', '%', ? ) AND a.store_code = j.store_code) GROUP BY store_code, store_desc, itm_code, item_desc, stock_item_yn, qty_on_hand, gen_uom_code, item_value, def_issue_uom, gen_uom_code, uom_desc, stock_uom_desc, reorder_level, unit_cost, base_uom_qoh";


		   /**
			* @Name - Priya
			* @Date - 07/04/2010
			* @Inc# - 20541
			* @Inc#	- 20640
			* @Date - 12/04/2010
			* @Desc - The previous function 'ST_GET_UOM_CONV_FACTOR_TO'  was not working properly and so replaced with the new function 'ST_GET_UOM_CONV_FAC_SING_STR'
			*/


			//String sql ="SELECT   store_code, store_desc, itm_code, item_desc, stock_item_yn, qty_on_hand, gen_uom_code, uom_desc, def_issue_uom, issue_uom, unit_cost, item_value, stock_uom_desc, (SUM (NVL (bt_qty_on_hand, 0) - NVL (committed_qty, 0))) avail_qty, base_uom_qoh, ROUND (NVL (  (SUM (NVL (bt_qty_on_hand, 0) - NVL (committed_qty, 0))) / NVL ((SELECT ST_GET_UOM_CONV_FAC_SING_STR(itm_code,store_code) CON_FACTOR FROM DUAL), 1 ), 0 ), 4 ) issue_uom_avl, reorder_level FROM (SELECT DISTINCT stb.batch_id, a.store_code, b.short_desc store_desc, a.item_code itm_code, c.short_desc item_desc, a.stock_item_yn, NVL (a.qty_on_hand, 0) qty_on_hand, c.gen_uom_code gen_uom_code, d.short_desc uom_desc, a.def_issue_uom def_issue_uom, f.short_desc issue_uom, ROUND ((  NVL ((ROUND (a.item_value, 3)), 0) / DECODE (NVL (a.qty_on_hand, 0), 0, 1, a.qty_on_hand ) ), 3 ) unit_cost, item_value, f.short_desc stock_uom_desc, stb.qty_on_hand bt_qty_on_hand, stb.committed_qty committed_qty, NVL (  NVL (a.qty_on_hand, 0) * NVL ((SELECT ST_GET_UOM_CONV_FAC_SING_STR(a.item_code,a.store_code) CON_FACTOR FROM DUAL), 1 ), 0 ) base_uom_qoh, a.reorder_level reorder_level FROM st_item_store a, mm_store_lang_vw b, mm_item_lang_vw c, am_uom_lang_vw d, am_uom_lang_vw f, st_store e, st_item_batch stb, st_acc_entity_param i, st_user_access_for_store j WHERE a.store_code = b.store_code AND a.item_code = c.item_code AND c.gen_uom_code = d.uom_code AND a.def_issue_uom = f.uom_code AND f.language_id = d.language_id AND a.store_code BETWEEN ? AND  ? AND a.item_code = NVL (?, a.item_code) AND UPPER (c.short_desc) LIKE UPPER (?) AND (   (NVL (a.qty_on_hand, 0) >= 0 AND 'A' = ?) OR (NVL (a.qty_on_hand, 0) > 0 AND 'S' = ?) OR (NVL (a.qty_on_hand, 0) = 0 AND 'Z' = ?) OR ( NVL (a.qty_on_hand, 0) < NVL (reorder_level, 0) AND 'B' = ? ) ) AND (a.stock_item_yn LIKE UPPER (?)) AND b.eff_status = 'E' AND e.store_code = b.store_code AND e.store_type_flag != 'N' AND b.language_id = c.language_id AND b.language_id = d.language_id AND b.language_id = ? AND NVL (c.item_class_code, 'X') BETWEEN NVL (?, NVL (c.item_class_code, 'X')) AND NVL (?, NVL (c.item_class_code, 'X')) AND NVL (c.item_anal1_code, 'X') BETWEEN NVL (?, NVL (c.item_anal1_code, 'X')) AND NVL (?, NVL (c.item_anal1_code, 'X')) AND NVL (c.item_anal2_code, 'X') BETWEEN NVL (?, NVL (c.item_anal2_code, 'X')) AND NVL (?, NVL (c.item_anal2_code, 'X')) AND NVL (c.item_anal3_code, 'X') BETWEEN NVL (?, NVL (c.item_anal3_code, 'X')) AND NVL (?, NVL (c.item_anal3_code, 'X')) AND facility_id = ? AND a.store_code = stb.store_code(+) AND a.item_code = stb.item_code(+) AND j.user_id LIKE DECODE (i.restrict_view_stk_status, 'ALL', '%', ? ) AND a.store_code = j.store_code) GROUP BY store_code, store_desc, itm_code, item_desc, stock_item_yn, qty_on_hand, gen_uom_code, item_value, def_issue_uom, gen_uom_code, uom_desc, stock_uom_desc, reorder_level, unit_cost, base_uom_qoh";
			//String sql ="SELECT   store_code, store_desc, itm_code, item_desc, stock_item_yn, qty_on_hand, gen_uom_code, uom_desc, def_issue_uom, issue_uom, unit_cost, item_value, stock_uom_desc, (SUM (NVL (bt_qty_on_hand, 0) - NVL (committed_qty, 0))) avail_qty, base_uom_qoh, ROUND (NVL (  (SUM (NVL (bt_qty_on_hand, 0) - NVL (committed_qty, 0))) / NVL ((SELECT ST_GET_UOM_CONV_FAC_SING_STR(itm_code,store_code) CON_FACTOR FROM DUAL), 1 ), 0 ), 4 ) issue_uom_avl, reorder_level FROM (SELECT DISTINCT stb.batch_id, a.store_code, b.short_desc store_desc, a.item_code itm_code, c.short_desc item_desc, a.stock_item_yn, NVL (a.qty_on_hand, 0) qty_on_hand, c.gen_uom_code gen_uom_code, d.short_desc uom_desc, a.def_issue_uom def_issue_uom, f.short_desc issue_uom, TRIM(ST_DISPLAY_COST_DECIMALS (a.ITEM_CODE, a.STORE_CODE )) unit_cost, item_value, f.short_desc stock_uom_desc, stb.qty_on_hand bt_qty_on_hand, stb.committed_qty committed_qty, NVL (  NVL (a.qty_on_hand, 0) * NVL ((SELECT ST_GET_UOM_CONV_FAC_SING_STR(a.item_code,a.store_code) CON_FACTOR FROM DUAL), 1 ), 0 ) base_uom_qoh, a.reorder_level reorder_level FROM st_item_store a, mm_store_lang_vw b, mm_item_lang_vw c, am_uom_lang_vw d, am_uom_lang_vw f, st_store e, st_item_batch stb, st_acc_entity_param i, st_user_access_for_store j,st_item k WHERE a.store_code = b.store_code AND a.item_code = c.item_code AND c.gen_uom_code = d.uom_code AND a.def_issue_uom = f.uom_code AND f.language_id = d.language_id AND a.store_code BETWEEN ? AND  ? AND a.item_code = NVL (?, a.item_code) AND UPPER (c.short_desc) LIKE UPPER (?) AND (   (NVL (a.qty_on_hand, 0) >= 0 AND 'A' = ?) OR (NVL (a.qty_on_hand, 0) > 0 AND 'S' = ?) OR (NVL (a.qty_on_hand, 0) = 0 AND 'Z' = ?) OR ( NVL (a.qty_on_hand, 0) < NVL (a.reorder_level, 0) AND 'B' = ? ) ) AND (a.stock_item_yn LIKE UPPER (?)) AND b.eff_status = 'E' AND e.store_code = b.store_code AND e.store_type_flag != 'N' AND b.language_id = c.language_id AND b.language_id = d.language_id AND b.language_id = ? AND NVL (c.item_class_code, 'X') BETWEEN NVL (?, NVL (c.item_class_code, 'X')) AND NVL (?, NVL (c.item_class_code, 'X')) AND NVL (c.item_anal1_code, 'X') BETWEEN NVL (?, NVL (c.item_anal1_code, 'X')) AND NVL (?, NVL (c.item_anal1_code, 'X')) AND NVL (c.item_anal2_code, 'X') BETWEEN NVL (?, NVL (c.item_anal2_code, 'X')) AND NVL (?, NVL (c.item_anal2_code, 'X')) AND NVL (c.item_anal3_code, 'X') BETWEEN NVL (?, NVL (c.item_anal3_code, 'X')) AND NVL (?, NVL (c.item_anal3_code, 'X')) AND facility_id = ? AND a.store_code = stb.store_code(+) AND a.item_code = stb.item_code(+) AND j.user_id LIKE DECODE (i.restrict_view_stk_status, 'ALL', '%', ? ) AND a.store_code = j.store_code AND k.item_code = a.item_code AND (   expiry_yn = 'N'    OR (    expiry_yn = 'Y' AND (   (    use_after_expiry_yn = 'Y' AND ('Y' = 'Y') ) OR expiry_date_or_receipt_date >= TRUNC (NVL (TO_DATE ('', 'dd/mm/yyyy'), SYSDATE ) ) ))) ) GROUP BY store_code, store_desc, itm_code, item_desc, stock_item_yn, qty_on_hand, gen_uom_code, item_value, def_issue_uom, gen_uom_code, uom_desc, stock_uom_desc, reorder_level, unit_cost, base_uom_qoh";
			
			
		//String sql="SELECT DISTINCT x.store_code, store_desc, itm_code, item_desc, stock_item_yn,qty_on_hand, gen_uom_code, uom_desc, def_issue_uom, issue_uom,unit_cost, item_value, avail_qty, base_uom_qoh, issue_uom_avl, reorder_level FROM (SELECT   store_code, store_desc,  itm_code, item_desc, stock_item_yn, qty_on_hand, gen_uom_code, uom_desc, def_issue_uom, issue_uom, unit_cost, item_value, (SUM (  NVL (bt_qty_on_hand, 0) - NVL (committed_qty, 0) ) ) avail_qty, base_uom_qoh,ROUND (NVL(  (SUM (  NVL (bt_qty_on_hand, 0) - NVL (committed_qty, 0) ) ) / NVL ((st_get_uom_conv_fac_sing_str (itm_code, store_code ) ), 1 ),0 ), 4 ) issue_uom_avl, reorder_level FROM (SELECT DISTINCT stb.batch_id, a.store_code, b.short_desc store_desc, a.item_code itm_code, c.short_desc item_desc, a.stock_item_yn,NVL (a.qty_on_hand, 0) qty_on_hand, c.gen_uom_code gen_uom_code, (SELECT short_desc FROM am_uom_lang_vw WHERE uom_code = c.gen_uom_code AND language_id = ?) uom_desc, a.def_issue_uom def_issue_uom, TRIM (st_display_cost_decimals (a.item_code, a.store_code ) ) unit_cost, item_value, (SELECT short_desc FROM am_uom_lang_vw WHERE uom_code = a.def_issue_uom AND language_id = ?) issue_uom, stb.qty_on_hand bt_qty_on_hand, stb.committed_qty committed_qty, NVL (  NVL (a.qty_on_hand, 0) * NVL ((st_get_uom_conv_fac_sing_str (a.item_code, a.store_code ) ), 1 ), 0 ) base_uom_qoh, a.reorder_level reorder_level FROM st_item_store a, mm_store_lang_vw b, mm_item_lang_vw c, st_store e, st_item_batch stb, st_item k WHERE a.store_code = b.store_code AND a.item_code = c.item_code AND a.store_code BETWEEN ? AND ? AND a.item_code = NVL (?, a.item_code) AND UPPER (c.short_desc) LIKE UPPER (?) AND (   (    NVL (a.qty_on_hand, 0) >= 0 AND 'A' = ? ) OR (    NVL (a.qty_on_hand, 0) > 0 AND 'S' = ? ) OR (    NVL (a.qty_on_hand, 0) = 0 AND 'Z' = ? ) OR (    NVL (a.qty_on_hand, 0) < NVL (a.reorder_level, 0)AND 'B' = ? ) ) AND (a.stock_item_yn LIKE (?)) AND b.eff_status = 'E' AND e.store_code = b.store_code AND e.store_type_flag != 'N' AND b.language_id = c.language_id AND b.language_id = ? AND c.item_class_code BETWEEN NVL (?,'!') AND NVL (?,'~') AND NVL (c.item_anal1_code, 'X') BETWEEN NVL(?,NVL(c.item_anal1_code,'X')) AND NVL(?,NVL(c.item_anal1_code,'X')) AND NVL (c.item_anal2_code, 'X') BETWEEN NVL (?,NVL (c.item_anal2_code,'X')) AND NVL (?,NVL (c.item_anal2_code,'X')) AND NVL (c.item_anal3_code, 'X') BETWEEN NVL(?,NVL (c.item_anal3_code,'X')) AND NVL(?,NVL (c.item_anal3_code,'X')) AND facility_id = ? AND a.store_code = stb.store_code(+) AND a.item_code = stb.item_code(+) AND k.item_code = a.item_code AND (   expiry_yn = 'N' OR (    expiry_yn = 'Y' AND (   (  /*  use_after_expiry_yn = 'Y' AND */('Y' = 'Y') ) OR decode(a.qty_on_hand, 0, sysdate,expiry_date_or_receipt_date) >= TRUNC (NVL (TO_DATE ('','dd/mm/yyyy'), SYSDATE )) )) )) GROUP BY store_code, store_desc, itm_code, item_desc, stock_item_yn, qty_on_hand, gen_uom_code, item_value, def_issue_uom, gen_uom_code, uom_desc, issue_uom, reorder_level, unit_cost, base_uom_qoh) x, st_acc_entity_param i, st_user_access_for_store j WHERE j.user_id LIKE (CASE WHEN i.restrict_view_stk_status = 'ALL' THEN '%' WHEN i.restrict_view_stk_status = 'UAS' THEN ? END ) AND x.store_code = j.store_code ";
		//this query is added dynamically for KAUH issue by Ganga Monday, September 03, 2012

		chkFields.add( locale);
		chkFields.add( locale);
		chkFields.add( locale); //Added by Rabbani #Inc no :39203 on  23-APR-2013
		chkFields.add( store_code_from);
		chkFields.add( store_code_to);
       	chkFields.add( item_code);


		//Commented by Rabbani #Inc no :39203 on  23-APR-2013
		//String sql="SELECT DISTINCT x.store_code, store_desc, itm_code, item_desc, stock_item_yn,qty_on_hand, gen_uom_code, uom_desc, def_issue_uom, issue_uom,unit_cost, item_value, avail_qty, base_uom_qoh, issue_uom_avl, reorder_level FROM (SELECT   store_code, store_desc,  itm_code, item_desc, stock_item_yn, qty_on_hand, gen_uom_code, uom_desc, def_issue_uom, issue_uom, unit_cost, item_value, (SUM (  NVL (bt_qty_on_hand, 0) - NVL (committed_qty, 0) ) ) avail_qty, base_uom_qoh,ROUND (NVL(  (SUM (  NVL (bt_qty_on_hand, 0) - NVL (committed_qty, 0) ) ) / NVL ((st_get_uom_conv_fac_sing_str (itm_code, store_code ) ), 1 ),0 ), 4 ) issue_uom_avl, reorder_level FROM (SELECT   a.store_code, b.short_desc store_desc, a.item_code itm_code, c.short_desc item_desc, a.stock_item_yn,NVL (a.qty_on_hand, 0) qty_on_hand, c.gen_uom_code gen_uom_code, (SELECT short_desc FROM am_uom_lang_vw WHERE uom_code = c.gen_uom_code AND language_id = ?) uom_desc, a.def_issue_uom def_issue_uom, TRIM (st_display_cost_decimals (a.item_code, a.store_code ) ) unit_cost, item_value, (SELECT short_desc FROM am_uom_lang_vw WHERE uom_code = a.def_issue_uom AND language_id = ?) issue_uom, stb.qty_on_hand bt_qty_on_hand, stb.committed_qty committed_qty, NVL (  NVL (a.qty_on_hand, 0) * NVL ((st_get_uom_conv_fac_sing_str (a.item_code, a.store_code ) ), 1 ), 0 ) base_uom_qoh, a.reorder_level reorder_level FROM st_item_store a, mm_store_lang_vw b, mm_item_lang_vw c, st_store e, st_item_batch stb, st_item k WHERE a.store_code = b.store_code AND a.item_code = c.item_code AND a.store_code BETWEEN ? AND ? AND a.item_code = NVL (?, a.item_code) ";
		
		//Added by Rabbani #Inc no :39203 on  23-APR-2013
		//String sql="SELECT DISTINCT x.store_code, store_desc, itm_code, item_desc, stock_item_yn,qty_on_hand, gen_uom_code, uom_desc, def_issue_uom, issue_uom,unit_cost, item_value, avail_qty, base_uom_qoh, issue_uom_avl, reorder_level,facility_id, facility_name FROM (SELECT   store_code, store_desc,  itm_code, item_desc, stock_item_yn, qty_on_hand, gen_uom_code, uom_desc, def_issue_uom, issue_uom, unit_cost, item_value, (SUM (  NVL (bt_qty_on_hand, 0) - NVL (committed_qty, 0) ) ) avail_qty, base_uom_qoh,ROUND (NVL(  (SUM (  NVL (bt_qty_on_hand, 0) - NVL (committed_qty, 0) ) ) / NVL ((st_get_uom_conv_fac_sing_str (itm_code, store_code ) ), 1 ),0 ), 4 ) issue_uom_avl, reorder_level,facility_id, facility_name FROM (SELECT   a.store_code, b.short_desc store_desc, a.item_code itm_code, c.short_desc item_desc, a.stock_item_yn,NVL (a.qty_on_hand, 0) qty_on_hand, c.gen_uom_code gen_uom_code, (SELECT short_desc FROM am_uom_lang_vw WHERE uom_code = c.gen_uom_code AND language_id = ?) uom_desc, a.def_issue_uom def_issue_uom, TRIM (st_display_cost_decimals (a.item_code, a.store_code ) ) unit_cost, item_value, (SELECT short_desc FROM am_uom_lang_vw WHERE uom_code = a.def_issue_uom AND language_id = ?) issue_uom, stb.qty_on_hand bt_qty_on_hand, stb.committed_qty committed_qty, NVL (  NVL (a.qty_on_hand, 0) * NVL ((st_get_uom_conv_fac_sing_str (a.item_code, a.store_code ) ), 1 ), 0 ) base_uom_qoh, a.reorder_level reorder_level,b.facility_id facility_id, (SELECT facility_name FROM sm_facility_param_lang_vw vw WHERE  vw.facility_id = b.facility_id AND language_id = ?) facility_name FROM st_item_store a, mm_store_lang_vw b, mm_item_lang_vw c, st_store e, st_item_batch stb, st_item k WHERE a.store_code = b.store_code AND a.item_code = c.item_code AND a.store_code BETWEEN ? AND ? AND a.item_code = NVL (?, a.item_code) ";
		
		//Added by Sakti against TTM-SCF-0106 to get (base uom unit_cost*qty)item_value_new,base_unit_cost
		//String sql="SELECT DISTINCT x.store_code, store_desc, itm_code, item_desc, stock_item_yn,qty_on_hand, gen_uom_code, uom_desc, def_issue_uom, issue_uom,unit_cost, item_value, avail_qty, base_uom_qoh, issue_uom_avl, reorder_level,facility_id, facility_name,base_unit_cost,item_value_new FROM (SELECT   store_code, store_desc,  itm_code, item_desc, stock_item_yn, qty_on_hand, gen_uom_code, uom_desc, def_issue_uom, issue_uom, unit_cost,base_unit_cost, item_value, (SUM (  NVL (bt_qty_on_hand, 0) - NVL (committed_qty, 0) ) ) avail_qty,((SUM (  NVL (bt_qty_on_hand, 0) - NVL (committed_qty, 0) ) )*ST_DISPLAY_UNIT_COST(itm_code))item_value_new, base_uom_qoh,ROUND (NVL(  (SUM (  NVL (bt_qty_on_hand, 0) - NVL (committed_qty, 0) ) ) / NVL ((st_get_uom_conv_fac_sing_str (itm_code, store_code ) ), 1 ),0 ), 4 ) issue_uom_avl, reorder_level,facility_id, facility_name FROM (SELECT   a.store_code, b.short_desc store_desc, a.item_code itm_code, c.short_desc item_desc, a.stock_item_yn,NVL (a.qty_on_hand, 0) qty_on_hand, c.gen_uom_code gen_uom_code, (SELECT short_desc FROM am_uom_lang_vw WHERE uom_code = c.gen_uom_code AND language_id = ?) uom_desc, a.def_issue_uom def_issue_uom, TRIM (st_display_cost_decimals (a.item_code, a.store_code ) ) unit_cost,TRIM(ST_DISPLAY_UNIT_COST(a.item_code))base_unit_cost, item_value, (SELECT short_desc FROM am_uom_lang_vw WHERE uom_code = a.def_issue_uom AND language_id = ?) issue_uom, stb.qty_on_hand bt_qty_on_hand, stb.committed_qty committed_qty, NVL (  NVL (a.qty_on_hand, 0) * NVL ((st_get_uom_conv_fac_sing_str (a.item_code, a.store_code ) ), 1 ), 0 ) base_uom_qoh, a.reorder_level reorder_level,b.facility_id facility_id, (SELECT facility_name FROM sm_facility_param_lang_vw vw WHERE  vw.facility_id = b.facility_id AND language_id = ?) facility_name FROM st_item_store a, mm_store_lang_vw b, mm_item_lang_vw c, st_store e, st_item_batch stb, st_item k WHERE a.store_code = b.store_code AND a.item_code = c.item_code AND a.store_code BETWEEN ? AND ? AND a.item_code = NVL (?, a.item_code) ";
		//Modified by suresh.r on 12-11-2014 against Inc 52256
		//String sql="SELECT DISTINCT x.store_code, store_desc, itm_code, item_desc, stock_item_yn,qty_on_hand, gen_uom_code, uom_desc, def_issue_uom, issue_uom,unit_cost, item_value, avail_qty, base_uom_qoh, issue_uom_avl, reorder_level,facility_id, facility_name,base_unit_cost,item_value_new FROM (SELECT   store_code, store_desc,  itm_code, item_desc, stock_item_yn, qty_on_hand, gen_uom_code, uom_desc, def_issue_uom, issue_uom, unit_cost,base_unit_cost, item_value, (SUM (  NVL (bt_qty_on_hand, 0) - NVL (committed_qty, 0) ) ) avail_qty,((SUM (  NVL (bt_qty_on_hand, 0) - NVL (committed_qty, 0) ) )*ST_DISPLAY_UNIT_COST(itm_code,sysdate,'CURRENT_STOCK'))item_value_new, base_uom_qoh,ROUND (NVL(  (SUM (  NVL (bt_qty_on_hand, 0) - NVL (committed_qty, 0) ) ) / NVL ((st_get_uom_conv_fac_sing_str (itm_code, store_code ) ), 1 ),0 ), 4 ) issue_uom_avl, reorder_level,facility_id, facility_name FROM (SELECT   a.store_code, b.short_desc store_desc, a.item_code itm_code, c.short_desc item_desc, a.stock_item_yn,NVL (a.qty_on_hand, 0) qty_on_hand, c.gen_uom_code gen_uom_code, (SELECT short_desc FROM am_uom_lang_vw WHERE uom_code = c.gen_uom_code AND language_id = ?) uom_desc, a.def_issue_uom def_issue_uom, TRIM (st_display_cost_decimals (a.item_code, a.store_code ) ) unit_cost,TRIM(ST_DISPLAY_UNIT_COST(a.item_code,sysdate,'CURRENT_STOCK'))base_unit_cost, item_value, (SELECT short_desc FROM am_uom_lang_vw WHERE uom_code = a.def_issue_uom AND language_id = ?) issue_uom, stb.qty_on_hand bt_qty_on_hand, stb.committed_qty committed_qty, NVL (  NVL (a.qty_on_hand, 0) * NVL ((st_get_uom_conv_fac_sing_str (a.item_code, a.store_code ) ), 1 ), 0 ) base_uom_qoh, a.reorder_level reorder_level,b.facility_id facility_id, (SELECT facility_name FROM sm_facility_param_lang_vw vw WHERE  vw.facility_id = b.facility_id AND language_id = ?) facility_name FROM st_item_store a, mm_store_lang_vw b, mm_item_lang_vw c, st_store e, st_item_batch stb, st_item k WHERE a.store_code = b.store_code AND a.item_code = c.item_code AND a.store_code BETWEEN ? AND ? AND a.item_code = NVL (?, a.item_code) ";
		//Query moved to StRepoistory by suresh.r on 04-05-2015 against Inc 53228
		String sql=eST.Common.StRepository.getStKeyValue("SQL_ST_STOCK_STATUS_BY_STORE_QUERY");

		if (!(item_desc.equals("%%"))) {
			sql = sql + "  AND UPPER (c.short_desc) LIKE UPPER (?)" ;
			chkFields.add( item_desc); 
		}
		
		if(stock_level.equals("A")){
		 sql = sql + " and NVL (a.qty_on_hand, 0) >=0 "; 
		}else if(stock_level.equals("S")){
  		 sql = sql + " and NVL (a.qty_on_hand, 0) > 0 ";		
		}else if(stock_level.equals("Z")){
  		 sql = sql + " and NVL (a.qty_on_hand, 0) = 0 ";		
		}else if(stock_level.equals("B")){
  		 sql = sql + " and NVL (a.qty_on_hand, 0) < NVL (a.reorder_level,0) ";		
		}

		if (!stock_item.equals("%")) {
			sql = sql + "  AND a.stock_item_yn =  ? " ;
			chkFields.add(stock_item);
		}

		chkFields.add( locale);
		//Modified for ML-MMOH-SCF-0355 on 08/03/2016 by B.Badmavathi
		//sql = sql + " AND b.eff_status = 'E' AND e.store_code = b.store_code AND e.store_type_flag != 'N' AND b.language_id = c.language_id AND b.language_id = ? ";
		sql = sql + " AND b.eff_status = 'E' AND c.eff_status = 'E' AND a.eff_status = 'E' AND e.store_code = b.store_code AND e.store_type_flag != 'N' AND b.language_id = c.language_id AND b.language_id = ? ";

		if (!(fm_item_class.equals("")) ||  !(to_item_class.equals(""))) {

			sql = sql + " AND c.item_class_code BETWEEN NVL (?,'!') AND NVL (?,'~')";

			chkFields.add(fm_item_class);
			chkFields.add(to_item_class);
		}

		if (!(fm_anal1.equals("")) ||  !(to_anal1.equals(""))) {

			sql = sql + " AND NVL (c.item_anal1_code, 'X') BETWEEN NVL(?,NVL(c.item_anal1_code,'X')) AND NVL(?,NVL(c.item_anal1_code,'X')) ";  
			
			chkFields.add(fm_anal1);
			chkFields.add(to_anal1);

		}
		if (!(fm_anal2.equals("")) ||  !(to_anal2.equals(""))) {

			sql = sql + " AND NVL (c.item_anal2_code, 'X') BETWEEN NVL (?,NVL (c.item_anal2_code,'X')) AND NVL (?,NVL (c.item_anal2_code,'X')) ";

			chkFields.add(fm_anal2);
			chkFields.add(to_anal2);

		}
		if (!(fm_anal3.equals("")) ||  !(to_anal3.equals(""))) {

			sql = sql +  " AND NVL (c.item_anal3_code, 'X') BETWEEN NVL(?,NVL (c.item_anal3_code,'X')) AND NVL(?,NVL (c.item_anal3_code,'X'))" ;
		
			chkFields.add(fm_anal3);
			chkFields.add(to_anal3);
		}
        //Commented by Rabbani #Inc no :39203 on  18-APR-2013
		//sql = sql + " AND facility_id = ? AND a.store_code = stb.store_code(+) AND a.item_code = stb.item_code(+) AND k.item_code = a.item_code AND (   expiry_yn = 'N' OR (    expiry_yn = 'Y' AND (   (  /*  use_after_expiry_yn = 'Y' AND */('Y' = 'Y') ) OR decode(a.qty_on_hand, 0, sysdate,expiry_date_or_receipt_date) >= TRUNC (NVL (TO_DATE ('','dd/mm/yyyy'), SYSDATE )) )) )) GROUP BY store_code, store_desc, itm_code, item_desc, stock_item_yn, qty_on_hand, gen_uom_code, item_value, def_issue_uom, gen_uom_code, uom_desc, issue_uom, reorder_level, unit_cost, base_uom_qoh) x, st_acc_entity_param i, st_user_access_for_store j WHERE j.user_id LIKE (CASE WHEN i.restrict_view_stk_status = 'ALL' THEN '%' WHEN i.restrict_view_stk_status = 'UAS' THEN ? END ) AND x.store_code = j.store_code";
		
		//Added by Rabbani #Inc no :39203 on  18-APR-2013
	     String trn_across_facility_yn =		bean.checkForNull((String)bean.fetchRecord("select  trn_across_facility_yn  from  ST_ACC_ENTITY_PARAM where ACC_ENTITY_ID= 'ZZ'").get("TRN_ACROSS_FACILITY_YN"),"N");

		 //MOHE-ICN-0015
		   String restrict_view_stk_status =		bean.checkForNull((String)bean.fetchRecord("select  restrict_view_stk_status  from  ST_ACC_ENTITY_PARAM where ACC_ENTITY_ID= 'ZZ'").get("RESTRICT_VIEW_STK_STATUS"),"N");
		 
		 if(trn_across_facility_yn.equals("N")){
         sql = sql + "  AND FACILITY_ID  = ? ";
	     chkFields.add(bean.getLoginFacilityId());
          }
		//ends
		
		//sql = sql + "  AND a.store_code = stb.store_code(+) AND a.item_code = stb.item_code(+) AND k.item_code = a.item_code AND (   expiry_yn = 'N' OR (    expiry_yn = 'Y' AND (   (  /*  use_after_expiry_yn = 'Y' AND */('Y' = 'Y') ) OR decode(a.qty_on_hand, 0, sysdate,expiry_date_or_receipt_date) >= TRUNC (NVL (TO_DATE ('','dd/mm/yyyy'), SYSDATE )) )) )) GROUP BY store_code, store_desc, itm_code, item_desc, stock_item_yn, qty_on_hand, gen_uom_code, item_value, def_issue_uom, gen_uom_code, uom_desc, issue_uom, reorder_level,facility_id, facility_name, unit_cost, base_uom_qoh,base_unit_cost) x, st_acc_entity_param i, st_user_access_for_store j WHERE j.user_id LIKE (CASE WHEN i.restrict_view_stk_status = 'ALL' THEN '%' WHEN i.restrict_view_stk_status = 'UAS' THEN ? END ) AND x.store_code = j.store_code";
		//Modified by suresh.r on 04-05-2015 against Inc 53228
		//sql = sql + "  AND a.store_code = stb.store_code(+) AND a.item_code = stb.item_code(+) AND k.item_code = a.item_code AND (   expiry_yn = 'N' OR (    expiry_yn = 'Y' AND (   (  /*  use_after_expiry_yn = 'Y' AND */('Y' = 'Y') ) OR decode(a.qty_on_hand, 0, sysdate,expiry_date_or_receipt_date) >= TRUNC (NVL (TO_DATE ('','dd/mm/yyyy'), SYSDATE )) )) )) GROUP BY store_code, store_desc, itm_code, item_desc, stock_item_yn, qty_on_hand, gen_uom_code, item_value, def_issue_uom, gen_uom_code, uom_desc, issue_uom, reorder_level,facility_id, facility_name, unit_cost, base_uom_qoh,base_unit_cost) x, st_acc_entity_param i WHERE exists (select 'Y' from st_user_access_for_store where store_code = x.store_code and user_id = (CASE WHEN i.restrict_view_stk_status = 'ALL' THEN user_id WHEN i.restrict_view_stk_status = 'UAS' THEN ? END))";
		//MOdified on performance passed from front end st_acc_entity_param ...restrict_view_stk_status value  MOHE-ICN-0015
		sql = sql + "  AND a.store_code = stb.store_code(+) AND a.item_code = stb.item_code(+) AND k.item_code = a.item_code AND (   expiry_yn = 'N' OR (    expiry_yn = 'Y' AND (   (  /*  use_after_expiry_yn = 'Y' AND */('Y' = 'Y') ) OR decode(a.qty_on_hand, 0, sysdate,expiry_date_or_receipt_date) >= TRUNC (NVL (TO_DATE ('','dd/mm/yyyy'), SYSDATE )) )) )) GROUP BY store_code, store_desc, itm_code, item_desc, stock_item_yn, qty_on_hand, gen_uom_code, item_value, def_issue_uom, gen_uom_code, uom_desc, issue_uom, reorder_level,facility_id, facility_name, unit_cost, base_uom_qoh,base_unit_cost) x  WHERE exists (select 'Y' from st_user_access_for_store where store_code = x.store_code and user_id = nvl(?, user_id)) ";


		if(restrictInReportYN.equals("Y")){//21623  
			sql =sql + "and store_code in (select store_code from st_user_access_for_store where user_id= ?)"; 
		}
 				 
		if(sort_order.equals(""))
		{
			 sort_order = " ORDER BY store_desc, item_desc";
		     item_code_img ="display:''";
		} else if(sort_order.contains("item_code")) 
			{
            
			 if(sort_order.contains("Asc"))
			{
		     	//sort_order = " ORDER BY "+sort_order;
				sort_order = " ORDER BY store_desc,itm_code";
				item_code_img ="display:''";
			    s2=s1;
			}
			if(sort_order.contains("Desc"))
		         {
		           //sort_order = " ORDER BY "+sort_order;
				   sort_order = " ORDER BY store_desc,itm_code DESC";
	               item_code_img ="display:''";
			       s1=s2;
		         }		
		}else if(sort_order.contains("BASE_UOM_QOH"))
		{
            if(sort_order.contains("Asc"))
			{
                 sort_order = " ORDER BY "+sort_order;
			     base_uom_qoh_img ="display:''";
			     s2=s1;
			}
			if(sort_order.contains("Desc"))
			{
               sort_order = " ORDER BY "+sort_order;
			   base_uom_qoh_img ="display:''";
			   s1=s2;			
			}
		}else if(sort_order.contains("ITEM_VALUE")) 
		{
			if(sort_order.contains("Asc"))
			{
              sort_order = " ORDER BY "+sort_order;
			  item_value_img ="display:''";
			  s2=s1;
			}else
			{
			   sort_order = " ORDER BY "+sort_order;
			   item_value_img ="display:''";
			   s1=s2;			
			}
		}else if(sort_order.contains("item_desc"))
		{
		     if(sort_order.contains("Asc"))
			{
              sort_order = " ORDER BY "+sort_order;
			  item_desc_img ="display:''";
			  s2=s1;
			}
			if(sort_order.contains("Desc"))
			{
			   sort_order = " ORDER BY "+sort_order;
			   item_desc_img ="display:''";
			   s1=s2;			
			}
	}else if(sort_order.contains("QTY_ON_HAND"))
		{
            if(sort_order.contains("Asc"))
			{
                 sort_order = " ORDER BY "+sort_order;
			     qoh_img ="display:''";
			     s2=s1;
			}
			if(sort_order.contains("Desc"))
			{
               sort_order = " ORDER BY "+sort_order;
			   qoh_img ="display:''";
			   s1=s2;			
			}
		}

 		 
		 sqlMap.put("sqlData", sql+sort_order);

		
		displayFields.add("STORE_DESC");	//1
		displayFields.add("ITM_CODE");		//2
		displayFields.add("ITEM_DESC");
		displayFields.add("AVAIL_QTY");        //3
		displayFields.add("ISSUE_UOM");         
		displayFields.add("ISSUE_UOM_AVL");     //5
		
		displayFields.add("BASE_UOM_QOH");        //6
		displayFields.add("UOM_DESC");
		displayFields.add("QTY_ON_HAND");        //8
		//displayFields.add("STOCK_UOM_DESC");
		displayFields.add("UNIT_COST");
		displayFields.add("ITEM_VALUE");
		displayFields.add("STOCK_ITEM_YN");
		displayFields.add("STORE_CODE");
		displayFields.add("REORDER_LEVEL");
		//displayFields.add("EQVL_VALUE");
		displayFields.add("FACILITY_NAME"); //Added by Rabbani #Inc no :39203 on  23-APR-2013
		displayFields.add("BASE_UNIT_COST"); //Added by Sakti against TTM-SCF-0106 to get base_unit_cost
		displayFields.add("ITEM_VALUE_NEW"); //Added by Sakti against TTM-SCF-0106 to get (base uom unit_cost*qty)item_value_new
	// System.out.println("displayFields 221" +displayFields);
		
		//displayFields.add("store_type_flag");

		//chkFields.add( (String)session.getAttribute("facility_id"));
		//chkFields.add(bean.getLoginFacilityId());
		
		// MOHE-ICN-0015
System.err.println("==RESTRICT_VIEW_STK_STATUS"+restrict_view_stk_status);
		if(restrict_view_stk_status!=null && restrict_view_stk_status.equals("ALL")) 
			chkFields.add("");  // pass "" as it wil check for NVL to take user id ....restrict access
		else 
		   chkFields.add(bean.getLoginById());  // restrict access - MOHE-ICN-0015
if(restrictInReportYN.equals("Y")){//21623  
	chkFields.add(bean.getLoginById());  
}
      
		funcMap.put("displayFields", displayFields);
		funcMap.put("chkFields", chkFields);
		ArrayList result			=		(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
System.err.println("sqlMap==>"+sqlMap+"chkFields==>"+chkFields);
       
		if((result.size()>=3) && (!(((String) result.get(0)).equals("0")))){
//System.err.println("result.size()==>"+result.size());
		%>
			<table  border = 0 cellpadding=0 cellspacing=0 width="100%" align="center">
			  
			<tr>
				<td width="80%" class="white" >&nbsp;</td>
				<td width="20%" class="white" >&nbsp;<%=result.get(1)%></td>
			</tr>
			</table>
			<table   cellpadding=0 cellspacing=1 width="100%" align="center">
				<%if((accessCostDetails).equals("N")){%>
				<th nowrap width="40%" colspan=2>&nbsp;</th>
				<th nowrap colspan=3 width = "18%">Inventory On Hand<br>(Issue UOM)</br></th>
				<th nowrap colspan=3 width ="18%">Inventory On Hand<br>(Base UOM)</br></th>
				<th nowrap colspan=2>&nbsp;</th>
				<%}%>
				<%if((accessCostDetails).equals("Y")){%>
                  <th nowrap width="34%" colspan=2>&nbsp;</th>
				<th  colspan=2 width = "16%">Inventory On Hand<br>(Issue UOM)</br></th>
				<th  colspan=2 width ="16%">Inventory On Hand<br>(Base UOM)</br></th>
				<th nowrap colspan=2>&nbsp;</th>
                 <%}%>
			</table>
			<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center" id='tb1'>
				<th nowrap width="20%" onclick ="sortOrder(this,'../../eST/images/Ascending.gif','../../eST/images/Descending.gif');" style="WORD-BREAK:BREAK-ALL;cursor:pointer" name="item_code" id="item_code"><fmt:message key="Common.ItemCode.label" bundle="${common_labels}" />&nbsp;&nbsp;<img name="item_code" id="item_code" style=<%=item_code_img%> src=<%=s1%> border=none alt="Sort Order"></th>
				<th nowrap style="WORD-BREAK:BREAK-ALL;cursor:pointer" name="item_desc" id="item_desc"  width="20%" onclick ="sortOrder(this,'../../eST/images/Ascending.gif','../../eST/images/Descending.gif');"><fmt:message key="Common.ItemDescription.label" bundle="${common_labels}"/>&nbsp;&nbsp;<img name="item_desc_img" id="item_desc"  style=<%=item_desc_img%> src=<%=s1%> border=none alt="Sort Order"></th>
				<th nowrap width="6%" name="QTY_ON_HAND" id="QTY_ON_HAND" style="WORD-BREAK:BREAK-ALL;cursor:pointer" onclick ="sortOrder(this,'../../eST/images/Ascending.gif','../../eST/images/Descending.gif');">QOH&nbsp;<img style=<%=qoh_img%> src=<%=s1%> border=none alt="Descending Order"></th>
				<th nowrap width="6%">UOM</th>
				<th nowrap width="6%">Avl.Qty</th>
				<th nowrap width="6%" name="BASE_UOM_QOH" id="BASE_UOM_QOH" style="WORD-BREAK:BREAK-ALL;cursor:pointer" onclick ="sortOrder(this,'../../eST/images/Ascending.gif','../../eST/images/Descending.gif');">QOH &nbsp;<img name="base_uom_qoh" id="base_uom_qoh" style=<%=base_uom_qoh_img%> src=<%=s1%> border=none alt="Sort Order"></th>
				<th nowrap width="6%">UOM</th>
				<th nowrap width="6%">Avl.Qty</th>
				<!--<th nowrap><fmt:message key="Common.StockUOM.label" bundle="${common_labels}"/></th>
									
				<th nowrap><fmt:message key="eST.ConvFactor.label" bundle="${st_labels}"/></th>-->
		<%if((accessCostDetails).equals("Y")){%>
				<th nowrap width="12%"><fmt:message key="Common.UnitCost.label" bundle="${common_labels}"/></th>
				<th nowrap width="12%" style="WORD-BREAK:BREAK-ALL;cursor:pointer" name = "item_value" id = "item_value" onclick ="sortOrder(this,'../../eST/images/Ascending.gif','../../eST/images/Descending.gif');">Cost Value &nbsp;<img name="item_value" id = "item_value" style=<%=item_value_img%> src=<%=s2%> border=none alt="Sort Order"></th>
		<%}%>	
				<th nowrap><fmt:message key="eST.StockItem.label" bundle="${st_labels}"/></th>
				<th nowrap>RO Level</th>
			</tr> 
				<%
						ArrayList records=new ArrayList();
						for(int recCount=2,k = 0; recCount<result.size(); recCount++,k++) {
								classvalue			=	(recCount % 2 == 0)?"QRYEVEN":"QRYODD";
							//  String link_columns =	"1";
								records				=	(ArrayList) result.get(recCount);
						

				%>
			 
				
			<%
				
								curr_item_store		=		(String)records.get(0);
				if(!curr_item_store.equals(prev_item_store))
				{
				%>
				<tr>
				
				<td colspan=12 align='left' class='ITEMSELECT'><font size=1><b><fmt:message key="Common.Store.label" bundle="${common_labels}"/>:</b> 
				<!--Added by Rabbani #Inc no :39203 on  23-APR-2013 -->
				<%=CommonBean.checkForNull((String)records.get(0),"")%>&nbsp;&nbsp;&nbsp;<b> Facility Name :</b>   <%=CommonBean.checkForNull((String)records.get(14),"")%></td>
							
				</tr>
				<%
								store_code_from			=		CommonBean.checkForNull((String)records.get(0),"");
					}
					else{%>
			<%}%>
				
				<tr id="tr_<%=k%>">
	
	<td class="<%=classvalue%>" onClick="callBatchSearchScreen('<%=(String)records.get(1)%>','<%=(String)records.get(12)%>');" onmouseover="changeCursor(this);" ><font class='HYPERLINK'><%=(String)records.get(1)%></font></td>
	<td class="<%=classvalue%>" align="left" style="font-size:7pt;WORD-BREAK:BREAK-ALL;"><%=CommonBean.checkForNull((String)records.get(2),"&nbsp;")%></td>
	<!--
	* @Name - Priya
	* @Date - 01/02/2010
	* @Inc# - 15496 (SRR20056-CRF-0537.2)
	* @Desc - Modified by priya as if the value of 'QOH' ,'UOM' & 'AVL.QTY' is equal to zero and no_of_decimals is 4 then it should be displayed as 0 only & not as '0.000' & so used the common method
	-->
	<td class="<%=classvalue%>" style="TEXT-ALIGN:right"><font size=1><%=bean.setNumberFormat(bean.checkForNull((String)records.get(8),"0"),no_of_decimals)%></font></td>
 	<td class="<%=classvalue%>" align="left"><font size=1><%=bean.checkForNull((String)records.get(4))%></font></td>
	<td class="<%=classvalue%>" style="TEXT-ALIGN:right"><font size=1 ><%=bean.setNumberFormat(bean.checkForNull((String)records.get(5),"0"),no_of_decimals)%></font></td>
	<td class="<%=classvalue%>" style="TEXT-ALIGN:right"><font size=1><%=bean.setNumberFormat(bean.checkForNull((String)records.get(6),"0"),no_of_decimals)%></font></td>
	<td class="<%=classvalue%>" align="left"><font size=1><%=bean.checkForNull((String)records.get(7))%></font></td>
	<td class="<%=classvalue%>" style="TEXT-ALIGN:right"><font size=1><%=bean.setNumberFormat(bean.checkForNull((String)records.get(3),"0"),no_of_decimals)%></font></td>
	
	<% String val=CommonBean.checkForNull((String)records.get(15),"0"); %>
<%if((accessCostDetails).equals("Y")){%>
	<td class="<%=classvalue%>" style="TEXT-ALIGN:right" title="<%=val%>"><font size=1><%=bean.setNumberFormat(bean.checkForNull(val,"0"),noOfDecimalsForCost)%></font></td>
	<td class="<%=classvalue%>" style="TEXT-ALIGN:right" ><font size=1>
	<% String num=CommonBean.checkForNull((String)records.get(16),"0");
	%>
	
	<%=num.equals("0")? "0.00":bean.setNumberFormat(bean.checkForNull(num,"0"),noOfDecimalsForCost)%></font></td>
<%}%>
	<td class="<%=classvalue%>" align="center"><font size=1>
					
	<%
	if(CommonBean.checkForNull((String)records.get(11)).equals("Y"))
	out.println("<img src=\'../../eCommon/images/enabled.gif\'></img>");
					else
	out.println("<img src=\'../../eCommon/images/disabled.gif\'></img>");

				%>
	
				</font></td>
				
				<td class="<%=classvalue%>" style="TEXT-ALIGN:right"><font size=1><%=CommonBean.checkForNull((String)records.get(13),"&nbsp;")%></font></td>
		<td class='NODISPLAY'><%=records.get(8)%></td>	
		  
      
		</tr>
			
		<%
			prev_item_store=curr_item_store;
			}
		%>
		
		<%
	
		} 
		else{
			

		%>
			<script>
				alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
				document.location.href="../../eCommon/html/blank.html";
			</script>
		<%
		
		}
		out.println(" </table>	</form>");
		out.flush();
		
		out.println(CommonBean.setForm (request ,"../../eST/jsp/StockStatusByStoreResult.jsp", searched));

		
	}
	catch(Exception e) {
		out.print("Exception @ Result JSP :"+e.toString());

		e.printStackTrace();
	}
	finally{//21623
		//if(con != null)
		//	ConnectionManager.returnConnection(con,request);  //MOHE-ICN-0015
	}
%>
	<%
putObjectInBean(bean_id,bean,request);
%>
		
</body>

<!-- <script>activeLink();</script> -->
</html>

