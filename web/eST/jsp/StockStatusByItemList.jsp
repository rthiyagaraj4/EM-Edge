<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eST.StockStatusByStoreBean,eST.StockStatusByItemBean, java.util.HashMap,webbeans.eCommon.*,java.util.ArrayList,java.text.NumberFormat , java.util.Locale" %>

<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<html>
	<head>
		<%
		request.setCharacterEncoding("UTF-8");
		String locale			=	(String)session.getAttribute("LOCALE");
		String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
		<!-- 	<script language="javascript" src="../../eST/js/StockStatusByStoreDetailBean.js"></script>-->
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<title><fmt:message key="eST.StorewiseConsumption.label" bundle="${st_labels}"/></title>
	</head>
	
	<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" > 
	<form name="StockStatusByItemList" id="StockStatusByItemList">
	<%

		boolean searched			=		(request.getParameter("searched") == null) ?false:true;
		String item_code			=		request.getParameter("item_code")==null?"":request.getParameter( "item_code" );
		String move_year			=		request.getParameter("move_year")==null?"":request.getParameter( "move_year" );
		String move_month			=		request.getParameter("move_month")==null?"":request.getParameter( "move_month" );
		String store_code_from			=			request.getParameter( "store_code_from" )==null?"":request.getParameter( "store_code_from" );
		String store_code_to			=			request.getParameter( "store_code_to" )==null?"":request.getParameter( "store_code_to" );
		String strCostAccess			=			request.getParameter( "cost_access" )==null?"":request.getParameter( "cost_access" );
		String bean_id				=			"StockStatusByItemBean";
	String bean_name			=			"eST.StockStatusByItemBean";
	StockStatusByItemBean bean =			(StockStatusByItemBean) getBeanObject( bean_id, bean_name,request );
	bean.setLanguageId(locale);
	//	String ACC_ENTITY_ID				=		(String)session.getAttribute("ACC_ENTITY_ID");
		
	
		String user_name			=		(String) session.getValue( "login_user" ) ;
	try{
		HashMap sqlMap				=		new HashMap();
		HashMap funcMap				=		new HashMap();
		ArrayList displayFields		=		new ArrayList();
		ArrayList chkFields			=		new ArrayList();
		/**
		 * @Name - Priya
		 * @Date - 07/06/2010
		 * @Inc# - 
		 * @Desc -  To get no of decimals for cost 
		 */
		 int noOfDecimalsForCost=Integer.parseInt(bean.getNoOfDecimalsCost());

		/** @Name - Priya
		* @Date - 01/02/2010
		* @Inc# - 15496 (SRR20056-CRF-0537.2)
		* @Desc - To use common method, the previous coding has been removed & to get the values based on no_of_decimals 	st_display_decimals function is used in the query
		*/
		//sqlMap.put("sqlData","SELECT   B.SHORT_DESC STORE,DECODE (TRIM (TO_CHAR ( -1 * (SUM (NVL (A.CONS_QTY, 0))),'999,999,999,999,999,999,999')),'.00', '0',TRIM (TO_CHAR ( -1 * (SUM (NVL (A.CONS_QTY, 0))),'999,999,999,999,999,999,999')))  ISSUE,DECODE (TRIM (TO_CHAR (-1 * (SUM (NVL (A.CONS_COST, 0))),'999,999,999,999,999,999,999.99')),'.00', '0.00',TRIM (TO_CHAR (-1 * (SUM (NVL (A.CONS_COST, 0))),'999,999,999,999,999,999,999.99'))) ISSUE_COST,DECODE (TRIM (TO_CHAR ( -1 * (SUM (NVL (A.SAL_QTY, 0) + NVL (A.SRT_QTY, 0))),'999,999,999,999,999,999,999')),'.00', '0',TRIM (TO_CHAR ( -1 * (SUM (NVL (A.SAL_QTY, 0) + NVL (A.SRT_QTY, 0))),'999,999,999,999,999,999,999'))) SALESPATIENT,DECODE (TRIM (TO_CHAR (-1 * (SUM (NVL (A.SAL_COST, 0) + NVL (A.SRT_COST, 0))),'999,999,999,999,999,999,999.99')),'.00', '0.00',TRIM (TO_CHAR (-1 * (SUM (NVL (A.SAL_COST, 0) + NVL (A.SRT_COST, 0))),'999,999,999,999,999,999,999.99')))  SALESPATIENT_VALUE FROM ST_ITEM_MOVE_SUMM A, MM_STORE_LANG_VW B   WHERE A.STORE_CODE = B.STORE_CODE AND A.ITEM_CODE = ? AND A.MOVE_YEAR = ? AND A.MOVE_MONTH = ? AND B.LANGUAGE_ID = ? AND A.FACILITY_ID = ? AND A.STORE_CODE BETWEEN NVL(UPPER(?),'!') AND NVL(UPPER(?),'~') GROUP BY B.SHORT_DESC HAVING -1 * (SUM (NVL (A.CONS_QTY, 0))) != 0 OR -1 * (SUM (NVL (A.CONS_COST, 0))) != 0 OR -1 * (SUM (NVL (A.SAL_QTY, 0) + NVL (A.SRT_QTY, 0))) != 0 OR -1 * (SUM (NVL (A.SAL_COST, 0) + NVL (A.SRT_COST, 0))) != 0 ");

		/** @Name - Priya
		* @Date - 22/04/2010
		* @Desc - To include the param 'N' for the function ST_DISPLAY_DECIMALS
		*/
		//sqlMap.put("sqlData","SELECT STORE, ST_DISPLAY_DECIMALS((-1 * (SUM (NVL (cons_qty, 0)))),'N') issue, DECODE (TRIM (TO_CHAR (-1 * (SUM (NVL (cons_cost, 0))), '999,999,999,999,999,999,999.99' ) ), '.00', '0.00', TRIM (TO_CHAR (-1 * (SUM (NVL (cons_cost, 0))), '999,999,999,999,999,999,999.99' ) ) ) issue_cost, ST_DISPLAY_DECIMALS((  -1 * (SUM (NVL (sal_qty, 0) + NVL (srt_qty, 0)) )),'N') salespatient, DECODE (TRIM (TO_CHAR (  -1 * (SUM (NVL (sal_cost, 0) + NVL (srt_cost, 0)) ), '999,999,999,999,999,999,999.99' ) ), '.00', '0.00', TRIM (TO_CHAR (  -1 * (SUM (NVL (sal_cost, 0) + NVL (srt_cost, 0)) ), '999,999,999,999,999,999,999.99' ) ) ) salespatient_value     FROM ( select distinct b.short_desc STORE,a.cons_qty cons_qty, a.sal_qty sal_qty, a.srt_qty srt_qty, a.cons_cost cons_cost, a.sal_cost sal_cost, a.srt_cost srt_cost from st_item_move_summ a, mm_store_lang_vw b,st_acc_entity_param c, st_user_access_for_store d    WHERE a.store_code = b.store_code AND a.item_code = ? AND a.move_year = ? AND a.move_month = ? AND b.language_id = ? AND a.facility_id = ? AND a.store_code BETWEEN NVL (UPPER (?), '!') AND NVL (UPPER (?), '~') AND d.user_id LIKE DECODE (c.restrict_view_stk_status, 'ALL', '%', ? ) AND a.store_code = d.store_code) GROUP BY STORE   HAVING -1 * (SUM (NVL (cons_qty, 0))) != 0 OR -1 * (SUM (NVL (cons_cost, 0))) != 0 OR -1 * (SUM (NVL (sal_qty, 0) + NVL (srt_qty, 0))) != 0       OR -1 * (SUM (NVL (sal_cost, 0) + NVL (srt_cost, 0))) != 0");
		/**
		 * @Name - Priya
		 * @Date - 07/06/2010
		 * @Inc# - 
		 * @Desc -  To get consumption_cost with out ',' format the above query is modified 
		 */
		//sqlMap.put("sqlData","SELECT STORE, ST_DISPLAY_DECIMALS((-1 * (SUM (NVL (cons_qty, 0)))),'N') issue, DECODE ((-1 * (SUM (NVL (cons_cost, 0)))), '.00', '0.00', (-1 * (SUM (NVL (cons_cost, 0))) ) ) issue_cost, ST_DISPLAY_DECIMALS((  -1 * (SUM (NVL (sal_qty, 0) + NVL (srt_qty, 0)) )),'N') salespatient, DECODE ((  -1 * (SUM (NVL (sal_cost, 0) + NVL (srt_cost, 0)) ) ), '.00', '0.00',(  -1 * (SUM (NVL (sal_cost, 0) + NVL (srt_cost, 0)) ) ) ) salespatient_value     FROM ( select distinct b.short_desc STORE,a.cons_qty cons_qty, a.sal_qty sal_qty, a.srt_qty srt_qty, a.cons_cost cons_cost, a.sal_cost sal_cost, a.srt_cost srt_cost from st_item_move_summ a, mm_store_lang_vw b,st_acc_entity_param c, st_user_access_for_store d    WHERE a.store_code = b.store_code AND a.item_code = ? AND a.move_year = ? AND a.move_month = ? AND b.language_id = ? AND a.facility_id = ? AND a.store_code BETWEEN NVL (UPPER (?), '!') AND NVL (UPPER (?), '~') AND d.user_id LIKE DECODE (c.restrict_view_stk_status, 'ALL', '%', ? ) AND a.store_code = d.store_code) GROUP BY STORE   HAVING -1 * (SUM (NVL (cons_qty, 0))) != 0 OR -1 * (SUM (NVL (cons_cost, 0))) != 0 OR -1 * (SUM (NVL (sal_qty, 0) + NVL (srt_qty, 0))) != 0       OR -1 * (SUM (NVL (sal_cost, 0) + NVL (srt_cost, 0))) != 0");

		/*
					 * @Name - Sakti
					 * @Date - 24/07/2014
					 * @Inc# -  SKR-SCF-1023 [IN:050330]
					 * @Desc - to calculate cost, quantity*st_display_unit_cost() added
		*/

		//sqlMap.put("sqlData","SELECT STORE, ST_DISPLAY_DECIMALS((-1 * (SUM (NVL (cons_qty, 0)))),'N') issue, /*DECODE ((-1 * (SUM (NVL (cons_cost, 0)))), '.00', '0.00', (-1 * (SUM (NVL (cons_cost, 0))) ) ) issue_cost*/ ( st_display_decimals ((-1 * (SUM (NVL (cons_qty, 0)))), 'N')*st_display_unit_cost(?))issue_cost, ST_DISPLAY_DECIMALS((  -1 * (SUM (NVL (sal_qty, 0) + NVL (srt_qty, 0)) )),'N') salespatient, /*DECODE ((  -1 * (SUM (NVL (sal_cost, 0) + NVL (srt_cost, 0)) ) ), '.00', '0.00',(  -1 * (SUM (NVL (sal_cost, 0) + NVL (srt_cost, 0)) ) ) ) salespatient_value*/ (st_display_decimals ((-1 * (SUM (NVL (sal_qty, 0) + NVL (srt_qty, 0)))), 'N')*st_display_unit_cost(?))salespatient_value     FROM ( select distinct b.short_desc STORE,a.cons_qty cons_qty, a.sal_qty sal_qty, a.srt_qty srt_qty, a.cons_cost cons_cost, a.sal_cost sal_cost, a.srt_cost srt_cost from st_item_move_summ a, mm_store_lang_vw b,st_acc_entity_param c, st_user_access_for_store d    WHERE a.store_code = b.store_code AND a.item_code = ? AND a.move_year = ? AND a.move_month = ? AND b.language_id = ? AND a.facility_id = ? AND a.store_code BETWEEN NVL (UPPER (?), '!') AND NVL (UPPER (?), '~') AND d.user_id LIKE DECODE (c.restrict_view_stk_status, 'ALL', '%', ? ) AND a.store_code = d.store_code) GROUP BY STORE   HAVING -1 * (SUM (NVL (cons_qty, 0))) != 0 OR -1 * (SUM (NVL (cons_cost, 0))) != 0 OR -1 * (SUM (NVL (sal_qty, 0) + NVL (srt_qty, 0))) != 0       OR -1 * (SUM (NVL (sal_cost, 0) + NVL (srt_cost, 0))) != 0");
		//Modified by suresh.r on 24-11-2014 against Inc 52256
		sqlMap.put("sqlData","SELECT STORE, ST_DISPLAY_DECIMALS((-1 * (SUM (NVL (cons_qty, 0)))),'N') issue, /*DECODE ((-1 * (SUM (NVL (cons_cost, 0)))), '.00', '0.00', (-1 * (SUM (NVL (cons_cost, 0))) ) ) issue_cost*/ ( st_display_decimals ((-1 * (SUM (NVL (cons_qty, 0)))), 'N')*st_display_unit_cost(?,LAST_DAY (TO_DATE (move_month || '/' || move_year, 'mm/yyyy')),'CURRENT_STOCK'))issue_cost, ST_DISPLAY_DECIMALS((  -1 * (SUM (NVL (sal_qty, 0) + NVL (srt_qty, 0)) )),'N') salespatient, /*DECODE ((  -1 * (SUM (NVL (sal_cost, 0) + NVL (srt_cost, 0)) ) ), '.00', '0.00',(  -1 * (SUM (NVL (sal_cost, 0) + NVL (srt_cost, 0)) ) ) ) salespatient_value*/ (st_display_decimals ((-1 * (SUM (NVL (sal_qty, 0) + NVL (srt_qty, 0)))), 'N')*st_display_unit_cost(?,LAST_DAY (TO_DATE (move_month || '/' || move_year, 'mm/yyyy')),'CURRENT_STOCK'))salespatient_value     FROM ( select distinct b.short_desc STORE,a.cons_qty cons_qty, a.sal_qty sal_qty, a.srt_qty srt_qty, a.cons_cost cons_cost, a.sal_cost sal_cost, a.srt_cost srt_cost,a.move_month move_month,a.move_year move_year from st_item_move_summ a, mm_store_lang_vw b,st_acc_entity_param c, st_user_access_for_store d    WHERE a.store_code = b.store_code AND a.item_code = ? AND a.move_year = ? AND a.move_month = ? AND b.language_id = ? AND a.facility_id = ? AND a.store_code BETWEEN NVL (UPPER (?), '!') AND NVL (UPPER (?), '~') AND d.user_id LIKE DECODE (c.restrict_view_stk_status, 'ALL', '%', ? ) AND a.store_code = d.store_code) GROUP BY STORE,move_month,move_year   HAVING -1 * (SUM (NVL (cons_qty, 0))) != 0 OR -1 * (SUM (NVL (cons_cost, 0))) != 0 OR -1 * (SUM (NVL (sal_qty, 0) + NVL (srt_qty, 0))) != 0       OR -1 * (SUM (NVL (sal_cost, 0) + NVL (srt_cost, 0))) != 0");

		//Line In repo 914			
		displayFields.add("STORE");	
		displayFields.add("issue");	
		displayFields.add("issue_cost");
		displayFields.add("salespatient");
		displayFields.add("salespatient_value");
	
		//chkFields.add( store_code);
		chkFields.add( item_code);
		chkFields.add( item_code);
		chkFields.add( item_code);
		chkFields.add( move_year);
		chkFields.add( move_month);
		chkFields.add(locale);
		chkFields.add((String)session.getValue("facility_id"));
		chkFields.add(store_code_from);
		chkFields.add(store_code_to);
		chkFields.add(user_name);

		funcMap.put("displayFields", displayFields);
		funcMap.put("chkFields", chkFields);
		ArrayList result			=		(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
	 
		if((result.size()>=3)){
 
		//	{
		%>
			<table CELLPADDING=0 CELLSPACING=0 WIDTH="100%" ALIGN="center">
		
			<tr>
				<td width="80%" class="white">&nbsp;</td>
				<td width="20%" class="white" align="right">&nbsp;<%=result.get(1)%></td>
			</tr>
		
			</table>
			<table border="1" cellpadding="0" cellspacing="0" width="99%" align="center" id='tb1'>
			<tr>
				<th><fmt:message key="Common.Store.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.IssueQuantity.label" bundle="${common_labels}"/></th>
				<%if(strCostAccess.equals("Y")){%>
				<th><fmt:message key="eST.IssuesCost.label" bundle="${st_labels}"/></th>
				<%}%>
				<th><fmt:message key="Common.SaleQuantity.label" bundle="${common_labels}"/></th>
				<%if(strCostAccess.equals("Y")){%>
				<th><fmt:message key="Common.Sale.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Cost.label" bundle="${common_labels}"/></th>
				<%}%>
			</tr>	
				<%
				ArrayList data = new ArrayList();
				for (int i=2; i<result.size(); i++) {
					String className = (i % 2 == 0)?"QRYEVEN":"QRYODD";
					data = (ArrayList)result.get(i);	
	System.err.println("===data"+data	);		
				%>
				<!--
				* @Name - Priya
				* @Date - 01/02/2010
				* @Inc# - 15496 (SRR20056-CRF-0537.2)
				* @Desc - Modified by priya as if the value of 'IssueQuantity' & 'SaleQuantity' is equal to zero and no_of_decimals is 4 then it should be displayed as 0 only & not as '0.000' & so used the common function st_display_decimals has been used in the query
				-->
				<tr>
						<td class="<%=className%>" align="left"><%=(String)data.get(0)%></td>
						<td class="<%=className%>" style="TEXT-ALIGN:right"><%=data.get(1)%></td>
						<%if(strCostAccess.equals("Y")){%>
						<td class="<%=className%>" style="TEXT-ALIGN:right"><%=bean.setNumberFormat((String)data.get(2),noOfDecimalsForCost)%></td>
						<%}%>
						<td class="<%=className%>" style="TEXT-ALIGN:right"><%=data.get(3)%></td>
						<%if(strCostAccess.equals("Y")){%>
						<td class="<%=className%>" style="TEXT-ALIGN:right"><%=bean.setNumberFormat((String)data.get(4),noOfDecimalsForCost)%></td>
						<%}%>
				</tr>
			<%
				}
			%>
			</table>
		
		</form>
		
<%	
	out.flush();
	}
	out.println(CommonBean.setForm (request ,"../../eST/jsp/StockStatusByItemList.jsp", searched));
	}
				catch(Exception e) {
					e.printStackTrace();
				}
%>
			
	</body>
</html>

