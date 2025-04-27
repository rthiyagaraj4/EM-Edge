<!DOCTYPE html>
<%@ page import=" eST.IssueBean,java.util.HashMap" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<title><fmt:message key="eST.StockLevel.label" bundle="${st_labels}"/></title>
	<head>
		<%
			request.setCharacterEncoding("UTF-8");
			String locale			=	 (String)session.getAttribute("LOCALE");
			String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
			<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<!-- <script language="javascript" src="../../eCommon/js/messages.js"></script> -->
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<!-- <script language="javascript" src="../../eST/js/StMessages.js"></script> -->
	<script language="javascript" src="../../eST/js/StCommon.js"></script>
	<script language="javascript" src="../../eST/js/StTransaction.js"></script>
	<script language="JavaScript" src="../../eST/js/StockTransfer.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<body>
<%
	String item_code		=	(String)request.getParameter("item_code");
	String item_desc		=	request.getParameter("item_desc");
	String fm_store_code	=	(String)request.getParameter("fm_store_code");
	String to_store_code	=	(String)request.getParameter("to_store_code");
	String iss_qty			=	(String)request.getParameter("iss_qty")==null?"0":(String)request.getParameter("iss_qty");
	double avail_stock			=	0;
	double avail_stock1		=	0;
	String trn_type			=	request.getParameter("trn_type")==null?"":(String)request.getParameter("trn_type");
	HashMap minMax			=	new HashMap();	
	HashMap minMax1			=	new HashMap();	
	IssueBean bean			=	(IssueBean) getBeanObject("issueBean","eST.IssueBean",request);  
	bean.setLanguageId(locale);
	String[] stParameters	= {item_code, fm_store_code, "0", "N", "", "N", to_store_code};
	String[] stParameters1	= {item_code, to_store_code, "0", "N", "", "N", fm_store_code};
	String[] alParameters	= {item_code, fm_store_code,locale};
	String[] alParameters1	= {item_code, to_store_code,locale};
	int no_of_decimals = 0;
	if((bean.getAllowDecimalsYN(item_code)).equals("Y")){
		no_of_decimals = bean.getNoOfDecimals();
	}
	try{
		HashMap hmStockAvailabilityStatus  = bean.getStockAvailabilityStatus(stParameters);
		HashMap hmStockAvailabilityStatus1 = bean.getStockAvailabilityStatus(stParameters1);
	try{
	
	    //Commented  by Rabbani #inc no :35661 (PMG2012-CRF-0012) on 21/11/2012
		minMax = (HashMap)bean.fetchRecord("SELECT MIN_STK_QTY, MAX_STK_QTY, REORDER_LEVEL, DEF_ISSUE_UOM,SHORT_DESC FROM ST_ITEM_STORE,AM_UOM_LANG_VW WHERE ITEM_CODE = ? AND STORE_CODE = ? AND  DEF_ISSUE_UOM = UOM_CODE  AND LANGUAGE_ID = ?",alParameters);
		minMax1 = (HashMap)bean.fetchRecord("SELECT MIN_STK_QTY, MAX_STK_QTY, REORDER_LEVEL, DEF_ISSUE_UOM,SHORT_DESC FROM ST_ITEM_STORE,AM_UOM_LANG_VW WHERE ITEM_CODE = ? AND STORE_CODE = ? AND  DEF_ISSUE_UOM = UOM_CODE  AND LANGUAGE_ID = ?",alParameters1);
		
		//Added  by Rabbani #inc no :35661 (PMG2012-CRF-0012) on 23/11/2012 Starts
		//minMax = (HashMap)bean.fetchRecord("SELECT st.min_stk_qty, st.max_stk_qty, st.reorder_level, st.def_issue_uom, am.short_desc ,(SELECT SHORT_DESC FROM AM_UOM_LANG_VW WHERE UOM_CODE=mm.pur_uom_code and language_id= mm.language_id)pur_uom_desc FROM st_item_store st, am_uom_lang_vw am,mm_item_lang_vw mm WHERE st.item_code = ? and  st.item_code = mm.item_code  AND store_code = ? AND st.def_issue_uom = am.uom_code AND am.language_id = ? and am.language_id = mm.language_id",alParameters);		
		//minMax1 = (HashMap)bean.fetchRecord("SELECT st.min_stk_qty, st.max_stk_qty, st.reorder_level, st.def_issue_uom, am.short_desc ,(SELECT SHORT_DESC FROM AM_UOM_LANG_VW WHERE UOM_CODE=mm.pur_uom_code and language_id= mm.language_id)pur_uom_desc FROM st_item_store st, am_uom_lang_vw am,mm_item_lang_vw mm WHERE st.item_code = ? and  st.item_code = mm.item_code  AND store_code = ? AND st.def_issue_uom = am.uom_code AND am.language_id = ? and am.language_id = mm.language_id",alParameters1);
		//ends
		
	}catch(Exception e){
		e.printStackTrace();
	}
	if(trn_type.equals("TFR")){
		avail_stock	=	(Double.parseDouble((String)hmStockAvailabilityStatus.get("available_stock"))+Double.parseDouble((String)hmStockAvailabilityStatus.get("expired_stock")))/(bean.getConvFactTemp(item_code,fm_store_code));
		avail_stock1	=	(Double.parseDouble((String)hmStockAvailabilityStatus1.get("available_stock"))+Double.parseDouble((String)hmStockAvailabilityStatus1.get("expired_stock")))/(bean.getConvFactTemp(item_code,to_store_code));
	}else{
		avail_stock	=	Double.parseDouble((String)hmStockAvailabilityStatus.get("available_stock"))/(bean.getConvFactTemp(item_code,fm_store_code));
		avail_stock1	=	Double.parseDouble((String)hmStockAvailabilityStatus1.get("available_stock"))/(bean.getConvFactTemp(item_code,to_store_code));
	}
	if(iss_qty.equals("")){
		iss_qty = "0";
	}
	avail_stock = avail_stock + Double.parseDouble(iss_qty);
	%>
		<table border="1" cellspacing="0" width="100%">
		<tr>
				<td class="label"><B><fmt:message key="Common.item.label" bundle="${common_labels}"/>:&nbsp;&nbsp;&nbsp;</B></td>
				<td class="label" colspan = 7><%=item_desc%></td>
			</tr>
			<!--	
	* @Name - Priya
	* @Date - 19/02/2010
	* @Inc# - IN019466
	* @Desc - To align the headers in center . 					
	-->
			<tr>
				<td class="COLUMNHEADER" style="TEXT-ALIGN:center"><b><fmt:message key="Common.Store.label" bundle="${common_labels}"/></b></td>
				<!--Added by Rabbani/Ganga for  #inc no :35661 (PMG2012-CRF-0012) on 21/11/2012 
				<td class="COLUMNHEADER" style="TEXT-ALIGN:center"><b><fmt:message key="Common.PurchaseUOM.label" bundle="${common_labels}"/></b></td>-->
				<td class="COLUMNHEADER" style="TEXT-ALIGN:center"><b><fmt:message key="Common.StockUOM.label" bundle="${common_labels}"/></b></td>
				<td class="COLUMNHEADER" style="TEXT-ALIGN:center"><b><fmt:message key="eST.QuantityOnHand.label" bundle="${st_labels}"/></b></td>
				<td class="COLUMNHEADER" style="TEXT-ALIGN:center"><b><fmt:message key="eST.AvailableStock.label" bundle="${st_labels}"/></b></td>
				<td class="COLUMNHEADER" style="TEXT-ALIGN:center"><b><fmt:message key="Common.Minimum.label" bundle="${common_labels}"/></b></td>
				<td class="COLUMNHEADER" style="TEXT-ALIGN:center"><b><fmt:message key="Common.maximum.label" bundle="${common_labels}"/></b></td>
				<td class="COLUMNHEADER" style="TEXT-ALIGN:center"><b><fmt:message key="eST.Reorder.label" bundle="${st_labels}"/></b></td>
				
			</tr>
			<!-- 					
						* @Name - Priya
						* @Date - 19/02/2010
						* @Inc# - IN019466
						* @Desc - To right align Quantity on hand, AvailableStock, MIN_STK_QTY, MAX_STK_QTY, REORDER_LEVEL .				
					-->
			<tr>
				<!--<td class="QRYEVEN"><%=(String)bean.getStore_desc(fm_store_code)%></td>-->
				<!--Added by Rabbani/Ganga for #inc no :35661 (PMG2012-CRF-0012) on 21/11/2012 -->
				<td  class="QRYEVEN"><A HREF="#" onClick="callBatchSearchScreen ('<%=fm_store_code%>','<%=item_code%>');"><%=(String)bean.getStore_desc(fm_store_code)%></A></td>
				<!--<td class="QRYEVEN" style="TEXT-ALIGN:left"><%=bean.checkForNull((String)minMax.get("PUR_UOM_DESC"),"&nbsp;")%>&nbsp;</td>
				added ended-->
				<td class="QRYEVEN" style="TEXT-ALIGN:left"><%=bean.checkForNull((String)minMax.get("SHORT_DESC"))%></td>
				<td class="QRYEVEN" style="TEXT-ALIGN:right"><%=bean.setNumber((String)hmStockAvailabilityStatus1.get("to_qty_on_hand"),no_of_decimals)%>&nbsp;</td>
				<td class="QRYEVEN" style="TEXT-ALIGN:right"><%=bean.setNumber(""+avail_stock,no_of_decimals)%>&nbsp;</td>
				<td class="QRYEVEN" style="TEXT-ALIGN:right"><%=bean.checkForNull((String)minMax.get("MIN_STK_QTY"),"&nbsp;")%>&nbsp;</td>
				<td class="QRYEVEN" style="TEXT-ALIGN:right"><%=bean.checkForNull((String)minMax.get("MAX_STK_QTY"),"&nbsp;")%>&nbsp;</td>
				<td class="QRYEVEN" style="TEXT-ALIGN:right"><%=bean.checkForNull((String)minMax.get("REORDER_LEVEL"),"&nbsp;")%>&nbsp;</td>
			</tr>
			<tr>
				<!--<td class="QRYODD"><%=(String)bean.getStore_desc(to_store_code)%></td>-->
				<!--Added  by Rabbani/Ganga for #inc no :35661 (PMG2012-CRF-0012) on 21/11/2012 -->
				<td  class="QRYEVEN"><A HREF="#" onClick="callBatchSearchScreen ('<%=to_store_code%>','<%=item_code%>');"><%=(String)bean.getStore_desc(to_store_code)%></A></td>
				<!--<td class="QRYODD" style="TEXT-ALIGN:left"><%=bean.checkForNull((String)minMax1.get("PUR_UOM_DESC"),"&nbsp;")%>&nbsp;</td>
				<!--added ended-->
				<td class="QRYODD" style="TEXT-ALIGN:left"><%=bean.checkForNull((String)minMax1.get("SHORT_DESC"))%></td>
				<td class="QRYODD" style="TEXT-ALIGN:right"><%=bean.setNumber((String)hmStockAvailabilityStatus.get("to_qty_on_hand"),no_of_decimals)%>&nbsp;</td>
				<td class="QRYODD" style="TEXT-ALIGN:right"><%=bean.setNumber(""+avail_stock1,no_of_decimals)%>&nbsp;</td>
				<td class="QRYODD" style="TEXT-ALIGN:right"><%=bean.checkForNull((String)minMax1.get("MIN_STK_QTY"),"&nbsp;")%>&nbsp;</td>
				<td class="QRYODD" style="TEXT-ALIGN:right"><%=bean.checkForNull((String)minMax1.get("MAX_STK_QTY"),"&nbsp;")%>&nbsp;</td>
				<td class="QRYODD" style="TEXT-ALIGN:right"><%=bean.checkForNull((String)minMax1.get("REORDER_LEVEL"),"&nbsp;")%>&nbsp;</td>
			</tr>
			<tr>
				<td colspan="8">&nbsp;</td>
			</tr>
		</table>
	<%}catch(Exception e){
			e.printStackTrace();
			%>
			<script>alert(getMessage("ITEM_STORE_NOT_FOUND","ST"));window.close();</script>
		<%}
	%>
</body>
</html>

