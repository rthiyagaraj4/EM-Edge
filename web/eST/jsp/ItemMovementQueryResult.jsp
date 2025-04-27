<!DOCTYPE html>
<%/*
--------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name				Rev.Date   		Rev.By 				Description
--------------------------------------------------------------------------------------------------------------------------------
06/01/2021  TFS id:-11670       B Haribabu          06/01/2021                       ST-Common-Item Movement Query function
-------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="eST.ItemMovementShowItemBean, eST.Common.* , eCommon.Common.*,java.util.ArrayList,java.util.HashMap,webbeans.eCommon.*,java.text.NumberFormat " contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
		<title></title>
<%

		request.setCharacterEncoding("UTF-8");
		String locale			=	(String)session.getAttribute("LOCALE");
		String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eCommon/js/rowcolor.js"></script>
		<script language="Javascript" src="../../eST/js/StCommon.js"></script>
		<script language="Javascript" src="../../eST/js/ItemMovement.js"> </script>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body onScroll="processScroll()">
<form name='ItemMovementResultForm' id='ItemMovementResultForm'  >

<%	
	String bean_id					=		"ItemMovementShowItemBean";
	String bean_name				=		"eST.ItemMovementShowItemBean";
	ArrayList result				=		new ArrayList();
	HashMap showdataList			=		new HashMap();
	HashMap showdataList_s			=		new HashMap();
	ItemMovementShowItemBean bean	=		(ItemMovementShowItemBean) getBeanObject( bean_id,bean_name,request);
	
	bean.setLanguageId(locale);
	bean.clear();
	bean.setQuery_type(request.getParameter("query_type"));
	bean.setResult_criteria(request.getParameter("result_criteria"));
	bean.setStore_code(request.getParameter("store_code"));
	bean.setItem_code(request.getParameter("item_code"));
	bean.setItem_class(request.getParameter("item_class"));
	
	
	String from = request.getParameter("from");
	String to = request.getParameter("to");

	if(locale.equals("th"))
	{
		if(!from.equals("0"))
		{
			from = Integer.toString((Integer.parseInt(from)-54300)) ;
		}
		if(!to.equals("0"))
		{
			to = Integer.toString((Integer.parseInt(to)-54300)) ;
		}

	} 


	
	//bean.setFrom(request.getParameter("from"));
	bean.setFrom(from);
	//bean.setTo(request.getParameter("to"));
	bean.setTo(to);
	result								=		bean.loadData();	
	String store_code					=		(String)bean.getStore_code();
	String item_CC						=		(String)bean.getItem_code();
	String GRN_QTY_COLUMN				=		"";
	String POS_ADJ_COLUMN				=		"";
	String POS_VAR_QTY_COLUMN			=		"";
	String MFG_QTY_COLUMN				=		"";
	String IN_SALE_RET_COLUMN			=		"";
	String IN_PROD_COLUMN				=		"";
	String OUT_RTV_COLUMN				=		"";
	String OUT_ADJ_COLUMN				=		"";
	String OUT_VAR_COLUMN				=		"";
	String OUT_MFG_COLUMN				=		"";
	String OUT_PROD_COLUMN				=		"";
	String OUT_SALE_COLUMN				=		"";
	String OUT_CONS_COLUMN				=		"";
	String TOTAL_TOTAL_INFLOW			=		"";
	String TOTAL_TOTAL_OUTFLOW			=		"";
	String TOTAL_TOTAL_INFLOW_STORE		=		"";
	String TOTAL_TOTAL_OUTFLOW_STORE	=		"";
	String IN_TFR_COLUMN				=		"";
	String IN_INV_ISS_STORE_COLUMN		=		"";
	String IN_INV_RET_STORE_COLUMN		=		"";
	String OUT_INV_ISS_STORE_COLUMN		=		"";
	String OUT_NS_ISS_STORE_COLUMN		=		"";
	String OUT_INV_RET_STORE_COLUMN		=		"";
	String OUT_NS_RET_STORE_COLUMN		=		"";
	String OUT_TFR_COLUMN				=		"";
	String PERIOD				        =		"";
		/** @Name - Priya
		* @Date - 03/02/2010
		* @Inc# - 15496 (SRR20056-CRF-0537.2)
		* @Desc - To use common method, the previous coding has been removed & to get the values based on no_of_decimals 	st_display_decimals_format function is used in the query (ItemMovementShowItemBean --> loadData())
		*/
	/*String fmt = "";
	String ACC_ENTITY_ID				=		(String)session.getAttribute("ACC_ENTITY_ID");
	String no_of_decimals				=		"";

				/* @Name - Rams
			 * @Date - 1/12/2010
			 * @Inc# - 18097
			 * @Desc - For the Decimal related display  In the Existing Scenerio if the Value is 0 then Query is returning .0000 or .000 basing on No of Decimals fmt is used to add 0 prior to the .0000 Query Must be changed in the Bean
			 It is Temporary Change Only 
			 */
	/*HashMap hmRecord = bean.fetchRecord("SELECT  NVL( NO_OF_DECIMALS,'0') NO_OF_DECIMALS FROM st_acc_entity_param WHERE  ACC_ENTITY_ID=?",ACC_ENTITY_ID);
	no_of_decimals				=		CommonBean.checkForNull((String)hmRecord.get("NO_OF_DECIMALS"),"0");
	for(int i=0;i<Integer.parseInt(no_of_decimals);i++){
		if(i==0)
		fmt+=".";
		fmt+="0";
		}	*/
	
	if(result.size() >0)
	{
	if(store_code.equals(""))
	{
	%>
	<div id="divHeadSep" style="position: absolute;">
	<table cellpadding=0 cellspacing=0 width="200%" align=center>
	<tr >
	<table border="1" cellpadding="0" cellspacing="0" width="200%"  id='tb1'>
	<tr  id="heading">
		<th colspan=2>&nbsp;</th>
		<th COLSPAN='7'  class='CAGROUP_HEADING'><font size=1><b><-------------------------------------------------------------------- <fmt:message key="eST.StockInflow.label" bundle="${st_labels}"/>------------------------------------------------------------></b></font></th>
		<th COLSPAN='7'  class='CAGROUP_HEADING'><font size=1><b>--------------------------------------------<fmt:message key="eST.StockOutflow.label" bundle="${st_labels}"/>------------------------------------------------------------------</b></font></th>
		<th colspan=2>&nbsp;</th>
	<tr>
	<tr  id="heading1">
		<th  class='CAGROUP_HEADING'><font size=1><b><fmt:message key="eST.AccountingPeriod.label" bundle="${st_labels}"/></font></th>
		<th  nowrap class='CAGROUP_HEADING'><font size=1><b><fmt:message key="Common.OpeningBalance.label" bundle="${common_labels}"/></b></font></th>
		<th nowrap class='CAGROUP_HEADING'><font size=1><b><fmt:message key="eST.GRN.label" bundle="${st_labels}"/></b></font></th>
		<th nowrap class='CAGROUP_HEADING'><font size=1><b><fmt:message key="eMM.Adjustment.label" bundle="${mm_labels}"/></b></font></th>
		<th nowrap class='CAGROUP_HEADING'><font size=1><b><fmt:message key="Common.Variance.label" bundle="${common_labels}"/></b></font></th>
		<th nowrap class='CAGROUP_HEADING'><font size=1><b><fmt:message key="eST.MFGReceive.label" bundle="${st_labels}"/></b></font></th>
		<th nowrap class='CAGROUP_HEADING'><font size=1><b><fmt:message key="eST.SalesReturns.label" bundle="${st_labels}"/> </b></font></th>
		<th nowrap class='CAGROUP_HEADING'><font size=1><b><fmt:message key="eST.ProductTransfer.label" bundle="${st_labels}"/></b></font></th>
		<th nowrap class='CAGROUP_HEADING'><font size=1><b><fmt:message key="Common.total.label" bundle="${common_labels}"/> </b></font></th>
		<th nowrap class='CAGROUP_HEADING'><font size=1><b><fmt:message key="eST.RTV.label" bundle="${st_labels}"/></b></font></th>
		<th nowrap class='CAGROUP_HEADING'><font size=1><b><fmt:message key="eMM.Adjustment.label" bundle="${mm_labels}"/></b></font></th>
		<th nowrap class='CAGROUP_HEADING'><font size=1><b><fmt:message key="Common.Variance.label" bundle="${common_labels}"/></b></font></th>
		<th nowrap class='CAGROUP_HEADING'><font size=1><b><fmt:message key="eST.MFGReceive.label" bundle="${st_labels}"/> </b></font></th>
		<th nowrap class='CAGROUP_HEADING'><font size=1><b><fmt:message key="eST.ProductTransfer.label" bundle="${st_labels}"/> </b></font></th>
		<th nowrap class='CAGROUP_HEADING'><font size=1><b><fmt:message key="eST.Sales.label" bundle="${st_labels}"/></b></font></th>
		<th nowrap class='CAGROUP_HEADING'><font size=1><b><fmt:message key="Common.total.label" bundle="${common_labels}"/> </b></font></th>
		<th nowrap class='CAGROUP_HEADING'><font size=1><b><fmt:message key="eST.Consumption.label" bundle="${st_labels}"/></b></font></th>
		<th nowrap class='CAGROUP_HEADING'><font size=1><b><fmt:message key="eST.ClosingBalance.label" bundle="${st_labels}"/> </b></font></th>
	</tr>
	<%
	}
	else	{
	%>
	<div id="divHeadSep" style="position: absolute;">

	<table cellpadding=0 cellspacing=0 width="280%" align=center>
	<tr >
	<table border="1" cellpadding="0" cellspacing="0" width="280%"  id='tb1'>
		<tr id="heading">
		<th colspan=2 >&nbsp;</th>
	
		<th COLSPAN='9'  class='CAGROUP_HEADING'><font size=1><b>-------------------------------------------------------------------------- <fmt:message key="eST.StockInflow.label" bundle="${st_labels}"/> ---------------------------------------------------------------------------------------------</b></font></th>
		<th COLSPAN='11'  class='CAGROUP_HEADING'><font size=1><b>------------------------------------------------------------------------------------------- <fmt:message key="eST.StockOutflow.label" bundle="${st_labels}"/>----------------------------------------------------------------------------------------------------------------------</b></font></th>
		<th colspan=1>&nbsp;</th>
	<tr>
	<tr id="heading1">
		<th nowrap class='CAGROUP_HEADING'><font size=1><b><fmt:message key="Common.Period.label" bundle="${common_labels}"/></b></font></th>
		<th nowrap class='CAGROUP_HEADING'><font size=1><b><fmt:message key="Common.OpeningBalance.label" bundle="${common_labels}"/></b></font></th>
		<th nowrap class='CAGROUP_HEADING'><font size=1><b><fmt:message key="eST.GRN.label" bundle="${st_labels}"/></b></font></th>
		<th nowrap class='CAGROUP_HEADING'><font size=1><b><fmt:message key="eST.InventoryIssues.label" bundle="${st_labels}"/></b></font></th>
		<th nowrap class='CAGROUP_HEADING'><font size=1><b><fmt:message key="eST.InventoryReturns.label" bundle="${st_labels}"/></b></font></th>
		<th nowrap class='CAGROUP_HEADING'><font size=1><b><fmt:message key="eST.ProductTransfer.label" bundle="${st_labels}"/></b></font></th>
		<th nowrap class='CAGROUP_HEADING'><font size=1><b><fmt:message key="eST.StockTransfer.label" bundle="${st_labels}"/></b></font></th>
		<th nowrap class='CAGROUP_HEADING'><font size=1><b><fmt:message key="eMM.Adjustment.label" bundle="${mm_labels}"/></b></font></th>
		<th nowrap class='CAGROUP_HEADING'><font size=1><b><fmt:message key="eST.MFGReceive.label" bundle="${st_labels}"/> </b></font></th>
		<th nowrap class='CAGROUP_HEADING'><font size=1><b><fmt:message key="eST.SalesReturns.label" bundle="${st_labels}"/></b></font></th>
		<th  class='CAGROUP_HEADING'><font size=1><b><fmt:message key="Common.total.label" bundle="${common_labels}"/> </b></font></th>
		<th nowrap class='CAGROUP_HEADING'><font size=1><b><fmt:message key="eST.RTV.label" bundle="${st_labels}"/></b></font></th>
		<th nowrap class='CAGROUP_HEADING'><font size=1><b><fmt:message key="eST.InventoryIssues.label" bundle="${st_labels}"/></b></font></th>
		<th nowrap class='CAGROUP_HEADING'><font size=1><b><fmt:message key="eST.NonStockIssues.label" bundle="${st_labels}"/></b></font></th>
		<th nowrap class='CAGROUP_HEADING'><font size=1><b><fmt:message key="eST.InventoryReturns.label" bundle="${st_labels}"/></b></font></th><!-- Modified for TFS id:11670 -->
		<th nowrap class='CAGROUP_HEADING'><font size=1><b><fmt:message key="eST.NonStockReturns.label" bundle="${st_labels}"/></b></font></th>
		<th nowrap class='CAGROUP_HEADING'><font size=1><b><fmt:message key="eST.ProductTransfer.label" bundle="${st_labels}"/></b></font></th>
		<th nowrap class='CAGROUP_HEADING'><font size=1><b><fmt:message key="eST.StockTransfer.label" bundle="${st_labels}"/></b></font></th>
		<th nowrap class='CAGROUP_HEADING'><font size=1><b><fmt:message key="eMM.Adjustment.label" bundle="${mm_labels}"/></b></font></th>
		<th nowrap class='CAGROUP_HEADING'><font size=1><b><fmt:message key="eST.MFGReceive.label" bundle="${st_labels}"/></b></font></th>
		<th nowrap class='CAGROUP_HEADING'><font size=1><b><fmt:message key="eST.Sales.label" bundle="${st_labels}"/></b></font></th>
		<th  class='CAGROUP_HEADING'><font size=1><b><fmt:message key="Common.total.label" bundle="${common_labels}"/> </b></font></th>
		<th nowrap class='CAGROUP_HEADING'><font size=1><b><fmt:message key="eST.ClosingBalance.label" bundle="${st_labels}"/> </b></font></th>
	</tr>
	<%
	}
	}
	if(result.size() > 0)
	{
	if(store_code.equals(""))
	{
	for(int i=0;i<result.size();i++)
	{
	showdataList					=		(HashMap)result.get(i);

	String className=(i%2==0)?"QRYEVEN":"QRYODD";

	/*String PERIOD					=		(String)showdataList.get("PERIOD");
	String IN_OPEN_BAL				=		bean.setNumber((String)showdataList.get("IN_OPEN_BAL"),2);
	String IN_GRN					=		bean.setNumber((String)showdataList.get("IN_GRN"),2);
	String IN_ADJ					=		bean.setNumber((String)showdataList.get("IN_ADJ"),2);
	String IN_VAR					=		bean.setNumber((String)showdataList.get("IN_VAR"),2);
	String IN_MFG_REC				=		bean.setNumber((String)showdataList.get("IN_MFG_REC"),2);
	String IN_SALE_RET				=		bean.setNumber((String)showdataList.get("IN_SALE_RET"),2);
	String IN_PROD					=		bean.setNumber((String)showdataList.get("IN_PROD"),2);
	String OUT_RTV					=		bean.setNumber((String)showdataList.get("OUT_RTV"),2);
	String OUT_ADJ					=		bean.setNumber((String)showdataList.get("OUT_ADJ"),2);
	String OUT_VAR					=		bean.setNumber((String)showdataList.get("OUT_VAR"),2);
	String OUT_MFG					=		bean.setNumber((String)showdataList.get("OUT_MFG"),2);
	String OUT_PROD					=		bean.setNumber((String)showdataList.get("OUT_PROD"),2);
	String OUT_SALE					=		bean.setNumber((String)showdataList.get("OUT_SALE"),2);
	String OUT_CONS					=		bean.setNumber((String)showdataList.get("OUT_CONS"),2);
	String OUT_CLOS_BAL				=		bean.setNumber((String)showdataList.get("OUT_CLOS_BAL"),2);
	String TOTAL_INFLOW				=		bean.setNumber((String)showdataList.get("TOTAL_INFLOW"),2);
	String TOTAL_OUTFLOW			=		bean.setNumber((String)showdataList.get("TOTAL_OUTFLOW"),2);*/
	GRN_QTY_COLUMN					=		(String)showdataList.get("GRN_QTY_COLUMN");
	POS_ADJ_COLUMN					=		(String)showdataList.get("POS_ADJ_COLUMN");
	POS_VAR_QTY_COLUMN				=		(String)showdataList.get("POS_VAR_QTY_COLUMN");
	MFG_QTY_COLUMN					=		(String)showdataList.get("MFG_QTY_COLUMN");
	IN_SALE_RET_COLUMN				=		(String)showdataList.get("IN_SALE_RET_COLUMN");
	IN_PROD_COLUMN					=		(String)showdataList.get("IN_PROD_COLUMN");
	OUT_RTV_COLUMN					=		(String)showdataList.get("OUT_RTV_COLUMN");
	OUT_ADJ_COLUMN					=		(String)showdataList.get("OUT_ADJ_COLUMN");
	OUT_VAR_COLUMN					=		(String)showdataList.get("OUT_VAR_COLUMN");
	OUT_MFG_COLUMN					=		(String)showdataList.get("OUT_MFG_COLUMN");
	OUT_PROD_COLUMN					=		(String)showdataList.get("OUT_PROD_COLUMN");
	OUT_SALE_COLUMN					=		(String)showdataList.get("OUT_SALE_COLUMN");
	OUT_CONS_COLUMN					=		(String)showdataList.get("OUT_CONS_COLUMN");
	TOTAL_TOTAL_INFLOW				=		(String)showdataList.get("TOTAL_TOTAL_INFLOW");
	TOTAL_TOTAL_OUTFLOW				=		(String)showdataList.get("TOTAL_TOTAL_OUTFLOW");
	PERIOD				            =		(String)showdataList.get("PERIOD");
	PERIOD				            =	com.ehis.util.DateUtils.convertDate(PERIOD,"MY","en",locale);

	%>
	<tr onClick="return changeRowColor(this);">
		<td  class="<%=className%>"  ><font size=1><%=PERIOD%></font></td>
		<td  class="<%=className%>"   style="TEXT-ALIGN:right"><font size=1><%=bean.checkForNull((String)showdataList.get("IN_OPEN_BAL"),"0.00")%></font>&nbsp;</td>
		<td nowrap class="<%=className%>"   style="TEXT-ALIGN:right"><font size=1><%=showdataList.get("IN_GRN")%></font>&nbsp;</td>
		<td nowrap class="<%=className%>"   style="TEXT-ALIGN:right"><font size=1><%=showdataList.get("IN_ADJ")%></font>&nbsp;</td>
		<td nowrap class="<%=className%>"   style="TEXT-ALIGN:right"><font size=1><%=showdataList.get("IN_VAR")%></font>&nbsp;</td>
		<td nowrap class="<%=className%>"   style="TEXT-ALIGN:right"><font size=1><%=showdataList.get("IN_MFG_REC")%></font>&nbsp;</td>
		<td nowrap class="<%=className%>"   style="TEXT-ALIGN:right"><font size=1><%=showdataList.get("IN_SALE_RET")%></font>&nbsp;</td>
		<td nowrap class="<%=className%>"   style="TEXT-ALIGN:right"><font size=1><%=showdataList.get("IN_PROD")%></font>&nbsp;</td>
		<td  class="<%=className%>"   style="TEXT-ALIGN:right"><font size=1><%=showdataList.get("TOTAL_INFLOW")%></font>&nbsp;</td>
		<td nowrap class="<%=className%>"   style="TEXT-ALIGN:right"><font size=1><%=showdataList.get("OUT_RTV")%></font>&nbsp;</td>
		<td nowrap class="<%=className%>"   style="TEXT-ALIGN:right"><font size=1><%=showdataList.get("OUT_ADJ")%></font>&nbsp;</td>
		<td nowrap class="<%=className%>"   style="TEXT-ALIGN:right"><font size=1><%=showdataList.get("OUT_VAR")%></font>&nbsp;</td>
		<td nowrap class="<%=className%>"   style="TEXT-ALIGN:right"><font size=1><%=showdataList.get("OUT_MFG")%></font>&nbsp;</td>
		<td nowrap class="<%=className%>"   style="TEXT-ALIGN:right"><font size=1><%=showdataList.get("OUT_PROD")%></font>&nbsp;</td>
		<td nowrap class="<%=className%>"   style="TEXT-ALIGN:right"><font size=1><%=showdataList.get("OUT_SALE")%></font>&nbsp;</td>
		<td nowrap class="<%=className%>"   style="TEXT-ALIGN:right"><font size=1><%=showdataList.get("TOTAL_OUTFLOW")%></font>&nbsp;</td>
		<td nowrap class="<%=className%>"   style="TEXT-ALIGN:right"><font size=1><%=showdataList.get("OUT_CONS")%></font>&nbsp;</td>
		<td nowrap class="<%=className%>"   style="TEXT-ALIGN:right"><font size=1><%=bean.checkForNull((String)showdataList.get("OUT_CLOS_BAL"),"0.00")%></font>&nbsp;</td>
		</tr>
	<%
	}
	%>
	<tr>
	<th  class='CAGROUP_HEADING' colspan="2" style="TEXT-ALIGN:left"><font size=1><b><fmt:message key="Common.total.label" bundle="${common_labels}"/> </b></font></th>
	<th  nowrap class='CAGROUP_HEADING' colspan="1" style="TEXT-ALIGN:right"><font size=1><b><%=GRN_QTY_COLUMN%> </b></font>&nbsp;</th>
	<th nowrap class='CAGROUP_HEADING' colspan="1" style="TEXT-ALIGN:right"><font size=1><b><%=POS_ADJ_COLUMN%> </b></font>&nbsp;</th>
	<th nowrap class='CAGROUP_HEADING' colspan="1" style="TEXT-ALIGN:right"><font size=1><b><%=POS_VAR_QTY_COLUMN%></b></font>&nbsp;</th>
	<th nowrap class='CAGROUP_HEADING' colspan="1" style="TEXT-ALIGN:right"><font size=1><b><%=MFG_QTY_COLUMN%></b></font>&nbsp;</th>
	<th nowrap class='CAGROUP_HEADING' colspan="1" style="TEXT-ALIGN:right"><font size=1><b><%=IN_SALE_RET_COLUMN%></b></font>&nbsp;</th>
	<th nowrap class='CAGROUP_HEADING' colspan="1" style="TEXT-ALIGN:right"><font size=1><b><%=IN_PROD_COLUMN%> </b></font>&nbsp;</th>
	<th nowrap class='CAGROUP_HEADING' colspan="1" style="TEXT-ALIGN:right"><font size=1><b><%=TOTAL_TOTAL_INFLOW%></b></font>&nbsp;</th>
	<th nowrap class='CAGROUP_HEADING' colspan="1" style="TEXT-ALIGN:right"><font size=1><b><%=OUT_RTV_COLUMN%></b></font>&nbsp;</th>
	<th nowrap class='CAGROUP_HEADING' colspan="1" style="TEXT-ALIGN:right"><font size=1><b><%=OUT_ADJ_COLUMN%></b></font>&nbsp;</th>
	<th  nowrap class='CAGROUP_HEADING' colspan="1" style="TEXT-ALIGN:right"><font size=1><b><%=OUT_VAR_COLUMN%></b></font>&nbsp;</th>
	<th nowrap class='CAGROUP_HEADING' colspan="1" style="TEXT-ALIGN:right"><font size=1><b><%=OUT_MFG_COLUMN%></b></font>&nbsp;</th>
	<th nowrap class='CAGROUP_HEADING' colspan="1" style="TEXT-ALIGN:right"><font size=1><b><%=OUT_PROD_COLUMN%></b></font>&nbsp;</th>
	<th nowrap class='CAGROUP_HEADING' colspan="1" style="TEXT-ALIGN:right"><font size=1><b><%=OUT_SALE_COLUMN%></b></font>&nbsp;</th>
	<th nowrap class='CAGROUP_HEADING' colspan="1" style="TEXT-ALIGN:right"><font size=1><b><%=TOTAL_TOTAL_OUTFLOW%></b></font>&nbsp;</th>
	<th nowrap class='CAGROUP_HEADING' colspan="1" style="TEXT-ALIGN:right"><font size=1><b><%=OUT_CONS_COLUMN%></b></font>&nbsp;</th>
	</tr>
	<%
	}
	else
	{
	for(int j=0;j<result.size();j++)
	{
	showdataList_s					=			(HashMap)result.get(j);

	String className_s=(j%2==0)?"QRYEVEN":"QRYODD";
	/** @Name - Priya
		* @Date - 03/02/2010
		* @Inc# - 15496 (SRR20056-CRF-0537.2)
		* @Desc - To use common method, the previous coding has been removed & to get the values based on no_of_decimals 	st_display_decimals_format function is used in the query (ItemMovementShowItemBean --> loadData())
		*/
	/*String PERIOD_s					=			((String)showdataList_s.get("PERIOD")).equals(fmt)?"0"+fmt:(String)showdataList_s.get("PERIOD");
	String IN_OPEN_BAL_s			=			((String)showdataList_s.get("IN_OPEN_BAL")).equals(fmt)?"0"+fmt:(String)showdataList_s.get("IN_OPEN_BAL");
	String IN_GRN_s					=			((String)showdataList_s.get("IN_GRN")).equals(fmt)?"0"+fmt:(String)showdataList_s.get("IN_GRN");
	String IN_INV_ISS_STORE_s		=			((String)showdataList_s.get("IN_INV_ISS_STORE")).equals(fmt)?"0"+fmt:(String)showdataList_s.get("IN_INV_ISS_STORE");
	String IN_INV_RET_STORE_s		=			((String)showdataList_s.get("IN_INV_RET_STORE")).equals(fmt)?"0"+fmt:(String)showdataList_s.get("IN_INV_RET_STORE");
	String IN_PROD_s				=			((String)showdataList_s.get("IN_PROD")).equals(fmt)?"0"+fmt:(String)showdataList_s.get("IN_PROD");
	String IN_TFR_s					=			((String)showdataList_s.get("IN_TFR")).equals(fmt)?"0"+fmt:(String)showdataList_s.get("IN_TFR");
	String IN_ADJ_s					=			((String)showdataList_s.get("IN_ADJ")).equals(fmt)?"0"+fmt:(String)showdataList_s.get("IN_ADJ");
	String IN_MFG_REC_s				=			((String)showdataList_s.get("IN_MFG_REC")).equals(fmt)?"0"+fmt:(String)showdataList_s.get("IN_MFG_REC");
	String IN_SALE_RET_s			=			((String)showdataList_s.get("IN_SALE_RET")).equals(fmt)?"0"+fmt:(String)showdataList_s.get("IN_SALE_RET");
	String OUT_INV_ISS_STORE_s		=			((String)showdataList_s.get("OUT_INV_ISS_STORE")).equals(fmt)?"0"+fmt:(String)showdataList_s.get("OUT_INV_ISS_STORE");
	String OUT_NS_ISS_STORE_s		=			((String)showdataList_s.get("OUT_NS_ISS_STORE")).equals(fmt)?"0"+fmt:(String)showdataList_s.get("OUT_NS_ISS_STORE");
	String OUT_INV_RET_STORE_s		=			((String)showdataList_s.get("OUT_INV_RET_STORE")).equals(fmt)?"0"+fmt:(String)showdataList_s.get("OUT_INV_RET_STORE");
	String OUT_NS_RET_STORE_s		=			((String)showdataList_s.get("OUT_NS_RET_STORE")).equals(fmt)?"0"+fmt:(String)showdataList_s.get("OUT_NS_RET_STORE");
	String OUT_RTV_s				=		((String)showdataList_s.get("OUT_RTV")).equals(fmt)?"0"+fmt:(String)showdataList_s.get("OUT_RTV");
	String OUT_PROD_s				=			((String)showdataList_s.get("OUT_PROD")).equals(fmt)?"0"+fmt:(String)showdataList_s.get("OUT_PROD");
	String OUT_TFR_s				=			((String)showdataList_s.get("OUT_TFR")).equals(fmt)?"0"+fmt:(String)showdataList_s.get("OUT_TFR");
	String OUT_ADJ_s				=			((String)showdataList_s.get("OUT_ADJ")).equals(fmt)?"0"+fmt:(String)showdataList_s.get("OUT_ADJ");
	String OUT_MFG_s				=			((String)showdataList_s.get("OUT_MFG")).equals(fmt)?"0"+fmt:(String)showdataList_s.get("OUT_MFG");
	String OUT_SALE_s				=			((String)showdataList_s.get("OUT_SALE")).equals(fmt)?"0"+fmt:(String)showdataList_s.get("OUT_SALE");
	String OUT_CLOS_BAL_s			=			((String)showdataList_s.get("OUT_CLOS_BAL")).equals(fmt)?"0"+fmt:(String)showdataList_s.get("OUT_CLOS_BAL");
	GRN_QTY_COLUMN					=			((String)showdataList_s.get("GRN_QTY_COLUMN")).equals(fmt)?"0"+fmt:(String)showdataList_s.get("GRN_QTY_COLUMN");
	POS_ADJ_COLUMN					=			((String)showdataList_s.get("POS_ADJ_COLUMN")).equals(fmt)?"0"+fmt:(String)showdataList_s.get("POS_ADJ_COLUMN");
	MFG_QTY_COLUMN					=			((String)showdataList_s.get("MFG_QTY_COLUMN")).equals(fmt)?"0"+fmt:(String)showdataList_s.get("MFG_QTY_COLUMN");
	IN_SALE_RET_COLUMN				=			((String)showdataList_s.get("IN_SALE_RET_COLUMN")).equals(fmt)?"0"+fmt:(String)showdataList_s.get("IN_SALE_RET_COLUMN");
	IN_PROD_COLUMN					=			((String)showdataList_s.get("IN_PROD_COLUMN")).equals(fmt)?"0"+fmt:(String)showdataList_s.get("IN_PROD_COLUMN");
	
	
	OUT_RTV_COLUMN					=			((String)showdataList_s.get("OUT_RTV_COLUMN")).equals(fmt)?"0"+fmt:(String)showdataList_s.get("OUT_RTV_COLUMN");
	OUT_ADJ_COLUMN					=			((String)showdataList_s.get("OUT_ADJ_COLUMN")).equals(fmt)?"0"+fmt:(String)showdataList_s.get("OUT_ADJ_COLUMN");
	OUT_MFG_COLUMN					=			((String)showdataList_s.get("OUT_MFG_COLUMN")).equals(fmt)?"0"+fmt:(String)showdataList_s.get("OUT_MFG_COLUMN");
	OUT_PROD_COLUMN					=			((String)showdataList_s.get("OUT_PROD_COLUMN")).equals(fmt)?"0"+fmt:(String)showdataList_s.get("OUT_PROD_COLUMN");
	OUT_SALE_COLUMN					=			((String)showdataList_s.get("OUT_SALE_COLUMN")).equals(fmt)?"0"+fmt:(String)showdataList_s.get("OUT_SALE_COLUMN");
	OUT_CONS_COLUMN					=			((String)showdataList_s.get("OUT_CONS_COLUMN")).equals(fmt)?"0"+fmt:(String)showdataList_s.get("OUT_CONS_COLUMN");
	TOTAL_TOTAL_INFLOW_STORE		=			((String)showdataList_s.get("TOTAL_TOTAL_INFLOW_STORE")).equals(fmt)?"0"+fmt:(String)showdataList_s.get("TOTAL_TOTAL_INFLOW_STORE");
	TOTAL_TOTAL_OUTFLOW_STORE		=			((String)showdataList_s.get("TOTAL_TOTAL_OUTFLOW_STORE")).equals(fmt)?"0"+fmt:(String)showdataList_s.get("TOTAL_TOTAL_OUTFLOW_STORE");
	IN_INV_ISS_STORE_COLUMN			=			((String)showdataList_s.get("IN_INV_ISS_STORE_COLUMN")).equals(fmt)?"0"+fmt:(String)showdataList_s.get("IN_INV_ISS_STORE_COLUMN");
	IN_INV_RET_STORE_COLUMN			=			((String)showdataList_s.get("IN_INV_RET_STORE_COLUMN")).equals(fmt)?"0"+fmt:(String)showdataList_s.get("IN_INV_RET_STORE_COLUMN");
	OUT_INV_ISS_STORE_COLUMN		=			((String)showdataList_s.get("OUT_INV_ISS_STORE_COLUMN")).equals(fmt)?"0"+fmt:(String)showdataList_s.get("OUT_INV_ISS_STORE_COLUMN");
	OUT_NS_ISS_STORE_COLUMN			=			((String)showdataList_s.get("OUT_NS_ISS_STORE_COLUMN")).equals(fmt)?"0"+fmt:(String)showdataList_s.get("OUT_NS_ISS_STORE_COLUMN");
	OUT_INV_RET_STORE_COLUMN		=			((String)showdataList_s.get("OUT_INV_RET_STORE_COLUMN")).equals(fmt)?"0"+fmt:(String)showdataList_s.get("OUT_INV_RET_STORE_COLUMN");
	OUT_NS_RET_STORE_COLUMN			=			((String)showdataList_s.get("OUT_NS_RET_STORE_COLUMN")).equals(fmt)?"0"+fmt:(String)showdataList_s.get("OUT_NS_RET_STORE_COLUMN");
	OUT_TFR_COLUMN					=			((String)showdataList_s.get("OUT_TFR_COLUMN")).equals(fmt)?"0"+fmt:(String)showdataList_s.get("OUT_TFR_COLUMN");
	IN_TFR_COLUMN					=			((String)showdataList_s.get("IN_TFR_COLUMN")).equals(fmt)?"0"+fmt:(String)showdataList_s.get("IN_TFR_COLUMN");*/
	String PERIOD_s					= (String)showdataList_s.get("PERIOD");
	PERIOD_s				=	com.ehis.util.DateUtils.convertDate(PERIOD_s,"MY","en",locale);
	String IN_OPEN_BAL_s			= bean.checkForNull((String)showdataList_s.get("IN_OPEN_BAL"),"0.00");
	String IN_GRN_s					= (String)showdataList_s.get("IN_GRN");
	String IN_INV_ISS_STORE_s		= (String)showdataList_s.get("IN_INV_ISS_STORE");
	String IN_INV_RET_STORE_s		= (String)showdataList_s.get("IN_INV_RET_STORE");
	String IN_PROD_s				= (String)showdataList_s.get("IN_PROD");
	String IN_TFR_s					= (String)showdataList_s.get("IN_TFR");
	String IN_ADJ_s					= (String)showdataList_s.get("IN_ADJ");
	String IN_MFG_REC_s				= (String)showdataList_s.get("IN_MFG_REC");
	String IN_SALE_RET_s			= (String)showdataList_s.get("IN_SALE_RET");
	String OUT_INV_ISS_STORE_s		= (String)showdataList_s.get("OUT_INV_ISS_STORE");
	String OUT_NS_ISS_STORE_s		= (String)showdataList_s.get("OUT_NS_ISS_STORE");
	String OUT_INV_RET_STORE_s		= (String)showdataList_s.get("OUT_INV_RET_STORE");
	String OUT_NS_RET_STORE_s		= (String)showdataList_s.get("OUT_NS_RET_STORE");
	String OUT_RTV_s				= (String)showdataList_s.get("OUT_RTV");
	String OUT_PROD_s				= (String)showdataList_s.get("OUT_PROD");
	String OUT_TFR_s				= (String)showdataList_s.get("OUT_TFR");
	String OUT_ADJ_s				= (String)showdataList_s.get("OUT_ADJ");
	String OUT_MFG_s				= (String)showdataList_s.get("OUT_MFG");
	String OUT_SALE_s				= (String)showdataList_s.get("OUT_SALE");
	String OUT_CLOS_BAL_s			= bean.checkForNull((String)showdataList_s.get("OUT_CLOS_BAL"),"0.00");
	GRN_QTY_COLUMN					= (String)showdataList_s.get("GRN_QTY_COLUMN");
	POS_ADJ_COLUMN					= (String)showdataList_s.get("POS_ADJ_COLUMN");
	MFG_QTY_COLUMN					= (String)showdataList_s.get("MFG_QTY_COLUMN");
	IN_SALE_RET_COLUMN				= (String)showdataList_s.get("IN_SALE_RET_COLUMN");
	IN_PROD_COLUMN					= (String)showdataList_s.get("IN_PROD_COLUMN");
	
	
	OUT_RTV_COLUMN					= (String)showdataList_s.get("OUT_RTV_COLUMN");
	OUT_ADJ_COLUMN					= (String)showdataList_s.get("OUT_ADJ_COLUMN");
	OUT_MFG_COLUMN					= (String)showdataList_s.get("OUT_MFG_COLUMN");
	OUT_PROD_COLUMN					= (String)showdataList_s.get("OUT_PROD_COLUMN");
	OUT_SALE_COLUMN					= (String)showdataList_s.get("OUT_SALE_COLUMN");
	OUT_CONS_COLUMN					= (String)showdataList_s.get("OUT_CONS_COLUMN");
	TOTAL_TOTAL_INFLOW_STORE		= (String)showdataList_s.get("TOTAL_TOTAL_INFLOW_STORE");
	TOTAL_TOTAL_OUTFLOW_STORE		= (String)showdataList_s.get("TOTAL_TOTAL_OUTFLOW_STORE");
	IN_INV_ISS_STORE_COLUMN			= (String)showdataList_s.get("IN_INV_ISS_STORE_COLUMN");
	IN_INV_RET_STORE_COLUMN			= (String)showdataList_s.get("IN_INV_RET_STORE_COLUMN");
	OUT_INV_ISS_STORE_COLUMN		= (String)showdataList_s.get("OUT_INV_ISS_STORE_COLUMN");
	OUT_NS_ISS_STORE_COLUMN			= (String)showdataList_s.get("OUT_NS_ISS_STORE_COLUMN");
	OUT_INV_RET_STORE_COLUMN		= (String)showdataList_s.get("OUT_INV_RET_STORE_COLUMN");
	OUT_NS_RET_STORE_COLUMN			= (String)showdataList_s.get("OUT_NS_RET_STORE_COLUMN");
	OUT_TFR_COLUMN					= (String)showdataList_s.get("OUT_TFR_COLUMN");
	IN_TFR_COLUMN					= (String)showdataList_s.get("IN_TFR_COLUMN");

	%>
	<tr id="tr<%=j%>" onClick=" changeRowColor(tr<%=j%>);">
		<td  class="<%=className_s%>"  width=100><a HREF="#" onClick="changeRowColor(tr<%=j%>);callDetailWindow ('<%=item_CC%>','<%=store_code%>','<%=PERIOD_s%>','<%=IN_OPEN_BAL_s%>','<%=IN_GRN_s%>','<%=OUT_RTV_s%>','<%=IN_INV_ISS_STORE_s%>','<%=OUT_INV_ISS_STORE_s%>','----','<%=OUT_NS_ISS_STORE_s%>','<%=IN_INV_RET_STORE_s%>','<%=OUT_NS_RET_STORE_s%>','----','<%=OUT_NS_RET_STORE_s%>','<%=OUT_SALE_s%>','<%=IN_SALE_RET_s%>','<%=IN_PROD_s%>','<%=OUT_PROD_s%>','<%=IN_ADJ_s%>','<%=OUT_ADJ_s%>','<%=OUT_CLOS_BAL_s%>','<%=IN_MFG_REC_s%>','<%=OUT_MFG_s%>','<%=IN_TFR_s%>','<%=OUT_TFR_s%>');"><font size=1><%=PERIOD_s%></font></a></td>
		<td nowrap class="<%=className_s%>"   style="TEXT-ALIGN:right"><font size=1><%=IN_OPEN_BAL_s%></font>&nbsp;</td>
		<td nowrap class="<%=className_s%>"   style="TEXT-ALIGN:right"><font size=1><%=IN_GRN_s%></font>&nbsp;</td>
		<td nowrap class="<%=className_s%>"   style="TEXT-ALIGN:right"><font size=1><%=IN_INV_ISS_STORE_s%></font>&nbsp;</td>
		<td nowrap class="<%=className_s%>"   style="TEXT-ALIGN:right"><font size=1><%=IN_INV_RET_STORE_s%></font>&nbsp;</td>
		<td nowrap class="<%=className_s%>"   style="TEXT-ALIGN:right"><font size=1><%=IN_PROD_s%></font>&nbsp;</td>
		<td nowrap class="<%=className_s%>"   style="TEXT-ALIGN:right"><font size=1><%=IN_TFR_s%></font>&nbsp;</td>
		<td nowrap class="<%=className_s%>"   style="TEXT-ALIGN:right"><font size=1><%=IN_ADJ_s%></font>&nbsp;</td>
		<td nowrap class="<%=className_s%>"  style="TEXT-ALIGN:right"><font size=1><%=IN_MFG_REC_s%></font>&nbsp;</td>
		<td nowrap class="<%=className_s%>"   style="TEXT-ALIGN:right"><font size=1><%=IN_SALE_RET_s%></font>&nbsp;</td>
		<td nowrap class="<%=className_s%>"  style="TEXT-ALIGN:right"><font size=1><%=showdataList_s.get("TOTAL_INFLOW_STORE")%> </font>&nbsp;</td>
		<td nowrap class="<%=className_s%>"   style="TEXT-ALIGN:right"><font size=1><%=OUT_RTV_s%></font>&nbsp;</td>
		<td nowrap class="<%=className_s%>"   style="TEXT-ALIGN:right"><font size=1><%=OUT_INV_ISS_STORE_s%></font>&nbsp;</td>
		<td nowrap class="<%=className_s%>"   style="TEXT-ALIGN:right"><font size=1><%=OUT_NS_ISS_STORE_s%></font>&nbsp;</td>
		<td nowrap class="<%=className_s%>"   style="TEXT-ALIGN:right"><font size=1><%=OUT_INV_RET_STORE_s%></font>&nbsp;</td>
		<td nowrap class="<%=className_s%>"   style="TEXT-ALIGN:right"><font size=1><%=OUT_NS_RET_STORE_s%></font>&nbsp;</td>
		<td nowrap class="<%=className_s%>"   style="TEXT-ALIGN:right"><font size=1><%=OUT_PROD_s%></font>&nbsp;</td>
		<td nowrap class="<%=className_s%>"   style="TEXT-ALIGN:right"><font size=1><%=OUT_TFR_s%></font>&nbsp;</td>
		<td nowrap class="<%=className_s%>"   style="TEXT-ALIGN:right"><font size=1><%=OUT_ADJ_s%></font>&nbsp;</td>
		<td nowrap class="<%=className_s%>"  style="TEXT-ALIGN:right"><font size=1><%=OUT_MFG_s%></font>&nbsp;</td>
		<td nowrap class="<%=className_s%>"   style="TEXT-ALIGN:right"><font size=1><%=OUT_SALE_s%></font>&nbsp;</td>
		<td nowrap class="<%=className_s%>"   style="TEXT-ALIGN:right"><font size=1><%=(String)showdataList_s.get("TOTAL_OUTFLOW_STORE")%></font>&nbsp;</td>
		<td nowrap class="<%=className_s%>"   style="TEXT-ALIGN:right"><font size=1><%=OUT_CLOS_BAL_s%></font>&nbsp;</td>
		</tr>
	<%
	}%>
	<tr>
	<th  class='CAGROUP_HEADING' colspan="2" style="TEXT-ALIGN:left"><font size=1><b><fmt:message key="Common.total.label" bundle="${common_labels}"/> </b></font></th>
	<th  nowrap class='CAGROUP_HEADING' colspan="1" style="TEXT-ALIGN:right"><font size=1><b><%=GRN_QTY_COLUMN%> </b></font>&nbsp;</th>
	<th  nowrap class='CAGROUP_HEADING' colspan="1" style="TEXT-ALIGN:right"><font size=1><b><%=IN_INV_ISS_STORE_COLUMN%> </b></font>&nbsp;</th>
	<th  nowrap class='CAGROUP_HEADING' colspan="1" style="TEXT-ALIGN:right"><font size=1><b><%=IN_INV_RET_STORE_COLUMN%> </b></font>&nbsp;</th>
	<th nowrap class='CAGROUP_HEADING' colspan="1" style="TEXT-ALIGN:right"><font size=1><b><%=IN_PROD_COLUMN%> </b></font>&nbsp;</th>
	<th  nowrap class='CAGROUP_HEADING' colspan="1" style="TEXT-ALIGN:right"><font size=1><b><%=IN_TFR_COLUMN%> </b></font>&nbsp;</th>
	<th nowrap class='CAGROUP_HEADING' colspan="1" style="TEXT-ALIGN:right"><font size=1><b><%=POS_ADJ_COLUMN%> </b></font>&nbsp;</th>
	<th nowrap class='CAGROUP_HEADING' colspan="1" style="TEXT-ALIGN:right"><font size=1><b><%=MFG_QTY_COLUMN%> </b></font>&nbsp;</th>
	<th nowrap class='CAGROUP_HEADING' colspan="1" style="TEXT-ALIGN:right"><font size=1><b><%=IN_SALE_RET_COLUMN%> </b></font>&nbsp;</th>
	<th nowrap class='CAGROUP_HEADING' colspan="1" style="TEXT-ALIGN:right"><font size=1><b><%=TOTAL_TOTAL_INFLOW_STORE%> </b></font>&nbsp;</th>
	<th nowrap class='CAGROUP_HEADING' colspan="1" style="TEXT-ALIGN:right"><font size=1><b><%=OUT_RTV_COLUMN%> </b></font>&nbsp;</th>
	<th nowrap class='CAGROUP_HEADING' colspan="1" style="TEXT-ALIGN:right"><font size=1><b><%=OUT_INV_ISS_STORE_COLUMN%> </b></font>&nbsp;</th>
	<th nowrap class='CAGROUP_HEADING' colspan="1" style="TEXT-ALIGN:right"><font size=1><b><%=OUT_NS_ISS_STORE_COLUMN%> </b></font>&nbsp;</th>
	<th nowrap class='CAGROUP_HEADING' colspan="1" style="TEXT-ALIGN:right"><font size=1><b><%=OUT_INV_RET_STORE_COLUMN%> </b></font>&nbsp;</th>
	<th nowrap class='CAGROUP_HEADING' colspan="1" style="TEXT-ALIGN:right"><font size=1><%=OUT_NS_RET_STORE_COLUMN%><b> </b></font>&nbsp;</th>
	<th nowrap class='CAGROUP_HEADING' colspan="1" style="TEXT-ALIGN:right"><font size=1><b><%=OUT_PROD_COLUMN%> </b></font>&nbsp;</th>
	<th nowrap class='CAGROUP_HEADING' colspan="1" style="TEXT-ALIGN:right"><font size=1><b><%=OUT_TFR_COLUMN%> </b></font>&nbsp;</th>
	<th nowrap class='CAGROUP_HEADING' colspan="1" style="TEXT-ALIGN:right"><font size=1><b><%=OUT_ADJ_COLUMN%> </b></font>&nbsp;</th>
	<th nowrap class='CAGROUP_HEADING' colspan="1" style="TEXT-ALIGN:right"><font size=1><b><%=OUT_MFG_COLUMN%> </b></font>&nbsp;</th>
	<th nowrap class='CAGROUP_HEADING' colspan="1" style="TEXT-ALIGN:right"><font size=1><b><%=OUT_SALE_COLUMN%> </b></font>&nbsp;</th>
	<th nowrap class='CAGROUP_HEADING' colspan="1" style="TEXT-ALIGN:right"><font size=1><b><%=TOTAL_TOTAL_OUTFLOW_STORE%> </b></font>&nbsp;</th>
	</tr>
	<%
	}
	}
	else
	{
		%>
		<script>
		alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
		document.location.href="../../eCommon/html/blank.html";
		</script>
		<%
	}
	%>
	</table>
	</tr>
	<table>
	</div>
	<%
putObjectInBean(bean_id,bean,request);
%>
</form>
</body>
</html>

