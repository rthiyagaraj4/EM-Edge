<!DOCTYPE html>
<%@ page import ="eST.ItemMovementShowItemBean, eST.Common.* , eCommon.Common.*,java.util.ArrayList,java.util.HashMap,java.text.NumberFormat,java.text.DecimalFormat"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
	<head>
		<title></title>
<%

		request.setCharacterEncoding("UTF-8");
		String locale		=		(String)session.getAttribute("LOCALE");
		String sStyle		=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
		<script language="javascript" src="../../eCommon/js/rowcolor.js"></script>
		<script language="Javascript" src="../../eST/js/StCommon.js"></script>
		<script language="javascript" src="../../eST/js/ItemMovement.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<body>
<%
		
		String item_code			=		request.getParameter( "item_code" )==null?"":request.getParameter( "item_code" );
		String store_code			=		request.getParameter( "store_code")==null?"":request.getParameter( "store_code");
		//String stock_level		=		request.getParameter("query_type")==null?"":request.getParameter("query_type");
		String stock_item			=		request.getParameter("stock_item").trim( )==null?"":request.getParameter("stock_item");
		String trn_code				=		request.getParameter("trn_code")==null?"":request.getParameter("trn_code");
		String from					=		request.getParameter("from1")==null?"":request.getParameter("from1");
		String to					=		request.getParameter("to1")==null?"":request.getParameter("to1");

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

		String stock_inflow_outflow					=		request.getParameter("stock_inflow_outflow")==null?"":request.getParameter("stock_inflow_outflow");
		boolean searched			=		(request.getParameter("searched") == null) ?false:true;
	
	
		
	try{
		HashMap sqlMap				=		new HashMap();
		HashMap funcMap				=		new HashMap();
		ArrayList displayFields		=		new ArrayList();
		ArrayList chkFields			=		new ArrayList();

		int iIndexNext				=		-1;

		//sqlMap.put("sqlData", eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_MOVEMENT_DETAIL"));
		//sqlMap.put("sqlData", "SELECT   a.item_code,a.store_code,b.short_desc trn_type, a.doc_type_code doc_type, a.doc_no doc_no,TO_CHAR (a.doc_date, 'DD/MM/YYYY') doc_date,a.posted_date orderbycolumn, (  NVL (a.item_qty_normal, 0)+ NVL (a.item_qty_bonus, 0)+ NVL (a.item_qty_sample, 0))  item_qty,TO_CHAR (a.expiry_date, 'DD/MM/YYYY') expiry_date,c.short_desc other_store_desc, a.batch_id batch_id,NVL (d.short_name, a.trade_id) trade_id, e.short_desc bin_location,a.po_no po_no,DECODE (a.sal_trn_type,'I', 'Inpatient','O', 'Outpatient','R', 'Referral','C', 'Consumption') sale_type,a.supp_code supp_type, SUM (item_qty_normal) OVER (PARTITION BY a.item_code, a.store_code ORDER BY a.posted_date,-1* (  NVL (a.item_qty_normal, 0)+ NVL (a.item_qty_bonus, 0)+ NVL (a.item_qty_sample, 0)),a.bin_location_code,a.batch_id, a.trade_id,a.expiry_date)  balance FROM st_item_trn_dtl a,st_trn_type b,mm_store c,am_trade_name d,mm_bin_location e WHERE    SUBSTR (st_get_post_mth_yr (a.doc_date), 3) || SUBSTR (st_get_post_mth_yr (a.doc_date), 1, 2) BETWEEN ? AND ? AND item_code = ? AND a.store_code = ? AND (? IS NULL OR a.trn_type = ?) AND (? = 'B' OR stock_item_yn = ?) AND a.trn_type = b.trn_type AND c.store_code(+) = a.other_store_code AND a.trade_id = d.trade_id(+) AND e.store_code(+) = a.store_code AND e.bin_location_code(+) = a.bin_location_code  AND ((? = 'O' AND (  NVL (a.item_qty_normal, 0) + NVL (a.item_qty_bonus, 0) + NVL (a.item_qty_sample, 0))<0) OR (? = 'I' AND ((  NVL (a.item_qty_normal, 0)+ NVL (a.item_qty_bonus, 0)+ NVL (a.item_qty_sample, 0))>=0) OR (?='B' AND 1=1)))  ORDER BY orderbycolumn");
		//the above query is modified from doc_Date to posted_Date  by Ganga Tuesday, August 14, 2012 for Medicity

		//sqlMap.put("sqlData", "SELECT   a.item_code,a.store_code,b.short_desc trn_type, a.doc_type_code doc_type, a.doc_no doc_no,TO_CHAR (a.added_date, 'DD/MM/YYYY') doc_date,a.added_date orderbycolumn, (  NVL (a.item_qty_normal, 0)+ NVL (a.item_qty_bonus, 0)+ NVL (a.item_qty_sample, 0))  item_qty,TO_CHAR (a.expiry_date, 'DD/MM/YYYY') expiry_date,c.short_desc other_store_desc, a.batch_id batch_id,NVL (d.short_name, a.trade_id) trade_id, e.short_desc bin_location,a.po_no po_no,DECODE (a.sal_trn_type,'I', 'Inpatient','O', 'Outpatient','R', 'Referral','C', 'Consumption') sale_type,a.supp_code supp_type, SUM (item_qty_normal) OVER (PARTITION BY a.item_code, a.store_code ORDER BY a.added_date,-1* (  NVL (a.item_qty_normal, 0)+ NVL (a.item_qty_bonus, 0)+ NVL (a.item_qty_sample, 0)),a.bin_location_code,a.batch_id, a.trade_id,a.expiry_date)  balance FROM st_item_trn_dtl a,st_trn_type b,mm_store c,am_trade_name d,mm_bin_location e WHERE    SUBSTR (st_get_post_mth_yr (a.added_date), 3) || SUBSTR (st_get_post_mth_yr (a.added_date), 1, 2) BETWEEN ? AND ? AND item_code = ? AND a.store_code = ? AND (? IS NULL OR a.trn_type = ?) AND (? = 'B' OR stock_item_yn = ?) AND a.trn_type = b.trn_type AND c.store_code(+) = a.other_store_code AND a.trade_id = d.trade_id(+) AND e.store_code(+) = a.store_code AND e.bin_location_code(+) = a.bin_location_code  AND ((? = 'O' AND (  NVL (a.item_qty_normal, 0) + NVL (a.item_qty_bonus, 0) + NVL (a.item_qty_sample, 0))<0) OR (? = 'I' AND ((  NVL (a.item_qty_normal, 0)+ NVL (a.item_qty_bonus, 0)+ NVL (a.item_qty_sample, 0))>=0) OR (?='B' AND 1=1)))  ORDER BY orderbycolumn");//Commented against ML-MMOH-SCF-0403 by Badmavathi.B 05/08/2016
		//sqlMap.put("sqlData", "SELECT   a.item_code,a.store_code,b.short_desc trn_type, a.doc_type_code doc_type, a.doc_no doc_no,TO_CHAR (a.added_date, 'DD/MM/YYYY') doc_date,a.added_date orderbycolumn, (  NVL (a.item_qty_normal, 0)+ NVL (a.item_qty_bonus, 0)+ NVL (a.item_qty_sample, 0))  item_qty,TO_CHAR (a.expiry_date, 'DD/MM/YYYY') expiry_date,c.short_desc other_store_desc, a.batch_id batch_id,NVL (d.short_name, a.trade_id) trade_id, e.short_desc bin_location,a.po_no po_no,DECODE (a.sal_trn_type,'I', 'Inpatient','O', 'Outpatient','R', 'Referral','C', 'Consumption') sale_type,/*a.supp_code supp_type,*/(select short_name from ap_supplier where supp_code = a.supp_code)supp_type, SUM (item_qty_normal) OVER (PARTITION BY a.item_code, a.store_code ORDER BY a.added_date,-1* (  NVL (a.item_qty_normal, 0)+ NVL (a.item_qty_bonus, 0)+ NVL (a.item_qty_sample, 0)),a.bin_location_code,a.batch_id, a.trade_id,a.expiry_date)  balance FROM st_item_trn_dtl a,st_trn_type b,mm_store c,am_trade_name d,mm_bin_location e WHERE    SUBSTR (st_get_post_mth_yr (a.added_date), 3) || SUBSTR (st_get_post_mth_yr (a.added_date), 1, 2) BETWEEN ? AND ? AND item_code = ? AND a.store_code = ? AND (? IS NULL OR a.trn_type = ?) AND (? = 'B' OR stock_item_yn = ?) AND a.trn_type = b.trn_type AND c.store_code(+) = a.other_store_code AND a.trade_id = d.trade_id(+) AND e.store_code(+) = a.store_code AND e.bin_location_code(+) = a.bin_location_code  AND ((? = 'O' AND (  NVL (a.item_qty_normal, 0) + NVL (a.item_qty_bonus, 0) + NVL (a.item_qty_sample, 0))<0) OR (? = 'I' AND ((  NVL (a.item_qty_normal, 0)+ NVL (a.item_qty_bonus, 0)+ NVL (a.item_qty_sample, 0))>=0) OR (?='B' AND 1=1)))  ORDER BY orderbycolumn"); //Commented by Badmavathi.B 13/10/2016 added a.doc_no for Balance
		sqlMap.put("sqlData", "SELECT   a.item_code,a.store_code,b.short_desc trn_type, a.doc_type_code doc_type, a.doc_no doc_no,TO_CHAR (a.added_date, 'DD/MM/YYYY') doc_date,a.added_date orderbycolumn, (  NVL (a.item_qty_normal, 0)+ NVL (a.item_qty_bonus, 0)+ NVL (a.item_qty_sample, 0))  item_qty,TO_CHAR (a.expiry_date, 'DD/MM/YYYY') expiry_date,c.short_desc other_store_desc, a.batch_id batch_id,NVL (d.short_name, a.trade_id) trade_id, e.short_desc bin_location,a.po_no po_no,DECODE (a.sal_trn_type,'I', 'Inpatient','O', 'Outpatient','R', 'Referral','C', 'Consumption') sale_type,/*a.supp_code supp_type,*/(select short_name from ap_supplier where supp_code = a.supp_code)supp_type, SUM (item_qty_normal) OVER (PARTITION BY a.item_code, a.store_code ORDER BY a.added_date,-1* (  NVL (a.item_qty_normal, 0)+ NVL (a.item_qty_bonus, 0)+ NVL (a.item_qty_sample, 0)),a.bin_location_code,a.batch_id, a.trade_id,a.expiry_date, a.doc_no)  balance FROM st_item_trn_dtl a,st_trn_type b,mm_store c,am_trade_name d,mm_bin_location e WHERE    SUBSTR (st_get_post_mth_yr (a.added_date), 3) || SUBSTR (st_get_post_mth_yr (a.added_date), 1, 2) BETWEEN ? AND ? AND item_code = ? AND a.store_code = ? AND (? IS NULL OR a.trn_type = ?) AND (? = 'B' OR stock_item_yn = ?) AND a.trn_type = b.trn_type AND c.store_code(+) = a.other_store_code AND a.trade_id = d.trade_id(+) AND e.store_code(+) = a.store_code AND e.bin_location_code(+) = a.bin_location_code  AND ((? = 'O' AND (  NVL (a.item_qty_normal, 0) + NVL (a.item_qty_bonus, 0) + NVL (a.item_qty_sample, 0))<0) OR (? = 'I' AND ((  NVL (a.item_qty_normal, 0)+ NVL (a.item_qty_bonus, 0)+ NVL (a.item_qty_sample, 0))>=0) OR (?='B' AND 1=1)))  ORDER BY orderbycolumn"); 
		displayFields.add("TRN_TYPE");	
		displayFields.add("DOC_TYPE");	
		displayFields.add("DOC_NO");
		displayFields.add("DOC_DATE");
		displayFields.add("ITEM_QTY");
		displayFields.add("EXPIRY_DATE");
		displayFields.add("OTHER_STORE_DESC");
		displayFields.add("BATCH_ID");
		displayFields.add("TRADE_ID");
		displayFields.add("BIN_LOCATION");
		displayFields.add("PO_NO");
		displayFields.add("SALE_TYPE");
		displayFields.add("SUPP_TYPE");
		displayFields.add("BALANCE");
		if(from.equals("0") && to.equals("0"))
		{
				from = "190001";
				to = "999912";
		}
		if(from.equals("0"))
		{
				from = "190001";
		}
		if(to.equals("0"))
		{
				to = "999912";
		}
		chkFields.add(from);
		chkFields.add(to);
		chkFields.add(item_code);
		chkFields.add(store_code);
		chkFields.add(trn_code);
		chkFields.add(trn_code);
		chkFields.add(stock_item);
		chkFields.add(stock_item);
		chkFields.add(stock_inflow_outflow);
		chkFields.add(stock_inflow_outflow);
		chkFields.add(stock_inflow_outflow);
		funcMap.put("displayFields", displayFields);
		funcMap.put("chkFields", chkFields);
		ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
		if((result.size()>=3) && (!(((String) result.get(0)).equals("0"))))
		{
		%>
		<table cellpadding=0 cellspacing=0 width="780" align=center>
		<tr>
		<td width="80%" class="white">&nbsp;</td>
		<td width="20%" class="white">&nbsp;<%=result.get(1)%></td>
			<%iIndexNext=((String)result.get(1)).indexOf("Next");%>
		</tr>
		</table>
		<table border="1" cellpadding="0" cellspacing="0" width="200%"  id='tb1'>
		<th><fmt:message key="Common.transactiontype.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.DocTypeCode.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.DocNo.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.DocumentDate.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="eST.ItemQuantity.label" bundle="${st_labels}"/></th>
		<th><fmt:message key="Common.Balance.label" bundle="${common_labels}"/>
		<th><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="eST.PONo.label" bundle="${st_labels}"/></th>
		<th><fmt:message key="Common.Supplier.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="eST.OtherStore.label" bundle="${st_labels}"/></th>
		<th><fmt:message key="Common.TradeName.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.BinLocation.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="eST.SalesType.label" bundle="${st_labels}"/></th>
		<%
//	java.util.HashMap defaultParameter = null;
	String bean_id						=		"ItemMovementShowItemBean";
	String bean_name					=		"eST.ItemMovementShowItemBean";

	ItemMovementShowItemBean bean		=		(ItemMovementShowItemBean)getBeanObject(bean_id,bean_name,request);
	bean.setLanguageId(locale);
	bean.clear();
	bean.setQuery_type(request.getParameter("query_type")==null?"":request.getParameter("query_type"));
	bean.setStore_code(request.getParameter("store_code")==null?"":request.getParameter("store_code"));
	bean.setStock_item(request.getParameter("stock_item")==null?"":request.getParameter("stock_item"));
	bean.setItem_code(request.getParameter("item_code")==null?"":request.getParameter("item_code"));
	bean.setTrn_code(request.getParameter("trn_code")==null?"":request.getParameter("trn_code"));
	//bean.setFrom(request.getParameter("from1")==null?"":request.getParameter("from1"));
	
	bean.setFrom(from);
	//bean.setTo(request.getParameter("to1")==null?"":request.getParameter("to1"));
	bean.setTo(to);
	/**
			* @Name - krishna
			* @Date - 24/12/2009
			* @Inc# - CRF537.1
			* @Desc - No of decimal positions when u r find fmt
	 */
	int no_of_decimals=Integer.parseInt(bean.checkForNull((String)bean.fetchRecord("SELECT NO_OF_DECIMALS FROM ST_ACC_ENTITY_PARAM WHERE ACC_ENTITY_ID='ZZ'").get("NO_OF_DECIMALS"),"0"));
	//String fmt = "0";
		char [] c={'0','0','0','0'};
       StringBuffer strFormat = new StringBuffer();
	  /**
		* @Name - Priya
		* @Date - 02/02/2010
		* @Inc# - 15496 (SRR20056-CRF-0537.2)
		* @Desc - Modified by priya as if the value of 'Item Quantity' , 'Balance', 'Opening Balance' and Closing Balance' is equal to zero and no_of_decimals is 4 then it should be displayed as 0 only & not as '0.000' & so removed 'strFormat_zero' codings and made it to zero
		*/
	  String strFormat_zero = "0";
	
	if(no_of_decimals==0){
	strFormat.append("###,###");
	//strFormat_zero.append("0");
	}else 
		   {
         strFormat.append( "###,###.");
		 //strFormat_zero.append("0.");
           /* for(int i =0;i<no_of_decm;i++)
                       {
                        strFormat.append("0");
                           }*/
	   
	   strFormat.append(c,0,no_of_decimals);
	   //strFormat_zero.append(c,0,no_of_decimals);
	   }

	DecimalFormat dfTest = new DecimalFormat(strFormat.toString());
	/* Commented By rams
       Incident No : 18094
	   This Existing Commented Codes Adds Extra Decimals to the Existing Value 
	   Date 1/11/2010
	*/
	
	
	/*for(int i=0;i<no_of_decimals;i++){
		if(i==0)
		fmt+=".";
		fmt+="0";
		}*/

	
	
	String str_trn_code				=		bean.checkForNull(bean.getTrn_code(),"no_trn");
	String str_from					=		bean.getFrom();
	String str_to					=		bean.getTo();



	if(!str_from.equals(""))
	{
	bean.load_month_opening_qty();
	}
	if(!str_to.equals(""))
	{
	bean.load_month_closing_qty();
	}
		if(str_trn_code.equals("no_trn"))
			{
			String opening_bal=bean.checkForNull(bean.getMonth_opening_qty());
			if(opening_bal.equals(".00")){
			opening_bal="0.00";

			}
		%>
	<tr>
	<td colspan=3 class='ECMENUHIGHERLEVELCOLOR'></td>
	<td class='ECMENUHIGHERLEVELCOLOR'><font size=1><b><fmt:message key="Common.OpeningBalance.label" bundle="${common_labels}"/> :</font></td>
	<td class='ECMENUHIGHERLEVELCOLOR' style="TEXT-ALIGN:right" ><%=(Double.parseDouble(bean.checkForNull(bean.getMonth_opening_qty(),"0.0").replaceAll(",",""))==0.0)? strFormat_zero.toString():dfTest.format(Double.parseDouble(bean.checkForNull(bean.getMonth_opening_qty(),"0").replaceAll(",","")))%>&nbsp;</td>
	<td colspan=9 class='ECMENUHIGHERLEVELCOLOR'></td>
	</tr>
		<%
			}
		ArrayList records			=		new ArrayList();
		String stTEMP_BALANCE		=		"0";
		for(int recCount=2,k = 0; recCount<result.size(); recCount++,k++) {
		String className			=		(recCount % 2 == 0)?"QRYEVEN":"QRYODD";

		records						=		(ArrayList) result.get(recCount);
		String TRN_TYPE				=		CommonBean.checkForNull((String)records.get(0),"&nbsp;");
		String DOC_TYPE				=		CommonBean.checkForNull((String)records.get(1),"&nbsp;");
		String DOC_NO				=		CommonBean.checkForNull((String)records.get(2),"&nbsp;");
		String DOC_DATE				=		CommonBean.checkForNull((String)records.get(3),"&nbsp;");
		String ITEM_QTY				=		CommonBean.checkForNull((String)records.get(4),"&nbsp;");
		String EXPIRY_DATE			=		CommonBean.checkForNull((String)records.get(5),"&nbsp;");
		String OTHER_STORE_DESC		=		CommonBean.checkForNull((String)records.get(6),"&nbsp;");
		String BATCH_ID				=		CommonBean.checkForNull((String)records.get(7),"&nbsp;");
		String TRADE_ID				=		CommonBean.checkForNull((String)records.get(8),"&nbsp;");
		String BIN_LOCATION			=		CommonBean.checkForNull((String)records.get(9),"&nbsp;");
		String PO_NO				=		CommonBean.checkForNull((String)records.get(10),"&nbsp;");
		String SALE_TYPE			=		CommonBean.checkForNull((String)records.get(11),"&nbsp;");
		String SUPP_TYPE			=		CommonBean.checkForNull((String)records.get(12),"&nbsp;");
		String BALANCE				=		CommonBean.checkForNull((String)records.get(13),"&nbsp;");
        String stTempOpeningBal		=		CommonBean.checkForNull(bean.getMonth_opening_qty()) ; 
        stTempOpeningBal			=		stTempOpeningBal.equals("")?"0":stTempOpeningBal ;
       stTEMP_BALANCE 		=		String.valueOf(Double.parseDouble(bean.checkForNull(BALANCE,"0").replaceAll(",","")) + Double.parseDouble(stTempOpeningBal.replaceAll(",",""))) ;
	  // Added By Rams 1/19/2010 For the Decimal CRF 537.1 Begins
			/* @Name - Rams
		 * @Date - 1/19/2010
		 * @Inc# - 18094
		 * @Desc - For the Decimal related display if the Value is Less than Zero
		 */
		/*
	   String temp = dfTest.format(Double.parseDouble(bean.checkForNull(ITEM_QTY,"0").replaceAll(",","")));
						if(Double.parseDouble((temp.replaceAll(",","")))<1 && Double.parseDouble((temp.replaceAll(",","")))>0 )
			{
						temp = "0"+temp;
			}
			if(Double.parseDouble((temp.replaceAll(",","")))<0)
			{
			      
              if(temp.substring(0,temp.indexOf(".")).equals("-"))
				  temp ="-"+"0"+temp.substring(temp.indexOf("."),temp.length());
							
			} */
		/* @Name - Priya
		 * @Date - 22/03/2010
		 * @Inc# - 20186
		 * @Desc - As the above commented coding causes String Index out of bounds exception in some scenarios, It is done with common function as below.
		 */
			String temp = bean.setNumberFormat((bean.checkForNull(ITEM_QTY,"0").replaceAll(",","")),no_of_decimals);
	        DOC_DATE = com.ehis.util.DateUtils.convertDate(DOC_DATE,"DMY","en",locale);
	        EXPIRY_DATE = com.ehis.util.DateUtils.convertDate(EXPIRY_DATE,"DMY","en",locale);

%>
		<tr id='tr<%=k%>'onClick="changeRowColor(tr<%=k%>);">
		<td  class="<%=className%>" ><font size=1><%=TRN_TYPE%></font></td>
		<td  class="<%=className%>"  ><font size=1><%=DOC_TYPE%></font></td>
		<td  class="<%=className%>"  ><font size=1><%=DOC_NO%></font></td>
		<td  class="<%=className%>" ><font size=1><%=DOC_DATE%></font></td>
		<td  class="<%=className%>"   style="TEXT-ALIGN:right"><font size=1><%=(Double.parseDouble(bean.checkForNull(ITEM_QTY,"0").replaceAll(",",""))==0.0)? strFormat_zero.toString():temp%></font>&nbsp;</td>
		<td  class="<%=className%>"   style="TEXT-ALIGN:right"><font size=1><%=(Double.parseDouble(bean.checkForNull(stTEMP_BALANCE,"0").replaceAll(",",""))==0.0)? strFormat_zero.toString():dfTest.format(Double.parseDouble(bean.checkForNull(stTEMP_BALANCE,"0").replaceAll(",","")))%></font>&nbsp;</td>
		<td  class="<%=className%>"  ><font size=1><%=EXPIRY_DATE%></font></td>
		<td  class="<%=className%>"  ><font size=1><%=BATCH_ID%></font></td>
		<td  class="<%=className%>"  ><font size=1><%=PO_NO%></font></td>
		<td  class="<%=className%>" ><font size=1><%=SUPP_TYPE%></font></td>
		<td  class="<%=className%>"  ><font size=1><%=OTHER_STORE_DESC%></font></td>
		<td  class="<%=className%>"  ><font size=1><%=TRADE_ID%></font></td>
		<td  class="<%=className%>"  ><font size=1><%=BIN_LOCATION%></font></td>
		<td  class="<%=className%>"  ><font size=1><%=SALE_TYPE%></font></td>
		</tr>
		<%
		}
		if(str_trn_code.equals("no_trn"))
			{
		if (iIndexNext==-1) {

			

		%>
			<tr>
	<td colspan=3 class='ECMENUHIGHERLEVELCOLOR'></td>
	<td class='ECMENUHIGHERLEVELCOLOR'><font size=1><b><fmt:message key="eST.ClosingBalance.label" bundle="${st_labels}"/> :</font></td>
<!-- 	<td class='ECMENUHIGHERLEVELCOLOR'><%=bean.checkForZero(bean.getMonth_closing_qty())%>&nbsp;&nbsp;&nbsp;&nbsp;</td>
 -->	<td class='ECMENUHIGHERLEVELCOLOR' style="TEXT-ALIGN:right"><%=(Double.parseDouble(bean.checkForNull(stTEMP_BALANCE,"0").replaceAll(",",""))==0.0)? strFormat_zero.toString():dfTest.format(Double.parseDouble(bean.checkForNull(stTEMP_BALANCE,"0").replaceAll(",","")))%>&nbsp;</td>
	<td colspan=9 class='ECMENUHIGHERLEVELCOLOR'></td>
		</tr>
		<%
		}
			}
		%>
		</table>
		<%
		putObjectInBean(bean_id,bean,request);

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
		out.println(CommonBean.setForm(request,"../../eST/jsp/ItemMovementQueryResultDetail.jsp",searched));
		
	
		}catch(Exception e) {
			e.printStackTrace();
		out.print("Exception @ Result JSP :"+e.toString());
		}
	%>
</body>
</html>

