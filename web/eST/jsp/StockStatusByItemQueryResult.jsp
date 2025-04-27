<!DOCTYPE html>
<%@ page import ="eST.StockStatusByItemBean, eST.Common.* , java.util.HashMap,java.text.NumberFormat , java.util.Locale,java.util.ArrayList,java.text.DecimalFormat" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<html>
	<head>
		<title></title>
<%
		request.setCharacterEncoding("UTF-8");
		String locale				=		(String)session.getAttribute("LOCALE");
		String sStyle				=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eCommon/js/rowcolor.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../eST/js/StCommon.js"></script>
		<script language="Javascript" src="../../eST/js/StockStatusByItem.js">
		</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body>
<%
	
	String store_code_from			 =			request.getParameter( "store_code_from" )==null?"":request.getParameter( "store_code_from" );
	String store_code_to			 =			request.getParameter( "store_code_to" )==null?"":request.getParameter( "store_code_to" );
	String stock_level				 =			request.getParameter( "stock_level" )==null?"A":request.getParameter( "stock_level" );
	String item_code				 =			request.getParameter( "item_code" )==null?"":request.getParameter( "item_code" );
	 //Added by Rabbani #Inc no :39203 on  18/04/2013
	String dflt_facility_id	        =			request.getParameter( "dflt_facility_id" )==null?"":request.getParameter( "dflt_facility_id" );
	dflt_facility_id				=			CommonBean.checkForNull(dflt_facility_id,"%");
	String facility_name			=			"";  
	item_code						=			CommonBean.checkForNull(item_code,"%");
	String store_desc				=			"";
	String qty_on_hand				=			"";
	String item_value				=			"";
	String reorder_level			=			"";
	String bin_desc					=			"";
	String stock_yn					=			"";
	String store_code				=			"";
	String aval_qty					=			"";
	String bean_id					=			"StockStatusByItemBean";
	String bean_name				=			"eST.StockStatusByItemBean";
	StockStatusByItemBean bean		=			(StockStatusByItemBean) getBeanObject( bean_id, bean_name,request );
	bean.setLanguageId(locale);
	String item_value_new			=			"";
	String restrictInReportYN		= ""; //MOHE-ICN-0015

	boolean searched				=			(request.getParameter("searched") == null) ?false:true;
	//Added by Rabbani #30069(BRU-HIMS-CRF-110) on 23-APR-2013
	String includeSuspendedBatches	 =			request.getParameter( "includeSuspendedBatches" )==null?"N":request.getParameter( "includeSuspendedBatches" );
	
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
	/* Query Changed By rams
       Incident No : 18097
	   Format Masking in the query is removed As It is Not Giving Right Values for the Avl.Qty and Qty_on_Hand
	   Date 1/11/2010
	*/
	
	
	
	try{
		HashMap sqlMap				=			new HashMap();
		HashMap funcMap				=			new HashMap();
		ArrayList displayFields		=			new ArrayList();
		ArrayList chkFields			=			new ArrayList();
		//String user_name			=			(String) session.getValue( "login_user" ) ;


		//MOHE-ICN-0015
		String restrict_view_stk_status =		bean.checkForNull((String)bean.fetchRecord("select  restrict_view_stk_status  from  ST_ACC_ENTITY_PARAM where ACC_ENTITY_ID= 'ZZ'").get("RESTRICT_VIEW_STK_STATUS"),"N");
		//sqlMap.put("sqlData", eST.Common.StRepository.getStKeyValue("SQL_ST_STOCK_STATUS_BY_ITEM_STORE_LEVEL"));
		//sqlMap.put("sqlData", " SELECT   A.ITEM_CODE ITEM_CODE, A.STORE_CODE STORE_CODE,B.SHORT_DESC STORE_DESC, DECODE (TRIM (TO_CHAR (SUM (NVL (H.QTY_ON_HAND, 0)), '999,999,999,999,999,999,999') ), '.00', '0', TRIM (TO_CHAR (SUM (NVL (H.QTY_ON_HAND, 0)), '999,999,999,999,999,999,999') ) ) QTY_ON_HAND,A.STOCK_ITEM_YN STOCK_ITEM_YN, A.BIN_LOCATION_CODE,C.SHORT_DESC BIN_DESC,DECODE (TRIM (TO_CHAR ( NVL (A.REORDER_LEVEL, '0'),'999,999,999,999,999,999,999')),'0', '',TRIM (TO_CHAR ( NVL (A.REORDER_LEVEL, '0'),'999,999,999,999,999,999,999'))) REORDER_LEVEL,DECODE (TRIM (TO_CHAR (A.ITEM_VALUE,'999,999,999,999,999,999,999.99')),'.00', '0.00',TRIM (TO_CHAR (A.ITEM_VALUE,'999,999,999,999,999,999,999.99'))) ITEM_VALUE,DECODE (TRIM (TO_CHAR ( SUM (NVL (H.QTY_ON_HAND, 0) - NVL (H.COMMITTED_QTY, 0)),'999,999,999,999,999,999,999')),'.00', '0',TRIM (TO_CHAR ( SUM (NVL (H.QTY_ON_HAND, 0) - NVL (H.COMMITTED_QTY, 0)),'999,999,999,999,999,999,999')))  AVAILABLE_QTY,G.SHORT_DESC STOCK_UOM_DESC FROM ST_ITEM_STORE A,MM_STORE_LANG_VW B,MM_BIN_LOCATION_LANG_VW C /*,ST_USER_ACCESS_FOR_STORE D */,ST_STORE E,MM_ITEM_LANG_VW F,AM_UOM G,ST_ITEM_BATCH H WHERE A.STORE_CODE = B.STORE_CODE AND A.STORE_CODE = C.STORE_CODE(+) AND A.BIN_LOCATION_CODE = C.BIN_LOCATION_CODE(+) AND A.ITEM_CODE = ? /* AND D.USER_ID = ? AND D.STORE_CODE = B.STORE_CODE */ AND B.STORE_CODE = E.STORE_CODE AND E.STORE_TYPE_FLAG != 'N' AND B.LANGUAGE_ID = C.LANGUAGE_ID AND B.LANGUAGE_ID = ? AND B.LANGUAGE_ID = F.LANGUAGE_ID AND A.ITEM_CODE = F.ITEM_CODE AND A.DEF_ISSUE_UOM = G.UOM_CODE AND B.FACILITY_ID = ? AND E.STORE_CODE BETWEEN NVL (UPPER (?), '!') AND NVL (UPPER (?), '~') AND (   (? = 'Z' AND A.QTY_ON_HAND = 0) OR (? = 'S' AND A.QTY_ON_HAND > 0) OR (? = 'B' AND A.QTY_ON_HAND < NVL (A.REORDER_LEVEL, '0')) OR ? = 'A' ) AND A.STORE_CODE = H.STORE_CODE(+) AND A.ITEM_CODE = H.ITEM_CODE(+) GROUP BY A.ITEM_CODE, A.STORE_CODE, B.SHORT_DESC, A.QTY_ON_HAND, A.STOCK_ITEM_YN, A.BIN_LOCATION_CODE, C.SHORT_DESC, REORDER_LEVEL, A.ITEM_VALUE, G.SHORT_DESC ORDER BY STORE_DESC, QTY_ON_HAND, ITEM_VALUE ");
		/**
			* @Name - Priya
			* @Date - 29/04/2010
			* @Inc# - 20990
			* @Desc - h.expiry_date_or_receipt_date column is included in the select distinct sub query 
			*/
		//sqlMap.put("sqlData", "SELECT   item_code, store_code, store_desc, SUM (NVL (qty_on_hand, 0)) qty_on_hand, stock_item_yn, bin_location_code, bin_desc, DECODE (TRIM (TO_CHAR (NVL (reorder_level, '0'), '999,999,999,999,999,999,999' ) ), '0', '', TRIM (TO_CHAR (NVL (reorder_level, '0'), '999,999,999,999,999,999,999' ))) reorder_level, DECODE (TRIM (TO_CHAR (item_value, '999,999,999,999,999,999,999.99')), '.00', '0.00', TRIM (TO_CHAR (item_value, '999,999,999,999,999,999,999.99')) ) item_value, SUM (  NVL (qty_on_hand, 0)  - NVL (committed_qty, 0)),SUM (  NVL (qty_on_hand, 0) - NVL (committed_qty, 0)) available_qty, stock_uom_desc FROM (SELECT distinct h.batch_id, a.item_code item_code, a.store_code store_code, b.short_desc store_desc, h.qty_on_hand, a.stock_item_yn stock_item_yn, a.bin_location_code, c.short_desc bin_desc, a.reorder_level, a.item_value, h.committed_qty, g.short_desc stock_uom_desc,h.expiry_date_or_receipt_date FROM st_item_store a, mm_store_lang_vw b, mm_bin_location_lang_vw c, st_user_access_for_store d, st_store e, mm_item_lang_vw f, am_uom g, st_item_batch h, st_acc_entity_param i WHERE a.store_code = b.store_code AND a.store_code = c.store_code(+) AND a.bin_location_code = c.bin_location_code(+) AND a.item_code = ? AND b.store_code = e.store_code AND e.store_type_flag != 'N' AND c.language_id(+) = ? AND b.language_id = ? AND b.language_id = f.language_id AND a.item_code = f.item_code AND a.def_issue_uom = g.uom_code AND b.facility_id = ? AND e.store_code BETWEEN NVL (UPPER (?), '!') AND NVL (UPPER (?), '~') AND (   (? = 'Z' AND a.qty_on_hand = 0) OR (? = 'S' AND a.qty_on_hand > 0) OR (? = 'B' AND a.qty_on_hand < NVL (a.reorder_level, '0') ) OR ? = 'A' ) AND a.store_code = h.store_code(+) AND a.item_code = h.item_code(+) AND d.user_id LIKE DECODE (i.restrict_view_stk_status, 'ALL', '%', ? ) AND a.store_code = d.store_code) GROUP BY item_code, store_code, store_desc, stock_item_yn, bin_location_code, bin_desc, reorder_level, item_value, stock_uom_desc ORDER BY store_desc, qty_on_hand, item_value");
		/**
		 * @Name - Priya
		 * @Date - 07/06/2010
		 * @Inc# - 
		 * @Desc -  To get item_value with out ',' format the above query is modified 
		 */
		 //Commented by Rabbani #Inc no :39203 on  18-APR-2013
		//sqlMap.put("sqlData", "SELECT   item_code, store_code, store_desc, SUM (NVL (qty_on_hand, 0)) qty_on_hand, stock_item_yn, bin_location_code, bin_desc, DECODE (TRIM (TO_CHAR (NVL (reorder_level, '0'), '999,999,999,999,999,999,999' ) ), '0', '', TRIM (TO_CHAR (NVL (reorder_level, '0'), '999,999,999,999,999,999,999' ))) reorder_level, item_value, SUM (  NVL (qty_on_hand, 0)  - NVL (committed_qty, 0)),SUM (  NVL (qty_on_hand, 0) - NVL (committed_qty, 0)) available_qty, stock_uom_desc FROM (SELECT distinct h.batch_id, a.item_code item_code, a.store_code store_code, b.short_desc store_desc, h.qty_on_hand, a.stock_item_yn stock_item_yn, a.bin_location_code, c.short_desc bin_desc, a.reorder_level, a.item_value, h.committed_qty, g.short_desc stock_uom_desc,h.expiry_date_or_receipt_date FROM st_item_store a, mm_store_lang_vw b, mm_bin_location_lang_vw c, st_user_access_for_store d, st_store e, mm_item_lang_vw f, am_uom g, st_item_batch h, st_acc_entity_param i, st_item j WHERE a.store_code = b.store_code AND a.store_code = c.store_code(+) AND a.bin_location_code = c.bin_location_code(+) AND a.item_code = ? AND b.store_code = e.store_code AND e.store_type_flag != 'N' AND c.language_id(+) = ? AND b.language_id = ? AND b.language_id = f.language_id AND a.item_code = f.item_code AND a.def_issue_uom = g.uom_code AND b.facility_id = ? AND e.store_code BETWEEN NVL (UPPER (?), '!') AND NVL (UPPER (?), '~') AND (   (? = 'Z' AND a.qty_on_hand = 0) OR (? = 'S' AND a.qty_on_hand > 0) OR (? = 'B' AND a.qty_on_hand < NVL (a.reorder_level, '0') ) OR ? = 'A' ) AND a.store_code = h.store_code(+) AND a.item_code = h.item_code(+) AND d.user_id LIKE DECODE (i.restrict_view_stk_status, 'ALL', '%', ? ) AND a.store_code = d.store_code AND j.item_code = a.item_code AND (   expiry_yn = 'N'    OR (    expiry_yn = 'Y' AND (   (    /* use_after_expiry_yn = 'Y' AND */ ('Y' = 'Y') ) OR decode(a.qty_on_hand,0,sysdate,expiry_date_or_receipt_date) >= TRUNC (NVL (TO_DATE ('', 'dd/mm/yyyy'), SYSDATE ) ) )))) GROUP BY item_code, store_code, store_desc, stock_item_yn, bin_location_code, bin_desc, reorder_level, item_value, stock_uom_desc ORDER BY store_desc, qty_on_hand, item_value");
		
		//Added by Rabbani #Inc no :39203 on  18-APR-2013
		//Commented by Rabbani #30069(BRU-HIMS-CRF-110) on 23-APR-2013
		//sqlMap.put("sqlData", "SELECT   item_code, store_code, store_desc, SUM (NVL (qty_on_hand, 0)) qty_on_hand, stock_item_yn, bin_location_code, bin_desc, DECODE (TRIM (TO_CHAR (NVL (reorder_level, '0'), '999,999,999,999,999,999,999' ) ), '0', '', TRIM (TO_CHAR (NVL (reorder_level, '0'), '999,999,999,999,999,999,999' ))) reorder_level, item_value, SUM (  NVL (qty_on_hand, 0)  - NVL (committed_qty, 0)),SUM (  NVL (qty_on_hand, 0) - NVL (committed_qty, 0)) available_qty, stock_uom_desc FROM (SELECT distinct h.batch_id, a.item_code item_code, a.store_code store_code, b.short_desc store_desc, h.qty_on_hand, a.stock_item_yn stock_item_yn, a.bin_location_code, c.short_desc bin_desc, a.reorder_level, a.item_value, h.committed_qty, g.short_desc stock_uom_desc,h.expiry_date_or_receipt_date FROM st_item_store a, mm_store_lang_vw b, mm_bin_location_lang_vw c, st_user_access_for_store d, st_store e, mm_item_lang_vw f, am_uom g, st_item_batch h, st_acc_entity_param i, st_item j WHERE a.store_code = b.store_code AND a.store_code = c.store_code(+) AND a.bin_location_code = c.bin_location_code(+) AND a.item_code = ? AND b.store_code = e.store_code AND e.store_type_flag != 'N' AND c.language_id(+) = ? AND b.language_id = ? AND b.language_id = f.language_id AND a.item_code = f.item_code AND a.def_issue_uom = g.uom_code AND b.facility_id LIKE ? AND e.store_code BETWEEN NVL (UPPER (?), '!') AND NVL (UPPER (?), '~') AND (   (? = 'Z' AND a.qty_on_hand = 0) OR (? = 'S' AND a.qty_on_hand > 0) OR (? = 'B' AND a.qty_on_hand < NVL (a.reorder_level, '0') ) OR ? = 'A' ) AND a.store_code = h.store_code(+) AND a.item_code = h.item_code(+) AND d.user_id LIKE DECODE (i.restrict_view_stk_status, 'ALL', '%', ? ) AND a.store_code = d.store_code AND j.item_code = a.item_code AND (   expiry_yn = 'N'    OR (    expiry_yn = 'Y' AND (   (    /* use_after_expiry_yn = 'Y' AND */ ('Y' = 'Y') ) OR decode(a.qty_on_hand,0,sysdate,expiry_date_or_receipt_date) >= TRUNC (NVL (TO_DATE ('', 'dd/mm/yyyy'), SYSDATE ) ) )))) GROUP BY item_code, store_code, store_desc, stock_item_yn, bin_location_code, bin_desc, reorder_level, item_value, stock_uom_desc ORDER BY store_desc, qty_on_hand, item_value");
		
		//Added by Rabbani #30069(BRU-HIMS-CRF-110) on 23-APR-2013
		//sqlMap.put("sqlData", "SELECT   item_code, store_code, store_desc, SUM (NVL (qty_on_hand, 0)) qty_on_hand, stock_item_yn, bin_location_code, bin_desc, DECODE (TRIM (TO_CHAR (NVL (reorder_level, '0'), '999,999,999,999,999,999,999' ) ), '0', '', TRIM (TO_CHAR (NVL (reorder_level, '0'), '999,999,999,999,999,999,999' ))) reorder_level, item_value, SUM (  NVL (qty_on_hand, 0)  - NVL (committed_qty, 0)),DECODE (?,'Y', SUM (NVL (qty_on_hand, 0) - NVL (committed_qty, 0)), SUM (DECODE (suspended_yn, 'N', qty_on_hand, 0)) - SUM (DECODE (suspended_yn, 'N', committed_qty, 0))) available_qty, stock_uom_desc,facility_id ,facility_name FROM (SELECT distinct h.batch_id, a.item_code item_code, a.store_code store_code, b.short_desc store_desc, h.qty_on_hand, a.stock_item_yn stock_item_yn, a.bin_location_code, c.short_desc bin_desc, a.reorder_level, a.item_value, h.committed_qty, g.short_desc stock_uom_desc,h.expiry_date_or_receipt_date ,h.SUSPENDED_YN,b.facility_id facility_id,(SELECT facility_name FROM sm_facility_param_lang_vw vw  WHERE vw.facility_id = b.facility_id AND language_id = ?) facility_name FROM st_item_store a, mm_store_lang_vw b, mm_bin_location_lang_vw c, st_user_access_for_store d, st_store e, mm_item_lang_vw f, am_uom g, st_item_batch h, st_acc_entity_param i, st_item j WHERE a.store_code = b.store_code AND a.store_code = c.store_code(+) AND a.bin_location_code = c.bin_location_code(+) AND a.item_code = ? AND b.store_code = e.store_code AND e.store_type_flag != 'N' AND c.language_id(+) = ? AND b.language_id = ? AND b.language_id = f.language_id AND a.item_code = f.item_code AND a.def_issue_uom = g.uom_code AND b.facility_id LIKE ? AND e.store_code BETWEEN NVL (UPPER (?), '!') AND NVL (UPPER (?), '~') AND (   (? = 'Z' AND a.qty_on_hand = 0) OR (? = 'S' AND a.qty_on_hand > 0) OR (? = 'B' AND a.qty_on_hand < NVL (a.reorder_level, '0') ) OR ? = 'A' ) AND a.store_code = h.store_code(+) AND a.item_code = h.item_code(+) AND d.user_id LIKE DECODE (i.restrict_view_stk_status, 'ALL', '%', ? ) AND a.store_code = d.store_code AND j.item_code = a.item_code AND (   expiry_yn = 'N'    OR (    expiry_yn = 'Y' AND (   (    /* use_after_expiry_yn = 'Y' AND */ ('Y' = 'Y') ) OR decode(a.qty_on_hand,0,sysdate,expiry_date_or_receipt_date) >= TRUNC (NVL (TO_DATE ('', 'dd/mm/yyyy'), SYSDATE ) ) )))) GROUP BY item_code, store_code, store_desc, stock_item_yn, bin_location_code, bin_desc, reorder_level, item_value, stock_uom_desc ,facility_id ,facility_name ORDER BY store_desc, qty_on_hand, item_value");

		//Added by Sakti against TTM-SCF-0106 to get (base uom unit_cost*qty)item_value_new
		//sqlMap.put("sqlData", "SELECT   item_code, store_code, store_desc, SUM (NVL (qty_on_hand, 0)) qty_on_hand, stock_item_yn, bin_location_code, bin_desc, DECODE (TRIM (TO_CHAR (NVL (reorder_level, '0'), '999,999,999,999,999,999,999' ) ), '0', '', TRIM (TO_CHAR (NVL (reorder_level, '0'), '999,999,999,999,999,999,999' ))) reorder_level, item_value,sum(item_value_new) item_value_new, SUM (  NVL (qty_on_hand, 0)  - NVL (committed_qty, 0)),DECODE (?,'Y', SUM (NVL (qty_on_hand, 0) - NVL (committed_qty, 0)), SUM (DECODE (suspended_yn, 'N', qty_on_hand, 0)) - SUM (DECODE (suspended_yn, 'N', committed_qty, 0))) available_qty, stock_uom_desc,facility_id ,facility_name FROM (SELECT distinct h.batch_id, a.item_code item_code, a.store_code store_code, b.short_desc store_desc, h.qty_on_hand, a.stock_item_yn stock_item_yn, a.bin_location_code, c.short_desc bin_desc, a.reorder_level, a.item_value,(h.qty_on_hand*ST_DISPLAY_UNIT_COST(a.item_code))item_value_new, h.committed_qty, g.short_desc stock_uom_desc,h.expiry_date_or_receipt_date ,h.SUSPENDED_YN,b.facility_id facility_id,(SELECT facility_name FROM sm_facility_param_lang_vw vw  WHERE vw.facility_id = b.facility_id AND language_id = ?) facility_name FROM st_item_store a, mm_store_lang_vw b, mm_bin_location_lang_vw c, st_user_access_for_store d, st_store e, mm_item_lang_vw f, am_uom g, st_item_batch h, st_acc_entity_param i, st_item j WHERE a.store_code = b.store_code AND a.store_code = c.store_code(+) AND a.bin_location_code = c.bin_location_code(+) AND a.item_code = ? AND b.store_code = e.store_code AND e.store_type_flag != 'N' AND c.language_id(+) = ? AND b.language_id = ? AND b.language_id = f.language_id AND a.item_code = f.item_code AND a.def_issue_uom = g.uom_code AND b.facility_id LIKE ? AND e.store_code BETWEEN NVL (UPPER (?), '!') AND NVL (UPPER (?), '~') AND (   (? = 'Z' AND a.qty_on_hand = 0) OR (? = 'S' AND a.qty_on_hand > 0) OR (? = 'B' AND a.qty_on_hand < NVL (a.reorder_level, '0') ) OR ? = 'A' ) AND a.store_code = h.store_code(+) AND a.item_code = h.item_code(+) AND d.user_id LIKE DECODE (i.restrict_view_stk_status, 'ALL', '%', ? ) AND a.store_code = d.store_code AND j.item_code = a.item_code AND (   expiry_yn = 'N'    OR (    expiry_yn = 'Y' AND (   (    /* use_after_expiry_yn = 'Y' AND */ ('Y' = 'Y') ) OR decode(a.qty_on_hand,0,sysdate,expiry_date_or_receipt_date) >= TRUNC (NVL (TO_DATE ('', 'dd/mm/yyyy'), SYSDATE ) ) )))) GROUP BY item_code, store_code, store_desc, stock_item_yn, bin_location_code, bin_desc, reorder_level, item_value, stock_uom_desc ,facility_id ,facility_name ORDER BY store_desc, qty_on_hand, item_value");
		//Modified by suresh.r on 12-11-2014 against Inc 52256
		//sqlMap.put("sqlData", "SELECT   item_code, store_code, store_desc, SUM (NVL (qty_on_hand, 0)) qty_on_hand, stock_item_yn, bin_location_code, bin_desc, DECODE (TRIM (TO_CHAR (NVL (reorder_level, '0'), '999,999,999,999,999,999,999' ) ), '0', '', TRIM (TO_CHAR (NVL (reorder_level, '0'), '999,999,999,999,999,999,999' ))) reorder_level, item_value,sum(item_value_new) item_value_new, SUM (  NVL (qty_on_hand, 0)  - NVL (committed_qty, 0)),DECODE (?,'Y', SUM (NVL (qty_on_hand, 0) - NVL (committed_qty, 0)), SUM (DECODE (suspended_yn, 'N', qty_on_hand, 0)) - SUM (DECODE (suspended_yn, 'N', committed_qty, 0))) available_qty, stock_uom_desc,facility_id ,facility_name FROM (SELECT distinct h.batch_id, a.item_code item_code, a.store_code store_code, b.short_desc store_desc, h.qty_on_hand, a.stock_item_yn stock_item_yn, a.bin_location_code, c.short_desc bin_desc, a.reorder_level, a.item_value,(h.qty_on_hand*ST_DISPLAY_UNIT_COST(a.item_code,sysdate,'CURRENT_STOCK'))item_value_new, h.committed_qty, g.short_desc stock_uom_desc,h.expiry_date_or_receipt_date ,h.SUSPENDED_YN,b.facility_id facility_id,(SELECT facility_name FROM sm_facility_param_lang_vw vw  WHERE vw.facility_id = b.facility_id AND language_id = ?) facility_name FROM st_item_store a, mm_store_lang_vw b, mm_bin_location_lang_vw c, st_user_access_for_store d, st_store e, mm_item_lang_vw f, am_uom g, st_item_batch h, st_acc_entity_param i, st_item j WHERE a.store_code = b.store_code AND a.store_code = c.store_code(+) AND a.bin_location_code = c.bin_location_code(+) AND a.item_code = ? AND b.store_code = e.store_code AND e.store_type_flag != 'N' AND c.language_id(+) = ? AND b.language_id = ? AND b.language_id = f.language_id AND a.item_code = f.item_code AND a.def_issue_uom = g.uom_code AND b.facility_id LIKE ? AND e.store_code BETWEEN NVL (UPPER (?), '!') AND NVL (UPPER (?), '~') AND (   (? = 'Z' AND a.qty_on_hand = 0) OR (? = 'S' AND a.qty_on_hand > 0) OR (? = 'B' AND a.qty_on_hand < NVL (a.reorder_level, '0') ) OR ? = 'A' ) AND a.store_code = h.store_code(+) AND a.item_code = h.item_code(+) AND d.user_id LIKE DECODE (i.restrict_view_stk_status, 'ALL', '%', ? ) AND a.store_code = d.store_code AND j.item_code = a.item_code AND (   expiry_yn = 'N'    OR (    expiry_yn = 'Y' AND (   (    /* use_after_expiry_yn = 'Y' AND */ ('Y' = 'Y') ) OR decode(a.qty_on_hand,0,sysdate,expiry_date_or_receipt_date) >= TRUNC (NVL (TO_DATE ('', 'dd/mm/yyyy'), SYSDATE ) ) )))) GROUP BY item_code, store_code, store_desc, stock_item_yn, bin_location_code, bin_desc, reorder_level, item_value, stock_uom_desc ,facility_id ,facility_name ORDER BY store_desc, qty_on_hand, item_value");
		//Modified by suresh.r on 04-05-2015 against Inc 53228
		sqlMap.put("sqlData", eST.Common.StRepository.getStKeyValue("SQL_ST_STOCK_STATUS_BY_ITEM_QUERY"));

System.err.println("==MOHE-ICN-0015-==="+eST.Common.StRepository.getStKeyValue("SQL_ST_STOCK_STATUS_BY_ITEM_QUERY"));
		
		displayFields.add("STORE_DESC");	
		displayFields.add("QTY_ON_HAND");	
		displayFields.add("ITEM_VALUE");
		displayFields.add("STOCK_ITEM_YN");
		displayFields.add("BIN_DESC");
		displayFields.add("REORDER_LEVEL");
		displayFields.add("STORE_CODE");
		displayFields.add("STOCK_UOM_DESC");
		displayFields.add("AVAILABLE_QTY");
		displayFields.add("FACILITY_NAME"); //Added by Rabbani #INC no : 39203  on 18-04-2013
		displayFields.add("ITEM_VALUE_NEW");
    
	    chkFields.add(includeSuspendedBatches); //Added by Rabbani #30069(BRU-HIMS-CRF-110) on 23-APR-2013
		chkFields.add(locale);                  //Added by Rabbani #INC no : 39203  on 18-04-2013
		chkFields.add(item_code);
		chkFields.add(locale);
		chkFields.add(locale);
		//chkFields.add(bean.getLoginFacilityId());
		chkFields.add(dflt_facility_id); //Added by Rabbani #INC no : 39203  on 18-04-2013
		chkFields.add(store_code_from);
		chkFields.add(store_code_to);
		chkFields.add(stock_level);
		chkFields.add(stock_level);
		chkFields.add(stock_level);
		chkFields.add(stock_level);
		//chkFields.add(bean.getLoginById());
		// MOHE-ICN-0015
System.err.println("==RESTRICT_VIEW_STK_STATUS -  MOHE-ICN-0015"+restrict_view_stk_status);
		if(restrict_view_stk_status!=null && restrict_view_stk_status.equals("ALL")) 
			chkFields.add("");  // pass "" as it wil check for NVL to take user id ....restrict access
		else 
		    chkFields.add(bean.getLoginById());  // restrict access - MOHE-ICN-0015
		
		funcMap.put("displayFields", displayFields);
		funcMap.put("chkFields", chkFields);
		//System.out.println("chkFields=>"+ chkFields);

		ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
	 

		if((result.size()>=3) && (!(((String) result.get(0)).equals("0"))))
		{
		%>
		<table cellpadding=0 cellspacing=0 width="100%" align="center">
		<tr>
		<td width="80%" class="white">&nbsp;</td>
		
		<td width="20%" class="white">&nbsp;<%=result.get(1)%></td>
		</tr>
		</table>
		<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center" id='tb1'>
		<th width=100 align="center" ><fmt:message key="Common.Store.label" bundle="${common_labels}"/></th>
		<th width=100 align="center" ><fmt:message key="eST.QuantityOnHand.label" bundle="${st_labels}"/></th>
		 <th width=100 align="center" ><fmt:message key="eST.AvailableQty.label" bundle="${st_labels}"/></th> 
		<!-- <th width=100 align="center" ><fmt:message key="Common.StockUOM.label" bundle="${common_labels}"/></th> -->
		<%if(((String)bean.getAccessCostDetails()).equals("Y")){%>
		<th   width=100><fmt:message key="eST.CostValue.label" bundle="${st_labels}"/></th>
		<%}%>
		<th width=80 align="center" ><fmt:message key="eST.StockItem.label" bundle="${st_labels}"/></th>
		<th width=130 align="center" ><fmt:message key="eST.MasterBinLocation.label" bundle="${st_labels}"/></th>
		<th width=100 align="center" ><fmt:message key="eST.ROLevel.label" bundle="${st_labels}"/></th>
	</tr>
	<%		
		ArrayList records			=		new ArrayList();

		for(int recCount=2,k = 0; recCount<result.size(); recCount++,k++) {
		String className			=		(recCount % 2 == 0)?"QRYEVEN":"QRYODD";
		records						=		(ArrayList) result.get(recCount);
		 
		%>
		<tr>
		<%
		store_desc					=		CommonBean.checkForNull((String)records.get(0),"&nbsp;");
		//Added by Rabbani #INC no : 39203  on 18-APR-2013
		facility_name				=		CommonBean.checkForNull((String)records.get(9),"");  
		qty_on_hand					=		bean.setNumberFormat(bean.checkForNull((String)records.get(1),"0"),no_of_decimals);
		/**
		 * @Name - Priya
		 * @Date - 07/06/2010
		 * @Inc# - 
		 * @Desc -  To get no of decimals for cost 
		 */
		int noOfDecimalsForCost=Integer.parseInt(CommonBean.checkForNull(bean.getNoOfDecimalsCost(),"3"));
		item_value					=		bean.setNumberFormat((String)CommonBean.checkForNull((String)records.get(2),"0"),noOfDecimalsForCost);
		item_value_new					=		bean.setNumberFormat((String)CommonBean.checkForNull((String)records.get(10),"0"),noOfDecimalsForCost);
		//System.out.println("noOfDecimalsForCost"+ noOfDecimalsForCost);
		//System.out.println("no_of_decimals"+ no_of_decimals);
		
		/*if (item_value.indexOf(".") != -1)
			{
		item_value					=		item_value + "0";

		item_value					=		item_value.substring(0,item_value.indexOf(".")+3);
			}*/
		
		stock_yn					=		CommonBean.checkForNull((String)records.get(3),"&nbsp;");
		bin_desc					=		CommonBean.checkForNull((String)records.get(4),"&nbsp;");
		reorder_level				=		CommonBean.checkForNull((String)records.get(5),"&nbsp;");
		store_code					=		CommonBean.checkForNull((String)records.get(6),"&nbsp;");
		aval_qty					=		bean.setNumberFormat(bean.checkForNull((String)records.get(8),"0"),no_of_decimals); 	
		//System.out.println("aval_qty"+ aval_qty);
		%>
		 <!--
		* @Name - Priya
		* @Date - 01/02/2010
		* @Inc# - 15496 (SRR20056-CRF-0537.2)
		* @Desc - Modified by priya as if the value of 'Quantity on Hand' & 'Available Quantity' is equal to zero and no_of_decimals is 4 then it should be displayed as 0 only & not as '0.000' & so used the common method
		-->
		<tr>
		<td  class="<%=className%>" align=left width=100><font size=1><A HREF="#" onClick="callBatchSearchScreen ('<%=store_code%>','<%=includeSuspendedBatches%>');" title = '<%=facility_name%>' ><%=store_desc%></A></font></td>
					<!-- 					
						* @Name - Priya
						* @Date - 19/02/2010
						* @Inc# - IN019466
						* @Desc - To right align Quantity On Hand, Available Qty, Cost Value, RO Level.				
					-->
		<td  class="<%=className%>" style="TEXT-ALIGN:right"><font size=1>
		<%=qty_on_hand%></font>&nbsp;</td>
		<td  class="<%=className%>"  style="TEXT-ALIGN:right"><font size=1><%=aval_qty%></font>&nbsp;</td>
		<!-- <td  class="<%=className%>" align=right width=100><font size=1><%=(String)records.get(7)%></font></td>
	 -->	<%if((bean.checkForNull((String)bean.getAccessCostDetails(),"N")).equals("Y")){%>
		<!--<td  class="<%=className%>"  style="TEXT-ALIGN:right"><font size=1><%=item_value%></font>&nbsp;</td>-->
		<td  class="<%=className%>"  style="TEXT-ALIGN:right"><font size=1><%=item_value_new%></font>&nbsp;</td>
		<%}%>
		<td  class="<%=className%>"  >
		<%
		if(stock_yn.equals("Y")) {
		%>
		<image src='../../eCommon/images/enabled.gif'>
		<%
			}
		else {
		%>
		<image src='../../eCommon/images/disabled.gif'>
		<%
		}
		%>
		</td>
		
		<td  class="<%=className%>" align=left width=150><font size=1><%=bin_desc%></font></td>
		<td  class="<%=className%>"  style="TEXT-ALIGN:right"><font size=1><%=reorder_level%></font>&nbsp;</td>
		</tr>
		<%
		}
		%>
		</table>
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
		out.flush();
		out.println(CommonBean.setForm(request,"../../eST/jsp/StockStatusByItemQueryResult.jsp",searched));
		}
		catch(Exception e) {
			e.printStackTrace();
		//out.print("Exception @ Result JSP :"+e.toString());
		}
	%>
</body>
</html>

