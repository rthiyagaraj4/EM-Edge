<!DOCTYPE html>
<!-- Tuesday, June 28, 2004 -->
<%@ page import ="eST.StockStatusByItemBean, eST.Common.* , eCommon.Common.*,java.util.HashMap,java.util.ArrayList" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>

<html>
	<head>
		<title></title>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			=		(String)session.getAttribute("LOCALE");
		String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eST/js/StCommon.js"></script>
	<script language="Javascript" src="../../eST/js/StockStatusByItem.js">
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body>

<%
	String item_code			=			request.getParameter( "item_code" )==null?"":request.getParameter( "item_code" );
	String store_code_from			=			request.getParameter( "store_code_from" )==null?"":request.getParameter( "store_code_from" );
	String store_code_to			=			request.getParameter( "store_code_to" )==null?"":request.getParameter( "store_code_to" );
	String bean_id				=			"StockStatusByItemBean";
	String bean_name			=			"eST.StockStatusByItemBean";
	StockStatusByItemBean bean =			(StockStatusByItemBean) getBeanObject( bean_id, bean_name,request );
	bean.setLanguageId(locale);
	boolean searched			=			(request.getParameter("searched") == null) ?false:true;
	//Added by Rabbani #Inc no :39203 on  18/04/2013
	String dflt_facility_id			=			request.getParameter( "dflt_facility_id" )==null?"":request.getParameter( "dflt_facility_id" );
	
	 
	try{
		HashMap sqlMap			=			new HashMap();
		HashMap funcMap			=			new HashMap();
		ArrayList displayFields =			new ArrayList();
		ArrayList chkFields		=			new ArrayList();
		 /** @Name - Priya
		* @Date - 01/02/2010
		* @Inc# - 15496 (SRR20056-CRF-0537.2)
		* @Desc - To use common method, the previous coding has been removed & to get the values based on no_of_decimals 	st_display_decimals function is used in the query
		*/
		//sqlMap.put("sqlData", "SELECT   MOVE_MONTH, MOVE_YEAR, DECODE (TRIM (TO_CHAR (   -1 * (SUM (NVL (CONS_QTY, 0) + NVL (SAL_QTY, 0) + NVL (SRT_QTY, 0))),'999,999,999,999,999,999,999')),'.00', '0',TRIM (TO_CHAR (   -1* (SUM (NVL (CONS_QTY, 0) + NVL (SAL_QTY, 0) + NVL (SRT_QTY, 0))),'999,999,999,999,999,999,999'))) CONSUMPTION_QTY,DECODE (TRIM (TO_CHAR (  -1* (SUM (NVL (CONS_COST, 0) + NVL (SAL_COST, 0) + NVL (SRT_COST, 0))),'999,999,999,999,999,999,999.99')),'.00', '0.00',TRIM (TO_CHAR (  -1* (SUM (NVL (CONS_COST, 0) + NVL (SAL_COST, 0) + NVL (SRT_COST, 0))),'999,999,999,999,999,999,999.99')))CONSUMPTION_COST FROM ST_ITEM_MOVE_SUMM   WHERE ITEM_CODE = ? AND FACILITY_ID = ? AND   STORE_CODE BETWEEN NVL(UPPER(?),'!') AND NVL(UPPER(?),'~')  GROUP BY MOVE_YEAR, MOVE_MONTH HAVING (SUM (NVL (CONS_QTY, 0) + NVL (SAL_QTY, 0) + NVL (SRT_QTY, 0))) != 0 OR (SUM (NVL (CONS_COST, 0) + NVL (SAL_COST, 0) + NVL (SRT_COST, 0))) !=0 ORDER BY MOVE_YEAR || '/' || MOVE_MONTH DESC ");
		/** @Name - Priya
		* @Date - 22/04/2010
		* @Desc - To include the param 'N' for the function ST_DISPLAY_DECIMALS
		*/
		//sqlMap.put("sqlData", "SELECT   move_month, move_year,  ST_DISPLAY_DECIMALS((-1 * (SUM (  NVL (cons_qty, 0) + NVL (sal_qty, 0) + NVL (srt_qty, 0) ) )),'N') consumption_qty, DECODE (TRIM (TO_CHAR (  -1 * (SUM (  NVL (cons_cost, 0) + NVL (sal_cost, 0) + NVL (srt_cost, 0) ) ), '999,999,999,999,999,999,999.99' ) ), '.00', '0.00', TRIM (TO_CHAR (  -1 * (SUM (  NVL (cons_cost, 0) + NVL (sal_cost, 0) + NVL (srt_cost, 0) ) ), '999,999,999,999,999,999,999.99' ) ) ) consumption_cost FROM (SELECT distinct a.move_month move_month, a.move_year move_year, a.cons_qty cons_qty, a.sal_qty sal_qty, a.srt_qty srt_qty, a.cons_cost cons_cost, a.sal_cost sal_cost, a.srt_cost srt_cost from st_item_move_summ a, st_acc_entity_param b, st_user_access_for_store c WHERE a.item_code = ? AND a.facility_id = ? AND a.store_code BETWEEN NVL (UPPER (?), '!') AND NVL (UPPER (?), '~') AND c.user_id LIKE DECODE (b.restrict_view_stk_status, 'ALL', '%', ? ) AND a.store_code = c.store_code) GROUP BY move_year, move_month   HAVING (SUM (NVL (cons_qty, 0) + NVL (sal_qty, 0) + NVL (srt_qty, 0))) != 0 OR (SUM (NVL (cons_cost, 0) + NVL (sal_cost, 0) + NVL (srt_cost, 0))) != 0 ORDER BY move_year || '/' || move_month DESC ");	
		/**
		 * @Name - Priya
		 * @Date - 07/06/2010
		 * @Inc# - 
		 * @Desc -  To get consumption_cost with out ',' format the above query is modified 
		 */
		//sqlMap.put("sqlData", "SELECT   move_month, move_year,  ST_DISPLAY_DECIMALS((-1 * (SUM (  NVL (cons_qty, 0) + NVL (sal_qty, 0) + NVL (srt_qty, 0) ) )),'N') consumption_qty, DECODE ((  -1 * (SUM (  NVL (cons_cost, 0) + NVL (sal_cost, 0) + NVL (srt_cost, 0) ) )), '.00', '0.00', (  -1 * (SUM (  NVL (cons_cost, 0) + NVL (sal_cost, 0) + NVL (srt_cost, 0) ) ) ) ) consumption_cost FROM (SELECT distinct a.move_month move_month, a.move_year move_year, a.cons_qty cons_qty, a.sal_qty sal_qty, a.srt_qty srt_qty, a.cons_cost cons_cost, a.sal_cost sal_cost, a.srt_cost srt_cost from st_item_move_summ a, st_acc_entity_param b, st_user_access_for_store c WHERE a.item_code = ? AND a.facility_id = ? AND a.store_code BETWEEN NVL (UPPER (?), '!') AND NVL (UPPER (?), '~') AND c.user_id LIKE DECODE (b.restrict_view_stk_status, 'ALL', '%', ? ) AND a.store_code = c.store_code) GROUP BY move_year, move_month   HAVING (SUM (NVL (cons_qty, 0) + NVL (sal_qty, 0) + NVL (srt_qty, 0))) != 0 OR (SUM (NVL (cons_cost, 0) + NVL (sal_cost, 0) + NVL (srt_cost, 0))) != 0 ORDER BY move_year || '/' || move_month DESC ");
		
		//Added by Rabbani #Inc no :39203 on  18/04/2013
		//sqlMap.put("sqlData", "SELECT   move_month, move_year,  ST_DISPLAY_DECIMALS((-1 * (SUM (  NVL (cons_qty, 0) + NVL (sal_qty, 0) + NVL (srt_qty, 0) ) )),'N') consumption_qty, DECODE ((  -1 * (SUM (  NVL (cons_cost, 0) + NVL (sal_cost, 0) + NVL (srt_cost, 0) ) )), '.00', '0.00', (  -1 * (SUM (  NVL (cons_cost, 0) + NVL (sal_cost, 0) + NVL (srt_cost, 0) ) ) ) ) consumption_cost FROM (SELECT distinct a.move_month move_month, a.move_year move_year, a.cons_qty cons_qty, a.sal_qty sal_qty, a.srt_qty srt_qty, a.cons_cost cons_cost, a.sal_cost sal_cost, a.srt_cost srt_cost from st_item_move_summ a, st_acc_entity_param b, st_user_access_for_store c WHERE a.item_code = ? AND a.facility_id LIKE ? AND a.store_code BETWEEN NVL (UPPER (?), '!') AND NVL (UPPER (?), '~') AND c.user_id LIKE DECODE (b.restrict_view_stk_status, 'ALL', '%', ? ) AND a.store_code = c.store_code) GROUP BY move_year, move_month   HAVING (SUM (NVL (cons_qty, 0) + NVL (sal_qty, 0) + NVL (srt_qty, 0))) != 0 OR (SUM (NVL (cons_cost, 0) + NVL (sal_cost, 0) + NVL (srt_cost, 0))) != 0 ORDER BY move_year || '/' || move_month DESC ");

		
		//Modified by suresh.r on 24-11-2014 against Inc 52256
		//sqlMap.put("sqlData", "SELECT   move_month, move_year,  ST_DISPLAY_DECIMALS((-1 * (SUM (  NVL (cons_qty, 0) + NVL (sal_qty, 0) + NVL (srt_qty, 0) ) )),'N') consumption_qty, /*DECODE ((  -1 * (SUM (  NVL (cons_cost, 0) + NVL (sal_cost, 0) + NVL (srt_cost, 0) ) )), '.00', '0.00', (  -1 * (SUM (  NVL (cons_cost, 0) + NVL (sal_cost, 0) + NVL (srt_cost, 0) ) ) ) ) consumption_cost*/ (st_display_decimals ((  -1 * (SUM (  NVL (cons_qty, 0) + NVL (sal_qty, 0) + NVL (srt_qty, 0)))),'N')*st_display_unit_cost(?,LAST_DAY (TO_DATE (move_month || '/' || move_year, 'mm/yyyy')),'CURRENT_STOCK'))consumption_cost FROM (SELECT distinct a.move_month move_month, a.move_year move_year, a.cons_qty cons_qty, a.sal_qty sal_qty, a.srt_qty srt_qty, a.cons_cost cons_cost, a.sal_cost sal_cost, a.srt_cost srt_cost from st_item_move_summ a, st_acc_entity_param b, st_user_access_for_store c WHERE a.item_code = ? AND a.facility_id LIKE ? AND a.store_code BETWEEN NVL (UPPER (?), '!') AND NVL (UPPER (?), '~') AND c.user_id LIKE DECODE (b.restrict_view_stk_status, 'ALL', '%', ? ) AND a.store_code = c.store_code) GROUP BY move_year, move_month   HAVING (SUM (NVL (cons_qty, 0) + NVL (sal_qty, 0) + NVL (srt_qty, 0))) != 0 OR (SUM (NVL (cons_cost, 0) + NVL (sal_cost, 0) + NVL (srt_cost, 0))) != 0 ORDER BY move_year || '/' || move_month DESC ");
		//Modified by suresh.r on 04-05-2015 against Inc 53214
		sqlMap.put("sqlData", eST.Common.StRepository.getStKeyValue("SQL_ST_STOCK_STATUS_BY_ITEM_CONS_QUERY"));
		
		displayFields.add("move_month");	 		
		displayFields.add("move_year");	
		displayFields.add("consumption_qty");
		displayFields.add("consumption_cost");
		//chkFields.add(CommonBean.checkForNull(item_code,"%"));
		chkFields.add(CommonBean.checkForNull(item_code,"%"));//Added by suresh.r on 24-11-2014 against Inc 52256
		chkFields.add(CommonBean.checkForNull(item_code,"%"));
		//Added by Rabbani #Inc no :39203 on  18/04/2013
		chkFields.add(CommonBean.checkForNull(dflt_facility_id,"%"));
		//chkFields.add(bean.getLoginFacilityId());
		chkFields.add(store_code_from);
		chkFields.add(store_code_to);
		chkFields.add(bean.getLoginById());

		funcMap.put("displayFields", displayFields);
		funcMap.put("chkFields", chkFields);
		ArrayList result		=			(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
		/**
		 * @Name - Priya
		 * @Date - 07/06/2010
		 * @Inc# - 
		 * @Desc -  To get no of decimals for cost 
		 */
		 int noOfDecimalsForCost=Integer.parseInt(bean.getNoOfDecimalsCost());
	%>
	<script>
	var cost_access="<%=bean.getAccessCostDetails()%>";	
	</script>

	<%	if((result.size()>=3)&&(!(((String) result.get(0)).equals("0")))){
		%>
		<table border="0" cellpadding=0 cellspacing=0 width="10%" align="center">
			<tr>
				<td width=100 class="white">&nbsp;</td>
				<td width=100 class="white">&nbsp;<%=result.get(1)%></td>
			</tr>
		</table>
		<table border="1" cellpadding="0" cellspacing="0" width="55%" align="left" id='tb1'>
			<tr>
				<th  align="center" ><fmt:message key="Common.Period.label" bundle="${common_labels}"/></th>
				<th  align="Right" ><fmt:message key="eST.ConsumptionQty.label" bundle="${st_labels}"/></th>
		<%if(((String)bean.getAccessCostDetails()).equals("Y")){%>
				<th align="Right" ><fmt:message key="eST.ConsumptionCost.label" bundle="${st_labels}"/></th>
		<%}%>	
			</tr>
			<%
			     String strYear = "";
				int intCount			=		0;
				ArrayList data = new ArrayList();
				for (int i=2; i<result.size(); i++) {
					++intCount;
				//	String className	=		(i % 2 == 0)?"QRYEVEN":"QRYODD";
					data				=		(ArrayList)result.get(i);
					int  intmonth		=		Integer.parseInt((String)data.get(0));
					String strMonth		=		"";
					if (intmonth <10) {
						strMonth		=		"0"+intmonth;
					}else{
						strMonth		=		""+intmonth;
					}  			
					strYear = com.ehis.util.DateUtils.convertDate((String)data.get(1),"YY","en",locale);
					
					

			%>
					<tr>
						<td  id="period_<%=intCount%>" onClick="displayPending('<%=item_code%>','<%=strMonth%>','<%=strYear%>','<%=(String)data.get(1)%>','<%=intCount%>','<%=store_code_from%>','<%=store_code_to%>');" style="color:blue;cursor:pointer "> <%=strMonth%> / <%=strYear%></td>
						<td  id="qty_<%=intCount%>" align="Right"><%=data.get(2)%></td>
						<%if(((String)bean.getAccessCostDetails()).equals("Y")){%>
						<td  id="cost_<%=intCount%>" align="Right"><%=bean.setNumberFormat((String)data.get(3),noOfDecimalsForCost)%></td>
						<%}%>	
					</tr>
			<%
				}
			%>
		</table>
	<%
			out.flush();
		} 
		else{
		%>
			<script>
				alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
				history.go(-1);
				document.location.href="../../eCommon/html/blank.html";
			</script>
		<%
		}
		out.println(CommonBean.setForm (request ,"../../eST/jsp/StockStatusByItemConsumption.jsp", searched));
	}
	catch(Exception e) {
		out.print("Exception @ Result JSP :"+e.toString());
	}
%>

</body>
</html>

